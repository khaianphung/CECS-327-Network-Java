import java.net.*;
import java.io.*;

public class EchoServer {
	//Maximum size of echo datagram
    private static final int ECHOMAX = 255;   
   
    public static void main(String[] args) throws IOException{
        
        if(args.length != 1)    //Test for correct argument list
            throw new IllegalArgumentException("Usage:java EchoServer <port>");
        
        int servPort = Integer.parseInt(args[0]); // Set user set serverport
        
        DatagramSocket socket = new DatagramSocket(servPort); // create the serverport socket for client to connect
        DatagramPacket packet = new DatagramPacket(new byte[ECHOMAX], ECHOMAX); //set the byte amount to 255
		System.out.println("Waiting on Client to send a message........... "); 
        
   
        socket.receive(packet); //receive the packet from the client
	    String message2 = new String(packet.getData()); // create a string to send the message back to client
		System.out.println("Message Recived from Client: "+ message2);
        System.out.println("Handling client at " +
                    packet.getAddress().getHostAddress() + " on port " + 
                    packet.getPort());
		//Send the same packet back to client
        socket.send(packet);    
		//reset length to avoid shrinking buffer
        packet.setLength(ECHOMAX);    

        
        socket.close(); //close the socket
    }
}