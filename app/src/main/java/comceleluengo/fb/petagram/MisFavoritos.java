package comceleluengo.fb.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MisFavoritos extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_favoritos);

        //botón de subir
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.cat);

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