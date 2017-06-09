package com.android.mig.bakingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.mig.bakingapp.objects.Ingredient;
import com.android.mig.bakingapp.utils.IngredientsAdapter;

import java.util.ArrayList;

public class IngredientActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

        RecyclerView mIngredientRecyclerView = (RecyclerView) findViewById(R.id.ingredients_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mIngredientRecyclerView.setLayoutManager(linearLayoutManager);

        // retrieves array list that contains ingredients from main activity and sets the adapter with that array
        ArrayList<Ingredient> mIngredientArrayList = getIntent().getParcelableArrayListExtra(String.valueOf(R.string.action_ingredients));
        IngredientsAdapter mIngredientsAdapter = new IngredientsAdapter();
        mIngredientsAdapter.setIngredientAdapter(mIngredientArrayList);
        mIngredientRecyclerView.setAdapter(mIngredientsAdapter);
    }

}
