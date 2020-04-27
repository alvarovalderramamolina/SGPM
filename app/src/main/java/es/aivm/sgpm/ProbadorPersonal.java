package es.aivm.sgpm;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import es.aivm.sgpm.adapter.AdapterProbadorPersonal;
import es.aivm.sgpm.model.DataModel;
import es.aivm.sgpm.model.ProductModel;
import es.aivm.sgpm.model.ProbadorModel;
import es.aivm.sgpm.model.UserModel;

public class ProbadorPersonal extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private AdapterProbadorPersonal mAdapter;
    private LinearLayoutManager mLayoutManager;
     boolean isCesta = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_probador_personal);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_probador);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new AdapterProbadorPersonal(this);
        mRecyclerView.setAdapter(mAdapter);
        UserModel usu = DataModel.currentUser;

        final Intent intent = getIntent();
        final String probadorNombre = intent.getStringExtra("name");

       System.out.println("------------------- PROBADORES: " + DataModel.database.probadores.size());

       for (ProbadorModel probador : DataModel.database.probadores) {

            System.out.println("------------------- PROBADOR NAME \"" + probador.getName() +"\"");
            System.out.println("------------------- PROBADOR NAME INTENT \"" + probadorNombre +"\"");
            if (probador.getName().equals(probadorNombre)) {
                System.out.println("------------------- PRODUCTOS CESTA: " + probador.getUser().getCesta().size());
                for (ProductModel item : probador.getUser().getCesta()) {
                    System.out.println("------------------- PRODUCTO PRICE: " + item.getPrecio());
                    mAdapter.add(item);
                }
                break;
            }
        }

        final ImageButton cestaButton= findViewById(R.id.imageButton_cesta);
        final ImageButton probadorButton= findViewById(R.id.imageButton_probador);

       cestaButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               for(ProbadorModel probador : DataModel.database.probadores){
                   if(!isCesta){
                       if (probador.getName().equals(probadorNombre)){
                           for (ProductModel item :probador.getUser().getProbador())
                               mAdapter.remove(item);
                           for(ProductModel item : probador.getUser().getCesta()){
                               mAdapter.add(item);
                           }
                           cestaButton.setImageResource(R.drawable.boton_cesta_activo);
                           probadorButton.setImageResource(R.drawable.boton_probador);
                            isCesta= true;
                           break;
                       }
                   }

               }

           }
       });
       probadorButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               for (ProbadorModel probador : DataModel.database.probadores) {
                    if(isCesta){
                        if (probador.getName().equals(probadorNombre)) {
                        for (ProductModel item : probador.getUser().getCesta())
                            mAdapter.remove(item);
                        for (ProductModel item : probador.getUser().getProbador()) {
                            mAdapter.add(item);
                        }
                        cestaButton.setImageResource(R.drawable.boton_cesta);
                        probadorButton.setImageResource(R.drawable.boton_probador_activo);
                        isCesta=false;
                        break;
                    }}


               }
           }
       });

        TextView t = (TextView) findViewById(R.id.nombre_probador_dentro);
        t.setText(probadorNombre);

        View v1 = (View) findViewById(R.id.iconos_cestas_probador);
        v1.setVisibility(View.INVISIBLE);

        ImageView image1  = (ImageView) findViewById(R.id.logo_amazon);
        Resources res1 = getResources(); /** from an Activity */
        image1.setImageDrawable(res1.getDrawable(R.drawable.logo_blanco));

        LinearLayout rl = (LinearLayout) findViewById(R.id.gridLayout);
        //aplicas color.
        rl.setBackgroundResource(R.color.solidBlue);

        ImageButton volverButton = findViewById(R.id.boton_volver);
        volverButton.setColorFilter(Color.argb(255, 255, 255, 255));
        volverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ImageButton salirButton = findViewById(R.id.boton_salir);
        salirButton.setBackgroundResource(R.color.solidBlue);
        salirButton.setColorFilter(Color.argb(255, 255, 255, 255));
        salirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                startActivity(intent);
            }
        });
        hideNavigationBar();
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

}
