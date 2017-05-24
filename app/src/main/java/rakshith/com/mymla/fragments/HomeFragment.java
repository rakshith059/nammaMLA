package rakshith.com.mymla.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rakshith.basicLib.fragments.BaseFragment;

import rakshith.com.mymla.R;
import rakshith.com.mymla.adapters.HomePagerAdapter;

/**
 * Created by rakshith on 5/24/17.
 */
public class HomeFragment extends BaseFragment {

    ViewPager vpHomePager;
    TabLayout tlHomePagerTabs;
    HomePagerAdapter homePagerAdapter;

    public static HomeFragment newInstance() {
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        vpHomePager = (ViewPager) getView().findViewById(R.id.fragment_home_vp_home);
        tlHomePagerTabs = (TabLayout) getView().findViewById(R.id.fragment_home_tl_home);

        setUpViewPager(vpHomePager);
        tlHomePagerTabs.setupWithViewPager(vpHomePager);
    }

    private void setUpViewPager(ViewPager vpHomePager) {
        homePagerAdapter = new HomePagerAdapter(getChildFragmentManager());

        homePagerAdapter.addFragment(new StoryFragment(), getResources().getString(R.string.home), new Bundle());
        homePagerAdapter.addFragment(new StoryFragment(), getResources().getString(R.string.story), new Bundle());
        homePagerAdapter.addFragment(new StoryFragment(), getResources().getString(R.string.home), new Bundle());
        homePagerAdapter.addFragment(new StoryFragment(), getResources().getString(R.string.story), new Bundle());
        homePagerAdapter.addFragment(new StoryFragment(), getResources().getString(R.string.home), new Bundle());

        vpHomePager.setAdapter(homePagerAdapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        homePagerAdapter = null;
    }
}
