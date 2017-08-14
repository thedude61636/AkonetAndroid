package ninja.thedude.akonet.data.remote;

import java.util.ArrayList;

import ninja.thedude.akonet.data.model.Isp;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by thedude61636 on 7/23/17.
 */

public interface Api {

    @GET("index/")
    Call<ArrayList<Isp>> getIsps();

}
