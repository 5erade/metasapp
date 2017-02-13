package danilk.metasapp;

import android.app.Activity;
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
import com.example.danilk.metasapp.R;
import com.google.firebase.analytics.FirebaseAnalytics;

import danilk.adapters.ViewPagerAdapterCollegeResources;

public class CollegeResourcesFragment extends Fragment {

    private MainActivity mainActivity;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    FirebaseAnalytics mFirebaseAnalytics;
    private final String TAG = "College Resources";



    public CollegeResourcesFragment() {
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
        View view = inflater.inflate(R.layout.fragment_student_resources, container, false);

        toolbar = (Toolbar) view.findViewById(R.id.student_resources_toolbar);
        setupToolbar();


        ImageView pltlPic = (ImageView) view.findViewById(R.id.myImageView);
        Glide
                .with(getActivity())
                .load(R.drawable.rsz_1pltlpic)
                .crossFade()
                .into(pltlPic);
//  android:src="@drawable/rsz_1pltlpic"

        ImageView siPic = (ImageView) view.findViewById(R.id.siImageView);
        Glide
                .with(getActivity())
                .load(R.drawable.rsz_sipic)
                .crossFade()
                .into(siPic);

        ImageView researchProgram = (ImageView) view.findViewById(R.id.researchProgramImageView);
        Glide
                .with(getActivity())
                .load(R.drawable.banner_research_program)
                .crossFade()
                .into(researchProgram);

        ImageView summerBridgeProgram = (ImageView) view.findViewById(R.id.summerBridgeProgramImageView);
        Glide
                .with(getActivity())
                .load(R.drawable.summer_bridge_pic)
                .crossFade()
                .into(summerBridgeProgram);

        //android:src="@drawable/rsz_sipic"



       /* viewPager = (ViewPager) view.findViewById(R.id.tab_view_pager);
        setupViewPager();

        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        setupTab();*/

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(getActivity());
        Bundle params = new Bundle();
        params.putString("image_name", "hi");
        params.putString("full_text", TAG);
        mFirebaseAnalytics.logEvent("Student_Resources_Fragment", params);

        return view;
    }

    private void setupTab() {
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager() {
        viewPager.setAdapter(new ViewPagerAdapterCollegeResources(getChildFragmentManager()));
    }

    private void setupToolbar() {
        toolbar.setTitle("Student Resources");
        mainActivity.setSupportActionBar(toolbar);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainActivity.setupNavigationDrawer(toolbar);
    }


}