package goBang;


import sun.awt.image.ToolkitImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StartJFrame extends JFrame {

    private ChessBoard chessBoard;
    private JPanel toolbar;
    private JButton startButton, backButton, exitButton;

    private JMenuBar menuBar;
    private JMenu sysMenu;
    private JMenuItem startMenuItem, exitMenuItem, backMenuItem;


    public StartJFrame() {
        setTitle("单机版五子棋");//设置标题

        //游戏入口
        chessBoard = new ChessBoard();

        setResizable(false);//窗口不能用户手动调整
        setLocationRelativeTo(null);//开始窗口出现在屏幕中央

        Container contentPane = getContentPane();
        //contentPane.add(chessBoard);
        //chessBoard.setOpaque(true);

        //创建和添加菜单
        menuBar = new JMenuBar();//初始化菜单栏
        sysMenu = new JMenu("系统");//初始化菜单

        //初始化菜单项
        startMenuItem = new JMenuItem("重新开始");
        exitMenuItem = new JMenuItem("退出");
        backMenuItem = new JMenuItem("悔棋");

        //将三个菜单项添加到菜单上
        sysMenu.add(startMenuItem);
        sysMenu.add(exitMenuItem);
        sysMenu.add(backMenuItem);

        //初始化按钮事件监听器内部类
        StartJFrame.MyItemListener lis = new StartJFrame.MyItemListener();

        //将三个菜单注册到事件监听器上
        this.startMenuItem.addActionListener(lis);
        backMenuItem.addActionListener(lis);
        exitMenuItem.addActionListener(lis);

        menuBar.add(sysMenu);//将系统菜单添加到菜单栏上
        setJMenuBar(menuBar);//将menuBar设置为菜单栏

        toolbar = new JPanel();//工具面板实例化

        //三个按钮初始化
        startButton = new JButton("重新开始");
        exitButton = new JButton("退出");
        backButton = new JButton("悔棋");

        //将工具面板按钮用FlowLayout布局
        toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
        //将三个按钮添加到工具面板
        toolbar.add(startButton);
        toolbar.add(exitButton);
        toolbar.add(backButton);
        //将三个按钮注册监听事件
        startButton.addActionListener(lis);
        exitButton.addActionListener(lis);
        backButton.addActionListener(lis);
        //将工具面板布局到界面”南方“也就是下方
        add(toolbar, BorderLayout.SOUTH);

        //add(chessBoard);//将面板对象添加到窗体上(游戏主体)
        //设置界面关闭事件
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //setSize(800,800);
        pack();//自适应大小
    }

    private class MyItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();//获得事件源
            if (obj == StartJFrame.this.startMenuItem || obj == startButton) {
                //重新开始
                //JFiveFrame.this内部类引用外部类
                System.out.println("重新开始");
                //chessBoard.restartGame();
            } else if (obj == exitMenuItem || obj == exitButton)
                System.exit(0);
            else if (obj == backMenuItem || obj == backButton) {
                System.out.println("悔棋...");
                //chessBoard.goback();
            }
        }
    }

    private StartJFrame(int x) {
        Frame frame = new Frame();

        frame.setBackground(Color.pink);

        frame.setVisible(true);

        frame.setSize(700, 700);

        frame.setLocation(400, 70);

        frame.setResizable(false);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        Panel toolbar = new Panel();
        toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));

        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");

        toolbar.add(button1);
        toolbar.add(button2);
        toolbar.add(button3);

        //frame.setLayout(new FlowLayout());

/*
        frame.add(button1);
        frame.add(button2,BorderLayout.SOUTH);
        frame.add(button3);
*/
        frame.add(toolbar, BorderLayout.SOUTH);


        Image icon = Toolkit.getDefaultToolkit().getImage("卡通.jpeg");

        frame.setIconImage(icon);

        frame.setTitle("五子棋单机版");

        //frame.pack();
    }


    public static void main(String[] args) {
        StartJFrame jFrame = new StartJFrame();
    }
}
