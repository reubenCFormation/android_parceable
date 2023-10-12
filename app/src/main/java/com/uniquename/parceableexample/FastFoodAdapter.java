package com.uniquename.parceableexample;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.uniquename.parceableexample.javaclass.FastFood;

import java.util.ArrayList;

public class FastFoodAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<FastFood> fastFoods;

    TextView mFastFoodTitle;
    TextView mFastFoodDescription;
    Button  mSeeMealsBtn;

    public FastFoodAdapter(Context context,ArrayList<FastFood> fastFoods){
        this.context=context;
        this.fastFoods=fastFoods;

    }

    public int getCount(){
        return this.fastFoods.size();
    }

    public FastFood getItem(int position){
        return this.fastFoods.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(this.context).inflate(R.layout.list_fast_food,parent,false);
        }
        FastFood fastFood=getItem(position);

        mFastFoodTitle=convertView.findViewById(R.id.fast_food_title);
        mFastFoodDescription=convertView.findViewById(R.id.fast_food_description);
        mSeeMealsBtn=convertView.findViewById(R.id.see_restaurant_meals_btn);

        mFastFoodTitle.setText(fastFood.getTitle());
        mFastFoodDescription.setText(fastFood.getDescription());

        handleViewMenuClick(fastFood,mSeeMealsBtn);

        return convertView;

    }

    public void navigateToActivity(FastFood fastFood){
        Intent newIntent=new Intent(this.context,FastFoodObjectActivity.class);
        newIntent.putExtra("FastFoodObj",fastFood);
        this.context.startActivity(newIntent);
    }

    public void handleViewMenuClick(FastFood fastFood,Button btn){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToActivity(fastFood);

            }
        });
    }

}
