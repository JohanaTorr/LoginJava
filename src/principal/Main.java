/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;
import javax.swing.SwingUtilities;
import vista.FrmLogin;
/**
 *
 * @author Lenovo
 */


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FrmLogin().setVisible(true);
        });
    }
}