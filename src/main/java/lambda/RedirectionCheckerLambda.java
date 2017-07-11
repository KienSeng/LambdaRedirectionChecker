package lambda;

import Models.Factory.UrlConnector.UrlConnector;
import Models.JsonProcessor.JsonConverter;
import Models.LambdaInputProcessor.ApiGatewayInputProcessor;
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
        JsonObject json = new JsonConverter(input).convertToJsonObject();
        context.getLogger().log("\n\nInput Payload:\n"
                + json.toString() + "\n"
                + "=================================================\n\n");

        ApiGatewayInputProcessor processedOutput = new ApiGatewayInputProcessor(json);

        String url = processedOutput.getQueryParameters("url");
        context.getLogger().log("URL: " + url);

        RedirectionCheckerCore redirection = new RedirectionCheckerCore(new UrlConnector(url), "Redirection of " + url);

        try{
            String destUrl = processedOutput.getQueryParameters("destUrl");
            context.getLogger().log("Redirected URL: " + url);
            redirection.setRedirectedLocation(destUrl);
        }catch(Exception e){
            context.getLogger().log("Parameter 'destUrl' not found, skip verification for redirected URL");
        }

        redirection.startRedirectionCheck();
        return redirection.getRedirectionResult();
    }
}
