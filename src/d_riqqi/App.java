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

        double IDR_USD = 14225;
        double abc;
        double IDR_EURO = 15235;
        double IDR_JPN = 102.7231;

        double USD_JPN = 149.7755;
        double USD_EURO = 1.0221;

        double JPN_EURO = 0.0068;
        double inputJPNtoEURO = 90;
        double hasil = inputJPNtoEURO * IDR_JPN / IDR_EURO;
        double hasil2 = inputJPNtoEURO * JPN_EURO;
        System.out.println(hasil);
        System.out.println(1 / 0.0068);

//        System.out.printf("Harga: %s %n", UK.format(harga));
    }

}
