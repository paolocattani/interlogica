package org.interlogica.service.implementation;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import org.interlogica.dao.SouthAfricaDAO;
import org.interlogica.dto.ValidationResultDTO;
import org.interlogica.entity.SouthAfrica;
import org.interlogica.json.request.FileCheckRequest;
import org.interlogica.json.response.FileTestResponse;
import org.interlogica.json.response.SingleTestResponse;
import org.interlogica.service.SouthAfricaService;
import org.interlogica.validator.PhoneNumberValidator;

@ApplicationScoped
public class SouthAfricaServiceImplementation implements SouthAfricaService {

	private SouthAfricaDAO southAfricaDAO;

	@Inject
	SouthAfricaServiceImplementation(SouthAfricaDAO southAfricaDAO) {
		this.southAfricaDAO = southAfricaDAO;
	}

	public String sayHiString(String name) {
		return "Welcome " + name;
	}

	@Override
	public Response sayHi(String name) {
		return Response.status(Response.Status.OK).entity("Welcome " + name).build();
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public SingleTestResponse singleCheck(String phoneNumber) {
		// Request received by the server
		SingleTestResponse response = new SingleTestResponse(Response.Status.OK);
		// Validate number
		response.setResult(PhoneNumberValidator.validate(phoneNumber));
		return response;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public FileTestResponse fileCheck(FileCheckRequest request) {
		// Request received by the server
		FileTestResponse response = new FileTestResponse(Response.Status.OK);
		// Transform byte[] to something readable
		byte[] binary = Base64.getDecoder().decode(request.getFileContent());
		BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(binary)));

		// Split line using separator
		Function<String, String[]> getSplittedLine = (line) -> line.split(request.getColumnSeparator());

		// Function to validate lines in file
		Predicate<String> filter = (line) -> getSplittedLine.apply(line).length >= request.getKeyColumnNumber();

		// Get key and value for result
		Function<String, String> getKey = (line) -> getSplittedLine.apply(line)[request.getKeyColumnNumber()];
		Function<String, ValidationResultDTO> getValue = (line) -> PhoneNumberValidator.validate(getKey.apply(line));

		// Get results
		Map<String, ValidationResultDTO> result = reader.lines()
				// Skip header if is present
				.skip(request.getHasHeader() != null && request.getHasHeader() == Boolean.TRUE ? 1 : 0)
				// apply filter
				.filter(filter)
				// collect results
				.collect(Collectors.toMap(getKey, getValue));

		response.setResult(result);
		SouthAfrica record = new SouthAfrica(null, binary, request.getFileContentType(), request.getFileName(),
				request.getColumnSeparator(), request.getHasHeader(), request.getKeyColumnNumber(), result.toString());

		// Save result, and request
		southAfricaDAO.save(record);
		return response;
	}

}
