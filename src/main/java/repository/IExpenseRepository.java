package repository;

import models.Expense;
import models.ExpenseItem;

import java.util.List;

public interface IExpenseRepository {
    List<ExpenseItem> getAll() throws Exception;
    List<ExpenseItem> getByUserId(Integer userId) throws Exception;
    void addExpense(Expense expense) throws Exception;
}
