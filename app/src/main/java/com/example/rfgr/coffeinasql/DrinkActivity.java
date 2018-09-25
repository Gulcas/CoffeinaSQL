package com.example.rfgr.coffeinasql;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DrinkActivity extends Activity {

    public static final String EXTRA_DRINKNO = "drinkNo"; //dodaje stałą zmienną którą mogę wykorzystać w całej klasie

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        int drinkNo = (Integer) getIntent().getExtras().get(EXTRA_DRINKNO); //pobieramy identyfikator zmiennej

        //poniżej stworzony zostaje kursor, któy pobiera z tabeli DRINK wartości kolumn NAME DESCRIPTION i IMAGE_... z wiersza _id równego drinkNo
        try {
            SQLiteOpenHelper coffeinaDatabaseHelper = new CoffeinaDatabaseHelper(this);
            SQLiteDatabase db = coffeinaDatabaseHelper.getReadableDatabase(); //otwieram bazę jako Readalbe, ponieważ w przypadku braku możliwości edycji bazy
            // zostanie ona otwarta w trybie do odczytu, ale nie wyrzuci od razu SQLiteException;a
            Cursor cursor = db.query("DRINK",
                    new String[]{"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"},
                    "_id = ?",
                    new String[]{Integer.toString(drinkNo)},
                    null, null, null);
            if (cursor.moveToFirst()) {
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);
                int photoId = cursor.getInt(2);

                TextView name = (TextView) findViewById(R.id.name); //wyświetlam nazwę
                name.setText(nameText);

                TextView description = (TextView) findViewById(R.id.description); //wyświetlam opis
                description.setText(descriptionText);

                ImageView photo = (ImageView) findViewById(R.id.photo); //wyświetlam foto
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);
            }
            cursor.close(); //zamykam kursor
            db.close(); //i bazę danych
        } catch (SQLiteException e) { //jeżeli jednak baza danych zgłosi SQLiteException to wyrzucę toast na ekran
            Toast toast = Toast.makeText(this, "Baza is unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }


    }
}
