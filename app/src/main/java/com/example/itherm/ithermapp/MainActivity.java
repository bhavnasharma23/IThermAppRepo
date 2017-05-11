package com.example.itherm.ithermapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.example.itherm.ithermapp.agenda.AgendaActivity;
import com.example.itherm.ithermapp.fragments.AboutIThermFragment;
import com.example.itherm.ithermapp.fragments.AttendeesFragment;
import com.example.itherm.ithermapp.fragments.CommiteeFragment;
import com.example.itherm.ithermapp.fragments.HotelFragment;
import com.example.itherm.ithermapp.fragments.KeyNoteSpeakerFragment;
import com.example.itherm.ithermapp.fragments.MyScheduleFragment;
import com.example.itherm.ithermapp.fragments.NotificationsFragment;
import com.example.itherm.ithermapp.fragments.SponsorshipFragment;



public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        int position = intent.getExtras().getInt("menuClickPosition");
        selectFrag(position);

    }

    public void selectFrag(int position) {

        Fragment fr = null;
        switch (position)
        {
            case 0:
                fr = new AboutIThermFragment();
                break;

            case 1:
                Intent intent = new Intent(getApplicationContext(), AgendaActivity.class);
                startActivity(intent);
                break;

            case 2:
                fr = new AttendeesFragment();
                break;

            case 3:
                fr = new CommiteeFragment();
                break;

            case 4:
                fr = new SponsorshipFragment();
                break;

            case 5:
                fr = new MyScheduleFragment();
                break;

            case 6:
                fr = new KeyNoteSpeakerFragment();
                break;

            case 7:
                fr = new NotificationsFragment();
                break;
            case 8:
                fr = new HotelFragment();
                break;

            default:
                fr = new KeyNoteSpeakerFragment();

        }


//        FragmentManager fm = getSupportFragmentManager();
//
//        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//
//        fragmentTransaction.replace(R.id.fragment_place, fr);
//
//        fragmentTransaction.commit();

    }
}
