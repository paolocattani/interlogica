package org.interlogica.json.response;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import javax.ws.rs.core.Response;

import org.interlogica.dto.ValidationResultDTO;

public class FileTestResponse implements Serializable, CommonResponse {

	private static final long serialVersionUID = 3268546730097184957L;
	private Response.Status status;
	/**
	 * Test result by phone number
	 */
	private Map<String, ValidationResultDTO> result;

	public FileTestResponse(Response.Status status) {
		this.status = status;
	}

	@Override
	public Response.Status getStatus() {
		return status;
	}

	@Override
	public void setStatus(Response.Status status) {
		this.status = status;
	}

	public Map<String, ValidationResultDTO> getResult() {
		return result;
	}

	public void setResult(Map<String, ValidationResultDTO> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "FileTestResponse [status=" + status + ", result="
				+ (result != null ? toString(result.entrySet(), maxLen) : null) + "]";
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
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
		FileTestResponse other = (FileTestResponse) obj;
		return Objects.equals(result, other.result) && status == other.status;
	}

}
