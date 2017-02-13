package danilk.metasapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import danilk.algorithms.ScaleImageView;

import com.example.danilk.metasapp.R;
import com.google.firebase.analytics.FirebaseAnalytics;

import danilk.adapters.ViewPagerAdapterMap;


/**
 * Created by dan on 1/15/16.
 */
public class MapFragment extends Fragment {


    private MainActivity mainActivity;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mainActivity = (MainActivity) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab, container, false);

        toolbar = (Toolbar) view.findViewById(R.id.tab_toolbar);
        setupToolbar();

        viewPager = (ViewPager) view.findViewById(R.id.tab_view_pager);
        setupViewPager();

        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        setupTab();

        return view;
    }

    private void setupTab() {
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager() {
        viewPager.setAdapter(new ViewPagerAdapterMap(getChildFragmentManager()));
    }

    private void setupToolbar() {
        toolbar.setTitle(getString(R.string.map_fragment_title));
        mainActivity.setSupportActionBar(toolbar);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainActivity.setupNavigationDrawer(toolbar);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static class BuildingsAlgFragment extends Fragment {

        private final String TAG = "Buildings Fragment";
        FirebaseAnalytics mFirebaseAnalytics;


        public BuildingsAlgFragment() {
            //empty constructor
        }


        public static BuildingsAlgFragment newInstance(String title) {
            BuildingsAlgFragment fragmentFirst = new BuildingsAlgFragment();
            Bundle args = new Bundle();
            // args.putInt("someInt", page);
            args.putString("someTitle", title);
            fragmentFirst.setArguments(args);
            return fragmentFirst;
        }

        @SuppressLint("ValidFragment")
        // PhotoViewAttacher mAttacher;

        private Context context;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.buildings_fragment_alg, container, false);

            ImageView studentCenter = (ImageView) view.findViewById(R.id.student_center);
            Glide
                    .with(getActivity())
                    .load(R.drawable.rsz_dsc_1122)
                    .crossFade()
                    .into(studentCenter);
            //studentCenter.setImageBitmap(ImageDecode.decodeResource(getResources(), R.drawable.rsz_student_center));

            mFirebaseAnalytics = FirebaseAnalytics.getInstance(getActivity());
            Bundle params = new Bundle();
            params.putString("image_name", "hi");
            params.putString("full_text", TAG);
            mFirebaseAnalytics.logEvent("Building_Fragment", params);


            return view;
        }



    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static class MapTabFragment extends Fragment {

        private final String TAG = "Map Fragment";
        FirebaseAnalytics mFirebaseAnalytics;

        public MapTabFragment() {
            //empty constructor
        }

        public static MapTabFragment newInstance(String title) {
            MapTabFragment fragmentFirst = new MapTabFragment();
            Bundle args = new Bundle();
            // args.putInt("someInt", page);
            args.putString("someTitle", title);
            fragmentFirst.setArguments(args);
            return fragmentFirst;
        }

        @SuppressLint("ValidFragment")
       // PhotoViewAttacher mAttacher;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.map_layout, container, false);
            ScaleImageView image = (ScaleImageView) view.findViewById(R.id.image);
            image.setImageResource(R.drawable.rsz_map);




            mFirebaseAnalytics = FirebaseAnalytics.getInstance(getActivity());
            Bundle params = new Bundle();
            params.putString("image_name", "hi");
            params.putString("full_text", TAG);
            mFirebaseAnalytics.logEvent("Map_Fragment", params);
           return view;
        }


    }
//////////////////////////////////////////////////////////////////////////////////////////////

}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////