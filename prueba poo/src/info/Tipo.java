package info;

public class Tipo extends Animal {

    public Tipo(String mote, String tipo, String grupo, int salud, int nivelDesbloqueo, String imagePath, String info, int hambre, int aburrimiento) {
        super(mote, tipo, grupo, salud, nivelDesbloqueo, imagePath, info, hambre, aburrimiento);
    }

    // Subclases específicas, por ejemplo:
    public static class Felivoltio extends Tipo {

        public Felivoltio(String mote, String tipo, String grupo, int salud, int nivelDesbloqueo, String imagePath, String info, int hambre, int aburrimiento) {
        super("Meu", "FeliVoltio", "Electrico", salud, nivelDesbloqueo, imagePath, info, 50, 50);
        }
    }

    // Similar para otras subclases como Aguila, Tiburon, etc.
    public static class Aguila extends Tipo {

        public Aguila(String mote, String tipo, String grupo, int salud, int nivelDesbloqueo, String imagePath, String info, int hambre, int aburrimiento) {
        super(mote, tipo, grupo, salud, nivelDesbloqueo, imagePath, info, 50, 50);
        }
    }

    public static class Tiburon extends Tipo {

        public Tiburon(String mote, String tipo, String grupo, int salud, int nivelDesbloqueo, String imagePath, String info, int hambre, int aburrimiento) {
        super(mote, tipo, grupo, salud, nivelDesbloqueo, imagePath, info, 50, 50);
        }
    }

    public static class Lagarto extends Tipo {

        public Lagarto(String mote, String tipo, String grupo, int salud, int nivelDesbloqueo, String imagePath, String info, int hambre, int aburrimiento) {
        super(mote, tipo, grupo, salud, nivelDesbloqueo, imagePath, info, 50, 50);
        }
    }

    public static class Koala extends Tipo {

        public Koala(String mote, String tipo, String grupo, int salud, int nivelDesbloqueo, String imagePath, String info, int hambre, int aburrimiento) {
        super(mote, tipo, grupo, salud, nivelDesbloqueo, imagePath, info, 50, 50);
        }
    }
    
    

}
