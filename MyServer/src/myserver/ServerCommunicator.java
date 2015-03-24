
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myserver;
import java.rmi.*;

/**
 *
 * @author puser
 */
public interface ServerCommunicator extends Remote {
    public void printMessageOnServer(String message) throws RemoteException;
    public String getDataFromServer(String name) throws RemoteException;
}
