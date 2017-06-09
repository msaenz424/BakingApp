package com.android.mig.bakingapp.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.mig.bakingapp.R;
import com.android.mig.bakingapp.objects.Ingredient;
import com.android.mig.bakingapp.objects.Recipe;
import com.android.mig.bakingapp.objects.Step;

import java.util.ArrayList;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipesAdapterViewHolder>{

    ArrayList<Recipe> mRecipeArray;
    final private OnClickHandler mOnClickHandler;

    public RecipesAdapter(OnClickHandler clickHandler){
        mRecipeArray = new ArrayList<>();
        mOnClickHandler = clickHandler;
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
        Button mButtonStep;

        public RecipesAdapterViewHolder(View itemView) {
            super(itemView);
            mTextViewRecipe = (TextView)itemView.findViewById(R.id.text_view_recipe_item);
            mButtonIngredient = (Button) itemView.findViewById(R.id.button_ingredients);
            mButtonIngredient.setOnClickListener(this);
            mButtonStep = (Button) itemView.findViewById(R.id.button_steps);
            mButtonStep.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == mButtonIngredient.getId())
                mOnClickHandler.OnClickIngredient(mRecipeArray.get(getAdapterPosition()).getRecipeIngredient());
            else if (view.getId() == mButtonStep.getId()){
                mOnClickHandler.OnClickStep(mRecipeArray.get(getAdapterPosition()).getRecipeStep());
            }
        }
    }

    public interface OnClickHandler{
        void OnClickIngredient(ArrayList<Ingredient> ingredients);
        void OnClickStep(ArrayList<Step> steps);
    }

}
