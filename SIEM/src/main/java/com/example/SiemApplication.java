package com.example;

import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SiemApplication {
	
	public static final int TCP_PORT = 9000;

	public static void main(String[] args) {
		SpringApplication.run(SiemApplication.class, args);
		try {
			int clientCounter = 0;
			// slusaj zahteve na datom portu
			@SuppressWarnings("resource")
			ServerSocket ss = new ServerSocket(TCP_PORT);
			System.out.println("Server running...");
			while (true) {
				Socket sock = ss.accept();
				System.out.println("Client accepted: " + (++clientCounter));
				new ServerThread(sock, clientCounter);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
