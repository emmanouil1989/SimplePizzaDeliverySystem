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
public class Bill {

    private int PizzaPrice;

    public Bill(int PizzaPrice) {
        this.PizzaPrice = PizzaPrice;

    }

    public int getPizzaPrice() {
        return PizzaPrice;
    }

    public void setPizzaPrice(int pizzaprice) {
        PizzaPrice = pizzaprice;
    }

    public int addBill(int price) {
        price = PizzaPrice;
        return price;

    }

  
}
