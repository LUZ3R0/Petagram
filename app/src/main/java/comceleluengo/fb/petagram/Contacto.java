package comceleluengo.fb.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;

public class Contacto extends AppCompatActivity implements View.OnClickListener {

    private android.support.design.widget.TextInputEditText EditNombre, EditEmail, EditMensaje;
    private Button EnvComen;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        EnvComen = (Button) findViewById(R.id.botEnviar);
        EditNombre = (android.support.design.widget.TextInputEditText) findViewById(R.id.EditNombre);
        EditEmail = (android.support.design.widget.TextInputEditText) findViewById(R.id.EditEmail);
        EditMensaje = (android.support.design.widget.TextInputEditText) findViewById(R.id.EditMensaje);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        //botón de subir
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Agregamos el Icono
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.cat);

        //Cambiamos el título de la toolbar
        getSupportActionBar().setTitle("    Contacto");

        EnvComen.setOnClickListener(this);

    }

    private void sendEmail() {
        //Obtenemos el contenido del email
        String email = "cdlcode@gmail.com";
        String subject = EditEmail.getText().toString().trim();
        String message = EditMensaje.getText().toString().trim();

        //Creamos el objeto SendEmail
        SendMail sm = new SendMail(this, email, subject, message);

        //Ejecutamos SendEmail para enviar el email
        sm.execute();
    }

    @Override
    public void onClick(View v) {
        sendEmail();
        EditNombre.setText("");
        EditEmail.setText("");
        EditMensaje.setText("");

    }

}

