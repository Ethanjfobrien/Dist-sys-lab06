/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myserver;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author puser
 */
public class MyServer implements ServerCommunicator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "CommsService";
            ServerCommunicator server = new MyServer();
            ServerCommunicator stub = (ServerCommunicator) UnicastRemoteObject.exportObject(server, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            server.printMessageOnServer("server started");
        } catch (Exception e) {
            System.err.println("exception:"+ e.getLocalizedMessage());
        }

    }

    public MyServer() {
        super();
    }

    @Override
    public void printMessageOnServer(String message) throws RemoteException {
        System.out.println(message);
    }

    @Override
    public String getDataFromServer(String name) throws RemoteException {
        return name.toUpperCase();
    }

}
