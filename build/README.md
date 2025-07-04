# Guest Chat Client - Java

## Resources

[![platform-client-v2](https://maven-badges.herokuapp.com/maven-central/com.mypurecloud/purecloud-guest-chat-client/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.mypurecloud/purecloud-guest-chat-client)
[![Release Notes Badge](https://developer-content.genesys.cloud/images/sdk-release-notes.png)](https://github.com/MyPureCloud/purecloud-guest-chat-client-java/blob/master/releaseNotes.md)

* **Documentation** https://mypurecloud.github.io/purecloud-guest-chat-client-java/
* **Source** https://github.com/MyPureCloud/purecloud-guest-chat-client-java
* **Guest chat documentation** https://developer.genesys.cloud/commdigital/digital/webchat/guestchat

Documentation version: com.mypurecloud.sdk.v2.guest:purecloud-guest-chat-client:15.4.0

## Install Using maven

Install the library from maven via the package [com.mypurecloud:purecloud-guest-chat-client](https://mvnrepository.com/artifact/com.mypurecloud/purecloud-guest-chat-client)

## Android Support

The SDK may be used in Android. This requires Java 8 support in Android Studio (2.4 Preview 6 or later). For more information, see the Android Developers Blog: [Java 8 Language Features Support Update](https://android-developers.googleblog.com/2017/04/java-8-language-features-support-update.html)

## Using the SDK

### Referencing the Package

Import the necessary packages:

```java
import com.mypurecloud.sdk.v2.ApiException;
import com.mypurecloud.sdk.v2.guest.ApiClient;
import com.mypurecloud.sdk.v2.guest.ApiResponse;
import com.mypurecloud.sdk.v2.guest.Configuration;
import com.mypurecloud.sdk.v2.guest.api.WebChatApi;
import com.mypurecloud.sdk.v2.guest.PureCloudRegionHosts;
import com.mypurecloud.sdk.v2.guest.model.*;
```

### Creating a chat

The guest chat APIs do not require standard Genesys Cloud authentication, but do require a JWT token for all API calls other than creating a new chat.  

```java
String organizationId = "12b1a3fe-7a80-4b50-45fs-df88c0f9efad";
String deploymentId = "a3e316a7-ec8b-4fe9-5a49-dded9dcc097e";
String queueName = "Chat Queue";
String guestName = "Chat Guest";
String guestImage = "http://yoursite.com/path/to/guest/image.png";

// Create ApiClient instance
PureCloudRegionHosts region = PureCloudRegionHosts.us_east_1;
ApiClient apiClient = ApiClient.Builder.standard()
  .withBasePath(region)
  .build();

// Use the ApiClient instance
Configuration.setDefaultApiClient(apiClient);

// Instantiate API
webChatApi = new WebChatApi();

// Build create chat request
CreateWebChatConversationRequest request = new CreateWebChatConversationRequest();
request.setOrganizationId(organizationId);
request.setDeploymentId(deploymentId);

WebChatRoutingTarget target = new WebChatRoutingTarget();
target.setTargetType(WebChatRoutingTarget.TargetTypeEnum.QUEUE);
target.setTargetAddress(queueName);
request.setRoutingTarget(target);

WebChatMemberInfo memberInfo = new WebChatMemberInfo();
memberInfo.setDisplayName(guestName);
memberInfo.setProfileImageUrl(guestImage);
request.setMemberInfo(info);

// Create new chat
ApiResponse<CreateWebChatConversationResponse> response = 
  webChatApi.postWebchatGuestConversationsWithHttpInfo(request);

// Abort if unsuccessful
if (response.getException() != null) {
  throw response.getException();
}

// Store chat info in local var for easy access
chatInfo = response.getBody();
System.out.println("Conversation ID: " + chatInfo.getId());


// Set JWT in SDK
apiClient.setJwt(chatInfo.getJwt());

// Create websocket instance
System.out.println("Connecting to websocket...");
WebSocket ws = new WebSocketFactory().createSocket(chatInfo.getEventStreamUri());

// Handle incoming messages
ws.addListener(new WebSocketAdapter() {
  @Override
  public void onTextMessage(WebSocket websocket, String rawMessage) {
    // Handle message here
  }
});

// Connect to host
ws.connect();

// At this point, the chat has been created and will be routed per the target's configuration
```

### Building an ApiClient Instance

`ApiClient` implements a builder pattern to construct new instances:

```java
// Create ApiClient instance
PureCloudRegionHosts region = PureCloudRegionHosts.us_east_1;
ApiClient apiClient = ApiClient.Builder.standard()
    .withBasePath(region)
    .build();

// Use the ApiClient instance
Configuration.setDefaultApiClient(apiClient);

// Create API instances and make authenticated API requests
WebChatApi webChatApi = new WebChatApi();
CreateWebChatConversationResponse chat = webChatApi.postWebchatGuestConversations(body);
```

#### Setting the environment

Provide the full base url if not using `https://api.mypurecloud.com`:

```java
PureCloudRegionHosts region = PureCloudRegionHosts.ap_southeast_2;
.withBasePath(region)
```

#### Setting the HTTP connector

The SDK supports the following HTTP connectors:

* Apache (_default_, synchronous), use `ApacheHttpClientConnectorProvider`
* Ning (async), use `AsyncHttpClientConnectorProvider`
* OkHTTP (synchronous, recommended for Android), use `OkHttpClientConnectorProvider`

Specify the connector in the builder:

```java
.withProperty(ApiClientConnectorProperty.CONNECTOR_PROVIDER, new OkHttpClientConnectorProvider())
```

### SDK Logging

SDK users can choose between SL4J or our logging implementation, which makes use of STDOUT and an optional log file.

#### SL4J

Logging can be provided through SL4J, which uses HTTP request and response interceptors for requests when using the Apache connector. SL4J also logs exceptions from the Apache connector.  
To use SL4J, include a relevant SL4J library in the dependencies and SL4J configuration file.  

To provide a custom request interceptor, provide an object implementing `org.apache.http.HttpRequestInterceptor` to the following APIClient builder method:
```java
        .withHttpRequestInterceptor(requestInterceptor)
```

Use the following method to provide a custom response interceptor implementing `org.apache.http.HttpResponseInterceptor`:
```java
        .withHttpResponseInterceptor(responseInterceptor)
```

#### Standard Logging Implementation

Logging of API requests and responses can be controlled programmatically by creating an instance of `ApiClient.LoggingConfiguration` and passing it to the `withLoggingConfiguration` builder method of the `APIClient`.

`LogLevel` values:
1. trace (HTTP Method, URL, Request Body, HTTP Status Code, Request Headers, Response Headers)
2. debug (HTTP Method, URL, Request Body, HTTP Status Code, Request Headers)
3. error (HTTP Method, URL, Request Body, Response Body, HTTP Status Code, Request Headers, Response Headers)
4. none - default

`LogFormat` values:
1. JSON
2. Text - default

By default, the request and response bodies are not logged because these can contain PII. Be mindful of this data if choosing to log it.  
To log to a file, provide a value to `setLogFilePath`. SDK users are responsible for the rotation of the log file.

Example logging configuration:

```java
ApiClient.LoggingConfiguration loggingConfiguration = new ApiClient.LoggingConfiguration();
loggingConfiguration.setLogLevel("trace");
loggingConfiguration.setLogFormat("json");
loggingConfiguration.setLogRequestBody(true);
loggingConfiguration.setLogResponseBody(true);
loggingConfiguration.setLogToConsole(true);
loggingConfiguration.setLogFilePath("/var/log/javasdk.log");

ApiClient apiClient = ApiClient.Builder.standard()
                        .withLoggingConfiguration(loggingConfiguration)
                        .build();
```

#### Configuration file

A number of configuration parameters can be applied using a configuration file. There are two sources for this file:

1. The SDK will look for `%HOMEDRIVE%%HOMEPATH%\.genesyscloudjava-guest\config` on Windows, or `$HOME/.genesyscloudjava-guest/config` on Unix.
2. Provide a valid file path to the ApiClient

Example setting the configuration file:

```java
        .withConfigFilePath("/path/to/config")
```

The SDK will take an event-driven approach to monitor for config file changes and will apply changes in near real-time, regardless of whether a config file was present at start-up. To disable this behavior, set `autoReloadConfig` to false like so:  

```java
        .withAutoReloadConfig(false)
```
INI and JSON formats are supported. See below for examples of configuration values in both formats:

INI:

```ini
[logging]
log_level = trace
log_format = text
log_to_console = false
log_file_path = /var/log/javasdk.log
log_response_body = false
log_request_body = false
[general]
live_reload_config = true
host = https://api.mypurecloud.com
```

JSON:
```json
{
    "logging": {
        "log_level": "trace",
        "log_format": "text",
        "log_to_console": false,
        "log_file_path": "/var/log/javasdk.log",
        "log_response_body": false,
        "log_request_body": false
    },
    "general": {
        "live_reload_config": true,
        "host": "https://api.mypurecloud.com"
    }
}
```


#### Other ApiClient.Builder methods

* `withDefaultHeader(String header, String value)` Specifies additional headers to be sent with every request
* `withUserAgent(String userAgent)` Overrides the default user agent header
* `withObjectMapper(ObjectMapper objectMapper)` Overrides the default `ObjectMapper` used for deserialization
* `withDateFormat(DateFormat dateFormat)` Overrides the default `DateFormat`
* `withConnectionTimeout(int connectionTimeout)` Overrides the default connection timeout
* `withShouldThrowErrors(boolean shouldThrowErrors)` Set to `false` to suppress throwing of all errors
* `withProxy(Proxy proxy)` Sets a proxy to use for requests

### Making Requests

There are three steps to making requests:

1. Set the JWT on the SDK
2. Instantiate the WebChat API class
3. Invoke the methods on the API object

Example of getting the authenticated user's information:

#### Set the JWT (access token)

The JWT from the newly created chat must be applied to the SDK before any requests can be made targeting the chat. Do this by setting the JWT on the ApiClient instance.

```java
apiClient.setJwt(chatInfo.getJwt());
```

#### Using a request builder

Request builders allow requests to be constructed by only providing values for the properties you want to set. This is useful for methods with long signatures when you only need to set some properties and will help future-proof your code if the method signature changes (i.e. new parameters added).

```java
WebChatApi webChatApi = new WebChatApi();

// This example assumes a chat has been created and the JWT has been set

CreateWebChatMessageRequest body = new CreateWebChatMessageRequest();
body.setBody("chat message text");

PostWebchatGuestConversationMemberMessagesRequest request = 
  PostWebchatGuestConversationMemberMessagesRequest.builder()
    .withConversationId(chatInfo.getId())
    .withMemberId(chatInfo.getMember().getId())
    .withBody(body)
    .build();
WebChatMessage response = webChatApi.postWebchatGuestConversationMemberMessages(request);
```

#### Using method parameters

This request is identical to the request above, but uses the method with explicit parameters instead of a builder. These methods construct the request builder behind the scenes.

```java
WebChatApi webChatApi = new WebChatApi();

// This example assumes a chat has been created and the JWT has been set

CreateWebChatMessageRequest body = new CreateWebChatMessageRequest();
body.setBody("chat message text");

WebChatMessage response = webChatApi.postWebchatGuestConversationMemberMessages(
  chatInfo.getId(),
  chatInfo.getMember().getId(),
  body
);
```


#### Getting extended info

The Java SDK has the ability to return extended information about the response in addition to the response body. There are varieties of each API method call that are suffixed with _WithHttpInfo_. E.g. The `WebChatApi` has a method `postWebchatGuestConversationMemberMessages(...)` as well as `postWebchatGuestConversationMemberMessagesWithHttpInfo(...)`. Additionally, the request builder classes (e.g. `PostWebchatGuestConversationMemberMessagesRequest`) has a method `withHttpInfo()` that can be used to transform the request into an `ApiRequest` object that will return the extended information.

The extended responses will be of type [ApiResponse<T>](https://github.com/MyPureCloud/platform-client-sdk-java/blob/master/build/src/main/java/com/mypurecloud/sdk/v2/ApiResponse.java). This interface provides methods to get the exception (can be null), get the HTTP status code, get the reason phrase associated with the status code, get all headers, get a specific header, get the correlation ID header, and get the response body as a raw string or as a typed object.

Examples:

```java
// Using the WithHttpInfo method
ApiResponse<WebChatMessage> response = webChatApi.postWebchatGuestConversationMemberMessagesWithHttpInfo(
  chatInfo.getId(),
  chatInfo.getMember().getId(),
  body
);
```

```java
// Using the request builder
PostWebchatGuestConversationMemberMessagesRequest request = 
  PostWebchatGuestConversationMemberMessagesRequest.builder()
    .withConversationId(chatInfo.getId())
    .withMemberId(chatInfo.getMember().getId())
    .withBody(body)
    .build()
    .withHttpInfo();
WebChatMessage response = webChatApi.postWebchatGuestConversationMemberMessages(request);
```


## SDK Source Code Generation

The SDK is automatically regenerated and published from the API's definition after each API release. For more information on the build process, see the [platform-client-sdk-common](https://github.com/MyPureCloud/platform-client-sdk-common) project.


## Versioning

The SDK's version is incremented according to the [Semantic Versioning Specification](https://semver.org/). The decision to increment version numbers is determined by [diffing the Platform API's swagger](https://github.com/purecloudlabs/platform-client-sdk-common/blob/master/modules/swaggerDiff.js) for automated builds, and optionally forcing a version bump when a build is triggered manually (e.g. releasing a bugfix).


## Support

This package is intended to be forwards compatible with v2 of Genesys Cloud's Platform API. While the general policy for the API is not to introduce breaking changes, there are certain additions and changes to the API that cause breaking changes for the SDK, often due to the way the API is expressed in its swagger definition. Because of this, the SDK can have a major version bump while the API remains at major version 2. While the SDK is intended to be forward compatible, patches will only be released to the latest version. For these reasons, it is strongly recommended that all applications using this SDK are kept up to date and use the latest version of the SDK.

For any issues, questions, or suggestions for the SDK, visit the [Genesys Cloud Developer Community](https://community.genesys.com/communities/community-home1/digestviewer?CommunityKey=a39cc4d6-857e-43cb-be7b-019581ab9f38).
