package com.test.client;

public class Motor {
	private Packet packet;
	
	public Motor() {
		packet = new Packet();
	}
	
	private void setCommonInPacket()
	{
		packet.setDeparture(DataSet.APP);
		packet.setDestination(DataSet.SERIAL);
		packet.setTargetPart(DataSet.MOTOR);
	}
	
	public Packet goToFront()
	{
		setCommonInPacket();
		packet.setPosition((byte) (DataSet.FRT_L|DataSet.FRT_R));
		packet.setAction(DataSet.ON_FRONT);
		return packet;
	}
	
	public Packet goToBack()
	{
		setCommonInPacket();
		packet.setPosition((byte) (DataSet.FRT_L|DataSet.FRT_R));
		packet.setAction(DataSet.ON_BACK);
		return packet;
	}
	
	public Packet goToFrtRight()
	{
		setCommonInPacket();
		packet.setPosition((byte) (DataSet.FRT_R));
		packet.setAction(DataSet.ON_FRONT);
		return packet;
	}
	
	public Packet goToFrtLeft()
	{
		setCommonInPacket();
		packet.setPosition((byte) (DataSet.FRT_L));
		packet.setAction(DataSet.ON_FRONT);
		return packet;
	}
	
	public Packet goToRrRight()
	{
		setCommonInPacket();
		packet.setPosition((byte) (DataSet.FRT_L));
		packet.setAction(DataSet.ON_BACK);
		return packet;
	}
	
	public Packet goToRrLeft()
	{
		setCommonInPacket();
		packet.setPosition((byte) (DataSet.FRT_R));
		packet.setAction(DataSet.ON_BACK);
		return packet;
	}
	
	public Packet stop()
	{
		setCommonInPacket();
		packet.setPosition((byte) (DataSet.FRT_L|DataSet.FRT_R));
		packet.setAction(DataSet.OFF);
		return packet;
	}
	
	
}
