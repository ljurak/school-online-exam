package com.schoolonline.app.user;

import com.schoolonline.app.common.utils.Validator;
import com.schoolonline.app.user.dto.NewUserDTO;
import com.schoolonline.app.user.error.UserError;
import io.vavr.control.Either;

class UserValidator {

    private Validator validator;

    private UserRepository userRepository;

    UserValidator(UserRepository userRepository) {
        this.validator = new Validator();
        this.userRepository = userRepository;
    }

    Either<UserError, NewUserDTO> validateUser(NewUserDTO newUserDTO) {
        if (validator.isBlank(newUserDTO.getFirstName())) {
            return Either.left(UserError.MISSING_FIRSTNAME);
        } else if (!validator.hasMaxLength(newUserDTO.getFirstName(), 30)) {
            return Either.left(UserError.INVALID_FIRSTNAME);
        } else if (validator.isBlank(newUserDTO.getLastName())) {
            return Either.left(UserError.MISSING_LASTNAME);
        } else if (!validator.hasMaxLength(newUserDTO.getLastName(), 30)) {
            return Either.left(UserError.INVALID_LASTNAME);
        } else if (validator.isBlank(newUserDTO.getEmail())) {
            return Either.left(UserError.MISSING_EMAIL);
        } else if (!validator.isValidEmail(newUserDTO.getEmail())) {
            return Either.left(UserError.INVALID_EMAIL);
        } else if (validator.isBlank(newUserDTO.getPassword())) {
            return Either.left(UserError.MISSING_PASSWORD);
        } else if (!validator.hasLengthBeetwen(newUserDTO.getPassword(), 8, 20)) {
            return Either.left(UserError.INVALID_PASSWORD);
        }

        if (userRepository.existsByEmail(newUserDTO.getEmail())) {
            return Either.left(UserError.DUPLICATED_EMAIL);
        }

        return Either.right(newUserDTO);
    }
}
