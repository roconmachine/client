package com.roconmachine.client.core;

import lombok.Data;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class AppRequest {

   private final Map<String, Object> parameters = new LinkedHashMap<>();
//   private final Map<String, String> queryParams = new HashMap<>(0);
//   private final Map<String, String> pathVars = new HashMap<>(0);

}
