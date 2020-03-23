package com.schoolonline.app.user;

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

    private final String validTeacherJsonString = "{"
            + "\"firstName\":\"Mario\","
            + "\"lastName\":\"Doe\","
            + "\"email\":\"mario.doe@example.com\","
            + "\"password\":\"qwerty123\"}";

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DirtiesContext
    public void shouldAddStudentAndReturn201WhenSendingPostRequest() throws Exception {
        // when
        mockMvc.perform(post("/teachers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(validTeacherJsonString))

        // then
        .andExpect(status().isCreated())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.firstName", is("Mario")))
        .andExpect(jsonPath("$.lastName", is("Doe")));
    }
}