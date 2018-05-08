package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	public Page<Log> findAll(Pageable page) {
		return logRepository.findAll(page);
	}

	public Page<Log> findAllBySearch(Pageable page, String search) {
		return logRepository.findAll(page);
	}
	
	private List<Log> findList(String par){
		if (par.contains("version")) {
			if (par.contains("<=")) {
				String[] pieces= par.split("<=");
				int v= Integer.parseInt(pieces[1]);
				return logRepository.findByVersionLessThanEqual(v);
			} else if (par.contains(">=")) {
				String[] pieces= par.split(">=");
				int v= Integer.parseInt(pieces[1]);
				return logRepository.findByVersionGreaterThanEqual(v);
			}  else if (par.contains(">")) {
				String[] pieces= par.split(">");
				int v= Integer.parseInt(pieces[1]);
				return logRepository.findByVersionGreaterThan(v);
			} else if (par.contains("<")) {
				String[] pieces= par.split("<");
				int v= Integer.parseInt(pieces[1]);
				return logRepository.findByVersionLessThan(v);
			} else if (par.contains("=")) {
				String[] pieces= par.split("=");
				int v= Integer.parseInt(pieces[1]);
				return logRepository.findByVersion(v);
			}				
		} else if (par.contains("prival")) {
			if (par.contains("<=")) {
				String[] pieces= par.split("<=");
				int v= Integer.parseInt(pieces[1]);
				return logRepository.findByPrivalLessThanEqual(v);
			} else if (par.contains(">=")) {
				String[] pieces= par.split(">=");
				int v= Integer.parseInt(pieces[1]);
				return logRepository.findByPrivalGreaterThanEqual(v);
			}  else if (par.contains(">")) {
				String[] pieces= par.split(">");
				int v= Integer.parseInt(pieces[1]);
				return logRepository.findByPrivalGreaterThan(v);
			} else if (par.contains("<")) {
				String[] pieces= par.split("<");
				int v= Integer.parseInt(pieces[1]);
				return logRepository.findByPrivalLessThan(v);
			} else if (par.contains("=")) {
				String[] pieces= par.split("=");
				int v= Integer.parseInt(pieces[1]);
				return logRepository.findByPrival(v);
			}				
		} 
			
		 else if (par.contains("hostname")) {
			 if (par.contains("=")) {
					String[] pieces= par.split("=");
					pieces= pieces[1].split("\"");
					return logRepository.findByHostname(pieces[1]);
				} else
				if (par.contains("in")) {
					String[] pieces= par.split("in");
					pieces= pieces[0].split("\"");
					return logRepository.findByHostnameContaining(pieces[1]);
				}
			
		}else if (par.contains("appname")) {
			if (par.contains("=")) {
				String[] pieces= par.split("=");
				pieces= pieces[1].split("\"");
				return logRepository.findByAppname(pieces[1]);
			}
			else 
				if (par.contains("in")) {
					String[] pieces= par.split("in");
					pieces= pieces[0].split("\"");
					return logRepository.findByAppnameContaining(pieces[1]);
				} 
				
			}
		else  if (par.contains("timestamp")) {
			if (par.contains("=")) {
				String[] pieces= par.split("=");
				pieces= pieces[1].split("\"");
				return logRepository.findByTimestamp(pieces[1]);
			}
			 else
					if (par.contains("in")) {
						String[] pieces= par.split("in");
						pieces= pieces[0].split("\"");
						return logRepository.findByTimestampContaining(pieces[1]);
					}
				
			}
			else
				if (par.contains("procid")) {
					if (par.contains("=")) {
						String[] pieces= par.split("=");
						pieces= pieces[1].split("\"");
						return logRepository.findByProcid(pieces[1]);
					}
					
				}
			else
				if (par.contains("msgid")) {
						if (par.contains("=")) {
							String[] pieces= par.split("=");
							pieces= pieces[1].split("\"");
							return logRepository.findByMsgid(pieces[1]);
				}
						
			}else  if (par.contains("sd")) {
				if (par.contains("=")) {
					String[] pieces= par.split("=");
					pieces= pieces[1].split("\"");
					return logRepository.findBySd(pieces[1]);
				}
				 else
						if (par.contains("in")) {
							String[] pieces= par.split("in");
							pieces= pieces[0].split("\"");
							return logRepository.findBySdContaining(pieces[1]);
						}
					
				}else if (par.contains("msg")) {
								if (par.contains("=")) {
									String[] pieces= par.split("=");
									pieces= pieces[1].split("\"");
									return logRepository.findByMsg(pieces[1]);
									} else
								if (par.contains("in")) {
									String[] pieces= par.split("in");
									pieces= pieces[0].split("\"");
									return logRepository.findByMsgContaining(pieces[0]);
						}
						
					}
		
		return new ArrayList<Log>();
	}
	
	private List<String> mixString(String[] pieces) {
		ArrayList<String> list= new ArrayList<String>();
		String add="";
		int x=0;
		boolean start=false;
		for (String string : pieces) {
			int count = org.springframework.util.StringUtils.countOccurrencesOf(string, "\"");
			if (start) {
				if (count==0) {
					add=add+" "+string;
				} else if (count==1 && string.endsWith("\""))  {
					add=add+" "+string;
					list.add(add);
					add="";
					start=false;
				} else {
					System.out.println("error");
				}
				if (x==1) {
					x++;
				} else if (x==2) {
					list.add(add);
					add="";
					start=false;
				}
			} else {
				if (count==0) 
					list.add(string); 
				else if (count==1) {
					start=true;
					add=string;
					
				} else if (count==1) {
					start=true;
					add=string;
				} else if (count==2) {
					start=true;
					add=string;
					x++;
				}
				else
					System.out.println("error");
			}
		}
		
		return list;
	}
	
private List<Log> union(List<Log> original, List<Log> or){
		for (Log log : or) {
			if (!original.contains(log)) {
				original.add(log);
			}
		}
		return original;
	}
	
	private List<Log> section(List<Log> original, List<Log> and){
		List<Log> ret= new ArrayList<Log>();
		for (Log log : and) {
			if (original.contains(log)) {
				ret.add(log);
			}
		}
		return ret;
	}
	
	public List<Log> findAllBySearch(String search) {
		List<Log> logs = new ArrayList<Log>();
		
		String[] pieces= search.split(" ");
		ArrayList<String> parts= (ArrayList<String>) mixString(pieces);
		String mod="";
		while (parts.size()!=0) {
		if (mod.equals(""))
			if (parts.get(0).equals("and")) {
				mod="and";
				parts.remove(0);
				continue;
			}else if (parts.get(0).equals("or")) {
				mod="or";
				parts.remove(0);
				continue;
			} else {
				logs= findList(parts.get(0));
				parts.remove(0);
			}
		else if (mod.equals("and")) {
			ArrayList<Log> and= (ArrayList<Log>) findList(parts.get(0));
			logs=section(logs, and);
			parts.remove(0);
			mod="";
		} else if (mod.equals("or")) {
			
			ArrayList<Log> or= (ArrayList<Log>) findList(parts.get(0));
			logs=union(logs, or);
			parts.remove(0);
			mod="";
		}
		}
			
		
		return logs;
	}


}
