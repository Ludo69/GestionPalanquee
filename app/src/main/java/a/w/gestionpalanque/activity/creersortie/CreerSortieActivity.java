package a.w.gestionpalanque.activity.creersortie;

import a.w.gestionpalanque.R;
import a.w.gestionpalanque.activity.start.StartActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class CreerSortieActivity extends AppCompatActivity implements CreerSortieView{

    private static final int INTENT_EDIT = 200;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    EditText et_lieu;
    TextView et_date;

    CreerSortiePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_sortie);

        et_lieu = findViewById(R.id.lieu);
        et_date = findViewById(R.id.date);

        et_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        CreerSortieActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d("***", "onDateSet: date: " + year + "-" + month + "-" + day);
                String date = year + "-" + month + "-" + day;
                et_date.setText(date);
            }
        };

        presenter = new CreerSortiePresenter(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_valider, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ajouter:
                String lieu = et_lieu.getText().toString();
                String date = et_date.getText().toString();
                presenter.insertsortie(lieu, date);
                Intent intent = new Intent(this, StartActivity.class);
                startActivityForResult(intent, INTENT_EDIT);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onAddSuccess(String message) {
        Log.d("SUCCESS ", message);
    }

    @Override
    public void onAddError(String message) {
        Log.d("ERROR ", message);
    }
}
