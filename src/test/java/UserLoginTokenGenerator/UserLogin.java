package UserLoginTokenGenerator;

import Framework.Constants;
import JsonHelper.userlogin.UserLoginPayload;
import Utilities.TokenBinder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static Framework.Constants.login_endpoint;
import static io.restassured.RestAssured.given;

public class UserLogin {
    public static String loginToken = null;
    @Test
    public void userLogin(){
        Response response =  given().contentType(ContentType.JSON).and()
                .body(UserLoginPayload.createUserLoginPayload().toString())
                .when().post(Constants.baseURL + login_endpoint);

        response.then().log().all()
                .assertThat().statusCode(200)
                        .body("token", Matchers.notNullValue());
        TokenBinder tokenBinder = new TokenBinder();
        loginToken = tokenBinder.getToken(response.asString());
    }

}
