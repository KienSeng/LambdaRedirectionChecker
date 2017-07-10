package Models.LambdaInputProcessor;

import Models.JsonProcessor.JsonConverter;
import com.google.gson.JsonObject;

/**
 * Created by Kien Seng on 7/11/2017.
 */
public class ApiGatewayInputProcessor {
    JsonObject json;

    public ApiGatewayInputProcessor(String json){
        this.json = new JsonConverter().convertStringToJson(json);
    }

    public JsonObject getBody(){
        return json.get("body").getAsJsonObject();
    }

    public String getQueryParameters(String key, String returnType){
        return json.get("queryStringParameters").getAsJsonObject().get(key).getAsString();
    }

    public String getPathParameters(String key, String returnType){
        return json.get("pathParameters").getAsJsonObject().get(key).getAsString();
    }

    public String getHeadersParameters(String key, String returnType){
        return json.get("headers").getAsJsonObject().get(key).getAsString();
    }

    public String getRequestMethod(){
        return json.get("httpMethod").getAsString();
    }
}
