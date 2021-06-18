package pl.projekt.Figury;

import pl.projekt.Figura;
import pl.projekt.PoleObwod;

import java.awt.*;

public class Trojkat extends Figura implements PoleObwod {

    Color RGB; // Odwolanie do package java.awt pod nazwa RGB
    private double x, y, z, h;

    /* Konstruktor podstawowy */
    public Trojkat() {
        RGB = new Color(0,0,0); // Ustawienei koloru domyslnie
    }

    /* Konstruktor rozszerzony */
    public Trojkat(double x, double y, double z, double h) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.h = h;
        Obwod();
        Pole();
        RGB = new Color(0,0,0); // Ustawienei koloru domyslnie
    }
    /* Gety -Sety */
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

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    /* metody z Interface PoleObwod */
    @Override
    public double Pole() {
        Pole = (x * h) / 2; //Pole pochodzi z dziedziczonej kalsy Figura (abstrakcyjna)
        return Pole;
    }

    @Override
    public double Obwod() {
        Obwod = x + y + z; //Obowd pochodzi z dziedziczonej kalsy Figura (abstrakcyjna)
        return Obwod;
    }

    /* Porowanienie */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trojkat trojkat = (Trojkat) o;
        return Double.compare(trojkat.x, x) == 0 && Double.compare(trojkat.y, y) == 0 && Double.compare(trojkat.z, z) == 0 && Double.compare(trojkat.h, h) == 0;
    }

    @Override
    public String toString() {
        return "Trojkat{" +
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
        return RGB.getRGB(); // Ustawiwanie koloru
    }
}
