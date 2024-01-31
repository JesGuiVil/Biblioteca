package Ficheros;

import java.awt.Dimension;

import javax.swing.JTextArea;

class NoWrapTextArea extends JTextArea {
    public NoWrapTextArea(String text) {
        super(text);
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return getUI().getPreferredSize(this).width <= getParent().getSize().width;
    }

    @Override
    public void setSize(Dimension d) {
        if (d.width < getParent().getSize().width) {
            d.width = getParent().getSize().width;
        }
        super.setSize(d);
    }

    @Override
    public void setTabSize(int tabSize) {
        // Ajusta el tamaño de la pestaña según tus necesidades
        super.setTabSize(4); // Puedes cambiar el número según tus preferencias
    }
}


