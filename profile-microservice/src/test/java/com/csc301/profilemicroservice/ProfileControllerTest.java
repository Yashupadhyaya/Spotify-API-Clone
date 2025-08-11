package com.csc301.profilemicroservice;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api;
import java.util.HashMap;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ProfileControllerTest {

	/*
	 * ROOST_METHOD_HASH=likeSong_b915241087 ROOST_METHOD_SIG_HASH=likeSong_538288bf51
	 *
	 */public void likeSongSuccess() throws Exception {
    DbQueryStatus mockDbQueryStatus = new DbQueryStatus("Success message", DbQueryExecResult.QUERY_OK);
    Mockito.when(mockPlaylistDriver.likeSong(Mockito.anyString(), Mockito.anyString())).thenReturn(mockDbQueryStatus);
    HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(Utils.getUrl(mockRequest)).thenReturn("http:
    Map<String, Object> response = profileController.likeSong("userName", "songId", mockRequest);
    assertNotNull(response);
    assertEquals("PUT http:
    assertEquals("Success message", response.get("message"));
    assertEquals(DbQueryExecResult.QUERY_OK.toString(), response.get("status"));
}

	/*
	 * ROOST_METHOD_HASH=likeSong_b915241087 ROOST_METHOD_SIG_HASH=likeSong_538288bf51
	 *
	 */public void likeSongNotFound() {
    DbQueryStatus mockDbQueryStatus = new DbQueryStatus("Song not found", DbQueryExecResult.QUERY_ERROR_NOT_FOUND);
    Mockito.when(mockPlaylistDriver.likeSong(Mockito.anyString(), Mockito.anyString())).thenReturn(mockDbQueryStatus);
    HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(Utils.getUrl(mockRequest)).thenReturn("http:
    Map<String, Object> response = profileController.likeSong("userName", "songId", mockRequest);
    assertEquals("PUT http:
    assertEquals("Song not found", response.get("message"));
    assertEquals(DbQueryExecResult.QUERY_ERROR_NOT_FOUND.toString(), response.get("status"));
}

	/*
	 * ROOST_METHOD_HASH=likeSong_b915241087 ROOST_METHOD_SIG_HASH=likeSong_538288bf51
	 *
	 */public void likeSongApiFailure() throws Exception {
    DbQueryStatus mockDbQueryStatus = new DbQueryStatus("Initial success", DbQueryExecResult.QUERY_OK);
    Mockito.when(mockPlaylistDriver.likeSong(Mockito.anyString(), Mockito.anyString())).thenReturn(mockDbQueryStatus);
    HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(Utils.getUrl(mockRequest)).thenReturn("http:
    OkHttpClient clientMock = Mockito.mock(OkHttpClient.class);
    Response responseMock = Mockito.mock(Response.class);
    Mockito.when(responseMock.body().string()).thenReturn("{\"status\":\"ERROR\"}");
    Mockito.when(clientMock.newCall(Mockito.any(Request.class)).execute()).thenReturn(responseMock);
    Map<String, Object> response = profileController.likeSong("userName", "songId", mockRequest);
    assertEquals("PUT http:
    assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC.toString(), response.get("status"));

}

	/*
	 * ROOST_METHOD_HASH=likeSong_b915241087 ROOST_METHOD_SIG_HASH=likeSong_538288bf51
	 *
	 */public void likeSongExceptionHandling() {
    DbQueryStatus mockDbQueryStatus = new DbQueryStatus("Initial success", DbQueryExecResult.QUERY_OK);
    Mockito.when(mockPlaylistDriver.likeSong(Mockito.anyString(), Mockito.anyString())).thenReturn(mockDbQueryStatus);
    HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(Utils.getUrl(mockRequest)).thenReturn("http:
    Mockito.doThrow(RuntimeException.class).when(mockPlaylistDriver).likeSong(Mockito.anyString(), Mockito.anyString());
    Map<String, Object> response = profileController.likeSong("userName", "songId", mockRequest);
    assertEquals("PUT http:
    assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC.toString(), response.get("status"));

}

	/*
	 * ROOST_METHOD_HASH=likeSong_b915241087 ROOST_METHOD_SIG_HASH=likeSong_538288bf51
	 *
	 */public void likeSongResponseStructure() {
    DbQueryStatus mockDbQueryStatus = new DbQueryStatus("Success message", DbQueryExecResult.QUERY_OK);
    Mockito.when(mockPlaylistDriver.likeSong(Mockito.anyString(), Mockito.anyString())).thenReturn(mockDbQueryStatus);
    HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(Utils.getUrl(mockRequest)).thenReturn("http:
    Map<String, Object> response = profileController.likeSong("userName", "songId", mockRequest);
    assertEquals("PUT http:
    assertNotNull(response.get("message"));
    assertNotNull(response.get("status"));
}

	/*
	 * ROOST_METHOD_HASH=likeSong_b915241087 ROOST_METHOD_SIG_HASH=likeSong_538288bf51
	 *
	 */public void likeSongNullUserName() {
    HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(Utils.getUrl(mockRequest)).thenReturn("http:
    Map<String, Object> response = profileController.likeSong(null, "songId", mockRequest);
    assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC.toString(), response.get("status"));
    assertNotNull(response.get("message"));
}

	/*
	 * ROOST_METHOD_HASH=likeSong_b915241087 ROOST_METHOD_SIG_HASH=likeSong_538288bf51
	 *
	 */public void likeSongNullSongId() {
    HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(Utils.getUrl(mockRequest)).thenReturn("http:
    Map<String, Object> response = profileController.likeSong("userName", null, mockRequest);
    assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC.toString(), response.get("status"));
    assertNotNull(response.get("message"));
}

	/*
	 * ROOST_METHOD_HASH=likeSong_b915241087 ROOST_METHOD_SIG_HASH=likeSong_538288bf51
	 *
	 */public void likeSongInvalidUrlHandling() {
    DbQueryStatus mockDbQueryStatus = new DbQueryStatus("Initial success", DbQueryExecResult.QUERY_OK);
    Mockito.when(mockPlaylistDriver.likeSong(Mockito.anyString(), Mockito.anyString())).thenReturn(mockDbQueryStatus);
    HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(Utils.getUrl(mockRequest)).thenReturn("http:
    Map<String, Object> response = profileController.likeSong("userName", "songId", mockRequest);
    assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC.toString(), response.get("status"));
    assertNotNull(response.get("message"));
}

}