package org.cmucreatelab.flutter_android.classes;

/**
 * Created by Steve on 5/31/2016.
 */
public class Message {


    private String input;
    private String output;


    public Message() {
        input = "";
        output = "";
    }


    public void setInput(String input) {
        this.input = input;
    }
    public void setOutput(String output) {
        this.output = output;
    }
    public String getInput() {
        return input;
    }
    public String getOutput() {
        return output;
    }

}