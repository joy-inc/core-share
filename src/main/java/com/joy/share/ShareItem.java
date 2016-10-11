package com.joy.share;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

/**
 * Created by Daisw on 16/9/7.
 */

public class ShareItem {

    @DrawableRes
    public int mIconResId;
    @NonNull
    public String mName;

    public ShareItem(@DrawableRes int iconResId, @NonNull String name) {

        mIconResId = iconResId;
        mName = name;
    }

    public ShareItem(DEFAULT def) {

        this(def.mIconResId, def.mName);
    }

    public enum DEFAULT {

        WECHAT(R.drawable.ic_share_wechat, "微信"),
        WECHAT_ZONE(R.drawable.ic_share_wechat_moments, "朋友圈"),
        QQ(R.drawable.ic_share_qq, "QQ"),
        WEIBO(R.drawable.ic_share_weibo, "微博"),
        EMAIL(R.drawable.ic_share_email, "邮件"),
        COPY_LINK(R.drawable.ic_share_copylink, "复制链接");

        @DrawableRes
        public int mIconResId;
        @NonNull
        public String mName;

        DEFAULT(@DrawableRes int iconResId, @NonNull String name) {

            mIconResId = iconResId;
            mName = name;
        }
    }
}
