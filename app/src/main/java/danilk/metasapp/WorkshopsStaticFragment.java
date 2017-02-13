package danilk.metasapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.example.danilk.metasapp.R;

import danilk.models.TutorsModel;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

import danilk.adapters.ViewPagerAdapterWorkshopsStatic;

import static android.content.Context.MODE_PRIVATE;


/**
 * Created by danil on 10/7/16.
 */

public class WorkshopsStaticFragment extends Fragment {

    private MainActivity mainActivity;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;




    private final String TAG = "Workshops";

    public WorkshopsStaticFragment() {
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
        View view = inflater.inflate(R.layout.workshops_static_fragment, container, false);

        toolbar = (Toolbar) view.findViewById(R.id.tab_toolbar);
        setupToolbar();

        viewPager = (ViewPager) view.findViewById(R.id.tab_view_pager);
        setupViewPager();

        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        setupTab();








        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainActivity.setupNavigationDrawer(toolbar);
    }

    private void setupTab() {
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager() {
        viewPager.setAdapter(new ViewPagerAdapterWorkshopsStatic(getChildFragmentManager()));
    }

    private void setupToolbar() {
        toolbar.setTitle(TAG);
        mainActivity.setSupportActionBar(toolbar);
    }


    public static class MathFragment extends Fragment {



        private final String TAG = "Math Fragment";


        public MathFragment() {
            //empty constructor
        }


        public static WorkshopsStaticFragment.MathFragment newInstance(String title) {
            WorkshopsStaticFragment.MathFragment fragmentFirst = new WorkshopsStaticFragment.MathFragment();
            Bundle args = new Bundle();
            // args.putInt("someInt", page);
            args.putString("someTitle", title);
            fragmentFirst.setArguments(args);
            return fragmentFirst;
        }

        @SuppressLint("ValidFragment")
        // PhotoViewAttacher mAttacher;

        private Context context;
        FirebaseAnalytics mFirebaseAnalytics;
        Switch OnOff;


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("tutorsMath/tutorsMath63"); // defines
        DatabaseReference myRefMath13 = database.getReference("tutorsMath/tutorsMath13"); // defines
        DatabaseReference myRefMath111 = database.getReference("tutorsMath/tutorsMath111"); // defines
        DatabaseReference myRefMath311 = database.getReference("tutorsMath/tutorsMath311"); // defines
        DatabaseReference myRefMath21 = database.getReference("tutorsMath/tutorsMath21"); // defines
        DatabaseReference myRefMath25 = database.getReference("tutorsMath/tutorsMath25"); // defines
        DatabaseReference myRefMath71 = database.getReference("tutorsMath/tutorsMath71"); // defines


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            final View view = inflater.inflate(R.layout.math_static_fragment, container, false);

            final TextView tutorsTextMath63 =(TextView) view.findViewById(R.id.textViewMath63Tutors);
            final TextView tutorsTextMath13 =(TextView) view.findViewById(R.id.textViewMath13Tutors);
            final TextView tutorsTextMath111 =(TextView) view.findViewById(R.id.textView2Math111Tutors);
            final TextView tutorsTextMath311 = (TextView) view.findViewById(R.id.textViewMath311Tutors);
            final TextView tutorsTextMath25 = (TextView) view.findViewById(R.id.textViewMath25Tutors);
            final TextView tutorsTextMath21 = (TextView) view.findViewById(R.id.textViewMath21Tutors);
            final TextView tutorsTextMath71 = (TextView) view.findViewById(R.id.textViewMath71Tutors);

            SharedPreferences sharedPrefs = getActivity().getSharedPreferences("metasapp", 0);

            // Math 21 Firebase
            ValueEventListener postListenerMath21 = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    tutorsTextMath21.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefMath21.addValueEventListener(postListenerMath21);

            // Math 25 Firebase
            ValueEventListener postListenerMath25 = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    tutorsTextMath25.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefMath25.addValueEventListener(postListenerMath25);


            // Math 311 Firebase
            ValueEventListener postListenerMath311 = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    tutorsTextMath311.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefMath311.addValueEventListener(postListenerMath311);


            // Math 63 Firebase
            ValueEventListener postListenerMath63 = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    tutorsTextMath63.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRef.addValueEventListener(postListenerMath63);

            // Math 111 Firebase
            ValueEventListener postListenerMath111 = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    tutorsTextMath111.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefMath111.addValueEventListener(postListenerMath111);

            // Math 111 Firebase
            ValueEventListener postListenerMath13 = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    tutorsTextMath13.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefMath13.addValueEventListener(postListenerMath13);

            // Math 71 Firebase
            ValueEventListener postListenerMath71 = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    tutorsTextMath71.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefMath71.addValueEventListener(postListenerMath71);

            mFirebaseAnalytics = FirebaseAnalytics.getInstance(getActivity());
            Bundle params = new Bundle();
            params.putString("image_name", "hi");
            params.putString("full_text", TAG);
            mFirebaseAnalytics.logEvent("Math_Workshops_Fragment", params);

            final Snackbar subscribed = Snackbar.make(container, "Subscribed!", Snackbar.LENGTH_SHORT);
            final Snackbar unsubscribed = Snackbar.make(container, "Unsubscribed!", Snackbar.LENGTH_SHORT);

            boolean Math311 = sharedPrefs.getBoolean("Math311", false);
            final Switch math311 = (Switch)view.findViewById(R.id.switch311);
            math311.setChecked(Math311);

            math311.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (math311.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("Math311");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Math311", true);
                        editor.commit();
                        subscribed.show();


                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Math311");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Math311", false);
                        editor.commit();
                        unsubscribed.show();

                    }
                }
            });

            boolean Math71 = sharedPrefs.getBoolean("Math71", false);
            final Switch math71 = (Switch)view.findViewById(R.id.switch71);
            math71.setChecked(Math71);


            math71.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (math71.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("Math71");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Math71", true);
                        editor.commit();
                        subscribed.show();


                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Math71");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Math71", false);
                        editor.commit();
                        unsubscribed.show();

                    }
                }
            });


            boolean Math21 = sharedPrefs.getBoolean("Math21", false);
            final Switch math21 = (Switch)view.findViewById(R.id.switch21);
            math21.setChecked(Math21);


            math21.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (math21.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("Math21");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Math21", true);
                        editor.commit();
                        subscribed.show();


                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Math21");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Math21", false);
                        editor.commit();
                        unsubscribed.show();

                    }
                }
            });


            boolean Math25 = sharedPrefs.getBoolean("Math25", false);
            final Switch math25 = (Switch)view.findViewById(R.id.switch25);
            math25.setChecked(Math25);


            math25.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (math25.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("Math25");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Math25", true);
                        editor.commit();
                        subscribed.show();


                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Math25");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Math25", false);
                        editor.commit();
                        unsubscribed.show();

                    }
                }
            });
            boolean Math63 = sharedPrefs.getBoolean("Math63", false);
            final Switch math63 = (Switch)view.findViewById(R.id.switch63);
            math63.setChecked(Math63);


            math63.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (math63.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("Math63");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Math63", true);
                        editor.commit();
                        subscribed.show();


                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Math63");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Math63", false);
                        editor.commit();
                        unsubscribed.show();

                    }
                }
            });




            return view;
        }


    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static class PhysicsFragment extends Fragment {

        private final String TAG = "Physics Fragment";
        private Context context;
        FirebaseAnalytics mFirebaseAnalytics;

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRefPhysics2a = database.getReference("tutorsPhysics/tutorsPhysics2a");
        DatabaseReference myRefPhysics2b = database.getReference("tutorsPhysics/tutorsPhysics2b");
        DatabaseReference myRefPhysics4a = database.getReference("tutorsPhysics/tutorsPhysics4a");
        DatabaseReference myRefPhysics4b = database.getReference("tutorsPhysics/tutorsPhysics4b");


        public PhysicsFragment() {
            //empty constructor
        }

        public static WorkshopsStaticFragment.PhysicsFragment newInstance(String title) {
            WorkshopsStaticFragment.PhysicsFragment fragmentFirst = new WorkshopsStaticFragment.PhysicsFragment();
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
            View view = inflater.inflate(R.layout.physics_static_fragment, container, false);

            final TextView tutorsTextPhysics2a =(TextView) view.findViewById(R.id.textViewTutorsPhysics2a);
            final TextView tutorsTextPhysics2b =(TextView) view.findViewById(R.id.textViewTutorsPhysics2b);
            final TextView tutorsTextPhysics4a =(TextView) view.findViewById(R.id.textViewTutorsPhysics4a);
            final TextView tutorsTextPhysics4b =(TextView) view.findViewById(R.id.textViewTutorsPhysics4b);


            ValueEventListener postListenerPhysics2b = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    tutorsTextPhysics2b.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefPhysics2b.addValueEventListener(postListenerPhysics2b);

            ValueEventListener postListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    tutorsTextPhysics2a.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefPhysics2a.addValueEventListener(postListener);

            ValueEventListener postListenerPhysics4a = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    tutorsTextPhysics4a.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefPhysics4a.addValueEventListener(postListenerPhysics4a);

            ValueEventListener postListenerPhysics4b = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    tutorsTextPhysics4b.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefPhysics4b.addValueEventListener(postListenerPhysics4b);


            final Snackbar subscribed = Snackbar.make(container, "Subscribed!", Snackbar.LENGTH_SHORT);
            final Snackbar unsubscribed = Snackbar.make(container, "Unsubscribed!", Snackbar.LENGTH_SHORT);
            SharedPreferences sharedPrefs = getActivity().getSharedPreferences("metasapp", 0);


            boolean Physics2a = sharedPrefs.getBoolean("Physics2a", false);
            final Switch phys2a = (Switch)view.findViewById(R.id.switch2a);
            phys2a.setChecked(Physics2a);


            phys2a.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (phys2a.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("Physics2a");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Physics2a", true);
                        editor.commit();
                        subscribed.show();


                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Physics2a");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Physics2a", false);
                        editor.commit();
                        unsubscribed.show();

                    }
                }
            });

            boolean Physics2b = sharedPrefs.getBoolean("Physics2b", false);
            final Switch phys2b = (Switch)view.findViewById(R.id.switch2b);
            phys2b.setChecked(Physics2b);


            phys2b.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (phys2b.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("Physics2b");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Physics2b", true);
                        editor.commit();
                        subscribed.show();


                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Physics2b");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Physics2b", false);
                        editor.commit();
                        unsubscribed.show();

                    }
                }
            });

            boolean Physics4a = sharedPrefs.getBoolean("Physics4a", false);
            final Switch phys4a = (Switch)view.findViewById(R.id.switch4a);
            phys4a.setChecked(Physics4a);


            phys4a.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (phys4a.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("Physics4a");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Physics4a", true);
                        editor.commit();
                        subscribed.show();


                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Physics4a");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Physics4a", false);
                        editor.commit();
                        unsubscribed.show();

                    }
                }
            });

            boolean Physics4b = sharedPrefs.getBoolean("Physics4b", false);
            final Switch phys4b = (Switch)view.findViewById(R.id.switch4b);
            phys4b.setChecked(Physics4b);


            phys4b.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (phys4b.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("Physics4b");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Physics4b", true);
                        editor.commit();
                        subscribed.show();


                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Physics4b");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Physics4b", false);
                        editor.commit();
                        unsubscribed.show();

                    }
                }
            });





            mFirebaseAnalytics = FirebaseAnalytics.getInstance(getActivity());
            Bundle params = new Bundle();
            params.putString("image_name", "hi");
            params.putString("full_text", TAG);
            mFirebaseAnalytics.logEvent("Physics_Workshops_Fragment", params);


            return view;
        }


    }
