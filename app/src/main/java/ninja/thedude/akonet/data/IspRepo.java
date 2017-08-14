package ninja.thedude.akonet.data;

import android.util.Log;

import java.util.ArrayList;

import ninja.thedude.akonet.data.model.Isp;

/**
 * Created by thedude61636 on 7/25/17.
 */

public class IspRepo implements IspSource {

    private static final String TAG = "IspRepo";
    private static IspRepo INSTANCE;
    private boolean mCacheIsDirty = false;
    private ArrayList<Isp> mCachedIsps;
    private IspSource remoteSource;

    private IspRepo(IspSource remoteSource) {
        this.remoteSource = remoteSource;
    }

    public static IspRepo getInstance(IspSource remoteSource) {
        if (INSTANCE == null)
            INSTANCE = new IspRepo(remoteSource);
        return INSTANCE;
    }

    @Override
    public void getIsp(final LoadIspsCallback callback) {


        if (mCachedIsps != null && !mCacheIsDirty) {
            Log.i(TAG, "getIsp: ");
            callback.ispsLoaded(mCachedIsps);
            return;
        } else
            getFromRemote(callback);
        //        else {
//            load from local storage
//        }

    }

    private void getFromRemote(final LoadIspsCallback callback) {
        remoteSource.getIsp(new LoadIspsCallback() {
            @Override
            public void ispsLoaded(ArrayList<Isp> isps) {
                refreshCache(isps);
                callback.ispsLoaded(isps);
            }

            @Override
            public void loadingFailed() {
                callback.loadingFailed();
            }
        });
    }

    private void refreshCache(ArrayList<Isp> isps) {
        if (mCachedIsps == null) {
            mCachedIsps = new ArrayList<>();
        }
        mCachedIsps.clear();
        mCachedIsps = isps;
        mCacheIsDirty = false;
    }

    @Override
    public void refreshIsp() {
        mCacheIsDirty = true;
    }


}
