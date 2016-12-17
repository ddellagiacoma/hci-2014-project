package it.unitn.hci.adapters;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import it.unitn.hci.fragments.AvvisiFragment;
import it.unitn.hci.fragments.ChatFragment;

/**
 * Created by Franco on 15/12/13.
 */
public class SwipeTabAdapter extends FragmentPagerAdapter {

    public SwipeTabAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0: return new AvvisiFragment();
            case 1: return new ChatFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public String getPageTitle(int i){

        switch (i) {
            case 0: return "Avvisi";
            case 1: return "Chat";
        }

        return null;
    }
}
