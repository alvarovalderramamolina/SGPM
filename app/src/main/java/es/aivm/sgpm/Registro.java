package es.aivm.sgpm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import es.aivm.sgpm.model.DataModel;

public class Registro extends AppCompatActivity {

    private void setListeners() {
        final Button button = findViewById(R.id.registerButton);
        final EditText name = findViewById(R.id.nameInput);
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
                String nameValue = name.getText().toString();
                String emailValue = email.getText().toString();
                String pwValue = pw.getText().toString();

                DataModel.database.signUp(nameValue, emailValue, pwValue);

                Intent intent = new Intent (getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_registro);

        setListeners();
    }
}
