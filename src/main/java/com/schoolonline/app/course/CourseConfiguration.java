package com.schoolonline.app.course;

import com.schoolonline.app.common.utils.Validator;
import com.schoolonline.app.user.UserFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CourseConfiguration {

    @Bean
    CourseFacade courseFacade(UserFacade userFacade, CourseRepository courseRepository) {
        CourseValidator courseValidator = new CourseValidator(new Validator(), userFacade);
        CourseFactory courseFactory = new CourseFactory(courseValidator, courseRepository);
        CourseService courseService = new CourseService(courseFactory, courseRepository);
        return new CourseFacade(courseService);
    }
}
