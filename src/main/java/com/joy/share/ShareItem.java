package com.joy.share;

import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

/**
 * Created by Daisw on 16/9/7.
 */

public class ShareItem {

    @DrawableRes
    public int mIconResId;
    @StringRes
    public int mNameResId;
    @Nullable
    public DEFAULT mDefault;

    public ShareItem(@DrawableRes int iconResId, @StringRes int nameResId) {

        mIconResId = iconResId;
        mNameResId = nameResId;
    }

    public ShareItem(DEFAULT def) {

        this(def.mIconResId, def.mNameResId);
        mDefault = def;
    }

    public enum DEFAULT {

        WECHAT(R.drawable.ic_share_wechat, R.string.wechat),
        WECHAT_MOMENTS(R.drawable.ic_share_wechat_moments, R.string.wechat_moments),
        QQ(R.drawable.ic_share_qq, R.string.qq),
        WEIBO(R.drawable.ic_share_weibo, R.string.weibo),
        EMAIL(R.drawable.ic_share_email, R.string.email),
        COPY_LINK(R.drawable.ic_share_copylink, R.string.copy_link);

        @DrawableRes
        public int mIconResId;
        @StringRes
        public int mNameResId;

        DEFAULT(@DrawableRes int iconResId, @StringRes int nameResId) {

            mIconResId = iconResId;
            mNameResId = nameResId;
        }
    }
}
