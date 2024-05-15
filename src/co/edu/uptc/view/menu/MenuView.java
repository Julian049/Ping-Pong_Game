package co.edu.uptc.view.menu;

import co.edu.uptc.util.ViewPropertiesUtil;
import co.edu.uptc.view.ManagerView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuView extends JFrame {

    private JLabel titleGameLabel;
    private JButton selectRightKeyButton;
    private JButton selectLeftKeyButton;
    private char rightKey;
    private char leftKey;
    private JTextArea selectRightKeyTextArea;
    private JTextArea selectLeftKeyTextArea;
    private JLabel noteLabel;
    private ManagerView managerView;

    public MenuView() {
        initComponents();
    }

    public void setManagerView(ManagerView managerView) {
        this.managerView = managerView;
    }

    private void initComponents() {
        this.setSize(ViewPropertiesUtil.MENU_WIDTH, ViewPropertiesUtil.MENU_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        createComponents();
        addComponents(backgroundPanel, gbc);

        this.setContentPane(backgroundPanel);
    }

    private void createComponents() {
        createTitleGameLabel();
        createRightKeyTextArea();
        createRightKeyButton();
        createLeftKeyTextArea();
        createLeftKeyButton();
        createNoteLabel();
    }

    private void createTitleGameLabel( ) {
        titleGameLabel = new JLabel("Ping-pong");
        titleGameLabel.setForeground(new Color(45, 227, 51));
        titleGameLabel.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 30));
        titleGameLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void createRightKeyTextArea( ) {
        selectRightKeyTextArea = new JTextArea("Click here to configure the right key");
        selectRightKeyTextArea.setForeground(Color.BLACK);
        selectRightKeyTextArea.setBackground(new Color(0, 0, 0, 0));
        selectRightKeyTextArea.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 10));
        selectRightKeyTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectRightKeyTextArea.setText("Press the key");
                selectRightKeyTextArea.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        rightKey = e.getKeyChar();
                        selectRightKeyTextArea.setText("Key Selected" + rightKey);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });
            }
        });
        selectRightKeyTextArea.setEditable(false);
        selectRightKeyTextArea.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void createRightKeyButton( ) {
        selectRightKeyButton = new JButton("OK");
        selectRightKeyButton.setBackground(new Color(45, 227, 51));
        selectRightKeyButton.setBorderPainted(false);
        selectRightKeyButton.setFocusPainted(false);
        selectRightKeyButton.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 10));
        selectRightKeyButton.addActionListener(e -> {
            if ((int) rightKey == 0) {
                JOptionPane.showMessageDialog(null, "Please select a key", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                close();
                managerView.startGame();
            }
        });
    }

    private void createLeftKeyTextArea( ) {
        selectLeftKeyTextArea = new JTextArea("Click here to configure the right key");
        selectLeftKeyTextArea.setForeground(Color.BLACK);
        selectLeftKeyTextArea.setBackground(new Color(0, 0, 0, 0));
        selectLeftKeyTextArea.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 10));
        selectLeftKeyTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectLeftKeyTextArea.setText("Press the key");
                selectLeftKeyTextArea.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        leftKey = e.getKeyChar();
                        selectLeftKeyTextArea.setText("Key Selected" + rightKey);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });
            }
        });
        selectLeftKeyTextArea.setEditable(false);
        selectLeftKeyTextArea.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void createLeftKeyButton( ) {
        selectLeftKeyButton = new JButton("OK");
        selectLeftKeyButton.setBackground(new Color(45, 227, 51));
        selectLeftKeyButton.setBorderPainted(false);
        selectLeftKeyButton.setFocusPainted(false);
        selectLeftKeyButton.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 10));
        selectLeftKeyButton.addActionListener(e -> {
            if ((int) leftKey == 0) {
                JOptionPane.showMessageDialog(null, "Please select a key", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                close();
                managerView.startGame();
            }
        });
    }

    private void createNoteLabel( ) {
        noteLabel = new JLabel("Keys like: Shift, Control, Tab, etc dont work");
        noteLabel.setForeground(Color.BLACK);
        noteLabel.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 7));
        noteLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    private void addComponents(JPanel panel, GridBagConstraints gbc){
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleGameLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.REMAINDER;
        panel.add(selectRightKeyTextArea, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(selectRightKeyButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.REMAINDER;
        panel.add(selectLeftKeyTextArea, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(selectLeftKeyButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(noteLabel, gbc);
    }

    public void run() {
        this.setVisible(true);
    }

    public void close() {
        this.setVisible(false);
    }

    public char getRightKey() {
        return rightKey;
    }

    public char getLeftKey() {
        return leftKey;
    }
}
