package com.schoolonline.app.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class UserConfiguration {

    @Bean
    UserFacade userFacade(UserRepository userRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        UserValidator userValidator = new UserValidator(userRepository);
        UserFactory userFactory = new UserFactory(userValidator, userRepository, studentRepository, teacherRepository);
        return new UserFacade(userFactory);
    }
}
