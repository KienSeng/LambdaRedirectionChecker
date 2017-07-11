package Models.JsonProcessor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.LinkedHashMap;

/**
 * Created by Kien Seng on 7/10/2017.
 */
public class JsonConverter {
    String jsonString;

    public JsonConverter(Object input){
        jsonString = new Gson().toJson(input);
    }

    public JsonObject convertToJsonObject(){
        return new Gson().fromJson(jsonString, JsonObject.class).getAsJsonObject();
    }
}
