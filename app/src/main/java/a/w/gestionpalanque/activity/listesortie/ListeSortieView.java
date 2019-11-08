package a.w.gestionpalanque.activity.listesortie;

import java.util.List;

import a.w.gestionpalanque.activity.model.Sortie;

public interface ListeSortieView {
    void showLoading();
    void hideLoading();
    void onGetResult(List<Sortie> sorties);
    void onErrorLoading(String message);
}
