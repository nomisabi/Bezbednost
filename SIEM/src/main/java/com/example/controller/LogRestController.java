package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Log;
import com.example.service.LogService;

@RestController
public class LogRestController {
	@Autowired
	private LogService logService;
	
	
	@RequestMapping(value = "/api/logs", method = RequestMethod.GET)
	public ResponseEntity<List<Log>> getLogs(Pageable page) {
			Page<Log> logs = logService.findAll(page);
			List<Log> log_ret= new ArrayList<Log>();
			for (Log log : logs) {
				log_ret.add(log);
				System.out.println(log.toString());
			}
			return new ResponseEntity<>(log_ret, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/logs", method = RequestMethod.POST)
    public ResponseEntity<List<Log>> getLogsSearch(@RequestBody String search) {
			List<Log> logs = logService.findAllBySearch(search);
			return new ResponseEntity<>(logs, HttpStatus.OK);
    }
}
