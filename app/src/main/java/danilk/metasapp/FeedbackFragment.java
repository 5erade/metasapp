package danilk.metasapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.danilk.metasapp.R;
import com.google.firebase.analytics.FirebaseAnalytics;


/**
 * Created by dan on 1/26/16.
 */
public class FeedbackFragment extends Fragment {

    private MainActivity mainActivity;
    private Toolbar toolbar;
    Context context;
    private CardView cardView;
    TextView text;
    FirebaseAnalytics mFirebaseAnalytics;

    private final String TAG = "Feedback Fragment";

    public FeedbackFragment() {
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
        View view =  inflater.inflate(R.layout.feedback_fragment_layout, container, false);
        context = view.getContext();

        toolbar = (Toolbar)view.findViewById(R.id.feedback_toolbar);
        setupToolbar();

        text = (TextView)view.findViewById(R.id.textView);
        text.setText("We'd like to get your feedback on this app. \nThe more details you can provide, the better -Metas Center");
        cardView = (CardView)view.findViewById(R.id.feed_card);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dialog = new Intent(context, DoorbellDialogActivity.class);
                startActivity(dialog);

            }
        });


        mFirebaseAnalytics = FirebaseAnalytics.getInstance(getActivity());
        Bundle params = new Bundle();
        params.putString("image_name", "hi");
        params.putString("full_text", TAG);
        mFirebaseAnalytics.logEvent("Feedback_Fragment", params);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainActivity.setupNavigationDrawer(toolbar);
    }

    private void setupToolbar(){
        toolbar.setTitle("Feedback");
        mainActivity.setSupportActionBar(toolbar);
    }




}
