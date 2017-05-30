package rakshith.com.mymla.holders;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.rakshith.basicLib.utils.AppController;

import butterknife.BindView;
import butterknife.ButterKnife;
import rakshith.com.mymla.R;
import rakshith.com.mymla.models.StoryModel;
import rakshith.com.mymla.utils.Constants;

/**
 * Created by rakshith on 5/27/17.
 */
public class ChildStoryHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.story_child_iv_story_image)
    ImageView ivChildStoryImage;
    @BindView(R.id.story_child_tv_story_headline)
    TextView tvChildStoryHeadline;

    public ChildStoryHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public static RecyclerView.ViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_child, parent, false);
        return new ChildStoryHolder(view);
    }

    public void bind(StoryModel storyItem, int position) {
        if (storyItem != null) {
            String url = Constants.IMAGE_BASE_URL + storyItem.getStoryImageUrl();
            if (!TextUtils.isEmpty(url))
                AppController
                        .getInstance()
                        .getImageLoader()
                        .get(url, ImageLoader.getImageListener(ivChildStoryImage, R.color.cardview_shadow_start_color, R.color.black));

            String headline = storyItem.getStoryHeadline();
            if (!TextUtils.isEmpty(headline)) {
                tvChildStoryHeadline.setText(Html.fromHtml(headline));
            }
        }
    }
}
