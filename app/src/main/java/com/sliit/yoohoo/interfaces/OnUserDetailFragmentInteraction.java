package com.sliit.yoohoo.interfaces;

import com.sliit.yoohoo.models.Message;

import java.util.ArrayList;


public interface OnUserDetailFragmentInteraction {
    void getAttachments();

    ArrayList<Message> getAttachments(int tabPos);

    void switchToMediaFragment();
}
