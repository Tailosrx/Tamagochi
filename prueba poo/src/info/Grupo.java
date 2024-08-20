/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info;

public class Grupo extends Animal {

    public Grupo(String mote, String tipo, String grupo, int salud, int nivelDesbloqueo, String imagePath, String info, int hambre, int aburrimiento) {
        super(mote, tipo, grupo, salud, nivelDesbloqueo, imagePath, info, hambre, aburrimiento);
    }

    // Subclases específicas, por ejemplo:
    public static class Gusano extends Grupo {

        public Gusano(String mote, String tipo, String grupo, int salud, int nivelDesbloqueo, String imagePath, String info, int hambre, int aburrimiento) {
        super(mote, tipo, grupo, salud, nivelDesbloqueo, imagePath, info, hambre, aburrimiento);        }
    }

    public static class Araña extends Grupo {

        public Araña(String mote, String tipo, String grupo, int salud, int nivelDesbloqueo, String imagePath, String info, int hambre, int aburrimiento) {
        super(mote, tipo, grupo, salud, nivelDesbloqueo, imagePath, info, hambre, aburrimiento);        }
    }

    public static class Caracol extends Grupo {

        public Caracol(String mote, String tipo, String grupo, int salud, int nivelDesbloqueo, String imagePath, String info, int hambre, int aburrimiento) {
        super(mote, tipo, grupo, salud, nivelDesbloqueo, imagePath, info, hambre, aburrimiento);        }
    }
    
}
