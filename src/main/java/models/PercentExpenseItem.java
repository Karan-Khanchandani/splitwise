package models;

import java.util.Date;

public class PercentExpenseItem extends ExpenseItem{
    Integer id;
    Integer payerId;
    Integer payeeId;
    Integer percent;
    Integer totalAmount;
    Date createdAt;
    Date updatedAt;
    boolean deleted;

    public PercentExpenseItem(Integer payerId, Integer payeeId, Integer totalAmount, Integer percent) {
        this.payerId = payerId;
        this.payeeId = payeeId;
        this.percent = percent;
        this.totalAmount = totalAmount;
    }

    @Override
    Integer getAmount() {
        return totalAmount*percent/100;
    }
}
