package UserLoginTokenGenerator;

import Framework.Constants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserLogin {


    private String login_endpoint = "/api/login";
    public static String loginToken = null;

    String userLoginPayload = "{\n" +
            "    \"email\": \"eve.holt@reqres.in\",\n" +
            "    \"password\": \"cityslicka\"\n" +
            "}";

    @Test
    public void userLogin(){
        Response response =  given().contentType(ContentType.JSON).and()
                .body(userLoginPayload)
                .when().post(Constants.baseURL + login_endpoint);

        response.then().log().all()
                .assertThat().statusCode(200)
                        .body("token", Matchers.notNullValue());
        loginToken = response.asString().split(":")[1];
    }

}
