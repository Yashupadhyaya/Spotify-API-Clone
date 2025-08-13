package com.csc301.profilemicroservice;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import javax.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api;
import org.springframework.http.HttpStatus;
import okhttp3.RequestBody;
import java.util.Map;

public class UtilsTest {

	/*
	 * ROOST_METHOD_HASH=getUrl_dc6eeb1e28 ROOST_METHOD_SIG_HASH=getUrl_a287f381be
	 *
	 */public void validateUrlWithoutQueryParams() {

    HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(mockRequest.getRequestURL()).thenReturn(new StringBuffer("http:
    Mockito.when(mockRequest.getQueryString()).thenReturn(null);

    String result = Utils.getUrl(mockRequest);

    assertEquals("http:
}

	/*
	 * ROOST_METHOD_HASH=getUrl_dc6eeb1e28 ROOST_METHOD_SIG_HASH=getUrl_a287f381be
	 *
	 */public void validateUrlWithQueryParams() {

    HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(mockRequest.getRequestURL()).thenReturn(new StringBuffer("http:
    Mockito.when(mockRequest.getQueryString()).thenReturn("key=value");

    String result = Utils.getUrl(mockRequest);

    assertEquals("http:
}

	/*
	 * ROOST_METHOD_HASH=getUrl_dc6eeb1e28 ROOST_METHOD_SIG_HASH=getUrl_a287f381be
	 *
	 */public void validateLongUrlWithQueryParams() {

    HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(mockRequest.getRequestURL()).thenReturn(new StringBuffer("http:
    Mockito.when(mockRequest.getQueryString()).thenReturn("param1=value1&param2=value2");

    String result = Utils.getUrl(mockRequest);

    assertEquals("http:
}

	/*
	 * ROOST_METHOD_HASH=getUrl_dc6eeb1e28 ROOST_METHOD_SIG_HASH=getUrl_a287f381be
	 *
	 */public void validateNullRequestUrl() {

		HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);

		Mockito.when(mockRequest.getRequestURL()).thenReturn(null);
		Mockito.when(mockRequest.getQueryString()).thenReturn("param=value");

		String result = Utils.getUrl(mockRequest);

		assertEquals("null?param=value", result);
	}

	/*
	 * ROOST_METHOD_HASH=getUrl_dc6eeb1e28 ROOST_METHOD_SIG_HASH=getUrl_a287f381be
	 *
	 */public void validateEmptyQueryString() {

    HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(mockRequest.getRequestURL()).thenReturn(new StringBuffer("http:

    Mockito.when(mockRequest.getQueryString()).thenReturn("");

    String result = Utils.getUrl(mockRequest);


    assertEquals("http:
}

}