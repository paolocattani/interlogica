package org.interlogica;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.Collections;

import javax.inject.Inject;
import javax.ws.rs.core.Response.Status;

import org.interlogica.controller.SouthAfricaAPI;
import org.interlogica.dto.RemediationDTO;
import org.interlogica.dto.ValidationResultDTO;
import org.interlogica.json.response.SingleTestResponse;
import org.interlogica.service.implementation.SouthAfricaServiceImplementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestHTTPEndpoint(SouthAfricaAPI.class)
public class SouthAfricaTest {

	@Inject
	SouthAfricaServiceImplementation service;

	@Test
	public void testWelcomeEndpoint_Isolation() {
		Assertions.assertEquals("Welcome Interlogica", service.sayHiString("Interlogica"));
	}

	@Test
	public void testWelcomeEndpoint_API() {
		given().queryParam("name", "Interlogica").when().get("/welcome").then().statusCode(200)
				.body(is("Welcome Interlogica"));
	}

	@Test
	public void testSingleCheckEndpoint_Fail() {
		ValidationResultDTO validation = new ValidationResultDTO();
		validation.setError("Lenght should be 11 or 9 ( without prefix )");
		validation.setIsValid(Boolean.FALSE);
		validation.setIsModified(Boolean.FALSE);
		validation.setRemediations(new ArrayList<>());
		SingleTestResponse expected = new SingleTestResponse(Status.OK, validation);

		SingleTestResponse response = given().pathParam("phoneNumber", "1234156").when().get("/check/{phoneNumber}")
				.then().statusCode(200).extract().as(SingleTestResponse.class);
		Assertions.assertEquals(response, expected);
	}

	@Test
	public void testSingleCheckEndpoint_Success() {
		ValidationResultDTO validation = new ValidationResultDTO();
		validation.setError("");
		validation.setIsValid(Boolean.TRUE);
		validation.setIsModified(Boolean.FALSE);
		validation.setRemediations(new ArrayList<>());
		SingleTestResponse expected = new SingleTestResponse(Status.OK, validation);

		SingleTestResponse response = given().pathParam("phoneNumber", "12345678912").when().get("/check/{phoneNumber}")
				.then().statusCode(200).extract().as(SingleTestResponse.class);
		Assertions.assertEquals(response, expected);
	}

	@Test
	public void testSingleCheckEndpoint_Remediation() {
		ValidationResultDTO validation = new ValidationResultDTO();
		validation.setError("");
		validation.setIsValid(Boolean.FALSE);
		validation.setIsModified(Boolean.TRUE);
		validation.setRemediations(
				Collections.singletonList(new RemediationDTO("123456789", "27123456789", "Added prefix")));
		SingleTestResponse expected = new SingleTestResponse(Status.OK, validation);
		SingleTestResponse response = given().pathParam("phoneNumber", "123456789").when().get("/check/{phoneNumber}")
				.then().statusCode(200).extract().as(SingleTestResponse.class);
		Assertions.assertEquals(response, expected);
	}

}