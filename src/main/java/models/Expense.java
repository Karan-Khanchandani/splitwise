package models;

import java.util.Date;
import java.util.List;

public class Expense {
    Integer id;
    String description;
    Integer totalAmount;
    Date createdAt;
    Date updatedAt;
    boolean deleted;
    List<ExpenseItem> expenseItems;

    public Expense(String description, Integer totalAmount, List<ExpenseItem> expenseItems) {
        this.id = id;
        this.description = description;
        this.totalAmount = totalAmount;
        this.expenseItems = expenseItems;
    }

    public boolean isValid(){
        Integer expSum = 0;
        for(ExpenseItem exp: expenseItems){
            expSum += exp.getAmount();
        }
        return totalAmount.equals(expSum);
    }
}
