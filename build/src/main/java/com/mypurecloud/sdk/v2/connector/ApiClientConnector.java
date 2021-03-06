package com.mypurecloud.sdk.v2.guest.connector;

import com.mypurecloud.sdk.v2.guest.AsyncApiCallback;

import java.io.IOException;
import java.util.concurrent.Future;

public interface ApiClientConnector extends AutoCloseable {
    ApiClientConnectorResponse invoke(ApiClientConnectorRequest request) throws IOException;
    Future<ApiClientConnectorResponse> invokeAsync(ApiClientConnectorRequest request, AsyncApiCallback<ApiClientConnectorResponse> callback);
}
