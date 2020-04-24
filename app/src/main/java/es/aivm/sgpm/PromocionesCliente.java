package es.aivm.sgpm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import es.aivm.sgpm.adapter.AdapterProbadorPersonal;
import es.aivm.sgpm.adapter.AdapterPromocionesCliente;
import es.aivm.sgpm.model.DataModel;
import es.aivm.sgpm.model.PromocionModel;
import es.aivm.sgpm.model.UserModel;

public class PromocionesCliente extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AdapterPromocionesCliente mAdapter;
    private LinearLayoutManager mLayoutManager;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones_cliente);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_promociones_cliente);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new AdapterPromocionesCliente(this);
        mRecyclerView.setAdapter(mAdapter);

        for(PromocionModel item : DataModel.database.promociones){
            mAdapter.add(item);
        }

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
        UserModel usu = DataModel.currentUser;

        TextView contadorCesta = (TextView) findViewById(R.id.contador_cesta);
        contadorCesta.setText(usu.getCesta().size()+"");

        TextView contadorProbador = findViewById(R.id.contador_probador);
        contadorProbador.setText(usu.getProbador().size()+"");

        TextView puntos = findViewById(R.id.puntuacion_usuario);
        puntos.setText(DataModel.currentUser.getPuntos()+"");

        final ImageButton puntosButton= findViewById(R.id.boton_usar_puntos);
        puntosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataModel.currentUser.usarPuntos();
                puntosButton.setAlpha((float) 0.5);
            }
        });

        ImageButton finalizarButton= findViewById(R.id.boton_finalizar_compra);
        finalizarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Factura.class);
                startActivity(intent);
            }
        });
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
