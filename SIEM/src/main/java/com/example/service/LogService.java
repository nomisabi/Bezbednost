package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Log;
import com.example.repository.LogRepository;

@Service
public class LogService {
	@Autowired
	private LogRepository logRepository;

	public void save(String logStr) {
		System.out.println(logStr);
		String[] splited = logStr.split("\\s+");
		String[] splited2 = splited[0].split(">");
		int prival = Integer.parseInt(splited2[0].substring(1, splited2[0].length()));
		int version = Integer.parseInt(splited2[1]);
		String msg = splited[7];
		if (splited.length > 8) {
			StringBuilder bld = new StringBuilder();
			int i = 7;
			while (i < splited.length) {
				bld.append(" ");
				bld.append(splited[i]);
				i++;
			}
			msg = bld.toString();
		}

		Log log = new Log(prival, version, splited[1], splited[2], splited[3], splited[4], splited[5], splited[6],
				msg.trim());
		logRepository.save(log);

	}

}
