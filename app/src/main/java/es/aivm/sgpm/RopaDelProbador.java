package es.aivm.sgpm;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import es.aivm.sgpm.adapter.AdapterRopaProbada;
import es.aivm.sgpm.model.DataModel;
import es.aivm.sgpm.model.ItemProduct;
import es.aivm.sgpm.model.ItemsProbador;
import es.aivm.sgpm.model.UserModel;

public class RopaDelProbador extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private AdapterRopaProbada mAdapter;
    private LinearLayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ropa_del_probador);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_probador);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        DataModel.database = new DataModel(this);
        mAdapter= new AdapterRopaProbada(this);
        mRecyclerView.setAdapter(this.mAdapter);

        for (ItemProduct item: DataModel.database.abrigos ) {
            mAdapter.add(item);
        }

        View v1 = (View) findViewById(R.id.iconos_cestas_probador);
        v1.setVisibility(View.INVISIBLE);

        ImageView image1  = (ImageView) findViewById(R.id.logo_amazon);
        Resources res1 = getResources(); /** from an Activity */
        image1.setImageDrawable(res1.getDrawable(R.drawable.logo_blanco));



        LinearLayout rl = (LinearLayout) findViewById(R.id.gridLayout);
        //aplicas color.
        rl.setBackgroundResource(R.color.solidBlue);

        ImageButton volverButton = findViewById(R.id.boton_volver);
        volverButton.setColorFilter(Color.argb(255, 255, 255, 255));
        volverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ImageButton salirButton = findViewById(R.id.boton_salir);
        salirButton.setBackgroundResource(R.color.solidBlue);
        salirButton.setColorFilter(Color.argb(255, 255, 255, 255));
        salirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        ImageButton cestaButton = findViewById(R.id.boton_cesta);
        cestaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ShoppingBasket.class);
                startActivity(intent);
            }
        });
        ImageButton probadorButton= findViewById(R.id.boton_probador);
        probadorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RopaDelProbador.class);
                startActivity(intent);
            }
        });
        UserModel usu = DataModel.currentUser;

        TextView contadorCesta = (TextView) findViewById(R.id.contador_cesta);
        contadorCesta.setText(usu.getCesta().size()+"");

        TextView contadorProbador = findViewById(R.id.contador_probador);
        contadorProbador.setText(usu.getProbador().size()+"");

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
}
