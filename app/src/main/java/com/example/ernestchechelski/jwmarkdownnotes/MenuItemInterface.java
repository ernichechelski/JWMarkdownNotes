package com.example.ernestchechelski.jwmarkdownnotes;

import android.view.View;

import com.daimajia.swipe.SwipeLayout;

import org.parceler.Parcel;

/**
 * Created by ernest.chechelski on 12/5/2017.
 */

public interface MenuItemInterface {

    //To add swipelistener
    View onGenerateView(SwipeLayout itemLayout,View v,MenuItem item);

}
