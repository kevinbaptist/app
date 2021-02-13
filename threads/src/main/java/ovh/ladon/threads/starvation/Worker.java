package ovh.ladon.threads.starvation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Worker {

	public synchronized void work() {
		String name = Thread.currentThread().getName();
		String fileName = name + ".txt";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));) {
			writer.write("Thread " + name + " wrote this mesasge");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		while (true) {
			System.out.println(name + " is working");
			//Lines below solve the Starvation issue
//            try {
//                wait(1000);
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
		}
	}
}
