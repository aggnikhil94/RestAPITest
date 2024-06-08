import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class FirstAPITest {


    String baseURL = "https://reqres.in";

    public void getUserTest(){
       Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when().get(baseURL + "/api/users/2");

       response.then().log().all()
                       .assertThat().statusCode(200)
               .body("data.id", Matchers.equalTo(2))
               .body("data.first_name", Matchers.equalTo("Janet"));
    }

    public static void main(String[] args) {
        FirstAPITest api = new FirstAPITest();
        api.getUserTest();
    }
}
