package rakshith.com.mymla.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rakshith on 5/25/17.
 */
public class StoryModel implements Parcelable {
    private String storyHeadline;
    private String storyImageUrl;
    private String storyAuthor;
    private String storyCreatedAt;

    public StoryModel(Parcel in) {
        storyHeadline = in.readString();
        storyImageUrl = in.readString();
        storyAuthor = in.readString();
        storyCreatedAt = in.readString();
    }

    public static final Creator<StoryModel> CREATOR = new Creator<StoryModel>() {
        @Override
        public StoryModel createFromParcel(Parcel in) {
            return new StoryModel(in);
        }

        @Override
        public StoryModel[] newArray(int size) {
            return new StoryModel[size];
        }
    };

    public StoryModel(String storyHeadline, String storyImageUrl, String storyAuthor, String createdAtString) {
        this.setStoryHeadline(storyHeadline);
        this.setStoryImageUrl(storyImageUrl);
        this.setStoryAuthor(storyAuthor);
        this.setStoryCreatedAt(createdAtString);
    }

    public String getStoryHeadline() {
        return storyHeadline;
    }

    public void setStoryHeadline(String storyHeadline) {
        this.storyHeadline = storyHeadline;
    }

    public String getStoryImageUrl() {
        return storyImageUrl;
    }

    public void setStoryImageUrl(String storyImageUrl) {
        this.storyImageUrl = storyImageUrl;
    }

    public String getStoryAuthor() {
        return storyAuthor;
    }

    public void setStoryAuthor(String storyAuthor) {
        this.storyAuthor = storyAuthor;
    }

    public String getStoryCreatedAt() {
        return storyCreatedAt;
    }

    public void setStoryCreatedAt(String storyCreatedAt) {
        this.storyCreatedAt = storyCreatedAt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(storyHeadline);
        dest.writeString(storyImageUrl);
        dest.writeString(storyAuthor);
        dest.writeString(storyCreatedAt);
    }
}
