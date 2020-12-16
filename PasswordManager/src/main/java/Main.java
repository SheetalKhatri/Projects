import Service.PasswordService;

import java.util.Scanner;

public class Main {
    private static final String OPTIONS_MSG = "Enter 1 to retrieve a password, 2 to create a new one: ";
    private static final String MASTER_PW_MSG = "Please enter your master password: ";
    private static final String ACCOUNT_MSG = "Please enter your account name";
    private static final String ACCOUNT_PW_MSG = "Please enter your account password: ";
    private static final String GET_FAILED_MSG = "Could not retrieve password - please check your password and account name";
    private static final String ADD_SUCCESS_MSG = "Successfully added password for ";
    private static final String WRONG_CHOICE = "Incorrect choice, please try again";

    private static String ask(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(question);
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        String choice = ask(OPTIONS_MSG);
        PasswordService passwordService = new PasswordService();

        if (choice.equals("1")) {
            String mpw = ask(MASTER_PW_MSG);
            String accountName = ask(ACCOUNT_MSG);
            String password = passwordService.getPasswordForAccount(mpw, accountName);
            if (password == null) {
                System.out.println(GET_FAILED_MSG);
            } else {
                System.out.println(password);
            }
        } else if (choice.equals("2")) {
            String mpw = ask(MASTER_PW_MSG);
            String accountName = ask(ACCOUNT_MSG);
            String password = ask(ACCOUNT_PW_MSG);
            passwordService.setNewPasswordForAccount(accountName, password, mpw);
            System.out.println(ADD_SUCCESS_MSG + accountName);
        } else {
            System.out.println(WRONG_CHOICE);
        }
    }
}
