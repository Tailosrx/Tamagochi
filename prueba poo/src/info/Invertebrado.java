/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info;

public class Invertebrado extends Animal {

    public Invertebrado(String mote, String tipo, String grupo, int salud, int nivelDesbloqueo, String imagePath, String info) {
        super(mote, tipo, grupo, salud, nivelDesbloqueo, imagePath, info);
    }

    // Subclases específicas, por ejemplo:
    public static class Gusano extends Invertebrado {

        public Gusano(String mote, String tipo, String grupo, int salud, int nivelDesbloqueo, String imagePath, String info) {
            super(mote, tipo, grupo, salud, nivelDesbloqueo, imagePath, info);
        }
    }

    public static class Araña extends Invertebrado {

        public Araña(String mote, String tipo, String grupo, int salud, int nivelDesbloqueo, String imagePath, String info) {
            super(mote, tipo, grupo, salud, nivelDesbloqueo, imagePath, info);
        }
    }

    public static class Caracol extends Invertebrado {

        public Caracol(String mote, String tipo, String grupo, int salud, int nivelDesbloqueo, String imagePath, String info) {
            super(mote, tipo, grupo, salud, nivelDesbloqueo, imagePath, info);
        }
    }
    // Similar para otras subclases como Arana, Caracol, etc.
}
