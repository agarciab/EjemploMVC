package com.vn.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vn.dto.BuildingDTO;

@Component
public class ModificacioBuildingValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return BuildingDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
	}
}
