package es.aivm.sgpm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.aivm.sgpm.adapter.AdapterProbadorPersonal;
import es.aivm.sgpm.model.DataModel;
import es.aivm.sgpm.model.ProductModel;

public class SolicitudFacturaPersonal extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AdapterProbadorPersonal mAdapter;
    private LinearLayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_factura_personal);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_factura_personal);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AdapterProbadorPersonal(this);
        mRecyclerView.setAdapter(mAdapter);

        for (ProductModel item : DataModel.currentUser.getCesta()){

            mAdapter.add(item);}

        Button enviarButton = findViewById(R.id.enviar_factura);
        enviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Factura.class);
                startActivity(intent);
            }
        });

        TextView texto = findViewById(R.id.texto_factura_personal);
        texto.setText(DataModel.currentProbador.getName()+" quiere comprar");
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
