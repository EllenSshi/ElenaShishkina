package hw8.service;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CommonService {

    private RequestSpecification REQUEST_SPECIFICATION;

    public CommonService() throws IOException {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(new PropertyService().getDomain())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public Response getWithParams(String uri, Map<String, Object> params) {
        RequestSpecification specification = given(REQUEST_SPECIFICATION);
        for (Map.Entry<String, Object> param : params.entrySet())
            specification.param(param.getKey(), param.getValue());
        return specification.post(uri);
    }
}
