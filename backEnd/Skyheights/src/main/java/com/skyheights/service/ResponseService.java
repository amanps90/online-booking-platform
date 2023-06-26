package com.skyheights.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;

public class ResponseService {
	public static ResponseEntity<?> success(Object data) {
		Map<String, Object> map = new HashMap<>();
		if (data != null) {
			map.put("status", "success");
			map.put("data", data);
		} else {
			map.put("status", "failed");
			map.put("data", data);
		}
		return ResponseEntity.ok(map);
	}
}
