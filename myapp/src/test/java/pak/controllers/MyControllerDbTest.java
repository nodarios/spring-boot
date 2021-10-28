//package pak.controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.BDDMockito;
//import org.mockito.Mockito;
//import org.mockito.invocation.InvocationOnMock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import pak.entity.MyEntity;
//import pak.service.MyService;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.hasSize;
//import static org.mockito.AdditionalAnswers.returnsFirstArg;
//import static org.mockito.ArgumentMatchers.any;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
////@Ignore
//@Slf4j
//@RunWith(SpringRunner.class)
////--
//@SpringBootTest
//@AutoConfigureMockMvc
////or
////@WebMvcTest(controllers = {MyControllerDb.class})
////--
////@TestPropertySource(properties = {"jwt.token.expiration.hours=10"})
////@Import({TestSecurityConfigurer.class})
//public class MyControllerDbTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private MyService svc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private MyEntity myEntity = new MyEntity(1L, "a", "desc", "owner");
//
//    private List<MyEntity> myEntityList = Arrays.asList(myEntity);
//
//    @Before
//    public void setUp() throws Exception {
//        // arrange
//
//        Mockito.when(svc.findAll()).thenReturn(myEntityList);
//        //BDDMockito.given(svc.findAll()).willReturn(myEntityList);
//
//        Mockito.when(svc.save(any(MyEntity.class))).thenReturn(myEntity);
//        //Mockito.when(svc.save(any(MyEntity.class)))
//        //        .then(returnsFirstArg());
//        //Mockito.when(svc.save(any(MyEntity.class)))
//        //        .then((InvocationOnMock invocation) -> invocation.getArgument(0));
//    }
//
//    //@WithMockUser(value = "mockUser")
//    @Test
//    public void testGetEntities() throws Exception {
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .get("/mcdb/entity")
//                .accept(MediaType.APPLICATION_JSON);
//        // act and assert
//        MvcResult mvcResult = mvc
//                .perform(requestBuilder)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].name", equalTo("a")))
//                //.andExpect(content().string(equalTo("")))
//                .andReturn();
//        log.info("response {}", mvcResult.getResponse().getContentAsString());
//        // assert
//        Mockito.verify(svc/*, Mockito.never()*/).findAll();
//    }
//
//    //@WithMockUser(value = "mockUser")
//    @Test
//    public void testAddEntity() throws Exception {
//        MyEntity myEntity = new MyEntity();
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .post("/mcdb/entity/add")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(myEntity));
//        // act and assert
//        MvcResult mvcResult = mvc
//                .perform(requestBuilder)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name", equalTo("a")))
//                //.andExpect(content().string(equalTo("")))
//                .andReturn();
//        log.info("response {}", mvcResult.getResponse().getContentAsString());
//        // assert
//        Mockito.verify(svc/*, Mockito.never()*/).save(myEntity);
//    }
//
//}
