package me.zeljeznica.redvoznje;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends Activity implements OnItemSelectedListener {

    private ListView trainListView;
    private MyDatabase db;
    private AdapterForTrainDepartures adapter;
    private ArrayList<TrainItem> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trainListView = (ListView) findViewById(R.id.trainListView);
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.gradovi, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(this);

        db = new MyDatabase(this);
        values = new ArrayList<TrainItem>();

        adapter = new AdapterForTrainDepartures(this,values);
        //TODO Set new adapter for train list view
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        switch (position) {
            case 0:
                cursor = db.getNiksic();
                break;
            case 1:
                cursor = db.getPodgorica();
                break;
            case 2:
                values = db.getBijeloPolje();
                adapter.notifyDataSetChanged();
                break;
            case 3:
                cursor = db.getBar();
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }

}
