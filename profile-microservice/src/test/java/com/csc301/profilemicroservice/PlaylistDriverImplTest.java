package com.csc301.profilemicroservice;

import org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.Mockito;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Transaction;
import org.junit.jupiter.api;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

public class PlaylistDriverImplTest {

	/*
	 * ROOST_METHOD_HASH=likeSong_0db1938fb8 ROOST_METHOD_SIG_HASH=likeSong_643385e86e
	 *
	 */public void likeSongWhenSongIsAddedSuccessfully() {

		Driver mockDriver = mock(Driver.class);
		Session mockSession = mock(Session.class);
		Transaction mockTransaction = mock(Transaction.class);
		StatementResult mockStatementResult = mock(StatementResult.class);
		when(mockDriver.session()).thenReturn(mockSession);
		when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		when(mockTransaction.run(anyString(), anyMap())).thenReturn(mockStatementResult);

		when(mockStatementResult.hasNext()).thenReturn(true);

		String userName = "testUser";

		String songId = "testSongID";
		PlaylistDriverImpl playlistDriverImpl = new PlaylistDriverImpl(mockDriver);

		DbQueryStatus dbQueryStatus = playlistDriverImpl.likeSong(userName, songId);

		assertEquals("PUT", dbQueryStatus.getOperation(), "Expected `PUT` as the operation.");
		assertEquals(DbQueryExecResult.QUERY_OK, dbQueryStatus.getDbQueryExecResult(),
				"The song should be successfully added to the playlist.");
	}

	/*
	 * ROOST_METHOD_HASH=likeSong_0db1938fb8 ROOST_METHOD_SIG_HASH=likeSong_643385e86e
	 *
	 */public void likeSongWhenUserNameIsNull() {

		Driver mockDriver = mock(Driver.class);
		PlaylistDriverImpl playlistDriverImpl = new PlaylistDriverImpl(mockDriver);

		String songId = "testSongID";

		DbQueryStatus dbQueryStatus = playlistDriverImpl.likeSong(null, songId);

		assertEquals("PUT", dbQueryStatus.getOperation(), "Expected `PUT` as the operation.");
		assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC, dbQueryStatus.getDbQueryExecResult(),
				"Expected a generic error for null userName.");
	}

	/*
	 * ROOST_METHOD_HASH=likeSong_0db1938fb8 ROOST_METHOD_SIG_HASH=likeSong_643385e86e
	 *
	 */public void likeSongWhenSongIdIsNull() {

		Driver mockDriver = mock(Driver.class);
		PlaylistDriverImpl playlistDriverImpl = new PlaylistDriverImpl(mockDriver);

		String userName = "testUser";

		DbQueryStatus dbQueryStatus = playlistDriverImpl.likeSong(userName, null);

		assertEquals("PUT", dbQueryStatus.getOperation(), "Expected `PUT` as the operation.");
		assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC, dbQueryStatus.getDbQueryExecResult(),
				"Expected a generic error for null songId.");
	}

	/*
	 * ROOST_METHOD_HASH=likeSong_0db1938fb8 ROOST_METHOD_SIG_HASH=likeSong_643385e86e
	 *
	 */public void likeSongWhenPlaylistDoesNotExist() {

		Driver mockDriver = mock(Driver.class);
		Session mockSession = mock(Session.class);
		Transaction mockTransaction = mock(Transaction.class);
		StatementResult mockStatementResult = mock(StatementResult.class);
		when(mockDriver.session()).thenReturn(mockSession);
		when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		when(mockTransaction.run(anyString(), anyMap())).thenReturn(mockStatementResult);

		when(mockStatementResult.hasNext()).thenReturn(false);

		String userName = "testUser";

		String songId = "testSongID";
		PlaylistDriverImpl playlistDriverImpl = new PlaylistDriverImpl(mockDriver);

		DbQueryStatus dbQueryStatus = playlistDriverImpl.likeSong(userName, songId);

		assertEquals("PUT", dbQueryStatus.getOperation(), "Expected `PUT` as the operation.");
		assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC, dbQueryStatus.getDbQueryExecResult(),
				"Expected a generic error for non-existent playlist.");
	}

	/*
	 * ROOST_METHOD_HASH=likeSong_0db1938fb8 ROOST_METHOD_SIG_HASH=likeSong_643385e86e
	 *
	 */public void likeSongWhenSongAlreadyLiked() {

		Driver mockDriver = mock(Driver.class);
		Session mockSession = mock(Session.class);
		Transaction mockTransaction = mock(Transaction.class);
		StatementResult mockStatementResult = mock(StatementResult.class);
		when(mockDriver.session()).thenReturn(mockSession);
		when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		when(mockTransaction.run(anyString(), anyMap())).thenReturn(mockStatementResult);
		when(mockStatementResult.hasNext()).thenReturn(true).thenReturn(true).thenReturn(true);

		String userName = "testUser";

		String songId = "testSongID";
		PlaylistDriverImpl playlistDriverImpl = new PlaylistDriverImpl(mockDriver);

		DbQueryStatus dbQueryStatus = playlistDriverImpl.likeSong(userName, songId);

		assertEquals("PUT", dbQueryStatus.getOperation(), "Expected `PUT` as the operation.");
		assertEquals(DbQueryExecResult.QUERY_ERROR_NOT_FOUND, dbQueryStatus.getDbQueryExecResult(),
				"Expected error status indicating song already liked.");
	}

}