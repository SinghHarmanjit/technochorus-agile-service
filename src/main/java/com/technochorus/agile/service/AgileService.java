package com.technochorus.agile.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.technochorus.agile.service.entity.ApiGatewayResponse;

import java.util.HashMap;
import java.util.Map;

public class AgileService implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {
    private Map<String, String> headers = new HashMap<>();
    // NOTE: CORS support only * or a specific origin
    private String[] ALLOWED_ORIGINS = new String[] {
            "https://technochorus.com",
            "https://www.technochorus.com"};

    public AgileService() {
        headers.put("Content-Type", "application/json");
        headers.put("Access-Control-Allow-Credentials", "true");
        headers.put("Access-Control-Allow-Origin", ALLOWED_ORIGINS[0]);
    }

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
        String body = System.getenv("TASKS");
        return ApiGatewayResponse.builder()
                .setStatusCode(200)
                .setBody(body)
                .setHeaders(headers)
                .setBase64Encoded(false)
                .build();
    }
}
