package com.test.client.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import com.test.client.Log;
import com.test.client.Motor;

public class Sender extends Thread {
	private Socket socket;
	private DataOutputStream out;
	private Scanner scanner;
	private Motor mortor;
	
	public Sender(Socket socket) {
		this.socket = socket;
		try {
			mortor = new Motor();
			out = new DataOutputStream(this.socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		Log.getLog().logString("sender 스레드 동작.");
		
		scanner = new Scanner(System.in);
		byte[] packet;
		String tmp;
		
		while(out != null)
		{
			try {
				tmp = scanner.nextLine();
				if( tmp.equals("w"))
				{
					packet = mortor.goToFront().getPacket();
				}
				else if(tmp.equals("s"))
				{
					packet = mortor.goToBack().getPacket();
				}
				else if(tmp.equals("a"))
				{
					packet = mortor.goToFrtLeft().getPacket();
				}
				else if(tmp.equals("d"))
				{
					packet = mortor.goToFrtRight().getPacket();
				}
				else
				{
					packet = mortor.stop().getPacket();
				}
				
				out.write(packet);
				out.flush();
			} catch (IOException e) {
				Log.getLog().logString("io Exception : sender thread - " + e.getMessage());
				e.printStackTrace();
				return;
			}
		}
	}

	
}
