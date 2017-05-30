package rakshith.com.mymla.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.google.android.youtube.player.YouTubeApiServiceUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rakshith.basicLib.activities.BaseActivity;
import com.rakshith.basicLib.fragments.BaseFragment;
import com.rakshith.basicLib.utils.NetworkVolleyRequest;
import com.rakshith.basicLib.utils.RecyclerItemDecorator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rakshith.com.mymla.R;
import rakshith.com.mymla.adapters.StoriesListAdapter;
import rakshith.com.mymla.models.StoryModel;
import rakshith.com.mymla.models.YouTubeItems;
import rakshith.com.mymla.models.YouTubeModel;


/**
 * Created by rakshith on 5/30/17.
 */
public class VideoFragment extends BaseFragment {
    private static final String STORY_HEADLINE = "headline";
    private static final String STORY_AUTHOR = "author-name";
    private static final String STORY_IMAGE_URL = "hero-image-s3-key";
    private static final String STORY_CREATED_AT = "published-at";

    Unbinder unbinder;

    @BindView(R.id.fragment_story_ll_main_container)
    LinearLayout llMainContainer;
    @BindView(R.id.fragment_story_pb_progress)
    ProgressBar pbProgress;
    @BindView(R.id.fragment_story_ll_no_stories)
    LinearLayout llNoStories;
    @BindView(R.id.fragment_story_rv_list)
    RecyclerView rvHomeStories;
    @BindView(R.id.fragment_story_swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;
    private boolean mIsRefreshing = false;

    Activity mActivity;
    StoriesListAdapter storiesListAdapter;
    String youtube_url;

    Gson gson;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story, container, false);
        unbinder = ButterKnife.bind(this, view);

        mActivity = getActivity();
        if (mActivity != null)
            youtube_url = "https://www.googleapis.com/youtube/v3/search?key=" + mActivity.getResources().getString(R.string.youtube_key)
                    + "&channelId=" + mActivity.getResources().getString(R.string.channel_id) + "&part=snippet,id&order=date&maxResults=20";

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("dd/MM/yy hh:mm:a");
        gson = gsonBuilder.create();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvHomeStories.addItemDecoration(new RecyclerItemDecorator(true, 0, 10, 0, 10));
        rvHomeStories.setLayoutManager(layoutManager);

        rvHomeStories.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mIsRefreshing;
            }
        });

        pbProgress.setVisibility(View.VISIBLE);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mIsRefreshing = true;
                storiesListAdapter = null;
                loadStoriesIfInternetAvailable();
            }
        });
        loadStoriesIfInternetAvailable();
    }

    private void loadStoriesIfInternetAvailable() {
        if (((BaseActivity) getActivity()).isNetworkAvailable(mActivity)) {
            loadStories();
        } else {
            swipeRefreshLayout.setRefreshing(false);
            pbProgress.setVisibility(View.GONE);
            llNoStories.setVisibility(View.VISIBLE);
            Snackbar.make(llMainContainer, getResources().getString(R.string.no_internet), Snackbar.LENGTH_LONG).show();
        }
    }

    private void loadStories() {
        if (!TextUtils.isEmpty(youtube_url)) {
            NetworkVolleyRequest youTubeRequest = new NetworkVolleyRequest(NetworkVolleyRequest.RequestMethod.GET,
                    youtube_url
                    , String.class, new HashMap<>(), new HashMap<>(), new NetworkVolleyRequest.Callback() {
                @Override
                public void onSuccess(Object response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.toString());
                        JSONArray jsonArray = jsonObject.getJSONArray("items");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                            YouTubeItems youTubeItems = gson.fromJson(jsonObject1.toString(), YouTubeItems.class);
                            Log.d("Rakshith", "youtube response == " + response.toString());
                            Log.d("Rakshith", "youtube youTubeItems == " + youTubeItems.toString());
                            Log.d("Rakshith", "youtube videoId == " + youTubeItems.getYouTubeItemId().getYoutubeItemIdVideoId());
                            Log.d("Rakshith", "youtube title == " + youTubeItems.getYouTubeItemSnippet().getYoutubeItemTitle());
                            Log.d("Rakshith", "youtube channel title == " + youTubeItems.getYouTubeItemSnippet().getYoutubeItemChannelTitle());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onError(int errorCode, String errorMessage) {
                    Log.d("Rakshith", "youtube error response == " + errorMessage);
                }
            }, NetworkVolleyRequest.ContentType.JSON);

            youTubeRequest.execute();
        }
    }

    private void getStoryModel(String storyResponse) {
        ArrayList<StoryModel> storiesList = new ArrayList<>();

        try {
            JSONObject storiesObject = new JSONObject(storyResponse);
            JSONArray storiesArray = storiesObject.getJSONArray("stories");
            for (int i = 0; i < storiesArray.length(); i++) {
                JSONObject jsonStoryObject = storiesArray.getJSONObject(i);

                String storyHeadline = jsonStoryObject.getString(STORY_HEADLINE);
                String storyImageUrl = jsonStoryObject.getString(STORY_IMAGE_URL);
                String storyAuthor = jsonStoryObject.getString(STORY_AUTHOR);
                Long storyCreatedAt = jsonStoryObject.getLong(STORY_CREATED_AT);

                String createdAtString = new SimpleDateFormat("MM/dd/yyyy").format(new Date(storyCreatedAt));
                StoryModel storyModel = new StoryModel(storyHeadline, storyImageUrl, storyAuthor, createdAtString);
                storiesList.add(storyModel);
            }

            storiesListAdapter = new StoriesListAdapter(mActivity, storiesList, fragmentCallbacks);
            rvHomeStories.setAdapter(storiesListAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}