import java.net.*;
import java.io.*;
import java.util.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;



public class EchoClient {
	
	public static void main(String[] args) {
    try {
		//Check if the argument length is 2 if not display the correct usage
        if (args.length != 2) {
            System.err.println(
                "Usage: java EchoClient <host address> <port number>");
            System.exit(1);
        }
		//create input for portNumber and address location
		InetAddress Address = InetAddress.getByName(args[0]);  
        int portNumber = Integer.parseInt(args[1]);
		DatagramSocket dsock = new DatagramSocket();
		
		//create user input message to be send to the server
		Scanner usermessage = new Scanner(System.in);
		System.out.println("Please enter a Message to send: ");
		String input = usermessage.nextLine();
		
		byte arrsend[] = input.getBytes();
		DatagramPacket dpack = new DatagramPacket(arrsend,arrsend.length,Address,portNumber);
		
		dsock.send(dpack);//send the packet to the server
		
		//The client recieve the packet back from the server
		dsock.receive(dpack);
		//Create a string ti display the message the server sent
		String message2 = new String(dpack.getData());
		System.out.println("Recieve message from server: " + message2);
	
	}catch (IOException ex){
	System.err.println(ex);
	}


	}


}