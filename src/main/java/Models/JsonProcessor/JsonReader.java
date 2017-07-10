package Models.JsonProcessor;

import com.google.gson.JsonObject;

/**
 * Created by Kien Seng on 7/10/2017.
 */
public class JsonReader {
    public String getString(JsonObject json, String key){
        return json.get(key).getAsString();
    }

    public Object getObject(JsonObject json, String key){
        return json.get(key).getAsJsonObject();
    }

    public Integer getInteger(JsonObject json, String key){
        return json.get(key).getAsInt();
    }

    public Boolean getBoolean(JsonObject json, String key){
        return json.get(key).getAsBoolean();
    }

    public Double getDouble(JsonObject json, String key){
        return json.get(key).getAsDouble();
    }
}
