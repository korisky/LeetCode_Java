package Extras.ConcurrencyStuff.CinemaExample;

public class Customer {
    private int customerId;
    private Ticket ticket;

    public Customer(int customerId) {
        this.customerId = customerId;
    }

    public void buyTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", ticket=" + ticket +
                '}';
    }
}
