package com.majstry.eatapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.majstry.eatapp.R;
import com.majstry.eatapp.models.News;
import com.majstry.eatapp.models.SpecialOffer;
import com.majstry.eatapp.models.interfaces.OnNewsClickListener;
import com.majstry.eatapp.models.interfaces.OnSpecialOfferClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class NewsRecyclerAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    private Context mContext;
    private ArrayList<News> mNewses;
    private OnNewsClickListener mListener;

    public NewsRecyclerAdapter(Context context, ArrayList<News> newses) {
        mContext = context;
        mNewses = newses;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_recycler_item, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        News news = mNewses.get(position);

        ViewHolder viewHolder = ((ViewHolder) holder);

        viewHolder.itemView.setTag(viewHolder);
        viewHolder.titleTv.setText(news.getTitle());
        viewHolder.descTv.setText(news.getDesc());
        viewHolder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mNewses.size();
    }

    @Override
    public void onClick(View view) {
        ViewHolder vh = (ViewHolder) view.getTag();
        if (vh != null) {
            int visibility = vh.descTv.getVisibility();
            if (visibility == GONE) {
                if (!vh.descTv.getText().equals("")) {
                    vh.descTv.setVisibility(View.VISIBLE);
                }
            } else if (visibility == VISIBLE) {
                vh.descTv.setVisibility(GONE);
            }
        }
    }

    public void setOnNewsClickListener(OnNewsClickListener onNewsClickListener) {
        mListener = onNewsClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.news_recycler_title_tv)
        TextView titleTv;
        @BindView(R.id.news_recycler_desc_tv)
        TextView descTv;

        public ViewHolder(View view) {
            super(view);

            ButterKnife.bind(this, view);
        }
    }
}
