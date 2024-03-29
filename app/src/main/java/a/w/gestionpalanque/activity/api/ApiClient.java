package a.w.gestionpalanque.activity.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "http://gestionmatabb.alwaysdata.net/palanquee/";
    //private static final String BASE_URL = "http://10.0.2.2:8888/";
    private static Retrofit retrofit;

    public static Retrofit getApiClient() {

        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}