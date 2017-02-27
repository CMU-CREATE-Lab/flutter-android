package org.cmucreatelab.flutter_android.ui.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import org.cmucreatelab.flutter_android.R;
import org.cmucreatelab.flutter_android.helpers.GlobalHandler;
import org.cmucreatelab.flutter_android.helpers.static_classes.Constants;

/**
 * Created by Steve on 2/27/2017.
 */

public class RecordingWarningDataDialog extends RecordingWarningDialog implements RecordingWarningDialog.WarningButtonListener {


    public static RecordingWarningDataDialog newInstance(String name, int times, String time, int forTimes, String forTime) {
        RecordingWarningDataDialog recordingWarningDataDialog = new RecordingWarningDataDialog();

        Bundle args = new Bundle();
        args.putString(NAME_KEY, name);
        args.putInt(TIMES_KEY, times);
        args.putString(TIME_KEY, time);
        args.putInt(FOR_TIMES_KEY, forTimes);
        args.putString(FOR_TIME_KEY, forTime);
        recordingWarningDataDialog.setArguments(args);

        return recordingWarningDataDialog;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Log.d(Constants.LOG_TAG, "RecordingWarningSensorDialog.onCreateDialog");
        super.registerWarningListener(this);
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        buttonOk.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.round_orange_button_bottom_right));
        return dialog;
    }


    @Override
    public void onCancelRecording() {
        Log.d(Constants.LOG_TAG, "RecordingWarningDataDialog.onCancelRecording");
        GlobalHandler.getInstance(getActivity()).dataLoggingHandler.stopRecording();
        dismiss();
    }


    @Override
    public void onButtonOk() {
        Log.d(Constants.LOG_TAG, "RecordingWarningDataDialog.onButtonOk");
        dismiss();
    }
}
