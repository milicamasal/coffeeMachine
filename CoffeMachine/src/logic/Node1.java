/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import domain.Currency;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author student1
 */
public class Node1 extends Node {

    @Override
    public void getCurrency(Currency currency, Map<String, Integer> map) {
        int currentState1 = machineState.getMap().get("1");
        if (currency.getAmount() >= 1 && currentState1> 0) {
            if(currentState1>= currency.getAmount()){
            map.put("1", currency.getAmount());
             machineState.getMap().put("1", currentState1-currency.getAmount());       
                    }else{
            map.put("1", currentState1);
                JOptionPane.showMessageDialog(null,"Not enough money!");
            }
        } else {if(currentState1==0){ JOptionPane.showMessageDialog(null,"Not enough money!");}
            map.put("1", 0);
        }
    }

}/* int currentState20 = machineState.getMap().get("20");
          if (currency.getAmount() >= 20 && currentState20> 0) {
            int a = currency.getAmount() / 20;
            int b = currency.getAmount() % 20;
            if (a < currentState20) {
                map.put("20", a);
                machineState.getMap().put("20", currentState20-a);
            } else {
                map.put("20", currentState20);
                b+= (a-currentState20)*100;
                 machineState.getMap().put("20", 0);
            }
            if (b != 0 && next != null) {
                next.getCurrency(new Currency(b), map);
            }
        }*/
