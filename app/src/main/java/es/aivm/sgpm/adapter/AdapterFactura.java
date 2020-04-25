package es.aivm.sgpm.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.aivm.sgpm.ProbadorCliente;
import es.aivm.sgpm.R;
import es.aivm.sgpm.dialog.Dialogo;
import es.aivm.sgpm.model.ProductModel;

public class AdapterFactura extends RecyclerView.Adapter<AdapterFactura.ViewHolderProduct> {
    private List mDataset;
    private Context context;

    public AdapterFactura(Context c) {
        this.context = c;
        mDataset = new ArrayList();
    }

    public void add(ProductModel product) {
        mDataset.add(product);
        notifyItemInserted(mDataset.indexOf(product));
    }
    public void remove(ProductModel product) {
        int position = mDataset.indexOf(product);

        if(position != -1) {
            mDataset.remove(position);
            notifyItemRemoved(position);
        }
    }

    @Override
    public ViewHolderProduct onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_factura, parent, false);
        ViewHolderProduct vh = new ViewHolderProduct(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProduct holder, final int position) {
        final ProductModel item = (ProductModel) mDataset.get(position);

        String name = item.getNombre() + " · Talla " + item.getTalla().toString() + " · Color " + item.getColor().toString();

        holder.name.setText(name);
        holder.price.setText(item.getPrecio() + "€");

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolderProduct extends RecyclerView.ViewHolder {

        protected TextView name;
        protected TextView price;


        public ViewHolderProduct(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.product_label);
            price = (TextView) v.findViewById(R.id.product_price);
        }
    }
}
