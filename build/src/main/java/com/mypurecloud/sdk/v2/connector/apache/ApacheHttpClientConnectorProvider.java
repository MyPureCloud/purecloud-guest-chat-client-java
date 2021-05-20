package com.mypurecloud.sdk.v2.guest.connector.apache;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.mypurecloud.sdk.v2.guest.DetailLevel;
import com.mypurecloud.sdk.v2.guest.connector.ApiClientConnector;
import com.mypurecloud.sdk.v2.guest.connector.ApiClientConnectorProperties;
import com.mypurecloud.sdk.v2.guest.connector.ApiClientConnectorProperty;
import com.mypurecloud.sdk.v2.guest.connector.ApiClientConnectorProvider;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApacheHttpClientConnectorProvider implements ApiClientConnectorProvider {
    @Override
    public ApiClientConnector create(ApiClientConnectorProperties properties) {
        RequestConfig.Builder requestBuilder = RequestConfig.custom();

        Integer connectionTimeout = properties.getProperty(ApiClientConnectorProperty.CONNECTION_TIMEOUT, Integer.class, null);
        if (connectionTimeout != null && connectionTimeout > 0) {
            requestBuilder = requestBuilder.setConnectTimeout(connectionTimeout)
                    .setSocketTimeout(connectionTimeout)
                    .setConnectionRequestTimeout(connectionTimeout);
        }

        Proxy proxy = properties.getProperty(ApiClientConnectorProperty.PROXY, Proxy.class, null);
        if (proxy != null) {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetAddress = (InetSocketAddress)address;
                HttpHost proxyHost = new HttpHost(inetAddress.getAddress(), inetAddress.getPort());
                requestBuilder.setProxy(proxyHost);
            }
        }

        DetailLevel detailLevel = properties.getProperty(ApiClientConnectorProperty.DETAIL_LEVEL, DetailLevel.class, DetailLevel.MINIMAL);
        SLF4JInterceptor defaultInterceptor = new SLF4JInterceptor(detailLevel);
        HttpRequestInterceptor requestInterceptor = properties.getProperty(ApiClientConnectorProperty.HTTP_REQUEST_INTERCEPTOR,
            HttpRequestInterceptor.class,
            defaultInterceptor);
        HttpResponseInterceptor responseInterceptor = properties.getProperty(ApiClientConnectorProperty.HTTP_RESPONSE_INTERCEPTOR,
            HttpResponseInterceptor.class,
            defaultInterceptor);

        CloseableHttpClient client = HttpClients.custom()
                .setDefaultRequestConfig(requestBuilder.build())
                .addInterceptorFirst(requestInterceptor)
                .addInterceptorLast(responseInterceptor)
                .build();

        ExecutorService executorService = properties.getProperty(ApiClientConnectorProperty.ASYNC_EXECUTOR_SERVICE, ExecutorService.class, null);
        if (executorService == null) {
            executorService = Executors.newCachedThreadPool(new ThreadFactoryBuilder().setNameFormat("purecloud-sdk-%d").build());
        }

        return new ApacheHttpClientConnector(client, executorService);
    }
}
