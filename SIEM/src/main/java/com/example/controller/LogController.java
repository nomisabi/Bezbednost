package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.service.LogService;
import com.example.tcp.Connection;
import com.example.tcp.TcpController;

@TcpController
public class LogController {
	@Autowired
	private LogService logService;

	public void receiveData(Connection connection, byte[] data) {
		String s = new String(data);
		connection.send(s.toUpperCase().getBytes());
		logService.save(s);
	}

	public void connect(Connection connection) {
		System.out.println("New connection " + connection.getAddress().getCanonicalHostName());
	}

	public void disconnect(Connection connection) {
		System.out.println("Disconnect " + connection.getAddress().getCanonicalHostName());
	}
}
