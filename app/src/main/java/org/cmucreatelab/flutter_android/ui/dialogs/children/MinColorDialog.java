package org.cmucreatelab.flutter_android.ui.dialogs.children;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import org.cmucreatelab.flutter_android.helpers.static_classes.Constants;

import java.io.Serializable;

/**
 * Created by Steve on 9/22/2016.
 *
 * MinColorDialog
 *
 * A Dialog that prompts the user to choose a low color.
 */
public class MinColorDialog extends ChooseColorDialog {


    private DialogLowColorListener lowColorListener;


    public static MinColorDialog newInstance(Serializable serializable) {
        MinColorDialog minColorDialog = new MinColorDialog();

        Bundle args = new Bundle();
        args.putSerializable(COLOR_KEY, serializable);
        minColorDialog.setArguments(args);

        return minColorDialog;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Log.d(Constants.LOG_TAG, "onCreateDialog");
        lowColorListener = (DialogLowColorListener) getArguments().getSerializable(COLOR_KEY);
        return super.onCreateDialog(savedInstanceState);
    }


    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        Log.d(Constants.LOG_TAG, "onClickSetColor");
        lowColorListener.onLowColorChosen(finalRGB);
    }


    public interface DialogLowColorListener {
        public void onLowColorChosen(int[] rgb);
    }

}