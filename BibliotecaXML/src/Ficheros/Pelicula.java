package Ficheros;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType (propOrder = { "titulo", "codigo", "autor", "nota", "genero1", "genero2", "genero3", "duracion", "espectadores"})
public class Pelicula{
	
	//Atributos
    private String Titulo;
    private int Codigo;
    private String Autor;
    private double Nota;
    private Genero Genero1;
    private Genero Genero2;
    private Genero Genero3;
    private int Duracion = 0;
    private int[] espectadores=null;

    // Constructor vacío
    public Pelicula() {
    }
    
    // Constructor con atributos
    public Pelicula(String titulo, int codigo, String autor, double nota, Genero genero1, Genero genero2, Genero genero3, int duracion, int[] espect) {

        Titulo = titulo;
        Codigo = codigo;
        Autor = autor;
        Nota = nota;
        Genero1 = genero1;
        Genero2 = genero2;
        Genero3 = genero3;
        Duracion = duracion;
        espectadores = espect;
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
    public int getCodigo() {
        return Codigo;
    }
    public void setCodigo(int codigo) {
        Codigo = codigo;
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
    public Genero getGenero1() {
        return Genero1;
    }
    public void setGenero1(Genero genero1) {
        Genero1 = genero1;
    }
    @XmlElement
    public Genero getGenero2() {
        return Genero2;
    }
    public void setGenero2(Genero genero2) {
        Genero2 = genero2;
    }
    @XmlElement
    public Genero getGenero3() {
        return Genero3;
    }
    public void setGenero3(Genero genero3) {
        Genero3 = genero3;
    }
    @XmlElement
    public int getDuracion() {
        return Duracion;
    }
    public void setDuracion(int duracion) {
        Duracion = duracion;
    }

    @XmlElement
    public int[] getEspectadores() {
		return espectadores;
	}

	public void setEspectadores(int[] espectadores) {
		this.espectadores = espectadores;
	}
	
	// Metodo toString
	@Override
    public String toString() {
        return "Pelicula [Titulo=" + Titulo + ", Codigo=" + Codigo + ", Autor=" + Autor + ", Nota=" + Nota
                + ", Genero1=" + Genero1 + ", Genero2=" + Genero2 + ", Genero3=" + Genero3 + ", Duracion=" + Duracion
                + "]";
    }
}