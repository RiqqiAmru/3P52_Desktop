/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package d_riqqi;

import javax.swing.UIManager;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author Kamelia
 */
public class App {

    public static void main(String[] args) {
        Font font = new Font("Monospaced", Font.PLAIN, 15);
        //For MessageArea and TextField font.
        UIManager.put("OptionPane.messageFont", font);

        int yakin = JOptionPane.showConfirmDialog(null, "YAKIN INGIN HAPUS DATA INI?");
        System.out.println(yakin);
//        System.out.printf("Harga: %s %n", UK.format(harga));
    }

}
