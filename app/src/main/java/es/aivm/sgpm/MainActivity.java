package es.aivm.sgpm;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import es.aivm.sgpm.model.DataModel;
import es.aivm.sgpm.model.UserModel;

public class MainActivity extends AppCompatActivity {
    static boolean first = true;

    private void setListeners() {
        final Button clienteButton = findViewById(R.id.zonaClientesButton);
        clienteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), InitSesion.class);
                intent.putExtra("usuario", "cliente");
                startActivity(intent);
            }
        });

        final Button invitadoButton = findViewById(R.id.invitadoButton);
        invitadoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                UserModel u = new UserModel();
                DataModel.currentUser = u;

                Intent intent = new Intent (getApplicationContext(), Category.class);
                startActivity(intent);
            }
        });

        final Button adminButton = findViewById(R.id.accesoPersonalButton);
        adminButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), InitSesion.class);
                intent.putExtra("usuario", "personal");
                startActivity(intent);
            }
        });

        final Button crearCuentaButton = findViewById(R.id.crearCuentaButton);
        crearCuentaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), Registro.class);
                startActivity(intent);
            }
        });
    }

    //find by id get text
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (first){
            DataModel.database = new DataModel(this);
            first = false;
        }
        setListeners();
        hideNavigationBar();
    }

    private void hideNavigationBar(){
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
