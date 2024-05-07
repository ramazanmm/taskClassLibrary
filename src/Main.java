import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    static Book[] books = new Book[3];

    public static void main(String[] args) {

        boolean check1 = true;
        while (check1) {

            System.out.println("1 - butun kitablara baxin.");
            System.out.println("2 - kitab elave edin.");
            System.out.println("3 - ada gore search edin.");
            System.out.println("4 - price gore searc edin.");
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
                case 4:
                    getSearchPrice();
                    break;
            }
            boolean check2 = true;
            while (check2) {
                System.out.println("davam etmek isteyirsiz: (yes -1 / no - 2)");
                int choose = sc.nextInt();
                if (choose == 1) {
                    check1 = true;
                    check2 = false;
                } else if (choose == 2) {
                    check1 = false;
                    check2 = false;
                } else {
                    check1 = false;
                    check2 = true;
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
        System.out.print("axtarmaq istediyiniz metni yazin: ");
        String text = sc.nextLine();
        for (Book book : books) {
            if (book != null)
                System.out.println("Search: " + book.name.toLowerCase().contains(text));
        }
    }

    public static void getSearchPrice() {
        System.out.println("max Price daxil et: ");
        int maxPrice = sc.nextInt();
        System.out.println("min Price daxil et: ");
        int minPrice = sc.nextInt();

        for (Book book : books) {
            if (book != null && book.price > minPrice && book.price < maxPrice) {
                System.out.println("daxil edilen min ve max arasinda olan Price: " + book.name + book.price);
            }
        }
    }

    public static void addBook() {
        System.out.print("Kitabin adini daxil edin: ");
        String bookName = sc.nextLine();
        System.out.print("Price daxil edin: ");
        int bookPrice = sc.nextInt();
        System.out.print("Count daxil edin: ");
        int bookCount = sc.nextInt();

        Book book = new Book(bookName, bookPrice, bookCount);
        boolean check = true;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                check = false;
                break;
            }
        }
        if (check) {
            Book[] newBook = new Book[books.length * 2];
            for (int i = 0; i < books.length; i++) {
                newBook[i] = books[i];
            }
            newBook[books.length] = book;
            books = newBook;
        }
    }
}