import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Scanner sc = new Scanner(System.in);
    static Book[] books = new Book[3];

    public static void main(String[] args) {

        boolean check = true;
        while (check) {
            System.out.println("1 - butun kitablara bax.");
            System.out.println("2 - kitab elave et.");
            System.out.println("3 - search et.");
            System.out.print("secim edin: ");
            int proses = sc.nextInt();
            sc.nextLine();

            switch (proses) {
                case 1:
                    showBook();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    getSearch();
                    break;
            }
            boolean check1 = true;
            while (check1) {
                System.out.println("Davam etmek isteyirsinizmi: (yes - 1/ no - 2");
                int choose = sc.nextInt();

                if (choose == 1) {
                    check = true;
                    check1 = false;
                } else if (choose == 2) {
                    check = false;
                    check1 = false;
                } else {
                    check = false;
                    check1 = true;
                }
            }
        }
    }

    public static void showBook() {
        for (Book book : books) {
            if (book != null)
                System.out.println("Name: " + book.name + " Price: " + book.price + " Count: " + book.count);
        }
    }

    public static void getSearch() {
        System.out.print("Axtarmaq istediyin kitabin adini yaz: ");
        String text = sc.nextLine();
        for (Book book : books) {
            if (book != null)
                System.out.println("Name: " + book.name.toLowerCase().contains(text));
            ;
        }
    }

    public static void addBook() {
        System.out.print("book name: ");
        String bookName = sc.nextLine();
        System.out.print("book price: ");
        int bookPrice = sc.nextInt();
        System.out.print("book count: ");
        int bookCount = sc.nextInt();

        Book book = new Book(bookName, bookPrice, bookCount);
        boolean hasEmpty = true;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                hasEmpty = false;
                break;
            }
        }
        if (hasEmpty) {
            Book[] newBook = new Book[books.length * 2];
            for (int i = 0; i < books.length; i++) {
                newBook[i] = books[i];
            }
            newBook[books.length] = book;
            books = newBook;
        }
    }
}