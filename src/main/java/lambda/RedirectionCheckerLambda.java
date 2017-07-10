package lambda;

import Models.Factory.UrlConnector.UrlConnector;
import Models.JsonProcessor.JsonConverter;
import Models.JsonProcessor.JsonReader;
import Models.RedirectionChecker.RedirectionCheckerCore;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.LinkedHashMap;

/**
 * Created by Kien Seng on 7/10/2017.
 */
public class RedirectionCheckerLambda implements RequestHandler<Object, LinkedHashMap> {
    @Override
    public LinkedHashMap handleRequest(Object input, Context context) {
        String jsonMap = new Gson().toJson(input);
        context.getLogger().log(jsonMap);

        JsonObject json = new JsonConverter().convertStringToJson(jsonMap);

        String url = new JsonReader().getString(json, "start_url");
        String destUrl = new JsonReader().getString(json, "destination_url");

        RedirectionCheckerCore redirection = new RedirectionCheckerCore(new UrlConnector(url), "Redirection of " + url);
        redirection.setRedirectedLocation(destUrl);
        redirection.startRedirectionCheck();
        return redirection.getRedirectionResult();
    }
}
