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
}
