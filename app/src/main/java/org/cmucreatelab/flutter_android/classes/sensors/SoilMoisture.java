package org.cmucreatelab.flutter_android.classes.sensors;

import java.io.Serializable;

/**
 * Created by Steve on 8/11/2016.
 *
 * SoilMoisture
 *
 * A class representing a soil moisture sensor.
 *
 */
public class SoilMoisture extends A_Sensor implements Sensor, Serializable {

    private static final Sensor.Type sensorType = Type.SOIL_MOISTURE;


    public SoilMoisture() {
        // empty
    }


    @Override
    public Type getSensorType() {
        return sensorType;
    }

}