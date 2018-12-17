package com.mypurecloud.sdk.v2.guest.auth;

import com.mypurecloud.sdk.v2.guest.Pair;

import java.util.Map;
import java.util.List;

public interface Authentication {
  /** Apply authentication settings to header and query params. */
  void applyToParams(List<Pair> queryParams, Map<String, String> headerParams);
}
