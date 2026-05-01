/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import controlador.RegistroController;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Files;
/**
 *
 * @author Lenovo
 */
public class FrmRegistro extends JFrame {
    private JTextField txtNombre, txtApellido, txtEmail, txtUsuario;
    private JPasswordField txtPass, txtConfirm;
    private JLabel lblFoto;
    private byte[] fotoBytes;

    public FrmRegistro(){

        setTitle("Registro");
        setSize(400,500);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8,2));

        add(new JLabel("Nombre"));
        txtNombre = new JTextField(); add(txtNombre);

        add(new JLabel("Apellido"));
        txtApellido = new JTextField(); add(txtApellido);

        add(new JLabel("Email"));
        txtEmail = new JTextField(); add(txtEmail);

        add(new JLabel("Usuario"));
        txtUsuario = new JTextField(); add(txtUsuario);

        add(new JLabel("Contraseña"));
        txtPass = new JPasswordField(); add(txtPass);

        add(new JLabel("Confirmar"));
        txtConfirm = new JPasswordField(); add(txtConfirm);

        JButton btnFoto = new JButton("Seleccionar Foto");
        lblFoto = new JLabel("Sin imagen");

        add(btnFoto); add(lblFoto);

        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");

        add(btnGuardar); add(btnCancelar);

        // seleccionar imagen
        btnFoto.addActionListener(e -> seleccionarFoto());

        // guardar
        btnGuardar.addActionListener(e -> {
            new RegistroController().registrar(
                txtNombre.getText(),
                txtApellido.getText(),
                txtEmail.getText(),
                txtUsuario.getText(),
                new String(txtPass.getPassword()),
                new String(txtConfirm.getPassword()),
                fotoBytes,
                this
            );
        });

        // cancelar
        btnCancelar.addActionListener(e -> {
            new FrmRegistro().setVisible(true);
            this.dispose();
        });
    }

    private void seleccionarFoto(){
        JFileChooser fc = new JFileChooser();
        if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            try{
                File file = fc.getSelectedFile();
                fotoBytes = Files.readAllBytes(file.toPath());
                lblFoto.setText("Imagen cargada");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Error imagen");
            }
        }
    }
}
