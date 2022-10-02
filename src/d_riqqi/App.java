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
        int bilangan = 9;

        int a = 1;
        String tampil = "";

        while (a <= bilangan) {
            for (int i = 0; i < 11; i++) {
                tampil += a + " ";
            }
            tampil += "\n";
            a++;
        }
        JOptionPane.showMessageDialog(null, tampil);

    }

}
