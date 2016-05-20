package comceleluengo.fb.petagram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import comceleluengo.fb.petagram.adaptadores.PageAdapter;
import comceleluengo.fb.petagram.fragments.PerfilFragment;
import comceleluengo.fb.petagram.fragments.RecyclerViewFragment;


public class MainActivity extends AppCompatActivity{

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        setUpViewPager();

        if (toolbar!=null){
            setSupportActionBar(toolbar);
        }

        //cambiamos el título de appbar
        getSupportActionBar().setTitle("    Lista de mascotas");

        //Agregamos el Icono
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.cat);
    }

    private ArrayList<Fragment> agregarFragments(){

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        //Mostramos los iconos de los fragments
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_recyclerview);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perfil);


    }

    //Muestro en la appbar los actionviews
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
             case R.id.contacto:
                Intent email = new Intent(this, Contacto.class);
                startActivity(email);
                return true;

             case R.id.acercade:
                Intent mibio = new Intent(this, MiBiografia.class );
                startActivity(mibio);
                return true;

        }
         return super.onOptionsItemSelected(item);
     }


}
