package es.aivm.sgpm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import es.aivm.sgpm.model.DataModel;
import es.aivm.sgpm.model.UserModel;

import static es.aivm.sgpm.model.DataModel.currentUser;

public class Categorias extends AppCompatActivity implements View.OnClickListener{

    static boolean first = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        hideNavigationBar();

        final ImageButton apagar = findViewById(R.id.boton_salir);
        apagar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                startActivity(intent);
            }
        });

        View v= findViewById(R.id.boton_volver);
        ((ViewManager)v.getParent()).removeView(v);

        ImageButton cestaButton = findViewById(R.id.boton_cesta);
        cestaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CestaCliente.class);
                startActivity(intent);
            }
        });
        ImageButton probadorButton= findViewById(R.id.boton_probador);
        probadorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProbadorCliente.class);
                startActivity(intent);
            }
        });

        UserModel  usu = currentUser;

        System.out.println(usu.getCesta().size());

        TextView contadorCesta =  findViewById(R.id.contador_cesta);
        contadorCesta.setText(usu.getCesta().size()+"");

        TextView contadorProbador = findViewById(R.id.contador_probador);
        contadorProbador.setText(usu.getProbador().size()+"");

        TextView ofertasButton = findViewById(R.id.button10);
        TextView accesoriosButton = findViewById(R.id.button9);
        TextView zapatosButton = findViewById(R.id.button8);
        TextView abrigosButton = findViewById(R.id.button7);
        TextView jerseysButton = findViewById(R.id.button2);
        TextView pantalonesButton = findViewById(R.id.button);

        ImageView ofertasImage = findViewById(R.id.imageView8);
        ImageView accesoriosImage = findViewById(R.id.imageView9);
        ImageView zapatosImage = findViewById(R.id.imageView10);
        ImageView abrigosImage = findViewById(R.id.imageView11);
        ImageView jerseysImage = findViewById(R.id.imageView12);
        ImageView pantalonesImage = findViewById(R.id.imageView13);

        ofertasButton.setOnClickListener(this);
        zapatosButton.setOnClickListener(this);
        accesoriosButton.setOnClickListener(this);
        abrigosButton.setOnClickListener(this);
        jerseysButton.setOnClickListener(this);
        pantalonesButton.setOnClickListener(this);

        ofertasImage.setOnClickListener(this);
        accesoriosImage.setOnClickListener(this);
        zapatosImage.setOnClickListener(this);
        abrigosImage.setOnClickListener(this);
        jerseysImage.setOnClickListener(this);
        pantalonesImage.setOnClickListener(this);

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
    @Override
    public void onClick(View v) {
        Intent intent = new Intent (getApplicationContext(), ProductosCategoria.class);
        if(v.getId() == R.id.button10 || v.getId() == R.id.imageView13){
            intent.putExtra("category","Ofertas");
        }else if(v.getId() == R.id.button9 || v.getId() == R.id.imageView12){
            intent.putExtra("category","Accesorios");
        }else if(v.getId() == R.id.button8 || v.getId() == R.id.imageView11){
            intent.putExtra("category","Zapatos");
        }else if(v.getId() == R.id.button7 || v.getId() == R.id.imageView10){
            intent.putExtra("category","Abrigos");
        }else if(v.getId() == R.id.button2 || v.getId() == R.id.imageView9){
            intent.putExtra("category","Jerseys");
        }else if(v.getId() == R.id.button || v.getId() == R.id.imageView8){
            intent.putExtra("category","Pantalones");
        }

        startActivity(intent);
    }
    @Override
    public void onResume(){
        super.onResume();
        UserModel usu = DataModel.currentUser;

        TextView contadorCesta = (TextView) findViewById(R.id.contador_cesta);
        contadorCesta.setText(usu.getCesta().size()+"");

        TextView contadorProbador = findViewById(R.id.contador_probador);
        contadorProbador.setText(usu.getProbador().size()+"");

    }
}
