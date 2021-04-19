package models;

import java.util.Date;

public class EqualExpenseItem extends ExpenseItem {
    Integer numberOfPeople;
    Integer totalAmount;

    public EqualExpenseItem(Integer payerId, Integer payeeId, Integer numberOfPeople, Integer totalAmount) {
        super(1, payerId, payeeId);
        this.numberOfPeople = numberOfPeople;
        this.totalAmount = totalAmount;
    }

    @Override
    public Integer getAmount() {
        return totalAmount/numberOfPeople;
    }
}
