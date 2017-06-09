package com.android.mig.bakingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.mig.bakingapp.objects.Ingredient;
import com.android.mig.bakingapp.utils.RecipesAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecipesAdapter.OnIngredientClickHandler{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void OnClick(ArrayList<Ingredient> ingredients) {
        Intent intent = new Intent(this, IngredientActivity.class);
        intent.putExtra(String.valueOf(R.string.action_ingredients), ingredients);
        startActivity(intent);
    }
}
