package Models.JsonProcessor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.LinkedHashMap;

/**
 * Created by Kien Seng on 7/10/2017.
 */
public class JsonConverter {
    public JsonObject convertStringToJson(String jsonString){
        return new Gson().fromJson(jsonString, JsonObject.class).getAsJsonObject();
    }
}
