package Ficheros;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class Metodos {


	public static Biblioteca crearXML() {


		//Creamos las listas para agregar las peliculas
		List<Libro> libros = new ArrayList<>();

		//CREACION DE LIBROS
		Libro ironman = new Libro("Iron Man", 1000, "kikewest", 5.1, Categoria.Ficción);
		Libro deadpool = new Libro("Deadpool", 1001, "Tim Miller", 5.1, Categoria.No_ficción);
		Libro toystory = new Libro("Toy Story", 1002, "John Lasseter", 5.1, Categoria.Didácticos);
		Libro cars = new Libro("Cars", 1003, "John Lasseter", 8.1, Categoria.Ciencia);
		Libro elAscensoDeSkyWalker = new Libro("El ascenso de Sky-Walker", 1004, "J. J. Abrams", 5.1, Categoria.Arte);
		Libro hanSolo = new Libro("Han Solo", 1005, "Ron Howard", 8.1, Categoria.Deportes);
		Libro reyLeon  = new Libro("El Rey Leon", 1006, "Rob Minkoff", 5.1, Categoria.Infantiles);
		Libro frozen  = new Libro("Frozen", 1007, "Chris Buck", 8.1, Categoria.Deportes);


		//Añadimos las peliculas
		libros.add(ironman);
		libros.add(deadpool);
		libros.add(toystory);
		libros.add(cars);
		libros.add(elAscensoDeSkyWalker);
		libros.add(hanSolo);
		libros.add(reyLeon);
		libros.add(frozen);

		// Crear un objeto de la clase Disney y configurar las categorías en ese objeto.
		Biblioteca biblioteca = new Biblioteca(libros);

		// Utilizar JAXB para marshalling y convertir objetos en XML
		System.out.println("Archivo creado");
		try {
			JAXBContext context = JAXBContext.newInstance(Biblioteca.class);
			Marshaller marshaller = context.createMarshaller();

			// Marshalling de Disney
			marshaller.marshal(biblioteca, new File("Biblioteca.xml"));
			System.out.println("Archivo generado");

		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Ocurrió el siguiente error: " + e.getMessage());
		}
		return biblioteca;
	}

	public static String leerXML(String rutaArchivoXML) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File xmlFile = new File(rutaArchivoXML);

			Document document = builder.parse(xmlFile);
			document.getDocumentElement().normalize();

			//Se realiza el procesamiento del documento XML y se devuelve el resultado
			return displayNode(document.getDocumentElement(), "");
		} catch (ParserConfigurationException e) {
			return "Error de configuración del analizador XML: " + e.getMessage();
		} catch (SAXException e) {
			return "Error al analizar el archivo XML: " + e.getMessage();
		} catch (IOException e) {
			return "Error de entrada/salida al leer el arvhico XML: " + e.getMessage();
		} catch (Exception e) {
			return "Error inesperado al leer el archivo XML: " + e.getMessage();
		}
	}

	public static String displayNode(Node node, String indent) {
		StringBuilder result = new StringBuilder();
		try {

			if (node instanceof Element) {
				result.append(indent).append("").append(node.getNodeName()).append("\n");
				NodeList children = node.getChildNodes();
				for (int i = 0; i < children.getLength(); i++) {
					result.append(displayNode(children.item(i), indent + "  "));

				}
			} else if (node instanceof Text) {
				String text = ((Text) node).getWholeText().trim();
				if (!text.isEmpty()) {
					result.append(indent).append(text).append("\n");
				}
			}
		} catch (ClassCastException e) {
			result.append(indent).append("Error en el nodo: ").append(e.getMessage()).append("\n");
		} catch (NullPointerException e) {
			result.append(indent).append("Error en el nodo: Referencia nula").append(e.getMessage()).append("\n");
		}

		return result.toString();
	}

	public static Biblioteca reutilizarXML() {
		Biblioteca biblioteca = null;

		try {
			JAXBContext context = JAXBContext.newInstance(Biblioteca.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			biblioteca = (Biblioteca) unmarshaller.unmarshal(new File("Biblioteca.xml"));

			System.out.println("Archivo leído con éxito");

		} catch (JAXBException e) {
			System.out.println("Error al deserializar el archivo XML: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Ocurrió un error inesperado al reutilizar el archivo XML: " + e.getMessage());
		}
		return biblioteca;
	}

	public static void modificarTitulo(Biblioteca biblioteca) {
		String[] opciones = {"Buscar por ISBN", "Buscar por título"};
		int opcionSeleccionada = JOptionPane.showOptionDialog(null, "¿Cómo deseas buscar el libro que deseas modificar el título?",
				"Selecciona una opción", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

		if (opcionSeleccionada == -1) {
			// El usuario canceló la selección o presionó Cancelar
			return;
		}

		String nuevoTitulo = JOptionPane.showInputDialog("Introduce el nuevo título: ");

		if (nuevoTitulo == null) {
			// El usuario canceló la entrada o presionó Cancelar
			return;
		}

		if (opcionSeleccionada == 0) { // Buscar por código
			String isbnString = JOptionPane.showInputDialog("Introduce el ISBN del libro que deseas modificar el título:");

			if (isbnString == null) {
				return;
			}

			try {
				int isbn = Integer.parseInt(isbnString);
				boolean encontrado = false;

				for (Libro libro : biblioteca.getLibros()) {
					if (libro.getIsbn() == isbn) {
						libro.setTitulo(nuevoTitulo);
						encontrado = true;
					}
				}
				if (encontrado) {
					JOptionPane.showMessageDialog(null, "Título modificado correctamente!");
				} else {
					JOptionPane.showMessageDialog(null, "No se encontró ninguna película o serie con el ISBN " + isbn);
				}

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Por favor, introduce un ISBN válido.");
			}
		} else { // Buscar por título
			String tituloBusqueda = JOptionPane.showInputDialog("Introduce el título del libro que deseas modificar:");

			if (tituloBusqueda == null) {
				return;
			}

			boolean encontrado = false;

			// Busca en la lista de películas de Marvel
			for (Libro libro : biblioteca.getLibros()) {
				if (libro.getTitulo().equals(tituloBusqueda)) {
					libro.setTitulo(nuevoTitulo);
					encontrado = true;
				}
			}
			if (encontrado) {
				JOptionPane.showMessageDialog(null, "Título modificado correctamente!");
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró ninguna película o serie con el título " + tituloBusqueda);
			}
		}
		try {
			JAXBContext context = JAXBContext.newInstance(Biblioteca.class);
			Marshaller marshaller = context.createMarshaller();

			// Marshalling de Disney
			marshaller.marshal(biblioteca, new File("Biblioteca.xml"));


			System.out.println("achivo realizado");
		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}
	}


	public static void agregarLibro(Biblioteca biblioteca) {

		try {

			String titulo = JOptionPane.showInputDialog("Introduce el título del libro:");
			if (titulo == null) return; // Usuario canceló

			String isbnStr = JOptionPane.showInputDialog("Introduce el ISBN del libro:");
			if (isbnStr == null) return;
			int isbn = Integer.parseInt(isbnStr);

			String director = JOptionPane.showInputDialog("Introduce el autor:");
			if (director == null) return;

			String ratingStr = JOptionPane.showInputDialog("Introduce el rating de la película:");
			if (ratingStr == null) return;
			double rating = Double.parseDouble(ratingStr);

			Categoria genero = (Categoria) JOptionPane.showInputDialog(null, "Introduce el género:", "Género",
					JOptionPane.QUESTION_MESSAGE, null,
					Categoria.values(), Categoria.values()[0]);
			if (genero == null) return;





			Libro nuevoLibro = new Libro(titulo, isbn, director, rating, genero);
			biblioteca.getLibros().add(nuevoLibro);

			JOptionPane.showMessageDialog(null, "Libro agregado a la biblioteca");

			try {
				JAXBContext context = JAXBContext.newInstance(Biblioteca.class);
				Marshaller marshaller = context.createMarshaller();

				// Marshalling de Disney
				marshaller.marshal(biblioteca, new File("Biblioteca.xml"));


				System.out.println("achivo actualizado");
			} catch (JAXBException e) {
				e.getMessage();
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error en la conversión de datos. Asegúrate de ingresar números válidos.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado. Verifica los datos ingresados.");
		}
	}



	public static void eliminarPorCodigo(Biblioteca biblioteca) {
		String[] opciones = {"Buscar por ISBN", "Buscar por título"};
		int opcionSeleccionada = JOptionPane.showOptionDialog(null, "¿Cómo deseas el libro que deseas eliminar?",
				"Selecciona una opción", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

		if (opcionSeleccionada == -1) {
			// El usuario canceló la selección o presionó Cancelar
			return;
		}

		if (opcionSeleccionada == 0) { // Buscar por código
			String codigoString = JOptionPane.showInputDialog("Introduce el ISBN del libro que deseas eliminar");

			if (codigoString == null) {
				return;
			}

			try {
				int isbn = Integer.parseInt(codigoString);
				boolean encontrado = false;
				boolean libroeliminado= false;

				// Buscar en las listas de películas
				for (Libro libro : biblioteca.getLibros()) {
					if (libro.getIsbn() == isbn) {
						biblioteca.getLibros().remove(libro);
						libroeliminado=true;
						encontrado=true;
						JOptionPane.showMessageDialog(null, "Libro " + libro.getTitulo() + " eliminado.");
						break;
					}
				}


				if (!libroeliminado) {
					JOptionPane.showMessageDialog(null, "No se encontró ninguna libro con el ISBN " + isbn);
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Por favor, introduce un ISBN válido.");
			}
		}else { // Buscar por título
			String tituloBusqueda = JOptionPane.showInputDialog("Introduce el título del libro");

			if (tituloBusqueda == null) {
				return;
			}
			try {
				boolean encontrado=true;
				boolean libroeliminado=false;

				for (Libro libro : biblioteca.getLibros()) {
					if (libro.getTitulo().equals(tituloBusqueda)) {
						biblioteca.getLibros().remove(libro);
						libroeliminado=true;
						encontrado=true;
						JOptionPane.showMessageDialog(null, "Libro " + libro.getTitulo() + " eliminado.");
						break;
					}
				}


				if (!libroeliminado) {
					JOptionPane.showMessageDialog(null, "No se encontró ningun libro con el título " + tituloBusqueda);
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Por favor, introduce un título válido.");
			}
		}

		try {
			JAXBContext context = JAXBContext.newInstance(Biblioteca.class);
			Marshaller marshaller = context.createMarshaller();

			// Marshalling de Disney
			marshaller.marshal(biblioteca, new File("Biblioteca.xml"));


			System.out.println("achivo actualizado");
		} catch (JAXBException e) {
			e.getMessage();
		}
	}

	public static String obtenerInfoPorTitulo(Biblioteca biblioteca, String titulo) {
		StringBuilder info = new StringBuilder();

		try {

			// Buscar en las listas de películas
			for (Libro libro : biblioteca.getLibros()) {
				if (libro.getTitulo().equalsIgnoreCase(titulo)) {
					info.append("Título: ").append(libro.getTitulo()).append("\n");
					info.append("Código: ").append(libro.getIsbn()).append("\n");
					info.append("Director: ").append(libro.getAutor()).append("\n");
					info.append("Rating: ").append(libro.getNota()).append("\n");
					info.append("Géneros: ").append(libro.getCategoria()).append("\n");
					return info.toString();
				}
			}
		} catch (Exception e) {
			return "Ocurrió un error al buscar la información";
		}
		return "No se encontró ningun libro con el título: " + titulo;
	}

}