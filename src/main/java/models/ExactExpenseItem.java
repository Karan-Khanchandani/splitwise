package models;

import java.util.Date;

public class ExactExpenseItem extends ExpenseItem{
    Integer exactAmount;

    public ExactExpenseItem(Integer payerId, Integer payeeId, Integer exactAmount) {
        super(1, payerId, payeeId);
        this.exactAmount = exactAmount;
    }

    @Override
    public Integer getAmount() {
        return exactAmount;
    }
}
