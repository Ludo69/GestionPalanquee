package a.w.gestionpalanque.activity.start;

import a.w.gestionpalanque.R;
import a.w.gestionpalanque.activity.creersortie.CreerSortieActivity;
import a.w.gestionpalanque.activity.listesortie.ListeSortieActivity;
import a.w.gestionpalanque.activity.listesortie.ListeSortieAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        CardView cardviewcreersortie = findViewById(R.id.CRSortie);
        CardView cardviewlistesortie = findViewById(R.id.ListeSortie);

        cardviewcreersortie.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), CreerSortieActivity.class);
            startActivity(intent);
        });

        cardviewlistesortie.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ListeSortieActivity.class);
            startActivity(intent);
        });
    }
}
