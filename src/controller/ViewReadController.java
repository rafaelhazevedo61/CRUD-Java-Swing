/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsersDAO;
import javax.swing.table.DefaultTableModel;
import model.Users;
import view.ViewRead;

/**
 *
 * @author Rafael
 */
public class ViewReadController {

    private final ViewRead view;

    //CONSTRUTOR
    public ViewReadController(ViewRead view) {
        this.view = view;
    }

    private void read() {

        DefaultTableModel model = (DefaultTableModel) view.getjTableUsers().getModel();
        model.setNumRows(0);

        UsersDAO dao = new UsersDAO();

        dao.readUsers().forEach((Users u) -> {
            model.addRow(new Object[]{
                u.getCoduser(),
                u.getUsername(),
                u.getPassword(),
                u.getName(),
                u.getEmail()

            });
        });

    }

    public void readButton() {

        read();

    }

}
