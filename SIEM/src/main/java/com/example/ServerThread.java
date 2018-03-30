package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerThread extends Thread {
	private final Logger log = LoggerFactory.getLogger(ServerThread.class);

	public ServerThread(Socket sock, int value) {
		this.sock = sock;
		this.value = value;
		try {
			// inicijalizuj ulazni stream
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

			// inicijalizuj izlazni stream
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream())), true);
		} catch (Exception ex) {
			log.info(ex.getMessage());
		}
		start();
	}

	@Override
	public void run() {
		try {
			// procitaj zahtev
			String request = in.readLine();
			System.out.println(request);

			// odgovori na zahtev
			out.println("(" + value + ")");

			// zatvori konekciju
			in.close();
			out.close();
			sock.close();
		} catch (Exception ex) {
			log.info(ex.getMessage());
		}
	}

	private Socket sock;
	private int value;
	private BufferedReader in;
	private PrintWriter out;
}