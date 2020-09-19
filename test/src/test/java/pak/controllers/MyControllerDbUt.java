package pak.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pak.datajpa.entity.MyEntity;
import pak.datajpa.service.MyService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@Ignore
//@Profile({"UT"})
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {MyControllerDb.class})
public class MyControllerDbUt {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MyService svc;

    @Before
    public void setUp() {
        MyEntity myEntity = new MyEntity(1L, "a", "desc", "owner");
        List<MyEntity> myEntityList = Arrays.asList(myEntity);
        Mockito.when(svc.findAll()).thenReturn(myEntityList);
        //given(svc.findAll()).willReturn(myEntityList);
    }

    @Test
    public void testGetEntities() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/mcdb/entity")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", equalTo("a")));
    }

}
