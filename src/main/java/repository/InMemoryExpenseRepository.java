package repository;

import models.Expense;
import models.ExpenseItem;

import java.util.*;

public class InMemoryExpenseRepository implements IExpenseRepository{
    Map<Integer, List<ExpenseItem>> ownMap;
    Map<Integer, List<ExpenseItem>> owesMap;

    public InMemoryExpenseRepository() {
        ownMap = new HashMap<>();
        owesMap = new HashMap<>();
    }

    @Override
    public List<ExpenseItem> getAll() throws Exception {
        List<ExpenseItem> res = new ArrayList<>();
        for(Map.Entry<Integer, List<ExpenseItem>> entry: owesMap.entrySet()){
            res.addAll(entry.getValue());
        }
        return res;
    }

    @Override
    public List<ExpenseItem> getByUserId(Integer userId) throws Exception {
        List<ExpenseItem> res = new ArrayList<>();
        if(owesMap.containsKey(userId)){
            res.addAll(owesMap.get(userId));
        }
        if(ownMap.containsKey(userId)){
            res.addAll(ownMap.get(userId));
        }
        return res;
    }

    @Override
    public void addExpense(Expense expense) throws Exception {
        for(ExpenseItem expenseItem : expense.getExpenseItems()){
            Integer payer = expenseItem.getPayerId();
            Integer payee = expenseItem.getPayeeId();

            if(!ownMap.containsKey(payee)){
                ownMap.put(payee, new ArrayList<>());
            }
            List<ExpenseItem> ee = ownMap.get(payee);
            ee.add(expenseItem);
            ownMap.put(payee, ee);

            if(!owesMap.containsKey(payer)){
                owesMap.put(payer, new ArrayList<>());
            }
            List<ExpenseItem> ee1 = owesMap.get(payer);
            ee1.add(expenseItem);
            owesMap.put(payer, ee1);
        }
    }
}
