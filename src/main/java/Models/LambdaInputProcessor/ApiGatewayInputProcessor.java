package Models.LambdaInputProcessor;

import Models.JsonProcessor.JsonConverter;
import com.google.gson.JsonObject;

/**
 * Created by Kien Seng on 7/11/2017.
 */
public class ApiGatewayInputProcessor {
    JsonObject json;

    public ApiGatewayInputProcessor(JsonObject json){
        this.json = json;
    }

    public JsonObject getBody(){
        return json.get("body").getAsJsonObject();
    }

    public String getQueryParameters(String key){
//        return json.get("queryStringParameters").getAsJsonObject().get(key).getAsString();
        return json.get("params").getAsJsonObject()
                .get("querystring").getAsJsonObject()
                .get(key).getAsString();
    }

    public String getPathParameters(String key){
        return json.get("pathParameters").getAsJsonObject().get(key).getAsString();
    }

    public String getHeadersParameters(String key){
        return json.get("headers").getAsJsonObject().get(key).getAsString();
    }

    public String getRequestMethod(){
        return json.get("httpMethod").getAsString();
    }
}
