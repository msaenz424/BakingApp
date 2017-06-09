package com.android.mig.bakingapp.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.mig.bakingapp.R;
import com.android.mig.bakingapp.objects.Step;

import java.util.ArrayList;

public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.StepsAdapterViewHolder>{

    ArrayList<Step> mStepsArray;

    public StepsAdapter(){
        mStepsArray = new ArrayList<>();
    }

    public void setStepsAdapter(ArrayList<Step> stepArray){
        mStepsArray = stepArray;
        notifyDataSetChanged();
    }

    @Override
    public StepsAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_step, parent, false);

        return new StepsAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StepsAdapterViewHolder holder, int position) {
        holder.mTextViewStep.setText(mStepsArray.get(position).getStepShortDescription());
    }

    @Override
    public int getItemCount() {
        if (mStepsArray != null)
            return mStepsArray.size();
        return 0;
    }

    public class StepsAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView mTextViewStep;

        public StepsAdapterViewHolder(View itemView) {
            super(itemView);
            mTextViewStep = (TextView) itemView.findViewById(R.id.text_view_step);
        }
    }
}
