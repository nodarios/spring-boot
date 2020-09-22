package pak.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pak.datajpa.entity.MyEntity;
import pak.datajpa.service.MyService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@Ignore
@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//or
@WebMvcTest(controllers = {MyControllerDb.class})
public class MyControllerDbTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MyService svc;

    @Autowired
    private ObjectMapper objectMapper;

    private MyEntity myEntity = new MyEntity(1L, "a", "desc", "owner");

    private List<MyEntity> myEntityList = Arrays.asList(myEntity);

    @Before
    public void setUp() throws Exception {
        Mockito.when(svc.findAll()).thenReturn(myEntityList);
        //given(svc.findAll()).willReturn(myEntityList);

        Mockito.when(svc.save(any(MyEntity.class))).thenReturn(myEntity);
    }

    @Test
    public void testGetEntities() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/mcdb/entity")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mvc
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", equalTo("a")))
                //.andExpect(content().string(equalTo("")))
                .andReturn();
        logger.info("response {}", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testAddEntity() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/mcdb/entity/add")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new MyEntity()));
        MvcResult mvcResult = mvc
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("a")))
                //.andExpect(content().string(equalTo("")))
                .andReturn();
        logger.info("response {}", mvcResult.getResponse().getContentAsString());
    }

}
