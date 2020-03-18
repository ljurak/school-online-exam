package com.schoolonline.app.common.utils;

import java.util.regex.Pattern;

public class Validator {

    private Pattern emailPattern =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);

    public boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public boolean isBlank(String s) {
        return s == null || s.isBlank();
    }

    public boolean hasMinLength(String s, int min) {
        return s.length() >= min;
    }

    public boolean hasMaxLength(String s, int max) {
        return s.length() <= max;
    }

    public boolean hasLengthBeetwen(String s, int min, int max) {
        return hasMinLength(s, min) && hasMaxLength(s, max);
    }

    public boolean isValidEmail(String email) {
        return emailPattern.matcher(email).matches();
    }
}
