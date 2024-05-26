package co.edu.uptc.view.client.menu;

import co.edu.uptc.util.ViewPropertiesUtil;
import co.edu.uptc.view.client.ManagerView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public class OptionsPanelView extends JPanel implements Serializable {

    private JLabel settingsLabel;
    private JLabel selectRightKeyLabel;
    private JTextArea selectRightKeyTextArea;
    private JLabel selectLeftKeyLabel;
    private JTextArea selectLeftKeyTextArea;
    private JLabel noteLabel;
    private JButton backButton;
    private int rightKey;
    private int leftKey;
    private ManagerView managerView = new ManagerView();

    public OptionsPanelView() {
        initComponents();
    }

    public void setManagerView(ManagerView managerView) {
        this.managerView = managerView;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon image = new ImageIcon(ViewPropertiesUtil.BACKGROUND_IMAGE);
        image = new ImageIcon(image.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
        g.drawImage(image.getImage(), 0, 0, this);
        g.setColor(new Color(0,0,0,10));
        g.fillRect(0,0,this.getWidth(),this.getHeight());
    }

    private void initComponents() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        createComponents();

        addComponents(gbc);
    }

    private void createComponents() {
        createSettingsLabel();
        createRightKeyTextArea();
        createRightKeyLabel();
        createLeftKeyTextArea();
        createLeftKeyLabel();
        createNoteLabel();
        createBackButton();
    }

    private void createSettingsLabel() {
        settingsLabel = new JLabel(ViewPropertiesUtil.SETTINGS_BUTTON);
        settingsLabel.setForeground(ViewPropertiesUtil.TEXT_COLOR);
        settingsLabel.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 30));
        settingsLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void createRightKeyLabel() {
        selectRightKeyLabel = new JLabel(ViewPropertiesUtil.MOVE_RIGHT);
        selectRightKeyLabel.setForeground(ViewPropertiesUtil.TEXT_COLOR2);
        selectRightKeyLabel.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 10));
    }

    private void createRightKeyTextArea() {
        selectRightKeyTextArea = new JTextArea(ViewPropertiesUtil.CLICK_TO_SET_A_KEY);
        selectRightKeyTextArea.setForeground(ViewPropertiesUtil.TEXT_COLOR2);
        selectRightKeyTextArea.setBackground(new Color(0, 0, 0, 0));
        selectRightKeyTextArea.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 10));
        selectRightKeyTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectRightKeyTextArea.setText(ViewPropertiesUtil.PRESS_A_KEY);
                selectRightKeyTextArea.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        rightKey = e.getKeyChar();
                        selectRightKeyTextArea.setText(ViewPropertiesUtil.KEY_SELECTED + rightKey);
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

    private void createLeftKeyLabel() {
        selectLeftKeyLabel = new JLabel(ViewPropertiesUtil.MOVE_LEFT);
        selectLeftKeyLabel.setForeground(ViewPropertiesUtil.TEXT_COLOR2);
        selectLeftKeyLabel.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 10));
    }

    private void createLeftKeyTextArea() {
        selectLeftKeyTextArea = new JTextArea(ViewPropertiesUtil.CLICK_TO_SET_A_KEY);
        selectLeftKeyTextArea.setForeground(ViewPropertiesUtil.TEXT_COLOR2);
        selectLeftKeyTextArea.setBackground(new Color(0, 0, 0, 0));
        selectLeftKeyTextArea.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 10));
        selectLeftKeyTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectLeftKeyTextArea.setText(ViewPropertiesUtil.PRESS_A_KEY);
                selectLeftKeyTextArea.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        leftKey = e.getKeyChar();
                        selectLeftKeyTextArea.setText(ViewPropertiesUtil.KEY_SELECTED + rightKey);
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

    private void createNoteLabel() {
        noteLabel = new JLabel(ViewPropertiesUtil.NOTE);
        noteLabel.setForeground(ViewPropertiesUtil.TEXT_COLOR2);
        noteLabel.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 7));
        noteLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void createBackButton() {
        backButton = new JButton(ViewPropertiesUtil.BACK_BUTTON);
        backButton.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 20));
        backButton.setBackground(ViewPropertiesUtil.TEXT_COLOR);
        backButton.setForeground(ViewPropertiesUtil.TEXT_COLOR2);
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        backButton.addActionListener(e -> {
            if (leftKey == 0 || rightKey == 0){
                JOptionPane.showMessageDialog(null, "Select a key","ERROR", JOptionPane.ERROR_MESSAGE);
            }else {
                managerView.backToMenu();
                managerView.presenter.sendPlayerKeys(leftKey,rightKey);
            }
        });
    }

    private void addComponents(GridBagConstraints gbc) {

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(settingsLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 20);
        add(selectRightKeyLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 20, 0, 0);
        add(selectRightKeyTextArea, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 20);
        add(selectLeftKeyLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 20, 0, 0);
        add(selectLeftKeyTextArea, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(noteLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(backButton, gbc);
    }


    public void run() {
        this.setVisible(true);
    }

    public void close() {
        this.setVisible(false);
    }

    public int getRightKey() {
        return rightKey;
    }

    public int getLeftKey() {
        return leftKey;
    }
}
