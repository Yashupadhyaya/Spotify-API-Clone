
package com.csc301.songmicroservice;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.*;
import java.util.HashMap;
import java.util.Map;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class SongToStringTest {

	@Test
	@Tag("valid")
	public void validateJsonRepresentationForInitializedObject() {
		// Arrange
		String songName = "Test Song";
		String songArtistFullName = "Test Artist";
		String songAlbum = "Test Album";
		long songAmountFavourites = 25; // TODO: Modify values as necessary for varied
										// testing
		ObjectId songId = new ObjectId();
		Song testSong = new Song(songName, songArtistFullName, songAlbum);
		testSong.setSongAmountFavourites(songAmountFavourites);
		testSong.setId(songId);
		String expectedJson = "{id=" + songId.toHexString() + ", songName=" + songName + ", songArtistFullName="
				+ songArtistFullName + ", songAlbum=" + songAlbum + ", songAmountFavourites=" + songAmountFavourites
				+ "}";
		// Act
		String actualJson = testSong.toString();
		// Assert
		assertEquals(expectedJson, actualJson);
	}

}