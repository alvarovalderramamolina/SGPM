package es.aivm.sgpm;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import es.aivm.sgpm.adapter.AdapterCesta;
import es.aivm.sgpm.adapter.AdapterProduct;
import es.aivm.sgpm.dialog.DialogPago;
import es.aivm.sgpm.model.DataModel;

public class ShoppingBasket extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AdapterCesta mAdapter;
    private LinearLayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_basket);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_cesta);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        DataModel.database = new DataModel(this);
        mAdapter = new AdapterCesta(this);
        mRecyclerView.setAdapter(mAdapter);

        final ImageButton finalizarCompra = findViewById(R.id.boton_finalizar_compra);
        finalizarCompra.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogPago cdd=new DialogPago(ShoppingBasket.this);
                cdd.show();

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
