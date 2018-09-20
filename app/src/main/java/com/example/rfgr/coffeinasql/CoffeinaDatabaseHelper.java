package com.example.rfgr.coffeinasql;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class CoffeinaDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "cofeina"; //określam nazwę bazy dany SQLite, jeżeli nie zostanie określona to po zamknięciu aplikacji nie zostanie zapisana
    private static final int DB_VERSION = 1; //określam numer wersji bazy danych SQLite, jeżeli SQLite Helper wykryje że na urządzeniu jest już zainstalaowana baza to
    //na podstawie określonego numeru wersji wyższego odpali metodę onUpgrade lub na podstawie niższego onDowngrade, a jeżeli nie ma bazy na urządzeniu to onCreate

    CoffeinaDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION); //wywołuję konstruktor i przekazuję mu nazwę oraz numer wersji bazy danych SQLite
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //metoda onCreate jest wywołana przy okazji pierwszego tworzenia bazy danych i dlatego używana zostaje do
        // zapisania w niej początkowych danych

        /** poniższa metoda tworzy pustą bazę danych i określa jakie kolumny będzie ona zawierać,
         db.execSQL("CREATE TABLE DRINK (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + //pierwsza kolumna _id jest główną i automatycznie zostaje zwiększana
         "NAME TEXT," + //druga NAME to tekst
         "DESCRIPTION TEXT," + //trzecia DESCRIPTION to też tekst
         "IMAGE_RESOURCE_ID INTEGER);"); //czwarta to określenie lokalizacji pliku obrazu
         insertDrink(db, "Latte", "Taka kawa latte", R.drawable.ic_launcher_background); //dodaję wiersz do tabeli bazy danych za pomocą przygotowanej poniżej metody
         insertDrink(db, "Kawa 2", "Taka kawa 2", R.drawable.ic_launcher_background);
         insertDrink(db, "Kawa 3", "Taka kawa 3", R.drawable.ic_launcher_background); */
        updateMyDatabase(db, 0, DB_VERSION); //zamiast tworzyć bazę w metodzie onCreate, wywołam tu inną metodę która utworzy bazę danych dzięki czemu będę mógł wykorzystać
        //tą metodę zarówno do aktualizacji istniejących baz danych jak i do tworzenia nowych baz danych
    }

    @Override //metoda wywoływana do zaktualizowania bazy danych
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion); //metoda onUpgrade również wykorzysta utworzoną metodę updateMyDatabase, co zaoszczędza pisania tego samego kodu w 2 miejscach
    }

    //metoda insertDrink ułatwiająca nam wprowadzanie danych do bazy danych SQLite
    private static void insertDrink(SQLiteDatabase db, String name, String description, int resourceId) {
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("NAME", name);
        drinkValues.put("DESCRIPTION", description);
        drinkValues.put("IMAGTE_RESOURCE_ID", resourceId);
        db.insert("DRINK", null, drinkValues);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) { //jeżeli na urządzeniu nie ma zainstalowanej bazy to tworzę ją
            db.execSQL("CREATE TABLE DRINK (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + //pierwsza kolumna _id jest główną i automatycznie zostaje zwiększana
                    "NAME TEXT," + //druga NAME to tekst
                    "DESCRIPTION TEXT," + //trzecia DESCRIPTION to też tekst
                    "IMAGE_RESOURCE_ID INTEGER);"); //czwarta to określenie lokalizacji pliku obrazu
            insertDrink(db, "Latte", "Taka kawa latte", R.drawable.ic_launcher_background); //dodaję wiersz do tabeli bazy danych za pomocą przygotowanej poniżej metody
            insertDrink(db, "Kawa 2", "Taka kawa 2", R.drawable.ic_launcher_background);
            insertDrink(db, "Kawa 3", "Taka kawa 3", R.drawable.ic_launcher_background);
        }
        if (oldVersion < 2) { //jeżeli zainstalowana wersja bazy jest niższa niż wersja 2 to wykonam jakiś update :)

        }
    }
}
