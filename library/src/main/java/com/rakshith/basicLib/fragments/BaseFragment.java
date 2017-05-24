package com.rakshith.basicLib.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;

import com.rakshith.basicLib.interfaces.FragmentCallbacks;

public class BaseFragment extends Fragment {

    public FragmentCallbacks fragmentCallbacks;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onAttachToContext(context);
    }

    protected void onAttachToContext(Context context) {
        if (context instanceof FragmentCallbacks) {
            fragmentCallbacks = (FragmentCallbacks) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            onAttachToContext(activity);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentCallbacks = null;
    }
}

