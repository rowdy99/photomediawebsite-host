package com.subham.validator;

import com.subham.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<ValidPassword, Object> {

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        UserDto dto = (UserDto) obj;
        String password = dto.getPassword();
        Pattern specailCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
        Pattern lowerCasePatten = Pattern.compile("[a-z ]");
        Pattern digitCasePatten = Pattern.compile("[0-9 ]");

        if (password.length() < 6) {
            context.buildConstraintViolationWithTemplate("Password lenght must have alleast 6 character.")
                    .addPropertyNode("password").addConstraintViolation();
            return false;
        } else if (!specailCharPatten.matcher(password).find()) {
            context.buildConstraintViolationWithTemplate("Password must have atleast one special character.")
                    .addPropertyNode("password").addConstraintViolation();
            return false;
        } else if (!UpperCasePatten.matcher(password).find()) {
            context.buildConstraintViolationWithTemplate("Password must have atleast one uppercase character.")
                    .addPropertyNode("password").addConstraintViolation();
            return false;
        } else if (!lowerCasePatten.matcher(password).find()) {
            context.buildConstraintViolationWithTemplate("Password must have atleast one lowercase character.")
                    .addPropertyNode("password").addConstraintViolation();
            return false;
        } else if (!digitCasePatten.matcher(password).find()) {
            context.buildConstraintViolationWithTemplate("Password must have atleast one digit character.")
                    .addPropertyNode("password").addConstraintViolation();
            return false;
        }

        return true;
    }

}
