package com.library.ui;


import java.util.Scanner;

import com.library.model.Library;

public class UserInterface {
    
    private Library library;
    private Scanner scanner;
    
    public UserInterface() {
        this.library = new Library();
        this.scanner = new Scanner(System.in);
    }
    
    public void start() {
        System.out.println("Welcome to the Library Management System!");
        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. View all books");
            System.out.println("2. Search for a book");
            System.out.println("3. Check out a book");
            System.out.println("4. Return a book");
            System.out.println("5. Add a new book");
            System.out.println("0. Quit");
            
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    library.viewAllBooks();
                    break;
                case 2:
                    searchMenu();
                    break;
                case 3:
                    checkoutMenu();
                    break;
                case 4:
                    returnMenu();
                    break;
                case 5:
                    addBookMenu();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private void searchMenu() {
        System.out.println("Please choose a search option:");
        System.out.println("1. Search by title");
        System.out.println("2. Search by author");
        System.out.println("3. Search by ISBN");
        System.out.println("0. Go back");
        
        int choice = getIntInput();
        switch (choice) {
            case 1:
                System.out.print("Enter title to search for: ");
                String title = scanner.nextLine();
                library.searchBooksByTitle(title);
                break;
            case 2:
                System.out.print("Enter author to search for: ");
                String author = scanner.nextLine();
                library.searchBooksByAuthor(author);
                break;
            case 3:
                System.out.print("Enter ISBN to search for: ");
                String isbn = scanner.nextLine();
                library.searchBooksByISBN(isbn);
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    private void checkoutMenu() {
        System.out.print("Enter ISBN of book to check out: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter patron name: ");
        String patron = scanner.nextLine();
        library.checkOutBook(isbn, patron);
    }
    
    private void returnMenu() {
        System.out.print("Enter ISBN of book to return: ");
        String isbn = scanner.nextLine();
        library.returnBook(isbn);
    }
    
    private void addBookMenu() {
        System.out.print("Enter title of new book: ");
        String title = scanner.nextLine();
        System.out.print("Enter author of new book: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN of new book: ");
        String isbn = scanner.nextLine();
        library.addBook(title, author, isbn);
    }
    
    private int getIntInput() {
        while (true) {
            try {
                System.out.print("> ");
                int choice = Integer.parseInt(scanner.nextLine());
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
    
}