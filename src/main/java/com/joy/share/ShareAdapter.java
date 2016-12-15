package com.joy.share;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.joy.ui.adapter.ExRvAdapter;
import com.joy.ui.adapter.ExRvViewHolder;

/**
 * Created by Daisw on 16/9/7.
 */

public class ShareAdapter extends ExRvAdapter<ShareAdapter.ViewHolder, ShareItem> {

    class ViewHolder extends ExRvViewHolder<ShareItem> {

        ImageView mIvIcon;
        TextView mTvName;

        public ViewHolder(View v) {
            super(v);
            mIvIcon = (ImageView) v.findViewById(R.id.ivIcon);
            mTvName = (TextView) v.findViewById(R.id.tvName);
            float textSize = mTvName.getTextSize();
            mTvName.setMaxWidth((int) (textSize * 4.7));
            v.setOnClickListener((v1) -> callbackOnItemClickListener(getLayoutPosition(), v1));
        }

        @Override
        public void invalidateItemView(int position, ShareItem shareItem) {
            mIvIcon.setImageResource(shareItem.mIconResId);
            mTvName.setText(shareItem.mNameResId);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflateLayout(parent, R.layout.lib_item_share));
    }
}
