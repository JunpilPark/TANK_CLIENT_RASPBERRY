package com.test.client.server;

import java.net.Socket;

import com.test.client.Log;

public class ClientNet {
	public static int port = 9999;
	public static String ip = "127.0.0.1";
	private Socket socket = null;
	private Sender sender;
	private Reciver reciever;
	
	public ClientNet(boolean isInit)
	{
		try
		{
			if (isInit)
			{
			    socket = new Socket(ip,port);
				Log.getLog().logString("Socket 积己肯丰");
			}
			else
			{
				Log.getLog().logString("Sever Class积己 肯丰 : initSocket() 角青矫难 家南阑 积己窍绞矫坷.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void initSocket()
	{
		try
		{
			 socket = new Socket(ip,port);
			 Log.getLog().logString("Socket 积己肯丰");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void startReciver()
	{
		reciever = new Reciver(socket);
		reciever.start();
		
	}
	
	public void startSender()
	{
		sender = new Sender(socket);
		sender.start();
	}
	
}
