package comceleluengo.fb.petagram;

/**
 * Created by Usuario on 06/05/2016.
 */
public class Animales {

    private int imagen;
    private String nombre;
    private int likes;
    private int favoritos;

    public Animales(int imagen, String nombre, int likes, int favoritos) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.likes = likes;
        this.favoritos = favoritos;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getLikes() {
        return likes;
    }

    public int getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(int favoritos) {
        this.favoritos = favoritos;
    }
}
