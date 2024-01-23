package Ficheros;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class CategoriaSeries {
	
	// Atributos
    static public List<Serie> seriesMarvel = new ArrayList<>();
    static public List<Serie> seriesPixar = new ArrayList<>();
    static public List<Serie> seriesDisney = new ArrayList<>();
    static public List<Serie> seriesStarWars = new ArrayList<>();
    
    
    // Métodos (Getter y Setter)
	@XmlElement(name = "seriesMarvel")
	public List<Serie> getSeriesMarvel() {
		return seriesMarvel;
	}

	public void setSeriesMarvel(List<Serie> seriesMarvel) {
		CategoriaSeries.seriesMarvel = seriesMarvel;
	}
	@XmlElement(name = "seriesPixar")
	public List<Serie> getSeriesPixar() {
		return seriesPixar;
	}

	public void setSeriesPixar(List<Serie> seriesPixar) {
		CategoriaSeries.seriesPixar = seriesPixar;
	}
	@XmlElement(name = "seriesDisney")
	public List<Serie> getSeriesDisney() {
		return seriesDisney;
	}

	public void setSeriesDisney(List<Serie> seriesDisney) {
		CategoriaSeries.seriesDisney = seriesDisney;
	}
	@XmlElement(name = "seriesStarWars")
	public List<Serie> getSeriesStarWars() {
		return seriesStarWars;
	}

	public void setSeriesStarWars(List<Serie> seriesStarWars) {
		CategoriaSeries.seriesStarWars = seriesStarWars;
	}
	
	// CONSTRUCTORES
	
	// Constructor con atributos
	public CategoriaSeries(List<Serie> seriesMarvel, List<Serie> seriesPixar, List<Serie> seriesDisney, List<Serie> seriesStarWars) {
		
		CategoriaSeries.seriesMarvel = seriesMarvel;
		CategoriaSeries.seriesPixar = seriesPixar;
		CategoriaSeries.seriesDisney = seriesDisney;
		CategoriaSeries.seriesStarWars = seriesStarWars;
	}
	
	// Constructor vacío
	public CategoriaSeries() {
		
	}
    
    
}