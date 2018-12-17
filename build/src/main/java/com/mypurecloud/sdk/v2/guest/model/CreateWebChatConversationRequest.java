package com.mypurecloud.sdk.v2.guest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mypurecloud.sdk.v2.guest.model.WebChatMemberInfo;
import com.mypurecloud.sdk.v2.guest.model.WebChatRoutingTarget;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
/**
 * CreateWebChatConversationRequest
 */

public class CreateWebChatConversationRequest  implements Serializable {
  
  private String organizationId = null;
  private String deploymentId = null;
  private WebChatRoutingTarget routingTarget = null;
  private WebChatMemberInfo memberInfo = null;
  private String memberAuthToken = null;

  
  /**
   * The organization identifier.
   **/
  public CreateWebChatConversationRequest organizationId(String organizationId) {
    this.organizationId = organizationId;
    return this;
  }
  
  @ApiModelProperty(example = "null", required = true, value = "The organization identifier.")
  @JsonProperty("organizationId")
  public String getOrganizationId() {
    return organizationId;
  }
  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
  }

  
  /**
   * The web chat deployment id.
   **/
  public CreateWebChatConversationRequest deploymentId(String deploymentId) {
    this.deploymentId = deploymentId;
    return this;
  }
  
  @ApiModelProperty(example = "null", required = true, value = "The web chat deployment id.")
  @JsonProperty("deploymentId")
  public String getDeploymentId() {
    return deploymentId;
  }
  public void setDeploymentId(String deploymentId) {
    this.deploymentId = deploymentId;
  }

  
  /**
   * The target for the new chat conversation.
   **/
  public CreateWebChatConversationRequest routingTarget(WebChatRoutingTarget routingTarget) {
    this.routingTarget = routingTarget;
    return this;
  }
  
  @ApiModelProperty(example = "null", required = true, value = "The target for the new chat conversation.")
  @JsonProperty("routingTarget")
  public WebChatRoutingTarget getRoutingTarget() {
    return routingTarget;
  }
  public void setRoutingTarget(WebChatRoutingTarget routingTarget) {
    this.routingTarget = routingTarget;
  }

  
  /**
   * The member info of the 'customer' member starting the web chat.
   **/
  public CreateWebChatConversationRequest memberInfo(WebChatMemberInfo memberInfo) {
    this.memberInfo = memberInfo;
    return this;
  }
  
  @ApiModelProperty(example = "null", required = true, value = "The member info of the 'customer' member starting the web chat.")
  @JsonProperty("memberInfo")
  public WebChatMemberInfo getMemberInfo() {
    return memberInfo;
  }
  public void setMemberInfo(WebChatMemberInfo memberInfo) {
    this.memberInfo = memberInfo;
  }

  
  /**
   * If appropriate, specify the JWT of the authenticated guest.
   **/
  public CreateWebChatConversationRequest memberAuthToken(String memberAuthToken) {
    this.memberAuthToken = memberAuthToken;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "If appropriate, specify the JWT of the authenticated guest.")
  @JsonProperty("memberAuthToken")
  public String getMemberAuthToken() {
    return memberAuthToken;
  }
  public void setMemberAuthToken(String memberAuthToken) {
    this.memberAuthToken = memberAuthToken;
  }

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateWebChatConversationRequest createWebChatConversationRequest = (CreateWebChatConversationRequest) o;
    return Objects.equals(this.organizationId, createWebChatConversationRequest.organizationId) &&
        Objects.equals(this.deploymentId, createWebChatConversationRequest.deploymentId) &&
        Objects.equals(this.routingTarget, createWebChatConversationRequest.routingTarget) &&
        Objects.equals(this.memberInfo, createWebChatConversationRequest.memberInfo) &&
        Objects.equals(this.memberAuthToken, createWebChatConversationRequest.memberAuthToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(organizationId, deploymentId, routingTarget, memberInfo, memberAuthToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateWebChatConversationRequest {\n");
    
    sb.append("    organizationId: ").append(toIndentedString(organizationId)).append("\n");
    sb.append("    deploymentId: ").append(toIndentedString(deploymentId)).append("\n");
    sb.append("    routingTarget: ").append(toIndentedString(routingTarget)).append("\n");
    sb.append("    memberInfo: ").append(toIndentedString(memberInfo)).append("\n");
    sb.append("    memberAuthToken: ").append(toIndentedString(memberAuthToken)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

