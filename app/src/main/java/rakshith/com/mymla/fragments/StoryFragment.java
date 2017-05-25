package rakshith.com.mymla.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

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
import rakshith.com.mymla.utils.Constants;

/**
 * Created by rakshith on 5/24/17.
 */
public class StoryFragment extends BaseFragment {

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story, container, false);
        unbinder = ButterKnife.bind(this, view);

        mActivity = getActivity();
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
        String url = Constants.BASE_URL + Constants.STORIES_URL;
        HashMap<String, String> headerMap = new HashMap<>();

        NetworkVolleyRequest storiesRequest = new NetworkVolleyRequest(NetworkVolleyRequest.RequestMethod.GET, url,
                String.class, headerMap, headerMap, new NetworkVolleyRequest.Callback() {
            @Override
            public void onSuccess(Object response) {
                Log.d("Rakshith", "response from stories api " + response);
                getStoryModel(response.toString());
                pbProgress.setVisibility(View.GONE);
                mIsRefreshing = false;
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onError(int errorCode, String errorMessage) {
                pbProgress.setVisibility(View.GONE);
                Log.d("Rakshith", "error from stories api errorMessage=== " + errorMessage + " errorCode=== " + errorCode);
            }
        }, NetworkVolleyRequest.ContentType.JSON);
        storiesRequest.execute();
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
