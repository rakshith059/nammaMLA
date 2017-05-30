package rakshith.com.mymla.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by rakshith on 5/30/17.
 */
public class YouTubeItemId implements Serializable {
    @SerializedName("kind")
    private
    String youtubeItemIdKind;

    @SerializedName("videoId")
    private
    String youtubeItemIdVideoId;

    public String getYoutubeItemIdKind() {
        return youtubeItemIdKind;
    }

    public void setYoutubeItemIdKind(String youtubeItemIdKind) {
        this.youtubeItemIdKind = youtubeItemIdKind;
    }

    public String getYoutubeItemIdVideoId() {
        return youtubeItemIdVideoId;
    }

    public void setYoutubeItemIdVideoId(String youtubeItemIdVideoId) {
        this.youtubeItemIdVideoId = youtubeItemIdVideoId;
    }
}
