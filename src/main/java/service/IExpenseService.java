package service;

import models.Expense;
import models.ExpenseItem;

import java.util.List;

public interface IExpenseService {
    List<ExpenseItem> show() throws Exception;
    List<ExpenseItem> show(Integer userId) throws Exception;
    void addExpense(Expense expense) throws Exception;
}
