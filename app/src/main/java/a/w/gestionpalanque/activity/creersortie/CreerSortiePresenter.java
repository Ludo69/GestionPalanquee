package a.w.gestionpalanque.activity.creersortie;

import a.w.gestionpalanque.activity.api.ApiClient;
import a.w.gestionpalanque.activity.api.ApiInterface;
import a.w.gestionpalanque.activity.model.Sortie;
import androidx.annotation.NonNull;
import retrofit2.Callback;
import retrofit2.Response;

public class CreerSortiePresenter {

    private  CreerSortieView view;

    public CreerSortiePresenter(CreerSortieView view) {
        this.view = view;
    }

    void insertsortie(String lieu, String date) {

        view.showProgress();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        retrofit2.Call<Sortie> call = apiInterface.insertsortie(lieu, date);
        call.enqueue(new Callback<Sortie>() {
            @Override
            public void onResponse(@NonNull retrofit2.Call<Sortie> call, @NonNull Response<Sortie> response) {
                view.hideProgress();
                if(response.isSuccessful() && response.body() != null) {
                    Boolean success = response.body().getSuccess();
                    if(success){
                        view.onAddSuccess(response.body().getMessage());
                    } else {
                        view.onAddError(response.body().getMessage());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull retrofit2.Call<Sortie> call, @NonNull Throwable t) {
                view.hideProgress();
                view.onAddError(t.getLocalizedMessage());
            }
        });

    }

}


