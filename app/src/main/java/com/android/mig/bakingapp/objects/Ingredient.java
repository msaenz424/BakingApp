package com.android.mig.bakingapp.objects;


public class Ingredient {
    private double mIngredientQuantity;
    private String mIngredientMeasure;
    private String mIngredient;

    public Ingredient(double quantity, String measure, String ingredient){
        mIngredientQuantity = quantity;
        mIngredientMeasure = measure;
        mIngredient = ingredient;
    }

    public void setIngredientQuantity(double quantity){
        mIngredientQuantity = quantity;
    }

    public void setIngredientMeasure(String measure){
        mIngredientMeasure = measure;
    }

    public void setIngredient(String ingredient){
        mIngredient = ingredient;
    }

    public double getIngredientQuantity(){return mIngredientQuantity;}
    public String getIngredientMeasure(){return mIngredientMeasure;}
    public String getIngredient(){return mIngredient;}

}
