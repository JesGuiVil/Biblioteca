package Ficheros;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Biblioteca {

	//Atributos
    private List<Libro> libros = new ArrayList<>();



    //Métodos (Getter y Setter)
    @XmlElement(name = "libros")
	public  List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}



	// CONSTRUCTORES

	// Constructor con atributos
	public Biblioteca(List<Libro> libros) {
		this.libros=libros;
	}

	// Constructor vacío
	public Biblioteca() {

	}


}