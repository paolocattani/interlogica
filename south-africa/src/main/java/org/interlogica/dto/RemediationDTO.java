package org.interlogica.dto;

import java.io.Serializable;
import java.util.Objects;

public class RemediationDTO implements Serializable {

	private static final long serialVersionUID = -3583053781445425437L;
	/**
	 * The number before the remediation
	 */
	private String oldNumber;
	/**
	 * The number after the remediation
	 */
	private String newNumber;
	/**
	 * Action taken to normalize phone number
	 */
	private String action;

	public RemediationDTO(String oldNumber, String newNumber, String action) {
		this.oldNumber = oldNumber;
		this.newNumber = newNumber;
		this.action = action;
	}

	public String getOldNumber() {
		return oldNumber;
	}

	public void setOldNumber(String oldNumber) {
		this.oldNumber = oldNumber;
	}

	public String getNewNumber() {
		return newNumber;
	}

	public void setNewNumber(String newNumber) {
		this.newNumber = newNumber;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "Remediation [oldNumber=" + oldNumber + ", newNumber=" + newNumber + ", action=" + action + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(action, newNumber, oldNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RemediationDTO other = (RemediationDTO) obj;
		return Objects.equals(action, other.action) && Objects.equals(newNumber, other.newNumber)
				&& Objects.equals(oldNumber, other.oldNumber);
	}

}
