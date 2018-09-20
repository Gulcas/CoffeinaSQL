package com.example.rfgr.coffeinasql;

public class Snack {
    private String nameSnack;
    private String desciptionSnack;
    private int imageResourceIdSnack;

    public static final Snack[] snacks = {
            new Snack("Chleb", "Stary bez masła", R.drawable.ic_launcher_background),
            new Snack("Masło", "Masło bez chleba- też stare", R.drawable.ic_launcher_background),
            new Snack("Chleb i masło", "Stary, suchy chleb z masłem", R.drawable.ic_launcher_background)
    };

    private Snack(String nameSnack, String desciptionSnack, int imageResourceIdSnack) {
        this.nameSnack = nameSnack;
        this.desciptionSnack = desciptionSnack;
        this.imageResourceIdSnack = imageResourceIdSnack;
    }

    public String getDesciptionSnack() {
        return desciptionSnack;
    }

    public String getNameSnack() {
        return nameSnack;
    }

    public int getImageResourceIdSnack() {
        return imageResourceIdSnack;
    }

    public String toString() {
        return this.nameSnack;
    }
}
