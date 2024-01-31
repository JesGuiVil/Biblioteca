package Ficheros;

import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Metodos {


	public static Biblioteca crearXML() {


		//Creamos las listas para agregar las peliculas
		List<Libro> libros = new ArrayList<>();

		// Ficción
		Libro cienAnosSoledad = new Libro("Cien años de soledad", 958276674747L, "Gabriel García Márquez", "Sudamericana", "30-05-1967", Categoria.Ficción, Genero.drama);
		Libro donQuijote = new Libro("Don Quijote de la Mancha", 9788420412146L, "Miguel de Cervantes", "Publicación Original", "16-01-1605", Categoria.Ficción, Genero.comedia);
		Libro rayuela = new Libro("Rayuela", 9788437604947L, "Julio Cortázar", "Siglo XXI Editores", "28-06-1963", Categoria.Ficción, Genero.suspense);
		Libro crimenCastigo = new Libro("Crimen y castigo", 9788437602172L, "Fiodor Dostoievski", "Siglo XXI Editores", "22-12-1866", Categoria.Ficción, Genero.drama);

		// No ficción
		Libro unaBreveHistoriaDelTiempo = new Libro("Una breve historia del tiempo", 9780553380163L, "Stephen Hawking", "Bantam Books", "01-04-1988", Categoria.No_ficción, Genero.documental);
		Libro sapiens = new Libro("Sapiens: De animales a dioses", 9788499924216L, "Yuval Noah Harari", "Debate", "14-06-2011", Categoria.No_ficción, Genero.documental);
		Libro elPrincipe = new Libro("El príncipe", 9788484284232L, "Niccolò Machiavelli", "Clásicos Inolvidables", "01-01-1532", Categoria.No_ficción, Genero.política);
		Libro intoTheWild = new Libro("Hacia rutas salvajes", 9788433901900L, "Jon Krakauer", "Anagrama", "01-01-1996", Categoria.No_ficción, Genero.biografía);

		// Didácticos
		Libro elArteDeAprender = new Libro("El arte de aprender", 9788495787555L, "Josh Waitzkin", "Empresa Activa", "25-05-2007", Categoria.Didácticos, Genero.educación);
		Libro elPoderDelHabito = new Libro("El poder del hábito", 9788499982582L, "Charles Duhigg", "DeBolsillo", "06-03-2012", Categoria.Didácticos, Genero.psicología);
		Libro pensarRapidoPensarDespacio = new Libro("Pensar rápido, pensar despacio", 9788498921808L, "Daniel Kahneman", "DeBolsillo", "17-11-2011", Categoria.Didácticos, Genero.psicología);
		Libro elEfectoMariposa = new Libro("El efecto mariposa", 9788498011901L, "James Gleick", "Crítica", "01-01-1987", Categoria.Didácticos, Genero.matemáticas);

		// Arte
		Libro elCodigoDaVinci = new Libro("El código Da Vinci", 9788466637951L, "Dan Brown", "Ediciones B", "17-03-2003", Categoria.Arte, Genero.misterio);
		Libro starryNight = new Libro("La noche estrellada", 9788432092894L, "Vincent van Gogh", "Espasa", "01-01-1889", Categoria.Arte, Genero.pintura);
		Libro elGuernica = new Libro("Guernica", 9788484801600L, "Pablo Picasso", "Alianza Editorial", "01-01-1937", Categoria.Arte, Genero.pintura);
		Libro elNombreDeLaRosa = new Libro("El nombre de la rosa", 9788426411655L, "Umberto Eco", "Lumen", "16-10-1980", Categoria.Arte, Genero.misterio);

		// Infantiles
		Libro dondeVivenLosMonstruos = new Libro("Donde viven los monstruos", 9788493464417L, "Maurice Sendak", "Kalandraka", "17-09-1963", Categoria.Infantiles, Genero.fantasía);
		Libro elGatoEnElSombrero = new Libro("El gato en el sombrero", 9788448816555L, "Dr. Seuss", "Beascoa", "12-03-1957", Categoria.Infantiles, Genero.humor);
		Libro elPrincipito = new Libro("El principito", 9788426134623L, "Antoine de Saint-Exupéry", "Juventud", "06-04-1943", Categoria.Infantiles, Genero.filosofía);
		Libro winnieThePooh = new Libro("Winnie the Pooh", 9780142419407L, "A.A. Milne", "Puffin Books", "14-10-1926", Categoria.Infantiles, Genero.humor);

		// Autoayuda
		Libro pienseYHagaseRico = new Libro("Piense y hágase rico", 9781619491875L, "Napoleon Hill", "Seedbox Press", "03-03-1937", Categoria.Autoayuda, Genero.éxito_personal);
		Libro elSecreto = new Libro("El secreto", 9781582701707L, "Rhonda Byrne", "Atria Books", "26-11-2006", Categoria.Autoayuda, Genero.ley_de_atracción);
		Libro sieteHabitosDeLaGenteAltamenteEfectiva = new Libro("Los 7 hábitos de la gente altamente efectiva", 9788449318016L, "Stephen R. Covey", "Paidós", "15-08-1989", Categoria.Autoayuda, Genero.liderazgo);
		Libro elPoderDelAhora = new Libro("El poder del ahora", 9788478085380L, "Eckhart Tolle", "Grijalbo", "19-08-1997", Categoria.Autoayuda, Genero.espiritualidad);

		// Viajes
		Libro enElCamino = new Libro("En el camino", 9788433914545L, "Jack Kerouac", "Anagrama", "05-09-1957", Categoria.Viajes, Genero.aventura);
		Libro aLaCazaDelCarneroSalvaje = new Libro("A la caza del carnero salvaje", 9788483835107L, "Haruki Murakami", "Tusquets Editores", "30-04-1982", Categoria.Viajes, Genero.aventura);
		Libro intoThinAir = new Libro("De vuelta a lo alto", 9788484504662L, "Jon Krakauer", "Paidós", "01-05-1997", Categoria.Viajes, Genero.biografía);
		Libro laOdisea = new Libro("La Odisea", 9788477028753L, "Homero", "Alba Editorial", "01-01-800", Categoria.Viajes, Genero.aventura);

		// Ciencia
		Libro cosmos = new Libro("Cosmos", 9780345539434L, "Carl Sagan", "Random House", "28-09-1980", Categoria.Ciencia, Genero.documental);
		Libro elGenEgoista = new Libro("El gen egoísta", 9780199291151L, "Richard Dawkins", "Oxford University Press", "01-01-1976", Categoria.Ciencia, Genero.biología);
		Libro elCuerpoHumano = new Libro("El libro del cuerpo humano", 9781405332941L, "DK", "DK", "05-02-2007", Categoria.Ciencia, Genero.anatomía);
		Libro unaBreveHistoriaDelTiempo2 = new Libro("Una breve historia del tiempo", 9780553380163L, "Stephen Hawking", "Bantam Books", "01-04-1988", Categoria.Ciencia, Genero.astronomía);

		// Deportes
		Libro moneyball = new Libro("Moneyball", 9780393057652L, "Michael Lewis", "W. W. Norton & Company", "17-05-2003", Categoria.Deportes, Genero.biografía);
		Libro bornToRun = new Libro("Born to Run", 9780307279187L, "Christopher McDougall", "Knopf", "05-05-2009", Categoria.Deportes, Genero.aventura);
		Libro open = new Libro("Open", 9780379182023L, "Andre Agassi", "Knopf", "09-11-2009", Categoria.Deportes, Genero.biografía);
		Libro theBoysInTheBoat = new Libro("The Boys in the Boat", 9780670025817L, "Daniel James Brown", "Viking Press", "04-06-2013", Categoria.Deportes, Genero.historia);
		Libro theMambaMentality = new Libro("The Mamba Mentality", 9780374201234L, "Kobe Bryant", "MCD", "23-10-2018", Categoria.Deportes, Genero.biografía);





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

	public String leerXML(String rutaArchivoXML) {
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

	public void modificarLibro(Biblioteca biblioteca) {
		try {
			// Preguntar si se quiere seleccionar por título o ISBN
			String[] opcionesSeleccion = {"Título", "ISBN"};
			JComboBox<String> seleccionBox = new JComboBox<>(opcionesSeleccion);
			int seleccion = JOptionPane.showOptionDialog(
					null,
					"Seleccionar libro por:",
					"Modificar Libro",
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					opcionesSeleccion,
					opcionesSeleccion[0]);

			// Obtener valor de búsqueda (título o ISBN)
			String valorBusqueda = "";
			if (seleccion == 0) {
				valorBusqueda = JOptionPane.showInputDialog("Introduce el título del libro:");
			} else if (seleccion == 1) {
				String isbnStr = JOptionPane.showInputDialog("Introduce el ISBN del libro:");
				if (isbnStr == null) return;
				valorBusqueda = isbnStr;
			} else {
				return; // Usuario canceló
			}

			// Buscar el libro
			Libro libroSeleccionado = null;
			for (Libro libro : biblioteca.getLibros()) {
				if ((seleccion == 0 && libro.getTitulo().equalsIgnoreCase(valorBusqueda)) ||
						(seleccion == 1 && Long.toString(libro.getIsbn()).equals(valorBusqueda))) {
					libroSeleccionado = libro;
					break;
				}
			}

			if (libroSeleccionado != null) {
				// Mostrar lista de atributos para seleccionar
				String[] opcionesAtributos = {"Título", "ISBN", "Autor", "Editorial", "Fecha", "Categoría", "Género 1", "Género 2"};
				JComboBox<String> atributoBox = new JComboBox<>(opcionesAtributos);
				int atributoSeleccionado = JOptionPane.showOptionDialog(
						null,
						"Seleccionar campo a modificar:",
						"Modificar Libro",
						JOptionPane.DEFAULT_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						opcionesAtributos,
						opcionesAtributos[0]);

				// Obtener nuevo valor
				String nuevoValor = JOptionPane.showInputDialog("Introduce el nuevo valor para " + opcionesAtributos[atributoSeleccionado] + ":");

				// Actualizar el atributo seleccionado
				switch (atributoSeleccionado) {
				case 0:
					libroSeleccionado.setTitulo(nuevoValor);
					break;
				case 1:
					libroSeleccionado.setIsbn(Long.parseLong(nuevoValor));
					break;
				case 2:
					libroSeleccionado.setAutor(nuevoValor);
					break;
				case 3:
					libroSeleccionado.setEditorial(nuevoValor);
					break;
				case 4:
					libroSeleccionado.setFecha(nuevoValor);
					break;
				case 5:
					Categoria nuevaCategoria = (Categoria) JOptionPane.showInputDialog(
							null,
							"Seleccione la nueva categoría:",
							"Modificar Libro",
							JOptionPane.QUESTION_MESSAGE,
							null,
							Categoria.values(),
							libroSeleccionado.getCategoria());
					if (nuevaCategoria != null) {
						libroSeleccionado.setCategoria(nuevaCategoria);
					}
					break;
				case 6:
					Genero nuevoGenero = (Genero) JOptionPane.showInputDialog(
							null,
							"Seleccione el nuevo género:",
							"Modificar Libro",
							JOptionPane.QUESTION_MESSAGE,
							null,
							Genero.values(),
							libroSeleccionado.getGenero());
					if (nuevoGenero != null) {
						libroSeleccionado.setGenero(nuevoGenero);
					}
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opción no válida");
					break;
				}

				JOptionPane.showMessageDialog(null, "Libro modificado exitosamente");

			} else {
				JOptionPane.showMessageDialog(null, "No se encontró ningún libro con el título o ISBN proporcionado");
			}
			try {
				JAXBContext context = JAXBContext.newInstance(Biblioteca.class);
				Marshaller marshaller = context.createMarshaller();

				marshaller.marshal(biblioteca, new File("Biblioteca.xml"));

				System.out.println("Archivo actualizado");
			} catch (JAXBException e) {
				e.printStackTrace();
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error en la conversión de datos. Asegúrate de ingresar números válidos.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado. Verifica los datos ingresados.");
		}
	}


	public void agregarLibro(Biblioteca biblioteca) {
		try {
			String titulo = JOptionPane.showInputDialog("Introduce el título del libro:");
			if (titulo == null) return;

			String isbnStr = JOptionPane.showInputDialog("Introduce el ISBN del libro:");
			if (isbnStr == null) return;
			long isbn = Long.parseLong(isbnStr);

			String autor = JOptionPane.showInputDialog("Introduce el autor:");
			if (autor == null) return;

			String editorial = JOptionPane.showInputDialog("Introduce la editorial:");
			if (editorial == null) return;

			String fecha = JOptionPane.showInputDialog("Introduce la fecha en formato dd-mm-aaaa:");
			if (fecha == null) return;


			Categoria categoria = (Categoria) JOptionPane.showInputDialog(null, "Introduce la categoría:", "Categoría",
					JOptionPane.QUESTION_MESSAGE, null,
					Categoria.values(), Categoria.values()[0]);
			if (categoria == null) return;

			Genero genero = (Genero) JOptionPane.showInputDialog(null, "Introduce el género:", "género",
					JOptionPane.QUESTION_MESSAGE, null,
					Genero.values(), Genero.values()[0]);
			if (genero == null) return;

			Libro nuevoLibro = new Libro(titulo, isbn, autor, editorial, fecha, categoria, genero);
			biblioteca.getLibros().add(nuevoLibro);

			JOptionPane.showMessageDialog(null, "Libro agregado a la biblioteca");

			try {
				JAXBContext context = JAXBContext.newInstance(Biblioteca.class);
				Marshaller marshaller = context.createMarshaller();

				marshaller.marshal(biblioteca, new File("Biblioteca.xml"));

				System.out.println("Archivo actualizado");
			} catch (JAXBException e) {
				e.printStackTrace();
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error en la conversión de datos. Asegúrate de ingresar números válidos.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado. Verifica los datos ingresados.");
		}
	}


	public void eliminarPorCodigo(Biblioteca biblioteca) {
		String[] opciones = {"Buscar por ISBN", "Buscar por título"};
		int opcionSeleccionada = JOptionPane.showOptionDialog(null, "¿Cómo deseas buscar el libro que deseas eliminar?",
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
				long isbn = Long.parseLong(codigoString);
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
			// Buscar en las listas de libros
			for (Libro libro : biblioteca.getLibros()) {
				if (libro.getTitulo().equalsIgnoreCase(titulo)) {
					info.append("Título: ").append(libro.getTitulo()).append("\n");
					info.append("ISBN: ").append(libro.getIsbn()).append("\n");
					info.append("Autor: ").append(libro.getAutor()).append("\n");
					info.append("Editorial: ").append(libro.getEditorial()).append("\n");
					info.append("Fecha: ").append(libro.getFecha()).append("\n");
					info.append("Categoría: ").append(libro.getCategoria()).append("\n");
					info.append("Género: ").append(libro.getGenero()).append("\n");
					return info.toString();
				}
			}
		} catch (Exception e) {
			return "Ocurrió un error al buscar la información";
		}
		return "No se encontró ningún libro con el título: " + titulo;
	}
	protected void realizarConsultaXPath(Component componente) {
		// Aquí puedes implementar la lógica para la consulta XPath
		String xpathQuery = JOptionPane.showInputDialog("Introduce la consulta XPath:");

		if (xpathQuery != null && !xpathQuery.isEmpty()) {
			// Realizar la consulta XPath directamente sobre el archivo XML
			Object resultado = ejecutarConsultaXPath(xpathQuery);

			// Mostrar el resultado en un JDialog
			mostrarResultadoEnDialogo(componente,resultado);
		} else {
			// Manejar el caso en el que no se proporciona una consulta XPath
			JOptionPane.showMessageDialog(componente, "Consulta XPath vacía o cancelada", "Aviso", JOptionPane.WARNING_MESSAGE);
		}
	}

	private Object ejecutarConsultaXPath(String xpathQuery) {
		try {
			// Configurar el evaluador XPath
			XPathFactory xPathfactory = XPathFactory.newInstance();
			XPath xpath = xPathfactory.newXPath();

			// Crear un lector para el archivo XML
			InputSource inputSource = new InputSource("Biblioteca.xml");

			// Evaluar la consulta XPath
			XPathExpression expression = xpath.compile(xpathQuery);
			Object resultado = expression.evaluate(inputSource, XPathConstants.NODESET);

			return resultado;
		} catch (XPathExpressionException e) {
			return "Error al ejecutar la consulta XPath: " + e.getMessage();
		}
	}

	private static void mostrarResultadoEnDialogo(Component componente, Object resultado) {
		JTextArea textArea;

		if (resultado instanceof NodeList) {
			// Si el resultado es una NodeList, trata cada nodo por separado
			NodeList nodeList = (NodeList) resultado;
			StringBuilder resultadoText = new StringBuilder();

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);

				// Procesa el nodo y sus hijos recursivamente
				procesarNodo(resultadoText, node);

				resultadoText.append("\n");
			}

			textArea = new NoWrapTextArea(eliminarEspaciosIzquierda(resultadoText.toString()));
		} else if (resultado instanceof Node) {
			// Si el resultado es un solo nodo, obtén su contenido y muestra cada dato en una línea
			Node node = (Node) resultado;
			StringBuilder resultadoText = new StringBuilder();

			// Procesa el nodo y sus hijos recursivamente
			procesarNodo(resultadoText, node);

			resultadoText.append("\n");

			textArea = new NoWrapTextArea(eliminarEspaciosIzquierda(resultadoText.toString()));
		} else {
			// En otros casos, simplemente muestra el resultado como cadena
			textArea = new NoWrapTextArea(eliminarEspaciosIzquierda(resultado.toString()));
		}

		textArea.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(500, 300));

		JOptionPane.showMessageDialog(componente, scrollPane, "Resultado de la consulta XPath", JOptionPane.INFORMATION_MESSAGE);
	}
	private static void procesarNodo(StringBuilder resultadoText, Node node) {
		// Ignora los nodos de texto
		if (node.getNodeType() == Node.TEXT_NODE) {
			return;
		}

		// Agrega el nombre del nodo y su valor (si es un elemento)
		resultadoText.append(node.getNodeName()).append(": ").append(obtenerTextoNodo(node, node.getNodeName())).append("\n");

		// Procesa los atributos del nodo
		if (node.hasAttributes()) {
			NamedNodeMap attributes = node.getAttributes();
			for (int j = 0; j < attributes.getLength(); j++) {
				Node attribute = attributes.item(j);
				resultadoText.append("  @").append(attribute.getNodeName()).append(": ").append(attribute.getNodeValue()).append("\n");
			}
		}

		// Procesa los hijos recursivamente
		NodeList children = node.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			procesarNodo(resultadoText, children.item(i));
		}
	}
	private static String obtenerTextoNodo(Node node, String nodeName) {
		NodeList childNodes = node.getChildNodes();

		for (int j = 0; j < childNodes.getLength(); j++) {
			Node childNode = childNodes.item(j);

			// Considerar solo nodos de texto y aquellos con el nombre proporcionado
			if ((childNode.getNodeType() == Node.TEXT_NODE || childNode.getNodeType() == Node.CDATA_SECTION_NODE)
					&& childNode.getParentNode().getNodeName().equalsIgnoreCase(nodeName)) {
				return childNode.getNodeValue().trim();
			}
		}

		// Llamada recursiva para nodos hijos
		for (int j = 0; j < childNodes.getLength(); j++) {
			Node childNode = childNodes.item(j);
			String texto = obtenerTextoNodo(childNode, nodeName);
			if (!texto.isEmpty()) {
				return texto;
			}
		}

		return "";
	}

	private static String eliminarEspaciosIzquierda(String input) {
		StringBuilder result = new StringBuilder();
		String[] lines = input.split("\n");

		for (String line : lines) {
			result.append(line.replaceFirst("^\\s+", "")).append("\n");
		}

		return result.toString();
	}

}