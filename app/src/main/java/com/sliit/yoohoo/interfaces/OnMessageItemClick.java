package com.sliit.yoohoo.interfaces;

import com.sliit.yoohoo.models.Message;


public interface OnMessageItemClick {
    void OnMessageClick(Message message, int position);

    void OnMessageLongClick(Message message, int position);
}
