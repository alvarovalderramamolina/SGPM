package es.aivm.sgpm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import es.aivm.sgpm.adapter.AdapterFactura;
import es.aivm.sgpm.adapter.AdapterProbadorCliente;
import es.aivm.sgpm.model.DataModel;
import es.aivm.sgpm.model.ProductModel;
import es.aivm.sgpm.model.PromocionModel;
import es.aivm.sgpm.model.UserModel;

public class Factura extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AdapterFactura mAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_factura);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AdapterFactura(this);
        mRecyclerView.setAdapter(mAdapter);

        UserModel usu = DataModel.currentUser;

        double total = 0;

        for (ProductModel item : DataModel.currentUser.getCesta() ) {
            total += item.getPrecio();
            mAdapter.add(item);
        }


        ImageButton cestaButton = findViewById(R.id.boton_cesta);
        cestaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CestaCliente.class);
                startActivity(intent);
            }
        });

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

        ImageButton probadorButton = findViewById(R.id.boton_probador);
        probadorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProbadorPersonal.class);
                startActivity(intent);
            }
        });

        TextView contadorCesta = (TextView) findViewById(R.id.contador_cesta);
        contadorCesta.setText(usu.getCesta().size()+"");

        TextView contadorProbador = findViewById(R.id.contador_probador);
        contadorProbador.setText(usu.getProbador().size()+"");

        double descuento = 0;

        if (!DataModel.currentUser.isGuest()) {
            for (PromocionModel promo : DataModel.currentUser.getPromocionesActivadas() ) {
                descuento += promo.getDiscount();
            }

            descuento += (DataModel.currentUser.getPuntosUsados())*0.01;

            descuento *= total;
        }

        double precio = Math.round((total-descuento) * 100.0) / 100.0;
        double rebaja= Math.round((descuento) * 100.0)/100.0;

        TextView precio_total = findViewById(R.id.precio_total);
        precio_total.setText((precio) + "€");

        TextView descuentoTotal = findViewById(R.id.descuento_total);
        descuentoTotal.setText("-"+ (rebaja) + "€");

        ImageButton creditoButton = findViewById(R.id.pagar_tarjeta);
        creditoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MetodoPagoTarjeta.class);
                startActivity(intent);
            }
        });

        ImageButton paypalButton = findViewById(R.id.pagarPaypal);
        paypalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MetodoPagoPaypal.class);
                startActivity(intent);
            }
        });

    }
}
