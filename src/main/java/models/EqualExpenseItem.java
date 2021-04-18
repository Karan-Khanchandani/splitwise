package models;

import java.util.Date;

public class EqualExpenseItem extends ExpenseItem {
    Integer id;
    Integer payerId;
    Integer payeeId;
    Integer numberOfPeople;
    Integer totalAmount;
    Date createdAt;
    Date updatedAt;
    boolean deleted;

    public EqualExpenseItem(Integer id, Integer payerId, Integer payeeId, Integer numberOfPeople, Integer totalAmount) {
        this.id = id;
        this.payerId = payerId;
        this.payeeId = payeeId;
        this.numberOfPeople = numberOfPeople;
        this.totalAmount = totalAmount;
    }

    @Override
    Integer getAmount() {
        return totalAmount/numberOfPeople;
    }
}
