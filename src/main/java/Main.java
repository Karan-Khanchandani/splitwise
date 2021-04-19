import inputparser.InputParser;
import repository.IExpenseRepository;
import repository.InMemoryExpenseRepository;
import service.ExpenseService;
import service.IExpenseService;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IExpenseRepository expenseRepository = new InMemoryExpenseRepository();
        IExpenseService expenseService = new ExpenseService(expenseRepository);

        InputParser ip = new InputParser(expenseService);
        String input;
        while(true){
            input = sc.nextLine();
            if(input.equalsIgnoreCase("exit"))break;
            ip.parse(input);
        }
    }
}
