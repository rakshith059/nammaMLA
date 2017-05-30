package rakshith.com.mymla.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by rakshith on 5/30/17.
 */
public class YouTubeItemSnippetThumbnail implements Serializable {
    @SerializedName("default")
    private
    YouTubeItemThumbnailDefault youTubeItemThumbnailDefault;

    @SerializedName("medium")
    private
    YouTubeItemThumbnailMedium youTubeItemThumbnailMedium;

    @SerializedName("high")
    private
    YouTubeItemThumbnailHigh youTubeItemThumbnailHigh;

    public YouTubeItemThumbnailDefault getYouTubeItemThumbnailDefault() {
        return youTubeItemThumbnailDefault;
    }

    public void setYouTubeItemThumbnailDefault(YouTubeItemThumbnailDefault youTubeItemThumbnailDefault) {
        this.youTubeItemThumbnailDefault = youTubeItemThumbnailDefault;
    }

    public YouTubeItemThumbnailMedium getYouTubeItemThumbnailMedium() {
        return youTubeItemThumbnailMedium;
    }

    public void setYouTubeItemThumbnailMedium(YouTubeItemThumbnailMedium youTubeItemThumbnailMedium) {
        this.youTubeItemThumbnailMedium = youTubeItemThumbnailMedium;
    }

    public YouTubeItemThumbnailHigh getYouTubeItemThumbnailHigh() {
        return youTubeItemThumbnailHigh;
    }

    public void setYouTubeItemThumbnailHigh(YouTubeItemThumbnailHigh youTubeItemThumbnailHigh) {
        this.youTubeItemThumbnailHigh = youTubeItemThumbnailHigh;
    }
}
