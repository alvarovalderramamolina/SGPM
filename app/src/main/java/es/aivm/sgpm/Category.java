package es.aivm.sgpm;

import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import es.aivm.sgpm.model.DataModel;
import es.aivm.sgpm.model.UserModel;

import static es.aivm.sgpm.model.DataModel.currentUser;

public class Category extends AppCompatActivity implements View.OnClickListener{

    static boolean first = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        hideNavigationBar();

        if (first){
            DataModel.database = new DataModel(this);
            first = false;
        }
      
        ImageButton salirButton = findViewById(R.id.boton_salir);
        salirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        View v= findViewById(R.id.boton_volver);
        ((ViewManager)v.getParent()).removeView(v);

        ImageButton cestaButton = findViewById(R.id.boton_cesta);
        cestaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ShoppingBasket.class);
                startActivity(intent);
            }
        });
        ImageButton probadorButton= findViewById(R.id.boton_probador);
        probadorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FittingRoom.class);
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

        ofertasButton.setOnClickListener(this);
        zapatosButton.setOnClickListener(this);
        accesoriosButton.setOnClickListener(this);
        abrigosButton.setOnClickListener(this);
        jerseysButton.setOnClickListener(this);
        pantalonesButton.setOnClickListener(this);

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
        Intent intent = new Intent (getApplicationContext(), Products.class);
        switch (v.getId()){
            case R.id.button10:
                intent.putExtra("category","Ofertas");
                break;
            case R.id.button9:
                intent.putExtra("category","Accesorios");
                break;
            case R.id.button8:
                intent.putExtra("category","Zapatos");
                break;
            case R.id.button7:
                intent.putExtra("category","Abrigos");
                break;
            case R.id.button2:
                intent.putExtra("category","Jerseys");
                break;
            case R.id.button:
                intent.putExtra("category","Pantalones");
                break;
        }
        startActivity(intent);
    }
}
