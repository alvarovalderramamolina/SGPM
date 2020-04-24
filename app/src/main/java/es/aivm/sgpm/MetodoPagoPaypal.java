package es.aivm.sgpm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import es.aivm.sgpm.adapter.AdapterFactura;
import es.aivm.sgpm.exception.AccesLoginException;
import es.aivm.sgpm.model.DataModel;
import es.aivm.sgpm.model.ProductModel;
import es.aivm.sgpm.model.PromocionModel;
import es.aivm.sgpm.model.UserModel;

public class MetodoPagoPaypal extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodo_pago_paypal);

        Button pagarButton = findViewById(R.id.pagarPaypal);
        final EditText email = findViewById(R.id.emailInput);
        final EditText pw = findViewById(R.id.passwordInput);
        pagarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailValue = email.getText().toString();
                String pwValue = pw.getText().toString();

                if(!emailValue.equals("") && !pwValue.equals("")){
                    Intent intent = new Intent(getApplicationContext(),Agradecimiento.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Todos los campos deben estar rellenos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ImageButton volverButton = findViewById(R.id.boton_volver);
        volverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
