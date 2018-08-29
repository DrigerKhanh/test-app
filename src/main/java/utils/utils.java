package utils;

import javax.servlet.http.HttpServletRequest;

public class utils {
	public static String getUrl(HttpServletRequest request, String url) {
		return request.getContextPath() + url;
	}
}
