package com.example.android.examalterationhelper;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.Gravity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

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


public class NavBarTest {
    @Rule
    public ActivityTestRule<admin_pg> activityTestRule
            = new ActivityTestRule<>(admin_pg.class);
    @Test
    public void clickOnYourNavigationItem_Register() {
        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        // Start the screen of your activity.
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_reg));

        // Check that you Activity was opened.
        onView(withId(R.id.register_clipart)).check(matches(isDisplayed()));
    }
    @Test
    public void clickOnYourNavigationItem_Update() {
        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        // Start the screen of your activity.
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_update));

        // Check that you Activity was opened.
        onView(withId(R.id.update_details_clipart)).check(matches(isDisplayed()));
    }
    @Test
    public void clickOnYourNavigationItem_ExamTimeTable() {
        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        // Start the screen of your activity.
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_timetable));

        // Check that you Activity was opened.
        onView(withId(R.id.proceed_date)).check(matches(isDisplayed()));
    }

//    @Test
//    public void clickOnYourNavigationItem_RequestsReceived() {
//        // Open Drawer to click on navigation.
//        onView(withId(R.id.drawer_layout))
//                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
//                .perform(DrawerActions.open()); // Open Drawer
//
//        // Start the screen of your activity.
//        onView(withId(R.id.nav_view))
//                .perform(NavigationViewActions.navigateTo(R.id.nav_rcvd_req));
//
//        // Check that you Activity was opened.
//        onView(withId(R.id.req_title)).check(matches(isDisplayed()));
//    }
//
//    @Test
//    public void clickOnYourNavigationItem_RequestAlteration() {
//        // Open Drawer to click on navigation.
//        onView(withId(R.id.drawer_layout))
//                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
//                .perform(DrawerActions.open()); // Open Drawer
//
//        // Start the screen of your activity.
//        onView(withId(R.id.nav_view))
//                .perform(NavigationViewActions.navigateTo(R.id.nav_request));
//
//        // Check that you Activity was opened.
//        onView(withId(R.id.req_title)).check(matches(isDisplayed()));
//    }

}
