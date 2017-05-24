package com.rakshith.basicLib.interfaces;

import android.app.Fragment;

/**
 * Created by rakshith on 3/7/17.
 */
public interface FragmentCallbacks {

    public void addFragment(Fragment fragment, String mBackStack);

    public void replaceFragment(Fragment fragment, String mBackStack);

    public Fragment getmFragment();

    public void popCurrentFragment();
}
