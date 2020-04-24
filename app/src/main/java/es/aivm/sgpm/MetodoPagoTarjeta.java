package es.aivm.sgpm;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.ImageButton;
        import android.widget.TextView;
        import android.widget.Toast;

        import es.aivm.sgpm.model.DataModel;
        import es.aivm.sgpm.model.UserModel;

public class MetodoPagoTarjeta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodo_pago_tarjeta);


        final ImageButton atras = findViewById(R.id.boton_volver);
        atras.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        final ImageButton apagar = findViewById(R.id.boton_salir);
        apagar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                startActivity(intent);
            }
        });

        final EditText etNumTarjeta = findViewById(R.id.num_tarjeta);
        final EditText etCaducidad = findViewById(R.id.caducidad);
        final EditText etCodSeguridad = findViewById(R.id.cod_seguridad);

        final ImageButton pagarTarjeta = findViewById(R.id.pagar_tarjeta);
        pagarTarjeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String numTarjeta = etNumTarjeta.getText().toString();
                String caducidad = etCaducidad.getText().toString();
                String codSeguridad = etCodSeguridad.getText().toString();
                if(!numTarjeta.equals("") && !caducidad.equals("") && !codSeguridad.equals("")){
                    Intent intent = new Intent(getApplicationContext(),Agradecimiento.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Todos los campos deben estar rellenos.", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
