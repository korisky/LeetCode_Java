package Extras.ConcurrencyStuff.CinemaExample;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TicketSingle {
    private static final String ROOM = "Central Vedio hall";
    private static final int Row = 20;
    private static final int Col = 10;
    private static final String FIlM_NAME = "RED";
    private static final BigDecimal PRICE = BigDecimal.valueOf(30);

    private static final int CUSTOMER_COUNT = 250;
    private static List<Ticket> tickets = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static int CUSTOMER_ID = 1;

    public static void main(String[] args) {
        int ticketId = 1;
        for (int r = 1; r <= Row; r++) {
            for (int c = 1; c <= Col; c++) {
                Ticket ticket = new Ticket(ticketId++, ROOM, r, c,
                        FIlM_NAME, PRICE,
                        LocalDateTime.of(2020, 5, 10, 18, 00));
                tickets.add(ticket);
            }
        }
//        Iterator<Ticket> iterator = tickets.iterator();
//        while (iterator.hasNext())
//            System.out.println(iterator.next().toString());

        Collections.shuffle(tickets);

        while (tickets.size() > 0 && CUSTOMER_ID <= CUSTOMER_COUNT) {
            Ticket ticket = tickets.get(tickets.size() - 1);
            Customer customer = new Customer(CUSTOMER_ID);
            customer.buyTicket(ticket);
            customers.add(customer);
            tickets.remove(tickets.size() - 1);
            System.out.println(tickets.size() + "," + CUSTOMER_ID);
            System.out.println("No." + CUSTOMER_ID + " Customer bought "
                    + "Row:" + customer.getTicket().getRow() +
                    " Col:" + customer.getTicket().getCol());
            CUSTOMER_ID++;
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println();
        System.out.println("Tickets Info Summary:");
        System.out.println("Remaining Tickets number is: " + tickets.size());
        Iterator<Ticket> ticketIterator = tickets.iterator();
        while (ticketIterator.hasNext())
            System.out.println(ticketIterator.next().toString());

        System.out.println("Number of Customers that bought ticket: " + customers.size());
        Iterator<Customer> customerIterator = customers.iterator();
        while (customerIterator.hasNext())
            customerIterator.next().toString();
        System.out.println("Number of Customers that did not buy the ticket: "
                + (CUSTOMER_COUNT - customers.size()));
    }
}
