package it.unitn.hci.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import it.unitn.hci.R;
import it.unitn.hci.adapters.BasicListAdapter;
import it.unitn.hci.support.ListItem;

public class Notifiche extends Activity{

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_not_clickable);

        ListView listView = (ListView) findViewById(R.id.list_not_clickable);

        List<ListItem> list = new ArrayList<ListItem>();
        list.add(new ListItem("Gruppo \"Analisi gennaio\": è stato fissato un incontro per venerdi alle 15.00!",
                "17.12.13 at 02:16:09"));
        list.add(new ListItem("Giulio Lissoni ti ha accreditato 2 ore",
                "16.11.13 at 01:34:19"));
        list.add(new ListItem("Gruppo \"Database\": mettete le preferenze per il prossimo incontro sul calendario grazie! :)",
                "14.11.13 at 08:17:09"));
        list.add(new ListItem("Luisa Bianchi ha richiesto il tuo aiuto per Economia (2h)",
                "23.09.13 at 07:56:35"));
        list.add(new ListItem("Gruppo \"ASD progetto 1\": il ritrovo che era stato fissato per giovedi alle 10.30 è stato spostato alle 14, stessa aula!",
                "12.09.13 at 08:59:59"));

        ArrayAdapter<ListItem> adapter = new BasicListAdapter(this, R.layout.row_double, list);
        listView.setAdapter(adapter);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle("My news");
    }
}
