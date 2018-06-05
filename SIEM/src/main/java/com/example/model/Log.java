package com.example.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Log {
	@Id
	@GeneratedValue
	private Long id;
	
	private int prival;                // priority value
	private int version;               // version -- 1
	private String timestamp;          // time stamp
	private String hostname;           // host name
	private String appname;            // app name
	private String procid;             // procid
	private String msgid;              // message id
	private String sd;                 // structured data
	private String msg;                // message

	public Log() {

	}

	public Log(int prival, int version, String timestamp, String hostname, String appname, String procid, String msgid,
			String sd, String msg) {
		super();
		this.prival = prival;
		this.version = version;
		this.timestamp = timestamp;
		this.hostname = hostname;
		this.appname = appname;
		this.procid = procid;
		this.msgid = msgid;
		this.sd = sd;
		this.msg = msg;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Log [id=" + id + ", prival=" + prival + ", version=" + version + ", timestamp=" + timestamp
				+ ", hostname=" + hostname + ", appname=" + appname + ", procid=" + procid + ", msgid=" + msgid
				+ ", sd=" + sd + ", msg=" + msg + "]";
	}
	
	

}
