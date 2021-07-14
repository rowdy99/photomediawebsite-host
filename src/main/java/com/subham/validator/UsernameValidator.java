package com.subham.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<ValidUsername, String> {

    @Override
    public void initialize(ValidUsername constraintAnnotation) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        // TODO Auto-generated method stub
        return (username != null) && username.matches("[A-Za-z0-9_]+");
    }

}
