package pl.projekt;

public class Punkt {

    private int px, py, pz, pt;

    public Punkt() {
        px = 0;
        py = 0;
        pz = 0;
        pt = 0;
    }
    //jeden wieszcholek
    public Punkt(int px, int py) {
        this.px = px;
        this.py = py;
    }

    public Punkt(int px, int py, int pz, int pt) {
        this.px = px;
        this.py = py;
        this.pz = pz;
        this.pt = pt;
    }

    public int getPx() {
        return px;
    }

    public void setPx(int px) {
        this.px = px;
    }

    public int getPy() {
        return py;
    }

    public void setPy(int py) {
        this.py = py;
    }

    public int getPz() {
        return pz;
    }

    public void setPz(int pz) {
        this.pz = pz;
    }

    public int getPt() {
        return pt;
    }

    public void setPt(int pt) {
        this.pt = pt;
    }

    public String toString() {
        return "Punkty wspolrzednych (" + px + ", " + py + "), ( " + pz + ", " + pt + ")";
    }
}
