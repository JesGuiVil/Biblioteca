package Ficheros;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "titulo", "isbn", "autor", "fecha", "editorial", "categoria", "genero1", "genero2" })
public class Libro {

    // Atributos
    private String Titulo;
    private long Isbn;
    private String Autor;
    private String Editorial;
    private Date Fecha; // Cambiado a tipo Date
    private Categoria Categoria;
    private Genero genero1;
    private Genero genero2;

   public Libro() {

   }


    public Libro(String titulo, long isbn, String autor, String editorial, Date fecha, Ficheros.Categoria categoria,
			Genero genero1, Genero genero2) {
		super();
		Titulo = titulo;
		Isbn = isbn;
		Autor = autor;
		Editorial = editorial;
		Fecha = fecha;
		Categoria = categoria;
		this.genero1 = genero1;
		this.genero2 = genero2;
	}

	// Métodos (Getter y Setter)
    @XmlElement
    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    @XmlElement
    public long getIsbn() {
        return Isbn;
    }

    public void setIsbn(long isbn) {
        Isbn = isbn;
    }

    @XmlElement
    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    @XmlElement
    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String editorial) {
        Editorial = editorial;
    }

    @XmlElement
    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    @XmlElement
    public Categoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(Categoria categoria) {
        Categoria = categoria;
    }

    @XmlElement
    public Genero getGenero1() {
        return genero1;
    }

    public void setGenero1(Genero genero1) {
        this.genero1 = genero1;
    }

    @XmlElement
    public Genero getGenero2() {
        return genero2;
    }

    public void setGenero2(Genero genero2) {
        this.genero2 = genero2;
    }

    // Método toString
    @Override
    public String toString() {
        return "Libro [Titulo=" + Titulo + ", ISBN=" + Isbn + ", Autor=" + Autor + ", Fecha=" + Fecha + ", Editorial="
                + Editorial + ", Categoría=" + Categoria + "]";
    }
}
