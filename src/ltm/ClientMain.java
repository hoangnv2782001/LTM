/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltm;

import client.controller.ClientController;
import client.view.ClientView;

/**
 *
 * @author Administrator
 */
public class ClientMain {
    public static void main(String[] args) {
        ClientView clientView = new ClientView();
        ClientController clientController = new ClientController(clientView);
    }
}
