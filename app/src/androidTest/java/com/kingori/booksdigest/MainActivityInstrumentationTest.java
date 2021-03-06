package com.kingori.booksdigest;

import android.view.View;

import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.kingori.booksdigest.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void listItemClickDisplaysToastWithCorrectBookTitle() {
        View activityDecorView = mActivityTestRule.getActivity().getWindow().getDecorView();
        String bookTitle = "Unbowed";
        onData(anything())
                .inAdapterView(withId(R.id.reviewList))
                .atPosition(0)
                .perform(click());
        onView(withText(bookTitle)).inRoot(withDecorView(not(activityDecorView)))
                .check(matches(withText(bookTitle)));
    }
}
