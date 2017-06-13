package com.android.mig.bakingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.mig.bakingapp.objects.Step;
import com.android.mig.bakingapp.utils.StepDetailPagerAdapter;

import java.util.ArrayList;

public class StepDetailFragment extends Fragment {

    private static final String ARG_STEP_DESCRIPTION = "step_description";
    private static final int STARTING_POSITION = 0;
    private StepDetailPagerAdapter mStepDetailPagerAdapter;
    private ViewPager mViewPager;
    int mPosition;
    View rootView;

    public StepDetailFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_step_detail, container, false);

        // retrieves the array of steps that was passed from StepListFragment
        ArrayList<Step> mStepArrayList = getActivity().getIntent().getParcelableArrayListExtra(Intent.EXTRA_TEXT);
        mPosition = getActivity().getIntent().getIntExtra(Intent.EXTRA_UID, STARTING_POSITION);

        // Create the adapter that will return a fragment for each step
        mStepDetailPagerAdapter = new StepDetailPagerAdapter(getChildFragmentManager());
        mStepDetailPagerAdapter.setStepDetailAdapter(mStepArrayList);

        // Set up the ViewPager with the sections adapter and displays the step that was selected
        mViewPager = (ViewPager) rootView.findViewById(R.id.viewpager_step_detail);
        mViewPager.setAdapter(mStepDetailPagerAdapter);
        mViewPager.setCurrentItem(mPosition);

        return rootView;
    }

    /**
     * This fragment just holds the view that goes inside the ViewPager
     */
    public static class ViewPagerSubFragment extends Fragment{
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View subView = inflater.inflate(R.layout.fragment_step_detail_slide_page, container, false);
            TextView textView = (TextView) subView.findViewById(R.id.text_view_step_description);
            textView.setText(getArguments().getString(ARG_STEP_DESCRIPTION));
            return subView;
        }

        /**
         * Returns a new instance of this fragment with the corresponding step description to be displayed
         */
        public static ViewPagerSubFragment newInstance(String stepDescription) {
            ViewPagerSubFragment fragment = new ViewPagerSubFragment();
            Bundle args = new Bundle();
            args.putString(ARG_STEP_DESCRIPTION, stepDescription);
            fragment.setArguments(args);
            return fragment;
        }
    }

}
