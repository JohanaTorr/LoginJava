/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import controlador.LoginController;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Lenovo
 */
public class FrmLogin extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtPass;

    public FrmLogin(){

        setTitle("Login");
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,2));

        add(new JLabel("Usuario"));
        txtUsuario = new JTextField(); add(txtUsuario);

        add(new JLabel("Contraseña"));
        txtPass = new JPasswordField(); add(txtPass);

        JButton btnLogin = new JButton("Login");
        JButton btnReg = new JButton("Registro");

        add(btnLogin);
        add(btnReg);

        btnLogin.addActionListener(e -> {
            new LoginController().login(
                txtUsuario.getText(),
                new String(txtPass.getPassword()),
                this
            );
        });

        btnReg.addActionListener(e -> {
            new FrmRegistro().setVisible(true);
            this.dispose();
        });
    }

    public void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
