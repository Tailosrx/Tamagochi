package info;

public abstract class Animal {
    private String mote;
    private String tipo;
    private String grupo;
    private int salud;
    private int nivelDesbloqueo;
    private String imagePath;
    private String info;

    public Animal(String mote, String tipo, String grupo, int salud, int nivelDesbloqueo, String imagePath, String info) {
        this.mote = mote;
        this.tipo = tipo;
        this.grupo = grupo;
        this.salud = salud;
        this.nivelDesbloqueo = nivelDesbloqueo;
        this.imagePath = imagePath;
        this.info = info;
    }

 

    public String getMote() {
        return mote;
    }

    public String getTipo() {
        return tipo;
    }

    public String getGrupo() {
        return grupo;
    }

    public int getSalud() {
        return salud;
    }

    public int getNivelDesbloqueo() {
        return nivelDesbloqueo;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void setNivelDesbloqueo(int nivelDesbloqueo) {
        this.nivelDesbloqueo = nivelDesbloqueo;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    
}
