package org.jobhacker.exercise;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Event {
	String name;
	private int availableSeats;
	public static Lock lock = new ReentrantLock();
	public Event(String name, int seats)
	{
		this.name = name;
		availableSeats = seats;
	}
	public void bookTicket(String user)
	{
		lock.lock();
		try {
			if (availableSeats == 0) {
				System.out.print("Sorry " + user + ", " + name + " event seats are sold out.");
			} else {
				availableSeats--;
				System.out.print(user + "'s ticket has been booked for " + name + ".");
			}
			System.out.println("  -  "+ Thread.currentThread().getName());
			System.out.println();
		} finally {
			lock.unlock();
		}
	}
}
