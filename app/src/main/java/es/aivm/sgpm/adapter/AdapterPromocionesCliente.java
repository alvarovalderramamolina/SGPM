package es.aivm.sgpm.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.aivm.sgpm.Producto;
import es.aivm.sgpm.R;
import es.aivm.sgpm.model.DataModel;
import es.aivm.sgpm.model.PromocionModel;

public class AdapterPromocionesCliente extends RecyclerView.Adapter<AdapterPromocionesCliente.ViewHolderPromocion> {

    private List mDataset;
    private Context context;

    public AdapterPromocionesCliente(Context c){
        this.context= c;
        mDataset= new ArrayList<AdapterPromocionesCliente>();
    }

    public void add(PromocionModel promocion){
        mDataset.add(promocion);
        notifyItemInserted(mDataset.indexOf(promocion));
    }

    public void remove(PromocionModel promocion){
        int position = mDataset.indexOf(promocion);

        if(position != -1) {
            mDataset.remove(position);
            notifyItemRemoved(position);
        }
    }

    @NonNull
    @Override
    public ViewHolderPromocion onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_promociones_cliente, parent, false);
        AdapterPromocionesCliente.ViewHolderPromocion vh = new AdapterPromocionesCliente.ViewHolderPromocion(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderPromocion holder, int position) {
        final PromocionModel promocion = (PromocionModel) mDataset.get(position);
        holder.imagen.setImageDrawable(promocion.getImage());
        holder.titulo.setText(promocion.getName());
        holder.descripcion.setText(promocion.getDescription());
        holder.activar.setImageDrawable(context.getResources().getDrawable(R.drawable.boton_activar_promocion));

        holder.activar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    DataModel.currentUser.addPromocion(promocion);
                    double x = 0.5;
                    holder.activar.setAlpha((float) x);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolderPromocion extends RecyclerView.ViewHolder {

        protected ImageView imagen;
        protected TextView titulo;
        protected TextView descripcion;
        protected ImageButton activar;

        public ViewHolderPromocion(View v) {
            super(v);

            imagen= (ImageView) v.findViewById(R.id.imagen_promocion);
            titulo= v.findViewById(R.id.texto_titulo_promocion);
            descripcion= v.findViewById(R.id.texto_descripcion_promocion);
            activar= v.findViewById(R.id.boton_activar_promocion);

        }
    }
}
