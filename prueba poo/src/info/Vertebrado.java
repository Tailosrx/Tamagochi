package info;

public class Vertebrado {

    public static class Vertebrados extends Animal {

        public Vertebrados(String nombre, String mote, String tipo, String grupo, int salud) {
            super(mote, nombre, tipo, grupo, salud);
        }

        public void vertebradoInfo() {
            System.out.println("Los vertebrados tienen columna vertebral");
        }
    }

    public static class Mamifero extends Vertebrados {

        public Mamifero(String nombre, String mote, String tipo, String grupo, int salud) {
            super(nombre, mote, tipo, grupo, salud);
        }

        // Método para mamíferos
        public void MamiferoInfo() {
            System.out.println("Los mamíferos tienen glándulas mamarias.");
        }
    }

    public static class Koala extends Mamifero {

        public Koala(String nombre, String mote, String tipo, String grupo, int salud) {
            super(nombre, mote, tipo, grupo, salud);
        }

        // Constructor
    }

    // Clase Gato (subclase de Mamifero)
    public static class Gato extends Mamifero {

        public Gato(String nombre, String mote, String tipo, String grupo, int salud) {
            super(nombre, mote, tipo, grupo, salud);
        }

    }

    // Clase Ave (subclase de Vertebrado)
    public static class Ave extends Vertebrados {

        public Ave(String nombre, String mote, String tipo, String grupo, int salud) {
            super(nombre, mote, tipo, grupo, salud);
        }

        // Método para aves
        public void aveInfo() {
            System.out.println("Las aves tienen plumas y ponen huevos.");
        }
    }

    public static class Aguila extends Ave {

        public Aguila(String nombre, String mote, String tipo, String grupo, int salud) {
            super(nombre, mote, tipo, grupo, salud);
        }

    }

    // Clase Pez (subclase de Vertebrado)
    public static class Pez extends Vertebrados {

        public Pez(String nombre, String mote, String tipo, String grupo, int salud) {
            super(nombre, mote, tipo, grupo, salud);
        }

        // Método para peces
        public void pezInfo() {
            System.out.println("Los peces tienen aletas y branquias.");
        }
    }

    public static class Tiburon extends Pez {

        public Tiburon(String nombre, String mote, String tipo, String grupo, int salud) {
            super(nombre, mote, tipo, grupo, salud);
        }

    }

    // Clase Anfibio (subclase de Vertebrado)
    public static class Anfibio extends Vertebrados {

        public Anfibio(String nombre, String mote, String tipo, String grupo, int salud) {
            super(nombre, mote, tipo, grupo, salud);
        }

        // Método para anfibios
        public void anfibioInfo() {
            System.out.println("Los anfibios pasan parte de su vida en el agua y parte en la tierra.");
        }
    }

    // Clase Reptil (subclase de Vertebrado)
    public static class Reptil extends Vertebrados {

        public Reptil(String nombre, String mote, String tipo, String grupo, int salud) {
            super(nombre, mote, tipo, grupo, salud);
        }

        // Método para reptiles
        public void reptilInfo() {
            System.out.println("Los reptiles tienen escamas y ponen huevos con cáscara.");
        }
    }

    public static class Lagarto extends Reptil {

        public Lagarto(String nombre, String mote, String tipo, String grupo, int salud) {
            super(nombre, mote, tipo, grupo, salud);
        }

        // Constructor
    }

}
