package com.star.sud;

import java.util.Map;

public class StarUtil {

	public static String getParamsAsString(Map<String, String> reqParams) {
		StringBuffer paramsAsStr = new StringBuffer("");

		if (reqParams != null && reqParams.size() > 0) {
			for (String key : reqParams.keySet()) {
				if (!paramsAsStr.toString().isEmpty()) {
					paramsAsStr.append("&");
				}
				paramsAsStr.append(key + "=" + reqParams.get(key));
			}
		}

		return paramsAsStr.toString();
	}

}
