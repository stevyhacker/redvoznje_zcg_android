package me.zeljeznica.redvoznje;

import com.commonsware.cwac.merge.MergeAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.Menu;
import android.view.View;
import android.widget.ListAdapter;

public class MainActivity extends Activity implements OnItemSelectedListener {

	private Cursor cursor;

	// private Cursor niksic;
	// private Cursor bijelopolje;
	// private Cursor podgorica;
	private ListView listview;
	private ListView listview2;
	private MyDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview = (ListView) findViewById(R.id.listView1);
		listview2 = (ListView) findViewById(R.id.listView2);

		Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<CharSequence> spinner_adapter = ArrayAdapter
				.createFromResource(this, R.array.gradovi,
						android.R.layout.simple_spinner_item);
		spinner_adapter
				.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		spinner.setAdapter(spinner_adapter);
		spinner.setOnItemSelectedListener(this);

		db = new MyDatabase(this);
		//cursor = db.getBar(); // you would not typically call this on the main
								// thread
		// new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// niksic = db.getNiksic();
		// podgorica = db.getPodgorica();
		// bijelopolje = db.getBijeloPolje();
		// bar = db.getBar();
		// }
		// }).start();

	}

	// class Task implements Runnable {
	// @Override
	// public void run() {
	// bar = db.getBar();
	// niksic = db.getNiksic();
	// podgorica=db.getPodgorica();
	// bijelopolje=db.getBijeloPolje();
	// }
	// }

	@Override
	protected void onDestroy() {
		super.onDestroy();
		cursor.close();
		// niksic.close();
		// bijelopolje.close();
		// podgorica.close();

		db.close();
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		switch (position) {
		case 0:
			cursor = db.getNiksic();
			listAdapters();
			break;
		case 1:
			cursor = db.getPodgorica();
			listAdapters();
			break;
		case 2:
			cursor = db.getBijeloPolje();
			listAdapters();
			break;
		case 3:
			cursor = db.getBar();
			listAdapters();
			break;

		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

	public void listAdapters() {
		 MergeAdapter mergeAdapter = new MergeAdapter();
		
		ListAdapter adapter = new SimpleCursorAdapter(this,
				android.R.layout.activity_list_item, cursor,
				new String[] {"polazakiz" },
		new int[] { android.R.id.text1 ,android.R.id.text2});
//		mergeAdapter.addAdapter(adapter);
		
		listview.setAdapter(adapter);
		
		 ListAdapter adapter2 = new SimpleCursorAdapter(this,
		 android.R.layout.activity_list_item, cursor,
		 new String[] { "vrijemepolaska" },
		 new int[] { android.R.id.text1 });
	//	mergeAdapter.addAdapter(adapter2);
	//	listview.setAdapter(mergeAdapter);
		 listview2.setAdapter(adapter2);
		
	}

}
