package Extras.ConcurrencyStuff.CinemaExample;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Ticket {
    private int ticketId;
    private String room;
    private Integer row;
    private Integer col;
    private String filmName;
    private BigDecimal price;
    private LocalDateTime datetime;

    private Ticket() {
    }

    public Ticket(int ticketId, String room,
                  Integer row, Integer col,
                  String filmName, BigDecimal price,
                  LocalDateTime datetime) {
        this.ticketId = ticketId;
        this.room = room;
        this.row = row;
        this.col = col;
        this.filmName = filmName;
        this.price = price;
        this.datetime = datetime;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", room='" + room + '\'' +
                ", row=" + row +
                ", col=" + col +
                ", filmName='" + filmName + '\'' +
                ", price=" + price +
                ", datetime=" + datetime +
                '}';
    }
}
