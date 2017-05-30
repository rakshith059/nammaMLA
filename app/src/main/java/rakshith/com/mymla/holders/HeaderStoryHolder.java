package rakshith.com.mymla.holders;

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
import butterknife.Unbinder;
import rakshith.com.mymla.R;
import rakshith.com.mymla.models.StoryModel;
import rakshith.com.mymla.utils.Constants;

/**
 * Created by rakshith on 5/26/17.
 */
public class HeaderStoryHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.story_header_iv_story_icon)
    ImageView ivStoryIcon;
    @BindView(R.id.story_header_tv_story_headline)
    TextView tvStoryHeadline;

    public HeaderStoryHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public static RecyclerView.ViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_header, parent, false);
        return new HeaderStoryHolder(view);
    }

    public void bind(StoryModel storyItem, int position) {
        if (storyItem != null) {
            String imageUrl = Constants.IMAGE_BASE_URL + storyItem.getStoryImageUrl();
            if (!TextUtils.isEmpty(imageUrl))
                AppController
                        .getInstance()
                        .getImageLoader()
                        .get(imageUrl,
                                ImageLoader.getImageListener(ivStoryIcon, R.color.cardview_shadow_start_color, R.color.black));

            String headline = storyItem.getStoryHeadline();
            if (!TextUtils.isEmpty(headline)) {
                tvStoryHeadline.setText(Html.fromHtml(headline));
            }
        }
    }
}
