package es.aivm.sgpm;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import es.aivm.sgpm.dialog.Dialogo;
import es.aivm.sgpm.model.DataModel;
import es.aivm.sgpm.model.ProductModel;
import es.aivm.sgpm.model.UserModel;

import static es.aivm.sgpm.model.DataModel.currentUser;

public class Producto extends AppCompatActivity {

    private ProductModel.Talla talla;
    private ProductModel.Color color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);


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

        final ImageButton atras = findViewById(R.id.boton_volver);
        atras.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        final ImageButton apagar = findViewById(R.id.boton_salir);
        apagar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                startActivity(intent);
            }
        });

        hideNavigationBar();
        ImageButton cestaButton = findViewById(R.id.boton_cesta);
        cestaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CestaCliente.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
        ImageButton probadorButton= findViewById(R.id.boton_probador);
        probadorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProbadorCliente.class);
                startActivity(intent);
            }
        });

        final UserModel usu = currentUser;

        System.out.println(usu.getCesta().size());

        final TextView contadorCesta =  findViewById(R.id.contador_cesta);
        contadorCesta.setText(usu.getCesta().size()+"");

        final TextView contadorProbador = findViewById(R.id.contador_probador);
        contadorProbador.setText(usu.getProbador().size()+"");


        final TextView tallaS = (TextView)findViewById(R.id.talla_S);
        final TextView tallaM = (TextView)findViewById(R.id.talla_M);
        final TextView tallaL = (TextView)findViewById(R.id.talla_L);
        final TextView tallaXL = (TextView)findViewById(R.id.talla_XL);

        tallaS.setTextSize(25);
        tallaS.setTypeface(null, Typeface.BOLD);

        talla = ProductModel.Talla.S;

        tallaS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tallaS.setTextSize(25);
                tallaM.setTextSize(15);
                tallaL.setTextSize(15);
                tallaXL.setTextSize(15);

                tallaS.setTypeface(null, Typeface.BOLD);
                tallaM.setTypeface(null, Typeface.NORMAL);
                tallaL.setTypeface(null, Typeface.NORMAL);
                tallaXL.setTypeface(null, Typeface.NORMAL);

                talla = ProductModel.Talla.S;
            }
        });
        tallaM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tallaS.setTextSize(15);
                tallaM.setTextSize(25);
                tallaL.setTextSize(15);
                tallaXL.setTextSize(15);

                tallaS.setTypeface(null, Typeface.NORMAL);
                tallaM.setTypeface(null, Typeface.BOLD);
                tallaL.setTypeface(null, Typeface.NORMAL);
                tallaXL.setTypeface(null, Typeface.NORMAL);

                talla = ProductModel.Talla.M;
            }
        });
        tallaL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tallaS.setTextSize(15);
                tallaM.setTextSize(15);
                tallaL.setTextSize(25);
                tallaXL.setTextSize(15);

                tallaS.setTypeface(null, Typeface.NORMAL);
                tallaM.setTypeface(null, Typeface.NORMAL);
                tallaL.setTypeface(null, Typeface.BOLD);
                tallaXL.setTypeface(null, Typeface.NORMAL);

                talla = ProductModel.Talla.L;
            }
        });
        tallaXL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tallaS.setTextSize(15);
                tallaM.setTextSize(15);
                tallaL.setTextSize(15);
                tallaXL.setTextSize(25);

                tallaS.setTypeface(null, Typeface.NORMAL);
                tallaM.setTypeface(null, Typeface.NORMAL);
                tallaL.setTypeface(null, Typeface.NORMAL);
                tallaXL.setTypeface(null, Typeface.BOLD);

                talla = ProductModel.Talla.XL;
            }
        });

        final LinearLayout azul = (LinearLayout)findViewById(R.id.azul);
        final LinearLayout negro = (LinearLayout)findViewById(R.id.negro);
        final LinearLayout rojo = (LinearLayout)findViewById(R.id.rojo);
        final LinearLayout gris = (LinearLayout)findViewById(R.id.gris);
        final LinearLayout naranja = (LinearLayout)findViewById(R.id.naranja);

        azul.setBackgroundResource(R.color.solidGrey);
        color = ProductModel.Color.AZUL;

        azul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azul.setBackgroundResource(R.color.solidGrey);
                negro.setBackgroundResource(R.color.white);
                rojo.setBackgroundResource(R.color.white);
                gris.setBackgroundResource(R.color.white);
                naranja.setBackgroundResource(R.color.white);

                color = ProductModel.Color.AZUL;
            }
        });
        negro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azul.setBackgroundResource(R.color.white);
                negro.setBackgroundResource(R.color.solidGrey);
                rojo.setBackgroundResource(R.color.white);
                gris.setBackgroundResource(R.color.white);
                naranja.setBackgroundResource(R.color.white);

                color = ProductModel.Color.NEGRO;
            }
        });
        rojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azul.setBackgroundResource(R.color.white);
                negro.setBackgroundResource(R.color.white);
                rojo.setBackgroundResource(R.color.solidGrey);
                gris.setBackgroundResource(R.color.white);
                naranja.setBackgroundResource(R.color.white);

                color = ProductModel.Color.ROJO;
            }
        });
        gris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azul.setBackgroundResource(R.color.white);
                negro.setBackgroundResource(R.color.white);
                rojo.setBackgroundResource(R.color.white);
                gris.setBackgroundResource(R.color.solidGrey);
                naranja.setBackgroundResource(R.color.white);

                color = ProductModel.Color.GRIS;
            }
        });
        naranja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azul.setBackgroundResource(R.color.white);
                negro.setBackgroundResource(R.color.white);
                rojo.setBackgroundResource(R.color.white);
                gris.setBackgroundResource(R.color.white);
                naranja.setBackgroundResource(R.color.solidGrey);

                color = ProductModel.Color.NARANJA;
            }
        });

        final ImageButton addItemAProbador = (ImageButton)findViewById(R.id.add_item_probador);
        addItemAProbador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataModel.currentProduct.setColor(color);
                DataModel.currentProduct.setTalla(talla);

                Dialogo cdd = new Dialogo(Producto.this, "AñadirProductoProbador","¿Estás seguro que quieres añadir este producto para probar más tarde?");
                cdd.show();

            }
        });

        final ImageButton addItemACesta = (ImageButton)findViewById(R.id.add_item_cesta);
        addItemACesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataModel.currentProduct.setColor(color);
                DataModel.currentProduct.setTalla(talla);

                Dialogo cdd = new Dialogo(Producto.this, "AñadirProductoCesta","¿Estás seguro que quieres añadir este producto a la cesta?");
                cdd.show();
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

    @Override
    public void onResume(){
        super.onResume();
        UserModel usu = DataModel.currentUser;

        TextView contadorCesta = (TextView) findViewById(R.id.contador_cesta);
        contadorCesta.setText(usu.getCesta().size()+"");

        TextView contadorProbador = findViewById(R.id.contador_probador);
        contadorProbador.setText(usu.getProbador().size()+"");

    }
}
