package ninja.thedude.akonet;

import android.content.Context;

import ninja.thedude.akonet.Utils.Tools;
import ninja.thedude.akonet.data.IspRepo;
import ninja.thedude.akonet.data.remote.RemoteSource;

/**
 * Created by thedude61636 on 7/27/17.
 */

public class Injection {

    public static IspRepo provideIspRepo(Context context) {
        Tools.checkNotNull(context);
        return IspRepo.getInstance(RemoteSource.getInstance());
    }
}
