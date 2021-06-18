package pl.projekt.Figury;

import pl.projekt.Figura;
import pl.projekt.PoleObwod;

import java.awt.*;

public class Prostokat extends Figura implements PoleObwod {

    Color RGB; // Odwolanie do package java.awt pod nazwa RGB
    public double x;
    public double y;

    /* Konstruktor podstawowy */
    public Prostokat() {
        RGB = new Color(0,0,0); // Ustawienei koloru domyslnie
    }

    public Prostokat(double x, double y) {
        this.x = x;
        this.y = y;
        Obwod();
        Pole();
    }

    /* Gety - Sety */
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    /* metody z Interface PoleObwod */
    @Override
    public double Pole() {
        Pole = x * y; //Pole pochodzi z dziedziczonej kalsy Figura (abstrakcyjna)
        return Pole;
    }

    @Override
    public double Obwod() {
        Obwod = (2 * x) + (2 * y); //Obwod pochodzi z dziedziczonej kalsy Figura (abstrakcyjna)
        return Obwod;
    }

    /* Porowanienie */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prostokat prostokat = (Prostokat) o;
        return Double.compare(prostokat.x, x) == 0 && Double.compare(prostokat.y, y) == 0;
    }

    @Override
    public String toString() {
        return "Prostokat{" +
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
