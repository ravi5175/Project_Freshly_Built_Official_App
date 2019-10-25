package com.freshly_built.ravi.feedpost.Java;



// main activity fragments adapter


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

class PagerViewAdapter extends FragmentStatePagerAdapter {
    /*public PagerViewAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }*/

    public PagerViewAdapter(FragmentManager supportFragmentManager)
    {
        super(supportFragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment fragment= null;
        switch (position)
        {
            case 0: fragment= new Fragment_Home();break;
            case 1: fragment= new Fragment_Question();break;
            case 2: fragment =new Fragment_Blog();break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
