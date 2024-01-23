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
import javax.swing.SwingConstants;

public class InterfazDisney {

    // ATRIBUTOS
    static Disney disney = new Disney();
    private static JFrame frame;
    private static JPanel panelPrincipal;
    private static GridBagConstraints constraints;
    private static JPanel panelMenu;
    private static JPanel panelPeliculas;
    private static JPanel panelSeries;
    private static JPanel panelOtros;
    private static JPanel panelActual;
    private static BufferedImage imagenFondo = null;
    private static Dimension dimensionFija = new Dimension(200, 80);
    private static JTextArea textArea;
    private static JScrollPane scrollPane;
    private static Font customFont;
    private static Font fontDisney;
    private static Font fontDisneyChiquitita;
    private static JButton botonPeliculas;
    private static JButton botonSeries;
    private static JButton botonMostrarXML;
    private static JButton botonOtrosDatos;

    // Opciones de los desplegables
    private static String[] opcionesPeliculasMarvel = {"Iron Man", "Deadpool"};
    private static String[] opcionesPeliculasPixar = {"Toy Story", "Cars"};
    private static String[] opcionesSeriesMarvel = {"Loki", "Daredevil"};
    private static String[] opcionesSeriesPixar = {"Monstruos a la obra", "Dug y Carl"};
    // JComboBox para las películas
    // JComboBox para las series
    // Añadimos un boton que nos permita volver al inicio del programa
    private static JButton btnVolver = new JButton("volver al inicio");

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfazDisney window = new InterfazDisney();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InterfazDisney() {
        initialize();
    }

    public static void initialize() {
        frame = new JFrame("Bienvenido a Disney");
        frame.setSize(1150, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        panelPrincipal = new JPanel();
        panelMenu = new JPanel(new GridBagLayout());
        panelPeliculas = new JPanel(new GridBagLayout());
        panelSeries = new JPanel(new GridBagLayout());
        panelOtros = new JPanel(new GridBagLayout());
        panelActual = new JPanel();
        
		// Cargamos la fuente personalizada
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("waltograph42.otf"));
			ge.registerFont(customFont);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//Personalizamos las fuentes del programa
		fontDisney = new Font(customFont.getFontName(), Font.PLAIN, 35);
		fontDisneyChiquitita = new Font(customFont.getFontName(), Font.PLAIN, 20);

		File archivo = new File("Disney.xml");

		if (archivo.exists()) {
			disney = Metodos.reutilizarXML();
		} else {
			disney = Metodos.crearXML();
		}
	
		try {
			imagenFondo = ImageIO.read(new File("imagenes/portadaMM.jpg"));
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
		construirPanelMenu();
        construirPanelPeliculas();
        construirPanelSeries();
        construirPanelOtros();
        panelActual = panelMenu;
		panelPrincipal.add(panelMenu);


		try {
			BufferedImage cursorImage = ImageIO.read(new File("imagenes/varita.png"));
			Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0), "CustomCursor");
			frame.setCursor(customCursor);
		} catch (IOException e) {
			e.printStackTrace();
		}

