package me.anasmadrhar.githubstars;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import me.anasmadrhar.githubstars.view.Fragment.RepoListFragment;
import me.anasmadrhar.githubstars.view.activity.MainActivity;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class RepoListTest {

    @Rule
    //Activity Test Rule for the activity which contains my login fragment
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void init() {
        //Initail setup method to load my fragment in the activity before beginning to test
        mActivityRule.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer, new RepoListFragment()).commit();
    }

    @Test
    public void OnRecyclerViewClick() throws InterruptedException {
        //Perform type action on the view with id as email
        Espresso.onView(withId(R.id.recyclerView)).perform(click());

    }

    @Test
    public void OnRecyclerViewScroll() throws InterruptedException {
        //Perform type action on the view with id as email
        RecyclerView recyclerView = mActivityRule.getActivity().findViewById(R.id.recyclerView);
        if (recyclerView.getAdapter() != null)
            Espresso.onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.scrollToPosition(recyclerView.getAdapter().getItemCount() - 1));

    }


}
