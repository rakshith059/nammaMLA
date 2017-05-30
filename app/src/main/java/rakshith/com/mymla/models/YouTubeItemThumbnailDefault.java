package rakshith.com.mymla.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by rakshith on 5/30/17.
 */
public class YouTubeItemThumbnailDefault implements Serializable {
    @SerializedName("url")
    private
    String thumbnailDefaultUrl;

    @SerializedName("width")
    private
    String thumbnailDefaultWidth;

    @SerializedName("height")
    private
    String thumbnailDefaultHeight;

    public String getThumbnailDefaultUrl() {
        return thumbnailDefaultUrl;
    }

    public void setThumbnailDefaultUrl(String thumbnailDefaultUrl) {
        this.thumbnailDefaultUrl = thumbnailDefaultUrl;
    }

    public String getThumbnailDefaultWidth() {
        return thumbnailDefaultWidth;
    }

    public void setThumbnailDefaultWidth(String thumbnailDefaultWidth) {
        this.thumbnailDefaultWidth = thumbnailDefaultWidth;
    }

    public String getThumbnailDefaultHeight() {
        return thumbnailDefaultHeight;
    }

    public void setThumbnailDefaultHeight(String thumbnailDefaultHeight) {
        this.thumbnailDefaultHeight = thumbnailDefaultHeight;
    }
}
