package com.mypurecloud.sdk.v2.guest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.io.Serializable;
/**
 * GuestMemberInfo
 */

public class GuestMemberInfo  implements Serializable {
  
  private String displayName = null;
  private String profileImageUrl = null;
  private Map<String, String> customFields = null;

  
  /**
   * The display name to use for the guest member in the conversation.
   **/
  public GuestMemberInfo displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }
  
  @ApiModelProperty(example = "null", required = true, value = "The display name to use for the guest member in the conversation.")
  @JsonProperty("displayName")
  public String getDisplayName() {
    return displayName;
  }
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  
  /**
   * The URL to the profile image to use for the guest member in the conversation, if any.
   **/
  public GuestMemberInfo profileImageUrl(String profileImageUrl) {
    this.profileImageUrl = profileImageUrl;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "The URL to the profile image to use for the guest member in the conversation, if any.")
  @JsonProperty("profileImageUrl")
  public String getProfileImageUrl() {
    return profileImageUrl;
  }
  public void setProfileImageUrl(String profileImageUrl) {
    this.profileImageUrl = profileImageUrl;
  }

  
  /**
   * Any custom fields of information, in key-value format, to attach to the guest member in the conversation.
   **/
  public GuestMemberInfo customFields(Map<String, String> customFields) {
    this.customFields = customFields;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Any custom fields of information, in key-value format, to attach to the guest member in the conversation.")
  @JsonProperty("customFields")
  public Map<String, String> getCustomFields() {
    return customFields;
  }
  public void setCustomFields(Map<String, String> customFields) {
    this.customFields = customFields;
  }

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GuestMemberInfo guestMemberInfo = (GuestMemberInfo) o;
    return Objects.equals(this.displayName, guestMemberInfo.displayName) &&
        Objects.equals(this.profileImageUrl, guestMemberInfo.profileImageUrl) &&
        Objects.equals(this.customFields, guestMemberInfo.customFields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, profileImageUrl, customFields);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GuestMemberInfo {\n");
    
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    profileImageUrl: ").append(toIndentedString(profileImageUrl)).append("\n");
    sb.append("    customFields: ").append(toIndentedString(customFields)).append("\n");
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

