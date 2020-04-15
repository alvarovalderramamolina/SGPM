package es.aivm.sgpm;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ImageView image  = (ImageView) findViewById(R.id.boton_atras);
        Resources res = getResources(); /** from an Activity */

        image.setImageDrawable(res.getDrawable(R.drawable.boton_salir));
    }
}
