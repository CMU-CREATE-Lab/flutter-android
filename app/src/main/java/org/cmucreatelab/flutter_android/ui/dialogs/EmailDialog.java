package org.cmucreatelab.flutter_android.ui.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.internal.view.ContextThemeWrapper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import org.cmucreatelab.flutter_android.R;
import org.cmucreatelab.flutter_android.classes.datalogging.DataSet;
import org.cmucreatelab.flutter_android.helpers.GlobalHandler;
import org.cmucreatelab.flutter_android.helpers.static_classes.Constants;
import org.cmucreatelab.flutter_android.helpers.static_classes.EmailHandler;
import org.cmucreatelab.flutter_android.helpers.static_classes.FileHandler;

import java.io.Serializable;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Steve on 9/7/2016.
 *
 * EmailDialog
 *
 * A dialog that prompts the user to send an email of a data log.
 */
public class EmailDialog extends BaseResizableDialog {

    private static final String DATA_SET_KEY = "data_set_key";

    private GlobalHandler globalHandler;
    private EditText email;
    private EditText message;
    private DataSet currentDataLog;


    public static EmailDialog newInstance(Serializable dataSet) {
        EmailDialog emailDialog = new EmailDialog();

        Bundle args = new Bundle();
        args.putSerializable(DATA_SET_KEY, dataSet);
        emailDialog.setArguments(args);

        return emailDialog;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        globalHandler = GlobalHandler.getInstance(this.getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.dialog_email, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), R.style.AppTheme));
        builder.setView(view);
        ButterKnife.bind(this, view);
        email = (EditText) view.findViewById(R.id.edit_text_email);
        message = (EditText) view.findViewById(R.id.edit_text_message);
        currentDataLog = (DataSet) getArguments().getSerializable(DATA_SET_KEY);
        return builder.create();
    }


    @OnClick(R.id.button_send_email)
    public void onClickSendEmail() {
        Log.d(Constants.LOG_TAG, "onClickSend");
        if (Constants.SEND_EMAIL_AS == Constants.MailerType.INTENT) {
            EmailHandler.sendEmailIntent(getActivity(), email.getText().toString(), message.getText().toString(), FileHandler.getFileFromDataSet(globalHandler, currentDataLog));
        } else if (Constants.SEND_EMAIL_AS == Constants.MailerType.INTENT) {
            EmailHandler.sendEmailServer(getActivity(), email.getText().toString(), message.getText().toString(), FileHandler.getFileFromDataSet(globalHandler, currentDataLog), GlobalHandler.getInstance(getActivity().getApplicationContext()).sessionHandler.getSession().getFlutter().getName());
        } else {
            Log.e(Constants.LOG_TAG, "Unknown type for Constants.SEND_EMAIL_AS");
        }
        this.dismiss();
    }

}
