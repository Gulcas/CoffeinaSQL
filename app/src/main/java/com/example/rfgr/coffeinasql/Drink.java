package com.example.rfgr.coffeinasql;

public class Drink {
    private String name; //określam jakie parametry będzie miał dany drink
    private String description;
    private int imageResourceId;

    public static final Drink[] drinks = { //tworzę tablicę obiektów klasy Drink
            new Drink("Late", "Czarna breja z mlekiem", R.drawable.ic_launcher_background),
            new Drink("Cappucino", "Napój kawo podobny", R.drawable.ic_launcher_background),
            new Drink("Espresso", "Czarna jak noc listopadowa", R.drawable.ic_launcher_background)
    };

    private Drink(String name, String description, int imageResourceId) { //tworzę konstruktor klasy Drink
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getDescription() { //metody get... pobierają wartości z zmiennych prywatnych
        return description;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String toString() {
        return this.name;
    }
}

