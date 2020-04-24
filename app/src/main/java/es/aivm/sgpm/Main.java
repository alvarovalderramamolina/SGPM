package es.aivm.sgpm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import es.aivm.sgpm.model.DataModel;
import es.aivm.sgpm.model.ProbadorModel;
import es.aivm.sgpm.model.UserModel;

public class Main extends AppCompatActivity {


    private void setListeners() {
        final Button clienteButton = findViewById(R.id.zonaClientesButton);
        clienteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), InicioSesion.class);
                intent.putExtra("usuario", "cliente");
                startActivity(intent);
            }
        });

        final Button invitadoButton = findViewById(R.id.invitadoButton);
        invitadoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                UserModel u = new UserModel();
                DataModel.currentUser = u;

                if (DataModel.firstInvitee) {
                    DataModel.firstInvitee = false;
                } else {
                    for (int i=0; i<DataModel.database.usuarios.size(); i++) {
                        UserModel user = DataModel.database.usuarios.get(i);
                        if(user.isGuest()) {
                            DataModel.database.usuarios.remove(i);
                            break;
                        }
                    }
                    for (int i=0; i<DataModel.database.probadores.size(); i++) {
                        ProbadorModel prob = DataModel.database.probadores.get(i);
                        if(prob.getUser().isGuest()) {
                            DataModel.database.probadores.remove(i);
                            break;
                        }
                    }
                }
                DataModel.database.usuarios.add(u);
                DataModel.database.crearProbador(DataModel.database.usuarios.size()-1);
                Intent intent = new Intent (getApplicationContext(), Categorias.class);
                startActivity(intent);
            }
        });

        final Button adminButton = findViewById(R.id.accesoPersonalButton);
        adminButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), InicioSesion.class);
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
        System.out.println("------------------- FIRST: " + DataModel.first);
        if (DataModel.first){
            DataModel.database = new DataModel(this);
            DataModel.first = false;
        }
        System.out.println("------------------- PROBADORES: " + DataModel.database.probadores.size());
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
