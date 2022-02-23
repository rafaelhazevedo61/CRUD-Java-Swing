/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Users;
import util.ConnectionFactory;
import util.Text;

/**
 *
 * @author Rafael
 */
public class UsersDAO {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    public boolean verifyExist(Users user) {

        //VALIDATION
        if (Text.isNullOrEmpty(user.getUsername())
                || Text.isNullOrEmpty(user.getPassword())) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório não preenchido!");
        }

        conn = ConnectionFactory.openConnection();

        try {

            String sql = "select * from users where username=? and password=?";

            pst = conn.prepareStatement(sql);

            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());

            rs = pst.executeQuery();

            while (rs.next()) {

                return true;

            }

        } catch (SQLException e) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.closeConnection();
        }

        return false;

    }

    public void deleteUser(int coduser) {

        //VALIDATION
        if (coduser == 0) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório não preenchido!");
        }

        conn = ConnectionFactory.openConnection();

        try {

            String sql = "delete from users where coduser = ?";

            pst = conn.prepareStatement(sql);

            pst.setInt(1, coduser);

            pst.execute();

            JOptionPane.showMessageDialog(null, "User deleted with sucess!");

        } catch (SQLException e) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.closeConnection();
        }
    }

    public void createUser(Users user) {

        //VALIDATION
        if (Text.isNullOrEmpty(user.getUsername())
                || Text.isNullOrEmpty(user.getPassword())
                || Text.isNullOrEmpty(user.getName())) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório não preenchido!");
        }

        conn = ConnectionFactory.openConnection();

        try {

            String sql = "insert into users (username,password,name,email) values (?,?,?,?)";

            pst = conn.prepareStatement(sql);

            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getName());
            pst.setString(4, user.getEmail());

            pst.execute();

            JOptionPane.showMessageDialog(null, "User created with sucess!");

        } catch (SQLException e) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.closeConnection();
        }

    }

    public void updateUser(Users user) {

        //VALIDATION
        if (Text.isNullOrEmpty(user.getUsername())
                || Text.isNullOrEmpty(user.getName())) {

            JOptionPane.showMessageDialog(null, "Campo obrigatório não preenchido!");

        }

        conn = ConnectionFactory.openConnection();

        try {

            String sql = "update users set username=?,name=?,email=? where coduser=?";

            pst = conn.prepareStatement(sql);

            pst.setString(1, user.getUsername());
            pst.setString(2, user.getName());
            pst.setString(3, user.getEmail());
            pst.setInt(4, user.getCoduser());

            System.out.println(pst);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "The selected register was updated with sucess!");

        } catch (SQLException e) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.closeConnection();
        }

    }

    public List<Users> readUsers() {

        conn = ConnectionFactory.openConnection();

        List<Users> users = new ArrayList<>();

        try {

            String sql = "select * from users";

            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {

                users.add(LoadResultSet(rs));

            }

            return users;

        } catch (SQLException e) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.closeConnection();
        }

        return users;

    }

    public Users LoadResultSet(ResultSet rs) throws SQLException {

        Users user = new Users();

        user.setCoduser(rs.getInt("coduser"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));

        return user;

    }

}
