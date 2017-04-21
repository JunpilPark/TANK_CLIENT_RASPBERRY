package com.test.client;

public class Packet {
	private byte[] packet;
	
	public Packet()
	{
		packet = new byte[4];
	}
	
	public void setDeparture(byte departurBit)
	{
		packet[0] = (byte) (departurBit << 4);
		Log.getLog().logString("make departure packet[0] : " + Byte.toString(packet[0]));
	}
	
	public void setDestination(byte destinationBit)
	{
		packet[0] = (byte) (packet[0] | destinationBit);
		Log.getLog().logString("make destination packet[0] : " + Byte.toString(packet[0]));
	}
	
	public void setTargetPart(byte partBit)
	{
		packet[1] = partBit;
		Log.getLog().logString("make packet[1] : " + Byte.toString(packet[1]));
	}
	
	public void setPosition(byte positionBit)
	{
		packet[2] = positionBit;
		Log.getLog().logString("make packet[2] : " + Byte.toString(packet[2]));
	}
	
	public void setAction(byte actionBit)
	{
		packet[3] = actionBit;
		Log.getLog().logString("make packet[3] : " + Byte.toString(packet[3]));
	}
	
	public byte[] getPacket()
	{
		Log.getLog().logString("get packet : " + Byte.toString(packet[0]) + ", " + Byte.toString(packet[1]) + ", " + 
								Byte.toString(packet[2]) +", " + Byte.toString(packet[3]));
		return packet;
	}
}
