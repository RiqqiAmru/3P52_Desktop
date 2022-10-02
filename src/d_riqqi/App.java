/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package d_riqqi;

import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JOptionPane;

/**
 *
 * @author Kamelia
 */
public class App {

    public static void main(String[] args) {
        Font font = new Font("Monospaced", Font.PLAIN, 17);
//For MessageArea and TextField font.
        UIManager.put("OptionPane.messageFont", font);

        int awal = 1, inputan = 7, angkaMendatar = 12, angkaSamping = 0;
        int angkaTengah = 0, spasi = 7, printSpasi = 0, angkaTampilTengah = 0;
        String tampil = "";

        while (awal <= inputan) {
            angkaSamping = awal;
            angkaMendatar = angkaSamping + 11;
            angkaTengah = angkaSamping + 2;
            angkaTampilTengah = angkaTengah;
            printSpasi = spasi;
            int angkaAkhir = 0;
            while (angkaSamping >= 1) {
                tampil += angkaMendatar + " ";
                System.out.print(angkaMendatar + " ");
                angkaAkhir += angkaMendatar;
                angkaSamping--;
                angkaMendatar++;
            }
            while (angkaTampilTengah >= 3) {
                tampil += angkaTampilTengah + " ";
                System.out.print(angkaTampilTengah + " ");
                angkaTampilTengah--;
                angkaAkhir += angkaTengah;
            };
            while (printSpasi >= 1) {
                tampil += "     ";
                System.out.print("     ");
                printSpasi--;
            }
            tampil += " = " + angkaAkhir + "\n";
            System.out.println(" = " + angkaAkhir);
            awal++;
            spasi--;

        }
//            JOptionPane.showMessageDialog(null, tampil);

//        JOptionPane.showMessageDialog(null, tampil);
    }

}
