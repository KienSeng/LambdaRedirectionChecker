package Models.JsonFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
