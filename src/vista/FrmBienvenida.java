/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import modelo.Usuario;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Lenovo
 */


public class FrmBienvenida extends JFrame {

    public FrmBienvenida(Usuario u){

        setTitle("Bienvenido");
        setSize(400,300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel lblNombre = new JLabel(
            "Bienvenido " + u.getNombre(),
            SwingConstants.CENTER
        );

        add(lblNombre, BorderLayout.NORTH);

        JLabel lblFoto = new JLabel("", SwingConstants.CENTER);

        if(u.getFoto() != null){
            ImageIcon icon = new ImageIcon(u.getFoto());
            Image img = icon.getImage().getScaledInstance(120,120,Image.SCALE_SMOOTH);
            lblFoto.setIcon(new ImageIcon(img));
        }

        add(lblFoto, BorderLayout.CENTER);

        JButton salir = new JButton("Cerrar sesión");

        salir.addActionListener(e -> {
            new FrmLogin().setVisible(true);
            this.dispose();
        });

        add(salir, BorderLayout.SOUTH);
    }
}
