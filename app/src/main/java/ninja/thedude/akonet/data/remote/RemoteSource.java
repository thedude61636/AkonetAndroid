package ninja.thedude.akonet.data.remote;

import android.util.Log;

import java.util.ArrayList;

import ninja.thedude.akonet.data.IspSource;
import ninja.thedude.akonet.data.model.Isp;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by thedude61636 on 7/25/17.
 */

public class RemoteSource implements IspSource {

    private static final String TAG = "RemoteSource";

    private static RemoteSource remoteSource;

    private RemoteSource(){

    }
    public static RemoteSource getInstance() {
        if (remoteSource == null)
            remoteSource = new RemoteSource();
        return remoteSource;
    }

    @Override
    public void getIsp(final IspSource.LoadIspsCallback callback) {

        IspHelper.getApi().getIsps().enqueue(new Callback<ArrayList<Isp>>() {
            @Override
            public void onResponse(Call<ArrayList<Isp>> call, Response<ArrayList<Isp>> response) {
                Log.d(TAG, "onResponse() called with: call = [" + call + "], response = [" + response + "]");

                if (response.body() != null)
                    callback.ispsLoaded(response.body());
                else {
                    callback.loadingFailed();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Isp>> call, Throwable t) {
                callback.loadingFailed();
            }
        });

    }

    @Override
    public void refreshIsp() {

        //repo handles this
    }
}
