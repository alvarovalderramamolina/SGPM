package es.aivm.sgpm;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.security.AccessControlException;

import es.aivm.sgpm.exception.AccesLoginException;
import es.aivm.sgpm.model.DataModel;
import es.aivm.sgpm.model.UserModel;

public class InicioSesion extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        this.context = getApplicationContext();

        setListeners();
    }

    private void setListeners() {
        final Button button = findViewById(R.id.initSesion);
        final EditText email = findViewById(R.id.emailInput);
        final EditText pw = findViewById(R.id.passwordInput);
        final ImageButton atras = findViewById(R.id.backButton);

        atras.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String emailValue = email.getText().toString();
                String pwValue = pw.getText().toString();

                if(!emailValue.equals("") && !pwValue.equals("")){
                    try {
                        changeTheActivityByTypeUser(emailValue, pwValue);
                    } catch (AccesLoginException e) {
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "Todos los campos deben estar rellenos.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void changeTheActivityByTypeUser(String emailValue, String pwValue) throws AccesLoginException {

        final Intent intentOrigen = getIntent();
        String tipoUsuario = intentOrigen.getStringExtra("usuario");

        if (tipoUsuario.equals("cliente")) {
            UserModel u = DataModel.database.logInUsuario(emailValue, pwValue);

            if(u != null) {
                DataModel.currentUser = u;

                Intent intent = new Intent (getApplicationContext(), Categorias.class);
                startActivity(intent);
            }else{
                throw new AccesLoginException();
            }
        } else if (tipoUsuario.equals("personal")) {
            boolean isAdmin = DataModel.database.logInAdmin(emailValue, pwValue);

            if(isAdmin) {
                Intent intent = new Intent (getApplicationContext(), ProbadoresActivosPersonal.class);
                startActivity(intent);
            }else{
                throw new AccesLoginException();
            }
        }
    }
}
