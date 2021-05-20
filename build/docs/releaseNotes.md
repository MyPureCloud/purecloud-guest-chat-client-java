Platform API version: 4693


Adding SL4J back into the SDK. Also adding the ability to provide custom HTTP request and response interceptors.

# Major Changes (0 changes)


# Minor Changes (0 changes)


# Point Changes (11 changes)

**POST /api/v2/webchat/guest/conversations** (1 change)

* Response 429 was changed from Rate limit exceeded the maximum [%s] requests within [%s] seconds to Rate limit exceeded the maximum. Retry the request in [%s] seconds

**POST /api/v2/webchat/guest/conversations/{conversationId}/members/{memberId}/typing** (1 change)

* Response 429 was changed from Rate limit exceeded the maximum [%s] requests within [%s] seconds to Rate limit exceeded the maximum. Retry the request in [%s] seconds

**POST /api/v2/webchat/guest/conversations/{conversationId}/members/{memberId}/messages** (1 change)

* Response 429 was changed from Rate limit exceeded the maximum [%s] requests within [%s] seconds to Rate limit exceeded the maximum. Retry the request in [%s] seconds

**GET /api/v2/webchat/guest/conversations/{conversationId}/members/{memberId}** (1 change)

* Response 429 was changed from Rate limit exceeded the maximum [%s] requests within [%s] seconds to Rate limit exceeded the maximum. Retry the request in [%s] seconds

**DELETE /api/v2/webchat/guest/conversations/{conversationId}/members/{memberId}** (1 change)

* Response 429 was changed from Rate limit exceeded the maximum [%s] requests within [%s] seconds to Rate limit exceeded the maximum. Retry the request in [%s] seconds

**GET /api/v2/webchat/guest/conversations/{conversationId}/messages/{messageId}** (1 change)

* Response 429 was changed from Rate limit exceeded the maximum [%s] requests within [%s] seconds to Rate limit exceeded the maximum. Retry the request in [%s] seconds

**GET /api/v2/webchat/guest/conversations/{conversationId}/mediarequests** (1 change)

* Response 429 was changed from Rate limit exceeded the maximum [%s] requests within [%s] seconds to Rate limit exceeded the maximum. Retry the request in [%s] seconds

**GET /api/v2/webchat/guest/conversations/{conversationId}/messages** (1 change)

* Response 429 was changed from Rate limit exceeded the maximum [%s] requests within [%s] seconds to Rate limit exceeded the maximum. Retry the request in [%s] seconds

**GET /api/v2/webchat/guest/conversations/{conversationId}/mediarequests/{mediaRequestId}** (1 change)

* Response 429 was changed from Rate limit exceeded the maximum [%s] requests within [%s] seconds to Rate limit exceeded the maximum. Retry the request in [%s] seconds

**PATCH /api/v2/webchat/guest/conversations/{conversationId}/mediarequests/{mediaRequestId}** (1 change)

* Response 429 was changed from Rate limit exceeded the maximum [%s] requests within [%s] seconds to Rate limit exceeded the maximum. Retry the request in [%s] seconds

**GET /api/v2/webchat/guest/conversations/{conversationId}/members** (1 change)

* Response 429 was changed from Rate limit exceeded the maximum [%s] requests within [%s] seconds to Rate limit exceeded the maximum. Retry the request in [%s] seconds
