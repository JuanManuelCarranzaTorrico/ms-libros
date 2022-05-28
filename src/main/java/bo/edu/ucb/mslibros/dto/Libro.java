package bo.edu.ucb.mslibros.dto;

public class Libro {
    private int idLibro;
    private String Titulo;
    private String Autor;
    private int Publicacion;
    private int Estado;

    public Libro() {
    }

    public Libro(int idLibro, String Titulo, String Autor, int Publicacion, int Estado) {
        this.idLibro = idLibro;
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.Publicacion = Publicacion;
        this.Estado = Estado;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int estado) {
        Estado = estado;
    }

    public int getPublicacion() {
        return Publicacion;
    }

    public void setPublicacion(int publicacion) {
        Publicacion = publicacion;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }
}
