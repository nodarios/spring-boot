package pak.controllers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import pak.datajpa.entity.MyEntity;

import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

//@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT/*, properties = {"spring.h2.console.enabled=true", "spring.h2.console.path=/h2"}*/)
@Sql(scripts = {"/data-plus.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Slf4j
public class MyControllerDbIT {

    @LocalServerPort
    private int port;

    @Value("${server.port}")
    private int serverPort;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/mcdb/entity");
    }

    @Test
    public void testGetEntities() throws Exception {
        log.info("port {}", port);
        log.info("serverPort {}", serverPort);

        //ParameterizedTypeReference<List<MyEntity>> responseType =
        //        new ParameterizedTypeReference<List<MyEntity>>() {
        //        };
        //ResponseEntity<List<MyEntity>> response = template.exchange(
        //        base.toString()/* + "/account/{account}?name={name}"*/,
        //        HttpMethod.GET,
        //        null,
        //        responseType/*, "my-account", "my-name"*/
        //);
        //assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        //assertThat(response.getBody().size(), equalTo(7));

        ResponseEntity<MyEntity[]> response = template.getForEntity(base.toString(), MyEntity[].class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody().length, equalTo(7));
    }

}
