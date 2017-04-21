package com.test.client;

import com.test.client.server.ClientNet;

public class Client {
	public static void main(String... args)
	{
		
		Log.getLog().debugModeOn();
		ClientNet clientNet = new ClientNet(true);
		clientNet.startSender();
		clientNet.startReciver();
	}
}
