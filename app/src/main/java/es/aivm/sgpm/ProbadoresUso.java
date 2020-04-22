package es.aivm.sgpm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import es.aivm.sgpm.adapter.AdapterProbador;
import es.aivm.sgpm.adapter.AdapterProduct;
import es.aivm.sgpm.model.DataModel;
import es.aivm.sgpm.model.ItemProduct;
import es.aivm.sgpm.model.ProbadorModel;

import static es.aivm.sgpm.model.DataModel.database;

public class ProbadoresUso extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private AdapterProbador mAdapter;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_probadores_uso);
        
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_probadores);
        gridLayoutManager= new GridLayoutManager(getApplicationContext(),4);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        database = new DataModel(this);
        mAdapter = new AdapterProbador(this);
        mRecyclerView.setAdapter(mAdapter);

        for(ProbadorModel item :database.probadores ){
            mAdapter.add(item);
        }



        View v = (View) findViewById(R.id.boton_salir);
        ((ViewManager)v.getParent()).removeView(v);

        View v1 = (View) findViewById(R.id.iconos_cestas_probador);
        v1.setVisibility(View.INVISIBLE);

        ImageView image1  = (ImageView) findViewById(R.id.logo_amazon);
        Resources res1 = getResources(); /** from an Activity */
        image1.setImageDrawable(res1.getDrawable(R.drawable.logo_blanco));

        LinearLayout rl = (LinearLayout) findViewById(R.id.toolbar_products);
            //aplicas color.
        rl.setBackgroundResource(R.color.solidBlue);

        ImageButton volverButton = findViewById(R.id.boton_salir);
        volverButton.setColorFilter(Color.argb(255, 255, 255, 255));
        volverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        
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
