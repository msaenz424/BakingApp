package com.android.mig.bakingapp;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.android.mig.bakingapp.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityScreenTest {

    public static final String INGREDIENT_TEXT = "unsalted butter, melted";

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void clickRecyclerViewIngredientsButton_OpensIngredientActivity(){
        // clicks on button "Ingredients" within the RecyclerView item at position 0
        onView(withId(R.id.recipe_list_fragment)).perform(
                RecyclerViewActions.actionOnItemAtPosition(0, MyViewAction.clickChildViewWithId(R.id.button_ingredients)));

        // checks if INGREDIENT_TEXT is found in RecyclerView at position 1
        onView(withId(R.id.ingredient_list_fragment))
                .check(matches(MyRecyclerViewMatcher.atPositionOnView(1, withText(INGREDIENT_TEXT), R.id.text_view_ingredient)));
    }
}