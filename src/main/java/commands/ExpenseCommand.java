package commands;

import exceptions.InvalidExpenseTypeException;
import models.*;
import service.IExpenseService;

import java.util.ArrayList;
import java.util.List;

public class ExpenseCommand extends Command {
    private IExpenseService expenseService;
    private String[] inputs;

    public ExpenseCommand(IExpenseService expenseService, String[] inputs) {
        this.expenseService = expenseService;
        this.inputs = inputs;
    }
    @Override
    public void execute() throws Exception {
        Integer payerId = Integer.parseInt(inputs[0]);
        Integer totalAmt = Integer.parseInt(inputs[1]);
        Integer numberOfParticipants = Integer.parseInt(inputs[2]);
        List<Integer> participants = new ArrayList<>();
        for(int i = 0; i < numberOfParticipants; i++){
            participants.add(Integer.parseInt(inputs[3+i]));
        }
        List<ExpenseItem> expenseItems = new ArrayList<>();
        String expenseType = inputs[3 + numberOfParticipants];
        if(expenseType.equals("EQUAL")){
            for(Integer payee: participants) {
                expenseItems.add(new EqualExpenseItem(payerId, payee, numberOfParticipants, totalAmt));
            }
        }else if(expenseType.equals("EXACT")){
            for(int i = 0; i < participants.size(); i++){
                Integer exactAmt = Integer.parseInt(inputs[4 + numberOfParticipants + i]);
                expenseItems.add(new ExactExpenseItem(payerId, participants.get(i), exactAmt));
            }
        }else if (expenseType.equals("PERCENT")){
            for(int i = 0; i < participants.size(); i++){
                Integer exactAmt = Integer.parseInt(inputs[4 + numberOfParticipants + i]);
                expenseItems.add(new PercentExpenseItem(payerId, participants.get(i),totalAmt, exactAmt));
            }
        }else {
            throw new InvalidExpenseTypeException();
        }
        Expense expense = new Expense("sample expense", totalAmt, expenseItems);
        expenseService.addExpense(expense);
    }
}
