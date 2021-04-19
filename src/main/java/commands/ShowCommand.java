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
        System.out.println("Executing show command");
        if(inputs.length == 0){
            expenseItems = expenseService.show();
        }else {
            expenseItems = expenseService.show(Integer.parseInt(inputs[1]));
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
                if(!amtMap.containsKey(key)){
                    amtMap.put(key, 0);
                }
                amtMap.put(key, amtMap.get(key) + amt);
            }
        }
        for(Map.Entry<String, Integer> entry: amtMap.entrySet()){
            String key = entry.getKey();
            String[] sp = key.split("-");
            System.out.printf("User%s owes User%s: %d", sp[0], sp[1], entry.getValue());
        }
    }
}
