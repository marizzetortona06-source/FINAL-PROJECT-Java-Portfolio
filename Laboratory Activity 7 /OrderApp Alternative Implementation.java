package com.store.main;
import com.store.order.*;
import com.store.payment.Payable;
import java.util.ArrayList;
import java.util.Iterator;

class OrderApp {
    public static void main(String[] args) {
        ArrayList<Order> orderList = new ArrayList<>();
        
        OnlineOrder 1storder = new OnlineOrder(10001, 650.00);
        OnlineOrder 2ndOrder = new OnlineOrder(10002, 1350.65);
        OnlineOrder 3rdOrder = new OnlineOrder(10003, 500.25);
        
        orderList.add(1stOrder);
        orderList.add(2ndOrder);
        orderList.add(3rdOrder);
        
        System.out.println("\n - - ORDER LIST - - ");
        
        for (Order currentOrder : orderList) {
            currentOrder.processOrder();
            System.out.println(currentOrder.getOrderSummary());
        }
        
        firstOrder.pay();
        thirdOrder.pay();
        
        System.out.println("\n - - FINAL LIST - -");
        
        Iterator<Order> iterator = orderList.iterator();
        while (iterator.hasNext()) {
            Order currentOrder = iterator.next();
            
            if (currentOrder.getStatus() == OrderStatus.CANCELLED) {
                iterator.remove();
                continue;
            }
            
            System.out.println(currentOrder.getOrderSummary());
        }
    }
}
