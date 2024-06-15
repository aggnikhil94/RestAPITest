package UserListAPIs;

import Framework.Constants;
import UserLoginTokenGenerator.UserLogin;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class FirstAPITest {
    @Test (dependsOnMethods = {"userLogin"})
    public void getSingleUser(){
        Response response = given().contentType(ContentType.JSON)
                .headers("Authorisation", UserLogin.loginToken)
                .when().get(Constants.baseURL + Constants.user_endpoint + "2");
        System.out.println(response.asString());
    }
}
