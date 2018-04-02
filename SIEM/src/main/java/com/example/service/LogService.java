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
		String lines[] = logStr.split("\\r?\\n");
		for (String line : lines) {
			Log log = parseLine(line);
			logRepository.save(log);
		}
	}

	private Log parseLine(String line) {
		String[] splited = line.split("\\s+");
		String[] splited2 = splited[0].split(">");
		int prival = Integer.parseInt(splited2[0].substring(1, splited2[0].length()));
		int version = Integer.parseInt(splited2[1]);
		String sd = splited[6];
		String msg = splited[7];

		if (line.contains("[")) {
			sd = line.substring(line.indexOf("["), line.indexOf("]") + 1);
			msg = line.substring(line.indexOf("]") + 1, line.length());
		} else {
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
		}
		return new Log(prival, version, splited[1], splited[2], splited[3], splited[4], splited[5], sd, msg.trim());
	}

}
