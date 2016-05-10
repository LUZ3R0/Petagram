package comceleluengo.fb.petagram;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Icono
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.cat);

        List<Animales> items = new ArrayList<>();

        items.add(new Animales(R.drawable.ayudantedesanta, "A. de Santa", 0,0));
        items.add(new Animales(R.drawable.bicho, "Bicho", 0,0));
        items.add(new Animales(R.drawable.garfield, "Garfield", 0,0));
        items.add(new Animales(R.drawable.jerry, "Jerry", 0,0));
        items.add(new Animales(R.drawable.pajaroloco, "P. Loco", 0,0));
        items.add(new Animales(R.drawable.plutodos, "Pluto", 0,0));
        items.add(new Animales(R.drawable.stitch, "Stitch",0,0));
        items.add(new Animales(R.drawable.tom, "Tom", 0,0));

        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usamos un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Creamos un nuevo adaptador
        adapter = new AnimalesAdapter(items);
        recycler.setAdapter(adapter);


    }

    //Muestro en la appbar el actionview
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menudeopciones, menu);
        return true;
    }


    //Defino lo que pasa cuando hago click en cualquier actionview de la appbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.misFavoritos:

                Intent miintent = new Intent(this, MisFavoritos.class);
                startActivity(miintent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }


}
