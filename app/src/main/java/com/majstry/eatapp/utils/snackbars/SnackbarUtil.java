package com.majstry.eatapp.utils.snackbars;

import android.support.design.widget.Snackbar;

public class SnackbarUtil {

    public static void showInfoSnackbar(String message) {
        Snackbar snackbar = SnackbarFactory.createSnackbar(SnackbarType.INFO_SNACKBAR);
        if (snackbar == null) {
            return;
        }

        showSnackbar(snackbar, message);
    }

    public static void showErrorSnackbar(String message) {
        Snackbar snackbar = SnackbarFactory.createSnackbar(SnackbarType.ERROR_SNACKBAR);
        if (snackbar == null) {
            return;
        }

        showSnackbar(snackbar, message);
    }

    private static void showSnackbar(Snackbar snackbar, String message) {
        snackbar.setText(message);
        snackbar.show();
    }

}
