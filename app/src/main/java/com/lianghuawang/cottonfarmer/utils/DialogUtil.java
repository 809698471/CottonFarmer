package com.lianghuawang.cottonfarmer.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

public class DialogUtil {

    public static void VerifyDialog(Context context, String titls, String messages,String PositiveButton,String NegativeButton,
                                    DialogInterface.OnClickListener listener) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle(titls)
                .setMessage(messages)
                .setPositiveButton(PositiveButton, listener)
                .setNegativeButton(NegativeButton, listener);
        dialog.show();

    }

}
