package com.vn.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vn.dto.BuildingDTO;

@Component
public class AltaBuildingValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return BuildingDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "buildingId", "id.empty");
		ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
		
		BuildingDTO dto = (BuildingDTO) target;
		if (dto.getBuildingId() < 1) {
			errors.rejectValue("buildingId", "negativeValue");
		}
	}

}
