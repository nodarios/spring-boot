package pak;

import com.squareup.okhttp.Call;
import com.swagger.client.codegen.rest.invoker.ApiClient;
import com.swagger.client.codegen.rest.invoker.ApiException;
import com.swagger.client.codegen.rest.invoker.Pair;
import com.swagger.client.codegen.rest.invoker.ProgressRequestBody;
import com.swagger.client.codegen.rest.invoker.auth.HttpBasicAuth;

import java.util.List;
import java.util.Map;

public class AuthApiClient extends ApiClient {

    @Override
    public Call buildCall(String path, String method, List<Pair> queryParams, List<Pair> collectionQueryParams, Object body, Map<String, String> headerParams, Map<String, Object> formParams, String[] authNames, ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // TODO get credentials from env

        //OAuth authentication = new OAuth();
        //authentication.setAccessToken("TOKEN");

        HttpBasicAuth authentication = new HttpBasicAuth();
        authentication.setUsername("foo");
        authentication.setPassword("foo");

        authentication.applyToParams(queryParams, headerParams);

        return super.buildCall(path, method, queryParams, collectionQueryParams, body, headerParams, formParams, authNames, progressRequestListener);
    }
}
