package ua.edu.zntu.guidebook.activities;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import ua.edu.zntu.guidebook.R;
import ua.edu.zntu.guidebook.async.TimetableAsyncTask;
import ua.edu.zntu.guidebook.fragments.GuidebookFragment;
import ua.edu.zntu.guidebook.fragments.NewsFragment;
import ua.edu.zntu.guidebook.fragments.RoomsFragment;
import ua.edu.zntu.guidebook.fragments.SectionInfoFragment;
import ua.edu.zntu.guidebook.fragments.TimetableFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int LAYOUT = R.layout.activity_main;

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private TimetableFragment timetableFragment;
    private NewsFragment newsFragment;
    private RoomsFragment roomsFragment;
    private GuidebookFragment guidebookFragment;

    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        manager = getSupportFragmentManager();

        timetableFragment = new TimetableFragment();
        newsFragment = new NewsFragment();
        roomsFragment = new RoomsFragment();
        guidebookFragment = new GuidebookFragment();

        String startFragmentName = this.getIntent().getStringExtra("StartFragment");

        int checkedItem = 0;

        if (startFragmentName == null && savedInstanceState == null && manager.findFragmentByTag(TimetableFragment.TAG) == null) {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, timetableFragment, TimetableFragment.TAG)
                    .commit();
            checkedItem = 0;
        }

        initToolbar();
        initNavigationView(checkedItem);
    }


    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        toolbar.inflateMenu(R.menu.menu_toolbar);
    }

    private void initNavigationView(int checkedItem) {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.getMenu().getItem(checkedItem).setChecked(true);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        transaction = manager.beginTransaction();

        switch (id) {

        case R.id.nav_timetable:
            changeFragment(timetableFragment, TimetableFragment.TAG);
            break;

        case R.id.nav_find:
            changeFragment(roomsFragment, RoomsFragment.TAG);
            break;

        case R.id.nav_news:
            changeFragment(newsFragment, NewsFragment.TAG);
            break;

        case R.id.nav_directory:
            changeFragment(guidebookFragment, GuidebookFragment.TAG);
            break;
        }

        transaction.addToBackStack(null);
        transaction.commit();

        if (id != R.id.nav_timetable) { TimetableAsyncTask.cancel(); }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        TimetableAsyncTask.cancel();
    }

    private void changeFragment(Fragment fragment, String TAG) {

        String[] fragments = {
                TimetableFragment.TAG,
                RoomsFragment.TAG,
                NewsFragment.TAG,
                SectionInfoFragment.TAG,
                GuidebookFragment.TAG,
        };

        boolean wasReplaced = false;

        for (String checkTag : fragments) {
            if (manager.findFragmentByTag(checkTag) != null) {
                transaction.replace(R.id.container, fragment, TAG);
                wasReplaced = true;
            }
        }
        if (!wasReplaced) {
            if (manager.findFragmentByTag(TAG) == null) {
                transaction.add(R.id.container, fragment, TAG);
            }
        }
    }
}
