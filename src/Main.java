import com.workintech.books.*;
import com.workintech.enums.FrequencyOfPublication;

import java.util.Scanner;

public class Main {
    static Scanner s;

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Book book1 = new Book(1001, "Çalıkuşu", "Reşat Nuri Gültekin", 50);
        Book book2 = new Book(1002, "Anadolu Notları", "Reşat Nuri Gültekin", 45);
        Book book3 = new Book(1003, "İnce Memed 1", "Yaşar Kemal", 60);
        Book book4 = new Book(10030, "İnce Memed 2", "Yaşar Kemal", 65);

        Book journal1 = new Journal(1004, "The Guardian", "John Crace", 12);
        Book journal2 = new Journal(1005, "Daily News", "John Crace", 15);

        Book studyBook1 = new StudyBook(1006, "University Mathematics", "Colin McGregor", 45);
        Book studyBook2 = new StudyBook(1007, "Applied Mathematics", "R.D. Sharma", 40);

        Book magazine1 = new Magazine(1008, "National Geographic", "Kenneth Brower", 20,
                FrequencyOfPublication.FREQUENT);
        Book magazine2 = new Magazine(1009, "Popular Science", "Andrew Paul", 18,
                FrequencyOfPublication.NORMAL);

        Library.addBook(book1, book2, book3, book4, journal1, journal2, studyBook1, studyBook2,
                magazine1, magazine2);

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
    private static void selectOperation() {
        System.out.println();
        System.out.println("""
                Select operation :\s
                 1.Add new book\s
                 2.Get books\s
                 3.Delete book\s
                 4.Search book\s
                 5.Update book\s
                 0.Exit""");
        int input = s.nextInt();

        if (input != 0) {
            switch (input) {
                case 1:
                    addBook();
                    break;
                case 2:
                    getBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    searchBook();
                    break;
                case 5:
                    updateBook();
                    break;
                default:
                    System.out.println("choose from 1 to 5");
            }
            selectOperation();
        }
    }

    private static void addBook() {
        s = new Scanner(System.in);

        System.out.print("Select category (1.Book 2.Journal 3.Study Book 4.Magazine) : ");
        int category = s.nextInt();

        System.out.print("Book Id : ");
        int id = s.nextInt();

        s = new Scanner(System.in);

        System.out.print("Name : ");
        String name = s.nextLine();

        System.out.print("Author : ");
        String author = s.nextLine();

        System.out.print("Price : ");
        double price = Double.parseDouble(s.nextLine());

        switchByCategort(category, id, name, author, price);
    }

    private static void getBook() {
        System.out.print("Select category (1.Book 2.Journal 3.Study Book 4.Magazine) : ");
        int category = s.nextInt();
        switch (category) {
            case 2:
                Library.displayJournal();
                break;
            case 3:
                Library.displayStudyBook();
                break;
            case 4:
                Library.displayMagazine();
                break;
            default:
                Library.displayAllBooks();
        }


    }

    private static void deleteBook() {
        s = new Scanner(System.in);
        Library.displayAllBooks();

        System.out.print("Please write the id you want to delete from the library : ");
        int delete = s.nextInt();

        Library.deleteBook(delete);
    }

    private static void searchBook() {
        s = new Scanner(System.in);
        System.out.print("Search by (1.Id 2.Title 3.Author) : ");
        int category = s.nextInt();

        System.out.print("Enter search context : ");
        String input = s.next();

        switch (category) {
            case 2:
                Library.searchByTitle(input);
                break;
            case 3:
                Library.searchByAuthor(input);
                break;
            default:
                Library.searchById(Integer.parseInt(input));
        }
    }

    private static void switchByCategort(int category, int id, String name, String author,
                                         double price) {
        Book book;
        switch (category) {
            case 2:
                book = new Journal(id, name, author, price);
                break;
            case 3:
                book = new StudyBook(id, name, author, price);
                break;
            case 4:
                System.out.print("Frequence : (1.FREQUENT 2.NORMAL 3.INFREQUENT) : ");
                s = new Scanner(System.in);
                int frequence = s.nextInt();

                book = switch (frequence) {
                    case 1 -> new Magazine(id, name, author, price,
                            FrequencyOfPublication.FREQUENT);
                    case 3 -> new Magazine(id, name, author, price,
                            FrequencyOfPublication.INFREQUENT);
                    default -> new Magazine(id, name, author, price, FrequencyOfPublication.NORMAL);
                };
                break;
            default:
                book = new Book(id, name, author, price);
        }

        Library.addBook(book);
        Library.displayAllBooks();
    }

    private static void updateBook() {
        s = new Scanner(System.in);
        Library.displayAllBooks();

        System.out.print("Please write the id of book you want to update from the library : ");
        int id = s.nextInt();

        s = new Scanner(System.in);

        System.out.print("Name : ");
        String name = s.nextLine();

        System.out.print("Author : ");
        String author = s.nextLine();

        System.out.print("Price : ");
        int price = Integer.parseInt(s.nextLine());

        Library.updateBook(id, name, author, price);
    }


}