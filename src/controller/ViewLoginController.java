/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsersDAO;
import javax.swing.JOptionPane;
import model.Users;
import view.ViewLogin;

/**
 *
 * @author Rafael
 */
public class ViewLoginController {

    private final ViewLogin view;

    //CONSTRUTOR
    public ViewLoginController(ViewLogin view) {
        this.view = view;
    }

    private boolean login() {

        //GETTING VALUES OF VIEW
        String username = view.getjTextFieldUsername().getText();
        String password = new String(view.getjPasswordFieldPassword().getPassword());

        //SETTING MODEL USERS
        Users u = new Users();

        u.setUsername(username);
        u.setPassword(password);

        //LOADING DAO METHOD
        UsersDAO dao = new UsersDAO();

        boolean exist = dao.verifyExist(u);

        if (exist) {
            JOptionPane.showMessageDialog(null, "User authenticated");
        } else {
            JOptionPane.showMessageDialog(null, "User not authenticated");
        }

        return exist;

    }

    public void loginButton() {

        login();

    }

}
