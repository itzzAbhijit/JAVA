Simulate a ticket booking system where
multiple users((threads) are trying to
book tickets from l a
a limited pool.
Prevent overbooking using
synchronization

class TicketBooking {
    private int availableSeats = 5;

    public synchronized void bookTicket(String user, int tickets) {
        if (tickets <= availableSeats) {
            System.out.println(user + " booked " + tickets + " tickets.");
            availableSeats -= tickets;
        } else {
            System.out.println(user + " failed! Only " + availableSeats + " seats left.");
        }
    }
}

class UserThread extends Thread {
    TicketBooking booking;
    int tickets;

    public UserThread(TicketBooking booking, String name, int tickets) {
        super(name);
        this.booking = booking;
        this.tickets = tickets;
    }

    public void run() {
        booking.bookTicket(getName(), tickets);
    }
}

public class TicketSystem {
    public static void main(String[] args) {
        TicketBooking booking = new TicketBooking();

        new UserThread(booking, "User1", 2).start();
        new UserThread(booking, "User2", 3).start();
        new UserThread(booking, "User3", 2).start();
    }
}