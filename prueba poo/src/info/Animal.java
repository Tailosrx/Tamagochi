/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class Animal {

    private String nombre;
    private String mote;
    private String grupo;
    private String tipo;
    private int salud;

    public Animal(String nombre, String mote, String grupo, String tipo, int salud) {
        this.nombre = nombre;
        this.mote = mote;
        this.grupo = grupo;
        this.tipo = tipo;
        this.salud = salud;
    }

   

    public String getNombre() {
        return nombre;
    }

    public String getMote() {
        return mote;
    }

    public String getGrupo() {
        return grupo;
    }

    public String getTipo() {
        return tipo;
    }

    public int getSalud() {
        return salud;
    }

    public void mostrarInfo() {
        System.out.println("Especie: " + getNombre());
        System.out.println("Mote: " + getMote());
        System.out.println("Grupo: " + getGrupo());
        System.out.println("Tipo: " + getTipo());
        System.out.println("Salud: " + getSalud());
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    
}
