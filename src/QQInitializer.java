import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class QQInitializer extends JFrame {
    private int x = 0, y = 0; // 用来存放拖动窗口时鼠标的当前位置
    private LoginButtonListener loginButtonListener; // 登陆按钮的监听对象
    private JFrame frame; // frame窗口
    private JButton miniButton; // 最小化按钮
    private JButton closeButton; // 关闭按钮
    private JButton loginButton; // 登录按钮
    private JPanel northPanel; // 北部面板
    private JPanel westPanel; // 西部面板
    private JPanel centerPanel; // 中部面板
    private JPanel eastPanel; // 东部面板
    private JPanel southPanel; // 南部面板
    private JLabel northLabel; // 北部标签
    private JLabel westLabel; // 西部标签
    private JLabel codeLabel; // 忘记密码标签
    private JLabel enrollLabel; // 注册账号标签
    private JTextField text; // 账号文本框
    private JPasswordField codeWord; // 密码框
    private JCheckBox auto; // 自动登录复选框
    private JCheckBox mima; // 记住密码复选框
    private static boolean mimaState; // 记住密码复选框的当前状态
    private static boolean loginState; // 自动登录复选框的当前状态
    double time; // 让主界面停留的时间
    private static String id; // 储存记住的账号

    private static final String ACCOUNT = "1151214419"; // 账号
    private static final String PASSWORD = "123456"; // 密码

    // 用到的图片在 src/images 中
    private static final String IMAGE_PATH = System.getProperty("user.dir") + "\\src\\images\\";

    // 保存账号、记住密码、自动登录的文件
    private static final String TEMP_FILE_PATH = System.getProperty("user.dir") + "\\src\\temp\\";

    // 登录窗口的宽高
    private final int WIDTH = 500;
    private final int HEIGHT = 340;

    // 自动登录时, 登录界面的停留时间(单位：秒)
    private final int BLOCK_TIME = 2;

    public static void run() {
        new QQInitializer();
    }

    // 初始化界面
    public QQInitializer() {
        init();
    }

    private void init() {
        frame = new JFrame("QQ登录");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
//        frame.setBounds((d.width - d.width / 3) / 2, (d.height - d.height / 3) / 2, 500, 330);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(d.width / 2 - frame.getWidth() / 2, d.height / 2 - frame.getHeight() / 2);
        frame.setIconImage(t.getImage(getImagePath("icon.jpg")));
        frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
        frame.setUndecorated(true);//取消自带的边框
        frame.setResizable(false);
        northPanel = createNorth();
        westPanel = createWest();
        centerPanel = createCenter();
        southPanel = createSouth();
        eastPanel = createEast();
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(westPanel, BorderLayout.WEST);
        frame.add(southPanel, BorderLayout.SOUTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(eastPanel, BorderLayout.EAST);

        // 由于将 JFrame 自带的边框隐藏了，所以需要通过下面的方法来实现窗口的拖动功能
        frame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                x = e.getX(); // 鼠标的 X
                y = e.getY(); // 鼠标的 Y
            }
        });
        frame.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                int xScreen = e.getXOnScreen();
                int yScreen = e.getYOnScreen();
                int posX = xScreen - x;
                int posY = yScreen - y;
                frame.setLocation(posX, posY);
            }
        });
        // 此句必须放在最后
        frame.setVisible(true);
        if (auto.isSelected()) {
            loginButton.setEnabled(false);
            System.out.println(BLOCK_TIME + " 秒后自动登录...");
            Date d1 = new Date();
            try {
                TimeUnit.SECONDS.sleep(BLOCK_TIME); // 停留一秒
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            Date d2 = new Date();
            time = (double) ((d2.getTime() - d1.getTime()) / 1000);
        }

        // 是否自动登录（在这个 BLOCK_TIME 秒内, 如果没有将自动登录的复选框去掉, 则自动登录; 否则不登录）
        if (time == BLOCK_TIME && auto.isSelected()) {
            frame.dispose();
            onSuccess(true);
        } else if (time == BLOCK_TIME) {
            loginButton.setEnabled(true);
            File file1 = new File(getTempFilePath("autologin.txt"));
            OutputStream os;
            try {
                os = new FileOutputStream(file1);
                byte[] b = "false".getBytes();
                os.write(b);
                os.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * 创建北部面板
     */
    public JPanel createNorth() {
        JPanel northPanel = new JPanel();
        northPanel.setLayout(null);
        northPanel.setPreferredSize(new Dimension(0, 190));
        ImageIcon in = new ImageIcon(getImagePath("b.jpg"));
        JLabel cc = new JLabel(in);
        cc.setBounds(0, 0, 500, 190);
        cc.setOpaque(false);

        closeButton = new JButton(new ImageIcon(getImagePath("close_normal.png"))); // 将图片作为按钮的背景
        closeButton.setRolloverIcon(new ImageIcon(getImagePath("close_hover.png"))); // 鼠标进入按钮时切换图片
        closeButton.setPressedIcon(new ImageIcon(getImagePath("close_hover.png"))); // 鼠标按下按钮时切换图片
        closeButton.setBounds(468, 0, 30, 30);
        closeButton.setToolTipText("关闭");
        closeButton.setContentAreaFilled(false); // 设置按钮透明
        closeButton.setBorderPainted(false); // 取消按钮的边框
        closeButton.setFocusPainted(false); // 消除按钮的焦点，即点击按钮时不出现边框
        closeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // 将鼠标设置为手掌型

        miniButton = new JButton(new ImageIcon(getImagePath("mini.jpg")));
        miniButton.setRolloverIcon(new ImageIcon(getImagePath("mini.png")));
        miniButton.setPressedIcon(new ImageIcon(getImagePath("mini.png")));
        miniButton.setBounds(437, 0, 30, 30);
        miniButton.setToolTipText("最小化");
        miniButton.setContentAreaFilled(false);
        miniButton.setBorderPainted(false);
        miniButton.setFocusPainted(false);
        miniButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // 将鼠标设置为手掌型

        northPanel.add(closeButton);
        northPanel.add(miniButton);
        northPanel.add(cc);

        closeButton.addActionListener(new closeButtonListener());
        miniButton.addActionListener(new miniButtonListener());

        return northPanel;
    }

    /**
     * 创建西部面板
     */
    public JPanel createWest() {
        JPanel westPanel = new JPanel();
        westPanel.setLayout(null);
        westPanel.setPreferredSize(new Dimension(160, 0));
        ImageIcon ss = new ImageIcon(getImagePath("qq.png"));
        JLabel cs = new JLabel(ss);
        cs.setBounds(35, 0, 100, 100);
        westPanel.add(cs);
        return westPanel;
    }

    /**
     * 创建中部面板
     */
    public JPanel createCenter() {
        File file = new File(getTempFilePath("rememberme.txt"));
        if (file.exists()) {
            InputStream input = null;
            try {
                input = new FileInputStream(file);
                byte[] b = new byte[(int) file.length()];
                input.read(b);
                mimaState = Boolean.parseBoolean(new String(b));
                input.close();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else {
            mimaState = Boolean.parseBoolean(new String("false"));
        }
        File file1 = new File(getTempFilePath("autologin.txt"));
        if (file1.exists()) {
            InputStream input = null;
            try {
                input = new FileInputStream(file1);
                byte[] b = new byte[(int) file1.length()];
                input.read(b);
                loginState = Boolean.parseBoolean(new String(b));
                input.close();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else{
            loginState = Boolean.parseBoolean(new String("false"));
        }
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(null);
        centerPanel.setPreferredSize(new Dimension(0, 220));
        text = new JTextField(10); // 最多存放10个字
        text.setBounds(0, 10, 200, 30);
        text.setFont(new Font("宋体", Font.BOLD, 17)); // 字体和字体大小
        // 限制 QQ 账号只能输入数字
        text.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyChar();
                int count = 0;
                //System.out.println(key);
                if ((key >= KeyEvent.VK_0 && key <= KeyEvent.VK_9))
                    count++;
                if ((!(key >= KeyEvent.VK_0 && key <= KeyEvent.VK_9)) || (count == 10))
                    e.consume();
            }
        });
        mima = new JCheckBox("记住密码", mimaState);
        mima.setBounds(0, 78, 80, 18);
        auto = new JCheckBox("自动登录", loginState);
        auto.setBounds(110, 78, 80, 18);
        text.addFocusListener(new JTextFieldListener(text, mima, "QQ号"));
        text.setOpaque(false);
        centerPanel.add(text);
        codeWord = new JPasswordField(18);
        codeWord.setBounds(0, 42, 200, 30);
        codeWord.setFont(new Font("宋体", Font.BOLD, 17));
        codeWord.addFocusListener(new JPasswordFieldListener(codeWord, mima, "密码"));
        codeWord.setOpaque(false);
        centerPanel.add(mima);
        centerPanel.add(codeWord);
        centerPanel.add(auto);

        // 将账号框和密码框注册到登陆按扭的事件处理上
        loginButtonListener = new LoginButtonListener(text, codeWord, mima, auto);
        return centerPanel;
    }

    /**
     * 创建南部面板
     */
    public JPanel createSouth() {
        JPanel southPanel = new JPanel();
        southPanel.setLayout(null);
        southPanel.setPreferredSize(new Dimension(0, 40));

        loginButton = new JButton("登 录", new ImageIcon(getImagePath("login_normal.png"))); // 登录
        loginButton.setRolloverIcon(new ImageIcon(getImagePath("login_hover.png"))); // 鼠标进入按钮时切换图片
        loginButton.setPressedIcon(new ImageIcon(getImagePath("login_hover.png"))); // 鼠标按下按钮时切换图片
        loginButton.setBounds(160, 0, 200, 30);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // 将鼠标设置为手掌型
        loginButton.setContentAreaFilled(false);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false); // 取消按钮的边框
        loginButton.setFocusPainted(false); // 消除按钮的焦点，即点击按钮时不出现边框
        loginButton.setVerticalTextPosition(SwingConstants.CENTER);
        loginButton.setHorizontalTextPosition(SwingConstants.CENTER);
        loginButton.setFont(new Font("宋体", Font.BOLD, 15));
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.addActionListener(loginButtonListener);

        // 右下角的二维码
        JButton QRCodeButton = new JButton(new ImageIcon(getImagePath("right_normal.png"))); // 将图片作为按钮的背景
        QRCodeButton.setLayout(null);
        QRCodeButton.setRolloverIcon(new ImageIcon(getImagePath("right_hover.png"))); // 鼠标进入按钮时切换图片
        QRCodeButton.setPressedIcon(new ImageIcon(getImagePath("right_hover.png"))); // 鼠标按下按钮时切换图片
        QRCodeButton.setBounds(WIDTH - 46, 0, 30, 30);
        QRCodeButton.setToolTipText("扫码登录");
        QRCodeButton.setContentAreaFilled(false); // 设置按钮透明
        QRCodeButton.setBorderPainted(false); // 取消按钮的边框
        QRCodeButton.setFocusPainted(false); // 消除按钮的焦点，即点击按钮时不出现边框
        QRCodeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // 将鼠标设置为手掌型

        southPanel.add(loginButton);
        southPanel.add(QRCodeButton);

        return southPanel;
    }

    /**
     * 创建东部面板
     */
    public JPanel createEast() {
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(null);
        eastPanel.setPreferredSize(new Dimension(130, 0));

        enrollLabel = new JLabel("注册账号");
        enrollLabel.setBounds(0, 10, 100, 30);
        enrollLabel.setFont(new Font("宋体", Font.BOLD, 15));
        enrollLabel.setForeground(new Color(100, 149, 238));
        enrollLabel.addMouseListener(new LabelAdapter(enrollLabel, "注册账号"));
        enrollLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // 将鼠标设置为手型

        codeLabel = new JLabel("忘记密码");
        codeLabel.setBounds(0, 42, 100, 30);
        codeLabel.setFont(new Font("宋体", Font.BOLD, 15));
        codeLabel.setForeground(new Color(100, 149, 238));
        codeLabel.addMouseListener(new LabelAdapter(codeLabel, "忘记密码"));
        codeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        eastPanel.add(enrollLabel);
        eastPanel.add(codeLabel);

        return eastPanel;
    }

    /**
     * 北部面板关闭按钮的事件处理
     */
    class closeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //frame.dispose();
            System.exit(0);
        }
    }

    /**
     * 北部面板最小化按钮的事件处理
     */
    class miniButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            frame.setExtendedState(frame.ICONIFIED);
        }
    }

    /*
     * 南部的登录按钮的事件处理
     */
    class LoginButtonListener implements ActionListener {
        private JTextField t;
        private JPasswordField f;
        private JCheckBox mima;
        private JCheckBox login;

        public LoginButtonListener(JTextField t, JPasswordField f, JCheckBox mima, JCheckBox login) {
            this.t = t;
            this.f = f;
            this.mima = mima;
            this.login = login;
        }

        public void actionPerformed(ActionEvent e) {
            String account = t.getText();
            String password = new String(f.getPassword());
            File rememberMimaFile = new File(getTempFilePath("rememberme.txt"));
            File autoLoginFile = new File(getTempFilePath("autologin.txt"));
            if (ACCOUNT.equals(account) && PASSWORD.equals(password)) {
                // 如果登录时记住了密码, 则记录状态, 下次登录时自动填充账号和密码
                if (mima.isSelected()) {
                    File file2 = new File(getTempFilePath("account.txt"));
                    try {
                        FileUtils.createFile(getTempFilePath("account.txt"));
                        OutputStream os1 = new FileOutputStream(file2);
                        byte[] b1 = account.getBytes();
                        os1.write(b1);
                        os1.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        FileUtils.createFile(getTempFilePath("rememberme.txt"));
                        OutputStream os = new FileOutputStream(rememberMimaFile);
                        byte[] b = "true".getBytes();
                        os.write(b);
                        os.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    try {
                        FileUtils.createFile(getTempFilePath("rememberme.txt"));
                        OutputStream os = new FileOutputStream(rememberMimaFile);
                        byte[] b = "false".getBytes();
                        os.write(b);
                        os.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                // 自动登录
                if (mima.isSelected() && login.isSelected()) {
                    try {
                        FileUtils.createFile(getTempFilePath("autologin.txt"));
                        OutputStream os = new FileOutputStream(autoLoginFile);
                        byte[] b = "true".getBytes();
                        os.write(b);
                        os.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    try {
                        FileUtils.createFile(getTempFilePath("autologin.txt"));
                        OutputStream os = new FileOutputStream(autoLoginFile);
                        byte[] b = "false".getBytes();
                        os.write(b);
                        os.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }

                // 登录成功
                frame.dispose();
                onSuccess(true);

            } else {
                JOptionPane.showMessageDialog(null, "账号或密码错误，请重新输入", "提示消息", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * 实现文本框的焦点功能，当焦点不在文本框内时，显示默认提示信息（QQ号）
     */
    public class JTextFieldListener implements FocusListener {
        private String str;
        private JTextField text1;
        private JCheckBox rememberMima;

        public JTextFieldListener(JTextField text1, JCheckBox rememberMima, String str) {
            this.text1 = text1;
            this.rememberMima = rememberMima;
            this.str = str;
            if (rememberMima.isSelected()) {
                File file = new File(getTempFilePath("account.txt"));
                try {
                    InputStream in = new FileInputStream(file);
                    byte[] bn = new byte[(int) file.length()];
                    in.read(bn);
                    in.close();
                    id = new String(bn);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                text1.setText(new String(id));
                text1.setForeground(Color.BLACK);

            } else {
                text1.setText(str);
                text1.setForeground(Color.gray);
            }
        }

        public void focusGained(FocusEvent e) {
            if (text1.getText().equals(str)) {
                text1.setText("");
                text1.setForeground(Color.BLACK);
            }
        }

        public void focusLost(FocusEvent e) {

            if (text1.getText().equals("")) {
                text1.setForeground(Color.gray);
                text1.setText(str);
            }
        }
    }

    /**
     * 实现密码框的焦点功能，当焦点不在密码框内时，显示默认提示信息（密码）
     */
    public class JPasswordFieldListener implements FocusListener {
        private String str;
        private JPasswordField text1;
        private JCheckBox rememberMima;

        public JPasswordFieldListener(JPasswordField text1, JCheckBox rememberMima, String str) {
            this.text1 = text1;
            this.rememberMima = rememberMima;
            this.str = str;
            if (rememberMima.isSelected()) {
                String strMima = PASSWORD;
                text1.setText(strMima);
                text1.setEchoChar('*');
                text1.setForeground(Color.BLACK);
            } else {
                text1.setText(str);
                text1.setEchoChar((char) (0));//不设置回显
                text1.setForeground(Color.gray);
            }
        }

        public void focusGained(FocusEvent e) {
            if (text1.getText().equals(str)) {
                text1.setText("");
                text1.setEchoChar('*'); // 将回显设置为'*'
                text1.setForeground(Color.BLACK);
            }
        }

        public void focusLost(FocusEvent e) {
            if (text1.getText().equals("")) {
                text1.setEchoChar((char) (0));
                text1.setForeground(Color.gray);
                text1.setText(str);
            }
        }
    }

    /**
     * 对注册账号和忘记密码的标签添加鼠标事件
     */
    public class LabelAdapter extends MouseAdapter {
        private JFrame jf;
        private JLabel la;
        private String title;

        public LabelAdapter(JLabel la, String title) {
            this.la = la;
            this.title = title;
        }

        public void mouseClicked(MouseEvent e) {
            jf = new JFrame(title);
            Toolkit t = Toolkit.getDefaultToolkit();
            Dimension d = t.getScreenSize();
            jf.setBounds((d.width - d.width / 3) / 2, (d.height - d.height / 3) / 2, 500, 330);
            jf.setBounds(500, 300, 500, 200);
            jf.setVisible(true);
            jf.setResizable(false);
        }

        public void mouseEntered(MouseEvent e) {
            la.setForeground(new Color(255, 77, 35));
        }

        public void mousePressed(MouseEvent e) {
            la.setForeground(new Color(255, 77, 35));
        }

        public void mouseExited(MouseEvent e) {
            la.setForeground(new Color(100, 149, 238));
        }
    }

    /**
     * 登录成功后的回调
     */
    private void onSuccess(boolean message) {
        if (message) {
            if (auto.isSelected() && time == BLOCK_TIME) {
                JOptionPane.showMessageDialog(null, "自动登录成功", "提示消息", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "登录成功", "提示消息", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        JFrame jf = new JFrame("QQ主页");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        jf.setIconImage(t.getImage(getImagePath("icon.jpg")));
//        jf.setSize(WIDTH, HEIGHT);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE); // 关闭时, 退出程序


        // 设置背景图片
        ImageIcon background = new ImageIcon(getImagePath("qqSuccess.png"));
        JLabel label = new JLabel(background);
        // 把标签的大小位置设置为图片刚好填充整个面板
        label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        JPanel imagePanel = (JPanel) jf.getContentPane();
        imagePanel.setOpaque(false);
        // 内容窗格默认的布局管理器为BorderLayout
        imagePanel.setLayout(new FlowLayout());
        jf.getLayeredPane().setLayout(null);
        // 把背景图片添加到分层窗格的最底层作为背景
        jf.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        jf.setSize(background.getIconWidth(), background.getIconHeight());
//        jf.setLocation(d.width / 2 - jf.getWidth() / 2, d.height / 2 - jf.getHeight() / 2);
        jf.setLocation(d.width - d.width / 4  , d.height / 7);

        jf.setVisible(true);
    }

    private String getImagePath(String imageName) {
        if (imageName == null || imageName.trim().length() == 0) {
            throw new RuntimeException("图片名称不能为空");
        }
        return IMAGE_PATH + imageName;
    }

    private String getTempFilePath(String fileName) {
        if (fileName == null || fileName.trim().length() == 0) {
            throw new RuntimeException("图片名称不能为空");
        }
        return TEMP_FILE_PATH + fileName;
    }
}

