package view;

import constants.SafeDecSqlConstants;
import model.User;
import util.DatabaseConnectionUtil;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Locale;

public class LoginPage {
    private JFrame frame;
    private JLabel titleLabel;
    private JButton loginButton;
    private JButton registerButton;
    private JTextField emailTextField;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JPasswordField passwordTextField;
    private JPanel loginPanel;

    public LoginPage() {
        $$$setupUI$$$();
        loginButton.addActionListener(e -> login());
        registerButton.addActionListener(e -> registerUser());
    }


    public void launchFrame() {
        frame = new JFrame("Login Page");
        frame.setContentPane(this.loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void registerUser() {
        RegisterUserPage registerPage = new RegisterUserPage();
        registerPage.launchFrame();
    }

    private void login() {
        String email = emailTextField.getText();
        String pwd = Arrays.toString(passwordTextField.getPassword());

        if (isLoginValid(email, pwd)) {
            frame.dispose();
            JFrame parentFrame = new JFrame();
            parentFrame.setLayout(new BorderLayout());
            parentFrame.getContentPane().add(BorderLayout.CENTER, new CardPanel(loadUserFromDatabase()));
            parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            parentFrame.setTitle("SafeDec Services");
            parentFrame.pack();
            parentFrame.setLocationRelativeTo(null);
            parentFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Login Credentials");
        }
    }

    private boolean isLoginValid(String email, String password) {
        try {
            PreparedStatement stmt = DatabaseConnectionUtil.getDbConnection().prepareStatement(SafeDecSqlConstants.GET_USER);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private User loadUserFromDatabase() {
        User user = new User();

        try {
            PreparedStatement stmt = DatabaseConnectionUtil.getDbConnection().prepareStatement(SafeDecSqlConstants.GET_USER_DETAILS);
            stmt.setString(1, emailTextField.getText());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int userId = rs.getInt("userId");
                String customerName = rs.getString("name");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber");
                String emergencyContact1 = rs.getString("emergencyContact1");
                String emergencyContact2 = rs.getString("emergencyContact2");
                String masterCode = rs.getString("masterCode");
                String address = rs.getString("address");

                user.setId(userId);
                user.setName(customerName);
                user.setEmail(email);
                user.setPhoneNumber(phoneNumber);
                user.setEmergencyContact1(emergencyContact1);
                user.setEmergencyContact2(emergencyContact2);
                user.setMasterCode(masterCode);
                user.setAddress(address);
            }
        } catch (Exception e) {
            System.out.println("Error: in retrieving user details");
            e.printStackTrace();
        }

        return user;
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        loginPanel = new JPanel();
        loginPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 4, new Insets(0, 0, 0, 0), -1, -1));
        loginPanel.setBackground(new Color(-1));
        loginPanel.setEnabled(false);
        loginPanel.setMinimumSize(new Dimension(400, 400));
        titleLabel = new JLabel();
        Font titleLabelFont = this.$$$getFont$$$("Courier", Font.BOLD, 24, titleLabel.getFont());
        if (titleLabelFont != null) titleLabel.setFont(titleLabelFont);
        titleLabel.setHorizontalAlignment(0);
        titleLabel.setHorizontalTextPosition(0);
        titleLabel.setText("SafeDec - Fire and Security Services");
        loginPanel.add(titleLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        loginButton = new JButton();
        loginButton.setText("Login");
        loginPanel.add(loginButton, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        registerButton = new JButton();
        registerButton.setText("New User ? Register Here");
        loginPanel.add(registerButton, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        emailLabel = new JLabel();
        emailLabel.setText("Email");
        loginPanel.add(emailLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        emailTextField = new JTextField();
        loginPanel.add(emailTextField, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(300, -1), null, 0, false));
        passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        loginPanel.add(passwordLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwordTextField = new JPasswordField();
        loginPanel.add(passwordTextField, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(300, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return loginPanel;
    }


}
