package main;
//import java.io.File;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import common.CommunicationSocket;
import common.Constants;
import common.Direction;
import elevator.ElevatorSubsystem;
import event.*;
import event.toElevator.*;
import floor.EventReader;
import floor.FloorSubsystem;
import scheduler.SchedulerSubsystem;


public class Main {
	public static void main(String[] args) throws Exception {
//		CommunicationSocket elevatorSocket = new CommunicationSocket();
//		CommunicationSocket floorSocket = new CommunicationSocket();
//		int numberOfFloors = 22;
//		
//		ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem(elevatorSocket, Constants.NUM_ELEVATORS, Constants.NUM_FLOORS);
//		FloorSubsystem floorSubsystem = new FloorSubsystem(floorSocket, Constants.NUM_FLOORS);
//		SchedulerSubsystem schedulerSubsystem = new SchedulerSubsystem(elevatorSocket, floorSocket);
//		
//		Thread elevatorThread = new Thread(elevatorSubsystem);
//		Thread floorThread = 8new Thread(floorSubsystem);
//		Thread schedulerThread = new Thread(schedulerSubsystem);
//		
//		
//		elevatorThread.start();
//		floorThread.start();
//		schedulerThread.start();
//		
		FloorButtonEvent sockEvent = new FloorButtonEvent(3, 4, common.Direction.UP, 12);
		ByteArrayOutputStream byteOut = null;
		ByteArrayInputStream byteIn = null;
		

		byteOut = new ByteArrayOutputStream();

		ObjectOutputStream out = new ObjectOutputStream(byteOut);
		out.writeObject(sockEvent);
		out.close();
		System.out.println("Event serialized.");

		DatagramSocket dS = new DatagramSocket();
		InetAddress ip = InetAddress.getByName("127.0.0.1");  
		DatagramPacket dP = new DatagramPacket(byteOut.toByteArray(), byteOut.size(), ip, 3000);

		dS.send(dP);
		dS.close();
		System.out.println("Datagram sent.");



//		byteIn = new ByteArrayInputStream(byteOut.toByteArray());
//
//		ObjectInputStream in = new ObjectInputStream(byteIn);
//		FloorButtonEvent recEvent = (FloorButtonEvent)in.readObject();
//		in.close();
//
//		System.out.println(recEvent);
//		System.out.println(recEvent.getFloor());


	}
}
