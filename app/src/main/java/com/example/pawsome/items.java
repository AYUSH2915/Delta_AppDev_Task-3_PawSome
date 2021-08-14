package com.example.pawsome;

public class items {

    private String imageurl,name,height,weight,temperament,country,breed_type,bred_for,lifespan;



    public items(String imageurl, String name,String height,String weight,String lifespan,String temperament,String breed_type,String bred_for,String country){
        this.imageurl=imageurl;
        this.name=name;
        this.name=name;
        this.height=height;
        this.weight=weight;
        this.temperament=temperament;
        this.country=country;
        this.breed_type=breed_type;
        this.bred_for=bred_for;
        this.lifespan=lifespan;


    }

    public String getImageurl() {
        return imageurl;
    }
    public String getId() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getTemperament() {
        return temperament;
    }

    public String getCountry() {
        return country;
    }

    public String getBreed_type() {
        return breed_type;
    }

    public String getBred_for() {
        return bred_for;
    }

    public String getLifespan() {
        return lifespan;
    }
}
