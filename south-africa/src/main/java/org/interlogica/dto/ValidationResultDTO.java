package org.interlogica.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ValidationResultDTO implements Serializable {

	private static final long serialVersionUID = 2662760881581605298L;
	/**
	 * If the phone number is valid or not. If not then take a look at
	 * {@code isValid} and {@code remediation}
	 */
	private Boolean isValid;
	/**
	 * Error message
	 */
	private String error;
	/**
	 * If the phone has been modified to attempt automatic correction.
	 */
	private Boolean isModified;
	/**
	 * Action taken to correct the phone number
	 */
	private List<RemediationDTO> remediations;

	public ValidationResultDTO() {
		this.isValid = Boolean.TRUE;
		this.isModified = Boolean.FALSE;
		this.error = "";

	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Boolean getIsModified() {
		return isModified;
	}

	public void setIsModified(Boolean isModified) {
		this.isModified = isModified;
	}

	public List<RemediationDTO> getRemediations() {
		return remediations;
	}

	public void setRemediations(List<RemediationDTO> remediations) {
		this.remediations = remediations;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "ValidationResultDTO [isValid=" + isValid + ", error=" + error + ", isModified=" + isModified
				+ ", remediations="
				+ (remediations != null ? remediations.subList(0, Math.min(remediations.size(), maxLen)) : null) + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(error, isModified, isValid, remediations);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValidationResultDTO other = (ValidationResultDTO) obj;
		return Objects.equals(error, other.error) && Objects.equals(isModified, other.isModified)
				&& Objects.equals(isValid, other.isValid) && Objects.equals(remediations, other.remediations);
	}

}
