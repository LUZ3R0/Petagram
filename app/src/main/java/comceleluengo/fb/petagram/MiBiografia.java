package comceleluengo.fb.petagram;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Usuario on 12/05/2016.
 */
public class MiBiografia extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView nombre, descripcion;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_biografia);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        nombre = (TextView) findViewById(R.id.nombre);
        descripcion = (TextView) findViewById(R.id.descripcion);
        foto = (ImageView) findViewById(R.id.foto);

        if (toolbar!=null){
            setSupportActionBar(toolbar);
        }

        //botón de subir
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Agregamos el Icono
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.cat);

        //cambiamos el título de appbar
        getSupportActionBar().setTitle("    Biografía");

    }
}
