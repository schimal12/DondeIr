package mx.itesm.edu.dondeir;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MenuActivity extends ListActivity {


    private ArrayAdapter<Item> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        items = new ArrayAdapter<Item>(this,android.R.layout.simple_list_item_1, new ArrayList<Item>());
        setListAdapter(items);
        CargaMenuAsyncTask cargaMenuAsyncTask = new CargaMenuAsyncTask(this, items);
        cargaMenuAsyncTask.execute("menu");


    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Item item = (Item)getListAdapter().getItem(position);
        Intent it = new Intent(this, MapaActivity.class);
        it.putExtra("item", item);
        startActivity(it);
    }



}
