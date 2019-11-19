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
public class Node50 extends Node {

    @Override
    public void getCurrency(Currency currency, Map<String, Integer> map) {
       int currentState50 = machineState.getMap().get("50");
          if (currency.getAmount() >= 50 && currentState50> 0) {
            int a = currency.getAmount() / 50;
            int b = currency.getAmount() % 50;
            if (a <= currentState50) {
                map.put("50", a);
                machineState.getMap().put("50", currentState50-a);
            } else {
                map.put("50", currentState50);
                b+= (a-currentState50)*50;
                 machineState.getMap().put("50", 0);
            }
            if (b != 0 && next != null) {
                next.getCurrency(new Currency(b), map);
            }
        } else {
            map.put("50", 0);
            if (next != null) {
                next.getCurrency(currency, map);
            }
        }
    }

}
