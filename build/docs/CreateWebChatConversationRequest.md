---
title: CreateWebChatConversationRequest
ispreview: true
---
## CreateWebChatConversationRequest


## Properties

| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **organizationId** | **String** | The organization identifier. |  |
| **deploymentId** | **String** | The web chat Deployment ID which contains the appropriate settings for this chat conversation. |  |
| **routingTarget** | [**WebChatRoutingTarget**](WebChatRoutingTarget.html) | The routing information to use for the new chat conversation. |  |
| **memberInfo** | [**GuestMemberInfo**](GuestMemberInfo.html) | The guest member info to use for the new chat conversation. |  |
| **memberAuthToken** | **String** | If the guest member is an authenticated member (ie, not anonymous) his JWT is provided here. The token will have been previously generated with the \&quot;POST /api/v2/signeddata\&quot; resource. |  [optional] |
{: class="table table-striped"}



