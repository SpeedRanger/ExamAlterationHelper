package com.example.android.examalterationhelper;

import android.app.Activity;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.Gravity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ScreenTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule
            = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void clickLoginButton_FailsLogin() throws Exception{
        onView(withId(R.id.username_input)).perform(clearText());
        onView(withId(R.id.username_input)).perform(typeText("cb.enadm001"));
        onView(withId(R.id.password_input1)).perform(clearText());
        onView(withId(R.id.password_input1)).perform(typeText("adm001"),closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withText("invalid credentials")).inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    @Test
    public void clickLoginButton_SuccessfulLogin() throws Exception{
        onView(withId(R.id.username_input)).perform(clearText());
        onView(withId(R.id.username_input)).perform(typeText("cb.en.adm001"));
        onView(withId(R.id.password_input1)).perform(clearText());
        onView(withId(R.id.password_input1)).perform(typeText("adm001"),closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withText("login successful")).inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    @Test
    public void username_empty() throws Exception{
        onView(withId(R.id.username_input)).perform(clearText());
        onView(withId(R.id.password_input1)).perform(clearText());
        onView(withId(R.id.password_input1)).perform(typeText("adm001"),closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withText("Enter Username")).inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    @Test
    public void password_empty() throws Exception{
        onView(withId(R.id.username_input)).perform(clearText());
        onView(withId(R.id.username_input)).perform(typeText("cb.en.adm001"),closeSoftKeyboard());
        onView(withId(R.id.password_input1)).perform(clearText());
        onView(withId(R.id.login)).perform(click());
        onView(withText("Enter Password")).inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

//    @Test
//    public void forgot_password() throws Exception {
//        onView(withId(R.id.forgot_password)).perform(click());
//        onView(withId(R.id.edit_fp_un)).perform(typeText("AN"), closeSoftKeyboard());
//        onView(withId(R.id.fp_btn)).perform(click());
//        TimeUnit.MILLISECONDS.sleep(5000);
//        onView(withText("Password Sent")).inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
//
//    }
//    @Test
//    public void request_alteration() throws Exception {
//        onView(withId(R.id.username_input)).perform(clearText());
//        onView(withId(R.id.username_input)).perform(typeText("cb.en.fac001"));
//        onView(withId(R.id.password_input1)).perform(clearText());
//        onView(withId(R.id.password_input1)).perform(typeText("fac001"),closeSoftKeyboard());
//        onView(withId(R.id.login)).perform(click());
//        onView(withId(R.id.drawer_layout))
//                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
//                .perform(DrawerActions.open()); // Open Drawer
//
//        // Start the screen of your activity.
//        onView(withId(R.id.nav_view))
//                .perform(NavigationViewActions.navigateTo(R.id.nav_request));
//        onView(withId(R.id.time_txt)).check(matches(isDisplayed()));
//    }

}




