package com.sliit.yoohoo.viewHolders;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.sliit.yoohoo.R;
import com.sliit.yoohoo.activities.ImageViewerActivity;
import com.sliit.yoohoo.interfaces.OnMessageItemClick;
import com.sliit.yoohoo.models.Message;
import com.sliit.yoohoo.utils.Helper;


public class MessageAttachmentImageViewHolder extends BaseMessageViewHolder {
    ImageView image;
    LinearLayout ll;

    public MessageAttachmentImageViewHolder(View itemView, OnMessageItemClick itemClickListener) {
        super(itemView, itemClickListener);
        image = itemView.findViewById(R.id.image);
        ll = itemView.findViewById(R.id.container);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick(true);
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemClick(false);
                return true;
            }
        });
    }

    @Override
    public void setData(final Message message, int position) {
        super.setData(message, position);

        cardView.setCardBackgroundColor(ContextCompat.getColor(context, message.isSelected() ? R.color.colorPrimary : R.color.colorBgLight));
        ll.setBackgroundColor(message.isSelected() ? ContextCompat.getColor(context, R.color.colorPrimary) : isMine() ? Color.WHITE : ContextCompat.getColor(context, R.color.colorBgLight));

        Glide.with(context).load(message.getAttachment().getUrl())
                .apply(new RequestOptions().placeholder(R.drawable.yoohoo_placeholder).diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(image);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Helper.CHAT_CAB)
                    context.startActivity(ImageViewerActivity.newUrlInstance(context, message.getAttachment().getUrl()));
            }
        });

    }
}
