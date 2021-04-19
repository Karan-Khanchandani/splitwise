package commands;

import exceptions.InvalidInputException;
import models.ExpenseItem;
import service.IExpenseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowCommand extends Command {
    private IExpenseService expenseService;
    private String[] inputs;

    public ShowCommand(IExpenseService expenseService, String[] inputs) {
        this.expenseService = expenseService;
        this.inputs = inputs;
    }

    @Override
    public void execute() throws Exception {
        List<ExpenseItem> expenseItems;
        if(inputs.length > 1) {
            throw new InvalidInputException();
        }
        if(inputs.length == 0){
            expenseItems = expenseService.show();
        }else {
            expenseItems = expenseService.show(Integer.parseInt(inputs[0]));
        }

        if(expenseItems == null ||  expenseItems.size() == 0){
            System.out.println("No balances");
            return;
        }

        Map<String, Integer> amtMap = new HashMap<>();
        for(ExpenseItem e : expenseItems){
            Integer payer = e.getPayerId();
            Integer payee = e.getPayeeId();
            Integer amt = e.getAmount();
            if(!payer.equals(payee)){
                String key = payer + "-" + payee;
                String revKey = payee + "-" + payer;

                if(!amtMap.containsKey(key)){
                    amtMap.put(key, 0);
                }

                if(amtMap.containsKey(revKey)){
                    simplifyCalculations(amtMap, amt, key, revKey);
                }else{
                    amtMap.put(key, amtMap.get(key) + amt);
                }
            }
        }

        for(Map.Entry<String, Integer> entry: amtMap.entrySet()){
            String key = entry.getKey();
            String[] sp = key.split("-");
            System.out.printf("User%s owes User%s: %d\n", sp[1], sp[0], entry.getValue());
        }
    }

    private void simplifyCalculations(Map<String, Integer> amtMap, Integer amt, String key, String revKey) {
        Integer revAmt = amtMap.get(revKey);
        if(amt == revAmt){
            amtMap.remove(revKey);
            amtMap.remove(key);
        }else if(amt > revAmt){
            amtMap.remove(revKey);
            amtMap.put(key, amtMap.get(key) + amt - revAmt);
        }else{
            amtMap.remove(key);
            amtMap.put(revKey, amtMap.get(revKey) + revAmt - amt);
        }
    }
}
