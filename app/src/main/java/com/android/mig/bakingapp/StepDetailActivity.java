package com.android.mig.bakingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.android.mig.bakingapp.objects.Step;
import com.android.mig.bakingapp.utils.StepDetailPagerAdapter;

import java.util.ArrayList;

public class StepDetailActivity extends AppCompatActivity {

    private static final int STARTING_POSITION = 0;

    private StepDetailPagerAdapter mStepDetailPagerAdapter;
    private ViewPager mViewPager;
    int mPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_detail);

        ArrayList<Step> mStepArrayList = getIntent().getParcelableArrayListExtra(Intent.EXTRA_TEXT);
        mPosition = getIntent().getIntExtra(Intent.EXTRA_UID, STARTING_POSITION);

        // Create the adapter that will return a fragment for each step
        mStepDetailPagerAdapter = new StepDetailPagerAdapter(getSupportFragmentManager());
        mStepDetailPagerAdapter.setStepDetailAdapter(mStepArrayList);

        // Set up the ViewPager with the sections adapter and displays the step that was selected
        mViewPager = (ViewPager) findViewById(R.id.viewpager_step_detail);
        mViewPager.setAdapter(mStepDetailPagerAdapter);
        mViewPager.setCurrentItem(mPosition);
    }
}
