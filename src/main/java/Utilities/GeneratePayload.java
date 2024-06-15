package Utilities;

import org.json.JSONObject;

public class GeneratePayload {

    JSONObject jsonObject = null;

    public JSONObject createJsonObject(String key, String value){
        if(jsonObject == null){
            jsonObject = new JSONObject();
        }
        jsonObject.put(key,value);
        return jsonObject;
    }

    public JSONObject createJsonObject(String key, String value, JSONObject jsonObject){
        if(jsonObject == null){
            jsonObject = new JSONObject();
        }
        jsonObject.put(key,value);
        return jsonObject;
    }

}
