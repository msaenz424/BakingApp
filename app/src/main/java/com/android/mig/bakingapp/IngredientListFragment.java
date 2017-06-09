package com.android.mig.bakingapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.mig.bakingapp.objects.Ingredient;
import com.android.mig.bakingapp.utils.IngredientsAdapter;

import java.util.ArrayList;


public class IngredientListFragment extends Fragment {

    View rootView;
    IngredientsAdapter mIngredientsAdapter;

    public IngredientListFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_ingredien_list, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.ingredients_recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<Ingredient> mIngredientArrayList = getActivity().getIntent().getParcelableArrayListExtra(String.valueOf(R.string.action_ingredients));
        mIngredientsAdapter = new IngredientsAdapter();
        recyclerView.setAdapter(mIngredientsAdapter);
        mIngredientsAdapter.setIngredientAdapter(mIngredientArrayList);

        return rootView;
    }
}
