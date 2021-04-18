package commands;

import exceptions.InvalidInputException;
import models.ExpenseItem;
import service.IExpenseService;

import java.util.List;

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
            expenseItems = expenseService.show();
        }
    }
}
