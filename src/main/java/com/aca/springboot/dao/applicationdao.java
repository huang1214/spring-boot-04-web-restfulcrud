package com.aca.springboot.dao;

import com.aca.springboot.entities.application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class applicationdao {

    private static Map<Integer, application> applications = null;

    static {
        applications = new HashMap<Integer, application>();
        applications.put(1,new application("1","1","1",
                        "1","1","1","1","1","1"));
        applications.put(2,new application("2","2","2",
                "2","2","2","2","2","2"));
    }

    public Collection<application> getAll(){
        return applications.values();
    }
}
