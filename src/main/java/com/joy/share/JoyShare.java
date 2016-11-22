package com.joy.share;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

import com.joy.ui.adapter.OnItemClickListener;
import com.joy.ui.view.bottomsheet.JBottomSheetRvDialog;
import com.joy.ui.view.recyclerview.ItemDecoration;

import java.util.ArrayList;
import java.util.List;

import static com.joy.ui.utils.DimenCons.DP_1_PX;

/**
 * Created by Daisw on 16/9/7.
 */

public class JoyShare {

    private final JBottomSheetRvDialog mShareDialog;
    private final ShareAdapter mShareAdapter;

    public JoyShare(Context context) {
        mShareDialog = new JBottomSheetRvDialog(context);
        mShareDialog.setLayoutManager(new GridLayoutManager(context, 3));
        mShareDialog.addItemDecoration(new ItemDecoration.Builder(context)
                .dividerSize(0)
                .verticalSpace(DP_1_PX * 16)
                .paddingParent(DP_1_PX * 24)
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
