package com.thoughtworks.capability.gtb.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@SpringBootTest
@AutoConfigureMockMvc
public class EventControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private ResultActions result;

    @AfterEach
    void tearDown() throws UnsupportedEncodingException {
        if (result != null) {
            String contentAsString = result.andReturn()
                    .getResponse()
                    .getContentAsString(StandardCharsets.UTF_8);
            System.out.println(contentAsString);
        }
    }

    @Test
    public void should_get_event_by_id() throws Exception {
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("http://localhost:8080/events/1")
                .accept("application/json;charset=UTF-8");
        result = mockMvc.perform(req)
        .andExpect(MockMvcResultMatchers.jsonPath("$.type", Matchers.is("D")))
        .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("下载文件")));
    }
}