//////////////////////////////////////////////////////////////////////////////////////////////

    public static class BioFragment extends Fragment {

        private final String TAG = "Bio Fragment";

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRefBio4a = database.getReference("tutorsBio/tutorsBio4a");
        DatabaseReference myRefBio4b = database.getReference("tutorsBio/tutorsBio4b");
        DatabaseReference myRefBio20 = database.getReference("tutorsBio/tutorsBio20");
        DatabaseReference myRefBio21 = database.getReference("tutorsBio/tutorsBio21");

        FirebaseAnalytics mFirebaseAnalytics;


        public BioFragment() {
            //empty constructor
        }

        public static WorkshopsStaticFragment.BioFragment newInstance(String title) {
            WorkshopsStaticFragment.BioFragment fragmentFirst = new WorkshopsStaticFragment.BioFragment();
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
            View view = inflater.inflate(R.layout.bio_static_fragment, container, false);

            final TextView tutorsTextBio4a =(TextView) view.findViewById(R.id.textViewBio4aTutors);
            final TextView tutorsTextBio4b =(TextView) view.findViewById(R.id.textViewBio4bTutors);
            final TextView tutorsTextBio20 =(TextView) view.findViewById(R.id.textViewBio20Tutors);
            final TextView tutorsTextBio21 =(TextView) view.findViewById(R.id.textViewBio21Tutors);


            ValueEventListener postListenerBio21 = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    tutorsTextBio21.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefBio21.addValueEventListener(postListenerBio21);

            ValueEventListener postListenerBio20 = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    tutorsTextBio20.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefBio20.addValueEventListener(postListenerBio20);


            ValueEventListener postListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    tutorsTextBio4a.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefBio4a.addValueEventListener(postListener);


            ValueEventListener postListenerBio4b = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    tutorsTextBio4b.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefBio4b.addValueEventListener(postListenerBio4b);

            final Snackbar subscribed = Snackbar.make(container, "Subscribed!", Snackbar.LENGTH_SHORT);
            final Snackbar unsubscribed = Snackbar.make(container, "Unsubscribed!", Snackbar.LENGTH_SHORT);
            SharedPreferences sharedPrefs = getActivity().getSharedPreferences("metasapp", 0);

            boolean Bio4a = sharedPrefs.getBoolean("Bio4a", false);
            final Switch bio4a = (Switch)view.findViewById(R.id.switch4a);
            bio4a.setChecked(Bio4a);

            bio4a.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (bio4a.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("Bio4a");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Bio4a", true);
                        editor.commit();
                        subscribed.show();


                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Bio4a");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Bio4a", false);
                        editor.commit();
                        unsubscribed.show();

                    }
                }
            });

            boolean Bio4b = sharedPrefs.getBoolean("Bio4b", false);
            final Switch bio4b = (Switch)view.findViewById(R.id.switch4b);
            bio4b.setChecked(Bio4b);

            bio4b.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (bio4b.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("Bio4b");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Bio4b", true);
                        editor.commit();
                        subscribed.show();


                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Bio4b");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Bio4b", false);
                        editor.commit();
                        unsubscribed.show();

                    }
                }
            });


            boolean Bio20 = sharedPrefs.getBoolean("Bio20", false);
            final Switch bio20 = (Switch)view.findViewById(R.id.switch20);
            bio20.setChecked(Bio20);

            bio20.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (bio20.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("Bio20");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Bio20", true);
                        editor.commit();
                        subscribed.show();


                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Bio20");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Bio20", false);
                        editor.commit();
                        unsubscribed.show();

                    }
                }
            });

            boolean Bio21 = sharedPrefs.getBoolean("Bio21", false);
            final Switch bio21 = (Switch)view.findViewById(R.id.switch21);
            bio21.setChecked(Bio21);

            bio21.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (bio21.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("Bio21");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Bio21", true);
                        editor.commit();
                        subscribed.show();


                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Bio21");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Bio21", false);
                        editor.commit();
                        unsubscribed.show();

                    }
                }
            });



            mFirebaseAnalytics = FirebaseAnalytics.getInstance(getActivity());
            Bundle params = new Bundle();
            params.putString("image_name", "hi");
            params.putString("full_text", TAG);
            mFirebaseAnalytics.logEvent("Bio_Workshops_Fragment", params);

            return view;
        }




    }

