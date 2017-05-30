package rakshith.com.mymla.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by rakshith on 5/30/17.
 */
public class YouTubeItems implements Serializable {
    @SerializedName("kind")
    private
    String itemKind;

    @SerializedName("etag")
    private
    String itemETag;

    @SerializedName("id")
    private
    YouTubeItemId youTubeItemId;

    @SerializedName("snippet")
    private
    YouTubeItemSnippet youTubeItemSnippet;

    public String getItemKind() {
        return itemKind;
    }

    public void setItemKind(String itemKind) {
        this.itemKind = itemKind;
    }

    public String getItemETag() {
        return itemETag;
    }

    public void setItemETag(String itemETag) {
        this.itemETag = itemETag;
    }

    public YouTubeItemId getYouTubeItemId() {
        return youTubeItemId;
    }

    public void setYouTubeItemId(YouTubeItemId youTubeItemId) {
        this.youTubeItemId = youTubeItemId;
    }

    public YouTubeItemSnippet getYouTubeItemSnippet() {
        return youTubeItemSnippet;
    }

    public void setYouTubeItemSnippet(YouTubeItemSnippet youTubeItemSnippet) {
        this.youTubeItemSnippet = youTubeItemSnippet;
    }
}
