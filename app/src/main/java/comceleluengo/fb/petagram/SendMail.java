package comceleluengo.fb.petagram;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by Usuario on 19/05/2016.
 */

//Class is extending AsyncTask because this class is going to perform a networking operation
public class SendMail extends AsyncTask<Void,Void,Void> {

    //Declarando Variables
    private Context context;
    private Session session;

    //Información de SendEmail
    private String email;
    private String subject;
    private String message;

    //Progressdialog para mostrar mientras enviamos el Email
    private ProgressDialog progressDialog;

    //Clase constructor
    public SendMail(Context context, String email, String subject, String message){
        //Inicializamos las variables
        this.context = context;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Mostrando progressdialog mientras enviamos el email
        progressDialog = ProgressDialog.show(context,"Enviando mensaje","Por favor espere...",false,false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Quitamos el progress dialog
        progressDialog.dismiss();
        //Mostramos mensaje
        Toast.makeText(context,"Mensaje enviado",Toast.LENGTH_LONG).show();

    }

    @Override
    protected Void doInBackground(Void... params) {
        //Creando propiedades
        Properties props = new Properties();

        //Configurando propiedades para gmail
        //Si no estas usando gmail necesitas cambiar los valores
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        //Creando una nueva session
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    //Autenticando la contraseña
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Config.EMAIL, Config.PASSWORD);
                    }
                });

        try {
            //Creando objeto MimeMessage
            MimeMessage mm = new MimeMessage(session);

            //Seteando dirección sender
            mm.setFrom(new InternetAddress(Config.EMAIL));
            //Agregando receptor
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            //Agregando asunto
            mm.setSubject(subject);
            //Agregando mensaje
            mm.setText(message);

            //Enviando mensaje
            Transport.send(mm);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}