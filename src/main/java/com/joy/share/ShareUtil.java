package com.joy.share;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.joy.utils.ToastUtil;

import java.io.File;

/**
 * Created by Daisw on 2016/12/9.
 */

public class ShareUtil {

    public static void copyUrl(Activity act, String url) {
        ClipboardManager cm = (ClipboardManager) act.getSystemService(act.CLIPBOARD_SERVICE);
        cm.setPrimaryClip(ClipData.newRawUri("URL", Uri.parse(url)));
        ToastUtil.showToast(act, R.string.toast_share_copy_finish);
    }

    public static void openBrowser(Activity act, String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        act.startActivity(intent);
    }

    public static void shareTextUrl(Activity act, String url, String subject) {
        shareTextUrl(act, url, subject, null);
    }

    public static void shareTextUrl(Activity act, String url, String subject, @Nullable CharSequence title) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, url);
        act.startActivity(Intent.createChooser(intent, title));
    }

    public static void shareImage(Activity act, String imgPath) {
        shareImage(act, imgPath, null);
    }

    public static void shareImage(Activity act, String imgPath, CharSequence title) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        // If you want to share a png image only, you can do: setType("image/png");
        // OR for jpeg: setType("image/jpeg");
        intent.setType("image/*");
        // Make sure you put example png image named myImage.png in your directory
//        String imgPath = Environment.getExternalStorageDirectory() + "/myImage.png";
        File imgFile = new File(imgPath);
        Uri uri = Uri.fromFile(imgFile);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        act.startActivity(Intent.createChooser(intent, title));
    }
}
