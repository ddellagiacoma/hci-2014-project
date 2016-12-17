package it.unitn.hci.activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import it.unitn.hci.R;
import it.unitn.hci.adapters.BasicListAdapter;
import it.unitn.hci.adapters.PaymentAdapter;
import it.unitn.hci.support.ListItem;
import it.unitn.hci.support.Payment;

public class MyBank extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mybank);
        ListView listView = (ListView) findViewById(R.id.list_bank);

        List<Payment> list = new ArrayList<Payment>();
        list.add(new Payment(Html.fromHtml("<b>Giulio Lissoni</b> ha accreditato  <b>2h</b> sul tuo conto."), "17.12.13 at 02:16:09", Payment.PLUS));
        list.add(new Payment(Html.fromHtml("Hai accreditato <b>1h</b> sul conto di <b>Renato Avi</b>."), "16.11.13 at 01:34:19", Payment.MINUS));
        list.add(new Payment(Html.fromHtml("<b>Federico Svaldi</b> ha accreditato <b>3h</b> sul tuo conto."), "14.11.13 at 08:17:09", Payment.PLUS));
        list.add(new Payment(Html.fromHtml("<b>Luisa Bianchi</b> ha accreditato <b>0.5h</b> sul tuo conto."), "23.09.13 at 07:56:35", Payment.PLUS));

        ArrayAdapter<Payment> adapter = new PaymentAdapter(this, R.layout.row_double, list);
        listView.setAdapter(adapter);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle("My bank");
	}

}
