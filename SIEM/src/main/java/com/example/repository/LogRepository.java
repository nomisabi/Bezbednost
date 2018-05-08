package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Log;

public interface LogRepository extends JpaRepository<Log, Long> {

	List<Log> findByPrival(int prival);
	
	List<Log> findByPrivalLessThan(int prival);
	
	List<Log> findByPrivalLessThanEqual(int prival);
	
	List<Log> findByPrivalGreaterThan(int prival);
	
	List<Log> findByPrivalGreaterThanEqual(int prival);
	
	List<Log> findByVersion(int Version);
	
	List<Log> findByVersionLessThan(int version);
	
	List<Log> findByVersionLessThanEqual(int version);
	
	List<Log> findByVersionGreaterThan(int version);
	
	List<Log> findByVersionGreaterThanEqual(int version);
	
	List<Log> findByTimestamp(String timestamp);
	
	List<Log> findByTimestampContaining(String timestamp);
	
	List<Log> findByHostname(String hostname);
	
	List<Log> findByAppnameContaining(String appname);
	
	List<Log> findByHostnameContaining(String hostname);
	
	List<Log> findByAppname(String appname);
	
	List<Log> findByProcid(String procid);
	
	List<Log> findByMsgid(String msgid);

	List<Log> findBySd(String sd);
	
	List<Log> findByMsgContaining(String msg);
	
	List<Log> findBySdContaining(String sd);
	
	List<Log> findByMsg(String msg);


}
