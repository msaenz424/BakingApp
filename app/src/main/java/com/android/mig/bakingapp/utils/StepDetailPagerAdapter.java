package com.android.mig.bakingapp.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.mig.bakingapp.StepDetailFragment;
import com.android.mig.bakingapp.objects.Step;

import java.util.ArrayList;

/**
 * Adapter for PageView in StepDetailActivity
 */

public class StepDetailPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Step> mStepArrayList;

    public StepDetailPagerAdapter(FragmentManager fm) {
        super(fm);
        mStepArrayList = new ArrayList<>();
    }

    public void setStepDetailAdapter(ArrayList<Step> stepArrayList){
        mStepArrayList = stepArrayList;
    }

    @Override
    public Fragment getItem(int position) {
        return StepDetailFragment.newInstance(mStepArrayList.get(position).getStepDescription());
    }

    @Override
    public int getCount() {
        return mStepArrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mStepArrayList.get(position).getStepShortDescription();
    }

}
