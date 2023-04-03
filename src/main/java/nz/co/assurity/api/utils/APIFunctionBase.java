package nz.co.assurity.api.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

/**
 * APIFunctionBase functional implementation common API operations.
 * @author    Amali Kariyawasam
 */
public class APIFunctionBase {

    public RequestSpecification getRequestSpec(String url, String requestPath, Map<String, String> headers, String body, Map<String, ?> queryParameters) {
        RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder();
        reqSpecBuilder.setBaseUri(url);
        reqSpecBuilder.setBasePath(requestPath);

        if (headers != null) {
            reqSpecBuilder.addHeaders(headers);
        }

        if (body != null && body.length() > 0) {
            reqSpecBuilder.setBody(body);
        }

        if (queryParameters != null && !queryParameters.isEmpty()) {
            reqSpecBuilder.addQueryParams(queryParameters);
        }

        return reqSpecBuilder.build();
    }

    public Map<String, String> getHeaders(){
        Map<String,String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");

        return  requestHeaders;
    }

}
