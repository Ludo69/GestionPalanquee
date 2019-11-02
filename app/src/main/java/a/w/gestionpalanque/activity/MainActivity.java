package a.w.gestionpalanque.activity;

import a.w.gestionpalanque.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();

        CardView cardviewAjoutgonflage = findViewById(R.id.CRSortie);

        cardviewAjoutgonflage.setOnClickListener(view -> {
            Toast.makeText(this, "Bientôt", Toast.LENGTH_SHORT).show();
        });
    }
}
