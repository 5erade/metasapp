package danilk.metasapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.danilk.metasapp.R;
import com.google.firebase.analytics.FirebaseAnalytics;


/**
 * Created by dan on 1/25/16.
 */
public class LeadershipFragment extends Fragment {


    private MainActivity mainActivity;
    private Toolbar toolbar;
    FirebaseAnalytics mFirebaseAnalytics;

    private final String TAG = "Leadership Fragment";


    public LeadershipFragment() {
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
        View view =  inflater.inflate(R.layout.leadership_fragment_layout, container, false);

        toolbar = (Toolbar)view.findViewById(R.id.leadership_toolbar);
        setupToolbar();

        ImageView president = (ImageView) view.findViewById(R.id.image_president);
        Glide
                .with(getActivity())
                .load(R.drawable.robert_circle)
                .crossFade()
                .into(president);
        //president.setImageBitmap(ImageDecode.decodeResource(getResources(), R.drawable.breland_circle));

        ImageView vicePresidentAcademicAffairs = (ImageView) view.findViewById(R.id.image_vice_president_academic_affairs);
        Glide
                .with(getActivity())
                .load(R.drawable.alex_circle)
                .crossFade()
                .into(vicePresidentAcademicAffairs);
        //vicePresidentAcademicAffairs.setImageBitmap(ImageDecode.decodeResource(getResources(), R.drawable.duncan_circle));

        ImageView vicePresidentStudentAffairs = (ImageView) view.findViewById(R.id.image_vice_president_student_affairs);
        Glide
                .with(getActivity())
                .load(R.drawable.liz_circle)
                .crossFade()
                .into(vicePresidentStudentAffairs);
        //vicePresidentStudentAffairs.setImageBitmap(ImageDecode.decodeResource(getResources(), R.drawable.roland_circle));

        ImageView vicePresidentAdmn = (ImageView) view.findViewById(R.id.image_vice_president_admn);
        Glide
                .with(getActivity())
                .load(R.drawable.angela_circle)
                .crossFade()
                .into(vicePresidentAdmn);
        //vicePresidentAdmn.setImageBitmap(ImageDecode.decodeResource(getResources(), R.drawable.escobar_circle));



        mFirebaseAnalytics = FirebaseAnalytics.getInstance(getActivity());
        Bundle params = new Bundle();
        params.putString("image_name", "hi");
        params.putString("full_text", TAG);
        mFirebaseAnalytics.logEvent("Leadership_Fragment", params);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainActivity.setupNavigationDrawer(toolbar);
    }

    private void setupToolbar(){
        toolbar.setTitle("Leadership");
        mainActivity.setSupportActionBar(toolbar);
    }


}