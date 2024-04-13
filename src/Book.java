import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Book {

    private UUID ID;
    private String name;
    private String author;
    private double price;
    private boolean status;
    private Date date_of_purchase;


    public Book(String name, String author, double price) {
        this.ID = UUID.randomUUID();
        this.name = name;
        this.author = author;
        this.price = price;
        this.status = true;
        this.date_of_purchase = new Date();
    }

    public UUID getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public boolean isStatus() {
        return status;
    }

    public Date getDate_of_purchase() {
        return date_of_purchase;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", date_of_purchase=" + date_of_purchase +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(ID, book.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
