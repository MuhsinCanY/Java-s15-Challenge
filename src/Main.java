import java.util.Scanner;

public class Main {
    static Scanner s;

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Book book1 = new Book("Çalıkuşu", "Reşat Nuri Gültekin", 50);
        Book book2 = new Book("Anadolu Notları", "Reşat Nuri Gültekin", 45);
        Book book3 = new Book("İnce Memed 1", "Yaşar Kemal", 60);
        Library.addBook(book1, book2, book3);

        User user1 = new User("Muhsin", "1", "2");
        Library.addUser(user1);

        welcome();
    }

    //First Step
    private static void welcome() {
        System.out.println("Welcome to Library... \n 1.Login \n 2.Create New User");
        s = new Scanner(System.in);

        int input = s.nextInt();

        switch (input) {
            case 1:
                login();
                break;
            case 2:
                newUser();
                break;
        }
    }

    private static void login() {
        System.out.println("login");

        System.out.println("Enter phone number : ");
        String phoneNumber = s.next();

        System.out.println("Enter email : ");
        String email = s.next();

        boolean isLogin = Library.login(phoneNumber, email);

        if (isLogin) {
            selectOperation();
        } else {
            System.out.println("User not found...");
            welcome();
        }
    }

    private static void newUser() {
        System.out.println("Enter name : ");
        String name = s.next();

        System.out.println("Enter phone number : ");
        String phoneNumber = s.next();

        System.out.println("Enter email : ");
        String email = s.next();

        User user = new User(name, email, phoneNumber);
        Library.addUser(user);

        System.out.println(Library.users);
        selectOperation();
    }

    //Second Step
    public static void selectOperation() {
        System.out.println("Select operation : \n 1.Add new book \n 2.Get all books \n 3.Delete " +
                "book \n 0.Exit");
        s = new Scanner(System.in);
        String input = s.nextLine();

        switch (input) {
            case "0":
                break;
            case "1":
                addBook();
                selectOperation();
                break;
            case "2":
                Library.getBooks();
                selectOperation();
                break;
            case "3":
                deleteBook();
                selectOperation();
                break;
            default:
                System.out.println("choose from 1 to 3");
                selectOperation();
        }
    }

    private static void deleteBook() {
        Library.getBooks();

        System.out.print("Please write the index you want to delete from the library : ");
        String delete = s.nextLine();

        Library.deleteBook(Integer.parseInt(delete));
    }

    private static void addBook() {
        System.out.print("Name : ");
        String name = s.nextLine();

        System.out.print("Author : ");
        String author = s.nextLine();

        System.out.print("Price : ");
        double price = Double.parseDouble(s.nextLine());

        Book book = new Book(name, author, price);
        Library.getBooks();
    }


}