/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsersDAO;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Users;
import view.ViewUpdate;

/**
 *
 * @author Rafael
 */
public class ViewUpdateController {

    private final ViewUpdate view;

    //CONSTRUTOR
    public ViewUpdateController(ViewUpdate view) {
        this.view = view;
    }

    public void mouseClicked() {

        JTable usersTable = view.getjTableUsers();

        JTextField username = view.getjTextFieldUsername();
        JTextField name = view.getjTextFieldName();
        JTextField email = view.getjTextFieldEmail();

        if (usersTable.getSelectedRow() != -1) {

            username.setText(usersTable.getValueAt(usersTable.getSelectedRow(), 1).toString());
            name.setText(usersTable.getValueAt(usersTable.getSelectedRow(), 2).toString());
            email.setText(usersTable.getValueAt(usersTable.getSelectedRow(), 3).toString());

        }

    }

    private void update() {

        //GETTING VALUES OF VIEW
        JTable usersTable = view.getjTableUsers();

        String username = view.getjTextFieldUsername().getText();
        String name = view.getjTextFieldName().getText();
        String email = view.getjTextFieldEmail().getText();

        //RETURNING CODUSER FROM SELECTED ROW
        int coduser = ((int) usersTable.getValueAt(usersTable.getSelectedRow(), 0));

        //SETTING MODEL USERS
        Users u = new Users();

        u.setCoduser(coduser);
        u.setUsername(username);
        u.setName(name);
        u.setEmail(email);

        //LOADING DAO METHOD
        UsersDAO dao = new UsersDAO();

        dao.updateUser(u);

    }

    public void read() {

        DefaultTableModel model = (DefaultTableModel) view.getjTableUsers().getModel();
        model.setNumRows(0);

        UsersDAO dao = new UsersDAO();

        dao.readUsers().forEach((Users u) -> {
            model.addRow(new Object[]{
                u.getCoduser(),
                u.getUsername(),
                u.getName(),
                u.getEmail()

            });
        });

    }

    public void updateButton() {

        update();
        read();

    }

}
