package com.example.rfgr.coffeinasql;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SnackCategoryActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listSnacks = getListView();
        ArrayAdapter<Snack> listAdapter = new ArrayAdapter<Snack>
                (this, android.R.layout.simple_list_item_1, Snack.snacks);
        listSnacks.setAdapter(listAdapter);
    }

    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id) {
        Intent intent = new Intent(SnackCategoryActivity.this, SnackActivity.class);
        intent.putExtra(SnackActivity.EXTRA_SNACKNO, (int) id);
        startActivity(intent);
    }
}
