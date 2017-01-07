package com.majstry.eatapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.majstry.eatapp.R;
import com.majstry.eatapp.models.MenuItemDecorator;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class IngredientsListAdapter extends ArrayAdapter {

    private Context mContext;
    private ArrayList<MenuItemDecorator> mIngredients;

    public IngredientsListAdapter(Context context, ArrayList<MenuItemDecorator> ingredients) {
        super(context, R.layout.ingredient_list_item, ingredients);

        mContext = context;
        mIngredients = ingredients;
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.ingredient_list_item, null);
        }

        MenuItemDecorator ingredient = mIngredients.get(position);

        TextView name = ButterKnife.findById(view, R.id.ingredient_item_name_tv);
        name.setText(ingredient.toString());

        return view;
    }
}
