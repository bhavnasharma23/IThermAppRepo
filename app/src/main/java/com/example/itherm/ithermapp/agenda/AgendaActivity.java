package com.example.itherm.ithermapp.agenda;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.itherm.ithermapp.R;
import com.nshmura.recyclertablayout.RecyclerTabLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class AgendaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Calendar start = Calendar.getInstance();
        start.add(Calendar.DATE, -600);
        Calendar end = Calendar.getInstance();
        end.add(Calendar.DATE, 600);

        List<String> mFragmentTitleDate = new ArrayList<>();
        List<String> mFragmentTitleDay = new ArrayList<>();
        List<String> mFragmentTitleMonth = new ArrayList<>();

        for (Calendar d = start; d.before(end); d.add(Calendar.DATE, 1))
        {
            mFragmentTitleDay.add(d.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH));
            mFragmentTitleDate.add(d.get(Calendar.DATE)+ "");
            mFragmentTitleMonth.add(d.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
        }

        DemoYearsPagerAdapter adapter = new DemoYearsPagerAdapter();
        adapter.addData(getApplicationContext(), mFragmentTitleDate, mFragmentTitleDay, mFragmentTitleMonth);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);


        viewPager.setCurrentItem(600);

        RecyclerTabLayout recyclerTabLayout = (RecyclerTabLayout)
                findViewById(R.id.recycler_tab_layout);
        RecyclerAdapter adapter1 = new RecyclerAdapter(mFragmentTitleDate, mFragmentTitleDay, mFragmentTitleMonth);

        recyclerTabLayout.setAdapter(adapter1);

        recyclerTabLayout.setUpWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
