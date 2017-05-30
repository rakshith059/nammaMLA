package rakshith.com.mymla.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by rakshith on 5/30/17.
 */
public class YouTubePageInfo implements Serializable {
    @SerializedName("totalResults")
    private
    int totalResults;

    @SerializedName("resultsPerPage")
    private
    int resultsPerPage;

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(int resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }
}
