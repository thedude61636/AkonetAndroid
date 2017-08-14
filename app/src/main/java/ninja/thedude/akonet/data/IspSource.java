package ninja.thedude.akonet.data;

import java.util.ArrayList;

import ninja.thedude.akonet.data.model.Isp;

/**
 * Created by thedude61636 on 7/25/17.
 */

public interface IspSource {

    void getIsp(LoadIspsCallback callback);

    void refreshIsp();

    interface LoadIspsCallback {

        void ispsLoaded(ArrayList<Isp> isps);

        void loadingFailed();

    }
}
