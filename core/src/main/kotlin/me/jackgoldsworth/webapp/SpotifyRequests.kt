package me.jackgoldsworth.webapp

import com.google.gson.JsonParser
import org.apache.http.HttpHeaders
import org.apache.http.client.methods.RequestBuilder
import org.apache.http.client.utils.URIBuilder
import org.apache.http.entity.ContentType
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils


/**
 * This is a list of Http calls for the Spotify API
 * @author Jack Goldsworth
 * @since v0.1
 */
object SpotifyRequests {

    var currentTrack: SpotifyTrack? = null;
    private val client = HttpClients.createDefault()

    /**
     * Sets the volume on the open device.
     * @return request status code.
     */
    fun setVolume(volume: Int, authToken: String): Int {
        val request = RequestBuilder.put()
                .setUri("https://api.spotify.com/v1/me/player/volume?volume_percent=$volume")
                .setHeader(HttpHeaders.AUTHORIZATION, "Bearer $authToken")
                .setHeader(HttpHeaders.CONTENT_LENGTH, "0")
                .build()
        val response = client.execute(request)
        return response.statusLine.statusCode
    }

    /**
     * Sets the current track playing.
     * @return request status code.
     */
    fun setTrack(trackName: String, authToken: String): SpotifyTrack {
        val track = searchTrack(trackName, authToken)
        val content = "{\"position_ms\":0,\"uris\":[\"spotify:track:${track.id}\"]}"
        val request = RequestBuilder.put()
            .setUri("https://api.spotify.com/v1/me/player/play")
            .setHeader(HttpHeaders.AUTHORIZATION, "Bearer $authToken")
            .setHeader(HttpHeaders.ACCEPT, "application/json")
            .setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
            .setEntity(StringEntity(content, ContentType.APPLICATION_JSON))
            .build()
        client.execute(request)
        return track
    }

    /**
     * Search for track by name.
     * @return track id
     */
    private fun searchTrack(track: String, authToken: String): SpotifyTrack {
        val uri = URIBuilder("https://api.spotify.com/v1/search")
            .addParameter("q", track)
            .addParameter("type", "track")
            .build()
        val request = RequestBuilder.get()
            .setUri(uri)
            .setHeader(HttpHeaders.AUTHORIZATION, "Bearer $authToken")
            .setHeader(HttpHeaders.CONTENT_LENGTH, "0")
            .setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
            .build()
        val response = client.execute(request)
        val entityString = EntityUtils.toString(response.entity)
        val json = JsonParser().parse(entityString)
        val item = json.asJsonObject.getAsJsonObject("tracks").getAsJsonArray("items").get(0).asJsonObject
        val trackId = item.get("id").asString
        val songName = item.get("name").asString
        val album = item.getAsJsonObject("album")
        val artist = album.getAsJsonArray("artists").get(0).asJsonObject.get("name").asString
        val imageUrl = album.getAsJsonArray("images").get(1).asJsonObject.get("url").asString
        val tempTrack = SpotifyTrack(trackId, imageUrl, songName, artist)
        currentTrack = tempTrack
        return tempTrack
    }
}