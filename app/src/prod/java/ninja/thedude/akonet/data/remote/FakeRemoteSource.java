package ninja.thedude.akonet.data.remote;

import com.google.common.collect.Lists;

import java.util.LinkedHashMap;
import java.util.Map;

import ninja.thedude.akonet.data.IspSource;
import ninja.thedude.akonet.data.model.Isp;

/**
 * Created by thedude61636 on 8/6/17.
 */

public class FakeRemoteSource implements IspSource {

    private static final Map<String, Isp> TASKS_SERVICE_DATA = new LinkedHashMap<>();
    private static FakeRemoteSource INSTANCE;

    // Prevent direct instantiation.
    private FakeRemoteSource() {
    }

    public static FakeRemoteSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FakeRemoteSource();
        }
        return INSTANCE;
    }


    @Override
    public void getIsp(LoadIspsCallback callback) {
        callback.ispsLoaded(Lists.newArrayList(TASKS_SERVICE_DATA.values()));
//        callback.loadingFailed();

    }

    @Override
    public void refreshIsp() {
        //handled by repo
    }
}
