package com.example.dell.loot;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Dashboard extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ViewPager viewPager=(ViewPager)getView().findViewById(R.id.viewpager);
        DashboardPagerAdapter dashboardPagerAdapter=new DashboardPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(dashboardPagerAdapter);

        TabLayout tabLayout = (TabLayout)getView().findViewById(R.id.tabs);
        tabLayout.setSelected(true);
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        Loot_Application app=(Loot_Application) getActivity().getApplication();
        if(app.user.getActive()==null||app.user.getActive().equalsIgnoreCase(""))
        {
            viewPager.setCurrentItem(1,true);
        }

        



    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
