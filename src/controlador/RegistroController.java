/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.FrmLogin;
import vista.FrmRegistro;
import javax.swing.*;

/**
 *
 * @author Lenovo
 */
public class RegistroController {
    private UsuarioDAO dao = new UsuarioDAO();

    public void registrar(String nombre, String apellido, String email,
                          String user, String pass, String confirm,
                          byte[] foto, FrmRegistro vista){

        if(nombre.isEmpty() || apellido.isEmpty() || user.isEmpty() || pass.isEmpty()){
            JOptionPane.showMessageDialog(vista,"Campos vacíos");
            return;
        }

        if(!pass.equals(confirm)){
            JOptionPane.showMessageDialog(vista,"Contraseñas no coinciden");
            return;
        }

        if(dao.existeUsuario(user)){
            JOptionPane.showMessageDialog(vista,"Usuario ya existe");
            return;
        }

        Usuario u = new Usuario(nombre, apellido, email, user, pass, foto);

        if(dao.insertar(u)){
            JOptionPane.showMessageDialog(vista,"Registro exitoso");
            new FrmLogin().setVisible(true);
            vista.dispose();
        }else{
            JOptionPane.showMessageDialog(vista,"Error BD");
        }
    }
}
