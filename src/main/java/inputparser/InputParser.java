package inputparser;

import commands.ExpenseCommand;
import commands.ShowCommand;
import service.IExpenseService;

public class InputParser {
    private IExpenseService expenseService;

    public InputParser(IExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    public void parse(String input){
        String[] sp = input.split(" ");
        if(sp.length == 0){
            System.out.println("Invalid input");
            return;
        }
        String command = sp[0];
        String[] inputs = new String[sp.length - 1];
        for(int i = 1; i < sp.length; i++){
            inputs[i-1] = sp[i];
        }
        if(command.equals("SHOW")){
            try {
                new ShowCommand(expenseService, inputs).execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (command.equals("EXPENSE")){
            try {
                new ExpenseCommand(expenseService, inputs).execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
