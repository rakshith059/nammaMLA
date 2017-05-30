package rakshith.com.mymla.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rakshith on 5/30/17.
 */
public class YouTubeModel implements Serializable {
    @SerializedName("kind")
    private
    String kind;

    @SerializedName("etag")
    private
    String eTag;

    @SerializedName("regionCode")
    private
    String regionCode;

    @SerializedName("pageInfo")
    private
    YouTubePageInfo youTubePageInfo;

    @SerializedName("items")
    private
    List<YouTubeItems> youTubeItemsList;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String geteTag() {
        return eTag;
    }

    public void seteTag(String eTag) {
        this.eTag = eTag;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public YouTubePageInfo getYouTubePageInfo() {
        return youTubePageInfo;
    }

    public void setYouTubePageInfo(YouTubePageInfo youTubePageInfo) {
        this.youTubePageInfo = youTubePageInfo;
    }

    public List<YouTubeItems> getYouTubeItemsList() {
        return youTubeItemsList;
    }

    public void setYouTubeItemsList(List<YouTubeItems> youTubeItemsList) {
        this.youTubeItemsList = youTubeItemsList;
    }
}
