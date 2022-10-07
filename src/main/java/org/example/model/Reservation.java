package org.example.model;

import java.time.LocalDate;

public class Reservation {
    private String custId;
    private String custName;
    private int numOfGuests;

    private LocalDate date;

    public Reservation(String custName, int numOfGuests,LocalDate date) {
        this.custName = custName;
        this.numOfGuests = numOfGuests;
        this.date = date;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public int getNumOfGuests() {
        return numOfGuests;
    }

    public void setNumOfGuests(int numOfGuests) {
        this.numOfGuests = numOfGuests;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }



    public String toString() {
        return String.format("Booking for %d persons for name : %s is confirmed" , numOfGuests, custName);
    }
}
