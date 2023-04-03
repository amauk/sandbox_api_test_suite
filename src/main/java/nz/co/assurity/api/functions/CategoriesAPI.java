package nz.co.assurity.api.functions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import nz.co.assurity.api.utils.APIFunctionBase;

import java.util.HashMap;
import java.util.Map;

import static nz.co.assurity.api.common.Attributes.CATALOGUE;
import static nz.co.assurity.api.common.Routes.BASE_URL;
import static nz.co.assurity.api.common.Routes.GET_CATEGORIES;

/**
 * CategoriesAPI functional implementation of Categories related endpoints.
 * Implementation related to CRUD operations can be included here.
 * @author    Amali Kariyawasam
 */
public class CategoriesAPI extends APIFunctionBase {

    public Response getCategories(String categoryId, Boolean considerCatalogue){

        String path = String.format(GET_CATEGORIES, categoryId);
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put(CATALOGUE, considerCatalogue.toString());


        RequestSpecification reqSpec = getRequestSpec(BASE_URL, path, getHeaders(), null, queryParams);
        Response getResponse = RestAssured.given().spec(reqSpec).get();

        return getResponse;
    }
}
