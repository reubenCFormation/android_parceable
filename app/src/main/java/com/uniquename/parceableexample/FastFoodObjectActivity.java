package com.uniquename.parceableexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.uniquename.parceableexample.javaclass.FastFood;

public class FastFoodObjectActivity extends AppCompatActivity {
    TextView mTitleText;
    ListView mListMeals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_food_object);
        setTitleText();
        setArrayAdapter();
    }

   public FastFood getIntentFastFoodObj(){
        Intent getIntent=getIntent();
        // ici je vais pouvoir recuperer mon objet entier grace au fait que il implemente l'interface parceable
        FastFood fastFoodObj=getIntent.getParcelableExtra("FastFoodObj");
        return fastFoodObj;
   }

   public void setTitleText(){
        mTitleText=findViewById(R.id.fast_food_meals_title);
        FastFood getFastFoodObj=getIntentFastFoodObj();
        mTitleText.setText("Liste de restaurants chez"+" "+getFastFoodObj.getTitle());
   }
    public void setArrayAdapter(){
        mListMeals=findViewById(R.id.list_restaurant_meals);
         FastFood getFastFoodObj=getIntentFastFoodObj();
        ArrayAdapter arrayAdapter=new ArrayAdapter(FastFoodObjectActivity.this,android.R.layout.simple_list_item_1,getFastFoodObj.getMeals());
        mListMeals.setAdapter(arrayAdapter);
    }
}