package es.aivm.sgpm.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.aivm.sgpm.R;
import es.aivm.sgpm.ShoppingBasket;
import es.aivm.sgpm.dialog.DialogPago;
import es.aivm.sgpm.model.ItemProduct;

import static es.aivm.sgpm.model.ItemProduct.Color.*;

public class AdapterCesta extends RecyclerView.Adapter<AdapterCesta.ViewHolderProduct> {
    private List mDataset;
    private Context context;

    public AdapterCesta(Context c) {
        this.context = c;
        mDataset = new ArrayList();
    }

    public void add(ItemProduct product) {
        mDataset.add(product);
        notifyItemInserted(mDataset.indexOf(product));
    }
    public void remove(ItemProduct product) {
        int position = mDataset.indexOf(product);

        if(position != -1) {
            mDataset.remove(position);
            notifyItemRemoved(position);
        }
    }

    @Override
    public ViewHolderProduct onCreateViewHolder(ViewGroup parent, int i) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cesta, parent, false);
        ViewHolderProduct vh = new ViewHolderProduct(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolderProduct holder, final int position) {
        final ItemProduct item = (ItemProduct) mDataset.get(position);
        holder.productImage.setImageDrawable(item.getImagen());
        holder.name.setText(item.getNombre());
        holder.brand.setText(item.getMarca());
        holder.price.setText(item.getPrecio() + "€");
        holder.papelera.setImageDrawable(context.getResources().getDrawable(R.drawable.icono_papelera));
        holder.color.setText(item.getColor().toString());
        holder.talla.setText(item.getTalla().toString());

        switch (item.getColor()) {
            case AZUL:
                holder.colorImagen.setBackground(context.getResources().getDrawable(R.color.solidBlue));
                break;
            case NEGRO:
                holder.colorImagen.setBackground(context.getResources().getDrawable(R.color.black));
                break;
            case ROJO:
                holder.colorImagen.setBackground(context.getResources().getDrawable(R.color.solidRed));
                break;
            case GRIS:
                holder.colorImagen.setBackground(context.getResources().getDrawable(R.color.solidGrey));
                break;
            case NARANJA:
                holder.colorImagen.setBackground(context.getResources().getDrawable(R.color.solidOrange));
                break;

        }


        holder.papelera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogPago cdd = new DialogPago(((ShoppingBasket)context), "EliminarProducto","¿Estás seguro que quieres eliminar este producto de la cesta?");
                cdd.position = position;
                cdd.show();
            }
        });

        /*holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(item);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolderProduct extends RecyclerView.ViewHolder {

        protected ImageView productImage;
        protected TextView name;
        protected TextView brand;
        protected TextView price;
        protected TextView talla;
        protected TextView color;
        protected ImageButton papelera;
        protected ImageView colorImagen;


        public ViewHolderProduct(View v) {
            super(v);
            productImage = (ImageView) v.findViewById(R.id.ivItem);
            name = (TextView) v.findViewById(R.id.name_item);
            brand = (TextView) v.findViewById(R.id.brand_item);
            price = (TextView) v.findViewById(R.id.price_item);
            talla = (TextView) v.findViewById(R.id.talla_prenda);
            color = (TextView) v.findViewById(R.id.color_texto);
            colorImagen = (ImageView) v.findViewById(R.id.color_cuadrado);
            papelera= (ImageButton) v.findViewById(R.id.papelera);

        }
    }
}
