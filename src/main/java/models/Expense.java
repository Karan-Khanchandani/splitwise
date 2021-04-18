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
}
