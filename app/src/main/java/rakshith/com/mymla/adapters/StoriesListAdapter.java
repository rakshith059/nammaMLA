package rakshith.com.mymla.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.rakshith.basicLib.interfaces.FragmentCallbacks;

import java.util.ArrayList;
import java.util.List;

import rakshith.com.mymla.holders.ChildStoryHolder;
import rakshith.com.mymla.holders.HeaderStoryHolder;
import rakshith.com.mymla.models.StoryModel;

/**
 * Created by rakshith on 5/25/17.
 */
public class StoriesListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    FragmentCallbacks mFragmentCallbacks;
    Activity mActivity;
    List<StoryModel> storyList;

    public StoriesListAdapter(Activity mActivity, ArrayList<StoryModel> storiesList, FragmentCallbacks fragmentCallbacks) {
        this.mActivity = mActivity;
        this.storyList = storiesList;
        this.mFragmentCallbacks = fragmentCallbacks;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        if (position == 0) {
            return HeaderStoryHolder.create(parent);
        } else
//            return HeaderStoryHolder.create(parent);
            return ChildStoryHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        StoryModel storyItem = storyList.get(position);
        if (holder instanceof HeaderStoryHolder) {
            ((HeaderStoryHolder) holder).bind(storyItem, position);
        } else ((ChildStoryHolder) holder).bind(storyItem, position);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        if (storyList == null || storyList.size() < 0)
            return 0;
        return storyList.size();
    }
}
