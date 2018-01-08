package tema8;

class Customer
{
    private int customerID;
    private int transactionTime;
    private int arrivalTime;

    Customer()
    {
        this(1,1,1);
    }

    Customer(int customerid, int transactionduration, int arrivaltime)
    {
        customerID = customerid;
        transactionTime = transactionduration;
        arrivalTime = arrivaltime;
    }

    int getTransactionTime()
    {
        return transactionTime;
    }

    int getArrivalTime()
    {
        return arrivalTime;
    }

    int getCustomerID()
    {
        return customerID;
    }

    public String toString()
    {
        return ""+customerID+":"+transactionTime+":"+arrivalTime;
    }
}

