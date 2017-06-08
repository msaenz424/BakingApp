package com.android.mig.bakingapp.objects;

public class Step {
    final String STEP_ID = "id";
    final String STEP_DESCRIPTION = "shortDescription";
    final String STEP_VIDEO_URL = "videoURL";
    final String STEP_THUMBNAIL_URL = "thumbnailURL";

    private int mStepID;
    private String mStepDescription;
    private String mStepVideoURL;
    private String mStepThumbnailURL;

    public Step(int id, String description, String videoURL, String thumbnailURL){
        mStepID = id;
        mStepDescription = description;
        mStepVideoURL = videoURL;
        mStepThumbnailURL = thumbnailURL;
    }

    public void setStepID(int id){
        mStepID = id;
    }

    public void setStepDescription(String description){
        mStepDescription = description;
    }

    public void setStepVideoURL(String videoURL){
        mStepVideoURL = videoURL;
    }

    public void setmStepThumbnailURL(String thumbnailURL){
        mStepThumbnailURL = thumbnailURL;
    }

    public int getStepID(){return mStepID;}
    public String getStepDescription(){return mStepDescription;}
    public String getStepVideoURL(){return mStepVideoURL;}
    public String getStepThumbnailURL(){return mStepThumbnailURL;}

}
