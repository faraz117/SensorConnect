package com.electronicjunkies.sensorconnect.sensorconnect;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


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
    private TextView accXTv, accYTv, accZTv;
    private float accX,accY,accZ;

    public SensorFragment() {
        // Required empty public constructor

    }
    private final SensorEventListener mSensorListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent arg0) {
            // TODO Auto-generated method stub
            accX=arg0.values[0];
            accY=arg0.values[1];
            accZ=arg0.values[2];
            accXTv.setText(Float.toString(accX));
            accYTv.setText(Float.toString(accY));
            accZTv.setText(Float.toString(accZ));
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
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(mSensorListener,mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        /* To load sensors dynamically
        RadioGroup group = (RadioGroup) findViewById(R.id.radio_group_sensor);
        RadioButton button;
        for(int i = 0; i < 3; i++) {
            button = new RadioButton(this);
            button.setText("Button " + i);
            group.addView(button);
        } */
        View v = inflater.inflate(R.layout.fragment_sensor, container, false);
        accXTv = (TextView) v.findViewById(R.id.accXValue);
        accYTv = (TextView) v.findViewById(R.id.accYValue);
        accZTv = (TextView) v.findViewById(R.id.accZValue);
        return v;
    }



}
