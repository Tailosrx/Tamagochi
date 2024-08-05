package info;

public class Vertebrado extends Animal {

    public Vertebrado(String mote, String tipo, String grupo, int salud, int nivelDesbloqueo, String imagePath, String info) {
        super(mote, tipo, grupo, salud, nivelDesbloqueo, imagePath, info);
    }

    // Subclases específicas, por ejemplo:
    public static class Felivoltio extends Vertebrado {

        public Felivoltio(String mote, String tipo, String grupo, int salud, int nivelDesbloqueo, String imagePath, String info) {
        super("Meu", "FeliVoltio", "Electrico", salud, nivelDesbloqueo, imagePath, info);
        }
    }

    // Similar para otras subclases como Aguila, Tiburon, etc.
    public static class Aguila extends Vertebrado {

        public Aguila(String mote, String tipo, String grupo, int salud, int nivelDesbloqueo, String imagePath, String info) {
        super(mote, tipo, grupo, salud, nivelDesbloqueo, imagePath, info);
        }
    }

    public static class Tiburon extends Vertebrado {

        public Tiburon(String mote, String tipo, String grupo, int salud, int nivelDesbloqueo, String imagePath, String info) {
        super(mote, tipo, grupo, salud, nivelDesbloqueo, imagePath, info);
        }
    }

    public static class Lagarto extends Vertebrado {

        public Lagarto(String mote, String tipo, String grupo, int salud, int nivelDesbloqueo, String imagePath, String info) {
        super(mote, tipo, grupo, salud, nivelDesbloqueo, imagePath, info);
        }
    }

    public static class Koala extends Vertebrado {

        public Koala(String mote, String tipo, String grupo, int salud, int nivelDesbloqueo, String imagePath, String info) {
        super(mote, tipo, grupo, salud, nivelDesbloqueo, imagePath, info);
        }
    }
    
    

}
