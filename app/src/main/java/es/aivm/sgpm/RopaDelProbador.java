package es.aivm.sgpm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import es.aivm.sgpm.adapter.AdapterRopaProbada;
import es.aivm.sgpm.model.DataModel;
import es.aivm.sgpm.model.ItemProduct;
import es.aivm.sgpm.model.ItemsProbador;

public class RopaDelProbador extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private AdapterRopaProbada mAdapter;
    private LinearLayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ropa_del_probador);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_probador);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        DataModel.database = new DataModel(this);
        mAdapter= new AdapterRopaProbada(this);
        mRecyclerView.setAdapter(this.mAdapter);

        for (ItemProduct item: DataModel.database.abrigos ) {
            mAdapter.add(item);
        }

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
