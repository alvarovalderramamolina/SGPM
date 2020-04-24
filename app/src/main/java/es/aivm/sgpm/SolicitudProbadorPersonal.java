package es.aivm.sgpm;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import es.aivm.sgpm.adapter.AdapterProbadorCliente;
import es.aivm.sgpm.adapter.AdapterProbadorPersonal;
import es.aivm.sgpm.model.DataModel;
import es.aivm.sgpm.model.ProductModel;

public class SolicitudProbadorPersonal extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AdapterProbadorPersonal mAdapter;
    private LinearLayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_probador_personal);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_solicitudProbadorPersonal);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AdapterProbadorPersonal(this);
        mRecyclerView.setAdapter(mAdapter);

        for (ProductModel item : DataModel.currentUser.getProbador()){

            mAdapter.add(item);}


        final EditText minutos = findViewById(R.id.tiempo_para_llevarle);
        ImageButton minutosButton =  findViewById(R.id.boton_introducir_tiempo);


        minutosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(minutos.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(),"Es obligatorio introducir un tiempo estimado",Toast.LENGTH_SHORT).show();
                else {

                    int tiempo= Integer.parseInt(minutos.getText().toString());

                    Intent intent = new Intent(getApplicationContext(),Espera.class);
                    intent.putExtra("timer",tiempo);
                    startActivity(intent);
                }
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
