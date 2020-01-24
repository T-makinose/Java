import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.util.*;
import java.awt.Color;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.border.EtchedBorder;

//import Ludigerr.Icon.Imag selectIconSet;

public class MyClient extends JFrame implements MouseListener, MouseMotionListener,KeyListener,ItemListener {
    private JButton buttonArray[][];
    private JButton helpButton[];
    private JButton gameStarButton;
    private JTextArea menuText;
    private JTextArea coveAreas;
    private JTextField nameField;
    private JTextField ipField;
    private JLabel eJLabel;
    private JLabel back;
    private Choice eSelect;
    private Container c;
    private ImageIcon boardIcon1, boardIcon2, Ludiger_B, Ludiger_R, Sword_B, Sword_R, Wizard_B, Wizard_R, Shield_B, Shield_R,
            Fenlia_B, Fenlia_R, Midne_B, Midne_R, Syuranoruaos_B, Syuranoruaos_R, Tiscater_B, Tiscater_R;
    private ImageIcon helpBoard, Shield_atk, Shield_move, Sword_atk, Sword_move, Wizard_move, Wizard_atk, Ludiger_move, Ludiger_atk, Fenlia_move, Fenlia_atk,
            Midne_move, Midne_atk, Syuranoruaos_move, Syuranoruaos_atk, Tiscater_move, Tiscater_atk;
    private ImageIcon start;
    private ImageIcon back1,back2;
    PrintWriter out;
    private int myColor, myTurn;
    private ImageIcon myIcon, yourIcon, sacrificeIcon;
    JButton bs = new JButton("Send");
    private int button_Size = 110;
    private HashMap<JButton, String> iconmap = new HashMap<JButton, String>();
    private HashMap<String, Integer> hpmap = new HashMap<String, Integer>();
    private HashMap<String, Integer> atkmap = new HashMap<String, Integer>();
    private int selectNum = -1;
    private int selMyIcon = 0, selEnemyIcon = 0;
    private String myName;
    private String myIPAdress;
    private boolean is_Start_Set = true;
    private boolean is_Select = false;
    private boolean is_Move = false;
    private boolean is_atk = false;
    private boolean isEnd = false;
    private boolean isStart=false;

    public void selectIconSet() {
        boardIcon1 = new ImageIcon("BoardImage1.png");
        boardIcon2 = new ImageIcon("BoardImage2.png");
        Ludiger_B = new ImageIcon("Ludiger_B.png");
        Ludiger_R = new ImageIcon("Ludiger_R.png");
        Sword_B = new ImageIcon("Sword_B.png");
        Sword_R = new ImageIcon("Sword_R.png");
        Wizard_B = new ImageIcon("Wizard_B.png");
        Wizard_R = new ImageIcon("Wizard_R.png");
        Shield_B = new ImageIcon("Shield_B.png");
        Shield_R = new ImageIcon("Shield_R.png");
        Fenlia_B = new ImageIcon("Fenlia_B.png");
        Fenlia_R = new ImageIcon("Fenlia_R.png");
        Midne_B = new ImageIcon("Midne_B.png");
        Midne_R = new ImageIcon("Midne_R.png");
        Syuranoruaos_B = new ImageIcon("Syuranoruaos_B.png");
        Syuranoruaos_R = new ImageIcon("Syuranoruaos_R.png");
        Tiscater_B = new ImageIcon("Tiscater_B.png");
        Tiscater_R = new ImageIcon("Tiscater_R.png");

        //helpMenup
        helpBoard = new ImageIcon("fieldSample.png");
        Shield_move = new ImageIcon("Shield_move.png");
        Shield_atk = new ImageIcon("Shield_atk.png");
        Sword_move = new ImageIcon("Sword_move.png");
        Sword_atk = new ImageIcon("Sword_atk.png");
        Wizard_move = new ImageIcon("Wizard_move.png");
        Wizard_atk = new ImageIcon("Wizard_atk.png");
        Ludiger_move = new ImageIcon("Ludiger_move.png");
        Ludiger_atk = new ImageIcon("Ludiger_atk.png");
        Fenlia_move = new ImageIcon("Fenlia_move.png");
        Fenlia_atk = new ImageIcon("Fenlia_atk.png");
        Syuranoruaos_move = new ImageIcon("Syuranoruaos_move.png");
        Syuranoruaos_atk = new ImageIcon("Syuranoruaos_atk.png");
        Midne_move = new ImageIcon("Midne_move.png");
        Midne_atk = new ImageIcon("Midne_atk.png");
        Tiscater_move = new ImageIcon("Tiscater_move.png");
        Tiscater_atk = new ImageIcon("Tiscater_atk.png");
    }

