package it.unitn.hci.activities;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v4.view.ViewPager;
import it.unitn.hci.R;

import it.unitn.hci.adapters.SwipeTabAdapter;

/**
 * Created by Franco on 15/12/13.
 */
public class Group extends FragmentActivity {

    private ViewPager viewPager;
    private SwipeTabAdapter mAdapter;
    private ActionBar actionBar;
    // Tab titles
    private String[] tabs = {"Avvisi", "Chat"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group);


        viewPager = (ViewPager) findViewById(R.id.pager);
        mAdapter = new SwipeTabAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mAdapter);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle(getIntent().getStringExtra("groupName"));
    }
}