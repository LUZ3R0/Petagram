package comceleluengo.fb.petagram.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
public class PerfilFragment extends Fragment {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private GridLayoutManager miGrid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        //inicializamos los datos
        List<Animales> items = new ArrayList<>();

        items.add(new Animales(R.drawable.jerry, "Jerry", 9,0));
        items.add(new Animales(R.drawable.jerry, "Jerry", 5,0));
        items.add(new Animales(R.drawable.jerry, "Jerry", 3, 0));
        items.add(new Animales(R.drawable.jerry, "Jerry", 11,0));
        items.add(new Animales(R.drawable.jerry, "Jerry", 7,0));
        items.add(new Animales(R.drawable.jerry, "Jerry",8,0));
        items.add(new Animales(R.drawable.jerry, "Jerry", 1, 0));

        recycler = (RecyclerView) v.findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        //Mostramos las imágenes cargadas en forma de Grid
        miGrid= new GridLayoutManager(getActivity(),3, GridLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(miGrid);

        //  Creamos un nuevo adaptador
        adapter = new AnimalesAdapter(items);
        recycler.setAdapter(adapter);

        return v;

    }





}
