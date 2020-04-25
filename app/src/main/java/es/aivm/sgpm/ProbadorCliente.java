package es.aivm.sgpm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import es.aivm.sgpm.adapter.AdapterProbadorCliente;
import es.aivm.sgpm.dialog.Dialogo;
import es.aivm.sgpm.model.DataModel;
import es.aivm.sgpm.model.ProductModel;
import es.aivm.sgpm.model.UserModel;

public class ProbadorCliente extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AdapterProbadorCliente mAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_probador_cliente);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_fitt);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AdapterProbadorCliente(this);
        mRecyclerView.setAdapter(mAdapter);

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

        final ImageButton finalizarCompra = findViewById(R.id.boton_probar_ahora);
        finalizarCompra.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Dialogo cdd = new Dialogo(ProbadorCliente.this, "PedirProductos","¿Estás seguro que quieres probar los productos?");
                cdd.show();
            }
        });

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

            }
        });
        UserModel usu = DataModel.currentUser;

        TextView contadorCesta = (TextView) findViewById(R.id.contador_cesta);
        contadorCesta.setText(usu.getCesta().size()+"");

        TextView contadorProbador = findViewById(R.id.contador_probador);
        contadorProbador.setText(usu.getProbador().size()+"");
        hideNavigationBar();

        for (ProductModel item : DataModel.currentUser.getProbador() )
            mAdapter.add(item);

        ImageButton camara = (ImageButton) findViewById(R.id.boton_camara);
        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Photo.class);
                startActivity(intent);
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
