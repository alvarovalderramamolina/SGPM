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
import es.aivm.sgpm.model.ItemProduct;

/**
 * Created by AIVM on 06/04/2020.
 */
public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolderProduct> {
    private List mDataset;
    private Context context;

    public AdapterProduct(Context c) {
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

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        ViewHolderProduct vh = new ViewHolderProduct(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolderProduct holder, int position) {
        final ItemProduct item = (ItemProduct) mDataset.get(position);
        holder.imageView.setImageDrawable(item.getImageSrc());
        holder.mTextView.setText(item.getName());

        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolderProduct extends RecyclerView.ViewHolder {

        protected ImageView imageView;
        protected TextView mTextView;

        public ViewHolderProduct(View v) {
            super(v);
            imageView = (ImageView) v.findViewById(R.id.ivItem);
            mTextView = (TextView) v.findViewById(R.id.tvItem);
        }
    }
}
