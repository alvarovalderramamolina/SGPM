package es.aivm.sgpm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import es.aivm.sgpm.adapter.AdapterProbador;
import es.aivm.sgpm.adapter.AdapterProduct;
import es.aivm.sgpm.model.DataModel;
import es.aivm.sgpm.model.ItemProduct;
import es.aivm.sgpm.model.ProbadorModel;

import static es.aivm.sgpm.model.DataModel.database;

public class ProbadoresUso extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private AdapterProbador mAdapter;
    private GridLayoutManager gridLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_probadores_uso);
        
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_probadores);
        gridLayoutManager= new GridLayoutManager(getApplicationContext(),4);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        database = new DataModel(this);
        mAdapter = new AdapterProbador(this);
        mRecyclerView.setAdapter(mAdapter);

        for(ProbadorModel item :database.probadores ){
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
