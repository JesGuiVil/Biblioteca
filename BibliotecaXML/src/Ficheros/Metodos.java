package Ficheros;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		// Ficción
        Libro cienAnosSoledad = new Libro("Cien años de soledad", 9780307350433, "Gabriel García Márquez", "Cien años de soledad", parseFecha("1967-05-30"), Categoria.Ficción, Genero.drama, Genero.magia);
        Libro donQuijote = new Libro("Don Quijote de la Mancha", 9788420412146, "Miguel de Cervantes", "Alonso Fernández de Avellaneda", parseFecha("1605-01-16"), Categoria.Ficción, Genero.aventura, Genero.comedia);
        Libro rayuela = new Libro("Rayuela", 9788437604947, "Julio Cortázar", "Siglo XXI Editores", parseFecha("1963-06-28"), Categoria.Ficción, Genero.drama, Genero.suspense);
        Libro crimenCastigo = new Libro("Crimen y castigo", 9788437602172, "Fiodor Dostoievski", "Siglo XXI Editores", parseFecha("1866-12-22"), Categoria.Ficción, Genero.suspense, Genero.drama);

        // No ficción
        Libro unaBreveHistoriaDelTiempo = new Libro("Una breve historia del tiempo", 9780553380163, "Stephen Hawking", "Bantam Books", parseFecha("1988-04-01"), Categoria.No_ficción, Genero.documental, Genero.ciencia_ficción);
        Libro sapiens = new Libro("Sapiens: De animales a dioses", 9788499924216, "Yuval Noah Harari", "Debate", parseFecha("2011-06-14"), Categoria.No_ficción, Genero.documental, Genero.historia);
        Libro elPrincipe = new Libro("El príncipe", 9788484284232, "Niccolò Machiavelli", "Clásicos Inolvidables", parseFecha("1532"), Categoria.No_ficción, Genero.política, Genero.filosofía);
        Libro intoTheWild = new Libro("Hacia rutas salvajes", 9788433901900, "Jon Krakauer", "Anagrama", parseFecha("1996-01-01"), Categoria.No_ficción, Genero.aventura, Genero.biografía);

        // Didácticos
        Libro elArteDeAprender = new Libro("El arte de aprender", 9788495787555, "Josh Waitzkin", "Empresa Activa", parseFecha("2007-05-25"), Categoria.Didácticos, Genero.autoayuda, Genero.educación);
        Libro elPoderDelHabito = new Libro("El poder del hábito", 9788499982582, "Charles Duhigg", "DeBolsillo", parseFecha("2012-03-06"), Categoria.Didácticos, Genero.psicología, Genero.autoayuda);
        Libro pensarRapidoPensarDespacio = new Libro("Pensar rápido, pensar despacio", 9788498921808, "Daniel Kahneman", "DeBolsillo", parseFecha("2011-11-17"), Categoria.Didácticos, Genero.psicología, Genero.economía);
        Libro elEfectoMariposa = new Libro("El efecto mariposa", 9788498011901, "James Gleick", "Crítica", parseFecha("1987-01-01"), Categoria.Didácticos, Genero.ciencia, Genero.matemáticas);

        // Arte
        Libro elCodigoDaVinci = new Libro("El código Da Vinci", 9788466637951, "Dan Brown", "Ediciones B", parseFecha("2003-03-17"), Categoria.Arte, Genero.suspense, Genero.misterio);
        Libro starryNight = new Libro("La noche estrellada", 9788432092894, "Vincent van Gogh", "Espasa", parseFecha("1889"), Categoria.Arte, Genero.bellas_artes, Genero.pintura);
        Libro elGuernica = new Libro("Guernica", 9788484801600, "Pablo Picasso", "Alianza Editorial", parseFecha("1937"), Categoria.Arte, Genero.bellas_artes, Genero.pintura);
        Libro elNombreDeLaRosa = new Libro("El nombre de la rosa", 9788426411655, "Umberto Eco", "Lumen", parseFecha("1980-10-16"), Categoria.Arte, Genero.misterio, Genero.historia);

        // Infantiles
        Libro dondeVivenLosMonstruos = new Libro("Donde viven los monstruos", 9788493464417, "Maurice Sendak", "Kalandraka", parseFecha("1963-09-17"), Categoria.Infantiles, Genero.infantil, Genero.fantasía);
        Libro elGatoEnElSombrero = new Libro("El gato en el sombrero", 9788448816555, "Dr. Seuss", "Beascoa", parseFecha("1957-03-12"), Categoria.Infantiles, Genero.infantil, Genero.humor);
        Libro elPrincipito = new Libro("El principito", 9788426134623, "Antoine de Saint-Exupéry", "Juventud", parseFecha("1943-04-06"), Categoria.Infantiles, Genero.infantil, Genero.filosofía);
        Libro winnieThePooh = new Libro("Winnie the Pooh", 9780142419407, "A.A. Milne", "Puffin Books", parseFecha("1926-10-14"), Categoria.Infantiles, Genero.infantil, Genero.humor);

        // Autoayuda
        Libro pienseYHagaseRico = new Libro("Piense y hágase rico", 9781619491875, "Napoleon Hill", "Seedbox Press", parseFecha("1937-03-03"), Categoria.Autoayuda, Genero.autoayuda, Genero.exito_personal);
        Libro elSecreto = new Libro("El secreto", 9781582701707, "Rhonda Byrne", "Atria Books", parseFecha("2006-11-26"), Categoria.Autoayuda, Genero.autoayuda, Genero.ley_de_atracción);
        Libro sieteHabitosDeLaGenteAltamenteEfectiva = new Libro("Los 7 hábitos de la gente altamente efectiva", 9788449318016, "Stephen R. Covey", "Paidós", parseFecha("1989-08-15"), Categoria.Autoayuda, Genero.autoayuda, Genero.liderazgo);
        Libro elPoderDelAhora = new Libro("El poder del ahora", 9788478085380, "Eckhart Tolle", "Grijalbo", parseFecha("1997-08-19"), Categoria.Autoayuda, Genero.autoayuda, Genero.espiritualidad);

        // Viajes
        Libro enElCamino = new Libro("En el camino", 9788433914545, "Jack Kerouac", "Anagrama", parseFecha("1957-09-05"), Categoria.Viajes, Genero.aventura, Genero.biografía);
        Libro aLaCazaDelCarneroSalvaje = new Libro("A la caza del carnero salvaje", 9788483835107, "Haruki Murakami", "Tusquets Editores", parseFecha("1982-04-30"), Categoria.Viajes, Genero.aventura, Genero.ficción);
        Libro intoThinAir = new Libro("De vuelta a lo alto", 9788484504662, "Jon Krakauer", "Paidós", parseFecha("1997-05-01"), Categoria.Viajes, Genero.aventura, Genero.biografía);
        Libro laOdisea = new Libro("La Odisea", 9788477028753, "Homero", "Alba Editorial", parseFecha("Siglo VIII a.C."), Categoria.Viajes, Genero.aventura, Genero.epopeya);

        // Ciencia
        Libro cosmos = new Libro("Cosmos", 9780345539434, "Carl Sagan", "Random House", parseFecha("1980-09-28"), Categoria.Ciencia, Genero.documental, Genero.astronomía);
        Libro elGenEgoista = new Libro("El gen egoísta", 9780199291151, "Richard Dawkins", "Oxford University Press", parseFecha("1976-01-01"), Categoria.Ciencia, Genero.divulgación_científica, Genero.biología);
        Libro elCuerpoHumano = new Libro("El libro del cuerpo humano", 9781405332941, "DK", "DK", parseFecha("2007-02-05"), Categoria.Ciencia, Genero.divulgación_científica, Genero.anatomía);
        Libro unaBreveHistoriaDelTiempo2 = new Libro("Una breve historia del tiempo", 9780553380163, "Stephen Hawking", "Bantam Books", parseFecha("1988-04-01"), Categoria.Ciencia, Genero.divulgación_científica, Genero.astronomía);

        // Deportes
        Libro moneyball = new Libro("Moneyball", 9780393057652, "Michael Lewis", "W. W. Norton & Company", parseFecha("2003-05-17"), Categoria.Deportes, Genero.deportes, Genero.biografía);
        Libro bornToRun = new Libro("Born to Run", 9780307279187, "Christopher McDougall", "Knopf", parseFecha("2009-05-05"), Categoria.Deportes, Genero.deportes, Genero.aventura);
        Libro open = new Libro("Open", 9780379182023, "Andre Agassi", "Knopf", parseFecha("2009-11-09"), Categoria.Deportes, Genero.deportes, Genero.biografía);
        Libro theBoysInTheBoat = new Libro("The Boys in the Boat", 9780670025817, "Daniel James Brown", "Viking Press", parseFecha("2013-06-04"), Categoria.Deportes, Genero.deportes, Genero.historia);
        Libro theMambaMentality = new Libro("The Mamba Mentality", 9780374201234, "Kobe Bryant", "MCD", parseFecha("2018-10-23"), Categoria.Deportes, Genero.deportes, Genero.biografía);


		//Añadimos los libros
        libros.add(cienAnosSoledad);
        libros.add(donQuijote);
        libros.add(rayuela);
        libros.add(crimenCastigo);

        libros.add(unaBreveHistoriaDelTiempo);
        libros.add(sapiens);
        libros.add(elPrincipe);
        libros.add(intoTheWild);

        libros.add(elArteDeAprender);
        libros.add(elPoderDelHabito);
        libros.add(pensarRapidoPensarDespacio);
        libros.add(elEfectoMariposa);

        libros.add(elCodigoDaVinci);
        libros.add(starryNight);
        libros.add(elGuernica);
        libros.add(elNombreDeLaRosa);

        libros.add(dondeVivenLosMonstruos);
        libros.add(elGatoEnElSombrero);
        libros.add(elPrincipito);
        libros.add(winnieThePooh);

        libros.add(pienseYHagaseRico);
        libros.add(elSecreto);
        libros.add(sieteHabitosDeLaGenteAltamenteEfectiva);
        libros.add(elPoderDelAhora);

        libros.add(enElCamino);
        libros.add(aLaCazaDelCarneroSalvaje);
        libros.add(intoThinAir);
        libros.add(laOdisea);

        libros.add(cosmos);
        libros.add(elGenEgoista);
        libros.add(elCuerpoHumano);
        libros.add(unaBreveHistoriaDelTiempo2);

        libros.add(moneyball);
        libros.add(bornToRun);
        libros.add(open);
        libros.add(theBoysInTheBoat);
        libros.add(theMambaMentality);

		

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
	private static java.sql.Date parseFecha(String fecha) throws ParseException {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    java.util.Date utilDate = dateFormat.parse(fecha);
	    return new java.sql.Date(utilDate.getTime());
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