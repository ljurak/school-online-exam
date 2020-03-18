package com.schoolonline.app.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class UserConfiguration {

    @Bean
    UserFacade userFacade(UserRepository userRepository, StudentRepository studentRepository) {
        UserValidator userValidator = new UserValidator(userRepository);
        UserFactory userFactory = new UserFactory(userValidator, userRepository, studentRepository);
        return new UserFacade(userFactory);
    }
}
