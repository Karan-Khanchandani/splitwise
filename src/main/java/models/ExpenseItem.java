package models;

import java.util.Date;

public abstract class ExpenseItem {
    Integer id;
    Integer payerId;
    Integer payeeId;
    Date createdAt;
    Date updatedAt;
    boolean deleted;

    public ExpenseItem(Integer id, Integer payerId, Integer payeeId) {
        this.id = id;
        this.payerId = payerId;
        this.payeeId = payeeId;
    }

    public abstract Integer getAmount();

    public Integer getPayerId() {
        return payerId;
    }

    public Integer getPayeeId() {
        return payeeId;
    }
}
