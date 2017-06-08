package com.android.mig.bakingapp.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.mig.bakingapp.R;
import com.android.mig.bakingapp.objects.Recipe;

import java.util.ArrayList;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipesAdapterViewHolder>{

    ArrayList<Recipe> mRecipeArray;

    public RecipesAdapter(){
        mRecipeArray = new ArrayList<>();
    }

    public void setRecipesAdapter(ArrayList<Recipe> recipeArray){
        mRecipeArray = recipeArray;
        notifyDataSetChanged();
    }

    @Override
    public RecipesAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_recipe, parent, false);
        return new RecipesAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipesAdapterViewHolder holder, int position) {
        String recipeName = mRecipeArray.get(position).getRecipeName();
        holder.mTextViewRecipe.setText(recipeName);
    }

    @Override
    public int getItemCount() {
        return mRecipeArray.size();
    }

    public class RecipesAdapterViewHolder extends RecyclerView.ViewHolder{

        TextView mTextViewRecipe;

        public RecipesAdapterViewHolder(View itemView) {
            super(itemView);
            mTextViewRecipe = (TextView)itemView.findViewById(R.id.text_view_recipe_item);
        }
    }
}
