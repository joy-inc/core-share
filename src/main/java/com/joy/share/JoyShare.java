package com.joy.share;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.GridLayoutManager;

import com.joy.ui.adapter.OnItemClickListener;
import com.joy.ui.view.bottomsheet.JBottomSheetRvDialog;
import com.joy.ui.view.recyclerview.ItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daisw on 16/9/7.
 */

public class JoyShare {

    private static final int DEFAULT_SPAN_COLUMN = 4;
    private final JBottomSheetRvDialog mShareDialog;
    private final ShareAdapter mShareAdapter;

    public JoyShare(Context context) {
        TypedArray ta = context.obtainStyledAttributes(R.styleable.JBottomSheetRvDialog);
        int spanColumn = ta.getInteger(R.styleable.JBottomSheetRvDialog_shareColumn, DEFAULT_SPAN_COLUMN);
        int verticalSpacing = ta.getDimensionPixelSize(R.styleable.JBottomSheetRvDialog_shareVerticalSpacing, 0);
        int parentPadding = ta.getDimensionPixelSize(R.styleable.JBottomSheetRvDialog_shareParentPadding, 0);
        ta.recycle();
        mShareDialog = new JBottomSheetRvDialog(context);
        mShareDialog.setLayoutManager(new GridLayoutManager(context, spanColumn));
        mShareDialog.addItemDecoration(ItemDecoration.builder(context)
                .dividerSize(0)
                .verticalSpace(verticalSpacing)
                .paddingParent(parentPadding)
                .build());
        mShareAdapter = new ShareAdapter();
        mShareDialog.setAdapter(mShareAdapter);
    }

    public final List<ShareItem> getDefaultItems() {
        ShareItem.DEFAULT[] defaultItems = ShareItem.DEFAULT.values();
        List<ShareItem> shareItems = new ArrayList<>();
        for (ShareItem.DEFAULT item : defaultItems) {
            shareItems.add(new ShareItem(item));
        }
        return shareItems;
    }

    public final ShareAdapter getAdapter() {
        return mShareAdapter;
    }

    public final List<ShareItem> getData() {
        return mShareAdapter.getData();
    }

    public final void setData(List<ShareItem> shareItems) {
        int itemCount = mShareAdapter.getItemCount();
        mShareAdapter.setData(shareItems);
        mShareAdapter.notifyItemRangeChanged(0, itemCount);
    }

    public final void add(ShareItem item) {
        int insertPosition = mShareAdapter.getItemCount();
        mShareAdapter.add(item);
        mShareAdapter.notifyItemInserted(insertPosition);
    }

    public final void add(int position, ShareItem item) {
        mShareAdapter.add(position, item);
        mShareAdapter.notifyItemInserted(position);
    }

    public final void addAll(List<ShareItem> items) {
        int insertPosition = mShareAdapter.getItemCount();
        mShareAdapter.addAll(items);
        mShareAdapter.notifyItemRangeInserted(insertPosition, items.size());
    }

    public final void addAll(int position, List<ShareItem> items) {
        mShareAdapter.addAll(position, items);
        mShareAdapter.notifyItemRangeInserted(position, items.size());
    }

    public final void remove(int position) {
        mShareAdapter.remove(position);
        mShareAdapter.notifyItemRemoved(position);
    }

    public final void remove(ShareItem item) {
        int removePosition = mShareAdapter.indexOf(item);
        mShareAdapter.remove(item);
        mShareAdapter.notifyItemRemoved(removePosition);
    }

    public final void clear() {
        int itemCount = mShareAdapter.getItemCount();
        mShareAdapter.clear();
        mShareAdapter.notifyItemRangeRemoved(0, itemCount);
    }

    public final void setOnItemClickListener(OnItemClickListener<ShareItem> l) {
        mShareAdapter.setOnItemClickListener(l);
    }

    public final void show() {
        mShareDialog.show();
    }

    public final void dismiss() {
        mShareDialog.dismiss();
    }
}
