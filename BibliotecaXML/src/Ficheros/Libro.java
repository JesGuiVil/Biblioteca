package Ficheros;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType (propOrder = { "titulo", "isbn", "autor", "nota", "categoria"})
public class Libro{

	//Atributos
	private String Titulo;
	private int Isbn;
	private String Autor;
	private double Nota;
	private Categoria Categoria;

	// Constructor vacío
	public Libro() {
	}

	// Constructor con atributos
	public Libro(String titulo, int isbn, String autor, double nota, Categoria categoria) {

		Titulo = titulo;
		Isbn = isbn;
		Autor = autor;
		Nota = nota;
		Categoria = categoria;
	}


	// Metodos (Getter y Setter)
	@XmlElement
	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	@XmlElement
	public int getIsbn() {
		return Isbn;
	}
	public void setIsbn(int isbn) {
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
	public double getNota() {
		return Nota;
	}
	public void setNota(double nota) {
		Nota = nota;
	}
	@XmlElement
	public Categoria getCategoria() {
		return Categoria;
	}
	public void setCategoria(Categoria categoria) {
		Categoria = categoria;
	}

	// Metodo toString
	@Override
	public String toString() {
		return "Pelicula [Titulo=" + Titulo + ", ISBN=" + Isbn + ", Autor=" + Autor + ", Nota=" + Nota
				+ ", Genero=" + Categoria +"]";
	}
}