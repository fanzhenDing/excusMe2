package com.example.fanzhending.excusme;

import com.amazonaws.auth.policy.conditions.BooleanCondition;
import com.amazonaws.mobileconnectors.lambdainvoker.LambdaFunction;
public interface LambdaInterface {

    /**
     * Invoke the Lambda function "AndroidBackendLambdaFunction".
     * The function name is the method name.
     */
    @LambdaFunction
    Boolean PutScheduledCall(LambdaRequest request);

}