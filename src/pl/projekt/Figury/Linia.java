package pl.projekt.Figury;


import pl.projekt.Figura;
import pl.projekt.PoleObwod;

import java.awt.*;

public class Linia extends Figura implements PoleObwod {

    Color RGB; // Odwolanie do package java.awt pod nazwa RGB
    private double x;

    /* Konstruktor podstawowy */
    public Linia() {
        RGB = new Color(0,0,0); // Ustawienei koloru domyslnie
    }

    /* Konstruktor rozszerzony */
    public Linia(double x) {
        this.x = x; // przypisanie do zmiennej prywatnej double x
        Obwod();
        Pole();
        RGB = new Color(0,0,0); // Ustawienei koloru domyslnie
    }

    /* Gety - Sety */
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    /* Porowanienie */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linia linia = (Linia) o;
        return Double.compare(linia.x, x) == 0;
    }

    /* metody z Interface PoleObwod */

    @Override
    public double Pole() {
        return 0; // Linia nie ma Pola a wiec 0
    }

    @Override
    public double Obwod() {
        return 0; // Linia nie ma Obowodu a wiec 0
    }

    @Override
    public String toString() {
        return "Linia{" +
                "Pole=" + Pole +
                ", Obwod=" + Obwod +
                '}';
    }

    /* metody z Interface RGB */

    @Override
    public void setRGB(int R, int G, int B) {
        RGB = new Color(R, G, B);
    }

    @Override
    public int getRGB() {
        return RGB.getRGB();
    }
}
