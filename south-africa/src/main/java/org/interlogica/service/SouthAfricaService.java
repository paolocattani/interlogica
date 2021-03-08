package org.interlogica.service;

import javax.ws.rs.core.Response;

import org.interlogica.json.request.FileCheckRequest;
import org.interlogica.json.response.FileTestResponse;
import org.interlogica.json.response.SingleTestResponse;

public interface SouthAfricaService {

	public SingleTestResponse singleCheck(String phoneNumber);

	public FileTestResponse fileCheck(FileCheckRequest request);

	public Response sayHi(String name);

}
