package me.zeljeznica.redvoznje;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by stevyhacker on 16.8.14..
 */
public class AdapterForTrainDepartures extends ArrayAdapter<TrainItem> {

    private Context context;
    private ArrayList<TrainItem> values;

    public AdapterForTrainDepartures(Context context, ArrayList<TrainItem> values) {
        super(context, R.layout.train_item_layout, values);
        this.values = values;
        this.context = context;
    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.train_item_layout, parent, false);

        TrainItem item = values.get(position);

        //TODO OPTIMIZE WITH STATIC VIEW HOLDER AND COMPARE PERFORMANCE
        TextView cityTextView = (TextView) view.findViewById(R.id.city_text_view);
        TextView timeOfDepartureTextView = (TextView) view.findViewById(R.id.time_text_view);

        cityTextView.setText(item.destination);
        timeOfDepartureTextView.setText(item.timeOfDeparture);

        return view;
    }
}
