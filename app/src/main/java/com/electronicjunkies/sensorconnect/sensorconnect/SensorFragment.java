package com.electronicjunkies.sensorconnect.sensorconnect;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Start Sensor Manager here ( Probably on create)
 * List all the sensors
 * Fetch values from the once which are checked
 * Colored Lists?
 */
public class SensorFragment extends Fragment {

    private  SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private List<Sensor> deviceSensors;

    public SensorFragment() {
        // Required empty public constructor

    }


    private final SensorEventListener mSensorListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onAccuracyChanged(Sensor arg0, int arg1) {
            // TODO Auto-generated method stub

        }
    };
    public void onCreate(Bundle savedInstanceState) {
        // Get a list of sensors and display them
        // oncheck event fire the sensor and display values
        //
        super.onCreate(savedInstanceState);
        mSensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        mSensorManager.registerListener(mSensorListener,mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sensor, container, false);
        return v;
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        // TODO list the information here
        // get the listview from our layout

        final ListView listView = (ListView)view.findViewById(R.id.list_sensors);
        final SparseBooleanArray mSelectedItemsIds = new SparseBooleanArray();
        // and populate it with the most basic view available for listviews, a single text view
        // only made final so we can refer to it in our anonymuous innerclass for clickListener impl
        final ArrayAdapter<Sensor> listAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_multiple_choice, android.R.id.text1, deviceSensors.toArray(new Sensor[deviceSensors.size()]));
        // set it to our listview
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Sensor sensor = listAdapter.getItem(i);
                // Or run sensor on click
                Toast.makeText(getActivity(), sensor.getName(),
                Toast.LENGTH_SHORT).show();
                if(!mSelectedItemsIds.get(i)){
                    listView.setItemChecked(i, true);
                    mSelectedItemsIds.put(i, true);
                    // Start the sensor and Display Sensor Values
                    // Store SelectedIds to pass to the final fragment
                }
                else{
                    mSelectedItemsIds.delete(i);
                    listView.setItemChecked(i, false);
                }

            }
        });


    }
}
