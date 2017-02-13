package danilk.metasapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import android.os.Handler;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;


import com.example.danilk.metasapp.R;
import com.firebase.client.Firebase;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessaging;


public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private final static String COLLAPSING_TOOLBAR_FRAGMENT_TAG = "collapsing_toolbar";
    private final static String HOME_TAG = "home";
    private final static String RESOURCES_TAG = "resources";
    private final static String FAB_FRAGMENT_TAG = "fab";
    private final static String TEXTBOOKS_TAG = "textbooks";
    private final static String LIST_FACULTY_TAG = "faculty";
    private final static String LEADERSHIP_TAG = "leadership";
    private final static String ATHLETICS_TAG = "athletics";
    private final static String TAB_MAP_TAG = "map";
    private final static String TAB_FRAGMENT_TAG = "tab";
    private final static String SELECTED_TAG = "selected_index";
    private final static String FEEDBACK_TAG = "feedback";
    private final static String ABOUT_FRAGMENT_TAG = "about";

    public static final String PREFS_NAME = "MyPrefsFile";


    private final static int LEADERSHIP = 6;
    private final static int RESOURCES = 1;
    private final static int COLLAPSING_TOOLBAR = 0;
    private final static int FAB = 2;
    private final static int TAB = 3;
    private final static int ATHLETICS = 4;
    private final static int FACULTY = 5;
    private final static int MAP = 7;
    private final static int FEEDBACK = 8;
    private final static int ABOUT = 9;
    private final static int TEXTBOOKS = 10;

    private static int selectedIndex;

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private View dialogViewSG;
    private View dialogViewMath13Tutors;
    private View dialogViewMath111Tutors;
    private View dialogViewTextbook;
    View container;
     FirebaseAnalytics mFirebaseAnalytics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        container = findViewById(R.id.fragment_container); // for snackbar

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        // dialogViewJanet = LayoutInflater.from(this).inflate(R.layout.dialog_layout_math13, null, false);

        Firebase.setAndroidContext(this);
        Firebase myFirebaseRef = new Firebase("https://metasprogamapp.firebaseio.com/"); /* initialize object */
        myFirebaseRef.keepSynced(true);

        if (savedInstanceState != null) {
            navigationView.getMenu().getItem(savedInstanceState.getInt(SELECTED_TAG)).setChecked(true);
            return;
        }

        selectedIndex = COLLAPSING_TOOLBAR;

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                new NewsFragment(), COLLAPSING_TOOLBAR_FRAGMENT_TAG).commit();
        // onBackPressed();
        disableNavigationViewScrollbars(navigationView);
    }

    /*@Override
    public void onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/

    private void disableNavigationViewScrollbars(NavigationView navigationView) {
        if (navigationView != null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView.getChildAt(0);
            if (navigationMenuView != null) {
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_TAG, selectedIndex);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        // getMenuInflater().inflate(R.menu.menu_main, menu); // this inflates stuff in toolbar of every fragment
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.item_collapsing_toolbar:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        drawerLayout.closeDrawer(GravityCompat.START);
                    }
                }, /* TIME: */ 190);
                if (!menuItem.isChecked()) {
                    selectedIndex = COLLAPSING_TOOLBAR;
                    menuItem.setChecked(true);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new NewsFragment(), COLLAPSING_TOOLBAR_FRAGMENT_TAG).addToBackStack(null).commit();
                }

                return true;

            case R.id.item_services:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        drawerLayout.closeDrawer(GravityCompat.START);
                    }
                }, /* TIME: */ 190);
                if (!menuItem.isChecked()) {
                    selectedIndex = RESOURCES;
                    menuItem.setChecked(true);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new CollegeResourcesFragment(), RESOURCES_TAG).addToBackStack(null).commit();
                }

           return true;

            case R.id.item_static_workshops:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        drawerLayout.closeDrawer(GravityCompat.START);
                    }
                }, /* TIME: */ 190);
                if (!menuItem.isChecked()) {
                    selectedIndex = TAB;
                    menuItem.setChecked(true);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new WorkshopsStaticFragment(), TAB_FRAGMENT_TAG).addToBackStack(null).commit();
                }

                return true;

            case R.id.item_leadership:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        drawerLayout.closeDrawer(GravityCompat.START);
                    }
                }, /* TIME: */ 190);
                if (!menuItem.isChecked()) {
                    selectedIndex = LEADERSHIP;
                    menuItem.setChecked(true);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new LeadershipFragment(), LEADERSHIP_TAG).addToBackStack(null).commit();
                }

                return true;
            case R.id.item_tab_map:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        drawerLayout.closeDrawer(GravityCompat.START);
                    }
                }, /* TIME: */ 190);
                if (!menuItem.isChecked()) {

                    selectedIndex = MAP;
                    menuItem.setChecked(true);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new MapFragment(), TAB_MAP_TAG).addToBackStack(null).commit();
                }

                return true;
            case R.id.item_feedback:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        drawerLayout.closeDrawer(GravityCompat.START);
                    }
                }, /* TIME: */ 190);
                if (!menuItem.isChecked()) {
                    selectedIndex = FEEDBACK;
                    menuItem.setChecked(true);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new FeedbackFragment(), FEEDBACK_TAG).addToBackStack(null).commit();
                }

                return true;
            case R.id.item_about:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        drawerLayout.closeDrawer(GravityCompat.START);
                    }
                }, /* TIME: */ 190);
                if (!menuItem.isChecked()) {
                    selectedIndex = ABOUT;
                    menuItem.setChecked(true);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new AboutFragment(), ABOUT_FRAGMENT_TAG).addToBackStack(null).commit();
                }

                return true;
        }
        return false;
    }

    // this override method was added because https://guides.codepath.com/android/Fragment-Navigation-Drawer
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    public void setupNavigationDrawer(Toolbar toolbar) {


        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }



    public void subscribeMath111(View view) {

        dialogViewMath111Tutors = LayoutInflater.from(this).inflate(R.layout.dialog_layout_math111, null, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.AppCompatAlertDialogStyle);
        builder.setTitle("Pick your Peer Leader");
        builder.setView(dialogViewMath111Tutors);

        final CheckBox tommyCheckbox = (CheckBox) dialogViewMath111Tutors.findViewById(R.id.tommyCheckBox111);
        final CheckBox anhCheckbox = (CheckBox) dialogViewMath111Tutors.findViewById(R.id.anhCheckBox111);
        final CheckBox thadoeCheckbox = (CheckBox) dialogViewMath111Tutors.findViewById(R.id.thadoeCheckBox111);
        final CheckBox aaronCheckbox = (CheckBox) dialogViewMath111Tutors.findViewById(R.id.aaronCheckBox111);

        SharedPreferences sharedPrefs = getSharedPreferences("metasapp111", MODE_PRIVATE);

        boolean tommy111StateCheckBox = sharedPrefs.getBoolean("tommyCheckbox111", false);
        tommyCheckbox.setChecked(tommy111StateCheckBox);

        boolean anh111StateCheckBox = sharedPrefs.getBoolean("anhCheckbox111", false);
        anhCheckbox.setChecked(anh111StateCheckBox);

        boolean thadoe111StateCheckBox = sharedPrefs.getBoolean("thadoeCheckbox111", false);
        thadoeCheckbox.setChecked(thadoe111StateCheckBox);

        boolean aaron111StateCheckBox = sharedPrefs.getBoolean("aaronCheckbox111", false);
        aaronCheckbox.setChecked(aaron111StateCheckBox);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(MainActivity.this, "Subscribed t", Toast.LENGTH_LONG).show();

            }

        });//second parameter used for onclicklistener
        builder.setNegativeButton("Cancel", null);
        builder.show().getWindow();


    }

    public void onCheckboxClickedMath111(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.tommyCheckBox111:
                if (checked) {
                    FirebaseMessaging.getInstance().subscribeToTopic("TommyMath111");
                    ;
                    Toast.makeText(MainActivity.this, "Subscribed to Tommy", Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("metasapp111", MODE_PRIVATE).edit();
                    editor.putBoolean("tommyCheckbox111", true);
                    editor.commit();
                } else {
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("tommyMath111");
                    ;
                    Toast.makeText(MainActivity.this, "Unsubscribed from Tommy", Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("metasapp111", MODE_PRIVATE).edit();
                    editor.putBoolean("tommyCheckbox111", false);
                    editor.commit();
                }
                break;
            case R.id.anhCheckBox111:
                if (checked) {
                    FirebaseMessaging.getInstance().subscribeToTopic("AnhMath111");
                    ;
                    Toast.makeText(MainActivity.this, "Subscribed to Anh", Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("metasapp111", MODE_PRIVATE).edit();
                    editor.putBoolean("anhCheckbox111", true);
                    editor.commit();
                } else {
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("AnhMath111");
                    ;
                    Toast.makeText(MainActivity.this, "Unsubscribed from Anh", Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("metasapp111", MODE_PRIVATE).edit();
                    editor.putBoolean("anhCheckbox111", false);
                    editor.commit();
                }
                break;
            case R.id.thadoeCheckBox111:
                if (checked) {
                    FirebaseMessaging.getInstance().subscribeToTopic("ThadoeMath111");
                    ;
                    Toast.makeText(MainActivity.this, "Subscribed to Thadoe", Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("metasapp111", MODE_PRIVATE).edit();
                    editor.putBoolean("thadoeCheckbox111", true);
                    editor.commit();
                } else {
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("ThadoeMath111");
                    ;
                    Toast.makeText(MainActivity.this, "Unsubscribed from Thadoe", Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("metasapp111", MODE_PRIVATE).edit();
                    editor.putBoolean("thadoeCheckbox111", false);
                    editor.commit();
                }
                break;
            case R.id.aaronCheckBox111:
                if (checked) {
                    FirebaseMessaging.getInstance().subscribeToTopic("AaronMath111");
                    ;
                    Toast.makeText(MainActivity.this, "Subscribed to Aaron", Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("metasapp111", MODE_PRIVATE).edit();
                    editor.putBoolean("aaronCheckbox111", true);
                    editor.commit();
                } else {
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("AaronMath111");
                    ;
                    Toast.makeText(MainActivity.this, "Unsubscribed from Aaron", Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("metasapp111", MODE_PRIVATE).edit();
                    editor.putBoolean("aaronCheckbox111", false);
                    editor.commit();
                }
                break;
        }

    }

    public void subscribeMath13(View view) {

        dialogViewMath13Tutors = LayoutInflater.from(this).inflate(R.layout.dialog_layout_math13, null, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.AppCompatAlertDialogStyle);
        builder.setTitle("Pick your Peer Leader");
        builder.setView(dialogViewMath13Tutors);


        //  final Switch OnOff = (Switch) dialogViewMath13Tutors.findViewById(R.id.janet_switch);

        final CheckBox janetCheckbox = (CheckBox) dialogViewMath13Tutors.findViewById(R.id.janetCheckBox);
        final CheckBox adamCheckbox = (CheckBox) dialogViewMath13Tutors.findViewById(R.id.adamCheckBox);
        final CheckBox smritiCheckbox = (CheckBox) dialogViewMath13Tutors.findViewById(R.id.smritiCheckBox);
        final CheckBox margotCheckbox = (CheckBox) dialogViewMath13Tutors.findViewById(R.id.margotCheckBox);

        SharedPreferences sharedPrefs = getSharedPreferences("metasapp", MODE_PRIVATE);

        boolean janetStateCheckBox = sharedPrefs.getBoolean("janetCheckbox", false);
        janetCheckbox.setChecked(janetStateCheckBox);


        boolean adamStateCheckBox = sharedPrefs.getBoolean("adamCheckbox", false);
        adamCheckbox.setChecked(adamStateCheckBox);

        boolean smritiStateCheckbox = sharedPrefs.getBoolean("smritiCheckbox", false);
        smritiCheckbox.setChecked(smritiStateCheckbox);

        boolean margotStateCheckBox = sharedPrefs.getBoolean("margotCheckbox", false);
        margotCheckbox.setChecked(margotStateCheckBox);


       /* boolean janetState = sharedPrefs.getBoolean("JanetSwitch", false);
        OnOff.setChecked(janetState); */

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(MainActivity.this, "Subscribed t", Toast.LENGTH_LONG).show();

            }

        });//second parameter used for onclicklistener
        builder.setNegativeButton("Cancel", null);
        builder.show().getWindow();         //Show dialog and launch keyboard

       /* OnOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    // textView.setText("Switch is currently ON");
                    FirebaseMessaging.getInstance().subscribeToTopic("janetMath13");;
                    Snackbar success = Snackbar.make(container, "Subscribed to Janet!", Snackbar.LENGTH_LONG);
                    success.show();

                    SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                    editor.putBoolean("JanetSwitch", true);
                    editor.commit();

                }
                else {
                    //textView.setText("Switch is currently OFF");
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("janetMath13");
                    Snackbar fail = Snackbar.make(container, "Unsubscribed to Janet!", Snackbar.LENGTH_LONG);
                    fail.show();

                    SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                    editor.putBoolean("JanetSwitch", false);
                    editor.commit();

                }

            }
        });*/


    }


    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.janetCheckBox:

                if (checked) {
                    FirebaseMessaging.getInstance().subscribeToTopic("janetMath13");
                    ;
                    Toast.makeText(MainActivity.this, "Subscribed to Janet", Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                    editor.putBoolean("janetCheckbox", true);
                    editor.commit();

                } else {
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("janetMath13");
                    Toast.makeText(MainActivity.this, "Unsubscribed from Janet", Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                    editor.putBoolean("janetCheckbox", false);
                    editor.commit();

                }

                break;

            case R.id.adamCheckBox:

                if (checked) {
                    FirebaseMessaging.getInstance().subscribeToTopic("adamMath13");
                    ;
                    Toast.makeText(MainActivity.this, "Subscribed to Adam Math-13", Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                    editor.putBoolean("adamCheckbox", true);
                    editor.commit();
                } else {
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("adamMath13");
                    Toast.makeText(MainActivity.this, "Unsubscribed from Adam Math-13", Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                    editor.putBoolean("adamCheckbox", false);
                    editor.commit();

                }

                break;

            case R.id.smritiCheckBox:

                if (checked) {
                    FirebaseMessaging.getInstance().subscribeToTopic("smritiMath13");
                    ;
                    Toast.makeText(MainActivity.this, "Subscribed to Smriti Math-13", Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                    editor.putBoolean("smritiCheckbox", true);
                    editor.commit();
                } else {
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("smritiMath13");
                    Toast.makeText(MainActivity.this, "Unsubscribed from Smriti Math-13", Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                    editor.putBoolean("smritiCheckbox", false);
                    editor.commit();

                }

            case R.id.margotCheckBox:

                if (checked) {
                    FirebaseMessaging.getInstance().subscribeToTopic("margotMath13");
                    ;
                    Toast.makeText(MainActivity.this, "Subscribed to Margot Math-13", Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                    editor.putBoolean("margotCheckbox", true);
                    editor.commit();
                } else {
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("margotMath13");
                    Toast.makeText(MainActivity.this, "Unsubscribed from Margot Math-13", Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("metasapp", MODE_PRIVATE).edit();
                    editor.putBoolean("margotCheckbox", false);
                    editor.commit();

                }
                break;
        }


    }


    ////////////////////////////////////////////////////////////// START Url buttons for static News view
    public void newsOne(View view) {
        web("http://www.sjcc.edu/News/Pages/SJCCPartnerswithUCSC.aspx");
    }

    public void newsTwo(View view) {
        web("http://www.sjcc.edu/News/Pages/MetasProgramBrightSpotinHispanicEducation.aspx");
    }

    public void newsThree(View view) {
        web("http://www.sjcc.edu/News/Pages/SJCC--EVC-Students-Visit-Cuba.aspx");
    }

    public void newsFour(View view) {
        web("http://www.sjcc.edu/News/Pages/SJECCD-Wins-Silicon-Valley-Engineering-Tech-Pathways-Grant.aspx");
    }

    //////////////////////////////////////////////////////////// END  Url buttons for static News view

    //////////////////////////////////////////////////////////// START Links for Students Resources


    // Metas
    public void callMetas(View view) {
        call("(408) 288-3125​");
    }

    public void webMetas(View view) {
        web("http://www.sjcc.edu/academics/academic-programs/metas");
    }

    public void emailMetas(View view) {
        email("metas.staff.sjcc@gmail.com");
    }

    // Library
    public void callLibrary(View view) {
        call("(408) 288-3775");
    }

    public void webLibrary(View View) {
        web("http://www.sjcc.edu/Library");
    }

    public void emailLibrary(View view) {
        email("SJCC.Library@sjcc.edu");
    }

    // Tutoring Center
    public void emailTutoringCenter(View view) {
        email("Tutoring.Center@sjcc.edu");
    }

    public void webTutoringCenter(View view) {
        web("http://www.sjcc.edu/current-students/on-campus-resources/tutoring-center");
    }

    // Reading and Writing Center
    public void callRWC(View view) {
        call("(408) 288-3761");
    }

    public void emailRWC(View view) {
        email("evelyn.rojas@sjcc.edu");
    }

    public void webRWC(View view) {
        web("http://www.sjcc.edu/current-students/on-campus-resources/reading-and-writing-center");
    }

    // Admisson and Records
    public void callAdmissonRecords(View view) {
        call("(408) 288-3700");
    }

    public void emailAdmissonRecords(View view) {
        email("sjcc.admissions@sjcc.edu");
    }

    public void webAdmissonRecords(View view) {
        web("http://www.sjcc.edu/current-students/on-campus-resources/admissions-and-records-office");
    }

    // Counseling
    public void callCounseling(View view) {
        call("(408) 288-3750");
    }

    public void emailCounseling(View view) {
        email("Mary.Wright@sjcc.edu");
    }

    public void webCounseling(View view) {
        web("http://www.sjcc.edu/current-students/on-campus-resources/counseling");
    }

    // Career Transfer Center
    public void callCareerCenter(View view) {
        call("(408) 288-3761");
    }

    public void emailCareerCenter(View view) {
        email("SJCCTrans@sjcc.edu");
    }

    public void webCareerCenter(View view) {
        web("http://www.sjcc.edu/future-students/on-campus-resources/career-transfer-center");
    }

    // Calendar
    public void webCalendar(View view) {
        web("http://www.sjcc.edu/academics/academic-calendar");
    }

    // Calendar
    public void webClassSchedule(View view) {
        web("http://evcwebs.sjeccd.edu/schedule/evc/");
    }

    // Financial Aid
    public void callFidAid(View view) {
        call("((408) 239-8853");
    }

    public void emailFinAid(View view) {
        email("SJCCFA@sjcc.edu");
    }

    public void webFinAid(View view) {
        web("http://www.sjcc.edu/current-students/on-campus-resources/financial-aid-and-scholarship");
    }

    //// Buildings call
    public void callStudentCenter(View view) {
        call("​(408) 288-3125​​​\n");
    }

    public void emailStudentCenter(View view) {
        email("​metas.staff.sjcc@gmail.com");
    }


    //////////////////////////////////////////////////////////// Start Leadership links

    public void callDirector(View view) {
        call("​(408) 288-3104​");
    }

    public void emailDirector(View view) {
        email("​robert.gutierrez@sjcc.edu");
    }

    public void callAcademicCounselor(View view) {
        call("(408) 288-3124");
    }

    public void emailAcademicCounselor(View view) {
        email("alex.lopez@sjcc.edu​");
    }

    public void callProgramSpecialist(View view) {
        call("​(408) 288-3136​");
    }

    public void emailProgramSpecialist(View view) {
        email("​elizabeth.flores@sjcc.edu");
    }

    public void callProgramCoordinator(View view) {
        call("​(408) 288-3125");
    }

    public void emailProgramCoordinator(View view) {
        email("angela.gullerud@sjcc.edu");
    }

    public void callVPSpecialServices(View view) {
        call("(408) 288-3729");
    }

    public void emailVPSpecialServices(View view) {
        email("Elaine.Burns@sjcc.edu");
    }

    /////////////////////////////////////////////////////////////// END Leadership links


    // methods for URL, CALL & WEB
    private void web(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    private void call(String number) {
        Uri uriNumber = Uri.parse("tel: " + number);
        Intent callNumber = new Intent(Intent.ACTION_DIAL, uriNumber);
        startActivity(callNumber);

    }

    private void email(String email) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", email, null));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email); // String[]
        startActivity(emailIntent);

    }
//math
    public void onClickMath311(View v) {
        FirebaseMessaging.getInstance().subscribeToTopic("Math311");
        ;
        Toast.makeText(this, "Subscribed to Math311!", Toast.LENGTH_SHORT).show();
    }
    public void onClickMath311Unsubscribe(View v) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("Math311");
        ;
        Toast.makeText(this, "Unsubscribed from Math311!", Toast.LENGTH_SHORT).show();
    }

    public void onClickMath21(View v) {
        FirebaseMessaging.getInstance().subscribeToTopic("Math21");
        ;
        Toast.makeText(this, "Subscribed to Math 21!", Toast.LENGTH_SHORT).show();
    }

    public void onClickMath21Unsubscribe(View v) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("Math21");
        ;
        Toast.makeText(this, "Unsubscribed from Math 21!", Toast.LENGTH_SHORT).show();
    }

    public void onClickMath71(View v) {
        FirebaseMessaging.getInstance().subscribeToTopic("Math71");
        ;
        Toast.makeText(this, "Subscribed to Math 71!", Toast.LENGTH_SHORT).show();
    }

    public void onClickMath71Unsubscribe(View v) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("Math71");
        ;
        Toast.makeText(this, "Unsubscribed from Math71!", Toast.LENGTH_SHORT).show();
    }

    public void onClickMath63(View v) {
        FirebaseMessaging.getInstance().subscribeToTopic("Math63");
        ;
        Toast.makeText(this, "Subscribed to Math 63!", Toast.LENGTH_SHORT).show();
    }

    public void onClickMath63Unsubscribe(View v) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("Math63");
        ;
        Toast.makeText(this, "Unsubscribed from Math 63!", Toast.LENGTH_SHORT).show();
    }

//physics

    public void onClickPhysics2a(View v) {
        FirebaseMessaging.getInstance().subscribeToTopic("Physics2a");
        ;
        Toast.makeText(this, "Subscribed to Physics 2A!", Toast.LENGTH_SHORT).show();
    }

    public void onClickPhysics2aUnsubscribe(View v) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("Physics2a");
        ;
        Toast.makeText(this, "Unsubscribed from Physics 2A!", Toast.LENGTH_SHORT).show();
    }

    public void onClickPhysics2b(View v) {
        FirebaseMessaging.getInstance().subscribeToTopic("Physics2b");
        ;
        Toast.makeText(this, "Subscribed to Physics 2B!", Toast.LENGTH_SHORT).show();
    }

    public void onClickPhysics2bUnsubscribe(View v) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("Physics2b");
        ;
        Toast.makeText(this, "Unsubscribed from Physics 2B!", Toast.LENGTH_SHORT).show();
    }
    public void onClickPhysics4a(View v) {
        FirebaseMessaging.getInstance().subscribeToTopic("Physics4a");
        ;
        Toast.makeText(this, "Subscribed to Physics 4A!", Toast.LENGTH_SHORT).show();
    }

    public void onClickPhysics4aUnsubscribe(View v) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("Physics4a");
        ;
        Toast.makeText(this, "Unsubscribed from Physics 4A!", Toast.LENGTH_SHORT).show();
    }

    public void onClickPhysics4b(View v) {
        FirebaseMessaging.getInstance().subscribeToTopic("Physics4b");
        ;
        Toast.makeText(this, "Subscribed to Physics 4B!", Toast.LENGTH_SHORT).show();
    }

    public void onClickPhysics4bUnsubscribe(View v) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("Physics4b");
        ;
        Toast.makeText(this, "Unsubscribed from Physics 4B!", Toast.LENGTH_SHORT).show();
    }

    // chem
    public void onClickChem1a(View v) {
        FirebaseMessaging.getInstance().subscribeToTopic("Chem1a");
        ;
        Toast.makeText(this, "Subscribed to Chem 1A!", Toast.LENGTH_SHORT).show();
    }
    public void onClickChem1aUnsubscribed(View v) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("Chem1a");
        ;
        Toast.makeText(this, "Unsubscribed from Chem 1A!", Toast.LENGTH_SHORT).show();
    }

    public void onClickChem1b(View v) {
        FirebaseMessaging.getInstance().subscribeToTopic("Chem1b");
        ;
        Toast.makeText(this, "Subscribed to Chem 1B!", Toast.LENGTH_SHORT).show();
    }

    public void onClickChem1bUnsubscribed(View v) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("Chem1b");
        ;
        Toast.makeText(this, "Unsubscribed from Chem 1B!", Toast.LENGTH_SHORT).show();
    }

    public void onClickChem15(View v) {
        FirebaseMessaging.getInstance().subscribeToTopic("Chem15");

        Toast.makeText(this, "Subscribed to Chem 15!", Toast.LENGTH_SHORT).show();
    }

    public void onClickChem15Unsubscribed(View v) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("Chem15");
        ;
        Toast.makeText(this, "Unsubscribed from Chem 15!", Toast.LENGTH_SHORT).show();
    }

    public void onClickChem12a(View v) {
        FirebaseMessaging.getInstance().subscribeToTopic("Chem12a");

        Toast.makeText(this, "Subscribed to Chem 12A!", Toast.LENGTH_SHORT).show();
    }

    public void onClickChem12aUnsubscribed(View v) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("Chem12");
        ;
        Toast.makeText(this, "Unsubscribed from Chem 12A!", Toast.LENGTH_SHORT).show();
    }

    public void onClickChem12b(View v) {
        FirebaseMessaging.getInstance().subscribeToTopic("Chem12b");

        Toast.makeText(this, "Subscribed to Chem 12B!", Toast.LENGTH_SHORT).show();
    }

    public void onClickChem12bUnsubscribed(View v) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("Chem12");
        ;
        Toast.makeText(this, "Unsubscribed from Chem 12B!", Toast.LENGTH_SHORT).show();
    }

    public void onClickChem32a(View v) {
        FirebaseMessaging.getInstance().subscribeToTopic("Chem32a");

        Toast.makeText(this, "Subscribed to Chem 32A!", Toast.LENGTH_SHORT).show();
    }

    public void onClickChem32aUnsubscribed(View v) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("Chem32a");
        ;
        Toast.makeText(this, "Unsubscribed from Chem 32A!", Toast.LENGTH_SHORT).show();
    }


    public void onClickChem32b(View v) {
        FirebaseMessaging.getInstance().subscribeToTopic("Chem32b");

        Toast.makeText(this, "Subscribed to Chem 32B!", Toast.LENGTH_SHORT).show();
    }

    public void onClickChem32bUnsubscribed(View v) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("Chem32b");
        ;
        Toast.makeText(this, "Unsubscribed from Chem 32B!", Toast.LENGTH_SHORT).show();
    }
