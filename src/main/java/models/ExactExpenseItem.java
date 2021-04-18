package models;

import java.util.Date;

public class ExactExpenseItem extends ExpenseItem{
    Integer id;
    Integer payerId;
    Integer payeeId;
    Integer exactAmount;
    Date createdAt;
    Date updatedAt;
    boolean deleted;

    public ExactExpenseItem(Integer payerId, Integer payeeId, Integer exactAmount) {
        this.id = 1; //this should be random
        this.payerId = payerId;
        this.payeeId = payeeId;
        this.exactAmount = exactAmount;
    }

    @Override
    Integer getAmount() {
        return exactAmount;
    }
}
