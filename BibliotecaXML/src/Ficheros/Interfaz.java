package Ficheros;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Interfaz {

	static Biblioteca biblioteca = new Biblioteca();
	private static JFrame frame;
	private static JPanel panelPrincipal;
	private static GridBagConstraints constraints;
	private static Clip clip;
	private static JPanel panelMenu;
	private static JPanel panelLibros;
	private static JPanel panelOtros;
	private static JPanel panelActual;
	private static JPanel panelInicio;
	private static BufferedImage imagenFondo = null;
	private static Dimension dimensionFija = new Dimension(250, 80);
	private static JTextArea textArea;
	private static JScrollPane scrollPane;
	private static Font customFont;
	private static Font font;
	private static Font fontpequenia;
	private static JButton pausarMusica=new JButton("pausar música");
	private static String[] opcionesFiccion;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Interfaz window = new Interfaz();
					Interfaz.frame.setVisible(true);
					// Inicia un hilo para cargar la música en segundo plano
					Thread musicThread = new Thread(new Runnable() {
						@Override
						public void run() {
							reproducirMusica();
						}
					});
					musicThread.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Interfaz() {
		initialize();
	}
	public static void initialize() {
		frame = new JFrame("Bienvenido a la biblioteca");
		frame.setSize(1150, 750);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		panelInicio = new JPanel();
		panelPrincipal = new JPanel();
		panelMenu = new JPanel(new GridBagLayout());
		panelLibros = new JPanel(new GridBagLayout());
		panelOtros = new JPanel(new GridBagLayout());
		panelActual = new JPanel();
		reproducirMusica();
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("JosefinSans-Medium.ttf"));
			ge.registerFont(customFont);
			font = new Font(customFont.getFontName(), Font.PLAIN, 35);
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("JosefinSans-Medium.ttf"));
			ge.registerFont(customFont);
			fontpequenia = new Font(customFont.getFontName(), Font.PLAIN, 20);
		} catch (Exception e) {
			e.printStackTrace();
		}
		File archivo = new File("Biblioteca.xml");
		if (archivo.exists()) {
			biblioteca = Metodos.reutilizarXML();
		} else {
			biblioteca = Metodos.crearXML();
		}
		pausarMusica.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (clip != null) {
					if (clip.isRunning()) {
						clip.stop();
						pausarMusica.setText("Reanudar música");
					} else {
						clip.start();
						pausarMusica.setText("Pausar música");
					}
				}
			}
		});
		try {
			imagenFondo = ImageIO.read(new File("imagenes/biblioteca.jpg"));
			panelPrincipal = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
				}
			};
		} catch (IOException e) {
			e.printStackTrace();
			panelPrincipal = new JPanel();
		}
		construirPanelInicio();
		construirPanelMenu();
		construirPanelLibros();
		construirPanelOtros();
		panelActual=panelInicio;
		panelPrincipal.add(panelActual);
		panelPrincipal.revalidate();
		try {
			BufferedImage cursorImage = ImageIO.read(new File("imagenes/varita.png"));
			Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0), "CustomCursor");
			frame.setCursor(customCursor);
		} catch (IOException e) {
			e.printStackTrace();
		}
		frame.setLayout(new BorderLayout());
		frame.add(pausarMusica,BorderLayout.SOUTH);
		frame.add(panelPrincipal);
	}
	public static void construirPanelMenu() {
		GridBagConstraints constraints = new GridBagConstraints();
		JButton botonPeliculas = new JButton("Películas");
		JButton botonMostrarXML = new JButton("Mostrar xml");
		JButton botonOtrosDatos = new JButton("Otros Datos");
		JButton btnVolver = new JButton("Salir");
		botonPeliculas.setFont(font);
		botonMostrarXML.setFont(font);
		botonOtrosDatos.setFont(font);
		btnVolver.setFont(font);
		Color colorFijo = new Color(0, 80, 250);
		botonPeliculas.setBackground(colorFijo);
		botonMostrarXML.setBackground(colorFijo);
		botonOtrosDatos.setBackground(colorFijo);
		botonPeliculas.setForeground(Color.WHITE);
		botonMostrarXML.setForeground(Color.WHITE);
		botonOtrosDatos.setForeground(Color.WHITE);
		botonPeliculas.setFocusPainted(false);
		botonMostrarXML.setFocusPainted(false);
		botonOtrosDatos.setFocusPainted(false);
		botonPeliculas.setBorderPainted(false);
		botonMostrarXML.setBorderPainted(false);
		botonOtrosDatos.setBorderPainted(false);
		botonPeliculas.setOpaque(true);
		botonMostrarXML.setOpaque(true);
		botonOtrosDatos.setOpaque(true);
		botonPeliculas.setPreferredSize(dimensionFija);
		botonMostrarXML.setPreferredSize(dimensionFija);
		botonOtrosDatos.setPreferredSize(dimensionFija);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(20, 20, 20, 20);
		panelMenu.add(botonPeliculas, constraints);
		constraints.gridx = 1;
		constraints.gridy = 2;
		panelMenu.add(botonMostrarXML, constraints);
		constraints.gridx = 0;
		constraints.gridy = 2;
		panelMenu.add(botonOtrosDatos, constraints);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 3; // Ocupa 3 columnas
		constraints.insets = new Insets(20, 20, 20, 20);
		panelMenu.setOpaque(false);
		panelMenu.add(btnVolver, constraints);
		panelMenu.setOpaque(false);
		botonPeliculas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanelLibros();
			}
		});
		botonMostrarXML.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String mostrar = Metodos.leerXML("Biblioteca.xml");
				textArea = new JTextArea(20, 40); // Crear un JTextArea con 20 filas y 40 columnas
				textArea.setText(mostrar);
				scrollPane = new JScrollPane(textArea);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				JOptionPane.showMessageDialog(frame, scrollPane, "Colección", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		botonOtrosDatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanelOtros();
			}
		});
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanelInicio();
			}
		});
	}
	public static void construirPanelPeliculas() {
		constraints = new GridBagConstraints();
		JComboBox<String> desplegableFiccion = new JComboBox<>();
		JButton botonDesplegarFiccion;
		JButton btnVolverMenuPrincipal = new JButton("Volver al Menú");
		// Crear un ícono con la imagen escalada
		ImageIcon iconoFiccion = new ImageIcon("imagenes/marvel.png");
		Image imageFiccion = iconoFiccion.getImage();
		Image newImageFiccion = imageFiccion.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
		iconoFiccion = new ImageIcon(newImageFiccion);
		botonDesplegarFiccion = new JButton(iconoFiccion);
		botonDesplegarFiccion.setFont(font);
		botonDesplegarFiccion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int contador=0;
				for (Libro libro : biblioteca.getLibros()) {
	                if (libro.getCategoria().equals("ficcion")) {
	                		contador++;
	                }
	            }
				opcionesFiccion= new String[contador];
				int index = 0;
	            for (Libro libro : biblioteca.getLibros()) {
	                if (libro.getCategoria().equals("ficcion")) {
	                    opcionesFiccion[index++] = libro.getTitulo();
	                }
	            }
				desplegableFiccion.setModel(new DefaultComboBoxModel<>(opcionesFiccion));
				desplegableFiccion.showPopup();
			}
		});

		desplegableFiccion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String libroSeleccionado = (String) desplegableFiccion.getSelectedItem();
				String infoLibro = Metodos.obtenerInfoPorTitulo(biblioteca, libroSeleccionado);
				JOptionPane.showMessageDialog(frame, infoLibro, "Información del libro: " + libroSeleccionado, JOptionPane.INFORMATION_MESSAGE);
			}
		});

		desplegableFiccion.setFont(fontpequenia);

		((JLabel) desplegableFiccion.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		desplegableFiccion.setPreferredSize(dimensionFija);
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.insets = new Insets(20, 20, 20, 20);
		panelLibros.add(botonDesplegarFiccion, constraints);
//		constraints.gridx = 1;
//		panelLibros.add(botonDesplegarComics, constraints);
//		constraints.gridx = 2;
//		constraints.gridx = 0;
//		panelLibros.add(desplegableNovelas, constraints);
//		constraints.gridx = 1;
//		panelLibros.add(desplegableComics, constraints);
//		constraints.gridx = 2;
		btnVolverMenuPrincipal.setFont(font);
		btnVolverMenuPrincipal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanelMenu(); // Llama al método para cambiar al panel del menú principal
			}
		});
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 3; // Ocupa 3 columnas
		constraints.insets = new Insets(20, 20, 20, 20);
		panelLibros.setOpaque(false);
		panelLibros.add(btnVolverMenuPrincipal, constraints);
	}
	public static void construirPanelLibros() {
	    GridBagConstraints constraints = new GridBagConstraints();

	    // Crear botones con imágenes y desplegables para cada categoría
	    Categoria[] categorias = Categoria.values();
        for (int i = 0; i < categorias.length; i++) {
            JButton botonDesplegable = construirBotonDesplegable(categorias[i]);
            constraints.gridx = i % 3;
            constraints.gridy = i / 3;
            constraints.insets = new Insets(20, 20, 20, 20);
            panelLibros.add(botonDesplegable, constraints);
        }

	    // Agregar el botón para volver al menú principal
	    JButton btnVolverMenuPrincipal = new JButton("Volver al Menú");
	    btnVolverMenuPrincipal.setFont(font);
	    btnVolverMenuPrincipal.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            cambiarPanelMenu(); // Llama al método para cambiar al panel del menú principal
	        }
	    });
	    constraints.gridx = 0;
	    constraints.gridy = categorias.length / 3; // Colocar el botón de volver en la siguiente fila
	    constraints.gridwidth = 3; // Ocupa 3 columnas
	    constraints.insets = new Insets(20, 20, 20, 20);
	    panelLibros.setOpaque(false);
	    panelLibros.add(btnVolverMenuPrincipal, constraints);
	}

	// Método para construir un botón con imagen y desplegable para una categoría
	private static JButton construirBotonDesplegable(Categoria categoria) {
	    GridBagConstraints constraints = new GridBagConstraints();
	    JButton botonDesplegar = new JButton();
	    // Lógica para cargar la imagen según la categoría (puedes personalizar esta parte)
	    String rutaImagen = "imagenes/" + categoria.toString().toLowerCase() + ".png";
	    ImageIcon icono = new ImageIcon(rutaImagen);
	    Image image = icono.getImage();
	    Image newImage = image.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
	    icono = new ImageIcon(newImage);
	    botonDesplegar.setIcon(icono);
	    botonDesplegar.setPreferredSize(new Dimension(dimensionFija.width, dimensionFija.height));
	    botonDesplegar.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Lógica para mostrar el desplegable según la categoría
	            mostrarDesplegable(categoria);
	        }
	    });

	    return botonDesplegar;
	}

	// Método para mostrar el desplegable con los títulos de libros de una categoría específica
	private static void mostrarDesplegable(Categoria categoria) {
	    JComboBox<String> desplegable = new JComboBox<>();
	    int contador = 0;

	    // Contar la cantidad de libros en la categoría
	    for (Libro libro : biblioteca.getLibros()) {
	        if (libro.getCategoria().equals(categoria)) {
	            contador++;
	        }
	    }

	    // Crear un array con los títulos de los libros en la categoría
	    String[] opcionesCategoria = new String[contador];
	    int index = 0;
	    for (Libro libro : biblioteca.getLibros()) {
	        if (libro.getCategoria().equals(categoria)) {
	            opcionesCategoria[index++] = libro.getTitulo();
	        }
	    }

	    // Configurar el desplegable con los títulos
	    desplegable.setModel(new DefaultComboBoxModel<>(opcionesCategoria));


	    // Mostrar el desplegable en un cuadro de diálogo
	    JOptionPane.showMessageDialog(frame, desplegable, "Libros de " + categoria, JOptionPane.PLAIN_MESSAGE);
	}

	public static void cargarImagenFondo(String nombreImagen) {
		try {
			imagenFondo = ImageIO.read(new File("imagenes/" + nombreImagen));
			panelPrincipal.repaint(); //Vuelve a pintar el panel para mostrar la nueva imagen de fondo
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	public static void construirPanelInicio() {
		frame.getContentPane().add(panelInicio, BorderLayout.CENTER);
		JButton btnInicio = new JButton("Bienvenido");
		btnInicio.setFont(font);
		btnInicio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanelMenu();
			}
		});
		panelInicio.add(btnInicio);
		panelInicio.setOpaque(false);
	}

	public static void construirPanelOtros() {
		frame.getContentPane().add(panelOtros, BorderLayout.CENTER);
		GridBagConstraints constraints = new GridBagConstraints();
		JButton btnModificarTitulo = new JButton("Modificar Título");
		JButton btnAgregarPelicula = new JButton("Agregar Película");
		JButton btnEliminarContenido = new JButton("Eliminar Contenido");
		JButton btnVolverMenuPrincipalOtros = new JButton("Volver al Menú");
		btnModificarTitulo.setFont(font);
		btnAgregarPelicula.setFont(font);
		btnEliminarContenido.setFont(font);
		Color colorFijo = new Color(0, 80, 250);
		btnModificarTitulo.setBackground(colorFijo);
		btnAgregarPelicula.setBackground(colorFijo);
		btnEliminarContenido.setBackground(colorFijo);
		btnModificarTitulo.setForeground(Color.WHITE);
		btnAgregarPelicula.setForeground(Color.WHITE);
		btnEliminarContenido.setForeground(Color.WHITE);
		btnModificarTitulo.setFocusPainted(false);
		btnAgregarPelicula.setFocusPainted(false);
		btnEliminarContenido.setFocusPainted(false);
		btnModificarTitulo.setBorderPainted(false);
		btnAgregarPelicula.setBorderPainted(false);
		btnEliminarContenido.setBorderPainted(false);
		btnModificarTitulo.setOpaque(true);
		btnAgregarPelicula.setOpaque(true);
		btnEliminarContenido.setOpaque(true);
		btnModificarTitulo.setPreferredSize(dimensionFija);
		btnAgregarPelicula.setPreferredSize(dimensionFija);
		btnEliminarContenido.setPreferredSize(dimensionFija);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(20, 20, 20, 20);
		panelOtros.add(btnAgregarPelicula, constraints);
		constraints.gridx = 0;
		constraints.gridy = 2;
		panelOtros.add(btnModificarTitulo, constraints);
		constraints.gridx = 1;
		constraints.gridy = 2;
		panelOtros.add(btnEliminarContenido, constraints);
		btnModificarTitulo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.modificarTitulo(biblioteca);
			}
		});
		btnAgregarPelicula.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.agregarLibro(biblioteca);
			}
		});
		btnEliminarContenido.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.eliminarPorCodigo(biblioteca);
			}
		});
		btnVolverMenuPrincipalOtros.setFont(font);
		btnVolverMenuPrincipalOtros.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanelMenu();
			}
		});
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 3; // Ocupa 3 columnas
		constraints.insets = new Insets(20, 20, 20, 20);
		panelOtros.setOpaque(false);
		panelOtros.add(btnVolverMenuPrincipalOtros, constraints);
	}
	public static void cambiarPanelInicio() {
		panelPrincipal.remove(panelActual); // Eliminar el panel actual
		panelActual = panelInicio; // Asignar el nuevo panel
		panelPrincipal.add(panelActual); // Agregar el nuevo panel
		panelPrincipal.revalidate();
		frame.repaint();// Actualizar la interfaz
	}
	public static void cambiarPanelOtros() {
		panelPrincipal.remove(panelActual); // Eliminar el panel actual
		panelActual = panelOtros; // Asignar el nuevo panel
		panelPrincipal.add(panelActual); // Agregar el nuevo panel
		panelPrincipal.revalidate();
		frame.repaint();// Actualizar la interfaz
	}
	public static void cambiarPanelLibros() {
		panelPrincipal.remove(panelActual); // Eliminar el panel actual
		panelActual = panelLibros; // Asignar el nuevo panel
		panelPrincipal.add(panelActual); // Agregar el nuevo panel
		panelPrincipal.revalidate();
		frame.repaint();// Actualizar la interfaz
	}

	public static void cambiarPanelMenu() {
		panelPrincipal.remove(panelActual); // Eliminar el panel actual
		panelActual = panelMenu; // Asignar el nuevo panel
		panelPrincipal.add(panelActual); // Agregar el nuevo panel
		panelPrincipal.revalidate();
		cargarImagenFondo("biblioteca.jpg");
		frame.repaint();// Actualizar la interfaz
	}
	public static void reproducirMusica() {
		try {
			String rutaMusica = "audio/kingdomhearts.wav";
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(rutaMusica));
			if (clip != null) {
				clip.stop(); // La musica actual se detiene si se está reproduciendo otra
				clip.close(); // Cerramos el clip actual
			}
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			float attenuation = -20.0f;
			gainControl.setValue(attenuation);
			clip.start(); // Reproducimos la música
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}