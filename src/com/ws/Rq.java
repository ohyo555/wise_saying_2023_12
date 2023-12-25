package com.ws;

import java.util.HashMap;
import java.util.Map;

// Rq == Request(요청)
public class Rq {
	private String actionCode;
	private Map<String, String> params; // (문자, 문자)인 Map형태의 params 변수 지정

	public Rq(String cmd) {
		String[] cmdBits = cmd.split("\\?", 2); // cmd를 ? 기준으로 2개로 나눠서 문자열 배열의 cmdBits로 지정 

		actionCode = cmdBits[0]; // cmdBits 배열의 첫번째 값을 actionCode값으로 지정

		params = new HashMap<>(); // HashMap형태의 params 변수 지정

		if (cmdBits.length == 1) {
			return;
		}

		String[] paramBits = cmdBits[1].split("&"); // cmdBits의 두번째 값을 & 기준으로 나누어 문자열 배열 paramBits로 지정

		for (String paramStr : paramBits) { // 배열 반복
			String[] paramStrBits = paramStr.split("=", 2); // paramStr을 = 기준으로 2개로 나눠서 문자열 배열 paramStrBits로 지정
			
			if (paramStrBits.length == 1) { // paramStrBits 배열 길이가 1이면 계속 (id는 있고 값은 없을때)
				continue;
			}

			String key = paramStrBits[0]; // paramStrBits의 첫번째 값을 key값으로 지정
			String value = paramStrBits[1]; // paramStrBits의 두번째 값을 value값으로 지정
			params.put(key, value); // hashmap 형태의 params에 key, value값을 넣음
		}
	}
	
	public String getActionCode() {
		return actionCode;
	}

	public String getParam(String name) { // name를 매개변수로 한 param값을 남겨주는 메소드?
		return params.get(name);
	}
	
	public int getIntParam(String name, int defaultValue) { // name를 매개변수로 하고 기본값을 지정해주는 메소드?
		try {
			return Integer.parseInt(getParam(name)); // 받은 name값을 정수로 반환
		} catch (NumberFormatException e) { // NumberFormatException 예외가 발생한 경우 defaultValue를 반환받음

		}
		return defaultValue;
	}
}