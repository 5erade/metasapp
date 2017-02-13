package danilk.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import danilk.metasapp.MapFragment;

/**
 * Created by dan on 1/15/16.
 */
public class ViewPagerAdapterMap extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 2;
    private String tabTitles[] = new String[] { "Room M-104", "Map"};


    public ViewPagerAdapterMap(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return MapFragment.BuildingsAlgFragment.newInstance("Page # 1");
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return MapFragment.MapTabFragment.newInstance("Page # 2");
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

}


