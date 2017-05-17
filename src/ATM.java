/* This class provides an basic implementation for ATM, it has a functionality
 * to store some bills in different currency denomination e.g. 100$, 50$. 
 * When user requests an amount, requested amount is dispersed using all bills
 * available.
 * If amount cannot be dispersed with one type bill entirely, different bills are
 * used e.g. 152$ can be given as 100 + 50 + 2 OR 50*2 + 20*2 + 10 + 2. This is
 * decided on how many bill as available.
 * If amount cannot be dispersed, user is shown an error message. 
 */
//package uber.round1;

import java.util.HashMap;
import java.util.Map.Entry;

public class ATM {
    private static HashMap<Integer, Integer> currencyBreakage;
    private static HashMap<Integer, Integer> currencyStore;
    private static int factors[] = {100,50,20,10,5,2};

    public static void init() {
        currencyStore = new HashMap<>();
        currencyStore.put(100, 10);
        currencyStore.put(50, 10);
        currencyStore.put(20, 10);
        currencyStore.put(10, 10);
        currencyStore.put(5, 10);
        currencyStore.put(2, 10);
    }

    private static int populateAmntForDispensing(int amount, int factor){
        int bills = 0;
        bills = amount / factor;
        int availableBills = currencyStore.get(factor);
        if( bills > availableBills){                
            currencyBreakage.put(factor, availableBills);
            amount = amount - (factor * availableBills);
            //currencyStore.put(factor, 0);
            // Problem is here, because even if the final amount cannot be dispensed, it is still reducing amount
            // So reduction should happen only when amount is dispensed.
        }else{
            currencyBreakage.put(factor, bills);
            amount = amount % factor;
            //currencyStore.put(factor, availableBills - bills);
        }
        return amount;
    }

    public static void dispense(int amount){
        currencyBreakage = new HashMap<>();
        System.out.println("Requested: " +amount);
        for(int i=0;i<factors.length;i++){
            amount = populateAmntForDispensing(amount, factors[i]);
        }
        if(amount>0){
            System.out.println("!!! Amount can not dispensed currently, please choose different amount. !!!");
        }else{
            System.out.println("##########");
            System.out.println("Dispensing");
            System.out.println("##########");
            for (Entry<Integer, Integer> entry : currencyBreakage.entrySet()) {
                System.out.println(entry.getKey() + "$ bills: " + entry.getValue());
                // Now reduce the same number from currency store
                currencyStore.put(entry.getKey(),currencyStore.get(entry.getKey()) - entry.getValue());
            }
        }
        currencyBreakage.clear();
    }

    public static void status(){
        System.out.println("########################");
        System.out.println("Bills availablity status");
        System.out.println("########################");
        for (Entry<Integer, Integer> entry : currencyStore.entrySet()) {
            System.out.println(entry.getKey() + "$ bills available: " + entry.getValue());
        }        
    }

    public static void main(String args[]){
        init();
        dispense(687);
        dispense(687);
        dispense(786);
        dispense(47);
        status();
    }
}
