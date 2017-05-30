package rakshith.com.mymla.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by rakshith on 5/30/17.
 */
public class YouTubeItemThumbnailHigh implements Serializable {
    @SerializedName("url")
    private
    String thumbnailHighUrl;

    @SerializedName("width")
    private
    String thumbnailHighWidth;

    @SerializedName("height")
    private
    String thumbnailHighHeight;

    public String getThumbnailHighUrl() {
        return thumbnailHighUrl;
    }

    public void setThumbnailHighUrl(String thumbnailHighUrl) {
        this.thumbnailHighUrl = thumbnailHighUrl;
    }

    public String getThumbnailHighWidth() {
        return thumbnailHighWidth;
    }

    public void setThumbnailHighWidth(String thumbnailHighWidth) {
        this.thumbnailHighWidth = thumbnailHighWidth;
    }

    public String getThumbnailHighHeight() {
        return thumbnailHighHeight;
    }

    public void setThumbnailHighHeight(String thumbnailHighHeight) {
        this.thumbnailHighHeight = thumbnailHighHeight;
    }
}