		frame.setLayout(new BorderLayout());
        frame.add(panelPrincipal);
	}


	public static void construirPanelMenu() {
		GridBagConstraints constraints = new GridBagConstraints();

		botonPeliculas = new JButton("Películas");
		botonSeries = new JButton("Series");
		botonMostrarXML = new JButton("Mostrar xml");
		botonOtrosDatos = new JButton("Otros Datos");

		botonPeliculas.setFont(fontDisney);
		botonSeries.setFont(fontDisney);
		botonMostrarXML.setFont(fontDisney);
		botonOtrosDatos.setFont(fontDisney);

		Color colorFijo = new Color(0, 80, 250);
		botonPeliculas.setBackground(colorFijo);
		botonSeries.setBackground(colorFijo);
		botonMostrarXML.setBackground(colorFijo);
		botonOtrosDatos.setBackground(colorFijo);

		botonPeliculas.setForeground(Color.WHITE);
		botonSeries.setForeground(Color.WHITE);
		botonMostrarXML.setForeground(Color.WHITE);
		botonOtrosDatos.setForeground(Color.WHITE);

		botonPeliculas.setFocusPainted(false);
		botonSeries.setFocusPainted(false);
		botonMostrarXML.setFocusPainted(false);
		botonOtrosDatos.setFocusPainted(false);

		botonPeliculas.setBorderPainted(false);
		botonSeries.setBorderPainted(false);
		botonMostrarXML.setBorderPainted(false);
		botonOtrosDatos.setBorderPainted(false);

		botonPeliculas.setOpaque(true);
		botonSeries.setOpaque(true);
		botonMostrarXML.setOpaque(true);
		botonOtrosDatos.setOpaque(true);

		botonPeliculas.setPreferredSize(dimensionFija);
		botonSeries.setPreferredSize(dimensionFija);
		botonMostrarXML.setPreferredSize(dimensionFija);
		botonOtrosDatos.setPreferredSize(dimensionFija);

		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(20, 20, 20, 20);
		panelMenu.add(botonPeliculas, constraints);

		constraints.gridx = 1;
		panelMenu.add(botonSeries, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		panelMenu.add(botonMostrarXML, constraints);

		constraints.gridx = 1;
		panelMenu.add(botonOtrosDatos, constraints);

		panelMenu.setOpaque(false);

		botonPeliculas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanelPeliculas();
			}
		});
		
		botonSeries.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanelSeries();
		
			}
		});

		botonMostrarXML.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String mostrar = Metodos.leerXML("Disney.xml");
				textArea = new JTextArea(20, 40); // Crear un JTextArea con 20 filas y 40 columnas
				textArea.setText(mostrar);

				scrollPane = new JScrollPane(textArea);
				scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

				JOptionPane.showMessageDialog(frame, scrollPane, "DISNEY", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		botonOtrosDatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanelOtros();
			}
		});

		panelPrincipal.add(panelMenu);
		panelPrincipal.revalidate();
	}

	public static void construirPanelPeliculas() {
		GridBagConstraints constraints = new GridBagConstraints();
	    JComboBox<String> desplegableMarvel = new JComboBox<>();
	    JComboBox<String> desplegablePixar = new JComboBox<>();
	    JButton botonDesplegarMarvel;
	    JButton botonDesplegarPixar;
	    JButton btnVolverMenuPrincipal = new JButton("Volver al Menú");
		// Crear un ícono con la imagen escalada
		ImageIcon iconoMarvel = new ImageIcon("imagenes/marvel.png");
		Image imageMarvel = iconoMarvel.getImage();
		Image newImageMarvel = imageMarvel.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
		iconoMarvel = new ImageIcon(newImageMarvel);
		botonDesplegarMarvel = new JButton(iconoMarvel);

		ImageIcon iconoPixar = new ImageIcon("imagenes/pixar.jpg");
		Image imagePixar = iconoPixar.getImage();
		Image newImagePixar = imagePixar.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
		iconoPixar = new ImageIcon(newImagePixar);
		botonDesplegarPixar = new JButton(iconoPixar);
	    
		botonDesplegarMarvel.setFont(fontDisney);
		botonDesplegarMarvel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				opcionesPeliculasMarvel= new String[disney.getPeliculas().getPeliculasMarvel().size()];
				for (int i=0;i<disney.getPeliculas().getPeliculasMarvel().size();i++){
					opcionesPeliculasMarvel[i]=disney.getPeliculas().getPeliculasMarvel().get(i).getTitulo();
				}
				desplegableMarvel.setModel(new DefaultComboBoxModel<>(opcionesPeliculasMarvel));
				desplegableMarvel.showPopup();
			}
		});
		botonDesplegarPixar.setFont(fontDisney);
		botonDesplegarPixar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				opcionesPeliculasPixar= new String[disney.getPeliculas().getPeliculasPixar().size()];
				for (int i=0;i<disney.getPeliculas().getPeliculasPixar().size();i++){
					opcionesPeliculasPixar[i]=disney.getPeliculas().getPeliculasPixar().get(i).getTitulo();
				}				
				desplegablePixar.setModel(new DefaultComboBoxModel<>(opcionesPeliculasPixar));
				desplegablePixar.showPopup();
			}
		});

		desplegableMarvel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String peliculaSeleccionada = (String) desplegableMarvel.getSelectedItem();

				// Obtenemos la información de la película
				String infoPelicula = Metodos.obtenerInfoPorTitulo(disney, peliculaSeleccionada);

				// Cambiamos la imagen de fondo
				if (peliculaSeleccionada.equalsIgnoreCase("Iron Man")) cargarImagenFondo("ironman.jpg");
				else if (peliculaSeleccionada.equalsIgnoreCase("DeadPool")) cargarImagenFondo("deadpool.jpg");

				// Mostramos la información en un diálogo de mensaje (JOptionPane)
				JOptionPane.showMessageDialog(frame, infoPelicula, "Información de la Película: " + peliculaSeleccionada, JOptionPane.INFORMATION_MESSAGE);
			}
		});

		desplegablePixar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String peliculaSeleccionada = (String) desplegablePixar.getSelectedItem();

				// Obtenemos la información de la película
				String infoPelicula = Metodos.obtenerInfoPorTitulo(disney, peliculaSeleccionada);


				// Cambiamos la imagen de fondo
				if (peliculaSeleccionada.equalsIgnoreCase("Toy Story")) cargarImagenFondo("toystory.jpg");
				else if (peliculaSeleccionada.equalsIgnoreCase("Cars")) cargarImagenFondo("cars.jpg");

				// Mostramos la información en un diálogo de mensaje (JOptionPane)
				JOptionPane.showMessageDialog(frame, infoPelicula, "Información de la Película: " + peliculaSeleccionada, JOptionPane.INFORMATION_MESSAGE);

			}
		});
		desplegableMarvel.setFont(fontDisneyChiquitita);
		desplegablePixar.setFont(fontDisneyChiquitita);

		((JLabel) desplegableMarvel.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) desplegablePixar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

		desplegableMarvel.setPreferredSize(dimensionFija);
		desplegablePixar.setPreferredSize(dimensionFija);

		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.insets = new Insets(20, 20, 20, 20);

		panelPeliculas.add(botonDesplegarMarvel, constraints);
		constraints.gridx = 1;
		panelPeliculas.add(botonDesplegarPixar, constraints);
		constraints.gridx = 2;

		constraints.gridx = 0;
		panelPeliculas.add(desplegableMarvel, constraints);
		constraints.gridx = 1;
		panelPeliculas.add(desplegablePixar, constraints);
		constraints.gridx = 2;
		
		btnVolverMenuPrincipal.setFont(fontDisney);
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
		panelPeliculas.add(btnVolverMenuPrincipal, constraints);
	}

	public static void cargarImagenFondo(String nombreImagen) {
		try {
			imagenFondo = ImageIO.read(new File("imagenes/" + nombreImagen));
			panelPrincipal.repaint(); //Vuelve a pintar el panel para mostrar la nueva imagen de fondo
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void construirPanelSeries() {
		GridBagConstraints constraints = new GridBagConstraints();
		// Crear un ícono con la imagen escalada para que coincida con el tamaño del botón
	    JComboBox<String> desplegableSeriesMarvel= new JComboBox<>();
	    JComboBox<String> desplegableSeriesPixar = new JComboBox<>();
	    JButton botonDesplegarSeriesMarvel;
	    JButton botonDesplegarSeriesPixar;
	    JButton btnVolverMenuPrincipalSeries = new JButton("Volver al Menú Principal");
	    
		ImageIcon iconoSeriesMarvel = new ImageIcon("imagenes/marvel.png");
		Image imageSeriesMarvel = iconoSeriesMarvel.getImage();
		Image newImageSeriesMarvel = imageSeriesMarvel.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
		iconoSeriesMarvel = new ImageIcon(newImageSeriesMarvel);
		botonDesplegarSeriesMarvel = new JButton(iconoSeriesMarvel);

		ImageIcon iconoSeriesPixar = new ImageIcon("imagenes/pixar.jpg");
		Image imageSeriesPixar = iconoSeriesPixar.getImage();
		Image newImageSeriesPixar = imageSeriesPixar.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
		iconoSeriesPixar = new ImageIcon(newImageSeriesPixar);
		botonDesplegarSeriesPixar = new JButton(iconoSeriesPixar);
		
		botonDesplegarSeriesMarvel.setFont(fontDisney);
		botonDesplegarSeriesMarvel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desplegableSeriesMarvel.showPopup();
			}
		});
		botonDesplegarSeriesPixar.setFont(fontDisney);
		botonDesplegarSeriesPixar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desplegableSeriesPixar.showPopup();
			}
		});
		
		desplegableSeriesMarvel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String SerieSeleccionada = (String) desplegableSeriesMarvel.getSelectedItem();

				// Obtenemos la información de la Serie
				String infoSerie = Metodos.obtenerInfoPorTitulo(disney, SerieSeleccionada);


				// Cambiamos la imagen de fondo
				if (SerieSeleccionada.equals("Loki")) cargarImagenFondo("loki.jpg");
				else if (SerieSeleccionada.equals("Daredevil")) cargarImagenFondo("daredevil.jpg");

				// Mostramos la información en un diálogo de mensaje (JOptionPane)
				JOptionPane.showMessageDialog(frame, infoSerie, "Información de la Serie: " + SerieSeleccionada, JOptionPane.INFORMATION_MESSAGE);
			}
		});

		desplegableSeriesPixar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String SerieSeleccionada = (String) desplegableSeriesPixar.getSelectedItem();

				// Obtenemos la información de la Serie
				String infoSerie = Metodos.obtenerInfoPorTitulo(disney, SerieSeleccionada);

				// Cambiamos la imagen de fondo
				if (SerieSeleccionada.equalsIgnoreCase("Monstruos a la obra")) cargarImagenFondo("monstruosSA.jpg");
				else if (SerieSeleccionada.equalsIgnoreCase("Dug y Carl")) cargarImagenFondo("dugDays.jpg");

				// Mostramos la información en un diálogo de mensaje (JOptionPane)
				JOptionPane.showMessageDialog(frame, infoSerie, "Información de la Serie: " + SerieSeleccionada, JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		desplegableSeriesMarvel.setFont(fontDisneyChiquitita);
		desplegableSeriesPixar.setFont(fontDisneyChiquitita);
		((JLabel) desplegableSeriesMarvel.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) desplegableSeriesPixar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		desplegableSeriesMarvel.setPreferredSize(dimensionFija);
		desplegableSeriesPixar.setPreferredSize(dimensionFija);

		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.insets = new Insets(20, 20, 20, 20);

		panelSeries.add(botonDesplegarSeriesMarvel, constraints);
		constraints.gridx = 1;
		panelSeries.add(botonDesplegarSeriesPixar, constraints);
		constraints.gridx = 2;

		constraints.gridx = 0;
		panelSeries.add(desplegableSeriesMarvel, constraints);
		constraints.gridx = 1;
		panelSeries.add(desplegableSeriesPixar, constraints);
		constraints.gridx = 2;
		
		btnVolverMenuPrincipalSeries.setFont(fontDisney);
		btnVolverMenuPrincipalSeries.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        cambiarPanelMenu();
		    }
		});
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 3;
		constraints.insets = new Insets(20, 20, 20, 20);
		panelSeries.add(btnVolverMenuPrincipalSeries, constraints);
	}

	public static void construirPanelOtros() {
		frame.getContentPane().add(panelOtros, BorderLayout.CENTER);
		GridBagConstraints constraints = new GridBagConstraints();
		JButton btnModificarTitulo = new JButton("Modificar Título");
		JButton btnAgregarPelicula = new JButton("Agregar Película");
		JButton btnAgregarSerie = new JButton("Agregar Serie");
		JButton btnEliminarContenido = new JButton("Eliminar Contenido");
	    JButton btnVolverMenuPrincipalOtros = new JButton("Volver al Menú Principal");

		btnModificarTitulo.setFont(fontDisney);
		btnAgregarPelicula.setFont(fontDisney);
		btnAgregarSerie.setFont(fontDisney);
		btnEliminarContenido.setFont(fontDisney);

		Color colorFijo = new Color(0, 80, 250);
		btnModificarTitulo.setBackground(colorFijo);
		btnAgregarPelicula.setBackground(colorFijo);
		btnAgregarSerie.setBackground(colorFijo);
		btnEliminarContenido.setBackground(colorFijo);

		btnModificarTitulo.setForeground(Color.WHITE);
		btnAgregarPelicula.setForeground(Color.WHITE);
		btnAgregarSerie.setForeground(Color.WHITE);
		btnEliminarContenido.setForeground(Color.WHITE);

		btnModificarTitulo.setFocusPainted(false);
		btnAgregarPelicula.setFocusPainted(false);
		btnAgregarSerie.setFocusPainted(false);
		btnEliminarContenido.setFocusPainted(false);

		btnModificarTitulo.setBorderPainted(false);
		btnAgregarPelicula.setBorderPainted(false);
		btnAgregarSerie.setBorderPainted(false);
		btnEliminarContenido.setBorderPainted(false);

		btnModificarTitulo.setOpaque(true);
		btnAgregarPelicula.setOpaque(true);
		btnAgregarSerie.setOpaque(true);
		btnEliminarContenido.setOpaque(true);

		btnModificarTitulo.setPreferredSize(dimensionFija);
		btnAgregarPelicula.setPreferredSize(dimensionFija);
		btnAgregarSerie.setPreferredSize(dimensionFija);
		btnEliminarContenido.setPreferredSize(dimensionFija);

		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(20, 20, 20, 20);
		panelOtros.add(btnAgregarPelicula, constraints);

		constraints.gridx = 1;
		panelOtros.add(btnAgregarSerie, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		panelOtros.add(btnModificarTitulo, constraints);

		constraints.gridx = 1;
		panelOtros.add(btnEliminarContenido, constraints);

		panelOtros.setOpaque(false);

		//Agregamos ActionListener para cada botón
		btnModificarTitulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Metodos.modificarTitulo(disney);
			}
		});

		btnAgregarPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Metodos.agregarPelicula(disney);
			}
		});

		btnAgregarSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Metodos.agregarSerie(disney);
			}
		});

		btnEliminarContenido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Metodos.eliminarPorCodigo(disney);
			}
		});
		
		btnVolverMenuPrincipalOtros.setFont(fontDisney);
		btnVolverMenuPrincipalOtros.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        cambiarPanelMenu();
		    }
		});
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 3;
		constraints.insets = new Insets(20, 20, 20, 20);
		panelOtros.add(btnVolverMenuPrincipalOtros, constraints);

	}

	
	public static void cambiarPanelOtros() {
	    panelPrincipal.remove(panelActual); // Eliminar el panel actual
	    panelActual = panelOtros; // Asignar el nuevo panel
	    panelPrincipal.add(panelActual); // Agregar el nuevo panel
	    panelPrincipal.revalidate();
	    frame.repaint();// Actualizar la interfaz
	}
	public static void cambiarPanelPeliculas() {
	    panelPrincipal.remove(panelActual); // Eliminar el panel actual
	    panelActual = panelPeliculas; // Asignar el nuevo panel
	    panelPrincipal.add(panelActual); // Agregar el nuevo panel
	    panelPrincipal.revalidate();
	    frame.repaint();// Actualizar la interfaz
	}
	public static void cambiarPanelSeries() {
	    panelPrincipal.remove(panelActual); // Eliminar el panel actual
	    panelActual = panelSeries; // Asignar el nuevo panel
	    panelPrincipal.add(panelActual); // Agregar el nuevo panel
	    panelPrincipal.revalidate();
	    frame.repaint();// Actualizar la interfaz
	}
	public static void cambiarPanelMenu() {
	    panelPrincipal.remove(panelActual); // Eliminar el panel actual
	    panelActual = panelMenu; // Asignar el nuevo panel
	    panelPrincipal.add(panelActual); // Agregar el nuevo panel
	    panelPrincipal.revalidate();
	    cargarImagenFondo("portadaMM.jpg");
	    frame.repaint();// Actualizar la interfaz
	}
}