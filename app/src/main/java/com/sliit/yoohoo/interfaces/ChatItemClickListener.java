package com.sliit.yoohoo.interfaces;

import android.view.View;

import com.sliit.yoohoo.models.Group;
import com.sliit.yoohoo.models.User;


public interface ChatItemClickListener {
    void onChatItemClick(String chatId, String chatName, int position, View userImage);

    void onChatItemClick(Group group, int position, View userImage);

    void placeCall(boolean callIsVideo, User user);
}
