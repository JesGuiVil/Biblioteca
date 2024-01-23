package Ficheros;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class CategoriaPeliculas {
	
	//Atributos
    public static List<Pelicula> peliculasMarvel = new ArrayList<>();
    public static List<Pelicula> peliculasPixar = new ArrayList<>();;
    public static List<Pelicula> peliculasDisney = new ArrayList<>();;
    public static List<Pelicula> peliculasStarWars = new ArrayList<>();;
    
    
    //Métodos (Getter y Setter)
    @XmlElement(name = "peliculasDisney")
	public  List<Pelicula> getPeliculasDisney() {
		return peliculasDisney;
	}

	public void setPeliculasDisney(List<Pelicula> peliculasDisney) {
		CategoriaPeliculas.peliculasDisney = peliculasDisney;
	}
	@XmlElement(name = "peliculasStarWars")
	public List<Pelicula> getPeliculasStarWars() {
		return peliculasStarWars;
	}

	public void setPeliculasStarWars(List<Pelicula> peliculasStarWars) {
		CategoriaPeliculas.peliculasStarWars = peliculasStarWars;
	}
	@XmlElement(name = "peliculasMarvel")
	public List<Pelicula> getPeliculasMarvel() {
		return peliculasMarvel;
	}

	public void setPeliculasMarvel(List<Pelicula> peliculasMarvel) {
		CategoriaPeliculas.peliculasMarvel = peliculasMarvel;
	}
	@XmlElement(name = "peliculasPixar")
	public List<Pelicula> getPeliculasPixar() {
		return peliculasPixar;
	}
	
	public void setPeliculasPixar(List<Pelicula> peliculasPixar) {
		CategoriaPeliculas.peliculasPixar = peliculasPixar;
	}
	
	// CONSTRUCTORES
	
	// Constructor con atributos
	public CategoriaPeliculas(List<Pelicula> peliculasmarvel, List<Pelicula> peliculaspixar,
			List<Pelicula> peliculasdisney, List<Pelicula> peliculasstarwars) {
		CategoriaPeliculas.peliculasMarvel = peliculasmarvel;
		CategoriaPeliculas.peliculasPixar = peliculaspixar;
		CategoriaPeliculas.peliculasDisney = peliculasdisney;
		CategoriaPeliculas.peliculasStarWars = peliculasstarwars;
	}
	
	// Constructor vacío
	public CategoriaPeliculas() {
		
	}

    
}