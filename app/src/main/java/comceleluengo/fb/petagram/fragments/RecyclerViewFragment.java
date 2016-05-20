package comceleluengo.fb.petagram.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import comceleluengo.fb.petagram.R;
import comceleluengo.fb.petagram.adaptadores.AnimalesAdapter;
import comceleluengo.fb.petagram.pojo.Animales;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        //inicializamos los datos
        List<Animales> items = new ArrayList<>();

        items.add(new Animales(R.drawable.ayudantedesanta, "A. de Santa", 0,0));
        items.add(new Animales(R.drawable.bicho, "Bicho", 0,0));
        items.add(new Animales(R.drawable.garfield, "Garfield", 0,0));
        items.add(new Animales(R.drawable.jerry, "Jerry", 0,0));
        items.add(new Animales(R.drawable.pajaroloco, "P. Loco", 0,0));
        items.add(new Animales(R.drawable.plutodos, "Pluto", 0,0));
        items.add(new Animales(R.drawable.stitch, "Stitch",0,0));
        items.add(new Animales(R.drawable.tom, "Tom", 0, 0));

        recycler = (RecyclerView) v.findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        //Usamos un administrador para LinearLayout
        lManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(lManager);

        //  Creamos un nuevo adaptador
        adapter = new AnimalesAdapter(items);
        recycler.setAdapter(adapter);

        return v;


    }

}