    public void GameStart(int myColor, int selMyIcon) {
        if (myColor == 0 && myTurn == 0) {
            buttonArray[0][0].setIcon(Wizard_B);
            buttonArray[0][4].setIcon(Wizard_B);
            buttonArray[0][2].setIcon(Ludiger_B);
            buttonArray[0][1].setIcon(Fenlia_B);
            buttonArray[1][1].setIcon(Sword_B);
            buttonArray[1][3].setIcon(Sword_B);
            buttonArray[2][0].setIcon(Shield_B);
            buttonArray[2][2].setIcon(Shield_B);
            buttonArray[2][4].setIcon(Shield_B);
            switch (selEnemyIcon) {
                case 0:
                    buttonArray[0][3].setIcon(Syuranoruaos_B);
                    break;
                case 1:
                    buttonArray[0][3].setIcon(Midne_B);
                    break;
                case 2:
                    buttonArray[0][3].setIcon(Tiscater_B);
                    break;
            }

            buttonArray[4][0].setIcon(Shield_R);
            buttonArray[4][2].setIcon(Shield_R);
            buttonArray[4][4].setIcon(Shield_R);
            buttonArray[5][1].setIcon(Sword_R);
            buttonArray[5][3].setIcon(Sword_R);
            buttonArray[6][0].setIcon(Wizard_R);
            buttonArray[6][4].setIcon(Wizard_R);
            buttonArray[6][3].setIcon(Fenlia_R);
            buttonArray[6][2].setIcon(Ludiger_R);
            switch (selMyIcon) {
                case 0:
                    buttonArray[6][1].setIcon(Syuranoruaos_R);
                    break;
                case 1:
                    buttonArray[6][1].setIcon(Midne_R);
                    break;
                case 2:
                    buttonArray[6][1].setIcon(Tiscater_R);
                    break;
            }
        } else {
            buttonArray[0][0].setIcon(Wizard_R);
            buttonArray[0][4].setIcon(Wizard_R);
            buttonArray[0][2].setIcon(Ludiger_R);
            buttonArray[0][1].setIcon(Fenlia_R);
            buttonArray[1][1].setIcon(Sword_R);
            buttonArray[1][3].setIcon(Sword_R);
            buttonArray[2][0].setIcon(Shield_R);
            buttonArray[2][2].setIcon(Shield_R);
            buttonArray[2][4].setIcon(Shield_R);

            switch (selEnemyIcon) {
                case 0:
                    buttonArray[0][3].setIcon(Syuranoruaos_R);
                    break;
                case 1:
                    buttonArray[0][3].setIcon(Midne_R);
                    break;
                case 2:
                    buttonArray[0][3].setIcon(Tiscater_R);
                    break;
            }

            buttonArray[4][0].setIcon(Shield_B);
            buttonArray[4][2].setIcon(Shield_B);
            buttonArray[4][4].setIcon(Shield_B);
            buttonArray[5][1].setIcon(Sword_B);
            buttonArray[5][3].setIcon(Sword_B);
            buttonArray[6][0].setIcon(Wizard_B);
            buttonArray[6][4].setIcon(Wizard_B);
            buttonArray[6][3].setIcon(Fenlia_B);
            buttonArray[6][2].setIcon(Ludiger_B);

            switch (selMyIcon) {
                case 0:
                    buttonArray[6][1].setIcon(Syuranoruaos_B);
                    break;
                case 1:
                    buttonArray[6][1].setIcon(Midne_B);
                    break;
                case 2:
                    buttonArray[6][1].setIcon(Tiscater_B);
                    break;
            }
        }

        iconmap.put(buttonArray[4][0], "player_Shield_0");//shild
        iconmap.put(buttonArray[4][2], "player_Shield_1");//shild
        iconmap.put(buttonArray[4][4], "player_Shield_2");//shild
        iconmap.put(buttonArray[5][1], "player_Sword_3");//Sword
        iconmap.put(buttonArray[5][3], "player_Sword_4");//Sword
        iconmap.put(buttonArray[6][0], "player_Wizard_5");//Wizard
        iconmap.put(buttonArray[6][4], "player_Wizard_6");//Wizard
        iconmap.put(buttonArray[6][2], "player_Ludiger_7");//Ludiger
        iconmap.put(buttonArray[6][3], "player_Fenlia_8");//Fenlia

        switch (selMyIcon) {
            case 0:
                iconmap.put(buttonArray[6][1], "player_Syuranoruaos_9");
                break;
            case 1:
                iconmap.put(buttonArray[6][1], "player_Midne_9");
                break;
            case 2:
                iconmap.put(buttonArray[6][1], "player_Tiscater_9");
                break;
        }


        iconmap.put(buttonArray[2][0], "enemy_Shield_0");
        iconmap.put(buttonArray[2][2], "enemy_Shield_1");
        iconmap.put(buttonArray[2][4], "enemy_Shield_2");
        iconmap.put(buttonArray[1][1], "enemy_Sword_3");
        iconmap.put(buttonArray[1][3], "enemy_Sword_4");
        iconmap.put(buttonArray[0][0], "enemy_Wizard_5");
        iconmap.put(buttonArray[0][4], "enemy_Wizard_6");
        iconmap.put(buttonArray[0][2], "enemy_Ludiger_7");
        iconmap.put(buttonArray[0][1], "enemy_Fenlia_8");

        switch (selEnemyIcon) {
            case 0:
                iconmap.put(buttonArray[0][3], "enemy_Syuranoruaos_9");
                break;
            case 1:
                iconmap.put(buttonArray[0][3], "enemy_Midne_9");
                break;
            case 2:
                iconmap.put(buttonArray[0][3], "enemy_Tiscater_9");
                break;
        }


        atkmap.put("player_Shield_0", 1);
        atkmap.put("player_Shield_1", 1);
        atkmap.put("player_Shield_2", 1);
        atkmap.put("player_Sword_3", 1);//Wizard
        atkmap.put("player_Sword_4", 1);
        atkmap.put("player_Wizard_5", 1);//Sword
        atkmap.put("player_Wizard_6", 1);
        atkmap.put("player_Ludiger_7", 2);
        atkmap.put("player_Fenlia_8", 10);

        switch (selMyIcon) {
            case 0:
                atkmap.put("player_Syuranoruaos_9", 1);
                break;
            case 1:
                atkmap.put("player_Midne_9", 1);
                break;
            case 2:
                atkmap.put("player_Tiscater_9", 1);
                break;
        }

        atkmap.put("enemy_Shield_0", 1);
        atkmap.put("enemy_Shield_1", 1);
        atkmap.put("enemy_Shield_2", 1);
        atkmap.put("enemy_Sword_3", 1);//Wizard
        atkmap.put("enemy_Sword_4", 1);
        atkmap.put("enemy_Wizard_5", 1);//Sword
        atkmap.put("enemy_Wizard_6", 1);
        atkmap.put("enemy_Ludiger_7", 2);
        atkmap.put("enemy_Fenlia_8", 10);

        switch (selEnemyIcon) {
            case 0:
                atkmap.put("enemy_Syuranoruaos_9", 1);
                break;
            case 1:
                atkmap.put("enemy_Midne_9", 1);
                break;
            case 2:
                atkmap.put("enemy_Tiscater_9", 1);
                break;
        }


        hpmap.put("player_Shield_0", 2);
        hpmap.put("player_Shield_1", 2);
        hpmap.put("player_Shield_2", 2);
        hpmap.put("player_Sword_3", 2);
        hpmap.put("player_Sword_4", 2);
        hpmap.put("player_Wizard_5", 2);
        hpmap.put("player_Wizard_6", 2);
        hpmap.put("player_Ludiger_7", 10000);
        hpmap.put("player_Fenlia_8", 3);

        switch (selMyIcon) {
            case 0:
                hpmap.put("player_Syuranoruaos_9", 3);
                break;
            case 1:
                hpmap.put("player_Midne_9", 3);
                break;
            case 2:
                hpmap.put("player_Tiscater_9", 3);
                break;
        }

        hpmap.put("enemy_Shield_0", 2);
        hpmap.put("enemy_Shield_1", 2);
        hpmap.put("enemy_Shield_2", 2);
        hpmap.put("enemy_Sword_3", 2);
        hpmap.put("enemy_Sword_4", 2);
        hpmap.put("enemy_Wizard_5", 2);
        hpmap.put("enemy_Wizard_6", 2);
        hpmap.put("enemy_Ludiger_7", 10000);
        hpmap.put("enemy_Fenlia_8", 3);

        switch (selEnemyIcon) {
            case 0:
                hpmap.put("enemy_Syuranoruaos_9", 3);
                break;
            case 1:
                hpmap.put("enemy_Midne_9", 3);
                break;
            case 2:
                hpmap.put("enemy_Tiscater_9", 3);
                break;
        }
    }

    public MyClient() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MyClient");
        setSize(1300, 900);
        c = getContentPane();
        getContentPane().setBackground(new Color(240, 255, 255));

        addKeyListener(this);
        


        nameField=new JTextField("名前");
        c.add(nameField);
        nameField.setBounds(550,450,200,50);
        myName=nameField.getText();
        if(myName.equals("名前")){
            myName="";
        }

        ipField=new JTextField("IPアドレスを入力してください");
        c.add(ipField);
        ipField.setBounds(550,500,200,50);

        myIPAdress=ipField.getText();
        if(myIPAdress.equals("IPアドレスを入力してください")){
            myIPAdress="";
        }

        eSelect=new Choice();
        eSelect.add("Syuranoruaos");
        eSelect.add("Midne");
        eSelect.add("Tiscater");
        c.add(eSelect);
        eSelect.setBounds(250,450,200,50);
        eSelect.addItemListener(this);
        
        
        start=new ImageIcon("START.jpg");
        gameStarButton=new JButton(start);
        c.add(gameStarButton);
        iconmap.put(gameStarButton, "0_start_0");
        gameStarButton.setBounds(525,600, 250, 100);
        gameStarButton.addMouseListener(this);
        gameStarButton.setActionCommand(Integer.toString(100));

