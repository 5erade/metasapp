package danilk.metasapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import danilk.adapters.RecyclerAdapterNews;

import com.example.danilk.metasapp.R;

import danilk.models.NewsModel;
import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseRecyclerAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;

import static android.content.ContentValues.TAG;

/**
 * Created by dan on 1/8/16.
 */
public class NewsFragment extends Fragment {



    private MainActivity appCompatActivity;
    private Toolbar toolbar;
    private CollapsingToolbarLayout newsCollapsingToolbar;
    private FirebaseRecyclerAdapter mAdapter;
    private ImageView header;



    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        appCompatActivity = (MainActivity)activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_collapsing_toolbar, container, false);

        toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        setupToolbar();

        newsCollapsingToolbar = (CollapsingToolbarLayout)view.findViewById(R.id.collapsing_toolbar);
        newsCollapsingToolbar.setTitle(getString(R.string.collapsing_toolbar_fragment_title));
        newsCollapsingToolbar.setExpandedTitleTextAppearance(R.style.CustomToolbar);

        header = (ImageView)view.findViewById(R.id.flexible_image);
        Glide
                .with(getActivity())
                .load(R.drawable.background_2017)
                .crossFade()
                .into(header);

        RecyclerView recycler = (RecyclerView)view.findViewById(R.id.recycler_view);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(appCompatActivity));


        Firebase ref = new Firebase("https://metasprogramapp.firebaseio.com/news");
        ref.keepSynced(true);


        mAdapter = new FirebaseRecyclerAdapter<NewsModel, RecyclerAdapterNews.ViewHolder>(NewsModel.class, R.layout.recycler_news,  RecyclerAdapterNews.ViewHolder.class, ref) {
        @Override
            public void populateViewHolder(RecyclerAdapterNews.ViewHolder news, NewsModel model,int position) {
                news.titleNews.setText(model.getTitleNews());
                news.contentNews.setText(model.getContentNews());
                news.linkNews.setText(model.getLinkNews());
            }
        };
        recycler.setAdapter(mAdapter);

        FirebaseAnalytics mFirebaseAnalytics;
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(getActivity());
        Bundle params = new Bundle();
        params.putString("image_name", "hi");
        params.putString("full_text", TAG);
        mFirebaseAnalytics.logEvent("Map_Fragment", params);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAdapter.cleanup();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        appCompatActivity.setupNavigationDrawer(toolbar);
    }

    private void setupToolbar(){
        toolbar.setTitle("");
        appCompatActivity.setSupportActionBar(toolbar);
    }



}