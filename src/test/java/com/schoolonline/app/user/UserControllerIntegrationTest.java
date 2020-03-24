package com.schoolonline.app.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.schoolonline.app.user.dto.NewUserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DirtiesContext
    public void shouldAddStudentAndReturn201WhenPostRequest() throws Exception {
        // given
        NewUserDTO newUserDTO = new NewUserDTO();
        newUserDTO.setFirstName("Mario");
        newUserDTO.setLastName("Doe");
        newUserDTO.setEmail("mario.doe@example.com");
        newUserDTO.setPassword("qwerty123");
        String studentJson = objectMapper.writeValueAsString(newUserDTO);

        // when
        mockMvc.perform(post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson))

        // then
        .andExpect(status().isCreated())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.firstName", is("Mario")))
        .andExpect(jsonPath("$.lastName", is("Doe")));
    }

    @Test
    public void shouldNotAddStudentAndReturn400WhenPostRequestWithInvalidPassword() throws Exception {
        // given
        NewUserDTO newUserDTO = new NewUserDTO();
        newUserDTO.setFirstName("Mario");
        newUserDTO.setLastName("Doe");
        newUserDTO.setEmail("mario.doe@example.com");
        newUserDTO.setPassword("qwerty");
        String studentJson = objectMapper.writeValueAsString(newUserDTO);

        // when
        mockMvc.perform(post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson))

        // then
        .andExpect(status().isBadRequest())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.message", is("Invalid password")));
    }

    @Test
    @DirtiesContext
    public void shouldNotAddStudentAndReturn400WhenPostRequestWithDuplicatedEmail() throws Exception {
        // given
        NewUserDTO newUserDTO = new NewUserDTO();
        newUserDTO.setFirstName("Mario");
        newUserDTO.setLastName("Doe");
        newUserDTO.setEmail("mario.doe@example.com");
        newUserDTO.setPassword("qwerty123");
        String studentJson = objectMapper.writeValueAsString(newUserDTO);
        mockMvc.perform(post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson));

        // when
        mockMvc.perform(post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson))

        // then
        .andExpect(status().isBadRequest())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.message", is("Duplicated email")));
    }

    @Test
    @DirtiesContext
    public void shouldAddTeacherAndReturn201WhenPostRequest() throws Exception {
        // given
        NewUserDTO newUserDTO = new NewUserDTO();
        newUserDTO.setFirstName("Mario");
        newUserDTO.setLastName("Doe");
        newUserDTO.setEmail("mario.doe@example.com");
        newUserDTO.setPassword("qwerty123");
        String teacherJson = objectMapper.writeValueAsString(newUserDTO);

        // when
        mockMvc.perform(post("/teachers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(teacherJson))

        // then
        .andExpect(status().isCreated())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.firstName", is("Mario")))
        .andExpect(jsonPath("$.lastName", is("Doe")));
    }

    @Test
    public void shouldNotAddTeacherAndReturn400WhenPostRequestWithMissingFirstName() throws Exception {
        // given
        NewUserDTO newUserDTO = new NewUserDTO();
        newUserDTO.setLastName("Doe");
        newUserDTO.setEmail("mario.doe@example.com");
        newUserDTO.setPassword("qwerty");
        String teacherJson = objectMapper.writeValueAsString(newUserDTO);

        // when
        mockMvc.perform(post("/teachers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(teacherJson))

        // then
        .andExpect(status().isBadRequest())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.message", is("Missing first name")));
    }

    @Test
    @DirtiesContext
    public void shouldRemoveStudentAndReturn200WhenDeleteRequest() throws Exception {
        // given
        NewUserDTO newUserDTO = new NewUserDTO();
        newUserDTO.setFirstName("Mario");
        newUserDTO.setLastName("Doe");
        newUserDTO.setEmail("mario.doe@example.com");
        newUserDTO.setPassword("qwerty123");
        String studentJson = objectMapper.writeValueAsString(newUserDTO);
        mockMvc.perform(post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson));

        // when
        mockMvc.perform(delete("/students/{studentId}", 1))

        // then
        .andExpect(status().isOk());
    }

    @Test
    @DirtiesContext
    public void shouldRemoveTeacherAndReturn200WhenDeleteRequest() throws Exception {
        // given
        NewUserDTO newUserDTO = new NewUserDTO();
        newUserDTO.setFirstName("Mario");
        newUserDTO.setLastName("Doe");
        newUserDTO.setEmail("mario.doe@example.com");
        newUserDTO.setPassword("qwerty123");
        String teacherJson = objectMapper.writeValueAsString(newUserDTO);
        mockMvc.perform(post("/teachers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(teacherJson));

        // when
        mockMvc.perform(delete("/teachers/{teacherId}", 1))

        // then
        .andExpect(status().isOk());
    }
}