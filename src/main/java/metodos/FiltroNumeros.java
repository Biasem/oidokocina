package metodos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FiltroNumeros implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        char caracter = e.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if(((caracter < '0') ||
                (caracter > '9')) &&
                (caracter != '\b' /*corresponde a BACK_SPACE*/))
        {
            e.consume();  // ignorar el evento de teclado
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
