package com.example.rfgr.coffeinasql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SnackActivity extends AppCompatActivity {
    public static final String EXTRA_SNACKNO = "snackNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack);

        int snackNo = (Integer) getIntent().getExtras().get(EXTRA_SNACKNO);
        Snack snack = Snack.snacks[snackNo];

        ImageView photo = (ImageView) findViewById(R.id.photoSnack);
        photo.setImageResource(snack.getImageResourceIdSnack());
        photo.setContentDescription(snack.getNameSnack());

        TextView name = (TextView) findViewById(R.id.nameSnack);
        name.setText(snack.getNameSnack());

        TextView description = (TextView) findViewById(R.id.descriptionSnack);
        description.setText(snack.getDesciptionSnack());
    }
}