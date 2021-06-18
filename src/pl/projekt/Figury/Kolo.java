package pl.projekt.Figury;

import pl.projekt.Figura;
import pl.projekt.PoleObwod;

import java.awt.*;

public class Kolo extends Figura implements PoleObwod {

    Color RGB; // Odwolanie do package java.awt pod nazwa RGB
    private double r;

    /* Konstruktor podstawowy */
    public Kolo() {
        RGB = new Color(0,0,0); // Ustawienei koloru domyslnie
    }

    /* Konstruktor rozszerzony */
    public Kolo(double r) {
        RGB = new Color(0,0,0); // Ustawienei koloru domyslnie
        this.r = r;
        Obwod();
        Pole();
    }

    /* Gety - Sety */
    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    /* Porowanienie */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kolo kolo = (Kolo) o;
        return Double.compare(kolo.r, r) == 0;
    }
    /* metody z Interface PoleObwod */
    @Override
    public double Pole() {
        Pole = (r*r*3.14); //Pole pochodzi z dziedziczonej kalsy Figura (abstrakcyjna)
        return Pole;
    }

    @Override
    public double Obwod() {
        Obwod = (2*r*3.14); //Obwod pochodzi z dziedziczonej kalsy Figura (abstrakcyjna)
        return Obwod;
    }

    @Override
    public String toString() {
        return "Kolo{" +
                "Pole=" + Pole +
                ", Obwod=" + Obwod +
                '}';
    }

    /* metody z Interface RGB */
    @Override
    public void setRGB(int R, int G, int B) {
        RGB = new Color(R,G,B); // Ustawiwanie koloru
    }

    @Override
    public int getRGB() {
        return RGB.getRGB(); //Pobranie koloru
    }


}
