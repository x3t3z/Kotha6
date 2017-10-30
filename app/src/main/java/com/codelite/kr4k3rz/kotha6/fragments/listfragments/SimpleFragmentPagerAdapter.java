package com.codelite.kr4k3rz.kotha6.fragments.listfragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.codelite.kr4k3rz.kotha6.R;


public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;


    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new RoomLocationFragment();
        } else if (position == 1) {
            return new RoomInfoFragment();
        } else if (position == 2) {
            return new TenantInfoFragment();
        } else if (position == 3) {
            return new RoomDescFragment();
        } else {
            return new PreviewFragment();
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 5;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.location);
            case 1:
                return mContext.getString(R.string.room_info);
            case 2:
                return mContext.getString(R.string.tenant_info);
            case 3:
                return mContext.getString(R.string.room_desc);
            case 4:
                return mContext.getString(R.string.preview);
            default:
                return null;
        }
    }


}