//////////////////////////////////////////////////////////////////////////////////////////////


    public static class ChemFragment extends Fragment  {

        private final String TAG = "Chem Fragment";

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRefChem1a = database.getReference("tutorsChem/tutorsChem1a");
        DatabaseReference myRefChem1b = database.getReference("tutorsChem/tutorsChem1b");
        DatabaseReference myRefChem15 = database.getReference("tutorsChem/tutorsChem15");
        DatabaseReference myRefChem12a = database.getReference("tutorsChem/tutorsChem12a");
        DatabaseReference myRefChem12b = database.getReference("tutorsChem/tutorsChem12b");
        DatabaseReference myRefChem32a = database.getReference("tutorsChem/tutorsChem32a");
        DatabaseReference myRefChem32b = database.getReference("tutorsChem/tutorsChem32b");


        FirebaseAnalytics mFirebaseAnalytics;

        public ChemFragment() {
            //empty constructor
        }

        public static WorkshopsStaticFragment.ChemFragment newInstance(String title) {
            WorkshopsStaticFragment.ChemFragment fragmentFirst = new WorkshopsStaticFragment.ChemFragment();
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
            View view = inflater.inflate(R.layout.chem_static_fragment, container, false);

            final TextView chemTutors1a =(TextView) view.findViewById(R.id.textViewChem1aTutors);
            final TextView chemTutors1b =(TextView) view.findViewById(R.id.textViewChem1bTutors);
            final TextView chemTutors15 =(TextView) view.findViewById(R.id.textViewChem15Tutors);
            final TextView chemTutors12a =(TextView) view.findViewById(R.id.textViewChem12aTutors);
            final TextView chemTutors12b =(TextView) view.findViewById(R.id.textViewChem12bTutors);
            final TextView chemTutors32a =(TextView) view.findViewById(R.id.textViewChem32aTutors);
            final TextView chemTutors32b =(TextView) view.findViewById(R.id.textViewChem32bTutors);

            ValueEventListener postListenerChem32b = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    chemTutors32b.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefChem32b.addValueEventListener(postListenerChem32b);

            ValueEventListener postListenerChem32a = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    chemTutors32a.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefChem32a.addValueEventListener(postListenerChem32a);


            ValueEventListener postListenerChem12b = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    chemTutors12b.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefChem12b.addValueEventListener(postListenerChem12b);


            ValueEventListener postListenerChem12a = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    chemTutors12a.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefChem12a.addValueEventListener(postListenerChem12a);


            ValueEventListener postListenerChem15 = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    chemTutors15.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefChem15.addValueEventListener(postListenerChem15);

            ValueEventListener postListenerChem1a = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    chemTutors1a.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefChem1a.addValueEventListener(postListenerChem1a);

            ValueEventListener postListenerChem1b = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    chemTutors1b.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefChem1b.addValueEventListener(postListenerChem1b);

            final Snackbar subscribed = Snackbar.make(container, "Subscribed!", Snackbar.LENGTH_SHORT);
            final Snackbar unsubscribed = Snackbar.make(container, "Unsubscribed!", Snackbar.LENGTH_SHORT);
            SharedPreferences sharedPrefs = getActivity().getSharedPreferences("metasapp", 0);


            boolean Chem1a = sharedPrefs.getBoolean("Chem1a", false);
            final Switch chem1a = (Switch)view.findViewById(R.id.switch1a);
            chem1a.setChecked(Chem1a);

            chem1a.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (chem1a.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("Chem1a");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Chem1a", true);
                        editor.commit();
                        subscribed.show();


                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Chem1a");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Chem1a", false);
                        editor.commit();
                        unsubscribed.show();

                    }
                }
            });

            boolean Chem1b = sharedPrefs.getBoolean("Chem1b", false);
            final Switch chem1b = (Switch)view.findViewById(R.id.switch1b);
            chem1b.setChecked(Chem1a);

            chem1b.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (chem1b.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("Chem1b");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Chem1b", true);
                        editor.commit();
                        subscribed.show();


                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Chem1b");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Chem1b", false);
                        editor.commit();
                        unsubscribed.show();

                    }
                }
            });

            boolean Chem15 = sharedPrefs.getBoolean("Chem15", false);
            final Switch chem15 = (Switch)view.findViewById(R.id.switch15);
            chem1b.setChecked(Chem15);

            chem15.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (chem15.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("Chem15");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Chem15", true);
                        editor.commit();
                        subscribed.show();


                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Chem15");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Chem15", false);
                        editor.commit();
                        unsubscribed.show();

                    }
                }
            });


            boolean Chem12a = sharedPrefs.getBoolean("Chem12a", false);
            final Switch chem12a = (Switch)view.findViewById(R.id.switch12a);
            chem12a.setChecked(Chem12a);

            chem12a.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (chem12a.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("Chem12a");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Chem12a", true);
                        editor.commit();
                        subscribed.show();


                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Chem12a");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Chem12a", false);
                        editor.commit();
                        unsubscribed.show();

                    }
                }
            });


            boolean Chem12b = sharedPrefs.getBoolean("Chem12b", false);
            final Switch chem12b = (Switch)view.findViewById(R.id.switch12b);
            chem12b.setChecked(Chem12b);

            chem12b.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (chem12b.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("Chem12b");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Chem12b", true);
                        editor.commit();
                        subscribed.show();


                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Chem12b");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Chem12b", false);
                        editor.commit();
                        unsubscribed.show();

                    }
                }
            });


            boolean Chem32a = sharedPrefs.getBoolean("Chem32a", false);
            final Switch chem32a = (Switch)view.findViewById(R.id.switch32a);
            chem32a.setChecked(Chem32a);

            chem32a.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (chem32a.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("Chem32a");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Chem32a", true);
                        editor.commit();
                        subscribed.show();


                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Chem32a");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Chem32a", false);
                        editor.commit();
                        unsubscribed.show();

                    }
                }
            });

            boolean Chem32b = sharedPrefs.getBoolean("Chem32b", false);
            final Switch chem32b = (Switch)view.findViewById(R.id.switch32b);
            chem32b.setChecked(Chem32b);

            chem32b.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (chem32b.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("Chem32b");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Chem32b", true);
                        editor.commit();
                        subscribed.show();


                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Chem32b");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("Chem32b", false);
                        editor.commit();
                        unsubscribed.show();

                    }
                }
            });


            mFirebaseAnalytics = FirebaseAnalytics.getInstance(getActivity());
            Bundle params = new Bundle();
            params.putString("image_name", "hi");
            params.putString("full_text", TAG);
            mFirebaseAnalytics.logEvent("Chem_Workshops_Fragment", params);

            return view;
        }


    }
    //////////////////////////////////////////////////////////////////////////////////////////////

    public static class EthStudFragment extends Fragment {

        private final String TAG = "Eth Stud Fragment";


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRefEthStud37a = database.getReference("tutorsEthStud/tutorsEthStud37a");
        DatabaseReference myRefEthStud37b = database.getReference("tutorsEthStud/tutorsEthStud37b");
        FirebaseAnalytics mFirebaseAnalytics;



        public EthStudFragment() {
            //empty constructor
        }

        public static WorkshopsStaticFragment.EthStudFragment newInstance(String title) {
            WorkshopsStaticFragment.EthStudFragment fragmentFirst = new WorkshopsStaticFragment.EthStudFragment();
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
            View view = inflater.inflate(R.layout.eth_stud_static_layout, container, false);

            final TextView tutorsTextEthStud37a =(TextView) view.findViewById(R.id.textViewTutorsEthStud37a);
            final TextView tutorsTextEthStud37b =(TextView) view.findViewById(R.id.textViewTutorsEthStud37b);


            ValueEventListener postListenerEthStud37a = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    tutorsTextEthStud37a.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefEthStud37a.addValueEventListener(postListenerEthStud37a);

            ValueEventListener postListenerEthStud37b = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    TutorsModel tutorsFirebase = dataSnapshot.getValue(TutorsModel.class);
                    tutorsTextEthStud37b.setText(tutorsFirebase.tutors);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            myRefEthStud37b.addValueEventListener(postListenerEthStud37b);

            final Snackbar subscribed = Snackbar.make(container, "Subscribed!", Snackbar.LENGTH_SHORT);
            final Snackbar unsubscribed = Snackbar.make(container, "Unsubscribed!", Snackbar.LENGTH_SHORT);
            SharedPreferences sharedPrefs = getActivity().getSharedPreferences("metasapp", 0);


            boolean EthStud37a = sharedPrefs.getBoolean("EthStud37a", false);
            final Switch ethStud37a = (Switch)view.findViewById(R.id.switch37a);
            ethStud37a.setChecked(EthStud37a);

            ethStud37a.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (ethStud37a.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("EthStud37a");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("EthStud37a", true);
                        editor.commit();
                        subscribed.show();


                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("EthStud37a");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("EthStud37a", false);
                        editor.commit();
                        unsubscribed.show();

                    }
                }
            });


            boolean EthStud37b = sharedPrefs.getBoolean("EthStud37b", false);
            final Switch ethStud37b = (Switch)view.findViewById(R.id.switch37b);
            ethStud37b.setChecked(EthStud37b);

            ethStud37b.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (ethStud37b.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("EthStud37b");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("EthStud37b", true);
                        editor.commit();
                        subscribed.show();


                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("EthStud37b");

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                        editor.putBoolean("EthStud37b", false);
                        editor.commit();
                        unsubscribed.show();

                    }
                }
            });




            mFirebaseAnalytics = FirebaseAnalytics.getInstance(getActivity());
            Bundle params = new Bundle();
            params.putString("image_name", "hi");
            params.putString("full_text", TAG);
            mFirebaseAnalytics.logEvent("Eth_Studies_Workshops_Fragment", params);

            return view;
        }


    }
}
