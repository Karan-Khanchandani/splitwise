import inputparser.InputParser;
import service.ExpenseService;
import service.IExpenseService;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IExpenseService expenseService = new ExpenseService();

        InputParser ip = new InputParser(expenseService);
        String input;
        while(true){
            input = sc.next();
            if(input.equalsIgnoreCase("exit"))break;
            ip.parse(input);
        }
    }
}
