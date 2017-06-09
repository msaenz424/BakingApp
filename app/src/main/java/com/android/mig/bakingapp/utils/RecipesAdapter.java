package com.android.mig.bakingapp.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.mig.bakingapp.R;
import com.android.mig.bakingapp.objects.Ingredient;
import com.android.mig.bakingapp.objects.Recipe;

import java.util.ArrayList;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipesAdapterViewHolder>{

    ArrayList<Recipe> mRecipeArray;
    final private OnIngredientClickHandler mOnIngredientClickHandler;

    public RecipesAdapter(Context context){
        mRecipeArray = new ArrayList<>();
        mOnIngredientClickHandler = (OnIngredientClickHandler) context;
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

    public class RecipesAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mTextViewRecipe;
        Button mButtonIngredient;

        public RecipesAdapterViewHolder(View itemView) {
            super(itemView);
            mTextViewRecipe = (TextView)itemView.findViewById(R.id.text_view_recipe_item);
            mButtonIngredient = (Button) itemView.findViewById(R.id.button_ingredients);
            mButtonIngredient.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == mButtonIngredient.getId()){
                mOnIngredientClickHandler.OnClick(mRecipeArray.get(getAdapterPosition()).getRecipeIngredient());
            }
        }
    }

    public interface OnIngredientClickHandler{
        void OnClick(ArrayList<Ingredient> ingredients);
    }

}
