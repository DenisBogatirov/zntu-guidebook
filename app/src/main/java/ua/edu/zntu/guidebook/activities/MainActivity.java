package ua.edu.zntu.guidebook.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import ua.edu.zntu.guidebook.R;
import ua.edu.zntu.guidebook.fragments.TimetableFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static final int LAYOUT = R.layout.activity_main;

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TimetableFragment timetableFragment;

    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);



        manager = getSupportFragmentManager();

        timetableFragment = new TimetableFragment();

        if (savedInstanceState == null && manager.findFragmentByTag(TimetableFragment.TAG) == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, timetableFragment, TimetableFragment.TAG).commit();
        }
        
        initToolbar();
        initNavigationView();
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

    private void initNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation);

        navigationView.getMenu().getItem(0).setChecked(true);

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        transaction = manager.beginTransaction();

        switch (id){

            case R.id.nav_timetable:

                if (manager.findFragmentByTag(TimetableFragment.TAG) == null) {

                    transaction.add(R.id.container, timetableFragment, TimetableFragment.TAG);
                }

                break;

            case R.id.nav_find:

                break;

            case R.id.nav_news:

                break;

            case R.id.nav_directory:

                break;
        }

        transaction.commit();

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
