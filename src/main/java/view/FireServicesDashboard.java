package view;

import constants.SafeDecConstants;
import model.ServiceConfiguration;
import service.SafeDecMediator;
import util.CustomOutputStreamUtil;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class FireServicesDashboard {
    private JPanel fireServicePanel;
    private JButton returnToMainPanelButton;
    private JButton generateBillButton;
    private JButton startStopServiceButton;
    private JButton simulateBreakInButton;
    private JTextArea fireDashboardLogs;
    private JPanel sectionSelectionPanel;
    private JCheckBox section1CheckBox;
    private JCheckBox section2CheckBox;
    private JCheckBox section3CheckBox;
    private JButton schedulingServiceButton;
    private JCheckBox office1CheckBox;
    private JCheckBox office2CheckBox;
    private JCheckBox office3CheckBox;
    private JCheckBox office4CheckBox;
    private JCheckBox office5CheckBox;
    private JCheckBox office6CheckBox;
    private JCheckBox office7CheckBox;
    private JCheckBox office8CheckBox;
    private JCheckBox office9CheckBox;
    private JCheckBox office10CheckBox;
    private JCheckBox office11CheckBox;
    private final SafeDecMediator mediator;
    private List<JCheckBox> sensorCheckBoxList;
    private ServiceConfiguration serviceConfiguration;

    public FireServicesDashboard(CardPanel cardPanel, SafeDecMediator mediator) {
        $$$setupUI$$$();
        this.mediator = mediator;

        addCheckBoxListeners();
        addSectionListeners();

        returnToMainPanelButton.addActionListener(e -> {
            cardPanel.getCardLayout().show(cardPanel, "mainPanel");
        });


        registerButtonListeners();

        PrintStream printStream = new PrintStream(new CustomOutputStreamUtil(fireDashboardLogs));
        System.setOut(printStream);
    }

    public JPanel generatePanel() {
        return fireServicePanel;
    }

    public void addCheckBoxListeners() {
        sensorCheckBoxList = Arrays.asList(office1CheckBox, office2CheckBox, office3CheckBox, office4CheckBox, office5CheckBox, office6CheckBox, office7CheckBox, office8CheckBox, office9CheckBox, office10CheckBox, office11CheckBox);

        for (int i = 0; i < sensorCheckBoxList.size(); i++) {
            int checkBoxId = i;
            sensorCheckBoxList.get(i).addActionListener(e -> mediator.onSensorSelection(
                    checkBoxId + 1,
                    serviceConfiguration.getSensorType(),
                    sensorCheckBoxList.get(checkBoxId).isSelected()
            ));
        }

    }

    public void addSectionListeners() {
        List<JCheckBox> sectionCheckBoxes = Arrays.asList(section1CheckBox, section2CheckBox, section3CheckBox);

        for (int i = 0; i < sectionCheckBoxes.size(); i++) {
            int sectionId = i;
            JCheckBox sectionCheckBox = sectionCheckBoxes.get(i);

            sectionCheckBox.addActionListener(e -> {
                        mediator.onSectionSelection(sectionId + 1, serviceConfiguration.getSensorType(), sectionCheckBox.isSelected());

                        for (int checkBoxId : SafeDecConstants.BUILDING_SECTIONS_MAPPING.get(sectionId + 1)) {
                            sensorCheckBoxList.get(checkBoxId - 1).setSelected(sectionCheckBox.isSelected());
                        }
                    }
            );
        }
    }

    public void setServiceConfiguration(ServiceConfiguration configuration) {
        this.serviceConfiguration = configuration;
        addCheckBoxListeners();
        addSectionListeners();
        mediator.selectTriggerNotification(serviceConfiguration.getAlertType());
    }

    public void registerButtonListeners() {
        String alertText = "Alert! Detected a Fire Incident!";

        startStopServiceButton.addActionListener(e -> mediator.toggleServiceStatus());
        schedulingServiceButton.addActionListener(e -> new ScheduleServiceDialog(mediator).launchFrame());
        generateBillButton.addActionListener(e -> mediator.displayBillPanel());
        simulateBreakInButton.addActionListener(e -> mediator.triggerAlertSimulation(alertText));
    }


    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        fireServicePanel = new JPanel();
        fireServicePanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(20, 6, new Insets(0, 0, 0, 0), -1, -1));
        fireServicePanel.setBackground(new Color(-1));
        Font fireServicePanelFont = this.$$$getFont$$$("Courier", Font.BOLD, 18, fireServicePanel.getFont());
        if (fireServicePanelFont != null) fireServicePanel.setFont(fireServicePanelFont);
        sectionSelectionPanel = new JPanel();
        sectionSelectionPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 5, new Insets(0, 0, 0, 0), -1, -1));
        sectionSelectionPanel.setBackground(new Color(-1));
        fireServicePanel.add(sectionSelectionPanel, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 16, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(400, 400), null, 0, false));
        section1CheckBox = new JCheckBox();
        section1CheckBox.setText("Section 1");
        sectionSelectionPanel.add(section1CheckBox, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        section2CheckBox = new JCheckBox();
        section2CheckBox.setText("Section 2");
        sectionSelectionPanel.add(section2CheckBox, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        section3CheckBox = new JCheckBox();
        section3CheckBox.setText("Section 3");
        sectionSelectionPanel.add(section3CheckBox, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        office1CheckBox = new JCheckBox();
        office1CheckBox.setText("Office 1");
        sectionSelectionPanel.add(office1CheckBox, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        office2CheckBox = new JCheckBox();
        office2CheckBox.setText("Office 2");
        sectionSelectionPanel.add(office2CheckBox, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        office3CheckBox = new JCheckBox();
        office3CheckBox.setText("Office 3");
        sectionSelectionPanel.add(office3CheckBox, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        office8CheckBox = new JCheckBox();
        office8CheckBox.setText("Office 8");
        sectionSelectionPanel.add(office8CheckBox, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        office9CheckBox = new JCheckBox();
        office9CheckBox.setText("Office 9");
        sectionSelectionPanel.add(office9CheckBox, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        office10CheckBox = new JCheckBox();
        office10CheckBox.setText("Office 10");
        sectionSelectionPanel.add(office10CheckBox, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        office4CheckBox = new JCheckBox();
        office4CheckBox.setText("Office 4");
        sectionSelectionPanel.add(office4CheckBox, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        office5CheckBox = new JCheckBox();
        office5CheckBox.setText("Office 5");
        sectionSelectionPanel.add(office5CheckBox, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        office6CheckBox = new JCheckBox();
        office6CheckBox.setText("Conference 6");
        sectionSelectionPanel.add(office6CheckBox, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        office7CheckBox = new JCheckBox();
        office7CheckBox.setText("Office 7");
        sectionSelectionPanel.add(office7CheckBox, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        office11CheckBox = new JCheckBox();
        office11CheckBox.setText("Office 11");
        sectionSelectionPanel.add(office11CheckBox, new com.intellij.uiDesigner.core.GridConstraints(5, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        fireServicePanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(17, 1, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        fireServicePanel.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 15, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        fireServicePanel.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(2, 5, 15, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        fireServicePanel.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        fireServicePanel.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        fireServicePanel.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(18, 1, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        fireDashboardLogs = new JTextArea();
        fireDashboardLogs.setColumns(1);
        fireDashboardLogs.setEditable(false);
        fireDashboardLogs.setLineWrap(true);
        fireDashboardLogs.setRows(25);
        scrollPane1.setViewportView(fireDashboardLogs);
        final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
        fireServicePanel.add(spacer6, new com.intellij.uiDesigner.core.GridConstraints(19, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Courier", Font.BOLD, 24, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Fire Service Dashboard");
        fireServicePanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        startStopServiceButton = new JButton();
        startStopServiceButton.setText("ON/OFF Service");
        fireServicePanel.add(startStopServiceButton, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        returnToMainPanelButton = new JButton();
        returnToMainPanelButton.setText("Return to Home");
        fireServicePanel.add(returnToMainPanelButton, new com.intellij.uiDesigner.core.GridConstraints(8, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setIcon(new ImageIcon(getClass().getResource("/office-img.png")));
        label2.setText("");
        fireServicePanel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 10, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        generateBillButton = new JButton();
        generateBillButton.setText("Generate Bill");
        fireServicePanel.add(generateBillButton, new com.intellij.uiDesigner.core.GridConstraints(7, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        schedulingServiceButton = new JButton();
        schedulingServiceButton.setText("Schedule Service");
        fireServicePanel.add(schedulingServiceButton, new com.intellij.uiDesigner.core.GridConstraints(6, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        simulateBreakInButton = new JButton();
        simulateBreakInButton.setText("Simulate Fire Incident");
        fireServicePanel.add(simulateBreakInButton, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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
        return fireServicePanel;
    }


}