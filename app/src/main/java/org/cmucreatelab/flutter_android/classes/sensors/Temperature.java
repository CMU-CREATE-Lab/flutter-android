package org.cmucreatelab.flutter_android.classes.sensors;

import org.cmucreatelab.flutter_android.R;

import java.io.Serializable;

/**
 * Created by Steve on 8/11/2016.
 *
 * Temperature
 *
 * A class representing a temperature sensor.
 *
 */
public class Temperature extends A_Sensor implements Sensor, Serializable {

    private static final Sensor.Type sensorType = Type.TEMPERATURE;
    public static final int blueImageId = R.drawable.sensor_blue_temperature;
    public static final int greenImageId = R.drawable.sensor_green_temperature;
    public static final int orangeImageId = R.drawable.sensor_orange_temperature;


    public Temperature() {
        // empty
    }


    @Override
    public Type getSensorType() {
        return sensorType;
    }


    @Override
    public int getBlueImageId() {
        return blueImageId;
    }


    @Override
    public int getGreenImageId() {
        return greenImageId;
    }


    @Override
    public int getOrangeImageId() {
        return orangeImageId;
    }

}
