package com.test.client.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import com.test.client.Log;

public class Reciver extends Thread{

	private Socket socket;
	private DataInputStream in;
	
	public Reciver(Socket socket) {
		this.socket = socket;
		try {
			in = new DataInputStream(this.socket.getInputStream());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		Log.getLog().logString("reciver 스레드 동작.");
		while(in != null)
		{
			try {
				System.out.println(in.readUTF());
			} catch (IOException e) {
				Log.getLog().logString("io Exception : reciver thread - " + e.getMessage());
				e.printStackTrace();
				return;
			}
		}
	}

}
