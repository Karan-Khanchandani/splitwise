package service;

import models.Expense;
import models.ExpenseItem;

import java.util.List;

public class ExpenseService implements IExpenseService{

    public ExpenseService() {
    }

    @Override
    public List<ExpenseItem> show() throws Exception {
        System.out.println("Executing show in expense service");
        return null;
    }

    @Override
    public List<ExpenseItem> show(Integer userId) throws Exception {
        return null;
    }

    @Override
    public void addExpense(Expense expense) throws Exception {

    }
}
