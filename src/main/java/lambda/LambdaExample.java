package lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * Created by Kien Seng on 7/10/2017.
 */
public class LambdaExample implements RequestHandler {
    @Override
    public Object handleRequest(Object input, Context context) {
        context.getLogger().log("HELOOOO WORLDDDD!!!!!!!!!!!!");
        return null;
    }
}
