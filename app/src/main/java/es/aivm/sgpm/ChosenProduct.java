package es.aivm.sgpm;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import es.aivm.sgpm.model.DataModel;
import es.aivm.sgpm.model.ItemProduct;

public class ChosenProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosen_product);

        final ImageView image = (ImageView) findViewById(R.id.imagen);
        image.setImageDrawable(DataModel.currentProduct.getImagen());

        final TextView nombre = (TextView) findViewById(R.id.nombreprod);
        nombre.setText(DataModel.currentProduct.getNombre());

        final TextView marca = (TextView) findViewById(R.id.marcaprod);
        marca.setText(DataModel.currentProduct.getMarca());

        final RatingBar barra = (RatingBar) findViewById(R.id.estrellasprod);
        barra.setRating(DataModel.currentProduct.getValoracionMedia());

        final TextView valoraciones= (TextView) findViewById(R.id.rating_amount_item);
        valoraciones.setText(DataModel.currentProduct.getNumValoraciones()+" valoraciones en amazon.com");

        final TextView precio = (TextView) findViewById(R.id.price_item);
        precio.setText(DataModel.currentProduct.getPrecio()+"€");

        if (DataModel.currentProduct.isDisponible()){
            final TextView disponibilidad = (TextView) findViewById(R.id.availability_item);
            disponibilidad.setText("Disponible");
        }
        else{
            final TextView disponibilidad = (TextView) findViewById(R.id.availability_item);
            disponibilidad.setText("No disponible");
            disponibilidad.setTextColor(Color.parseColor("#ED0327"));
        }
        hideNavigationBar();
        final TextView tallaS = (TextView)findViewById(R.id.talla_S);
        final TextView tallaM = (TextView)findViewById(R.id.talla_M);
        final TextView tallaL = (TextView)findViewById(R.id.talla_L);
        final TextView tallaXL = (TextView)findViewById(R.id.talla_XL);
        tallaS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tallaS.setTypeface(null, Typeface.BOLD);
                tallaM.setTypeface(null, Typeface.NORMAL);
                tallaL.setTypeface(null, Typeface.NORMAL);
                tallaXL.setTypeface(null, Typeface.NORMAL);
            }
        });
        tallaM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tallaS.setTypeface(null, Typeface.NORMAL);
                tallaM.setTypeface(null, Typeface.BOLD);
                tallaL.setTypeface(null, Typeface.NORMAL);
                tallaXL.setTypeface(null, Typeface.NORMAL);
            }
        });
        tallaL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tallaS.setTypeface(null, Typeface.NORMAL);
                tallaM.setTypeface(null, Typeface.NORMAL);
                tallaL.setTypeface(null, Typeface.BOLD);
                tallaXL.setTypeface(null, Typeface.NORMAL);
            }
        });
        tallaXL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tallaS.setTypeface(null, Typeface.NORMAL);
                tallaM.setTypeface(null, Typeface.NORMAL);
                tallaL.setTypeface(null, Typeface.NORMAL);
                tallaXL.setTypeface(null, Typeface.BOLD);
            }
        });
    }
    private void hideNavigationBar() {
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );
    }
}
