package comceleluengo.fb.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;
import comceleluengo.fb.petagram.adaptadores.AnimalesAdapter;
import comceleluengo.fb.petagram.pojo.Animales;

public class MisFavoritos extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_favoritos);

        toolbar = (Toolbar)findViewById(R.id.toolbar);

        if (toolbar!=null){
            setSupportActionBar(toolbar);
        }

        //botón de subir
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //cambiamos el título de appbar
        getSupportActionBar().setTitle("    Mis mascotas favoritas");

        //Agregamos el Icono
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.cat);

        //Inicializamos los datos del ArrayList
        List<Animales> items = new ArrayList<>();

        items.add(new Animales(R.drawable.jerry, "Jerry", 0,0));
        items.add(new Animales(R.drawable.stitch, "Stitch", 0,0));
        items.add(new Animales(R.drawable.tom, "Tom", 0, 0));
        items.add(new Animales(R.drawable.pajaroloco, "P. Loco", 0, 0));
        items.add(new Animales(R.drawable.ayudantedesanta, "A. de Santa", 0, 0));

        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usamos un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Creamos un nuevo adaptador
        adapter = new AnimalesAdapter(items);
        recycler.setAdapter(adapter);

    }

}