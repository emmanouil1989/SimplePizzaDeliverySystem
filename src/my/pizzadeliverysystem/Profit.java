/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.pizzadeliverysystem;

/**
 *
 * @author 14056682
 */
public class Profit {

    private int TotalBills;

    public Profit() {
        

    }

    public int getTotalBills() {
        return TotalBills;
    }

    public void setTotalBills(int totalbills) {
        TotalBills = totalbills;
    }



    public void addProfit(int money) {
         TotalBills = TotalBills + money;
    }

    public int resetProfit() {
       return  TotalBills = 0;

    }


}
