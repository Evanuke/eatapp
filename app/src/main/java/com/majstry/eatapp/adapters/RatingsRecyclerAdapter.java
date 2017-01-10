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
import com.majstry.eatapp.models.Rating;
import com.majstry.eatapp.models.interfaces.OnMenuItemClickListener;

import java.text.DecimalFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RatingsRecyclerAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private ArrayList<Rating> mRatings;

    public RatingsRecyclerAdapter(Context context, ArrayList<Rating> ratings) {
        mContext = context;
        mRatings = ratings;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ratings_recycler_item, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Rating rating = mRatings.get(position);

        ViewHolder viewHolder = ((ViewHolder) holder);

        viewHolder.nameTv.setText(rating.getName());
        viewHolder.ratingTv.setText(String.valueOf(rating.getRating()));
        Glide.with(mContext)
                .load(rating.getImgUrl())
                .centerCrop()
                .into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return mRatings.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ratings_recycler_iv)
        ImageView imageView;
        @BindView(R.id.ratings_recycler_name_tv)
        TextView nameTv;
        @BindView(R.id.ratings_recycler_item_rating_tv)
        TextView ratingTv;

        public ViewHolder(View view) {
            super(view);

            ButterKnife.bind(this, view);
        }
    }
}
