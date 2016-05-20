package comceleluengo.fb.petagram.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import comceleluengo.fb.petagram.pojo.Animales;
import comceleluengo.fb.petagram.R;

public class AnimalesAdapter extends RecyclerView.Adapter<AnimalesAdapter.AnimalesViewHolder>{

    private List<Animales> items;
    int contador = 0;

    public static class AnimalesViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre, likes;
        public ImageButton raiting;

        public AnimalesViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imgImagen);
            nombre = (TextView) v.findViewById(R.id.tvNombre);
            likes = (TextView) v.findViewById(R.id.tvNumHuesitos);
            raiting = (ImageButton) v.findViewById(R.id.imgraiting);

        }
    }

    public AnimalesAdapter(List<Animales> items) {

        this.items = items;
    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    @Override
    public AnimalesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.animales_card, viewGroup, false);
        return new AnimalesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final AnimalesViewHolder viewHolder, final int i) {

        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.likes.setText(String.valueOf(items.get(i).getLikes()));

        viewHolder.raiting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    contador = contador + 1;
                   //Mediante el setter cambiamos el valor del atributo likes, incrementandolo en 1 cada vez que demos click
                    items.get(i).setLikes(items.get(i).getLikes()+contador);

                    //Obtenemos el valor del atributo likes y lo mostramos en el TextView
                    viewHolder.likes.setText(String.valueOf(items.get(i).getLikes()));

                    //Volvemos el contador a 0 para que cuando hagamos click en otro items comience de 0
                    contador = 0;


            }



        });
    }


}
