package com.allexample.projects;

import com.allexample.projects.web.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
public class HelloTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }
    @Test
    public void getHello() throws Exception{
        String responseString = mockMvc.perform(MockMvcRequestBuilders.post("/login").param("name","")
                .param("age","1").param("pass","11")
        ).andReturn().getResponse().getContentAsString();
        System.out.println("result : "+responseString);
    }

}
