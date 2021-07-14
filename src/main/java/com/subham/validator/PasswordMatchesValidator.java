package com.subham.validator;

import com.subham.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        // TODO Auto-generated method stub
        UserDto dto = (UserDto) value;


        if (dto.getPassword().equals(dto.getMatchingPassword())) {
            return true;
        } else {
            context.buildConstraintViolationWithTemplate("Passwords don't match. custom")
                    .addPropertyNode("matchingPassword")
                    .addConstraintViolation();
            return false;
        }
    }

}
