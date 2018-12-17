---
title: WebChatApi
---
## WebChatApi

All URIs are relative to *https://api.mypurecloud.com*

| Method | Description |
| ------------- | ------------- |
| [**deleteWebchatGuestConversationMember**](WebChatApi.html#deleteWebchatGuestConversationMember) | Remove a member from a chat conversation |
| [**getWebchatGuestConversationMember**](WebChatApi.html#getWebchatGuestConversationMember) | Get a web chat conversation member |
| [**getWebchatGuestConversationMembers**](WebChatApi.html#getWebchatGuestConversationMembers) | Get the members of a chat conversation. |
| [**getWebchatGuestConversationMessage**](WebChatApi.html#getWebchatGuestConversationMessage) | Get a web chat conversation message |
| [**getWebchatGuestConversationMessages**](WebChatApi.html#getWebchatGuestConversationMessages) | Get the messages of a chat conversation. |
| [**postWebchatGuestConversationMemberMessages**](WebChatApi.html#postWebchatGuestConversationMemberMessages) | Send a message in a chat conversation. |
| [**postWebchatGuestConversationMemberTyping**](WebChatApi.html#postWebchatGuestConversationMemberTyping) | Send a typing-indicator in a chat conversation. |
| [**postWebchatGuestConversations**](WebChatApi.html#postWebchatGuestConversations) | Create an ACD chat conversation from an external customer. |
{: class="table table-striped"}

<a name="deleteWebchatGuestConversationMember"></a>

# **deleteWebchatGuestConversationMember**



> Void deleteWebchatGuestConversationMember(conversationId, memberId)

Remove a member from a chat conversation



Wraps DELETE /api/v2/webchat/guest/conversations/{conversationId}/members/{memberId}  

Requires NO permissions: 


### Example

~~~java
//Import classes:
//import com.mypurecloud.sdk.v2.guest.ApiClient;
//import com.mypurecloud.sdk.v2.guest.ApiException;
//import com.mypurecloud.sdk.v2.guest.Configuration;
//import com.mypurecloud.sdk.v2.guest.auth.*;
//import com.mypurecloud.sdk.v2.guest.api.WebChatApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Guest Chat JWT
ApiKeyAuth Guest Chat JWT = (ApiKeyAuth) defaultClient.getAuthentication("Guest Chat JWT");
Guest Chat JWT.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Guest Chat JWT.setApiKeyPrefix("Token");

WebChatApi apiInstance = new WebChatApi();
String conversationId = "conversationId_example"; // String | conversationId
String memberId = "memberId_example"; // String | memberId
try {
    apiInstance.deleteWebchatGuestConversationMember(conversationId, memberId);
} catch (ApiException e) {
    System.err.println("Exception when calling WebChatApi#deleteWebchatGuestConversationMember");
    e.printStackTrace();
}
~~~

### Parameters


| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **conversationId** | **String**| conversationId | |
| **memberId** | **String**| memberId | |
{: class="table table-striped"}

### Return type

null (empty response body)

<a name="getWebchatGuestConversationMember"></a>

# **getWebchatGuestConversationMember**



> [WebChatMemberInfo](WebChatMemberInfo.html) getWebchatGuestConversationMember(conversationId, memberId)

Get a web chat conversation member



Wraps GET /api/v2/webchat/guest/conversations/{conversationId}/members/{memberId}  

Requires NO permissions: 


### Example

~~~java
//Import classes:
//import com.mypurecloud.sdk.v2.guest.ApiClient;
//import com.mypurecloud.sdk.v2.guest.ApiException;
//import com.mypurecloud.sdk.v2.guest.Configuration;
//import com.mypurecloud.sdk.v2.guest.auth.*;
//import com.mypurecloud.sdk.v2.guest.api.WebChatApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Guest Chat JWT
ApiKeyAuth Guest Chat JWT = (ApiKeyAuth) defaultClient.getAuthentication("Guest Chat JWT");
Guest Chat JWT.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Guest Chat JWT.setApiKeyPrefix("Token");

WebChatApi apiInstance = new WebChatApi();
String conversationId = "conversationId_example"; // String | conversationId
String memberId = "memberId_example"; // String | memberId
try {
    WebChatMemberInfo result = apiInstance.getWebchatGuestConversationMember(conversationId, memberId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebChatApi#getWebchatGuestConversationMember");
    e.printStackTrace();
}
~~~

### Parameters


| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **conversationId** | **String**| conversationId | |
| **memberId** | **String**| memberId | |
{: class="table table-striped"}

### Return type

[**WebChatMemberInfo**](WebChatMemberInfo.html)

<a name="getWebchatGuestConversationMembers"></a>

# **getWebchatGuestConversationMembers**



> [WebChatMemberInfoEntityList](WebChatMemberInfoEntityList.html) getWebchatGuestConversationMembers(conversationId, pageSize, pageNumber, excludeDisconnectedMembers)

Get the members of a chat conversation.



Wraps GET /api/v2/webchat/guest/conversations/{conversationId}/members  

Requires NO permissions: 


### Example

~~~java
//Import classes:
//import com.mypurecloud.sdk.v2.guest.ApiClient;
//import com.mypurecloud.sdk.v2.guest.ApiException;
//import com.mypurecloud.sdk.v2.guest.Configuration;
//import com.mypurecloud.sdk.v2.guest.auth.*;
//import com.mypurecloud.sdk.v2.guest.api.WebChatApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Guest Chat JWT
ApiKeyAuth Guest Chat JWT = (ApiKeyAuth) defaultClient.getAuthentication("Guest Chat JWT");
Guest Chat JWT.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Guest Chat JWT.setApiKeyPrefix("Token");

WebChatApi apiInstance = new WebChatApi();
String conversationId = "conversationId_example"; // String | conversationId
Integer pageSize = 25; // Integer | The number of entries to return per page, or omitted for the default.
Integer pageNumber = 1; // Integer | The page number to return, or omitted for the first page.
Boolean excludeDisconnectedMembers = false; // Boolean | If true, the results will not contain members who have a DISCONNECTED state.
try {
    WebChatMemberInfoEntityList result = apiInstance.getWebchatGuestConversationMembers(conversationId, pageSize, pageNumber, excludeDisconnectedMembers);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebChatApi#getWebchatGuestConversationMembers");
    e.printStackTrace();
}
~~~

### Parameters


| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **conversationId** | **String**| conversationId | |
| **pageSize** | **Integer**| The number of entries to return per page, or omitted for the default. | [optional] [default to 25] |
| **pageNumber** | **Integer**| The page number to return, or omitted for the first page. | [optional] [default to 1] |
| **excludeDisconnectedMembers** | **Boolean**| If true, the results will not contain members who have a DISCONNECTED state. | [optional] [default to false] |
{: class="table table-striped"}

### Return type

[**WebChatMemberInfoEntityList**](WebChatMemberInfoEntityList.html)

<a name="getWebchatGuestConversationMessage"></a>

# **getWebchatGuestConversationMessage**



> [WebChatMessage](WebChatMessage.html) getWebchatGuestConversationMessage(conversationId, messageId)

Get a web chat conversation message



Wraps GET /api/v2/webchat/guest/conversations/{conversationId}/messages/{messageId}  

Requires NO permissions: 


### Example

~~~java
//Import classes:
//import com.mypurecloud.sdk.v2.guest.ApiClient;
//import com.mypurecloud.sdk.v2.guest.ApiException;
//import com.mypurecloud.sdk.v2.guest.Configuration;
//import com.mypurecloud.sdk.v2.guest.auth.*;
//import com.mypurecloud.sdk.v2.guest.api.WebChatApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Guest Chat JWT
ApiKeyAuth Guest Chat JWT = (ApiKeyAuth) defaultClient.getAuthentication("Guest Chat JWT");
Guest Chat JWT.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Guest Chat JWT.setApiKeyPrefix("Token");

WebChatApi apiInstance = new WebChatApi();
String conversationId = "conversationId_example"; // String | conversationId
String messageId = "messageId_example"; // String | messageId
try {
    WebChatMessage result = apiInstance.getWebchatGuestConversationMessage(conversationId, messageId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebChatApi#getWebchatGuestConversationMessage");
    e.printStackTrace();
}
~~~

### Parameters


| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **conversationId** | **String**| conversationId | |
| **messageId** | **String**| messageId | |
{: class="table table-striped"}

### Return type

[**WebChatMessage**](WebChatMessage.html)

<a name="getWebchatGuestConversationMessages"></a>

# **getWebchatGuestConversationMessages**



> [WebChatMessageEntityList](WebChatMessageEntityList.html) getWebchatGuestConversationMessages(conversationId, after, before)

Get the messages of a chat conversation.



Wraps GET /api/v2/webchat/guest/conversations/{conversationId}/messages  

Requires NO permissions: 


### Example

~~~java
//Import classes:
//import com.mypurecloud.sdk.v2.guest.ApiClient;
//import com.mypurecloud.sdk.v2.guest.ApiException;
//import com.mypurecloud.sdk.v2.guest.Configuration;
//import com.mypurecloud.sdk.v2.guest.auth.*;
//import com.mypurecloud.sdk.v2.guest.api.WebChatApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Guest Chat JWT
ApiKeyAuth Guest Chat JWT = (ApiKeyAuth) defaultClient.getAuthentication("Guest Chat JWT");
Guest Chat JWT.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Guest Chat JWT.setApiKeyPrefix("Token");

WebChatApi apiInstance = new WebChatApi();
String conversationId = "conversationId_example"; // String | conversationId
String after = "after_example"; // String | If available, get the messages chronologically after the id of this message
String before = "before_example"; // String | If available, get the messages chronologically before the id of this message
try {
    WebChatMessageEntityList result = apiInstance.getWebchatGuestConversationMessages(conversationId, after, before);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebChatApi#getWebchatGuestConversationMessages");
    e.printStackTrace();
}
~~~

### Parameters


| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **conversationId** | **String**| conversationId | |
| **after** | **String**| If available, get the messages chronologically after the id of this message | [optional] |
| **before** | **String**| If available, get the messages chronologically before the id of this message | [optional] |
{: class="table table-striped"}

### Return type

[**WebChatMessageEntityList**](WebChatMessageEntityList.html)

<a name="postWebchatGuestConversationMemberMessages"></a>

# **postWebchatGuestConversationMemberMessages**



> [WebChatMessage](WebChatMessage.html) postWebchatGuestConversationMemberMessages(conversationId, memberId, body)

Send a message in a chat conversation.



Wraps POST /api/v2/webchat/guest/conversations/{conversationId}/members/{memberId}/messages  

Requires NO permissions: 


### Example

~~~java
//Import classes:
//import com.mypurecloud.sdk.v2.guest.ApiClient;
//import com.mypurecloud.sdk.v2.guest.ApiException;
//import com.mypurecloud.sdk.v2.guest.Configuration;
//import com.mypurecloud.sdk.v2.guest.auth.*;
//import com.mypurecloud.sdk.v2.guest.api.WebChatApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Guest Chat JWT
ApiKeyAuth Guest Chat JWT = (ApiKeyAuth) defaultClient.getAuthentication("Guest Chat JWT");
Guest Chat JWT.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Guest Chat JWT.setApiKeyPrefix("Token");

WebChatApi apiInstance = new WebChatApi();
String conversationId = "conversationId_example"; // String | conversationId
String memberId = "memberId_example"; // String | memberId
CreateWebChatMessageRequest body = new CreateWebChatMessageRequest(); // CreateWebChatMessageRequest | Message
try {
    WebChatMessage result = apiInstance.postWebchatGuestConversationMemberMessages(conversationId, memberId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebChatApi#postWebchatGuestConversationMemberMessages");
    e.printStackTrace();
}
~~~

### Parameters


| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **conversationId** | **String**| conversationId | |
| **memberId** | **String**| memberId | |
| **body** | [**CreateWebChatMessageRequest**](CreateWebChatMessageRequest.html)| Message | |
{: class="table table-striped"}

### Return type

[**WebChatMessage**](WebChatMessage.html)

<a name="postWebchatGuestConversationMemberTyping"></a>

# **postWebchatGuestConversationMemberTyping**



> [WebChatTyping](WebChatTyping.html) postWebchatGuestConversationMemberTyping(conversationId, memberId)

Send a typing-indicator in a chat conversation.



Wraps POST /api/v2/webchat/guest/conversations/{conversationId}/members/{memberId}/typing  

Requires NO permissions: 


### Example

~~~java
//Import classes:
//import com.mypurecloud.sdk.v2.guest.ApiClient;
//import com.mypurecloud.sdk.v2.guest.ApiException;
//import com.mypurecloud.sdk.v2.guest.Configuration;
//import com.mypurecloud.sdk.v2.guest.auth.*;
//import com.mypurecloud.sdk.v2.guest.api.WebChatApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Guest Chat JWT
ApiKeyAuth Guest Chat JWT = (ApiKeyAuth) defaultClient.getAuthentication("Guest Chat JWT");
Guest Chat JWT.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Guest Chat JWT.setApiKeyPrefix("Token");

WebChatApi apiInstance = new WebChatApi();
String conversationId = "conversationId_example"; // String | conversationId
String memberId = "memberId_example"; // String | memberId
try {
    WebChatTyping result = apiInstance.postWebchatGuestConversationMemberTyping(conversationId, memberId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebChatApi#postWebchatGuestConversationMemberTyping");
    e.printStackTrace();
}
~~~

### Parameters


| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **conversationId** | **String**| conversationId | |
| **memberId** | **String**| memberId | |
{: class="table table-striped"}

### Return type

[**WebChatTyping**](WebChatTyping.html)

<a name="postWebchatGuestConversations"></a>

# **postWebchatGuestConversations**



> [CreateWebChatConversationResponse](CreateWebChatConversationResponse.html) postWebchatGuestConversations(body)

Create an ACD chat conversation from an external customer.



Wraps POST /api/v2/webchat/guest/conversations  

Requires NO permissions: 


### Example

~~~java
//Import classes:
//import com.mypurecloud.sdk.v2.guest.ApiException;
//import com.mypurecloud.sdk.v2.guest.api.WebChatApi;


WebChatApi apiInstance = new WebChatApi();
CreateWebChatConversationRequest body = new CreateWebChatConversationRequest(); // CreateWebChatConversationRequest | CreateConversationRequest
try {
    CreateWebChatConversationResponse result = apiInstance.postWebchatGuestConversations(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebChatApi#postWebchatGuestConversations");
    e.printStackTrace();
}
~~~

### Parameters


| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**CreateWebChatConversationRequest**](CreateWebChatConversationRequest.html)| CreateConversationRequest | |
{: class="table table-striped"}

### Return type

[**CreateWebChatConversationResponse**](CreateWebChatConversationResponse.html)

