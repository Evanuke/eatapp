package com.majstry.eatapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.majstry.eatapp.R;
import com.majstry.eatapp.models.MenuItem;
import com.majstry.eatapp.models.interfaces.OnMenuItemClickListener;

import java.text.DecimalFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuItemRecyclerAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    private Context mContext;
    private ArrayList<MenuItem> mMenuItems;
    private OnMenuItemClickListener mListener;

    public MenuItemRecyclerAdapter(Context context, ArrayList<MenuItem> menuItems) {
        mContext = context;
        mMenuItems = menuItems;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_item_recycler_item, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MenuItem item = mMenuItems.get(position);

        ViewHolder viewHolder = ((ViewHolder) holder);

        String price = new DecimalFormat("0.00").format(item.getPrice()) + "zł";

        viewHolder.itemView.setTag(item);
        viewHolder.nameTv.setText(item.getName());
        viewHolder.priceTv.setText(price);
        Glide.with(mContext)
                .load(item.getImageUrl())
                .centerCrop()
                .into(viewHolder.imageView);
        viewHolder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mMenuItems.size();
    }

    @Override
    public void onClick(View view) {
        MenuItem menuItem = (MenuItem) view.getTag();
        if (menuItem != null) {
            mListener.onMenuItemClicked(menuItem);
        }
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        mListener = onMenuItemClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.menu_item_recycler_item_rl)
        RelativeLayout itemRl;
        @BindView(R.id.menu_item_recycler_iv)
        ImageView imageView;
        @BindView(R.id.menu_item_recycler_name_tv)
        TextView nameTv;
        @BindView(R.id.menu_item_recycler_price_tv)
        TextView priceTv;

        public ViewHolder(View view) {
            super(view);

            ButterKnife.bind(this, view);
        }
    }
}
