package rakshith.com.mymla.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by rakshith on 5/30/17.
 */
public class YouTubeItemSnippet implements Serializable{
    @SerializedName("publishedAt")
    private
    String youtubeItemPublishedAt;

    @SerializedName("channelId")
    private
    String youtubeItemChannelId;

    @SerializedName("title")
    private
    String youtubeItemTitle;

    @SerializedName("description")
    private
    String youtubeItemDescription;

    @SerializedName("thumbnails")
    private
    YouTubeItemSnippetThumbnail youtubeItemThumbnails;

    @SerializedName("channelTitle")
    private
    String youtubeItemChannelTitle;

    @SerializedName("liveBroadcastContent")
    private
    String youtubeItemLiveBroadcastContent;

    public String getYoutubeItemPublishedAt() {
        return youtubeItemPublishedAt;
    }

    public void setYoutubeItemPublishedAt(String youtubeItemPublishedAt) {
        this.youtubeItemPublishedAt = youtubeItemPublishedAt;
    }

    public String getYoutubeItemChannelId() {
        return youtubeItemChannelId;
    }

    public void setYoutubeItemChannelId(String youtubeItemChannelId) {
        this.youtubeItemChannelId = youtubeItemChannelId;
    }

    public String getYoutubeItemTitle() {
        return youtubeItemTitle;
    }

    public void setYoutubeItemTitle(String youtubeItemTitle) {
        this.youtubeItemTitle = youtubeItemTitle;
    }

    public String getYoutubeItemDescription() {
        return youtubeItemDescription;
    }

    public void setYoutubeItemDescription(String youtubeItemDescription) {
        this.youtubeItemDescription = youtubeItemDescription;
    }

    public YouTubeItemSnippetThumbnail getYoutubeItemThumbnails() {
        return youtubeItemThumbnails;
    }

    public void setYoutubeItemThumbnails(YouTubeItemSnippetThumbnail youtubeItemThumbnails) {
        this.youtubeItemThumbnails = youtubeItemThumbnails;
    }

    public String getYoutubeItemChannelTitle() {
        return youtubeItemChannelTitle;
    }

    public void setYoutubeItemChannelTitle(String youtubeItemChannelTitle) {
        this.youtubeItemChannelTitle = youtubeItemChannelTitle;
    }

    public String getYoutubeItemLiveBroadcastContent() {
        return youtubeItemLiveBroadcastContent;
    }

    public void setYoutubeItemLiveBroadcastContent(String youtubeItemLiveBroadcastContent) {
        this.youtubeItemLiveBroadcastContent = youtubeItemLiveBroadcastContent;
    }
}
