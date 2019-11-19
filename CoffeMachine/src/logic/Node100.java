/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import domain.Currency;
import java.util.Map;

/**
 *
 * @author student1
 */
public class Node100 extends Node {

    @Override
    public void getCurrency(Currency currency, Map<String, Integer> map) {
        int currentState100 = machineState.getMap().get("100");
        if (currency.getAmount() >= 100 && currentState100> 0) {
            int a = currency.getAmount() / 100;
            int b = currency.getAmount() % 100;
            if (a <= currentState100) {
                map.put("100", a);
                machineState.getMap().put("100", currentState100-a);
            } else {
                map.put("100", currentState100);
                b+= (a-currentState100)*100;
                 machineState.getMap().put("100", 0);
            }
            if (b != 0 && next != null) {
                next.getCurrency(new Currency(b), map);
            }
        } else {
            map.put("100", 0);
            if (next != null) {
                next.getCurrency(currency, map);
            }
        }
    }

}
