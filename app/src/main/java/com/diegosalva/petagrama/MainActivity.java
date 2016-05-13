package com.diegosalva.petagrama;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout srlMiIndicadorRefresh;
    ListView lvMiLista;
    Adapter Adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFAB();

        srlMiIndicadorRefresh= (SwipeRefreshLayout) findViewById(R.id.srlMiIndicadorRefresh);
        lvMiLista= (ListView) findViewById(R.id.lvMiLista);

        String[] planetas= getResources().getStringArray(R.array.planetas);
        lvMiLista.setAdapter(new ArrayAdapter (this, android.R.layout.simple_list_item_1, planetas));

        srlMiIndicadorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                RefrescandoContenido();
            }
        });

    }

    public void RefrescandoContenido(){
        String[] planetas= getResources().getStringArray(R.array.planetas);
        lvMiLista.setAdapter(new ArrayAdapter (this, android.R.layout.simple_list_item_1, planetas));
        srlMiIndicadorRefresh.setRefreshing(false);
    }

    public void agregarFAB(){
        FloatingActionButton miFAB=(FloatingActionButton) findViewById(R.id.fabMiFAB);
                miFAB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("FLOATBUTTOM","click en float button");

                        //Toast.makeText(getBaseContext(), getResources().getString(R.string.mensaje), Toast.LENGTH_SHORT).show();
                        Snackbar.make(v, getResources().getString(R.string.mensaje), Snackbar.LENGTH_LONG)
                                .setAction(getResources().getString(R.string.texto_accion), new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Log.i("SNACKBAR", "Click en snackbar");


                                    }
                                })
                                .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                                .show();

                    }
                });
    }
}
