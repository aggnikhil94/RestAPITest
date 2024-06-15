package JsonHelper.userlogin;


import Utilities.GeneratePayload;
import org.json.JSONObject;

public class UserLoginPayload {

    public static JSONObject createUserLoginPayload(){
        GeneratePayload generatePayload = new GeneratePayload();
        JSONObject jo = generatePayload.createJsonObject("email", "eve.holt@reqres.in");
        jo = generatePayload.createJsonObject("password","cityslicka",jo);
        System.out.println(jo);
        return jo;
    }
}
