package ninja.thedude.akonet.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import ninja.thedude.akonet.Utils.Consts;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by thedude61636 on 7/23/17.
 */

public class IspHelper {
    private static Retrofit getRetrofit() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(20, TimeUnit.SECONDS).readTimeout(20, TimeUnit.SECONDS).writeTimeout(20, TimeUnit.SECONDS);
        OkHttpClient client = clientBuilder
                .build();
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder()
                .baseUrl(Consts.API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

    }

    public static Api getApi() {
        return getRetrofit().create(Api.class);
    }

}
