/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsersDAO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Users;
import view.ViewDelete;

/**
 *
 * @author Rafael
 */
public class ViewDeleteController {

    private final ViewDelete view;

    //CONSTRUTOR
    public ViewDeleteController(ViewDelete view) {
        this.view = view;
    }

    private void delete() {

        JTable usersTable = view.getjTableUsers();

        //RETURNING CODUSER FROM SELECTED ROW
        int coduser = ((int) usersTable.getValueAt(usersTable.getSelectedRow(), 0));

        //LOADING DAO METHOD
        UsersDAO dao = new UsersDAO();

        dao.deleteUser(coduser);

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

    public void deleteButton() {

        delete();
        read();

    }

}
