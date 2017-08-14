package ninja.thedude.akonet.isp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.util.Log;

import java.util.ArrayList;

import ninja.thedude.akonet.R;
import ninja.thedude.akonet.Utils.SnackbarMessage;
import ninja.thedude.akonet.data.IspRepo;
import ninja.thedude.akonet.data.IspSource;
import ninja.thedude.akonet.data.model.Isp;

/**
 * Created by thedude61636 on 7/27/17.
 */

public class IspViewModel extends AndroidViewModel {
    private static final String TAG = "IspViewModel";
    public ObservableArrayList<Isp> mIsps = new ObservableArrayList<>();
    public ObservableBoolean isDataLoading = new ObservableBoolean();
    SnackbarMessage snackbarMessage = new SnackbarMessage();
    private IspRepo repo;

    public IspViewModel(Application application, IspRepo ispRepo) {
        super(application);

        this.repo = ispRepo;
    }

    void start() {
        getIsps(false);
    }

    private void getIsps(final boolean forceUpdate) {
        isDataLoading.set(true);
        Log.d(TAG, "getIsps() called with: forceUpdate = [" + forceUpdate + "]");
        if (forceUpdate) {
            repo.refreshIsp();
        }
        repo.getIsp(new IspSource.LoadIspsCallback() {
            @Override
            public void ispsLoaded(ArrayList<Isp> isps) {
                isDataLoading.set(false);
                if (isps != null) {
                    mIsps.clear();
                    mIsps.addAll(isps);
                    if (forceUpdate) {
                        snackbarMessage.setValue(R.string.data_refreshed);
                    }
                }
            }

            @Override
            public void loadingFailed() {
                snackbarMessage.setValue(R.string.error_network);
                isDataLoading.set(false);
            }
        });

    }

    public void refresh() {
        getIsps(true);
    }


}
