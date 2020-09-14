package co.ke.bsl.ui.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;

import co.ke.bsl.R;
import co.ke.bsl.ui.common.DashboardActivity;


public class AboutActivity extends DashboardActivity {

    /**
     * onCreate
     *
     * Called when the activity is first created.
     * This is where you should do all of your normal static set up: create views, bind data to lists, etc.
     * This method also provides you with a Bundle containing the activity's previously frozen state, if there was one.
     *
     * Always followed by onStart().
     *
     * @param savedInstanceState Bundle
     */

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView (R.layout.activity_about);

        // Tell the user something about the current display configuration.

        Configuration c = getResources ().getConfiguration ();
        int size = c.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        //boolean isLarge = (size == Configuration.SCREENLAYOUT_SIZE_LARGE);
        //boolean isXLarge = (size == Configuration.SCREENLAYOUT_SIZE_XLARGE);
        //boolean addFrame = isLarge || isXLarge;

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        StringBuilder sb = new StringBuilder ();
        sb.append ("Screen: ");
        sb.append (size);
        sb.append (" density: ");
        sb.append (metrics.density);
        sb.append (" densityDpi:");
        sb.append (metrics.densityDpi);
        sb.append (" w:");
        sb.append (metrics.widthPixels);
        sb.append (" h:");
        sb.append (metrics.heightPixels);
        trace (sb.toString ());

    }

    private void trace(String toString) {
    }
}
