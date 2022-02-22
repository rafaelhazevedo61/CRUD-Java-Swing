/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.ViewCreate;
import view.ViewMain;
import view.ViewRead;

/**
 *
 * @author Rafael
 */
public class ViewMainController {

    private final ViewMain view;

    //CONSTRUTOR
    public ViewMainController(ViewMain view) {
        this.view = view;
    }

    public void createButton() {

        ViewCreate newView = new ViewCreate();
        newView.setVisible(true);

    }

    public void readButton() {

        ViewRead newView = new ViewRead();
        newView.setVisible(true);

    }

}
