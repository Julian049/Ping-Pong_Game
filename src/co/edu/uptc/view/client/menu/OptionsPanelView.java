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
    private JLabel selectUpKeyLabel;
    private JTextArea selectUpKeyTextArea;
    private JLabel selectDownKeyLabel;
    private JTextArea selectDownKeyTextArea;
    private JLabel selectThrowBallLabel;
    private JTextArea selectThrowBallTextArea;
    private JLabel noteLabel;
    private JButton backButton;
    private int upKey;
    private int downKey;
    private int throwKey;
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
        createUpKeyTextArea();
        createUpKeyLabel();
        createDownKeyTextArea();
        createDownKeyLabel();
        createThrowBallKeyTextArea();
        createThrowBallKeyLabel();
        createNoteLabel();
        createBackButton();
    }

    private void createSettingsLabel() {
        settingsLabel = new JLabel(ViewPropertiesUtil.SETTINGS_BUTTON);
        settingsLabel.setForeground(ViewPropertiesUtil.TEXT_COLOR);
        settingsLabel.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 30));
        settingsLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void createUpKeyLabel() {
        selectUpKeyLabel = new JLabel(ViewPropertiesUtil.MOVE_UP);
        selectUpKeyLabel.setForeground(ViewPropertiesUtil.TEXT_COLOR2);
        selectUpKeyLabel.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 10));
    }

    private void createUpKeyTextArea() {
        selectUpKeyTextArea = new JTextArea(ViewPropertiesUtil.CLICK_TO_SET_A_KEY);
        selectUpKeyTextArea.setForeground(ViewPropertiesUtil.TEXT_COLOR2);
        selectUpKeyTextArea.setBackground(new Color(0, 0, 0, 0));
        selectUpKeyTextArea.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 10));
        selectUpKeyTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectUpKeyTextArea.setText(ViewPropertiesUtil.PRESS_A_KEY);
                selectUpKeyTextArea.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        upKey = Character.toUpperCase(e.getKeyChar());
                        selectUpKeyTextArea.setText(ViewPropertiesUtil.KEY_SELECTED + upKey);
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
        selectUpKeyTextArea.setEditable(false);
        selectUpKeyTextArea.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void createDownKeyLabel() {
        selectDownKeyLabel = new JLabel(ViewPropertiesUtil.MOVE_DOWN);
        selectDownKeyLabel.setForeground(ViewPropertiesUtil.TEXT_COLOR2);
        selectDownKeyLabel.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 10));
    }

    private void createDownKeyTextArea() {
        selectDownKeyTextArea = new JTextArea(ViewPropertiesUtil.CLICK_TO_SET_A_KEY);
        selectDownKeyTextArea.setForeground(ViewPropertiesUtil.TEXT_COLOR2);
        selectDownKeyTextArea.setBackground(new Color(0, 0, 0, 0));
        selectDownKeyTextArea.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 10));
        selectDownKeyTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectDownKeyTextArea.setText(ViewPropertiesUtil.PRESS_A_KEY);
                selectDownKeyTextArea.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        downKey = Character.toUpperCase(e.getKeyChar());
                        selectDownKeyTextArea.setText(ViewPropertiesUtil.KEY_SELECTED + downKey);
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
        selectDownKeyTextArea.setEditable(false);
        selectDownKeyTextArea.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void createThrowBallKeyLabel() {
        selectThrowBallLabel = new JLabel(ViewPropertiesUtil.THROW_BALL);
        selectThrowBallLabel.setForeground(ViewPropertiesUtil.TEXT_COLOR2);
        selectThrowBallLabel.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 10));
    }

    private void createThrowBallKeyTextArea() {
        selectThrowBallTextArea = new JTextArea(ViewPropertiesUtil.CLICK_TO_SET_A_KEY);
        selectThrowBallTextArea.setForeground(ViewPropertiesUtil.TEXT_COLOR2);
        selectThrowBallTextArea.setBackground(new Color(0, 0, 0, 0));
        selectThrowBallTextArea.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 10));
        selectThrowBallTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectThrowBallTextArea.setText(ViewPropertiesUtil.PRESS_A_KEY);
                selectThrowBallTextArea.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        throwKey = Character.toUpperCase(e.getKeyChar());
                        selectThrowBallTextArea.setText(ViewPropertiesUtil.KEY_SELECTED + throwKey);
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
        selectThrowBallTextArea.setEditable(false);
        selectThrowBallTextArea.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
            if (downKey == 0 || upKey == 0 || throwKey == 0){
                JOptionPane.showMessageDialog(null, ViewPropertiesUtil.ANY_KEY_SELECTED_ERROR, ViewPropertiesUtil.ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
            }else {
                managerView.backToMenu();
                managerView.presenter.sendPlayerKeys(upKey,downKey,throwKey);
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
        add(selectUpKeyLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 20, 0, 0);
        add(selectUpKeyTextArea, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 20);
        add(selectDownKeyLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 20, 0, 0);
        add(selectDownKeyTextArea, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 20);
        add(selectThrowBallLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 20, 0, 0);
        add(selectThrowBallTextArea, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(noteLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(backButton, gbc);
    }


    public void run() {
        this.setVisible(true);
    }

    public void close() {
        this.setVisible(false);
    }

    public int getUpKey() {
        return upKey;
    }

    public int getDownKey() {
        return downKey;
    }

    public void setUpKey(int upKey) {
        this.upKey = upKey;
    }

    public void setDownKey(int downKey) {
        this.downKey = downKey;
    }

    public void setThrowKey(int throwKey) {
        this.throwKey = throwKey;
    }

    public int getThrowKey() {
        return throwKey;
    }
}
