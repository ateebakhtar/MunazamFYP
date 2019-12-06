package com.example.munazamfyp.Adapters;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.munazamfyp.Fragments.ReminderView;
import com.example.munazamfyp.Fragments.UserInformation;
import com.example.munazamfyp.Fragments.WorkloadView;
import com.example.munazamfyp.R;
//import com.example.viewpager.R;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES =
            new int[] { R.string.tab_text_1, R.string.tab_text_2,R.string.tab_text_4, R.string.tab_text_5 };
    private final Context mContext;

    public TabsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return WorkloadView.newInstance();
            case 1:
                return ReminderView.newInstance();
            case 2:
                return UserInformation.newInstance();
            default:
                return ReminderView.newInstance();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 4;
    }
}