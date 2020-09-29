package pak;

import com.swagger.client.codegen.rest.api.MyControllerGreetingApi;
import com.swagger.client.codegen.rest.invoker.ApiException;
import com.swagger.client.codegen.rest.model.Greeting;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiManagerIT {

    private static MyControllerGreetingApi myControllerGreetingApi;

    @BeforeAll
    public static void setup() {
        myControllerGreetingApi = ApiManager.getMyControllerGreetingApi("http://localhost:8080");
    }

    //@Disabled("reason")
    @Test
    @DisplayName("Test Greeting")
    void testGreeting() throws ApiException {
        Greeting greeting = myControllerGreetingApi.greetingUsingGET("Dear");
        assertEquals(greeting.getContent(), "Hello, Dear!");
    }

}
