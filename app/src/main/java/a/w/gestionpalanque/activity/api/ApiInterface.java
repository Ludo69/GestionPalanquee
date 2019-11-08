package a.w.gestionpalanque.activity.api;

import java.util.List;

import a.w.gestionpalanque.activity.model.Sortie;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("sorties.php")
    Call<List<Sortie>> getsorties();

    @FormUrlEncoded
    @POST("insertsortie.php")
    Call<Sortie> insertsortie(
            @Field("lieu") String lieu,
            @Field("date") String date
    );

}
