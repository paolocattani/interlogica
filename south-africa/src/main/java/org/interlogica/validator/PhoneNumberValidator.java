package org.interlogica.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.interlogica.dto.RemediationDTO;
import org.interlogica.dto.ValidationResultDTO;

public class PhoneNumberValidator {

	public static ValidationResultDTO validate(String phoneNumber) {
		ValidationResultDTO result = new ValidationResultDTO();
		if (StringUtils.isBlank(phoneNumber)) {
			result.setIsValid(Boolean.FALSE);
			result.setError("Phone number is empty");
		}

		String sanitizeString = "";
		List<RemediationDTO> remediations = new ArrayList<>();
		// Sanitize string
		if (result.getIsValid()) {
			sanitizeString = phoneNumber.replaceAll("[^0-9]", "");
			if (sanitizeString.length() != phoneNumber.length()) {
				remediations.add(new RemediationDTO(phoneNumber, sanitizeString, "Removed invalid characters"));
			}
		}

		if (result.getIsValid() && sanitizeString.length() != 11 && sanitizeString.length() != 9) {
			result.setIsValid(Boolean.FALSE);
			result.setError("Lenght should be 11 or 9 ( without prefix )");
		}

		if (result.getIsValid() && sanitizeString.length() == 9) {
			result.setIsValid(Boolean.FALSE);
			result.setIsModified(Boolean.TRUE);
			remediations.add(new RemediationDTO(sanitizeString, "27" + sanitizeString, "Added prefix"));
		}

		// Set remediations
		result.setRemediations(remediations);
		return result;
	}

}
