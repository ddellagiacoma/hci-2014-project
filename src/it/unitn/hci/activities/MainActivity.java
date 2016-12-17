package it.unitn.hci.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import it.unitn.hci.R;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void calendario(View v){
		Intent intentCalendario= new Intent (MainActivity.this, Calendar.class);
		startActivity(intentCalendario);
	}

	public void notifiche(View v){
		Intent intentNotifiche= new Intent (MainActivity.this, Notifiche.class);
		startActivity(intentNotifiche);
	}
	
	public void mybank(View v){
		Intent intentMyBank= new Intent (MainActivity.this, MyBank.class);
		startActivity(intentMyBank);
	}

    public void mygroups(View v){
        Intent intentMyGroups= new Intent (MainActivity.this, GroupList.class);
        startActivity(intentMyGroups);
    }


	public void mycv(View v){
		Context context = getApplicationContext();
        String text = "Questa sezione conterrà tutte le funzionalità di MyCv che sono già state implementate dagli sviluppatori di SmartCampus";

		Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
		toast.show();
	}
}
