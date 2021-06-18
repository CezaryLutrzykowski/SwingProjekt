package pl.projekt.Figury;

import pl.projekt.PoleObwod;

import java.awt.*;

public class Kwadrat extends Prostokat implements PoleObwod {

    Color RGB; // Odwolanie do package java.awt pod nazwa RGB

    /* Konstruktor podstawowy */
    public Kwadrat() {
        this.RGB = new Color(0,0,0); // Ustawienei koloru domyslnie
    }

    /* Konstruktor rozszerzony */
    public Kwadrat(double x, double y) {
        super.x = x; //dziedziczenie po Prostokocie double x
        super.y = y; //dziedziczenie po Prostokocie double y
        Obwod(); // Metoda Obowod
        Pole();  // Metoda Pole
        this.RGB = new Color(0,0,0); // Ustawienei koloru domyslnie
    }
    /* metody z Interface PoleObwod */
    @Override
    public double Pole() {
        return super.Pole(); // Dziedziczona metoda z klasy Prostokat
    }

    @Override
    public double Obwod() {
        return super.Obwod(); // Dziedziczona metoda z klasy Prostokat
    }

    @Override
    public String toString() {
        return "Kwadrat{" +
                "Pole=" + Pole +
                ", Obwod=" + Obwod +
                '}';
    }
    /* metody z Interface RGB */
    @Override
    public void setRGB(int R, int G, int B) { // metoda z Interface RGB
        RGB = new Color(R,G,B); // Ustawiwanie koloru
    }

    @Override
    public int getRGB() {
        return RGB.getRGB(); //Pobranie koloru
    }
}
