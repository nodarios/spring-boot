package pak;

import com.squareup.okhttp.Call;
import com.swagger.client.codegen.rest.invoker.ApiClient;
import com.swagger.client.codegen.rest.invoker.ApiException;
import com.swagger.client.codegen.rest.invoker.Pair;
import com.swagger.client.codegen.rest.invoker.ProgressRequestBody;
import com.swagger.client.codegen.rest.invoker.auth.Authentication;

import java.util.List;
import java.util.Map;

public class ApiClientAuth extends ApiClient {

    @Override
    public Call buildCall(String path, String method, List<Pair> queryParams, List<Pair> collectionQueryParams, Object body, Map<String, String> headerParams, Map<String, Object> formParams, String[] authNames, ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Authentication authentication = AuthManager.generateAuthentication();
        authentication.applyToParams(queryParams, headerParams);
        return super.buildCall(path, method, queryParams, collectionQueryParams, body, headerParams, formParams, authNames, progressRequestListener);
    }

}
