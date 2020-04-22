package es.aivm.sgpm;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import es.aivm.sgpm.model.DataModel;

public class Category extends AppCompatActivity implements View.OnClickListener{

    static boolean first = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ImageView image  = (ImageView) findViewById(R.id.boton_atras);
        Resources res = getResources(); /** from an Activity */

        image.setImageDrawable(res.getDrawable(R.drawable.boton_salir));
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        hideNavigationBar();

        if (first){
            DataModel.database = new DataModel(this);
            first = false;
        }
      
        ImageButton salirButton = findViewById(R.id.boton_atras);
        salirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
