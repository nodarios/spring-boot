package pak.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@Ignore
//@Profile({"UT"})
@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//or
@WebMvcTest(controllers = MyController.class)
public class MyControllerUt {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/mc/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }

}
