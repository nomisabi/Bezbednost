package com.example.model;

import java.util.Comparator;
import java.util.Date;
import java.util.Map;

public class ValueComparator implements Comparator<Log> {

    private Map<Log, Date> map;

    public ValueComparator(Map<Log, Date> map) {
        this.map = map;
    }

    public int compare(Log a, Log b) {
    		if ((map.get(a).getTime()-map.get(b).getTime())>=0) 
    			return 1;
    		else if  ((map.get(a).getTime()-map.get(b).getTime())<0) 
    			return -1;
        return 0;
    }
}