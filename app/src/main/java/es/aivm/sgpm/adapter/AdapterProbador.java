package es.aivm.sgpm.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.aivm.sgpm.R;
import es.aivm.sgpm.model.ProbadorModel;

public class AdapterProbador extends RecyclerView.Adapter<AdapterProbador.ViewHolderProbador> {

    private List mDataset;
    private Context context;

    public AdapterProbador(Context c) {
        this.context = c;
        mDataset= new ArrayList<>();
    }

    public void add(ProbadorModel probador) {
        mDataset.add(probador);
        notifyItemInserted(mDataset.indexOf(probador));
    }
    public void remove(ProbadorModel probador) {
        int position = mDataset.indexOf(probador);

        if(position != -1) {
            mDataset.remove(position);
            notifyItemRemoved(position);
        }
    }



    @Override
    public ViewHolderProbador onCreateViewHolder(ViewGroup parent, int i) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_probador_en_uso, parent, false);
        ViewHolderProbador vh = new ViewHolderProbador(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProbador holder, int position) {
        final ProbadorModel item = (ProbadorModel) mDataset.get(position);
        holder.Image.setImageDrawable(item.getImage());
        holder.name.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public  class ViewHolderProbador extends RecyclerView.ViewHolder {

        protected ImageView Image;
        protected TextView name;
        public ViewHolderProbador(View v) {
            super(v);
            Image= (ImageView) v.findViewById(R.id.foto_probador);
            name= (TextView) v.findViewById(R.id.nombre_probador);
        }
    }
}
