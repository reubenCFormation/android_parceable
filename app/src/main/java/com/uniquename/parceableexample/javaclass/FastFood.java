package com.uniquename.parceableexample.javaclass;

/*
Parfois, lors que nous avons un objet qui n'est une entité dans notre base de données, nous allons vouloir transmettre un objet entier d'une activité a une autre pour divers raisons. On pourrai transmettre plusiers informations en faisant appel plusiers fois a la methode getExtra. Cependant, si nous avons un grand objet cela peux devenir fastideux. Heuresement, il existe une solution pour pouvoir rendre nos objets "transmettable" d'une activité a une autre. Ainsi, nous allons pouvoir transmettre l'objet entier

 */

/*
Ici, nous allons rendre notre objet fast food parceable. Ce qui veux dire que il poourra etre serialisable et ainsi va pouvoir etre transmis d'une activité a une autre.
 */

import android.os.Parcel;
import android.os.Parcelable;

// Je crée ma classe FastFood et cette fois si, je vais implementer l'interface parceable qui va pouvoir serialisé mon objet
public class FastFood implements Parcelable {

    private String title;
    private String description;
    private String[] meals;

    public FastFood(String title, String description, String[] meals){
        this.title=title;
        this.description=description;
        this.meals=meals;
    }

    public static final Creator<FastFood> CREATOR=new Creator<FastFood>(){
        @Override
        public FastFood createFromParcel(Parcel parcel){
            // ici je vais creer mon nouveau objet qui sera serialisable. La methode writeToParcel m'a permis de rendre mon instance serialisable et ici avec mon instance de parcel en parametre je vais lire et interpreter  ce qui a etait ecrit et je vais concretement mettre ces informations dans une instance de la classe FastFood
           return new FastFood(parcel.readString(),parcel.readString(),parcel.createStringArray());
        }

        public FastFood[] newArray(int size){
            return new FastFood[size];
        }
    };



    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public String[] getMeals(){
        return this.meals;
    }

    public int describeContents(){
        return 0;
    }

    public void writeToParcel(Parcel dest,int flags){
        /*
            Ici, je vais construire mon object parceable. Mon instance de parcel dest va pouvoir avec ces methodes writeString transmettre une version serialisable de mon instance.Ainsi, mon objet pourra etre transmis via une Intent
         */

        dest.writeString(this.getTitle());
        dest.writeString(this.getDescription());
        dest.writeStringArray(this.getMeals());


    }



}
