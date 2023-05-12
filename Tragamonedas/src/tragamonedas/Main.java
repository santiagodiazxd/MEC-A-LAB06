/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tragamonedas;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lanzamiento de Dados y Tragamonedas");
        frame.setSize(600, 400);
        frame.setLayout(new GridLayout(2, 1));

        JPanel panelDados = new JPanel();
        panelDados.setLayout(new FlowLayout());
        JLabel labelDados = new JLabel("Lanzamiento de Dados: ");
        panelDados.add(labelDados);
        JLabel labelResultadoDados = new JLabel(new ImageIcon("images/1.jpg"));
        panelDados.add(labelResultadoDados);
        frame.add(panelDados);

        JPanel panelTragamonedas = new JPanel();
        panelTragamonedas.setLayout(new FlowLayout());
        JLabel labelTragamonedas = new JLabel("Lanzamiento de Tragamonedas: ");
        panelTragamonedas.add(labelTragamonedas);
        JLabel labelResultadoTragamonedas = new JLabel(new ImageIcon("images/3bar.jpg"));
        panelTragamonedas.add(labelResultadoTragamonedas);
        frame.add(panelTragamonedas);

        frame.setVisible(true);

        DadosThread dadosThread = new DadosThread(labelResultadoDados);
        dadosThread.start();

        TragamonedasThread tragamonedasThread = new TragamonedasThread(labelResultadoTragamonedas);
        tragamonedasThread.start();
    }
}

class DadosThread extends Thread {
    private JLabel label;
    private ImageIcon[] imagenesDados;

    public DadosThread(JLabel label) {
        this.label = label;
        this.imagenesDados = new ImageIcon[]{
                new ImageIcon("images/1.jpg"),
                new ImageIcon("images/2.jpg"),
                new ImageIcon("images/3.jpg"),
                new ImageIcon("images/4.jpg"),
                new ImageIcon("images/5.jpg"),
                new ImageIcon("images/6.jpg")
        };
    }

    public void run() {
        Random random = new Random();
        while (true) {
            int resultado = random.nextInt(6);
            label.setIcon(imagenesDados[resultado]);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TragamonedasThread extends Thread {
    private JLabel label;
    private ImageIcon[] imagenesTragamonedas;

    public TragamonedasThread(JLabel label) {
        this.label = label;
        this.imagenesTragamonedas = new ImageIcon[]{
                new ImageIcon("images/3bar.jpg"),
                new ImageIcon("images/Bar.jpg"),
                new ImageIcon("images/Bell.jpg"),
                new ImageIcon("images/Diamond.jpg"),
                new ImageIcon("images/Lemon.jpg"),
                new ImageIcon("images/Orange.jpg"),
                new ImageIcon("images/right.jpg"),
                new ImageIcon("images/center.jpg"),
                new ImageIcon("images/Seven.jpg"),
                new ImageIcon("images/Star.jpg")
        };
    }

    public void run() {
        Random random = new Random();
        while (true) {
            int resultado = random.nextInt(10);
            label.setIcon(imagenesTragamonedas[resultado]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}