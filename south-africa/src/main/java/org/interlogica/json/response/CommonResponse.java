package org.interlogica.json.response;

import javax.ws.rs.core.Response;

public interface CommonResponse {

	/**
	 * HTTP status
	 */
	public Response.Status getStatus();

	public void setStatus(Response.Status status);

}
