package view;

import model.ServiceBill;
import model.User;
import service.FireService;
import service.SafeDecMediator;
import service.SecurityService;

import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel {

    private final CardLayout cardLayout;
    private final SecurityServicesDashboard securityServicesDashboard;
    private final FireServicesDashboard fireServicesDashboard;

    public CardPanel(User user) {
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        securityServicesDashboard = new SecurityServicesDashboard(this, new SafeDecMediator(new SecurityService(user), new ServiceBill.ServiceBillBuilder()));
        fireServicesDashboard = new FireServicesDashboard(this, new SafeDecMediator(new FireService(user), new ServiceBill.ServiceBillBuilder()));

        add(new HomePage(this).getMainPanel(), "mainPanel");
        add(securityServicesDashboard.generatePanel(), "securityPanel");
        add(fireServicesDashboard.generatePanel(), "firePanel");
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public SecurityServicesDashboard getSecurityServicesDashboard() {
        return securityServicesDashboard;
    }

    public FireServicesDashboard getFireServicesDashboard() {
        return fireServicesDashboard;
    }

}