        back1=new ImageIcon("back2.png");
        back2=new ImageIcon("back.png");
        back=new JLabel(back1);
        c.add(back);
        back.setBounds(0,0,1300,900);
        back.setVisible(true);

        
    }

    public void InGame() {
        
        // String myName = JOptionPane.showInputDialog(null,"名前を入力してください", "名前の入力", JOptionPane.QUESTION_MESSAGE);
        // String myIPAdress = JOptionPane.showInputDialog(null, "IPアドレスを入力してください", "IPアドレスの入力", JOptionPane.QUESTION_MESSAGE);
        if (myName.equals("")) {
            myName = "No name";
        }
        if (myIPAdress.equals("")) {
            myIPAdress = "localhost";
        }

     
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setTitle("MyClient");
        // setSize(1300, 900);
        // c = getContentPane();
        // getContentPane().setBackground(new Color(240, 255, 255));


        selectIconSet();

        c.setLayout(null);
        
        buttonArray = new JButton[7][5];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
                    buttonArray[i][j] = new JButton(boardIcon1);
                    c.add(buttonArray[i][j]);
                    buttonArray[i][j].setBounds(j * button_Size + 50, 50 + i * button_Size, button_Size, button_Size);
                    buttonArray[i][j].setBackground(new Color(0, 0, 0));
                } else {
                    buttonArray[i][j] = new JButton(boardIcon2);
                    c.add(buttonArray[i][j]);
                    buttonArray[i][j].setBounds(j * button_Size + 50, 50 + i * button_Size, button_Size, button_Size);
                    buttonArray[i][j].setBackground(new Color(0, 0, 0));
                }
                buttonArray[i][j].addMouseListener(this);
                buttonArray[i][j].addMouseMotionListener(this);
                buttonArray[i][j].setActionCommand(Integer.toString(i * 5 + j));
                iconmap.put(buttonArray[i][j], "field_0_0");
            }

        }

        helpButton = new JButton[4];
        for (int i=0;i<2;i++) {
            helpButton[i] = new JButton(helpBoard);
            c.add(helpButton[i]);
            helpButton[i].setBounds(620 + i * 300, 110, 250, 250);
        }
        helpButton[2] = new JButton("Board");
        c.add(helpButton[2]);
        helpButton[2].setBounds(620, 50, 150, 50);
        helpButton[2].setFont(new Font("Arial BOLD ITALIC", Font.PLAIN, 16));
        helpButton[2].setForeground(new Color(255,255,255));
        helpButton[2].setBackground(new Color(253,248,235));
        helpButton[2].setEnabled(false);

        helpButton[3] = new JButton("HP:");
        c.add(helpButton[3]);
        helpButton[3].setFont(new Font("Arial BOLD ITALIC", Font.PLAIN, 16));
        helpButton[3].setBounds(920, 50, 120, 50);
        helpButton[3].setBackground(new Color(253,248,235));//252,241,216
        helpButton[3].setEnabled(false);

        menuText = new JTextArea("");
        c.add(menuText);
        menuText.setBounds(620, 440, 550, 350);
        menuText.setMargin(new Insets(50, 50, 50, 50));
        menuText.setPreferredSize(new Dimension(180, 40));
        menuText.setFont(new Font("ＭＳ 明朝", Font.BOLD, 16));
        EtchedBorder border = new EtchedBorder(EtchedBorder.RAISED);
        menuText.setBorder(border);
        menuText.setLineWrap(true);
        menuText.setEditable(false);

        back=new JLabel(back2);
        back.setVisible(true);
        back.setIcon(back2);
        c.add(back);
        back.setBounds(0,0,1300,900);
        back.setVisible(true);
        // coveAreas=new JTextArea("");
        // c.add(coveAreas);
        // coveAreas.setBounds(620, 50, 200, 50);
        // coveAreas.setBackground(new Color(255,0,0));



        Socket socket = null;
        try {
            socket = new Socket("localhost", 10000);
        } catch (UnknownHostException e) {
            System.err.println("ホストの IP アドレスが判定できません:" + e);
        } catch (IOException e) {
            System.err.println("エラーが発生しました: " + e);
        }

        MesgRecvThread mrt = new MesgRecvThread(socket, myName);
        mrt.start();
    }

    public class MesgRecvThread extends Thread {

        Socket socket;
        String myName;

        public MesgRecvThread(Socket s, String n) {
            socket = s;
            myName = n;
        }

        
        public void run() {
            try {
                InputStreamReader sisr = new InputStreamReader(socket.getInputStream());
                BufferedReader br = new BufferedReader(sisr);
                out = new PrintWriter(socket.getOutputStream(), true);
                out.println(myName);
                String myNumberStr = br.readLine();
                int myNumberInt = Integer.parseInt(myNumberStr);

                if (myNumberInt % 2 == 0) {
                    myColor = 0;
                    myTurn = 0;
                } else {
                    myColor = 1;
                    myTurn = 1;
                    //myTurn=0;//debug
                }

                if (is_Start_Set == true) {
                    GameStart(myColor, selMyIcon);
                    is_Start_Set = false;
                    System.out.println("good");
                }

                while (true) {
                    String inputLine = br.readLine();
                    if (inputLine != null) {
                        System.out.println(inputLine);
                        String[] inputTokens = inputLine.split(" ");    
                        String cmd = inputTokens[0];
                        if (cmd.equals("PLACE")) {
                            String placeName = inputTokens[1];
                            String placedName = inputTokens[2];
                            int placeNum = Integer.parseInt(placeName);
                            int placedNum = Integer.parseInt(placedName);
                            resetSelect(placedNum / 5, placedNum % 5);
                            //int color=Integer.parseInt(inputTokens[4]);
                            if (inputTokens[3].equals("Sword")) {
                                if (myTurn == 0) {
                                    int i = placeNum / 5;
                                    int j = placeNum % 5;
                                    int y = placedNum / 5;
                                    int x = placedNum % 5;
                                    SwordMove(i, j, x, y);
                                } else {
                                    int i = 6 - placeNum / 5;
                                    int j = 4 - placeNum % 5;
                                    int y = 6 - placedNum / 5;
                                    int x = 4 - placedNum % 5;
                                    SwordMove(i, j, x, y);
                                }
                            }
                            if (inputTokens[3].equals("Shield")) {
                                if (myTurn == 0) {
                                    int i = placeNum / 5;
                                    int j = placeNum % 5;
                                    int y = placedNum / 5;
                                    int x = placedNum % 5;
                                    ShieldMove(i, j, x, y);
                                } else {
                                    int i = 6 - placeNum / 5;
                                    int j = 4 - placeNum % 5;
                                    int y = 6 - placedNum / 5;
                                    int x = 4 - placedNum % 5;
                                    ShieldMove(i, j, x, y);
                                }
                            }
                            if (inputTokens[3].equals("Wizard")) {
                                if (myTurn == 0) {
                                    int i = placeNum / 5;
                                    int j = placeNum % 5;
                                    int y = placedNum / 5;
                                    int x = placedNum % 5;
                                    WizardMove(i, j, x, y);
                                } else {
                                    int i = 6 - placeNum / 5;
                                    int j = 4 - placeNum % 5;
                                    int y = 6 - placedNum / 5;
                                    int x = 4 - placedNum % 5;
                                    WizardMove(i, j, x, y);
                                }
                            }
                            if (inputTokens[3].equals("Ludiger")) {
                                if (myTurn == 0) {
                                    int i = placeNum / 5;
                                    int j = placeNum % 5;
                                    int y = placedNum / 5;
                                    int x = placedNum % 5;
                                    LudigerMove(i, j, x, y);
                                } else {
                                    int i = 6 - placeNum / 5;
                                    int j = 4 - placeNum % 5;
                                    int y = 6 - placedNum / 5;
                                    int x = 4 - placedNum % 5;
                                    LudigerMove(i, j, x, y);
                                }
                            }
                            if (inputTokens[3].equals("Fenlia")) {
                                if (myTurn == 0) {
                                    int i = placeNum / 5;
                                    int j = placeNum % 5;
                                    int y = placedNum / 5;
                                    int x = placedNum % 5;
                                    FenliaMove(i, j, x, y);
                                } else {
                                    int i = 6 - placeNum / 5;
                                    int j = 4 - placeNum % 5;
                                    int y = 6 - placedNum / 5;
                                    int x = 4 - placedNum % 5;
                                    FenliaMove(i, j, x, y);
                                }
                            }
                            if (inputTokens[3].equals("Syuranoruaos")) {
                                if (myTurn == 0) {
                                    int i = placeNum / 5;
                                    int j = placeNum % 5;
                                    int y = placedNum / 5;
                                    int x = placedNum % 5;
                                    SyuranoruaosMove(i, j, x, y);
                                } else {
                                    int i = 6 - placeNum / 5;
                                    int j = 4 - placeNum % 5;
                                    int y = 6 - placedNum / 5;
                                    int x = 4 - placedNum % 5;
                                    SyuranoruaosMove(i, j, x, y);
                                }
                            }
                            if (inputTokens[3].equals("Midne")) {
                                if (myTurn == 0) {
                                    int i = placeNum / 5;
                                    int j = placeNum % 5;
                                    int y = placedNum / 5;
                                    int x = placedNum % 5;
                                    MidneMove(i, j, x, y);
                                } else {
                                    int i = 6 - placeNum / 5;
                                    int j = 4 - placeNum % 5;
                                    int y = 6 - placedNum / 5;
                                    int x = 4 - placedNum % 5;
                                    MidneMove(i, j, x, y);
                                }
                            }
                            if (inputTokens[3].equals("Tiscater")) {
                                if (myTurn == 0) {
                                    int i = placeNum / 5;
                                    int j = placeNum % 5;
                                    int y = placedNum / 5;
                                    int x = placedNum % 5;
                                    TiscaterMove(i, j, x, y);
                                } else {
                                    int i = 6 - placeNum / 5;
                                    int j = 4 - placeNum % 5;
                                    int y = 6 - placedNum / 5;
                                    int x = 4 - placedNum % 5;
                                    TiscaterMove(i, j, x, y);
                                }
                            }
							/*if(color == myColor){
								//buttonArray[i][j].setIcon(myIcon);
							} else {
								//buttonArray[i][j].setIcon(yourIcon);
							}*/
                        }
                        if (cmd.equals("atk")) {
                            String enemyName = inputTokens[1];
                            String playerName = inputTokens[2];
                            int enemyNum = Integer.parseInt(enemyName);
                            int playerNum = Integer.parseInt(playerName);
                            resetSelect(playerNum / 5, playerNum % 5);
                            //int color=Integer.parseInt(inputTokens[4]);
                            if (inputTokens[3].equals("Sword")) {
                                if (myTurn == 0) {
                                    int i = enemyNum / 5;
                                    int j = enemyNum % 5;
                                    int y = playerNum / 5;
                                    int x = playerNum % 5;
                                    Swordatk(i, j, x, y);
                                    hpChck(i,j,y,x);
                                } else {
                                    int i = 6 - enemyNum / 5;
                                    int j = 4 - enemyNum % 5;
                                    int y = 6 - playerNum / 5;
                                    int x = 4 - playerNum % 5;
                                    Swordatk(i, j, x, y);
                                    hpChck(i,j,y,x);
                                }
                            }
                            if (inputTokens[3].equals("Shield")) {
                                if (myTurn == 0) {
                                    int i = enemyNum / 5;
                                    int j = enemyNum % 5;
                                    int y = playerNum / 5;
                                    int x = playerNum % 5;
                                    Shieldatk(i, j, x, y);
                                    hpChck(i,j,y,x);
                                } else {
                                    int i = 6 - enemyNum / 5;
                                    int j = 4 - enemyNum % 5;
                                    int y = 6 - playerNum / 5;
                                    int x = 4 - playerNum % 5;
                                    Shieldatk(i, j, x, y);
                                    hpChck(i,j,y,x);
                                }
                            }
                            if (inputTokens[3].equals("Wizard")) {
                                if (myTurn == 0) {
                                    int i = enemyNum / 5;
                                    int j = enemyNum % 5;
                                    int y = playerNum / 5;
                                    int x = playerNum % 5;
                                    Wizardatk(i, j, x, y);
                                    hpChck(i,j,y,x);
                                } else {
                                    int i = 6 - enemyNum / 5;
                                    int j = 4 - enemyNum % 5;
                                    int y = 6 - playerNum / 5;
                                    int x = 4 - playerNum % 5;
                                    Wizardatk(i, j, x, y);
                                    hpChck(i,j,y,x);
                                }
                            }
                            if (inputTokens[3].equals("Ludiger")) {
                                if (myTurn == 0) {
                                    int i = enemyNum / 5;
                                    int j = enemyNum % 5;
                                    int y = playerNum / 5;
                                    int x = playerNum % 5;
                                    Ludigeratk(i, j, x, y);
                                    hpChck(i,j,y,x);
                                } else {
                                    int i = 6 - enemyNum / 5;
                                    int j = 4 - enemyNum % 5;
                                    int y = 6 - playerNum / 5;
                                    int x = 4 - playerNum % 5;
                                    Ludigeratk(i, j, x, y);
                                    hpChck(i,j,y,x);
                                }
                            }
                            if (inputTokens[3].equals("Fenlia")) {
                                if (myTurn == 0) {
                                    int i = enemyNum / 5;
                                    int j = enemyNum % 5;
                                    int y = playerNum / 5;
                                    int x = playerNum % 5;
                                    Fenliaatk(i, j, x, y);
                                    hpChck(i,j,y,x);
                                } else {
                                    int i = 6 - enemyNum / 5;
                                    int j = 4 - enemyNum % 5;
                                    int y = 6 - playerNum / 5;
                                    int x = 4 - playerNum % 5;
                                    Fenliaatk(i, j, x, y);
                                    hpChck(i,j,y,x);
                                }
                            }
                            if (inputTokens[3].equals("Syuranoruaos")) {
                                if (myTurn == 0) {
                                    int i = enemyNum / 5;
                                    int j = enemyNum % 5;
                                    int y = playerNum / 5;
                                    int x = playerNum % 5;
                                    Syuranoruaosatk(i, j, x, y);
                                    hpChck(i,j,y,x);
                                } else {
                                    int i = 6 - enemyNum / 5;
                                    int j = 4 - enemyNum % 5;
                                    int y = 6 - playerNum / 5;
                                    int x = 4 - playerNum % 5;
                                    Syuranoruaosatk(i, j, x, y);
                                    hpChck(i,j,y,x);
                                }
                            }
                            if (inputTokens[3].equals("Midne")) {
                                if (myTurn == 0) {
                                    int i = enemyNum / 5;
                                    int j = enemyNum % 5;
                                    int y = playerNum / 5;
                                    int x = playerNum % 5;
                                    Midneatk(i, j, x, y);
                                    hpChck(i,j,y,x);
                                } else {
                                    int i = 6 - enemyNum / 5;
                                    int j = 4 - enemyNum % 5;
                                    int y = 6 - playerNum / 5;
                                    int x = 4 - playerNum % 5;
                                    Midneatk(i, j, x, y);
                                    hpChck(i,j,y,x);
                                }
                            }
                            if (inputTokens[3].equals("Tiscater")) {
                                if (myTurn == 0) {
                                    int i = enemyNum / 5;
                                    int j = enemyNum % 5;
                                    int y = playerNum / 5;
                                    int x = playerNum % 5;
                                    Tiscateratk(i, j, x, y);
                                    hpChck(i,j,y,x);
                                } else {
                                    int i = 6 - enemyNum / 5;
                                    int j = 4 - enemyNum % 5;
                                    int y = 6 - playerNum / 5;
                                    int x = 4 - playerNum % 5;
                                    Tiscateratk(i, j, x, y);
                                    hpChck(i,j,y,x);
                                }
                            }
							/*if(color == myColor){
								//buttonArray[i][j].setIcon(myIcon);
							} else {
								//buttonArray[i][j].setIcon(yourIcon);
							}*/
                        }

                        myTurn = 1 - myTurn;

                    } else {
                        break;
                    }


                }
                socket.close();
            } catch (IOException e) {
                System.err.println("" + e);
            }
        }
    }

    public static void main(String[] args) {
        MyClient net = new MyClient();
        net.setVisible(true);
    }

    public void resetSelect(int i, int j) {
        buttonArray[i][j].setBackground(new Color(0, 0, 0));
    }

    public void printHelp(String iconString){
         System.out.println(System.getProperty("file.encoding"));
         ArrayList<String> text = new ArrayList<String>();
         
         try {
             FileReader fr = new FileReader("C:/netprog/Ludiger/"+iconString+".txt");
             BufferedReader br = new BufferedReader(fr);
             String line;
             while ((line = br.readLine()) != null) {
                text.add(line);
             }

             br.close();
             fr.close();
            } catch (IOException ex) {
             ex.printStackTrace();
         }
         String helpTextText="";
         String helptext="";
         for(int i=0;i<text.size();i++){
             helptext=text.get(i);
             if(i!=0){
                helpTextText+="\n"+helptext;
             }else{
                 helpTextText=helptext;
             }
             
         }
         menuText.setText(helpTextText);
    }


    public void mouseClicked(MouseEvent e) {
        JButton theButton = (JButton) e.getComponent();
        String theArrayIndex = theButton.getActionCommand();
        int theBnum = Integer.parseInt(theArrayIndex);

        if((theButton.getIcon()==start)&&(isStart==false)){
            System.out.println("動いてんよ");
            gameStarButton.setVisible(false);
            nameField.setVisible(false);
            back.setVisible(false);
            ipField.setVisible(false);
            selMyIcon=eSelect.getSelectedIndex();
            eSelect.setVisible(false);
            InGame();
            isStart=true;

        }else if(isStart){
            int i = theBnum / 5;
            int j = theBnum % 5;
            int y = selectNum / 5;
            int x = selectNum % 5;
            String[] selectIconS = iconmap.get(buttonArray[i][j]).split("_");

            if (is_Select && myTurn == 0 && selectNum >= 0 && !(selectIconS[0].equals("player"))) {
                String[] selectedIconS = iconmap.get(buttonArray[y][x]).split("_");
                System.out.println("OK");
                if (selectedIconS[1].equals("Sword")) {
                    if (iconmap.get(buttonArray[i][j]).equals("field_0_0")) {
                        is_Move = SwordCanMoveCheck(i, j, x, y);
                        if (is_Move) {
                            String msg = "PLACE" + " " + theArrayIndex + " " + selectNum + " " + "Sword" + " " + myColor;
                            selectNum = -1;
                            is_Move = false;
    
                            out.println(msg);
                            out.flush();
                            repaint();
                        }
                    } else if (selectIconS[0].equals("enemy")) {
                        System.out.println(selectNum);
                        is_atk = SwordCanatkCheck(i, j, x, y);
                        if (is_atk) {
                            String msg = "atk" + " " + theArrayIndex + " " + selectNum + " " + "Sword" + " " + myColor;
                            selectNum = -1;
                            is_atk = false;
    
                            out.println(msg);
                            out.flush();
                            repaint();
                        }
                    }
                } else if (selectedIconS[1].equals("Shield")) {
                    if (iconmap.get(buttonArray[i][j]).equals("field_0_0")) {
                        is_Move = ShieldCanMoveCheck(i, j, x, y);
                        if (is_Move) {
                            String msg = "PLACE" + " " + theArrayIndex + " " + selectNum + " " + "Shield" + " " + myColor;
                            selectNum = -1;
                            is_Move = false;
    
                            out.println(msg);
                            out.flush();
                            repaint();
                        }
                    } else if (selectIconS[0].equals("enemy")) {
                        System.out.println(selectNum);
                        is_atk = ShieldCanatkCheck(i, j, x, y);
                        if (is_atk) {
                            String msg = "atk" + " " + theArrayIndex + " " + selectNum + " " + "Shield" + " " + myColor;
                            selectNum = -1;
                            is_atk = false;
    
                            out.println(msg);
                            out.flush();
                            repaint();
                        }
                    }
                } else if (selectedIconS[1].equals("Wizard")) {
                    if (iconmap.get(buttonArray[i][j]).equals("field_0_0")) {
                        is_Move = WizardCanMoveCheck(i, j, x, y);
                        if (is_Move) {
                            String msg = "PLACE" + " " + theArrayIndex + " " + selectNum + " " + "Wizard" + " " + myColor;
                            selectNum = -1;
                            is_Move = false;
    
                            out.println(msg);
                            out.flush();
                            repaint();
                        }
                    } else if (selectIconS[0].equals("enemy")) {
                        System.out.println(selectNum);
                        is_atk = WizardCanatkCheck(i, j, x, y);
                        if (is_atk) {
                            String msg = "atk" + " " + theArrayIndex + " " + selectNum + " " + "Wizard" + " " + myColor;
                            selectNum = -1;
                            is_atk = false;
    
                            out.println(msg);
                            out.flush();
                            repaint();
                        }
                    }
                } else if (selectedIconS[1].equals("Ludiger")) {
                    if (iconmap.get(buttonArray[i][j]).equals("field_0_0")) {
                        is_Move = LudigerCanMoveCheck(i, j, x, y);
                        if (is_Move) {
                            String msg = "PLACE" + " " + theArrayIndex + " " + selectNum + " " + "Ludiger" + " " + myColor;
                            selectNum = -1;
                            is_Move = false;
    
                            out.println(msg);
                            out.flush();
                            repaint();
                        }
                    } else if (selectIconS[0].equals("enemy")) {
                        System.out.println(selectNum);
                        is_atk = LudigerCanatkCheck(i, j, x, y);
                        if (is_atk) {
                            String msg = "atk" + " " + theArrayIndex + " " + selectNum + " " + "Ludiger" + " " + myColor;
                            selectNum = -1;
                            is_atk = false;
    
                            out.println(msg);
                            out.flush();
                            repaint();
                        }
                    }
                } else if (selectedIconS[1].equals("Fenlia")) {
                    if (iconmap.get(buttonArray[i][j]).equals("field_0_0")) {
                        is_Move = FenliaCanMoveCheck(i, j, x, y);
                        if (is_Move) {
                            String msg = "PLACE" + " " + theArrayIndex + " " + selectNum + " " + "Fenlia" + " " + myColor;
                            selectNum = -1;
                            is_Move = false;
    
                            out.println(msg);
                            out.flush();
                            repaint();
                        }
                    } else if (selectIconS[0].equals("enemy")) {
                        System.out.println(selectNum);
                        is_atk = FenliaCanatkCheck(i, j, x, y);
                        if (is_atk) {
                            String msg = "atk" + " " + theArrayIndex + " " + selectNum + " " + "Fenlia" + " " + myColor;
                            selectNum = -1;
                            is_atk = false;
    
                            out.println(msg);
                            out.flush();
                            repaint();
                        }
                    }
                } else if (selectedIconS[1].equals("Syuranoruaos")) {
                    if (iconmap.get(buttonArray[i][j]).equals("field_0_0")) {
                        is_Move = SyuranoruaosCanMoveCheck(i, j, x, y);
                        if (is_Move) {
                            String msg = "PLACE" + " " + theArrayIndex + " " + selectNum + " " + "Syuranoruaos" + " " + myColor;
                            selectNum = -1;
                            is_Move = false;
    
                            out.println(msg);
                            out.flush();
                            repaint();
                        }
                    } else if (selectIconS[0].equals("enemy")) {
                        System.out.println(selectNum);
                        is_atk = SyuranoruaosCanatkCheck(i, j, x, y);
                        if (is_atk) {
                            String msg = "atk" + " " + theArrayIndex + " " + selectNum + " " + "Syuranoruaos" + " " + myColor;
                            selectNum = -1;
                            is_atk = false;
    
                            out.println(msg);
                            out.flush();
                            repaint();
                        }
                    }
                } else if (selectedIconS[1].equals("Midne")) {
                    if (iconmap.get(buttonArray[i][j]).equals("field_0_0")) {
                        is_Move = MidneCanMoveCheck(i, j, x, y);
                        if (is_Move) {
                            String msg = "PLACE" + " " + theArrayIndex + " " + selectNum + " " + "Midne" + " " + myColor;
                            selectNum = -1;
                            is_Move = false;
    
                            out.println(msg);
                            out.flush();
                            repaint();
                        }
                    } else if (selectIconS[0].equals("enemy")) {
                        System.out.println(selectNum);
                        is_atk = MidneCanatkCheck(i, j, x, y);
                        if (is_atk) {
                            String msg = "atk" + " " + theArrayIndex + " " + selectNum + " " + "Midne" + " " + myColor;
                            selectNum = -1;
                            is_atk = false;
    
                            out.println(msg);
                            out.flush();
                            repaint();
                        }
                    }
                } else if (selectedIconS[1].equals("Tiscater")) {
                    if (iconmap.get(buttonArray[i][j]).equals("field_0_0")) {
                        is_Move = TiscaterCanMoveCheck(i, j, x, y);
                        if (is_Move) {
                            String msg = "PLACE" + " " + theArrayIndex + " " + selectNum + " " + "Tiscater" + " " + myColor;
                            selectNum = -1;
                            is_Move = false;
    
                            out.println(msg);
                            out.flush();
                            repaint();
                        }
                    } else if (selectIconS[0].equals("enemy")) {
                        System.out.println(selectNum);
                        is_atk = TiscaterCanatkCheck(i, j, x, y);
                        if (is_atk) {
                            String msg = "atk" + " " + theArrayIndex + " " + selectNum + " " + "Tiscater" + " " + myColor;
                            selectNum = -1;
                            is_atk = false;
    
                            out.println(msg);
                            out.flush();
                            repaint();
                        }
                    }
                }
            } else if (myTurn == 0) {
                System.out.println(iconmap.get(buttonArray[i][j]));
                if (selectIconS[0].equals("enemy")) {
                    helpMenu(selectIconS[1], i, j);
                    printHelp(selectIconS[1]);
                } else if (selectIconS[0].equals("player")) {
                    if ((selectNum == theBnum) && selectNum > 0) {
                        selectNum = -1;
                        resetSelect(y, x);
                    } else {
                        if (selectNum >= 0) {
                            resetSelect(y, x);
                        }
                        is_Select = true;
                        selectNum = theBnum;
                        System.out.println("OKK");
                        helpMenu(selectIconS[1], i, j);
                        printHelp(selectIconS[1]);
                        buttonArray[i][j].setBackground(new Color(255, 255, 0));
                    }
                }
            } else {
                if ((selectIconS[0].equals("player")) || (selectIconS[0].equals("enemy"))) {
                    helpMenu(selectIconS[1], i, j);
                    printHelp(selectIconS[1]);
                }
            }
        }
        System.out.println("動いてんよ"); 

    }

    public void helpMenu(String iconName, int i, int j) {
        if (iconName.equals("Shield")) {
            helpButton[0].setIcon(Shield_move);
            helpButton[1].setIcon(Shield_atk);
            helpButton[2].setText("Shield");
            helpButton[3].setText("HP:" + hpmap.get(iconmap.get(buttonArray[i][j])));
        } else if (iconName.equals("Sword")) {
            helpButton[0].setIcon(Sword_move);
            helpButton[1].setIcon(Sword_atk);
            helpButton[2].setText("Sword");
            helpButton[3].setText("HP:" + hpmap.get(iconmap.get(buttonArray[i][j])));
        } else if (iconName.equals("Wizard")) {
            helpButton[0].setIcon(Wizard_move);
            helpButton[1].setIcon(Wizard_atk);
            helpButton[2].setText("Wizard");
            helpButton[3].setText("HP:" + hpmap.get(iconmap.get(buttonArray[i][j])));
        } else if (iconName.equals("Ludiger")) {
            helpButton[0].setIcon(Ludiger_move);
            helpButton[1].setIcon(Ludiger_atk);
            helpButton[2].setText("Ludiger");
            helpButton[3].setText("HP:" + hpmap.get(iconmap.get(buttonArray[i][j])));
        } else if (iconName.equals("Fenlia")) {
            helpButton[0].setIcon(Fenlia_move);
            helpButton[1].setIcon(Fenlia_atk);
            helpButton[2].setText("Fenlia");
            helpButton[3].setText("HP:" + hpmap.get(iconmap.get(buttonArray[i][j])));
        } else if (iconName.equals("Syuranoruaos")) {
            helpButton[0].setIcon(Syuranoruaos_move);
            helpButton[1].setIcon(Syuranoruaos_atk);
            helpButton[2].setText("Syuranoruaos");
            helpButton[3].setText("HP:" + hpmap.get(iconmap.get(buttonArray[i][j])));
        } else if (iconName.equals("Midne")) {
            helpButton[0].setIcon(Midne_move);
            helpButton[1].setIcon(Midne_atk);
            helpButton[2].setText("Midne");
            helpButton[3].setText("HP:" + hpmap.get(iconmap.get(buttonArray[i][j])));
        } else if (iconName.equals("Tiscater")) {
            helpButton[0].setIcon(Tiscater_move);
            helpButton[1].setIcon(Tiscater_atk);
            helpButton[2].setText("Tiscater");
            helpButton[3].setText("HP:" + hpmap.get(iconmap.get(buttonArray[i][j])));
        } else {
            helpButton[0].setIcon(helpBoard);
            helpButton[1].setIcon(helpBoard);
            helpButton[2].setText("Board");
        }
    }


    public void hpChck(int i, int j,int y,int x) {
        String[] damagedIcon = iconmap.get(buttonArray[i][j]).split("_");
        if (hpmap.get(iconmap.get(buttonArray[i][j])) <= 0) {
            if (damagedIcon[1].equals("Ludiger")) {
                //GAME OVER
                System.out.println("Finish!!!!!");
            } else if (damagedIcon[1].equals("Fenlia")) {
                isEnd = true; 
                for (int n = 0; n < 7; n++) {
                    for (int m = 0; m < 5; x++) {
                        String sacrifice = iconmap.get(buttonArray[n][m]);
                        if (myTurn == 0) {
                            if (sacrifice.equals("enemy_Syuranoruaos_9") || sacrifice.equals("enemy_Midne_9") || sacrifice.equals("enemy_Tiscater_9")) {
                                sacrificeAction(sacrifice, i, j, m, n);
                            }
                        } else {
                            if (sacrifice.equals("player_Syuranoruaos_9") || sacrifice.equals("player_Midne_9") || sacrifice.equals("player_Tiscater_9")) {
                                sacrificeAction(sacrifice, i, j, m, n);
                            }
                        }

                    }
                }
                //GAME OVER
                if (isEnd) {
                    System.out.println("Finish!!!!!");
                }
            }
            if((damagedIcon[1].equals("Sword"))&&(iconmap.get(buttonArray[x][y]).equals("Wizard"))&&(hpmap.get(iconmap.get(buttonArray[i][j]))==0)){


            }
            else if ((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0)) {
                buttonArray[i][j].setIcon(boardIcon1);
            } else {
                buttonArray[i][j].setIcon(boardIcon2);
            }
            iconmap.put(buttonArray[i][j], "field_0_0");
        }
    }

    public void sacrificeAction(String sacrifice, int i, int j, int x, int y) {
        if ((myColor == 0 && myTurn == 0) || (myColor == 1 && myTurn == 1)) {
            buttonArray[y][x].setIcon(Fenlia_B);
        } else {
            buttonArray[y][x].setIcon(Fenlia_R);
        }
        iconmap.put(buttonArray[y][x], iconmap.get(buttonArray[i][j]));
        hpmap.put(iconmap.get(buttonArray[i][j]), hpmap.get(sacrifice));
        atkmap.put(iconmap.get(buttonArray[i][j]), atkmap.get(sacrifice));
        isEnd = false;
    }

    public void paint (String name){
        //a
    }


    //Sword

    public void SwordMove(int y, int x, int Sword_x, int Sword_y) {
        System.out.println("OKKKK");
        String val = iconmap.get(buttonArray[Sword_y][Sword_x]);
        iconmap.remove(buttonArray[y][x]);
        iconmap.put(buttonArray[y][x], val);
        iconmap.put(buttonArray[Sword_y][Sword_x], "field_0_0");
        if ((myColor == 0 && myTurn == 0) || (myColor == 1 && myTurn == 1)) {//myColor==myTurn
            buttonArray[y][x].setIcon(Sword_R);
        } else {
            buttonArray[y][x].setIcon(Sword_B);
        }
        if ((Sword_x % 2 == 0 && Sword_y % 2 == 0) || (Sword_x % 2 != 0 && Sword_y % 2 != 0)) {
            buttonArray[Sword_y][Sword_x].setIcon(boardIcon1);
        } else {
            buttonArray[Sword_y][Sword_x].setIcon(boardIcon2);
        }
    }

    public boolean SwordCanMoveCheck(int y, int x, int Sword_x, int Sword_y) {
        boolean flag = false;
        for (int i = -1; i < 1; i++) {
            for (int j = -1; j < 2; j++) {
                if ((Sword_x + j == x) && (Sword_y + i == y)) {
                    flag = true;
                    return flag;
                }
            }
        }
        if (Sword_x == x && Sword_y + 1 == y) {
            flag = true;
            return flag;
        }
        return flag;
    }

    public void Swordatk(int y, int x, int Sword_x, int Sword_y) {
        System.out.println("OKKK");
        int atk = atkmap.get(iconmap.get(buttonArray[Sword_y][Sword_x]));
        //String enemyType=iconmap.get(buttonArray[y][x]);
        int enemyHP = hpmap.get(iconmap.get(buttonArray[y][x]));

        String[] enemy = iconmap.get(buttonArray[y][x]).split("_");

        if (enemy[1].equals("Wizard")) {
            hpmap.put(iconmap.get(buttonArray[y][x]), enemyHP - 2);
        } else {
            hpmap.put(iconmap.get(buttonArray[y][x]), enemyHP - atk);
        }
    }

    public boolean SwordCanatkCheck(int y, int x, int Sword_x, int Sword_y) {
        boolean flag = false;
        for (int i = -1; i < 1; i++) {
            for (int j = -1; j < 2; j++) {
                if ((Sword_x + j == x) && (Sword_y + i == y)) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }


    //Shield

    public void ShieldMove(int y, int x, int Shield_x, int Shield_y) {
        System.out.println("OKKKK");
        String val = iconmap.get(buttonArray[Shield_y][Shield_x]);
        iconmap.remove(buttonArray[y][x]);
        iconmap.put(buttonArray[y][x], val);
        iconmap.put(buttonArray[Shield_y][Shield_x], "field_0_0");
        if ((myColor == 0 && myTurn == 0) || (myColor == 1 && myTurn == 1)) {//myColor==myTurn
            buttonArray[y][x].setIcon(Shield_R);
        } else {
            buttonArray[y][x].setIcon(Shield_B);
        }
        if ((Shield_x % 2 == 0 && Shield_y % 2 == 0) || (Shield_x % 2 != 0 && Shield_y % 2 != 0)) {
            buttonArray[Shield_y][Shield_x].setIcon(boardIcon1);
        } else {
            buttonArray[Shield_y][Shield_x].setIcon(boardIcon2);
        }
    }

    public boolean ShieldCanMoveCheck(int y, int x, int Shield_x, int Shield_y) {
        boolean flag = false;
        if (Shield_x == x && Shield_y - 1 == y) {
            flag = true;
            return flag;
        }
        for (int i = 0; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if ((Shield_x + j == x) && (Shield_y + i == y)) {
                    flag = true;
                    return flag;
                }
            }
        }
        for (int i = -2; i < 3; i += 2) {
            if (Shield_y + 2 == y && Shield_x + i == x) {
                flag = true;
                return flag;
            }
        }
        return flag;
    }

    public void Shieldatk(int y, int x, int Shield_x, int Shield_y) {
        System.out.println("OKKK");
        int atk = atkmap.get(iconmap.get(buttonArray[Shield_y][Shield_x]));
        //String enemyType=iconmap.get(buttonArray[y][x]);
        int enemyHP = hpmap.get(iconmap.get(buttonArray[y][x]));

        String[] enemy = iconmap.get(buttonArray[y][x]).split("_");

        hpmap.put(iconmap.get(buttonArray[y][x]), enemyHP - atk);
    }

    public boolean ShieldCanatkCheck(int y, int x, int Shield_x, int Shield_y) {
        boolean flag = false;
        for (int i = -1; i < 1; i++) {
            for (int j = -1; j < 2; j++) {
                if ((Shield_x + j == x) && (Shield_y + i == y)) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }


    //Wizard

    public void WizardMove(int y, int x, int Wizard_x, int Wizard_y) {
        System.out.println("OKKKK");
        String val = iconmap.get(buttonArray[Wizard_y][Wizard_x]);
        iconmap.remove(buttonArray[y][x]);
        iconmap.put(buttonArray[y][x], val);
        iconmap.put(buttonArray[Wizard_y][Wizard_x], "field_0_0");
        if ((myColor == 0 && myTurn == 0) || (myColor == 1 && myTurn == 1)) {//myColor==myTurn
            buttonArray[y][x].setIcon(Wizard_R);
        } else {
            buttonArray[y][x].setIcon(Wizard_B);
        }
        if ((Wizard_x % 2 == 0 && Wizard_y % 2 == 0) || (Wizard_x % 2 != 0 && Wizard_y % 2 != 0)) {
            buttonArray[Wizard_y][Wizard_x].setIcon(boardIcon1);
        } else {
            buttonArray[Wizard_y][Wizard_x].setIcon(boardIcon2);
        }
    }

    public boolean WizardCanMoveCheck(int y, int x, int Wizard_x, int Wizard_y) {
        boolean flag = false;
        if ((Wizard_x - 1 == x || Wizard_x + 1 == x) && Wizard_y == y) {
            flag = true;
            return flag;
        }
        for (int i = -2, j = 2; i < 3; i++, j--) {
            if ((Wizard_x + i == x && Wizard_y + i == y) || (Wizard_x + j == x && Wizard_y + i == y)) {
                flag = true;
                return flag;
            }
        }
        return flag;
    }

    public void Wizardatk(int y, int x, int Wizard_x, int Wizard_y) {
        System.out.println("OKKK");
        int atk = atkmap.get(iconmap.get(buttonArray[Wizard_y][Wizard_x]));
        //String enemyType=iconmap.get(buttonArray[y][x]);
        int enemyHP = hpmap.get(iconmap.get(buttonArray[y][x]));

        String[] enemy = iconmap.get(buttonArray[y][x]).split("_");

        if (enemy[1].equals("Sword")) {
            hpmap.put(iconmap.get(buttonArray[y][x]), enemyHP - 2);
        } else {
            hpmap.put(iconmap.get(buttonArray[y][x]), enemyHP - atk);
        }
    }

    public boolean WizardCanatkCheck(int y, int x, int Wizard_x, int Wizard_y) {
        boolean flag = false;
        if ((Wizard_x - 1 == x || Wizard_x + 1 == x) && Wizard_y == y) {
            flag = true;
            return flag;
        }
        for (int i = -2, j = 2; i < 3; i++, j--) {
            if ((Wizard_x + i == x && Wizard_y + i == y) || (Wizard_x + j == x && Wizard_y + i == y)) {
                flag = true;
                return flag;
            } else if ((Wizard_x == x && Wizard_y + i == y) || (Wizard_x + i == x && Wizard_y == y)) {
                flag = true;
                return flag;
            }
        }
        return flag;
    }

    //Ludiger

    public void LudigerMove(int y, int x, int Ludiger_x, int Ludiger_y) {
        System.out.println("OKKKK");
        String val = iconmap.get(buttonArray[Ludiger_y][Ludiger_x]);
        iconmap.remove(buttonArray[y][x]);
        iconmap.put(buttonArray[y][x], val);
        iconmap.put(buttonArray[Ludiger_y][Ludiger_x], "field_0_0");
        if ((myColor == 0 && myTurn == 0) || (myColor == 1 && myTurn == 1)) {//myColor==myTurn
            buttonArray[y][x].setIcon(Ludiger_R);
        } else {
            buttonArray[y][x].setIcon(Ludiger_B);
        }
        if ((Ludiger_x % 2 == 0 && Ludiger_y % 2 == 0) || (Ludiger_x % 2 != 0 && Ludiger_y % 2 != 0)) {
            buttonArray[Ludiger_y][Ludiger_x].setIcon(boardIcon1);
        } else {
            buttonArray[Ludiger_y][Ludiger_x].setIcon(boardIcon2);
        }
    }

    public boolean LudigerCanMoveCheck(int y, int x, int Ludiger_x, int Ludiger_y) {
        boolean flag = false;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (Ludiger_x + j == x && Ludiger_y + i == y) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }

    public void Ludigeratk(int y, int x, int Ludiger_x, int Ludiger_y) {
        System.out.println("OKKK");
        int atk = atkmap.get(iconmap.get(buttonArray[Ludiger_y][Ludiger_x]));
        //String enemyType=iconmap.get(buttonArray[y][x]);
        int enemyHP = hpmap.get(iconmap.get(buttonArray[y][x]));

        String[] enemy = iconmap.get(buttonArray[y][x]).split("_");

        if (enemy[1].equals("Shield")) {
            hpmap.put(iconmap.get(buttonArray[y][x]), enemyHP - 1);
        } else {
            hpmap.put(iconmap.get(buttonArray[y][x]), enemyHP - atk);
        }
    }

    public boolean LudigerCanatkCheck(int y, int x, int Ludiger_x, int Ludiger_y) {
        boolean flag = false;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (Ludiger_x + j == x && Ludiger_y + i == y) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }

    //Fenlia

    public void FenliaMove(int y, int x, int Fenlia_x, int Fenlia_y) {
        System.out.println("OKKKK");
        String val = iconmap.get(buttonArray[Fenlia_y][Fenlia_x]);
        iconmap.remove(buttonArray[y][x]);
        iconmap.put(buttonArray[y][x], val);
        iconmap.put(buttonArray[Fenlia_y][Fenlia_x], "field_0_0");
        if ((myColor == 0 && myTurn == 0) || (myColor == 1 && myTurn == 1)) {//myColor==myTurn
            buttonArray[y][x].setIcon(Fenlia_R);
        } else {
            buttonArray[y][x].setIcon(Fenlia_B);
        }
        if ((Fenlia_x % 2 == 0 && Fenlia_y % 2 == 0) || (Fenlia_x % 2 != 0 && Fenlia_y % 2 != 0)) {
            buttonArray[Fenlia_y][Fenlia_x].setIcon(boardIcon1);
        } else {
            buttonArray[Fenlia_y][Fenlia_x].setIcon(boardIcon2);
        }
    }

    public boolean FenliaCanMoveCheck(int y, int x, int Fenlia_x, int Fenlia_y) {
        boolean flag = false;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (Fenlia_x + j == x && Fenlia_y + i == y) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }

    public void Fenliaatk(int y, int x, int Fenlia_x, int Fenlia_y) {
        System.out.println("OKKK");
        int atk = atkmap.get(iconmap.get(buttonArray[Fenlia_y][Fenlia_x]));
        //String enemyType=iconmap.get(buttonArray[y][x]);
        int enemyHP = hpmap.get(iconmap.get(buttonArray[y][x]));

        String[] enemy = iconmap.get(buttonArray[y][x]).split("_");
        if (enemy[1].equals("Ludiger")) {
            hpmap.put(iconmap.get(buttonArray[y][x]), 0);
        } else {
            hpmap.put(iconmap.get(buttonArray[y][x]), enemyHP - atk);

        }
    }

    public boolean FenliaCanatkCheck(int y, int x, int Fenlia_x, int Fenlia_y) {
        boolean flag = false;
        String[] atkIcon = iconmap.get(buttonArray[y][x]).split("_");
        if (atkIcon[1].equals("Fenlia")) {
            return flag;
        }
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (Fenlia_x + j == x && Fenlia_y + i == y) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }

    //Syuranoruaos

    public void SyuranoruaosMove(int y, int x, int Syuranoruaos_x, int Syuranoruaos_y) {
        System.out.println("OKKKK");
        String val = iconmap.get(buttonArray[Syuranoruaos_y][Syuranoruaos_x]);
        iconmap.remove(buttonArray[y][x]);
        iconmap.put(buttonArray[y][x], val);
        iconmap.put(buttonArray[Syuranoruaos_y][Syuranoruaos_x], "field_0_0");
        if ((myColor == 0 && myTurn == 0) || (myColor == 1 && myTurn == 1)) {//myColor==myTurn
            buttonArray[y][x].setIcon(Syuranoruaos_R);
        } else {
            buttonArray[y][x].setIcon(Syuranoruaos_B);
        }
        if ((Syuranoruaos_x % 2 == 0 && Syuranoruaos_y % 2 == 0) || (Syuranoruaos_x % 2 != 0 && Syuranoruaos_y % 2 != 0)) {
            buttonArray[Syuranoruaos_y][Syuranoruaos_x].setIcon(boardIcon1);
        } else {
            buttonArray[Syuranoruaos_y][Syuranoruaos_x].setIcon(boardIcon2);
        }
    }

    public boolean SyuranoruaosCanMoveCheck(int y, int x, int Syuranoruaos_x, int Syuranoruaos_y) {
        boolean flag = false;
        if ((Syuranoruaos_x - 1 == x || Syuranoruaos_x + 1 == x) && Syuranoruaos_y == y) {
            flag = true;
            return flag;
        }
        for (int i = -2, j = 2; i < 3; i++, j--) {
            if ((Syuranoruaos_x + i == x && Syuranoruaos_y + i == y) || (Syuranoruaos_x + j == x && Syuranoruaos_y + i == y)) {
                flag = true;
                return flag;
            }
        }
        return flag;
    }

    public void Syuranoruaosatk(int y, int x, int Syuranoruaos_x, int Syuranoruaos_y) {
        System.out.println("OKKK");
        int atk = atkmap.get(iconmap.get(buttonArray[Syuranoruaos_y][Syuranoruaos_x]));
        //String enemyType=iconmap.get(buttonArray[y][x]);
        int enemyHP = hpmap.get(iconmap.get(buttonArray[y][x]));

        String[] enemy = iconmap.get(buttonArray[y][x]).split("_");

        hpmap.put(iconmap.get(buttonArray[y][x]), enemyHP - atk);
    }

    public boolean SyuranoruaosCanatkCheck(int y, int x, int Syuranoruaos_x, int Syuranoruaos_y) {
        boolean flag = false;
        if ((Syuranoruaos_x - 1 == x || Syuranoruaos_x + 1 == x) && Syuranoruaos_y == y) {
            flag = true;
            return flag;
        }
        for (int i = -2, j = 2; i < 3; i++, j--) {
            if ((Syuranoruaos_x + i == x && Syuranoruaos_y + i == y) || (Syuranoruaos_x + j == x && Syuranoruaos_y + i == y)) {
                flag = true;
                return flag;
            }
        }
        return flag;
    }

    //Midne

    public void MidneMove(int y, int x, int Midne_x, int Midne_y) {
        System.out.println("OKKKK");
        String val = iconmap.get(buttonArray[Midne_y][Midne_x]);
        iconmap.remove(buttonArray[y][x]);
        iconmap.put(buttonArray[y][x], val);
        iconmap.put(buttonArray[Midne_y][Midne_x], "field_0_0");
        if ((myColor == 0 && myTurn == 0) || (myColor == 1 && myTurn == 1)) {//myColor==myTurn
            buttonArray[y][x].setIcon(Midne_R);
        } else {
            buttonArray[y][x].setIcon(Midne_B);
        }
        if ((Midne_x % 2 == 0 && Midne_y % 2 == 0) || (Midne_x % 2 != 0 && Midne_y % 2 != 0)) {
            buttonArray[Midne_y][Midne_x].setIcon(boardIcon1);
        } else {
            buttonArray[Midne_y][Midne_x].setIcon(boardIcon2);
        }
    }

    public boolean MidneCanMoveCheck(int y, int x, int Midne_x, int Midne_y) {
        boolean flag = false;
        for (int i = -2, j = -2; i < 3; i++, j++) {
            if ((Midne_x + i == x && Midne_y == y) || (Midne_x == x && Midne_y + j == y)) {
                flag = true;
                return flag;
            }
        }
        return flag;
    }

    public void Midneatk(int y, int x, int Midne_x, int Midne_y) {
        System.out.println("OKKK");
        int atk = atkmap.get(iconmap.get(buttonArray[Midne_y][Midne_x]));
        //String Type=iconmap.get(buttonArray[y][x]);
        int enemyHP = hpmap.get(iconmap.get(buttonArray[y][x]));

        String[] enemy = iconmap.get(buttonArray[y][x]).split("_");

        hpmap.put(iconmap.get(buttonArray[y][x]), enemyHP - atk);
    }

    public boolean MidneCanatkCheck(int y, int x, int Midne_x, int Midne_y) {
        boolean flag = false;
        for (int i = -2, j = -2; i < 3; i++, j++) {
            if ((Midne_x + i == x && Midne_y == y) || (Midne_x == x && Midne_y + j == y)) {
                flag = true;
                return flag;
            }
        }
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (Midne_x + j == x && Midne_y + j == y) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }

    //Tiscater

    public void TiscaterMove(int y, int x, int Tiscater_x, int Tiscater_y) {
        System.out.println("OKKKK");
        String val = iconmap.get(buttonArray[Tiscater_y][Tiscater_x]);
        iconmap.remove(buttonArray[y][x]);
        iconmap.put(buttonArray[y][x], val);
        iconmap.put(buttonArray[Tiscater_y][Tiscater_x], "field_0_0");
        if ((myColor == 0 && myTurn == 0) || (myColor == 1 && myTurn == 1)) {//myColor==myTurn
            buttonArray[y][x].setIcon(Tiscater_R);
        } else {
            buttonArray[y][x].setIcon(Tiscater_B);
        }
        if ((Tiscater_x % 2 == 0 && Tiscater_y % 2 == 0) || (Tiscater_x % 2 != 0 && Tiscater_y % 2 != 0)) {
            buttonArray[Tiscater_y][Tiscater_x].setIcon(boardIcon1);
        } else {
            buttonArray[Tiscater_y][Tiscater_x].setIcon(boardIcon2);
        }
    }

    public boolean TiscaterCanMoveCheck(int y, int x, int Tiscater_x, int Tiscater_y) {
        boolean flag = false;
        for (int i = -2; i < 3; i++) {
            if (Tiscater_x == x && Tiscater_y + i == y) {
                flag = true;
                return flag;
            }
        }
        for (int i = -1; i < 1; i++) {
            for (int j = 1; j < 3; j *= 2) {
                if ((Tiscater_x + j == x || Tiscater_x - j == x) && (Tiscater_y + i == y)) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }

    public void Tiscateratk(int y, int x, int Tiscater_x, int Tiscater_y) {
        System.out.println("OKKK");
        int atk = atkmap.get(iconmap.get(buttonArray[Tiscater_y][Tiscater_x]));
        //String enemyType=iconmap.get(buttonArray[y][x]);
        int enemyHP = hpmap.get(iconmap.get(buttonArray[y][x]));

        String[] enemy = iconmap.get(buttonArray[y][x]).split("_");

        hpmap.put(iconmap.get(buttonArray[y][x]), enemyHP - atk);
    }

    public boolean TiscaterCanatkCheck(int y, int x, int Tiscater_x, int Tiscater_y) {
        boolean flag = false;
        for (int i = -2, j = -2; i < 3; i++, j++) {
            if ((Tiscater_x + i == x && Tiscater_y == y) || (Tiscater_x == x && Tiscater_y + j == y)) {
                flag = true;
                return flag;
            }
        }
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (Tiscater_x + j == x && Tiscater_y + j == y) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }


    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
        //System.out.println("}EXEo");
    }

    public void mousePressed(MouseEvent e) {
        //System.out.println("}EX");
    }

    public void mouseReleased(MouseEvent e) {
        //System.out.println("}EX");
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    @Override
	public void keyTyped(KeyEvent e) {
		//使用しないので空にしておきます。
	}
 
	@Override
	public void keyReleased(KeyEvent e) {
		switch ( e.getKeyCode() ) {
		case KeyEvent.VK_UP:
			//上キー
			System.out.println("上が離されました");
			break;
		case KeyEvent.VK_SPACE:
			//スペースキー
			System.out.println("スペースが離されました");
			break;
		case KeyEvent.VK_ENTER:
			//エンターキー
			System.out.println("Enterが離されました");
			break;
		}
	}

    public void keyPressed(KeyEvent e) {
		switch ( e.getKeyCode() ) {
		case KeyEvent.VK_UP:
			break;
		case KeyEvent.VK_SPACE:
			break;
        case KeyEvent.VK_ENTER:
			break;
		}
    }
    
    public  void itemStateChanged(ItemEvent e){
        switch(eSelect.getSelectedItem()){
            case "Syuranoruaos":
            System.out.println("Syuranoruaos");
            break;
            case "Midne":
            System.out.println("Midne");
            break;
            case "Tiscater":
            System.out.println("Tiscater");
            break;
        }
        
    }
}