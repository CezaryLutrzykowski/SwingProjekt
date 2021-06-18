package pl.projekt;

import pl.projekt.Figury.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    Color color;
    JFrame frame;
    JMenuBar menu;
    JMenu menuFile, menuRysuj;
    JMenuItem menuFileOpen, menuFileSave, menuFileExit, menuRysujLinia, menuRysujKwadrat, menuRysujProstokat, menuRysujTrojkat, menuRysujKolo;
    JPanel danePanel, rysujPanel, wynikPanel;
    JLabel pXlabel, pYlabel, pZlabel, pHlabel, downLabel, rLabel, gLabel, bLabel;
    JTextField pX, pY, pZ, pH, rTextField, gTextField, bTextField;
    JButton oblicz, kolor, menuKolor;


    public Main() {

        /* Tworzenie obiektow */
        frame = new JFrame();
        menu = new JMenuBar();
        menuFile = new JMenu("File");
        menuFileOpen = new JMenuItem("Open");
        menuFileSave = new JMenuItem("Save");
        menuFileExit = new JMenuItem("Exit");
        menuRysuj = new JMenu("Rysuj");
        menuRysujLinia = new JMenuItem("Linia");
        menuRysujKwadrat = new JMenuItem("Kwadrat");
        menuRysujProstokat = new JMenuItem("Prostokat");
        menuRysujTrojkat = new JMenuItem("Trojkat");
        menuRysujKolo = new JMenuItem("Kolo");
        danePanel = new JPanel();
        rysujPanel = new JPanel();
        wynikPanel = new JPanel();
        /* Dodawanie na scenie  */
        frame.setJMenuBar(menu);
        menu.add(menuFile);
        menuFile.add(menuFileOpen);
        menuFile.add(menuFileSave);
        menuFile.add(menuFileExit);
        menu.add(menuRysuj); // dodanie do menu-bar Rysuj
        menuRysuj.add(menuRysujLinia);
        menuRysuj.add(menuRysujKwadrat);
        menuRysuj.add(menuRysujProstokat);
        menuRysuj.add(menuRysujTrojkat);
        menuRysuj.add(menuRysujKolo);

        /* Listener File na MenuBar umozliwia dzialanie wybranej opcji w Menu/File/ */
        menuFileOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        menuFileSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        menuFileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        /* Listener Rysuj na MenuBar umozliwia dzialanie wybranej opcji w Menu/Rysuj/ */
        menuRysujLinia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcja("Linia");
            }
        });
        menuRysujKwadrat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcja("Kwadrat");
            }
        });
        menuRysujProstokat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcja("Prostokat");
            }
        });
        menuRysujTrojkat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcja("Trojkat");
            }
        });
        menuRysujKolo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcja("Kolo");
            }
        });

        /* Ustawianie oraz rysowanie obramowek */
        danePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Dane"),
                BorderFactory.createEmptyBorder(5, 5, 5, 200)));
        frame.add(BorderLayout.LINE_START, danePanel);

        rysujPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Rysuj"),
                BorderFactory.createEmptyBorder(5, 5, 50, 700)));
        frame.add(BorderLayout.LINE_END, rysujPanel);

        wynikPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Wyniki"),
                BorderFactory.createEmptyBorder(5, 5, 50, 5)));
        frame.add(BorderLayout.PAGE_END, wynikPanel);


        frame.setSize(1000, 800); /* Rozmiar glownego okna aplikacji */
        frame.setTitle("Projekt");            /* Tytul aplikacji */
        frame.setResizable(false);            /* Wylaczenie auto ustawiania obiekow */
        frame.setVisible(true);               /* Uwidocznienie ramek ustawiajac na true */
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /* Przy kliknieciu na X w aplikacji zabija program */
    }

    public static void main(String[] args) {
        new Main();
    }

    public void opcja(String option) {
        danePanel.removeAll();   /* Usuwanie wszystkich elementow zamieszoczynch na Panelu Dane */
        wynikPanel.removeAll();  /* Usuwanie wszystkich elementow zamieszoczynch na Panelu Wynik */

        switch (option) {
            case "Linia" -> {
                Linia linia = new Linia();           /* Tworzymy obiekt Linia */
                pXlabel = new JLabel("X = ");   /* Tworzymy Label */
                pXlabel.setBounds(10, 30, 100, 17);     /* Umieszczamy Label  */
                danePanel.add(pXlabel);             /* Dodajemy Label na aplikacji */
                pX = new JTextField();              /* Tworzymy TextField */
                pX.setBounds(50, 30, 70, 20);   /* Umieszczamy TextField  */
                danePanel.add(pX);                  /* Dodajemy TextField na aplikacji */

                oblicz = new JButton("Oblicz"); /* Tworzymy Button */
                danePanel.add(oblicz);              /* Dodajemy Button */
                oblicz.setBounds(10, 60, 150, 20); /* Umieszczamy Button  */

                /* Akcja po kliknieciu na Button */
                oblicz.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        linia.setX(Double.parseDouble(pX.getText()));   /* parsujemy(zamieniamy) zmienna pX z Stringa na double i wstawiamy w klasie Linia dlugosc */
                        downLabel.setText("Linia nie posiada Pola ani Obwodu"); /* wypisujemy wynik w obramowce Wynki */
                    }
                });

                rLabel = new JLabel("R = ");
                gLabel = new JLabel("G = ");
                bLabel = new JLabel("B = ");
                rLabel.setBounds(10, 90, 100, 17);
                gLabel.setBounds(10, 120, 100, 17);
                bLabel.setBounds(10, 150, 100, 17);
                danePanel.add(rLabel);
                danePanel.add(gLabel);
                danePanel.add(bLabel);
                rTextField = new JTextField();
                gTextField = new JTextField();
                bTextField = new JTextField();
                rTextField.setBounds(50, 90, 70, 20);
                gTextField.setBounds(50, 120, 70, 20);
                bTextField.setBounds(50, 150, 70, 20);
                danePanel.add(rTextField);
                danePanel.add(gTextField);
                danePanel.add(bTextField);

                kolor = new JButton("Kolor");
                danePanel.add(kolor);
                kolor.setBounds(10, 180, 150, 20);

                kolor.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int R, G, B;
                        /* parsujemy z String na inta */
                        R = Integer.parseInt(rTextField.getText());
                        G = Integer.parseInt(gTextField.getText());
                        B = Integer.parseInt(bTextField.getText());
                        linia.setRGB(R, G, B); /* Ustaiwamy w klasie Linia kolory */
                    }
                });

                menuKolor = new JButton("Panel Kolorow");
                danePanel.add(menuKolor);
                menuKolor.setBounds(10, 210, 150, 20);

                menuKolor.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        color = JColorChooser.showDialog(null, "Kolor", color); /* Wywolujemy domysny panel kolorow */
                        linia.setRGB(color.getRed(), color.getGreen(), color.getBlue());
                    }
                });

                downLabel = new JLabel();
                wynikPanel.add(downLabel);
                /* odswiezenie widoku komponentu */
                wynikPanel.repaint();
                frame.repaint();
            }
            case "Kwadrat" -> {
                Kwadrat kwadrat = new Kwadrat();
                pXlabel = new JLabel("X = ");
                pXlabel.setBounds(10, 30, 100, 17);
                danePanel.add(pXlabel);
                pX = new JTextField();
                pX.setBounds(50, 30, 70, 20);
                danePanel.add(pX);

                oblicz = new JButton("Oblicz");
                danePanel.add(oblicz);
                oblicz.setBounds(10, 60, 150, 20);

                oblicz.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        kwadrat.setX(Double.parseDouble(pX.getText()));
                        kwadrat.setY(Double.parseDouble(pX.getText()));
                        kwadrat.Obwod();
                        kwadrat.Pole();

                        downLabel.setText(kwadrat.toString()); // wypisanie prarametru
                    }
                });

                rLabel = new JLabel("R = ");
                gLabel = new JLabel("G = ");
                bLabel = new JLabel("B = ");
                rLabel.setBounds(10, 90, 100, 17);
                gLabel.setBounds(10, 120, 100, 17);
                bLabel.setBounds(10, 150, 100, 17);
                danePanel.add(rLabel);
                danePanel.add(gLabel);
                danePanel.add(bLabel);
                rTextField = new JTextField();
                gTextField = new JTextField();
                bTextField = new JTextField();
                rTextField.setBounds(50, 90, 70, 20);
                gTextField.setBounds(50, 120, 70, 20);
                bTextField.setBounds(50, 150, 70, 20);
                danePanel.add(rTextField);
                danePanel.add(gTextField);
                danePanel.add(bTextField);

                kolor = new JButton("Kolor");
                danePanel.add(kolor);
                kolor.setBounds(10, 180, 150, 20);

                kolor.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int R, G, B;
                        R = Integer.parseInt(rTextField.getText());
                        G = Integer.parseInt(gTextField.getText());
                        B = Integer.parseInt(bTextField.getText());
                        kwadrat.setRGB(R, G, B);
                    }
                });

                menuKolor = new JButton("Panel Kolorow");
                danePanel.add(menuKolor);
                menuKolor.setBounds(10, 210, 150, 20);

                menuKolor.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        color = JColorChooser.showDialog(null, "Kolor", color);
                        kwadrat.setRGB(color.getRed(), color.getGreen(), color.getBlue());
                    }
                });

                downLabel = new JLabel();
                wynikPanel.add(downLabel);
                wynikPanel.repaint();
                frame.repaint();
            }
            case "Prostokat" -> {
                Prostokat prostokat = new Prostokat();
                pXlabel = new JLabel("X = ");
                pYlabel = new JLabel("Y = ");
                pXlabel.setBounds(10, 30, 100, 17);
                pYlabel.setBounds(10, 60, 100, 17);
                danePanel.add(pXlabel);
                danePanel.add(pYlabel);
                pX = new JTextField();
                pY = new JTextField();
                pX.setBounds(50, 30, 70, 20);
                pY.setBounds(50, 60, 70, 20);
                danePanel.add(pX);
                danePanel.add(pY);

                oblicz = new JButton("Oblicz");
                danePanel.add(oblicz);
                oblicz.setBounds(10, 90, 150, 20);

                oblicz.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        prostokat.setX(Double.parseDouble(pX.getText())); // ustawiamy parametru X
                        prostokat.setY(Double.parseDouble(pY.getText())); // ustawiamy parametru Y
                        prostokat.Obwod(); // wywolanie metody liczacej Obwod
                        prostokat.Pole();  // wywolanie metody liczacej Obwod

                        downLabel.setText(prostokat.toString()); // wypisanie prarametru przedstawiajacy Obwod i Pole
                    }
                });

                rLabel = new JLabel("R = ");
                gLabel = new JLabel("G = ");
                bLabel = new JLabel("B = ");
                rLabel.setBounds(10, 120, 100, 17);
                gLabel.setBounds(10, 150, 100, 17);
                bLabel.setBounds(10, 180, 100, 17);
                danePanel.add(rLabel);
                danePanel.add(gLabel);
                danePanel.add(bLabel);
                rTextField = new JTextField();
                gTextField = new JTextField();
                bTextField = new JTextField();
                rTextField.setBounds(50, 120, 70, 20);
                gTextField.setBounds(50, 150, 70, 20);
                bTextField.setBounds(50, 180, 70, 20);
                danePanel.add(rTextField);
                danePanel.add(gTextField);
                danePanel.add(bTextField);

                kolor = new JButton("Kolor");
                danePanel.add(kolor);
                kolor.setBounds(10, 210, 150, 20);

                kolor.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int R, G, B;
                        R = Integer.parseInt(rTextField.getText());
                        G = Integer.parseInt(gTextField.getText());
                        B = Integer.parseInt(bTextField.getText());
                        prostokat.setRGB(R, G, B);
                    }
                });

                menuKolor = new JButton("Panel Kolorow");
                danePanel.add(menuKolor);
                menuKolor.setBounds(10, 240, 150, 20);

                menuKolor.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        color = JColorChooser.showDialog(null, "Kolor", color);
                        prostokat.setRGB(color.getRed(), color.getGreen(), color.getBlue());
                    }
                });

                downLabel = new JLabel();
                wynikPanel.add(downLabel);
                wynikPanel.repaint();
                frame.repaint();
            }
            case "Trojkat" -> {
                Trojkat trojkat = new Trojkat();
                pXlabel = new JLabel("X = ");
                pYlabel = new JLabel("Y = ");
                pZlabel = new JLabel("Z = ");
                pHlabel = new JLabel("H = ");
                pXlabel.setBounds(10, 30, 100, 17);
                pYlabel.setBounds(10, 60, 100, 17);
                pZlabel.setBounds(10, 90, 100, 17);
                pHlabel.setBounds(10, 120, 100, 17);
                danePanel.add(pXlabel);
                danePanel.add(pYlabel);
                danePanel.add(pZlabel);
                danePanel.add(pHlabel);
                pX = new JTextField();
                pY = new JTextField();
                pZ = new JTextField();
                pH = new JTextField();
                pX.setBounds(50, 30, 70, 20);
                pY.setBounds(50, 60, 70, 20);
                pZ.setBounds(50, 90, 70, 20);
                pH.setBounds(50, 120, 70, 20);
                danePanel.add(pX);
                danePanel.add(pY);
                danePanel.add(pZ);
                danePanel.add(pH);

                oblicz = new JButton("Oblicz");
                danePanel.add(oblicz);
                oblicz.setBounds(10, 150, 150, 20);

                oblicz.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Przypisanie dlugosci trojkata
                        trojkat.setX(Double.parseDouble(pX.getText()));
                        trojkat.setY(Double.parseDouble(pY.getText()));
                        trojkat.setZ(Double.parseDouble(pZ.getText()));
                        trojkat.setH(Double.parseDouble(pH.getText()));
                        trojkat.Obwod();
                        trojkat.Pole();

                        downLabel.setText(trojkat.toString());
                    }
                });

                rLabel = new JLabel("R = ");
                gLabel = new JLabel("G = ");
                bLabel = new JLabel("B = ");
                rLabel.setBounds(10, 180, 100, 17);
                gLabel.setBounds(10, 210, 100, 17);
                bLabel.setBounds(10, 240, 100, 17);
                danePanel.add(rLabel);
                danePanel.add(gLabel);
                danePanel.add(bLabel);
                rTextField = new JTextField();
                gTextField = new JTextField();
                bTextField = new JTextField();
                rTextField.setBounds(50, 180, 70, 20);
                gTextField.setBounds(50, 210, 70, 20);
                bTextField.setBounds(50, 240, 70, 20);
                danePanel.add(rTextField);
                danePanel.add(gTextField);
                danePanel.add(bTextField);

                kolor = new JButton("Kolor");
                danePanel.add(kolor);
                kolor.setBounds(10, 270, 150, 20);

                kolor.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int R, G, B;
                        R = Integer.parseInt(rTextField.getText());
                        G = Integer.parseInt(gTextField.getText());
                        B = Integer.parseInt(bTextField.getText());
                        trojkat.setRGB(R, G, B);
                    }
                });

                menuKolor = new JButton("Panel Kolorow");
                danePanel.add(menuKolor);
                menuKolor.setBounds(10, 300, 150, 20);

                menuKolor.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        color = JColorChooser.showDialog(null, "Kolor", color);
                        trojkat.setRGB(color.getRed(), color.getGreen(), color.getBlue());
                    }
                });

                downLabel = new JLabel();
                wynikPanel.add(downLabel);
                wynikPanel.repaint();
                frame.repaint();
            }
            case "Kolo" -> {
                Kolo kolo = new Kolo();
                pXlabel = new JLabel("R = ");
                pXlabel.setBounds(10, 30, 100, 17);
                danePanel.add(pXlabel);
                pX = new JTextField();
                pX.setBounds(50, 30, 70, 20);
                danePanel.add(pX);

                oblicz = new JButton("Oblicz");
                danePanel.add(oblicz);
                oblicz.setBounds(10, 60, 150, 20);

                oblicz.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Kolo kolo = new Kolo();
                        kolo.setR(Double.parseDouble(pX.getText()));
                        kolo.Obwod();
                        kolo.Pole();

                        downLabel.setText(kolo.toString());
                    }
                });

                rLabel = new JLabel("R = ");
                gLabel = new JLabel("G = ");
                bLabel = new JLabel("B = ");
                rLabel.setBounds(10, 90, 100, 17);
                gLabel.setBounds(10, 120, 100, 17);
                bLabel.setBounds(10, 150, 100, 17);
                danePanel.add(rLabel);
                danePanel.add(gLabel);
                danePanel.add(bLabel);
                rTextField = new JTextField();
                gTextField = new JTextField();
                bTextField = new JTextField();
                rTextField.setBounds(50, 90, 70, 20);
                gTextField.setBounds(50, 120, 70, 20);
                bTextField.setBounds(50, 150, 70, 20);
                danePanel.add(rTextField);
                danePanel.add(gTextField);
                danePanel.add(bTextField);

                kolor = new JButton("Kolor");
                danePanel.add(kolor);
                kolor.setBounds(10, 180, 150, 20);

                kolor.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int R, G, B;
                        R = Integer.parseInt(rTextField.getText());
                        G = Integer.parseInt(gTextField.getText());
                        B = Integer.parseInt(bTextField.getText());
                        kolo.setRGB(R, G, B);
                    }
                });

                menuKolor = new JButton("Panel Kolorow");
                danePanel.add(menuKolor);
                menuKolor.setBounds(10, 210, 150, 20);

                menuKolor.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        color = JColorChooser.showDialog(null, "Kolor", color);
                        kolo.setRGB(color.getRed(), color.getGreen(), color.getBlue());
                    }
                });

                downLabel = new JLabel();
                wynikPanel.add(downLabel);
                wynikPanel.repaint(); //odswiezenie widoku komponentu
                frame.repaint();
            }
            default -> {
                System.out.printf("ops!!!");
            }
        }
    }
}
