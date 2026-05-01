/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.FrmBienvenida;
import vista.FrmLogin;
import javax.swing.*;

/**
 *
 * @author Lenovo
 */
public class LoginController {
      private final UsuarioDAO dao = new UsuarioDAO();

    public void login(String user, String pass, FrmLogin vista){

        if(user.isEmpty() || pass.isEmpty()){
            JOptionPane.showMessageDialog(vista,"Campos vacíos");
            return;
        }

        Usuario u = dao.login(user, pass);

        if(u != null){
            new FrmBienvenida(u).setVisible(true);
            vista.dispose();
        }else{
            JOptionPane.showMessageDialog(vista,"Error login");
        }
    }
}
