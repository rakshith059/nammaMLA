package rakshith.com.mymla.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.rakshith.basicLib.activities.BaseActivity;
import com.rakshith.basicLib.interfaces.FragmentCallbacks;
import com.rakshith.basicLib.utils.NetworkVolleyRequest;
import com.rakshith.basicLib.widgets.TelephonyInfo;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import rakshith.com.mymla.R;
import rakshith.com.mymla.fragments.HomeFragment;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentCallbacks {

    private static final int REQUEST_READ_PHONE_STATE = 1000;

    AppCompatActivity mActivity;
    ArrayList<Fragment> mFragmentList = new ArrayList<>();
    Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mActivity = this;

        setHomeScreen();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("name", "rakshith");
                    jsonObject.put("password", "rakshith");

                    HashMap<String, String> request = new HashMap<String, String>();
                    request.put("body", jsonObject.toString());

                    NetworkVolleyRequest loginRequest = new NetworkVolleyRequest(NetworkVolleyRequest.RequestMethod.POST,
                            "http://achan.in/api/login", String.class, new HashMap<String, String>(), request,
                            new NetworkVolleyRequest.Callback() {
                                @Override
                                public void onSuccess(Object response) {
                                    Log.d("Rakshith", response.toString());
                                }

                                @Override
                                public void onError(int errorCode, String errorMessage) {

                                }
                            }, NetworkVolleyRequest.ContentType.JSON);
                    loginRequest.execute();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
////                if (isNetworkAvailable(MainActivity.this))
////                    Snackbar.make(view, "internet is present", Snackbar.LENGTH_LONG)
////                            .setAction("Action", null).show();
////                else {
////                    Snackbar.make(view, "Internet is not present", Snackbar.LENGTH_LONG)
////                            .setAction("Action", null).show();
////                }
//
////                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE);
////
////                if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
////                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_READ_PHONE_STATE);
////                } else {
////                    isDualSimOrNot();
////                }
//
//                showAlertDialog("title", "message", "ok", "cancel", new ConformationDialogInterface() {
//                    @Override
//                    public void positiveBtnClick() {
//                        String deviceId = getDeviceId();
//                        Snackbar.make(view, "internet is present " + deviceId, Snackbar.LENGTH_LONG)
//                                .setAction("Action", null).show();
//                    }
//
//                    @Override
//                    public void negativeBtnClick() {
//                        Snackbar.make(view, "internet is not present", Snackbar.LENGTH_LONG)
//                                .setAction("Action", null).show();
//                    }
//                });
//
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setHomeScreen() {
        if (getmFragment() == null) {
            addFragment(HomeFragment.newInstance(), null);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_READ_PHONE_STATE:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    isDualSimOrNot();
                }
                break;

            default:
                break;
        }
    }

    private void isDualSimOrNot() {
        TelephonyInfo telephonyInfo = TelephonyInfo.getInstance(this);

        String imeiSIM1 = telephonyInfo.getImeiSIM1();
        String imeiSIM2 = telephonyInfo.getImeiSIM2();

        boolean isSIM1Ready = telephonyInfo.isSIM1Ready();
        boolean isSIM2Ready = telephonyInfo.isSIM2Ready();

        boolean isDualSIM = telephonyInfo.isDualSIM();
        Log.i("Dual = ", " IME1 : " + imeiSIM1 + "\n" +
                " IME2 : " + imeiSIM2 + "\n" +
                " IS DUAL SIM : " + isDualSIM + "\n" +
                " IS SIM1 READY : " + isSIM1Ready + "\n" +
                " IS SIM2 READY : " + isSIM2Ready + "\n");

        TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        String number = tm.getLine1Number();
        Log.d("Rakshith", number);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            setHomeScreen();
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void addFragment(Fragment fragment, String mBackStack) {
        if (mActivity == null) {
            return;
        }
        mFragmentList.add(fragment);

        FragmentTransaction fragmentTransaction = mActivity.getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.home_container, fragment);

        if (mBackStack != null) {
            fragmentTransaction.addToBackStack(mBackStack);
        }

        mFragment = fragment;
        fragmentTransaction.commit();
    }

    @Override
    public void replaceFragment(Fragment fragment, String mBackStack) {
        if (mActivity == null) {
            return;
        }
        mFragmentList.add(fragment);

        FragmentTransaction fragmentTransaction = mActivity.getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.home_container, fragment);

        if (mBackStack != null) {
            fragmentTransaction.addToBackStack(mBackStack);
        }

        mFragment = fragment;
        fragmentTransaction.commit();
    }

    @Override
    public Fragment getmFragment() {
        if (mFragmentList.size() > 0) {
            return mFragmentList.get(mFragmentList.size() - 1);
        }
        return null;
    }

    @Override
    public void popCurrentFragment() {
        if (mFragmentList.size() > 0) {
            mFragmentList.remove(mFragmentList.size() - 1);
            if (mFragmentList.size() > 0) {
                mFragmentList.remove(mFragmentList.size() - 1);
            }
        }
        mActivity.getFragmentManager().popBackStack();
    }
}
