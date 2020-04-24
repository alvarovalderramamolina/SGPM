package es.aivm.sgpm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import es.aivm.sgpm.adapter.AdapterProducto;
import es.aivm.sgpm.model.DataModel;
import es.aivm.sgpm.model.ProductModel;
import es.aivm.sgpm.model.UserModel;

public class ProductosCategoria extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AdapterProducto mAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_productos_categoria);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new AdapterProducto(this);
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


        final Intent intent = getIntent();
        String category = intent.getStringExtra("category");

        final TextView categoryName = (TextView) findViewById(R.id.category_text);
        categoryName.setText(category);

        switch (category){
            case "Pantalones":
                for (ProductModel item : DataModel.database.pantalones )
                    mAdapter.add(item);
                break;
            case "Ofertas":
                for (ProductModel item : DataModel.database.ofertas )
                    mAdapter.add(item);
                break;
            case "Accesorios":
                for (ProductModel item : DataModel.database.accesorios )
                    mAdapter.add(item);
                break;
            case "Zapatos":
                for (ProductModel item : DataModel.database.calzado)
                    mAdapter.add(item);
                break;
            case "Abrigos":
                for (ProductModel item : DataModel.database.abrigos)
                    mAdapter.add(item);
                break;
            case "Jerseys":
                for (ProductModel item : DataModel.database.jerseys)
                    mAdapter.add(item);
                break;
        }

        hideNavigationBar();
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
