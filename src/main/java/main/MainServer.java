/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import server.Server;

/**
 *
 * @author Gabriel
 */
public class MainServer {
    public static void main(String[] args) {
    Server server = new Server(5000);
    if(server.initServer()) {
      server.run();
    }
  }
}
