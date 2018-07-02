package org.cmucreatelab.flutter_android.ui.dialogs.wizards.robot_outputs_wizard;

import android.util.Log;

import org.cmucreatelab.flutter_android.activities.RobotActivity;
import org.cmucreatelab.flutter_android.classes.outputs.FlutterOutput;
import org.cmucreatelab.flutter_android.classes.relationships.NoRelationship;
import org.cmucreatelab.flutter_android.classes.relationships.Relationship;
import org.cmucreatelab.flutter_android.helpers.static_classes.Constants;
import org.cmucreatelab.flutter_android.ui.dialogs.robots_tab.outputs.BaseOutputDialog;
import org.cmucreatelab.flutter_android.ui.dialogs.wizards.BaseResizableDialogWizard;
import org.cmucreatelab.flutter_android.ui.dialogs.wizards.Wizard;

import java.io.Serializable;

/**
 * Created by mike on 6/29/18.
 */

public abstract class OutputWizard<T extends FlutterOutput> extends Wizard {

    private RobotActivity activity;
    private T output;
    private State currentState;

    public class State implements Serializable {
        private BaseResizableDialogWizard currentDialog;
        public Relationship relationshipType = NoRelationship.getInstance();
        public int selectedSensorPort=0,
                outputMin=0,
                outputMax=100;
    }


    public OutputWizard(RobotActivity activity, T output) {
        this.activity = activity;
        this.output = output;
        this.currentState = new State();
    }


    public State getCurrentState() {
        return currentState;
    }


    @Override
    public void start() {
        currentState.currentDialog = ChooseRelationshipOutputDialogWizard.newInstance(this);
        currentState.currentDialog.show(activity.getSupportFragmentManager(), "tag");
    }


    @Override
    public void finish() {
        generateSettings(this.currentState, this.output);
        BaseOutputDialog dialog = generateOutputDialog(output, activity);
        dialog.show(activity.getSupportFragmentManager(), "tag");
        currentState.currentDialog.dismiss();
    }


    @Override
    public void changeDialog(BaseResizableDialogWizard nextDialog) {
        if (nextDialog == null) {
            Log.e(Constants.LOG_TAG, "found null nextDialog; ending wizard");
            currentState.currentDialog.dismiss();
            return;
        }

        nextDialog.show(activity.getSupportFragmentManager(), "tag");
        currentState.currentDialog.dismiss();
        currentState.currentDialog = nextDialog;
    }


    public abstract void generateSettings(OutputWizard.State currentState, T output);


    public abstract BaseOutputDialog generateOutputDialog(T output, RobotActivity activity);

}
