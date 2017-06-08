package com.android.mig.bakingapp.objects;

import java.util.ArrayList;

public class Recipe {

    private int mRecipeID;
    private String mRecipeName;
    private ArrayList<Ingredient> mRecipeIngredient;
    private ArrayList<Step> mRecipeStep;
    private int mRecipeServings;
    private String mRecipeImage;

    public Recipe(int id, String name, ArrayList<Ingredient> ingredients, ArrayList<Step> steps, int servings, String image){
        mRecipeID = id;
        mRecipeName = name;
        mRecipeIngredient = ingredients;
        mRecipeStep = steps;
        mRecipeServings = servings;
        mRecipeImage = image;
    }

    public void setmRecipeID(int id){
        mRecipeID = id;
    }
    public void setmRecipeName(String name){
        mRecipeName = name;
    }
    public void setmRecipeIngredient(ArrayList<Ingredient> ingredients){
        mRecipeIngredient = ingredients;
    }
    public void setmRecipeStep(ArrayList<Step> steps){
        mRecipeStep = steps;
    }
    public void setmRecipeServings(int servings){
        mRecipeServings = servings;
    }
    public void setmRecipeImage(String image){
        mRecipeImage = image;
    }

    public int getRecipeID(){return mRecipeID;}
    public String getRecipeName(){return mRecipeName;}
    public ArrayList<Ingredient> getRecipeIngredient(){return mRecipeIngredient;}
    public ArrayList<Step> getmRecipeStep(){return mRecipeStep;}
    public int getRecipeServings(){return mRecipeServings;}
    public String getRecipeImage(){return mRecipeImage;}
}
