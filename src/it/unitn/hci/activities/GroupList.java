package it.unitn.hci.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import it.unitn.hci.R;

/**
 * Created by Franco on 16/12/13.
 */
public class GroupList extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_clickable);

        ListView listView = (ListView) findViewById(R.id.list_clickable);

        List<String> list = new ArrayList<String>();
        list.add("Analisi aiuto");
        list.add("Hci gruppo 31");
        list.add("LFC gennaio");
        list.add("Inglese PET");
        list.add("Database");
        list.add("ASD progetto 1");
        list.add("Inglese FIRST");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row_single, R.id.text_list_single, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentMyGroups = new Intent (GroupList.this, Group.class);
                intentMyGroups.putExtra("groupName", ((TextView) view).getText());
                startActivity(intentMyGroups);
            }
        });

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle("My groups");
    }
}