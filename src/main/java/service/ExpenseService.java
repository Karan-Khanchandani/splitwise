package service;

import exceptions.InvalidExpenseException;
import models.Expense;
import models.ExpenseItem;
import repository.IExpenseRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseService implements IExpenseService{

    private IExpenseRepository expenseRepository;

    public ExpenseService() {
    }

    public ExpenseService(IExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public List<ExpenseItem> show() throws Exception {
        return expenseRepository.getAll();
    }

    @Override
    public List<ExpenseItem> show(Integer userId) throws Exception {
        return expenseRepository.getByUserId(userId);
    }

    @Override
    public void addExpense(Expense expense) throws Exception {
        if(!expense.isValid()){
            throw new InvalidExpenseException();
        }
        expenseRepository.addExpense(expense);
    }
}
