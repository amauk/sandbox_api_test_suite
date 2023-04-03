package nz.co.assurity.api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import nz.co.assurity.api.functions.CategoriesAPI;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * GetCategoriesTest Test cases of validating GET categories endpoint.
 * Test for positive and negative scenarios can be included here
 * @author    Amali Kariyawasam
 */
public class GetCategoriesTest {

    CategoriesAPI categoriesAPI;
    SoftAssert softAssert;
    Response response;
    @BeforeClass
    public void runBeforeClass() {
        categoriesAPI = new CategoriesAPI();
        softAssert = new SoftAssert();
        response = categoriesAPI.getCategories("6327", Boolean.FALSE);
    }

    @Test
    public void verifyGetCategoriesResponseWhenCatalogueIsFalse(){
        JsonPath jsonObj = response.jsonPath();
        softAssert.assertTrue(jsonObj.get("Name").equals("Carbon credits"), "Invalid Name returned in response");
        softAssert.assertEquals(jsonObj.get("CanRelist"), Boolean.TRUE, "Invalid CanRelist returned in response");

        int count = jsonObj.getList("Promotions").size();

        for (int i=0; i<count; i++){
            if (jsonObj.get("Promotions[" + i + "].Name").toString().equals("Gallery")){
                softAssert.assertTrue(jsonObj.get("Promotions[" + i + "].Description").toString().contains("Good position in category"), "Invalid Description returned in response");
                break;
            }
        }
        softAssert.assertAll();
    }

}
