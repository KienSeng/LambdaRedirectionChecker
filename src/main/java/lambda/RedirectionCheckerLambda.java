package lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

import java.util.LinkedHashMap;

/**
 * Created by Kien Seng on 7/10/2017.
 */
public class RedirectionCheckerLambda implements RequestHandler<String, LinkedHashMap> {
    @Override
    public LinkedHashMap handleRequest(String input, Context context) {
        String jsonMap = new Gson().toJson(input);
//        context.getLogger().log());

//        JsonObject json = new JsonConverter().convertStringToJson(jsonMap);
//
//        String url = new JsonReader().getString(json, "url");
//        RedirectionCheckerCore redirection = new RedirectionCheckerCore(new UrlConnector(url), "Redirection of " + url);
//
//        try{
//            String destUrl = new JsonReader().getString(json, "destUrl");
//            redirection.setRedirectedLocation(destUrl);
//        }catch(Exception e){
//            context.getLogger().log("Parameter 'destUrl' not found, skip verification for redirected URL");
//        }
//
//        redirection.startRedirectionCheck();
//        return redirection.getRedirectionResult();
        return null;
    }
}