// BIO


    public void onClickBio4a(View v) {
        FirebaseMessaging.getInstance().subscribeToTopic("Bio4b");

        Toast.makeText(this, "Subscribed to Bio 4A!", Toast.LENGTH_SHORT).show();
    }

    public void onClickBio4aUnsubscribed(View v) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("Bio4b");

        Toast.makeText(this, "Unsubscribed from Bio 4A!", Toast.LENGTH_SHORT).show();
    }

    public void onClickBio4b(View v) {
        FirebaseMessaging.getInstance().subscribeToTopic("Bio4b");

        Toast.makeText(this, "Subscribed to Bio 4B!", Toast.LENGTH_SHORT).show();
    }

    public void onClickBio4bUnsubscribed(View v) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("Bio4b");

        Toast.makeText(this, "Unsubscribed from Bio 4B!", Toast.LENGTH_SHORT).show();
    }
    public void onClickBio20(View v) {
        FirebaseMessaging.getInstance().subscribeToTopic("Bio20");

        Toast.makeText(this, "Subscribed to Bio 20!", Toast.LENGTH_SHORT).show();
    }

    public void onClickBio20Unsubscribed(View v) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("Bio20");

        Toast.makeText(this, "Unsubscribed from Bio 20!", Toast.LENGTH_SHORT).show();
    }

    public void onClickBio21(View v) {
        FirebaseMessaging.getInstance().subscribeToTopic("Bio21");

        Toast.makeText(this, "Subscribed to Bio 21!", Toast.LENGTH_SHORT).show();
    }

    public void onClickBio21Unsubscribed(View v) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("Bio21");

        Toast.makeText(this, "Unsubscribed from Bio 21!", Toast.LENGTH_SHORT).show();
    }


    // ETH STUD

    public void onClickEthStud37a(View v) {
        FirebaseMessaging.getInstance().subscribeToTopic("EthStud37a");

        Toast.makeText(this, "Subscribed to Eth Studies 37A!", Toast.LENGTH_SHORT).show();
    }

    public void onClickEthStud37aUnsubscribed(View v) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("EthStud37a");

        Toast.makeText(this, "Unsubscribed from Eth Studies 37A!", Toast.LENGTH_SHORT).show();
    }

    public void onClickEthStud37b(View v) {
        FirebaseMessaging.getInstance().subscribeToTopic("EthStud37b");

        Toast.makeText(this, "Subscribed to Eth Studies 37A!", Toast.LENGTH_SHORT).show();
    }

    public void onClickEthStud37bUnsubscribed(View v) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("EthStud37b");

        Toast.makeText(this, "Unsubscribed from Eth Studies 37A!", Toast.LENGTH_SHORT).show();
    }

    // student resources

    public void onClickWorkshopsFragment(View v){

       /* Fragment WorkshopsStaticFragment = new WorkshopsStaticFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
       // transaction.replace(R.id.fragment_container, someFragment ); // give your fragment container id in first parameter
        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
        transaction.commit(); */

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new WorkshopsStaticFragment(), TAB_FRAGMENT_TAG).addToBackStack(null).commit();
    }

    public void webLearnMoreResearchProgram(View view) {
        web("http://www.sjcc.edu/academics/academic-programs/metas/undergraduate-research-scholars-program");
    }

    public void webLearnMoreSummerBridgeProgram(View view) {
        web("http://www.sjcc.edu/academics/academic-programs/metas/caminos-summer-bridge-fye");
    }

    public void webApplyResearchProgram(View view) {
        web("https://sjcc.formstack.com/forms/undergraduate_research");
    }

    public void webLearnMorePLTL(View view) {
        web("http://www.sjcc.edu/academics/academic-programs/metas/peer-led-team-learning");
    }

    public void webLearnMoreSI(View view) {
        web("http://www.sjcc.edu/academics/academic-programs/metas/supplemental-instruction");
    }


    public void webMetasFacebook(View view) {
        web("https://www.facebook.com/SJCCMetasProgram");
    }

    public void webMetasSjccWebsite(View view) {
        web("http://www.sjcc.edu/academics/academic-programs/metas");
    }

    //end
}
