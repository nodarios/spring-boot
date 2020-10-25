package pak;

import com.swagger.client.codegen.rest.api.MyControllerGreetingApi;
import com.swagger.client.codegen.rest.invoker.ApiClient;
import lombok.Getter;

@Getter
public class ApiManager {

    private final MyControllerGreetingApi myControllerGreetingApi;

    private ApiManager(String apiUrl, AuthMethod authMethod) {
        ApiClient apiClient;
        if (authMethod == AuthMethod.NONE)
            apiClient = new ApiClient().setBasePath(apiUrl);
        else
            apiClient = new ApiClientAuth().setBasePath(apiUrl);
        myControllerGreetingApi = new MyControllerGreetingApi(apiClient);
    }

    @Getter
    private static String apiUrl;
    @Getter
    private static AuthMethod authMethod;
    @Getter
    private static String user;
    @Getter
    private static String pass;
    private static ApiManager apiManager;
    private static boolean initialized = false;

    public static ApiManager getInstance(String apiUrl, AuthMethod authMethod, String user, String pass) {
        if (!ApiManager.initialized) {
            ApiManager.apiUrl = apiUrl;
            ApiManager.authMethod = authMethod;
            ApiManager.user = user;
            ApiManager.pass = pass;
            ApiManager.apiManager = new ApiManager(apiUrl, authMethod);
            ApiManager.initialized = true;
        }
        return apiManager;
    }

}
