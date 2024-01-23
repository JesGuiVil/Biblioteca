package Ficheros;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Disney {
	
	// Atributos
	private CategoriaPeliculas peliculas;
    private CategoriaSeries series;
    
    
    // Métodos (Getter y Setter)
    @XmlElement(name = "peliculas")
	public CategoriaPeliculas getPeliculas() {
		return peliculas;
	}
	public void setPeliculas(CategoriaPeliculas peliculas) {
		this.peliculas = peliculas;
	}
	@XmlElement(name = "series")
	public CategoriaSeries getSeries() {
		return series;
	}
	public void setSeries(CategoriaSeries series) {
		this.series = series;
	}
	
	// CONSTRUCTORES
	
	// Constructor con atributos	
	public Disney(CategoriaPeliculas categoriaPeliculas, CategoriaSeries categoriaSeries) {
		this.peliculas=categoriaPeliculas;
		this.series=categoriaSeries;
	}
	
	// Constructor vacío
	public Disney() {
		
	}
	
    
}