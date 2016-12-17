package it.unitn.hci.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import it.unitn.hci.R;

public class Calendar extends Activity{

    private CalendarView cal;
    private long calDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        cal = (CalendarView) findViewById(R.id.calendar);

        calDate = cal.getDate();
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int monthOfYear, int dayOfMonth) {
                if (calDate != cal.getDate()){
                    calDate = cal.getDate();
                    createShowDialog("Appuntamenti: " + dayOfMonth + "/" + (++monthOfYear) + "/" + year);
                }
            }
        });

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle("My Calendar");
    }

    private void createShowDialog(String title){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        ListView listView = new ListView(this);
        List<Spanned> list = new ArrayList<Spanned>();
        listView.setSelector(android.R.color.transparent);

        list.add(Html.fromHtml("<b>10.00 - 12.00:</b><br> Lezione Basi di Dati"));
        list.add(Html.fromHtml("<b>14.00 - 16.00:</b><br> Lezione Probabilità e statistica"));
        list.add(Html.fromHtml("<b>16.00 - 17.00:</b><br> Incontro con gruppo \"Analisi aiuto\""));
        list.add(Html.fromHtml("<b>17.00 - 17.45:</b><br> Ricevimento con prof. Leopoldi"));

        listView.setAdapter(new ArrayAdapter<Spanned>(this, R.layout.row_single, R.id.text_list_single, list));

        builder.setView(listView);
        builder.setTitle(title);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        builder.show();
    }

}
