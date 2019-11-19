/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Milica i Nikola
 */
public class MachineState {

   

    private Map<String, Integer> map ;
    private static  MachineState instance = null;

    private MachineState() {
        map = new HashMap() {
                {
                    put("100", 10);
                    put("50", 10);
                    put("20", 10);
                    put("1", 20);
                }
            };
    }

    public static MachineState getInstance() {
        if (instance == null) {
            instance = new MachineState();
        }
        return instance;
    }
 public Map<String, Integer> getMap() {
        return map;
    }
    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

}
