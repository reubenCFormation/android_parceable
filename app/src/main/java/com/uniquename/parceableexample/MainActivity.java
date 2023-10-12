package com.uniquename.parceableexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.uniquename.parceableexample.javaclass.FastFood;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView mListFastFoods;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFastFoodAdapter();
    }

    public void setFastFoodAdapter(){
        mListFastFoods=findViewById(R.id.fast_food_list);
        ArrayList <FastFood> fastFoods=buildFastFood();
        FastFoodAdapter myFastFoodAdapter=new FastFoodAdapter(MainActivity.this,fastFoods);
        mListFastFoods.setAdapter(myFastFoodAdapter);
    }

    public ArrayList<FastFood> buildFastFood(){
        ArrayList <FastFood> fastFoods=new ArrayList<>();
        FastFood fastFood1=new FastFood("DoMac","The healthiest food in the world",new String[] {"Beef burger","Chicken burger","Chicken Salad","mcDouble whooper"});
        FastFood fastFood2=new FastFood("O'tacos","The best and healthiest french tacos ever",new String[]{"Le Fameaux","Le supreme","L'alpin","Le cordon bleau"});
        FastFood fastFood3=new FastFood("KFC","the best fried chicken started by Colonel Sanders at the young age of 62",new String[]{"Friec chicken ice cream","Fried Chicken Burger","Fried Chicken Ketchup","Fried chicken legs","Fried chicken wings"});

        fastFoods.add(fastFood1);
        fastFoods.add(fastFood2);
        fastFoods.add(fastFood3);

        return fastFoods;
    }
}