package com.majstry.eatapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.majstry.eatapp.R;
import com.majstry.eatapp.models.MenuItem;
import com.majstry.eatapp.models.SpecialOffer;
import com.majstry.eatapp.models.interfaces.OnMenuItemClickListener;
import com.majstry.eatapp.models.interfaces.OnSpecialOfferClickListener;

import java.text.DecimalFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpecialOfferRecyclerAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    private Context mContext;
    private ArrayList<SpecialOffer> mSpecialOffers;
    private OnSpecialOfferClickListener mListener;

    public SpecialOfferRecyclerAdapter(Context context, ArrayList<SpecialOffer> specialOffers) {
        mContext = context;
        mSpecialOffers = specialOffers;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.special_offer_recycler_item, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SpecialOffer so = mSpecialOffers.get(position);

        ViewHolder viewHolder = ((ViewHolder) holder);

        int dc = (int) (so.getDiscount() * 100);

        String discount = String.valueOf(dc) + "%";

        viewHolder.itemView.setTag(so);
        viewHolder.nameTv.setText(so.getName());
        viewHolder.discountTv.setText(discount);
        viewHolder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mSpecialOffers.size();
    }

    @Override
    public void onClick(View view) {
        SpecialOffer specialOffer = (SpecialOffer) view.getTag();
        if (specialOffer != null) {
            mListener.onSpecialOfferClicked(specialOffer);
        }
    }

    public void setOnSpecialOfferClickListener(OnSpecialOfferClickListener onSpecialOfferClickListener) {
        mListener = onSpecialOfferClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.special_offer_recycler_name_tv)
        TextView nameTv;
        @BindView(R.id.special_offer_recycler_discount_tv)
        TextView discountTv;

        public ViewHolder(View view) {
            super(view);

            ButterKnife.bind(this, view);
        }
    }
}
