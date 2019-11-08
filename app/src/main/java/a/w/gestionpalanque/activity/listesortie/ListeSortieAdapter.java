package a.w.gestionpalanque.activity.listesortie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import a.w.gestionpalanque.R;
import a.w.gestionpalanque.activity.model.Sortie;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ListeSortieAdapter extends RecyclerView.Adapter<a.w.gestionpalanque.activity.listesortie.ListeSortieAdapter.RecyclerViewAdapter> {

    private Context context;
    private List<Sortie> sorties;
    private ListeSortieAdapter.ItemClickListener itemClickListener;

    public ListeSortieAdapter(Context context, List<Sortie> sorties, ListeSortieAdapter.ItemClickListener itemClickListener) {
        this.context = context;
        this.sorties = sorties;
        this.itemClickListener =itemClickListener;
    }

    @NonNull
    @Override
    public ListeSortieAdapter.RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sortie, parent, false);
        return new a.w.gestionpalanque.activity.listesortie.ListeSortieAdapter.RecyclerViewAdapter(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ListeSortieAdapter.RecyclerViewAdapter holder, int position) {
        Sortie sortie = sorties.get(position);
        holder.tv_lieu.setText(sortie.getLieusortie());
        holder.tv_date.setText(sortie.getDatesortie());
    }

    @Override
    public int getItemCount() {
        return sorties.size();
    }

    class RecyclerViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tv_date, tv_lieu;
        CardView card_item;
        a.w.gestionpalanque.activity.listesortie.ListeSortieAdapter.ItemClickListener itemClickListener;

        RecyclerViewAdapter(View itemView, a.w.gestionpalanque.activity.listesortie.ListeSortieAdapter.ItemClickListener itemClickListener) {
            super(itemView);

            tv_lieu = itemView.findViewById(R.id.lieu);
            tv_date = itemView.findViewById(R.id.date);
            card_item = itemView.findViewById(R.id.card_item);

            this.itemClickListener = itemClickListener;
            card_item.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
