package main;

import view.LoginPage;

/**
 * Main class to Run the SafeDec - Fire and Security Services Application.
 */

public class SafeDecDemo {

    public static LoginPage loginPage;

    public static void main(String[] args) {
        loginPage = new LoginPage();
        java.awt.EventQueue.invokeLater(() -> loginPage.launchFrame());
    }

}
