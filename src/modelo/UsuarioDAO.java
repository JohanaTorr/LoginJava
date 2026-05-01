/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.*;
/**
 *
 * @author Lenovo
 */
public class UsuarioDAO {
    // LOGIN
    public Usuario login(String user, String pass){
        String sql = "SELECT * FROM usuarios WHERE usuario=? AND contrasena=?";
        try(Connection c = ConexionDB.getConexion();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setUsuario(rs.getString("usuario"));
                u.setFoto(rs.getBytes("foto"));
                return u;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    // INSERTAR
    public boolean insertar(Usuario u){
        String sql = "INSERT INTO usuarios(nombre,apellido,email,usuario,contrasena,foto) VALUES(?,?,?,?,?,?)";

        try(Connection c = ConexionDB.getConexion();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellido());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getUsuario());
            ps.setString(5, u.getContrasena());
            ps.setBytes(6, u.getFoto());

            return ps.executeUpdate() > 0;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    // VALIDAR USUARIO
    public boolean existeUsuario(String user){
        String sql = "SELECT COUNT(*) FROM usuarios WHERE usuario=?";
        try(Connection c = ConexionDB.getConexion();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return rs.getInt(1) > 0;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
        
    }
}
