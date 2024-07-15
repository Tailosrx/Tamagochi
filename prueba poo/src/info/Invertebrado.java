/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info;

/**
 *
 * @author kevin
 */
public class Invertebrado {

    public static class Invertebrados extends Animal {

        public Invertebrados(String nombre, String mote, String grupo, String tipo, int salud) {
            super(mote, nombre, tipo, "Invertebrado", salud);
        }

        // Método para invertebrados
        public void invertebradoInfo() {
            System.out.println("Los invertebrados no tienen columna vertebral");
        }
    }

    // Clase Artropodo (subclase de Invertebrado)
    public static class Artropodo extends Invertebrados {

        public Artropodo(String nombre, String raza, String grupo, String tipo, int salud) {
            super(nombre, raza, grupo, tipo, salud);
        }

        // Método para artrópodos
        public void artropodoInfo() {
            System.out.println("Los artrópodos tienen exoesqueleto y patas articuladas.");
        }
    }

    public static class Arana extends Artropodo {

        public Arana(String nombre, String raza, String grupo, String tipo, int salud) {
            super(nombre, raza, grupo, tipo, salud);
        }

    }

    // Clase Molusco (subclase de Invertebrado)
    public static class Molusco extends Invertebrados {

        public Molusco(String nombre, String raza, String grupo, String tipo, int salud) {
            super(nombre, raza, grupo, tipo, salud);
        }

    }

    public static class Caracol extends Molusco {

        public Caracol(String nombre, String raza, String grupo, String tipo, int salud) {
            super(nombre, raza, grupo, tipo, salud);
        }

    }

    // Clase Gusano (subclase de Invertebrado)
    public static class Gusano extends Invertebrados {

        public Gusano(String nombre, String mote, String grupo, String tipo, int salud) {
            super(nombre, mote, tipo, grupo, salud);
        }

        // Método para gusanos
        public void gusanoInfo() {
            System.out.println("Los gusanos son animales alargados y suaves.");
        }
    }

}
