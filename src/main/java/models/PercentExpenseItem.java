package models;

import java.util.Date;

public class PercentExpenseItem extends ExpenseItem{
    Integer percent;
    Integer totalAmount;

    public PercentExpenseItem(Integer payerId, Integer payeeId, Integer totalAmount, Integer percent) {
        super(1, payerId, payeeId);
        this.percent = percent;
        this.totalAmount = totalAmount;
    }

    @Override
    public Integer getAmount() {
        return totalAmount*percent/100;
    }
}
