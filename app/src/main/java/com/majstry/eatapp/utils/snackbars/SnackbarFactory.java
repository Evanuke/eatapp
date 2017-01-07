package com.majstry.eatapp.utils.snackbars;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.majstry.eatapp.R;
import com.majstry.eatapp.utils.CurrentFragmentProvider;

public class SnackbarFactory {

    public static Snackbar createSnackbar(SnackbarType type) {
        Fragment currentFragment = CurrentFragmentProvider.getInstance().getCurrentFragment();
        Snackbar snackbar;

        if (currentFragment != null) {
            View currentView = currentFragment.getView();
            snackbar = Snackbar.make(currentView, "", Snackbar.LENGTH_LONG);
        } else {
            return null;
        }

        switch (type) {
            case ERROR_SNACKBAR:
                snackbar.getView().setBackgroundColor(ContextCompat.getColor(currentFragment.getContext(), R.color.snackbar_error_color));
                break;
            case INFO_SNACKBAR:
                snackbar.getView().setBackgroundColor(ContextCompat.getColor(currentFragment.getContext(), R.color.snackbar_info_color));
        }

        return snackbar;
    }

}
