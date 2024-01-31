package Ficheros;

import java.math.BigInteger;
import java.time.LocalDate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "titulo", "isbn", "autor", "fecha", "editorial", "categoria", "genero"})
public class Libro {

    // Atributos
    private String Titulo;
    private long Isbn;
    private String Autor;
    private String Editorial;
    private String Fecha; // Cambiado a tipo Date
    private Categoria Categoria;
    private Genero genero;

   public Libro() {

   }


    public Libro(String titulo, long isbn, String autor, String editorial, String fecha, Ficheros.Categoria categoria,
			Genero genero) {
		super();
		this.Titulo = titulo;
		this.Isbn = isbn;
		this.Autor = autor;
		this.Editorial = editorial;
		this.Fecha = fecha;
		this.Categoria = categoria;
		this.genero = genero;
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
    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
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
    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    // Método toString
    @Override
    public String toString() {
        return "Libro [Titulo=" + Titulo + ", ISBN=" + Isbn + ", Autor=" + Autor + ", Fecha=" + Fecha + ", Editorial="
                + Editorial + ", Categoría=" + Categoria + "]";
    }
}
