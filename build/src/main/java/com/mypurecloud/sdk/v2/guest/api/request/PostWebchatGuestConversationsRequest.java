package com.mypurecloud.sdk.v2.guest.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.mypurecloud.sdk.v2.guest.ApiException;
import com.mypurecloud.sdk.v2.guest.ApiClient;
import com.mypurecloud.sdk.v2.guest.ApiRequest;
import com.mypurecloud.sdk.v2.guest.ApiRequestBuilder;
import com.mypurecloud.sdk.v2.guest.ApiResponse;
import com.mypurecloud.sdk.v2.guest.Configuration;
import com.mypurecloud.sdk.v2.guest.model.*;
import com.mypurecloud.sdk.v2.guest.Pair;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import com.mypurecloud.sdk.v2.guest.model.CreateWebChatConversationRequest;
import com.mypurecloud.sdk.v2.guest.model.CreateWebChatConversationResponse;
import com.mypurecloud.sdk.v2.guest.model.CreateWebChatMessageRequest;
import com.mypurecloud.sdk.v2.guest.model.ErrorBody;
import com.mypurecloud.sdk.v2.guest.model.WebChatGuestMediaRequest;
import com.mypurecloud.sdk.v2.guest.model.WebChatGuestMediaRequestEntityList;
import com.mypurecloud.sdk.v2.guest.model.WebChatMemberInfo;
import com.mypurecloud.sdk.v2.guest.model.WebChatMemberInfoEntityList;
import com.mypurecloud.sdk.v2.guest.model.WebChatMessage;
import com.mypurecloud.sdk.v2.guest.model.WebChatMessageEntityList;
import com.mypurecloud.sdk.v2.guest.model.WebChatTyping;

public class PostWebchatGuestConversationsRequest {

	private CreateWebChatConversationRequest body;
	public CreateWebChatConversationRequest getBody() {
		return this.body;
	}

	public void setBody(CreateWebChatConversationRequest body) {
		this.body = body;
	}

	public PostWebchatGuestConversationsRequest withBody(CreateWebChatConversationRequest body) {
	    this.setBody(body);
	    return this;
	} 

	private final Map<String, String> customHeaders = new HashMap<>();
    public Map<String, String> getCustomHeaders() {
        return this.customHeaders;
    }

    public void setCustomHeaders(Map<String, String> customHeaders) {
        this.customHeaders.clear();
        this.customHeaders.putAll(customHeaders);
    }

    public void addCustomHeader(String name, String value) {
        this.customHeaders.put(name, value);
    }

    public PostWebchatGuestConversationsRequest withCustomHeader(String name, String value) {
        this.addCustomHeader(name, value);
        return this;
    }

    public ApiRequest<CreateWebChatConversationRequest> withHttpInfo() {
        
        // verify the required parameter 'body' is set
        if (this.body == null) {
            throw new IllegalStateException("Missing the required parameter 'body' when building request for PostWebchatGuestConversationsRequest.");
        }
        

        return ApiRequestBuilder.create("POST", "/api/v2/webchat/guest/conversations")
                .withBody(body)

		.withCustomHeaders(customHeaders)
                .withContentTypes("application/json")
                .withAccepts("application/json")
                .withAuthNames()
                .build();
    }

	public static Builder builder() {
		return new Builder();
	}


	public static Builder builder(CreateWebChatConversationRequest body) {
	    return new Builder()
	            .withRequiredParams(body);
	}


	public static class Builder {
		private final PostWebchatGuestConversationsRequest request;

		private Builder() {
			request = new PostWebchatGuestConversationsRequest();
		}


		public Builder withBody(CreateWebChatConversationRequest body) {
			request.setBody(body);
			return this;
		}



		public Builder withRequiredParams(CreateWebChatConversationRequest body) {
			request.setBody(body);

			return this;
		}


		public PostWebchatGuestConversationsRequest build() {
            
            // verify the required parameter 'body' is set
            if (request.body == null) {
                throw new IllegalStateException("Missing the required parameter 'body' when building request for PostWebchatGuestConversationsRequest.");
            }
            
			return request;
		}
	}
}
