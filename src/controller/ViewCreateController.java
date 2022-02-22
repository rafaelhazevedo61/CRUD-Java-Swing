/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsersDAO;
import model.Users;
import view.ViewCreate;

/**
 *
 * @author Rafael
 */
public class ViewCreateController {

    private final ViewCreate view;

    //CONSTRUTOR
    public ViewCreateController(ViewCreate view) {
        this.view = view;
    }

    private void create() {

        //GETTING VALUES OF VIEW
        String username = view.getjTextFieldUsername().getText();
        String password = new String(view.getjPasswordFieldPassword().getPassword());
        String name = view.getjTextFieldName().getText();
        String email = view.getjTextFieldEmail().getText();

        //SETTING MODEL USERS
        Users u = new Users();

        u.setUsername(username);
        u.setPassword(password);
        u.setName(name);
        u.setEmail(email);

        //LOADING DAO METHOD
        UsersDAO dao = new UsersDAO();

        dao.createUser(u);

    }

    public void createButton() {

        create();

    }

}
