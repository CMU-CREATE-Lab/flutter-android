package org.cmucreatelab.flutter_android.classes.outputs;

import org.cmucreatelab.flutter_android.R;

import java.io.Serializable;

/**
 * Created by Steve on 6/20/2016.
 *
 * Servo
 *
 * A class that represents a servo on the flutter.
 *
 */
public class Servo extends A_Output implements Serializable, Output {


    public static final String SERVO_KEY = "servo_key";
    public static final String SERVO_NUMBER_KEY = "servo_number_key";

    private static final Output.Type outputType = Type.SERVO;
    private static final int MINIMUM = 0;
    private static final int MAXIMUM = 180;

    public static final int imageId = R.mipmap.ic_launcher;

    private int currentValue;


    public Servo(int portNumber) {
        super(portNumber);
        this.setCurrentValue(0);
    }


    public void setCurrentValue(int currentLocal) {
        if (currentLocal >= MINIMUM && currentLocal <= MAXIMUM) {
            this.currentValue = currentLocal;
        }
    }
    public int getCurrentValue() {
        return this.currentValue;
    }


    @Override
    public Type getOutputType() {
        return outputType;
    }


    @Override
    public int getOutputImageId() {
        return imageId;
    }


    @Override
    public int getMax() {
        return MAXIMUM;
    }


    @Override
    public int getMin() {
        return MINIMUM;
    }

}
