package Models.LambdaInputProcessor;

import com.google.gson.JsonObject;

/**
 * Created by Kien Seng on 7/11/2017.
 */
public class ApiGatewayRequestProcessor {
    JsonObject json;

    public ApiGatewayRequestProcessor(JsonObject json){
        this.json = json;
    }

    public JsonObject getBody(){
        return json.get("body-json").getAsJsonObject();
    }

    public String getQueryParameters(String key){
        return json.get("params").getAsJsonObject()
                .get("querystring").getAsJsonObject()
                .get(key).getAsString();
    }

    public String getPathParameters(String key){
        return json.get("params").getAsJsonObject()
                .get("path").getAsJsonObject()
                .get(key).getAsString();
    }

    public String getHeadersParameters(String key){
        return json.get("params").getAsJsonObject()
                .get("header").getAsJsonObject()
                .get(key).getAsString();
    }

    public String getRequestMethod(){
        return json.get("context").getAsJsonObject()
                .get("http-method").getAsString();
    }
}
