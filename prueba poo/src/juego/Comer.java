package juego;

import info.Animal;
import javax.swing.*;

public class Comer {

    public static final int EXITO = 1;
    public static final int FAIL = 0;

    private Animal a;
    private ResultCallback callback; 

    @FunctionalInterface
    public interface ResultCallback {
        void onResult(int resultado);
    }

    public Comer(Animal a, ResultCallback callback) {
        this.a = a;
        this.callback = callback;
    }

    public void start() {
        // Simulando un minijuego con un resultado basado en probabilidades
        int resultado;
        if (Math.random() > 0.3) {  // 70% de probabilidad de éxito
            resultado = EXITO;
        } else {
            resultado = FAIL;
        }

        // Llamando al callback con el resultado
        if (callback != null) {
            callback.onResult(resultado);
        }
    }
}
