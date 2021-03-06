package es.aivm.sgpm.adapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.aivm.sgpm.Producto;
import es.aivm.sgpm.R;
import es.aivm.sgpm.model.DataModel;
import es.aivm.sgpm.model.ProductModel;

/**
 * Created by AIVM on 06/04/2020.
 */
public class AdapterProducto extends RecyclerView.Adapter<AdapterProducto.ViewHolderProduct> {
    private List mDataset;
    private Context context;

    public AdapterProducto(Context c) {
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

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_productos_categoria, parent, false);
        ViewHolderProduct vh = new ViewHolderProduct(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolderProduct holder, final int position) {
        final ProductModel item = (ProductModel) mDataset.get(position);
        holder.productImage.setImageDrawable(item.getImagen());
        holder.name.setText(item.getNombre());
        holder.brand.setText(item.getMarca());
        holder.rating.setRating(item.getValoracionMedia());
        holder.amountRating.setText(item.getNumValoraciones() + " valoraciones en Amazon.com");
        holder.price.setText(item.getPrecio() + "€");
        if (item.isDisponible())
            holder.availability.setText("Disponible");
        else{
            holder.availability.setText("No disponible");
            holder.availability.setTextColor(Color.parseColor("#ED0327"));
        }
        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataModel.currentProduct=item;

                if (DataModel.currentProduct.isDisponible()) {
                    Intent intent = new Intent(v.getContext(), Producto.class);

                    context.startActivity(intent);
                } else {
                    Toast.makeText(context, "Producto no disponible.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolderProduct extends RecyclerView.ViewHolder {

        protected ImageView productImage;
        protected TextView name;
        protected TextView brand;
        protected RatingBar rating;
        protected TextView amountRating;
        protected TextView price;
        protected TextView availability;
        protected LinearLayout row;


        public ViewHolderProduct(View v) {
            super(v);
            productImage = (ImageView) v.findViewById(R.id.ivItem);
            name = (TextView) v.findViewById(R.id.name_item);
            brand = (TextView) v.findViewById(R.id.brand_item);
            rating = (RatingBar) v.findViewById(R.id.rating_item);
            amountRating = (TextView) v.findViewById(R.id.rating_amount_item);
            price = (TextView) v.findViewById(R.id.price_item);
            availability = (TextView) v.findViewById(R.id.availability_item);
            row = (LinearLayout) v.findViewById(R.id.linear_elemento);
        }
    }
}
