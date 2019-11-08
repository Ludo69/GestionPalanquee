package a.w.gestionpalanque.activity.listesortie;

import java.util.List;

import a.w.gestionpalanque.activity.api.ApiClient;
import a.w.gestionpalanque.activity.api.ApiInterface;
import a.w.gestionpalanque.activity.model.Sortie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListeSortiePresenter {

    private ListeSortieView view;

    public ListeSortiePresenter(ListeSortieView listeSortieView) { this.view = listeSortieView; }

    void getData(int type) {

        view.showLoading();

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Sortie>> call = apiInterface.getsorties();
        call.enqueue(new Callback<List<Sortie>>() {
            @Override
            public void onResponse(Call<List<Sortie>> call, Response<List<Sortie>> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.onGetResult(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Sortie>> call, Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });

    }

}
