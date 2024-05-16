package co.edu.uptc.view.menu;

import co.edu.uptc.util.ViewPropertiesUtil;
import co.edu.uptc.view.ManagerView;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JFrame {

    private JLabel titleGameLabel;
    private JButton startGameButton;
    private JButton settingsButton;
    private ManagerView managerView;
    private BackgroundPanel backgroundPanel;
    private OptionsPanelView optionsPanelView;

    public MenuView() {
        initComponents();
    }

    public void setManagerView(ManagerView managerView) {
        this.managerView = managerView;
        optionsPanelView.setManagerView(managerView);
    }

    private void initComponents() {
        this.setSize(ViewPropertiesUtil.MENU_WIDTH, ViewPropertiesUtil.MENU_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(new GridBagLayout());

        optionsPanelView = new OptionsPanelView();

        GridBagConstraints gbc = new GridBagConstraints();
        createComponents();
        addComponents(backgroundPanel, gbc);

        this.add(backgroundPanel);
    }

    private void createComponents() {
        createTitleGameLabel();
        createStartGameButton();
        createSettingsButton();
    }

    private void createTitleGameLabel() {
        titleGameLabel = new JLabel(ViewPropertiesUtil.GAME_TITLE);
        titleGameLabel.setForeground(ViewPropertiesUtil.TEXT_COLOR);
        titleGameLabel.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 30));
        titleGameLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void createStartGameButton() {
        startGameButton = new JButton(ViewPropertiesUtil.START_BUTTON);
        startGameButton.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 20));
        startGameButton.setBackground(ViewPropertiesUtil.TEXT_COLOR);
        startGameButton.setForeground(ViewPropertiesUtil.TEXT_COLOR2);
        startGameButton.setFocusPainted(false);
        startGameButton.setBorderPainted(false);
        startGameButton.addActionListener(e -> {
            close();
            managerView.startGame();
        });
    }
    private void createSettingsButton() {
        settingsButton = new JButton(ViewPropertiesUtil.SETTINGS_BUTTON);
        settingsButton.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 20));
        settingsButton.setBackground(ViewPropertiesUtil.TEXT_COLOR);
        settingsButton.setForeground(ViewPropertiesUtil.TEXT_COLOR2);
        settingsButton.setFocusPainted(false);
        settingsButton.setBorderPainted(false);
        settingsButton.addActionListener(e -> {
            backgroundPanel.setVisible(false);
            optionsPanelView.setVisible(true);
            add(optionsPanelView);
            remove(backgroundPanel);
            revalidate();
        });
    }

    public void backToMenu() {
        optionsPanelView.setVisible(false);
        backgroundPanel.setVisible(true);
        add(backgroundPanel);
        remove(optionsPanelView);
        revalidate();
    }

    private void addComponents(BackgroundPanel backgroundPanel, GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.SOUTH;
        backgroundPanel.add(titleGameLabel, gbc);

        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(0, 0, 20, 0);
        backgroundPanel.add(startGameButton, gbc);

        gbc.gridy = 2;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.NORTH;
        backgroundPanel.add(settingsButton, gbc);
    }

    public void run() {
        this.setVisible(true);
    }

    public void close() {
        this.setVisible(false);
    }
}
