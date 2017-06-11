package com.android.mig.bakingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.mig.bakingapp.objects.Step;
import com.android.mig.bakingapp.utils.StepsAdapter;

import java.util.ArrayList;


public class StepListFragment extends Fragment {

    StepsAdapter mStepsAdapter;
    View rootView;

    public StepListFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_recipe_list, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recipes_recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<Step> mStepArrayList = getActivity().getIntent().getParcelableArrayListExtra(String.valueOf(R.string.action_steps));
        mStepsAdapter = new StepsAdapter();
        recyclerView.setAdapter(mStepsAdapter);
        mStepsAdapter.setStepsAdapter(mStepArrayList, new StepsAdapter.OnClickHandler() {
            @Override
            public void OnClick(ArrayList<Step> stepArrayList, int position) {
                Intent intent = new Intent(getActivity(), StepDetailActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, stepArrayList);
                intent.putExtra(Intent.EXTRA_UID, position);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
