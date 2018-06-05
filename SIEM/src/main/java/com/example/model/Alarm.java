package com.example.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Alarm {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String description;
	
	private int seconds;
	private int number;
	
	private int prival;                // priority value
	private int version;               // version -- 1
	private String timestamp;          // time stamp
	private String hostname;           // host name
	private String appname;            // app name
	private String procid;             // procid
	private String msgid;              // message id
	private String sd;                 // structured data
	private String msg;     
	
	private boolean canDelete;
	
	public Alarm(Long id, String name, String description, int seconds, int number, int prival, int version,
			String timestamp, String hostname, String appname, String procid, String msgid, String sd, String msg,
			Set<Log> logs, boolean canDelete) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.seconds = seconds;
		this.number = number;
		this.prival = prival;
		this.version = version;
		this.timestamp = timestamp;
		this.hostname = hostname;
		this.appname = appname;
		this.procid = procid;
		this.msgid = msgid;
		this.sd = sd;
		this.msg = msg;
		this.logs = logs;
		this.canDelete= canDelete;
	}
	

	public Alarm(Long id, String name, String description, int seconds, int number, int prival, int version,
			String timestamp, String hostname, String appname, String procid, String msgid, String sd, String msg,
			 boolean canDelete) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.seconds = seconds;
		this.number = number;
		this.prival = prival;
		this.version = version;
		this.timestamp = timestamp;
		this.hostname = hostname;
		this.appname = appname;
		this.procid = procid;
		this.msgid = msgid;
		this.sd = sd;
		this.msg = msg;
		this.logs = new HashSet<Log>();
		this.canDelete= canDelete;
	}

	public Alarm(Long id, String name, String description, int seconds, int number, int prival, int version,
			String timestamp, String hostname, String appname, String procid, String msgid, String sd, String msg,
			Set<Log> logs) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.seconds = seconds;
		this.number = number;
		this.prival = prival;
		this.version = version;
		this.timestamp = timestamp;
		this.hostname = hostname;
		this.appname = appname;
		this.procid = procid;
		this.msgid = msgid;
		this.sd = sd;
		this.msg = msg;
		this.logs = logs;
		this.canDelete= true;
	}
	
	public Alarm() {
		super();
	}
	
	
	
	public boolean isCanDelete() {
		return canDelete;
	}

	public void setCanDelete(boolean canDelete) {
		this.canDelete = canDelete;
	}

	public int getSeconds() {
		return seconds;
	}


	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Log> logs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrival() {
		return prival;
	}

	public void setPrival(int prival) {
		this.prival = prival;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getProcid() {
		return procid;
	}

	public void setProcid(String procid) {
		this.procid = procid;
	}

	public String getMsgid() {
		return msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	public String getSd() {
		return sd;
	}

	public void setSd(String sd) {
		this.sd = sd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Set<Log> getLogs() {
		return logs;
	}

	public void setLogs(Set<Log> logs) {
		this.logs = logs;
	}

	@Override
	public String toString() {
		return "Alarm [id=" + id + ", name=" + name + ", description=" + description + ", prival=" + prival
				+ ", version=" + version + ", timestamp=" + timestamp + ", hostname=" + hostname + ", appname="
				+ appname + ", procid=" + procid + ", msgid=" + msgid + ", sd=" + sd + ", msg=" + msg + ", logs=" + logs
				+ "]";
	} 
	
	
}
