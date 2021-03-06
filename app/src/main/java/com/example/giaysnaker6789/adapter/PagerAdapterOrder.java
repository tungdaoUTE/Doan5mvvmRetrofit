package com.example.giaysnaker6789.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.example.giaysnaker6789.fragment.Fragment_danggiao;
public class PagerAdapterOrder extends FragmentStatePagerAdapter {

    public PagerAdapterOrder(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag = new Fragment_danggiao("b2");
                break;
            case 1:
                frag = new Fragment_danggiao("b3");
                break;
            case 2:
                frag = new Fragment_danggiao("b4");
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "chờ xác nhận";
                break;
            case 1:
                title = "đang giao";
                break;
            case 2:
                title = "đã giao";
                break;
        }
        return title;
    }
}