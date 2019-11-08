package a.w.gestionpalanque.activity.creersortie;

public interface CreerSortieView {
    void showProgress();
    void hideProgress();
    void onAddSuccess(String message);
    void onAddError(String message);
}
