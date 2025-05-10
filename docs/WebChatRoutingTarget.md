# WebChatRoutingTarget


## Properties

| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **targetType** | [**TargetTypeEnum**](#Enum--TargetTypeEnum) | The target type of the routing target, such as &#39;QUEUE&#39;. |  |
| **targetAddress** | **String** | The target of the route, in the format appropriate given the &#39;targetType&#39;. |  |
| **skills** | **List&lt;String&gt;** | The list of skill names to use for routing. |  [optional] |
| **language** | **String** | The language name to use for routing. |  [optional] |
| **priority** | **Long** | The priority to assign to the conversation for routing. |  [optional] |


## Enum: TargetTypeEnum

| Name | Value |
| ---- | ----- |
| OUTDATEDSDKVERSION | &quot;OutdatedSdkVersion&quot; | 
| QUEUE | &quot;QUEUE&quot; | 




_com.mypurecloud.sdk.v2.guest:purecloud-guest-chat-client:15.2.0_