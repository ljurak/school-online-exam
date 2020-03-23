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
    public void shouldAddStudentAndReturn201WhenSendingPostRequest() throws Exception {
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
}