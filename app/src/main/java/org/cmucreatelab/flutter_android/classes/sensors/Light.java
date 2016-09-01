package org.cmucreatelab.flutter_android.classes.sensors;

import java.io.Serializable;

/**
 * Created by Steve on 8/11/2016.
 *
 * Light
 *
 * A class representing a light sensor.
 *
 */
public class Light extends A_Sensor implements Sensor, Serializable {

    private static final Sensor.Type sensorType = Type.LIGHT;


    public Light() {
        // empty
    }


    @Override
    public Type getSensorType() {
        return sensorType;
    }

}