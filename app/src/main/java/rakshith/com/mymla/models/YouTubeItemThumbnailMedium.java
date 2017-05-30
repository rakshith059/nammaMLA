package rakshith.com.mymla.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by rakshith on 5/30/17.
 */
public class YouTubeItemThumbnailMedium implements Serializable{
    @SerializedName("url")
    private
    String thumbnailMediumUrl;

    @SerializedName("width")
    private
    String thumbnailMediumWidth;

    @SerializedName("height")
    private
    String thumbnailMediumHeight;

    public String getThumbnailMediumUrl() {
        return thumbnailMediumUrl;
    }

    public void setThumbnailMediumUrl(String thumbnailMediumUrl) {
        this.thumbnailMediumUrl = thumbnailMediumUrl;
    }

    public String getThumbnailMediumWidth() {
        return thumbnailMediumWidth;
    }

    public void setThumbnailMediumWidth(String thumbnailMediumWidth) {
        this.thumbnailMediumWidth = thumbnailMediumWidth;
    }

    public String getThumbnailMediumHeight() {
        return thumbnailMediumHeight;
    }

    public void setThumbnailMediumHeight(String thumbnailMediumHeight) {
        this.thumbnailMediumHeight = thumbnailMediumHeight;
    }
}
