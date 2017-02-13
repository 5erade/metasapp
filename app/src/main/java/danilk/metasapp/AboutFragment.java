package danilk.metasapp;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.danilk.metasapp.R;
import com.google.firebase.analytics.FirebaseAnalytics;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {


    private MainActivity mainActivity;
    private Toolbar toolbar;
    FirebaseAnalytics mFirebaseAnalytics;

    private final String TAG = "About Fragment";

    public AboutFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mainActivity = (MainActivity)activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_about, container, false);

        toolbar = (Toolbar)view.findViewById(R.id.about_toolbar);
        setupToolbar();

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(getActivity());
        Bundle params = new Bundle();
        params.putString("image_name", "hi");
        params.putString("full_text", TAG);
        mFirebaseAnalytics.logEvent("About_Fragment", params);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainActivity.setupNavigationDrawer(toolbar);
    }

    private void setupToolbar(){
        toolbar.setTitle(getString(R.string.about_fragment_title));
        mainActivity.setSupportActionBar(toolbar);
    }


}
