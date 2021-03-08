package org.interlogica.json.response;

import java.io.Serializable;
import java.util.Objects;

import javax.ws.rs.core.Response;

import org.interlogica.dto.ValidationResultDTO;

public class SingleTestResponse implements Serializable, CommonResponse {

	private static final long serialVersionUID = 8511795406536304819L;
	private Response.Status status;
	private ValidationResultDTO result;

	public SingleTestResponse(Response.Status status) {
		this.status = status;
	}

	public SingleTestResponse(Response.Status status, ValidationResultDTO result) {
		this.status = status;
		this.result = result;
	}

	@Override
	public Response.Status getStatus() {
		return status;
	}

	@Override
	public void setStatus(Response.Status status) {
		this.status = status;
	}

	public ValidationResultDTO getResult() {
		return result;
	}

	public void setResult(ValidationResultDTO result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "SingleTestResponse [status=" + status + ", result=" + result + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(result, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SingleTestResponse other = (SingleTestResponse) obj;
		return Objects.equals(result, other.result) && status == other.status;
	}

}
