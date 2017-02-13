package danilk.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import danilk.metasapp.WorkshopsStaticFragment;

/**
 * Created by danil on 10/8/16.
 */

public class ViewPagerAdapterWorkshopsStatic extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 5;
    private String tabTitles[] = new String[] { "MATH", "CHEM", "BIO", "PHYSICS", "ETH STUDIES"};


    public ViewPagerAdapterWorkshopsStatic(FragmentManager fragmentManager) {
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
                return WorkshopsStaticFragment.MathFragment.newInstance("Page # 1");
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return WorkshopsStaticFragment.ChemFragment.newInstance("Page # 2");
            case 2:
                return WorkshopsStaticFragment.BioFragment.newInstance("Page # 3");
            case 3:
                return WorkshopsStaticFragment.PhysicsFragment.newInstance("Page # 4");
            case 4:
                return WorkshopsStaticFragment.EthStudFragment.newInstance("Page # 5");
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
