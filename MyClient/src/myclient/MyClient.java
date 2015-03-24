package myclient;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import myserver.ServerCommunicator;

public class MyClient {

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "CommsService";
            String host = "localhost";
            Registry registry
                    = LocateRegistry.getRegistry(host);
            ServerCommunicator comm = (ServerCommunicator) registry.lookup(name);
            comm.printMessageOnServer("hello from client");
        } catch (Exception e) {
            System.err.println("exception:");
        }
    }
}

