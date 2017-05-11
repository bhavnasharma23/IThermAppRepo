package com.example.itherm.ithermapp.agenda;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.itherm.ithermapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 28/04/17.
 */

public class DemoYearsPagerAdapter extends PagerAdapter {
    private Context context;
    List<String> mFragmentTitleDate = new ArrayList<>();
    List<String> mFragmentTitleDay = new ArrayList<>();
    List<String> mFragmentTitleMonth = new ArrayList<>();

    private RecyclerView recyclerDemo;
    private FragmentAdapter adapter;
    private ArrayList<String> time = new ArrayList<>();
    private ArrayList<String> content = new ArrayList<>();


    public DemoYearsPagerAdapter() {
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.fragment_dummy, container, false);

      recyclerDemo = (RecyclerView) view.findViewById(R.id.recyclerCred);
      recyclerDemo.setLayoutManager(new LinearLayoutManager(context));
        time.clear();
        content.clear();


        time.add("10:30\n11:30");
        time.add("10:30\n11:30");
        time.add("10:30\n11:30");
        time.add("11:30\n12:30");
        time.add("11:30\n12:30");
        time.add("11:30\n12:30");

        content.add( "  Selected content for tab :" + mFragmentTitleDate.get(position) +
                " - " + mFragmentTitleDay.get(position) + " - " + mFragmentTitleMonth.get(position)
                + "\n\n\n" + context.getResources().getString(R.string.content));
        content.add(context.getResources().getString(R.string.content)
        + "\n\n" + context.getResources().getString(R.string.content));
        content.add(context.getResources().getString(R.string.content)
        + "\n\n" + context.getResources().getString(R.string.content));
        content.add("Selected content for tab :" + mFragmentTitleDate.get(position) +
                " - " + mFragmentTitleDay.get(position) + " - " + mFragmentTitleMonth.get(position)
                + "\n\n\n" + context.getResources().getString(R.string.content));
        content.add(context.getResources().getString(R.string.content)
                + "\n\n" + context.getResources().getString(R.string.content));
        content.add(context.getResources().getString(R.string.content)
                + "\n\n" + context.getResources().getString(R.string.content));

      adapter = new FragmentAdapter(time, content);

      recyclerDemo.setAdapter(adapter);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return mFragmentTitleDate.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public String getPageTitle(int position) {
        return mFragmentTitleDay.get(position) + "\n" +
                mFragmentTitleDate.get(position) ;
    }


    public void addData(Context context, List<String> date, List<String> day, List<String> month){
        this.context =context;
        mFragmentTitleDate = new ArrayList<>(date);
        mFragmentTitleDay = new ArrayList<>(day);
        mFragmentTitleMonth = new ArrayList<>(month);
    }

}
