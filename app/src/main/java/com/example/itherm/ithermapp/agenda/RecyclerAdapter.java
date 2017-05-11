package com.example.itherm.ithermapp.agenda;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.itherm.ithermapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 28/04/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    private Context context;
    List<String> mFragmentTitleDate = new ArrayList<>();
    List<String> mFragmentTitleDay = new ArrayList<>();
    List<String> mFragmentTitleMonth = new ArrayList<>();

    public RecyclerAdapter(List<String> date, List<String> day, List<String> month){
        mFragmentTitleDate = new ArrayList<>(date);
        mFragmentTitleDay = new ArrayList<>(day);
        mFragmentTitleMonth = new ArrayList<>(month);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        ViewHolder viewHolder;
        context = parent.getContext();
        view = LayoutInflater.from(context).inflate(R.layout.tab_custom, parent, false);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtDate.setText(mFragmentTitleDate.get(position));
        holder.txtDay.setText(mFragmentTitleDay.get(position));
        holder.txtMonth.setText(mFragmentTitleMonth.get(position));
    }

    @Override
    public int getItemCount() {
        return mFragmentTitleDay.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtDay;
        private TextView txtDate;
        private TextView txtMonth;

        public ViewHolder(View itemView) {
            super(itemView);
            txtDay = (TextView) itemView.findViewById(R.id.txtDay);
            txtDate = (TextView) itemView.findViewById(R.id.txtDate);
            txtMonth = (TextView) itemView.findViewById(R.id.txtMonth);

        }
    }
}
