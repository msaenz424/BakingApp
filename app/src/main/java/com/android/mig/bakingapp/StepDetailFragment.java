package com.android.mig.bakingapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class StepDetailFragment extends Fragment {

    private static final String ARG_STEP_DESCRIPTION = "step_description";

    View rootView;

    public StepDetailFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_step_detail, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.text_view_step_description);
        textView.setText(getArguments().getString(ARG_STEP_DESCRIPTION));
        return rootView;
    }

    /**
     * Returns a new instance of this fragment with the corresponding step description to be displayed
     */
    public static StepDetailFragment newInstance(String stepDescription) {
        StepDetailFragment fragment = new StepDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_STEP_DESCRIPTION, stepDescription);
        fragment.setArguments(args);
        return fragment;
    }

}
