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
import javax.swing.JFrame;

//import Ludiger.Icon.Imag selectIconSet;

public class MyClient1 extends JFrame implements MouseListener, MouseMotionListener {
    private JButton buttonArray[][];//{^pﾌ配
    private JButton helpButton[];
    private JTextArea menuText;
    private Container c;
    private ImageIcon boardIcon1, boardIcon2, ludige_B, ludige_R, sword_B, sword_R, wizard_B, wizard_R, shield_B, shield_R,
            fenlia_B, fenlia_R, midne_B, midne_R, syuranoruaos_B, syuranoruaos_R, tiscater_B, tiscater_R;
    private ImageIcon helpBoard, shield_atk, shield_move, sword_atk, sword_move, wizard_move, wizard_atk, ludige_move, ludige_atk, fenlia_move, fenlia_atk,
            midne_move, midne_atk, syuranoruaos_move, syuranoruaos_atk, tiscater_move, tiscater_atk;
    PrintWriter out;//oﾍ用ﾌC^[
    private int myColor, myTurn;
    private ImageIcon myIcon, yourIcon, sacrificeIcon;
    JButton bs = new JButton("Send");
    private int button_Size = 110;
    private HashMap<JButton, String> iconmap = new HashMap<JButton, String>();//薰ｪﾌゑﾌゑGﾌゑﾌゑﾌ具
    private HashMap<String, Integer> hpmap = new HashMap<String, Integer>();
    private HashMap<String, Integer> atkmap = new HashMap<String, Integer>();
    private boolean is_Start_Set = true;
    private boolean is_Select = false;
    private boolean is_Move = false;
    private boolean is_atk = false;
    private int selectNum = -1;
    private int selMyIcon = 0, selEnemyIcon = 0;
    private boolean isEnd = false;

    public void selectIconSet() {
        boardIcon1 = new ImageIcon("BoardImage1.png");
        boardIcon2 = new ImageIcon("BoardImage2.png");
        ludige_B = new ImageIcon("ludige_B.png");
        ludige_R = new ImageIcon("ludige_R.png");
        sword_B = new ImageIcon("Sword_B.png");
        sword_R = new ImageIcon("Sword_R.png");
        wizard_B = new ImageIcon("Wizard_B.png");
        wizard_R = new ImageIcon("Wizard_R.png");
        shield_B = new ImageIcon("Shield_B.png");
        shield_R = new ImageIcon("Shield_R.png");
        fenlia_B = new ImageIcon("Fenlia_B.png");
        fenlia_R = new ImageIcon("Fenlia_R.png");
        midne_B = new ImageIcon("Midne_B.png");
        midne_R = new ImageIcon("Midne_R.png");
        syuranoruaos_B = new ImageIcon("Syuranoruaos_B.png");
        syuranoruaos_R = new ImageIcon("Syuranoruaos_R.png");
        tiscater_B = new ImageIcon("Tiscater_B.png");
        tiscater_R = new ImageIcon("Tiscater_R.png");

        //helpMenup
        helpBoard = new ImageIcon("fieldSample.png");
        shield_move = new ImageIcon("shield_move.png");
        shield_atk = new ImageIcon("shield_atk.png");
        sword_move = new ImageIcon("sword_move.png");
        sword_atk = new ImageIcon("sword_atk.png");
        wizard_move = new ImageIcon("wizard_move.png");
        wizard_atk = new ImageIcon("wizard_atk.png");
        ludige_move = new ImageIcon("ludige_move.png");
        ludige_atk = new ImageIcon("ludige_atk.png");
        fenlia_move = new ImageIcon("fenlia_move.png");
        fenlia_atk = new ImageIcon("fenlia_atk.png");
        syuranoruaos_move = new ImageIcon("syuranoruaos_move.png");
        syuranoruaos_atk = new ImageIcon("syuranoruaos_atk.png");
        midne_move = new ImageIcon("midne_move.png");
        midne_atk = new ImageIcon("midne_atk.png");
        tiscater_move = new ImageIcon("tiscater_move.png");
        tiscater_atk = new ImageIcon("tiscater_atk.png");
    }

    public void GameStart(int myColor, int selMyIcon) {
        if (myColor == 0 && myTurn == 0) {
            buttonArray[0][0].setIcon(wizard_B);
            buttonArray[0][4].setIcon(wizard_B);
            buttonArray[0][2].setIcon(ludige_B);
            buttonArray[0][1].setIcon(fenlia_B);
            buttonArray[1][1].setIcon(sword_B);
            buttonArray[1][3].setIcon(sword_B);
            buttonArray[2][0].setIcon(shield_B);
            buttonArray[2][2].setIcon(shield_B);
            buttonArray[2][4].setIcon(shield_B);
            switch (selEnemyIcon) {
                case 0:
                    buttonArray[0][3].setIcon(syuranoruaos_B);
                    break;
                case 1:
                    buttonArray[0][3].setIcon(midne_B);
                    break;
                case 2:
                    buttonArray[0][3].setIcon(tiscater_B);
                    break;
            }

            buttonArray[4][0].setIcon(shield_R);
            buttonArray[4][2].setIcon(shield_R);
            buttonArray[4][4].setIcon(shield_R);
            buttonArray[5][1].setIcon(sword_R);
            buttonArray[5][3].setIcon(sword_R);
            buttonArray[6][0].setIcon(wizard_R);
            buttonArray[6][4].setIcon(wizard_R);
            buttonArray[6][3].setIcon(fenlia_R);
            buttonArray[6][2].setIcon(ludige_R);
            switch (selMyIcon) {
                case 0:
                    buttonArray[6][1].setIcon(syuranoruaos_R);
                    break;
                case 1:
                    buttonArray[6][1].setIcon(midne_R);
                    break;
                case 2:
                    buttonArray[6][1].setIcon(tiscater_R);
                    break;
            }
        } else {
            buttonArray[0][0].setIcon(wizard_R);
            buttonArray[0][4].setIcon(wizard_R);
            buttonArray[0][2].setIcon(ludige_R);
            buttonArray[0][1].setIcon(fenlia_R);
            buttonArray[1][1].setIcon(sword_R);
            buttonArray[1][3].setIcon(sword_R);
            buttonArray[2][0].setIcon(shield_R);
            buttonArray[2][2].setIcon(shield_R);
            buttonArray[2][4].setIcon(shield_R);

            switch (selEnemyIcon) {
                case 0:
                    buttonArray[0][3].setIcon(syuranoruaos_R);
                    break;
                case 1:
                    buttonArray[0][3].setIcon(midne_R);
                    break;
                case 2:
                    buttonArray[0][3].setIcon(tiscater_R);
                    break;
            }

            buttonArray[4][0].setIcon(shield_B);
            buttonArray[4][2].setIcon(shield_B);
            buttonArray[4][4].setIcon(shield_B);
            buttonArray[5][1].setIcon(sword_B);
            buttonArray[5][3].setIcon(sword_B);
            buttonArray[6][0].setIcon(wizard_B);
            buttonArray[6][4].setIcon(wizard_B);
            buttonArray[6][3].setIcon(fenlia_B);
            buttonArray[6][2].setIcon(ludige_B);

            switch (selMyIcon) {
                case 0:
                    buttonArray[6][1].setIcon(syuranoruaos_B);
                    break;
                case 1:
                    buttonArray[6][1].setIcon(midne_B);
                    break;
                case 2:
                    buttonArray[6][1].setIcon(tiscater_B);
                    break;
            }
        }

        iconmap.put(buttonArray[4][0], "player_shield_0");//shild
        iconmap.put(buttonArray[4][2], "player_shield_1");//shild
        iconmap.put(buttonArray[4][4], "player_shield_2");//shild
        iconmap.put(buttonArray[5][1], "player_sword_3");//sword
        iconmap.put(buttonArray[5][3], "player_sword_4");//sword
        iconmap.put(buttonArray[6][0], "player_wizard_5");//wizard
        iconmap.put(buttonArray[6][4], "player_wizard_6");//wizard
        iconmap.put(buttonArray[6][2], "player_ludige_7");//ludige
        iconmap.put(buttonArray[6][3], "player_fenlia_8");//fenlia

        switch (selMyIcon) {
            case 0:
                iconmap.put(buttonArray[6][1], "player_syuranoruaos_9");
                break;
            case 1:
                iconmap.put(buttonArray[6][1], "player_midne_9");
                break;
            case 2:
                iconmap.put(buttonArray[6][1], "player_tiscater_9");
                break;
        }


        iconmap.put(buttonArray[2][0], "enemy_shield_0");
        iconmap.put(buttonArray[2][2], "enemy_shield_1");
        iconmap.put(buttonArray[2][4], "enemy_shield_2");
        iconmap.put(buttonArray[1][1], "enemy_sword_3");
        iconmap.put(buttonArray[1][3], "enemy_sword_4");
        iconmap.put(buttonArray[0][0], "enemy_wizard_5");
        iconmap.put(buttonArray[0][4], "enemy_wizard_6");
        iconmap.put(buttonArray[0][2], "enemy_ludige_7");
        iconmap.put(buttonArray[0][1], "enemy_fenlia_8");

        switch (selEnemyIcon) {
            case 0:
                iconmap.put(buttonArray[0][3], "enemy_syuranoruaos_9");
                break;
            case 1:
                iconmap.put(buttonArray[0][3], "enemy_midne_9");
                break;
            case 2:
                iconmap.put(buttonArray[0][3], "enemy_tiscater_9");
                break;
        }


        atkmap.put("player_shield_0", 1);
        atkmap.put("player_shield_1", 1);
        atkmap.put("player_shield_2", 1);
        atkmap.put("player_sword_3", 1);//wizard対ゑは２_
        atkmap.put("player_sword_4", 1);
        atkmap.put("player_wizard_5", 1);//swordゑ２_
        atkmap.put("player_wizard_6", 1);
        atkmap.put("player_ludige_7", 2);
        atkmap.put("player_fenlia_8", 10);

        switch (selMyIcon) {
            case 0:
                atkmap.put("player_syuranoruaos_9", 1);
                break;
            case 1:
                atkmap.put("player_midne_9", 1);
                break;
            case 2:
                atkmap.put("player_tiscater_9", 1);
                break;
        }

        atkmap.put("enemy_shield_0", 1);
        atkmap.put("enemy_shield_1", 1);
        atkmap.put("enemy_shield_2", 1);
        atkmap.put("enemy_sword_3", 1);//wizard対ゑは２_
        atkmap.put("enemy_sword_4", 1);
        atkmap.put("enemy_wizard_5", 1);//swordゑ２_
        atkmap.put("enemy_wizard_6", 1);
        atkmap.put("enemy_ludige_7", 2);
        atkmap.put("enemy_fenlia_8", 10);

        switch (selEnemyIcon) {
            case 0:
                atkmap.put("enemy_syuranoruaos_9", 1);
                break;
            case 1:
                atkmap.put("enemy_midne_9", 1);
                break;
            case 2:
                atkmap.put("enemy_tiscater_9", 1);
                break;
        }


        hpmap.put("player_shield_0", 2);
        hpmap.put("player_shield_1", 2);
        hpmap.put("player_shield_2", 2);
        hpmap.put("player_sword_3", 2);
        hpmap.put("player_sword_4", 2);
        hpmap.put("player_wizard_5", 2);
        hpmap.put("player_wizard_6", 2);
        hpmap.put("player_ludige_7", 10000);
        hpmap.put("player_fenlia_8", 3);

        switch (selMyIcon) {
            case 0:
                hpmap.put("player_syuranoruaos_9", 3);
                break;
            case 1:
                hpmap.put("player_midne_9", 3);
                break;
            case 2:
                hpmap.put("player_tiscater_9", 3);
                break;
        }

        hpmap.put("enemy_shield_0", 2);
        hpmap.put("enemy_shield_1", 2);
        hpmap.put("enemy_shield_2", 2);
        hpmap.put("enemy_sword_3", 2);
        hpmap.put("enemy_sword_4", 2);
        hpmap.put("enemy_wizard_5", 2);
        hpmap.put("enemy_wizard_6", 2);
        hpmap.put("enemy_ludige_7", 10000);
        hpmap.put("enemy_fenlia_8", 3);

        switch (selEnemyIcon) {
            case 0:
                hpmap.put("enemy_syuranoruaos_9", 3);
                break;
            case 1:
                hpmap.put("enemy_midne_9", 3);
                break;
            case 2:
                hpmap.put("enemy_tiscater_9", 3);
                break;
        }
    }

    public MyClient1() {
        
        String myName = JOptionPane.showInputDialog(null, "名前を入力してください", "名前の入力", JOptionPane.QUESTION_MESSAGE);
        String myIPAdress = JOptionPane.showInputDialog(null, "IPアドレスを入力してください", "IPアドレスの入力", JOptionPane.QUESTION_MESSAGE);
        if (myName.equals("")) {
            myName = "No name";
        }
        if (myIPAdress.equals("")) {
            myIPAdress = "localhost";
        }

     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MyClient");
        setSize(1300, 900);
        c = getContentPane();
        getContentPane().setBackground(new Color(240, 255, 255));

        selectIconSet();

        c.setLayout(null);
        
        buttonArray = new JButton[7][5];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
                    buttonArray[i][j] = new JButton(boardIcon1);
                    c.add(buttonArray[i][j]);
                    buttonArray[i][j].setBounds(j * button_Size + 10, 10 + i * button_Size, button_Size, button_Size);
                    buttonArray[i][j].setBackground(new Color(0, 0, 0));
                } else {
                    buttonArray[i][j] = new JButton(boardIcon2);
                    c.add(buttonArray[i][j]);
                    buttonArray[i][j].setBounds(j * button_Size + 10, 10 + i * button_Size, button_Size, button_Size);
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
            helpButton[i].setBounds(570 + i * 260, 80, 250, 250);
        }
        helpButton[2] = new JButton("Board");
        c.add(helpButton[2]);
        helpButton[2].setBounds(570, 10, 200, 50);

        helpButton[3] = new JButton("HP:");
        c.add(helpButton[3]);
        helpButton[3].setBounds(570, 350, 100, 50);

        menuText = new JTextArea("aaaaaa");
        c.add(menuText);
        menuText.setBounds(570, 420, 400, 300);
        //menuText.setEditable(false);
        


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
                            if (inputTokens[3].equals("sword")) {
                                if (myTurn == 0) {
                                    int i = placeNum / 5;
                                    int j = placeNum % 5;
                                    int y = placedNum / 5;
                                    int x = placedNum % 5;
                                    swordMove(i, j, x, y);
                                } else {
                                    int i = 6 - placeNum / 5;
                                    int j = 4 - placeNum % 5;
                                    int y = 6 - placedNum / 5;
                                    int x = 4 - placedNum % 5;
                                    swordMove(i, j, x, y);
                                }
                            }
                            if (inputTokens[3].equals("shield")) {
                                if (myTurn == 0) {
                                    int i = placeNum / 5;
                                    int j = placeNum % 5;
                                    int y = placedNum / 5;
                                    int x = placedNum % 5;
                                    shieldMove(i, j, x, y);
                                } else {
                                    int i = 6 - placeNum / 5;
                                    int j = 4 - placeNum % 5;
                                    int y = 6 - placedNum / 5;
                                    int x = 4 - placedNum % 5;
                                    shieldMove(i, j, x, y);
                                }
                            }
                            if (inputTokens[3].equals("wizard")) {
                                if (myTurn == 0) {
                                    int i = placeNum / 5;
                                    int j = placeNum % 5;
                                    int y = placedNum / 5;
                                    int x = placedNum % 5;
                                    wizardMove(i, j, x, y);
                                } else {
                                    int i = 6 - placeNum / 5;
                                    int j = 4 - placeNum % 5;
                                    int y = 6 - placedNum / 5;
                                    int x = 4 - placedNum % 5;
                                    wizardMove(i, j, x, y);
                                }
                            }
                            if (inputTokens[3].equals("ludige")) {
                                if (myTurn == 0) {
                                    int i = placeNum / 5;
                                    int j = placeNum % 5;
                                    int y = placedNum / 5;
                                    int x = placedNum % 5;
                                    ludigeMove(i, j, x, y);
                                } else {
                                    int i = 6 - placeNum / 5;
                                    int j = 4 - placeNum % 5;
                                    int y = 6 - placedNum / 5;
                                    int x = 4 - placedNum % 5;
                                    ludigeMove(i, j, x, y);
                                }
                            }
                            if (inputTokens[3].equals("fenlia")) {
                                if (myTurn == 0) {
                                    int i = placeNum / 5;
                                    int j = placeNum % 5;
                                    int y = placedNum / 5;
                                    int x = placedNum % 5;
                                    fenliaMove(i, j, x, y);
                                } else {
                                    int i = 6 - placeNum / 5;
                                    int j = 4 - placeNum % 5;
                                    int y = 6 - placedNum / 5;
                                    int x = 4 - placedNum % 5;
                                    fenliaMove(i, j, x, y);
                                }
                            }
                            if (inputTokens[3].equals("syuranoruaos")) {
                                if (myTurn == 0) {
                                    int i = placeNum / 5;
                                    int j = placeNum % 5;
                                    int y = placedNum / 5;
                                    int x = placedNum % 5;
                                    syuranoruaosMove(i, j, x, y);
                                } else {
                                    int i = 6 - placeNum / 5;
                                    int j = 4 - placeNum % 5;
                                    int y = 6 - placedNum / 5;
                                    int x = 4 - placedNum % 5;
                                    syuranoruaosMove(i, j, x, y);
                                }
                            }
                            if (inputTokens[3].equals("midne")) {
                                if (myTurn == 0) {
                                    int i = placeNum / 5;
                                    int j = placeNum % 5;
                                    int y = placedNum / 5;
                                    int x = placedNum % 5;
                                    midneMove(i, j, x, y);
                                } else {
                                    int i = 6 - placeNum / 5;
                                    int j = 4 - placeNum % 5;
                                    int y = 6 - placedNum / 5;
                                    int x = 4 - placedNum % 5;
                                    midneMove(i, j, x, y);
                                }
                            }
                            if (inputTokens[3].equals("tiscater")) {
                                if (myTurn == 0) {
                                    int i = placeNum / 5;
                                    int j = placeNum % 5;
                                    int y = placedNum / 5;
                                    int x = placedNum % 5;
                                    tiscaterMove(i, j, x, y);
                                } else {
                                    int i = 6 - placeNum / 5;
                                    int j = 4 - placeNum % 5;
                                    int y = 6 - placedNum / 5;
                                    int x = 4 - placedNum % 5;
                                    tiscaterMove(i, j, x, y);
                                }
                            }
							/*if(color == myColor){//MNCAgﾅの擾
								//buttonArray[i][j].setIcon(myIcon);
							} else {//MNCAgﾅの擾
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
                            if (inputTokens[3].equals("sword")) {
                                if (myTurn == 0) {
                                    int i = enemyNum / 5;
                                    int j = enemyNum % 5;
                                    int y = playerNum / 5;
                                    int x = playerNum % 5;
                                    swordatk(i, j, x, y);
                                    hpCheck(i, j);
                                } else {
                                    int i = 6 - enemyNum / 5;
                                    int j = 4 - enemyNum % 5;
                                    int y = 6 - playerNum / 5;
                                    int x = 4 - playerNum % 5;
                                    swordatk(i, j, x, y);
                                    hpCheck(i, j);
                                }
                            }
                            if (inputTokens[3].equals("shield")) {
                                if (myTurn == 0) {
                                    int i = enemyNum / 5;
                                    int j = enemyNum % 5;
                                    int y = playerNum / 5;
                                    int x = playerNum % 5;
                                    shieldatk(i, j, x, y);
                                    hpCheck(i, j);
                                } else {
                                    int i = 6 - enemyNum / 5;
                                    int j = 4 - enemyNum % 5;
                                    int y = 6 - playerNum / 5;
                                    int x = 4 - playerNum % 5;
                                    shieldatk(i, j, x, y);
                                    hpCheck(i, j);
                                }
                            }
                            if (inputTokens[3].equals("wizard")) {
                                if (myTurn == 0) {
                                    int i = enemyNum / 5;
                                    int j = enemyNum % 5;
                                    int y = playerNum / 5;
                                    int x = playerNum % 5;
                                    wizardatk(i, j, x, y);
                                    hpCheck(i, j);
                                } else {
                                    int i = 6 - enemyNum / 5;
                                    int j = 4 - enemyNum % 5;
                                    int y = 6 - playerNum / 5;
                                    int x = 4 - playerNum % 5;
                                    wizardatk(i, j, x, y);
                                    hpCheck(i, j);
                                }
                            }
                            if (inputTokens[3].equals("ludige")) {
                                if (myTurn == 0) {
                                    int i = enemyNum / 5;
                                    int j = enemyNum % 5;
                                    int y = playerNum / 5;
                                    int x = playerNum % 5;
                                    ludigeatk(i, j, x, y);
                                    hpCheck(i, j);
                                } else {
                                    int i = 6 - enemyNum / 5;
                                    int j = 4 - enemyNum % 5;
                                    int y = 6 - playerNum / 5;
                                    int x = 4 - playerNum % 5;
                                    ludigeatk(i, j, x, y);
                                    hpCheck(i, j);
                                }
                            }
                            if (inputTokens[3].equals("fenlia")) {
                                if (myTurn == 0) {
                                    int i = enemyNum / 5;
                                    int j = enemyNum % 5;
                                    int y = playerNum / 5;
                                    int x = playerNum % 5;
                                    fenliaatk(i, j, x, y);
                                    hpCheck(i, j);
                                } else {
                                    int i = 6 - enemyNum / 5;
                                    int j = 4 - enemyNum % 5;
                                    int y = 6 - playerNum / 5;
                                    int x = 4 - playerNum % 5;
                                    fenliaatk(i, j, x, y);
                                    hpCheck(i, j);
                                }
                            }
                            if (inputTokens[3].equals("syuranoruaos")) {
                                if (myTurn == 0) {
                                    int i = enemyNum / 5;
                                    int j = enemyNum % 5;
                                    int y = playerNum / 5;
                                    int x = playerNum % 5;
                                    syuranoruaosatk(i, j, x, y);
                                    hpCheck(i, j);
                                } else {
                                    int i = 6 - enemyNum / 5;
                                    int j = 4 - enemyNum % 5;
                                    int y = 6 - playerNum / 5;
                                    int x = 4 - playerNum % 5;
                                    syuranoruaosatk(i, j, x, y);
                                    hpCheck(i, j);
                                }
                            }
                            if (inputTokens[3].equals("midne")) {
                                if (myTurn == 0) {
                                    int i = enemyNum / 5;
                                    int j = enemyNum % 5;
                                    int y = playerNum / 5;
                                    int x = playerNum % 5;
                                    midneatk(i, j, x, y);
                                    hpCheck(i, j);
                                } else {
                                    int i = 6 - enemyNum / 5;
                                    int j = 4 - enemyNum % 5;
                                    int y = 6 - playerNum / 5;
                                    int x = 4 - playerNum % 5;
                                    midneatk(i, j, x, y);
                                    hpCheck(i, j);
                                }
                            }
                            if (inputTokens[3].equals("tiscater")) {
                                if (myTurn == 0) {
                                    int i = enemyNum / 5;
                                    int j = enemyNum % 5;
                                    int y = playerNum / 5;
                                    int x = playerNum % 5;
                                    tiscateratk(i, j, x, y);
                                    hpCheck(i, j);
                                } else {
                                    int i = 6 - enemyNum / 5;
                                    int j = 4 - enemyNum % 5;
                                    int y = 6 - playerNum / 5;
                                    int x = 4 - playerNum % 5;
                                    tiscateratk(i, j, x, y);
                                    hpCheck(i, j);
                                }
                            }
							/*if(color == myColor){//MNCAgﾅの擾
								//buttonArray[i][j].setIcon(myIcon);
							} else {//MNCAgﾅの擾
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
                System.err.println("G[ﾜゑ: " + e);
            }
        }
    }

    public static void main(String[] args) {
        MyClient1 net = new MyClient1();
        net.setVisible(true);
    }

    public void resetSelect(int i, int j) {
        buttonArray[i][j].setBackground(new Color(0, 0, 0));
    }

    public void printHelp(String iconString){
         System.out.println(System.getProperty("file.encoding"));
         ArrayList<String> text = new ArrayList<String>();
         
         try {
             //ファイルを読み込む
             FileReader fr = new FileReader("C:/netprog/Ludiger/"+iconString+".txt");
             BufferedReader br = new BufferedReader(fr);

             //読み込んだファイルを１行ずつ画面出力する
             String line;
             while ((line = br.readLine()) != null) {
                 //System.out.println(++count + "行目：" + line);
                 //menuText.setText(line);
                byte[] bytes = line.getBytes("MS932");
                String str = new String(bytes, "MS932");
                text.add(line);
             }

             //終了処理
             br.close();
             fr.close();
            } catch (IOException ex) {
             //例外発生時処理
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


    public void mouseClicked(MouseEvent e) {//ボタンが押された時
        JButton theButton = (JButton) e.getComponent();
        String theArrayIndex = theButton.getActionCommand();
        int theBnum = Integer.parseInt(theArrayIndex);
        int i = theBnum / 5;
        int j = theBnum % 5;
        int y = selectNum / 5;
        int x = selectNum % 5;
        String[] selectIconS = iconmap.get(buttonArray[i][j]).split("_");

        if (is_Select && myTurn == 0 && selectNum >= 0 && !(selectIconS[0].equals("player"))) {
            String[] selectedIconS = iconmap.get(buttonArray[y][x]).split("_");
            System.out.println("OK");
            if (selectedIconS[1].equals("sword")) {//swordを選択していた場合
                if (iconmap.get(buttonArray[i][j]).equals("field_0_0")) {
                    is_Move = swordCanMoveCheck(i, j, x, y);
                    if (is_Move) {
                        String msg = "PLACE" + " " + theArrayIndex + " " + selectNum + " " + "sword" + " " + myColor;
                        selectNum = -1;
                        is_Move = false;

                        out.println(msg);
                        out.flush();
                        repaint();
                    }
                } else if (selectIconS[0].equals("enemy")) {
                    System.out.println(selectNum);
                    is_atk = swordCanatkCheck(i, j, x, y);
                    if (is_atk) {
                        String msg = "atk" + " " + theArrayIndex + " " + selectNum + " " + "sword" + " " + myColor;
                        selectNum = -1;
                        is_atk = false;

                        out.println(msg);
                        out.flush();
                        repaint();
                    }
                }
            } else if (selectedIconS[1].equals("shield")) {//shieldを選択していた場合
                if (iconmap.get(buttonArray[i][j]).equals("field_0_0")) {
                    is_Move = shieldCanMoveCheck(i, j, x, y);
                    if (is_Move) {
                        String msg = "PLACE" + " " + theArrayIndex + " " + selectNum + " " + "shield" + " " + myColor;
                        selectNum = -1;
                        is_Move = false;

                        out.println(msg);
                        out.flush();
                        repaint();
                    }
                } else if (selectIconS[0].equals("enemy")) {
                    System.out.println(selectNum);
                    is_atk = shieldCanatkCheck(i, j, x, y);
                    if (is_atk) {
                        String msg = "atk" + " " + theArrayIndex + " " + selectNum + " " + "shield" + " " + myColor;
                        selectNum = -1;
                        is_atk = false;

                        out.println(msg);
                        out.flush();
                        repaint();
                    }
                }
            } else if (selectedIconS[1].equals("wizard")) {//wizardを選択していた場合
                if (iconmap.get(buttonArray[i][j]).equals("field_0_0")) {
                    is_Move = wizardCanMoveCheck(i, j, x, y);
                    if (is_Move) {
                        String msg = "PLACE" + " " + theArrayIndex + " " + selectNum + " " + "wizard" + " " + myColor;
                        selectNum = -1;
                        is_Move = false;

                        out.println(msg);
                        out.flush();
                        repaint();
                    }
                } else if (selectIconS[0].equals("enemy")) {
                    System.out.println(selectNum);
                    is_atk = wizardCanatkCheck(i, j, x, y);
                    if (is_atk) {
                        String msg = "atk" + " " + theArrayIndex + " " + selectNum + " " + "wizard" + " " + myColor;
                        selectNum = -1;
                        is_atk = false;

                        out.println(msg);
                        out.flush();
                        repaint();
                    }
                }
            } else if (selectedIconS[1].equals("ludige")) {//ludigeを選択していた場合
                if (iconmap.get(buttonArray[i][j]).equals("field_0_0")) {
                    is_Move = ludigeCanMoveCheck(i, j, x, y);
                    if (is_Move) {
                        String msg = "PLACE" + " " + theArrayIndex + " " + selectNum + " " + "ludige" + " " + myColor;
                        selectNum = -1;
                        is_Move = false;

                        out.println(msg);
                        out.flush();
                        repaint();
                    }
                } else if (selectIconS[0].equals("enemy")) {
                    System.out.println(selectNum);
                    is_atk = ludigeCanatkCheck(i, j, x, y);
                    if (is_atk) {
                        String msg = "atk" + " " + theArrayIndex + " " + selectNum + " " + "ludige" + " " + myColor;
                        selectNum = -1;
                        is_atk = false;

                        out.println(msg);
                        out.flush();
                        repaint();
                    }
                }
            } else if (selectedIconS[1].equals("fenlia")) {//fenliaを選択していた場合
                if (iconmap.get(buttonArray[i][j]).equals("field_0_0")) {
                    is_Move = fenliaCanMoveCheck(i, j, x, y);
                    if (is_Move) {
                        String msg = "PLACE" + " " + theArrayIndex + " " + selectNum + " " + "fenlia" + " " + myColor;
                        selectNum = -1;
                        is_Move = false;

                        out.println(msg);
                        out.flush();
                        repaint();
                    }
                } else if (selectIconS[0].equals("enemy")) {
                    System.out.println(selectNum);
                    is_atk = fenliaCanatkCheck(i, j, x, y);
                    if (is_atk) {
                        String msg = "atk" + " " + theArrayIndex + " " + selectNum + " " + "fenlia" + " " + myColor;
                        selectNum = -1;
                        is_atk = false;

                        out.println(msg);
                        out.flush();
                        repaint();
                    }
                }
            } else if (selectedIconS[1].equals("syuranoruaos")) {//syuranoruaosを選択していた場合
                if (iconmap.get(buttonArray[i][j]).equals("field_0_0")) {
                    is_Move = syuranoruaosCanMoveCheck(i, j, x, y);
                    if (is_Move) {
                        String msg = "PLACE" + " " + theArrayIndex + " " + selectNum + " " + "syuranoruaos" + " " + myColor;
                        selectNum = -1;
                        is_Move = false;

                        out.println(msg);
                        out.flush();
                        repaint();
                    }
                } else if (selectIconS[0].equals("enemy")) {
                    System.out.println(selectNum);
                    is_atk = syuranoruaosCanatkCheck(i, j, x, y);
                    if (is_atk) {
                        String msg = "atk" + " " + theArrayIndex + " " + selectNum + " " + "syuranoruaos" + " " + myColor;
                        selectNum = -1;
                        is_atk = false;

                        out.println(msg);
                        out.flush();
                        repaint();
                    }
                }
            } else if (selectedIconS[1].equals("midne")) {//midneを選択していた場合
                if (iconmap.get(buttonArray[i][j]).equals("field_0_0")) {
                    is_Move = midneCanMoveCheck(i, j, x, y);
                    if (is_Move) {
                        String msg = "PLACE" + " " + theArrayIndex + " " + selectNum + " " + "midne" + " " + myColor;
                        selectNum = -1;
                        is_Move = false;

                        out.println(msg);
                        out.flush();
                        repaint();
                    }
                } else if (selectIconS[0].equals("enemy")) {
                    System.out.println(selectNum);
                    is_atk = midneCanatkCheck(i, j, x, y);
                    if (is_atk) {
                        String msg = "atk" + " " + theArrayIndex + " " + selectNum + " " + "midne" + " " + myColor;
                        selectNum = -1;
                        is_atk = false;

                        out.println(msg);
                        out.flush();
                        repaint();
                    }
                }
            } else if (selectedIconS[1].equals("tiscater")) {//tiscaterを選択していた場合
                if (iconmap.get(buttonArray[i][j]).equals("field_0_0")) {
                    is_Move = tiscaterCanMoveCheck(i, j, x, y);
                    if (is_Move) {
                        String msg = "PLACE" + " " + theArrayIndex + " " + selectNum + " " + "tiscater" + " " + myColor;
                        selectNum = -1;
                        is_Move = false;

                        out.println(msg);
                        out.flush();
                        repaint();
                    }
                } else if (selectIconS[0].equals("enemy")) {
                    System.out.println(selectNum);
                    is_atk = tiscaterCanatkCheck(i, j, x, y);
                    if (is_atk) {
                        String msg = "atk" + " " + theArrayIndex + " " + selectNum + " " + "tiscater" + " " + myColor;
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

    public void helpMenu(String iconName, int i, int j) {
        if (iconName.equals("shield")) {
            helpButton[0].setIcon(shield_move);
            helpButton[1].setIcon(shield_atk);
            helpButton[2].setText("shield");
            helpButton[3].setText("HP:" + hpmap.get(iconmap.get(buttonArray[i][j])));
        } else if (iconName.equals("sword")) {
            helpButton[0].setIcon(sword_move);
            helpButton[1].setIcon(sword_atk);
            helpButton[2].setText("sword");
            helpButton[3].setText("HP:" + hpmap.get(iconmap.get(buttonArray[i][j])));
        } else if (iconName.equals("wizard")) {
            helpButton[0].setIcon(wizard_move);
            helpButton[1].setIcon(wizard_atk);
            helpButton[2].setText("wizard");
            helpButton[3].setText("HP:" + hpmap.get(iconmap.get(buttonArray[i][j])));
        } else if (iconName.equals("ludige")) {
            helpButton[0].setIcon(ludige_move);
            helpButton[1].setIcon(ludige_atk);
            helpButton[2].setText("ludige");
            helpButton[3].setText("HP:" + hpmap.get(iconmap.get(buttonArray[i][j])));
        } else if (iconName.equals("fenlia")) {
            helpButton[0].setIcon(fenlia_move);
            helpButton[1].setIcon(fenlia_atk);
            helpButton[2].setText("fenlia");
            helpButton[3].setText("HP:" + hpmap.get(iconmap.get(buttonArray[i][j])));
        } else if (iconName.equals("syuranoruaos")) {
            helpButton[0].setIcon(syuranoruaos_move);
            helpButton[1].setIcon(syuranoruaos_atk);
            helpButton[2].setText("syuranoruaos");
            helpButton[3].setText("HP:" + hpmap.get(iconmap.get(buttonArray[i][j])));
        } else if (iconName.equals("midne")) {
            helpButton[0].setIcon(midne_move);
            helpButton[1].setIcon(midne_atk);
            helpButton[2].setText("midne");
            helpButton[3].setText("HP:" + hpmap.get(iconmap.get(buttonArray[i][j])));
        } else if (iconName.equals("tiscater")) {
            helpButton[0].setIcon(tiscater_move);
            helpButton[1].setIcon(tiscater_atk);
            helpButton[2].setText("tiscater");
            helpButton[3].setText("HP:" + hpmap.get(iconmap.get(buttonArray[i][j])));
        } else {
            helpButton[0].setIcon(helpBoard);
            helpButton[1].setIcon(helpBoard);
            helpButton[2].setText("Board");
        }
    }


    public void hpCheck(int i, int j) {
        String[] damagedIcon = iconmap.get(buttonArray[i][j]).split("_");

        if (hpmap.get(iconmap.get(buttonArray[i][j])) <= 0) {
            if (damagedIcon[1].equals("ludige")) {
                //GAME OVER
                System.out.println("Finish!!!!!");
            } else if (damagedIcon[1].equals("fenlia")) {
                isEnd = true;
                for (int y = 0; y < 7; y++) {
                    for (int x = 0; x < 5; x++) {
                        String sacrifice = iconmap.get(buttonArray[y][x]);
                        if (myTurn == 0) {
                            if (sacrifice.equals("enemy_syuranoruaos_9") || sacrifice.equals("enemy_midne_9") || sacrifice.equals("enemy_tiscater_9")) {
                                sacrificeAction(sacrifice, i, j, x, y);
                            }
                        } else {
                            if (sacrifice.equals("player_syuranoruaos_9") || sacrifice.equals("player_midne_9") || sacrifice.equals("player_tiscater_9")) {
                                sacrificeAction(sacrifice, i, j, x, y);
                            }
                        }

                    }
                }
                //GAME OVER
                if (isEnd) {
                    System.out.println("Finish!!!!!");
                }
            }

            if ((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0)) {
                buttonArray[i][j].setIcon(boardIcon1);
            } else {
                buttonArray[i][j].setIcon(boardIcon2);
            }
            iconmap.put(buttonArray[i][j], "field_0_0");
        }
    }

    public void sacrificeAction(String sacrifice, int i, int j, int x, int y) {
        if ((myColor == 0 && myTurn == 0) || (myColor == 1 && myTurn == 1)) {
            buttonArray[y][x].setIcon(fenlia_B);
        } else {
            buttonArray[y][x].setIcon(fenlia_R);
        }
        iconmap.put(buttonArray[y][x], iconmap.get(buttonArray[i][j]));
        hpmap.put(iconmap.get(buttonArray[i][j]), hpmap.get(sacrifice));
        atkmap.put(iconmap.get(buttonArray[i][j]), atkmap.get(sacrifice));
        isEnd = false;
    }


    //swordについて

    public void swordMove(int y, int x, int sword_x, int sword_y) {
        System.out.println("OKKKK");
        String val = iconmap.get(buttonArray[sword_y][sword_x]);
        iconmap.remove(buttonArray[y][x]);
        iconmap.put(buttonArray[y][x], val);
        iconmap.put(buttonArray[sword_y][sword_x], "field_0_0");
        if ((myColor == 0 && myTurn == 0) || (myColor == 1 && myTurn == 1)) {//myColor==myTurn
            buttonArray[y][x].setIcon(sword_R);
        } else {
            buttonArray[y][x].setIcon(sword_B);
        }
        if ((sword_x % 2 == 0 && sword_y % 2 == 0) || (sword_x % 2 != 0 && sword_y % 2 != 0)) {
            buttonArray[sword_y][sword_x].setIcon(boardIcon1);
        } else {
            buttonArray[sword_y][sword_x].setIcon(boardIcon2);
        }
    }

    public boolean swordCanMoveCheck(int y, int x, int sword_x, int sword_y) {
        boolean flag = false;
        for (int i = -1; i < 1; i++) {
            for (int j = -1; j < 2; j++) {
                if ((sword_x + j == x) && (sword_y + i == y)) {
                    flag = true;
                    return flag;
                }
            }
        }
        if (sword_x == x && sword_y + 1 == y) {
            flag = true;
            return flag;
        }
        return flag;
    }

    public void swordatk(int y, int x, int sword_x, int sword_y) {
        System.out.println("OKKK");
        int atk = atkmap.get(iconmap.get(buttonArray[sword_y][sword_x]));
        //String enemyType=iconmap.get(buttonArray[y][x]);
        int enemyHP = hpmap.get(iconmap.get(buttonArray[y][x]));

        String[] enemy = iconmap.get(buttonArray[y][x]).split("_");

        if (enemy[1].equals("wizard")) {
            hpmap.put(iconmap.get(buttonArray[y][x]), enemyHP - 2);
        } else {
            hpmap.put(iconmap.get(buttonArray[y][x]), enemyHP - atk);
        }
    }

    public boolean swordCanatkCheck(int y, int x, int sword_x, int sword_y) {
        boolean flag = false;
        for (int i = -1; i < 1; i++) {
            for (int j = -1; j < 2; j++) {
                if ((sword_x + j == x) && (sword_y + i == y)) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }


    //shieldについて

    public void shieldMove(int y, int x, int shield_x, int shield_y) {
        System.out.println("OKKKK");
        String val = iconmap.get(buttonArray[shield_y][shield_x]);
        iconmap.remove(buttonArray[y][x]);
        iconmap.put(buttonArray[y][x], val);
        iconmap.put(buttonArray[shield_y][shield_x], "field_0_0");
        if ((myColor == 0 && myTurn == 0) || (myColor == 1 && myTurn == 1)) {//myColor==myTurn
            buttonArray[y][x].setIcon(shield_R);
        } else {
            buttonArray[y][x].setIcon(shield_B);
        }
        if ((shield_x % 2 == 0 && shield_y % 2 == 0) || (shield_x % 2 != 0 && shield_y % 2 != 0)) {
            buttonArray[shield_y][shield_x].setIcon(boardIcon1);
        } else {
            buttonArray[shield_y][shield_x].setIcon(boardIcon2);
        }
    }

    public boolean shieldCanMoveCheck(int y, int x, int shield_x, int shield_y) {
        boolean flag = false;
        if (shield_x == x && shield_y - 1 == y) {
            flag = true;
            return flag;
        }
        for (int i = 0; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if ((shield_x + j == x) && (shield_y + i == y)) {
                    flag = true;
                    return flag;
                }
            }
        }
        for (int i = -2; i < 3; i += 2) {
            if (shield_y + 2 == y && shield_x + i == x) {
                flag = true;
                return flag;
            }
        }
        return flag;
    }

    public void shieldatk(int y, int x, int shield_x, int shield_y) {
        System.out.println("OKKK");
        int atk = atkmap.get(iconmap.get(buttonArray[shield_y][shield_x]));
        //String enemyType=iconmap.get(buttonArray[y][x]);
        int enemyHP = hpmap.get(iconmap.get(buttonArray[y][x]));

        String[] enemy = iconmap.get(buttonArray[y][x]).split("_");

        hpmap.put(iconmap.get(buttonArray[y][x]), enemyHP - atk);
    }

    public boolean shieldCanatkCheck(int y, int x, int shield_x, int shield_y) {
        boolean flag = false;
        for (int i = -1; i < 1; i++) {
            for (int j = -1; j < 2; j++) {
                if ((shield_x + j == x) && (shield_y + i == y)) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }


    //wizardについて

    public void wizardMove(int y, int x, int wizard_x, int wizard_y) {
        System.out.println("OKKKK");
        String val = iconmap.get(buttonArray[wizard_y][wizard_x]);
        iconmap.remove(buttonArray[y][x]);
        iconmap.put(buttonArray[y][x], val);
        iconmap.put(buttonArray[wizard_y][wizard_x], "field_0_0");
        if ((myColor == 0 && myTurn == 0) || (myColor == 1 && myTurn == 1)) {//myColor==myTurn
            buttonArray[y][x].setIcon(wizard_R);
        } else {
            buttonArray[y][x].setIcon(wizard_B);
        }
        if ((wizard_x % 2 == 0 && wizard_y % 2 == 0) || (wizard_x % 2 != 0 && wizard_y % 2 != 0)) {
            buttonArray[wizard_y][wizard_x].setIcon(boardIcon1);
        } else {
            buttonArray[wizard_y][wizard_x].setIcon(boardIcon2);
        }
    }

    public boolean wizardCanMoveCheck(int y, int x, int wizard_x, int wizard_y) {
        boolean flag = false;
        if ((wizard_x - 1 == x || wizard_x + 1 == x) && wizard_y == y) {
            flag = true;
            return flag;
        }
        for (int i = -2, j = 2; i < 3; i++, j--) {
            if ((wizard_x + i == x && wizard_y + i == y) || (wizard_x + j == x && wizard_y + i == y)) {
                flag = true;
                return flag;
            }
        }
        return flag;
    }

    public void wizardatk(int y, int x, int wizard_x, int wizard_y) {
        System.out.println("OKKK");
        int atk = atkmap.get(iconmap.get(buttonArray[wizard_y][wizard_x]));
        //String enemyType=iconmap.get(buttonArray[y][x]);
        int enemyHP = hpmap.get(iconmap.get(buttonArray[y][x]));

        String[] enemy = iconmap.get(buttonArray[y][x]).split("_");

        if (enemy[1].equals("sword")) {
            hpmap.put(iconmap.get(buttonArray[y][x]), enemyHP - 2);
        } else {
            hpmap.put(iconmap.get(buttonArray[y][x]), enemyHP - atk);
        }
    }

    public boolean wizardCanatkCheck(int y, int x, int wizard_x, int wizard_y) {
        boolean flag = false;
        if ((wizard_x - 1 == x || wizard_x + 1 == x) && wizard_y == y) {
            flag = true;
            return flag;
        }
        for (int i = -2, j = 2; i < 3; i++, j--) {
            if ((wizard_x + i == x && wizard_y + i == y) || (wizard_x + j == x && wizard_y + i == y)) {
                flag = true;
                return flag;
            } else if ((wizard_x == x && wizard_y + i == y) || (wizard_x + i == x && wizard_y == y)) {
                flag = true;
                return flag;
            }
        }
        return flag;
    }

    

    public void ludigeMove(int y, int x, int ludige_x, int ludige_y) {
        System.out.println("OKKKK");
        String val = iconmap.get(buttonArray[ludige_y][ludige_x]);
        iconmap.remove(buttonArray[y][x]);
        iconmap.put(buttonArray[y][x], val);
        iconmap.put(buttonArray[ludige_y][ludige_x], "field_0_0");
        if ((myColor == 0 && myTurn == 0) || (myColor == 1 && myTurn == 1)) {//myColor==myTurn
            buttonArray[y][x].setIcon(ludige_R);
        } else {
            buttonArray[y][x].setIcon(ludige_B);
        }
        if ((ludige_x % 2 == 0 && ludige_y % 2 == 0) || (ludige_x % 2 != 0 && ludige_y % 2 != 0)) {
            buttonArray[ludige_y][ludige_x].setIcon(boardIcon1);
        } else {
            buttonArray[ludige_y][ludige_x].setIcon(boardIcon2);
        }
    }

    public boolean ludigeCanMoveCheck(int y, int x, int ludige_x, int ludige_y) {
        boolean flag = false;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (ludige_x + j == x && ludige_y + i == y) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }

    public void ludigeatk(int y, int x, int ludige_x, int ludige_y) {
        System.out.println("OKKK");
        int atk = atkmap.get(iconmap.get(buttonArray[ludige_y][ludige_x]));
        //String enemyType=iconmap.get(buttonArray[y][x]);
        int enemyHP = hpmap.get(iconmap.get(buttonArray[y][x]));

        String[] enemy = iconmap.get(buttonArray[y][x]).split("_");

        if (enemy[1].equals("shield")) {
            hpmap.put(iconmap.get(buttonArray[y][x]), enemyHP - 1);
        } else {
            hpmap.put(iconmap.get(buttonArray[y][x]), enemyHP - atk);
        }
    }

    public boolean ludigeCanatkCheck(int y, int x, int ludige_x, int ludige_y) {
        boolean flag = false;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (ludige_x + j == x && ludige_y + i == y) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }

    

    public void fenliaMove(int y, int x, int fenlia_x, int fenlia_y) {
        System.out.println("OKKKK");
        String val = iconmap.get(buttonArray[fenlia_y][fenlia_x]);
        iconmap.remove(buttonArray[y][x]);
        iconmap.put(buttonArray[y][x], val);
        iconmap.put(buttonArray[fenlia_y][fenlia_x], "field_0_0");
        if ((myColor == 0 && myTurn == 0) || (myColor == 1 && myTurn == 1)) {//myColor==myTurn
            buttonArray[y][x].setIcon(fenlia_R);
        } else {
            buttonArray[y][x].setIcon(fenlia_B);
        }
        if ((fenlia_x % 2 == 0 && fenlia_y % 2 == 0) || (fenlia_x % 2 != 0 && fenlia_y % 2 != 0)) {
            buttonArray[fenlia_y][fenlia_x].setIcon(boardIcon1);
        } else {
            buttonArray[fenlia_y][fenlia_x].setIcon(boardIcon2);
        }
    }

    public boolean fenliaCanMoveCheck(int y, int x, int fenlia_x, int fenlia_y) {
        boolean flag = false;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (fenlia_x + j == x && fenlia_y + i == y) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }

    public void fenliaatk(int y, int x, int fenlia_x, int fenlia_y) {
        System.out.println("OKKK");
        int atk = atkmap.get(iconmap.get(buttonArray[fenlia_y][fenlia_x]));
        //String enemyType=iconmap.get(buttonArray[y][x]);
        int enemyHP = hpmap.get(iconmap.get(buttonArray[y][x]));

        String[] enemy = iconmap.get(buttonArray[y][x]).split("_");
        if (enemy[1].equals("ludige")) {
            hpmap.put(iconmap.get(buttonArray[y][x]), 0);
        } else {
            hpmap.put(iconmap.get(buttonArray[y][x]), enemyHP - atk);

        }
    }

    public boolean fenliaCanatkCheck(int y, int x, int fenlia_x, int fenlia_y) {
        boolean flag = false;
        String[] atkIcon = iconmap.get(buttonArray[y][x]).split("_");
        if (atkIcon[1].equals("fenlia")) {
            return flag;
        }
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (fenlia_x + j == x && fenlia_y + i == y) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }

    

    public void syuranoruaosMove(int y, int x, int syuranoruaos_x, int syuranoruaos_y) {
        System.out.println("OKKKK");
        String val = iconmap.get(buttonArray[syuranoruaos_y][syuranoruaos_x]);
        iconmap.remove(buttonArray[y][x]);
        iconmap.put(buttonArray[y][x], val);
        iconmap.put(buttonArray[syuranoruaos_y][syuranoruaos_x], "field_0_0");
        if ((myColor == 0 && myTurn == 0) || (myColor == 1 && myTurn == 1)) {//myColor==myTurn
            buttonArray[y][x].setIcon(syuranoruaos_R);
        } else {
            buttonArray[y][x].setIcon(syuranoruaos_B);
        }
        if ((syuranoruaos_x % 2 == 0 && syuranoruaos_y % 2 == 0) || (syuranoruaos_x % 2 != 0 && syuranoruaos_y % 2 != 0)) {
            buttonArray[syuranoruaos_y][syuranoruaos_x].setIcon(boardIcon1);
        } else {
            buttonArray[syuranoruaos_y][syuranoruaos_x].setIcon(boardIcon2);
        }
    }

    public boolean syuranoruaosCanMoveCheck(int y, int x, int syuranoruaos_x, int syuranoruaos_y) {
        boolean flag = false;
        if ((syuranoruaos_x - 1 == x || syuranoruaos_x + 1 == x) && syuranoruaos_y == y) {
            flag = true;
            return flag;
        }
        for (int i = -2, j = 2; i < 3; i++, j--) {
            if ((syuranoruaos_x + i == x && syuranoruaos_y + i == y) || (syuranoruaos_x + j == x && syuranoruaos_y + i == y)) {
                flag = true;
                return flag;
            }
        }
        return flag;
    }

    public void syuranoruaosatk(int y, int x, int syuranoruaos_x, int syuranoruaos_y) {
        System.out.println("OKKK");
        int atk = atkmap.get(iconmap.get(buttonArray[syuranoruaos_y][syuranoruaos_x]));
        //String enemyType=iconmap.get(buttonArray[y][x]);
        int enemyHP = hpmap.get(iconmap.get(buttonArray[y][x]));

        String[] enemy = iconmap.get(buttonArray[y][x]).split("_");

        hpmap.put(iconmap.get(buttonArray[y][x]), enemyHP - atk);
    }

    public boolean syuranoruaosCanatkCheck(int y, int x, int syuranoruaos_x, int syuranoruaos_y) {
        boolean flag = false;
        if ((syuranoruaos_x - 1 == x || syuranoruaos_x + 1 == x) && syuranoruaos_y == y) {
            flag = true;
            return flag;
        }
        for (int i = -2, j = 2; i < 3; i++, j--) {
            if ((syuranoruaos_x + i == x && syuranoruaos_y + i == y) || (syuranoruaos_x + j == x && syuranoruaos_y + i == y)) {
                flag = true;
                return flag;
            }
        }
        return flag;
    }

    

    public void midneMove(int y, int x, int midne_x, int midne_y) {
        System.out.println("OKKKK");
        String val = iconmap.get(buttonArray[midne_y][midne_x]);
        iconmap.remove(buttonArray[y][x]);
        iconmap.put(buttonArray[y][x], val);
        iconmap.put(buttonArray[midne_y][midne_x], "field_0_0");
        if ((myColor == 0 && myTurn == 0) || (myColor == 1 && myTurn == 1)) {//myColor==myTurn
            buttonArray[y][x].setIcon(midne_R);
        } else {
            buttonArray[y][x].setIcon(midne_B);
        }
        if ((midne_x % 2 == 0 && midne_y % 2 == 0) || (midne_x % 2 != 0 && midne_y % 2 != 0)) {
            buttonArray[midne_y][midne_x].setIcon(boardIcon1);
        } else {
            buttonArray[midne_y][midne_x].setIcon(boardIcon2);
        }
    }

    public boolean midneCanMoveCheck(int y, int x, int midne_x, int midne_y) {
        boolean flag = false;
        for (int i = -2, j = -2; i < 3; i++, j++) {
            if ((midne_x + i == x && midne_y == y) || (midne_x == x && midne_y + j == y)) {
                flag = true;
                return flag;
            }
        }
        return flag;
    }

    public void midneatk(int y, int x, int midne_x, int midne_y) {
        System.out.println("OKKK");
        int atk = atkmap.get(iconmap.get(buttonArray[midne_y][midne_x]));
        //String Type=iconmap.get(buttonArray[y][x]);
        int enemyHP = hpmap.get(iconmap.get(buttonArray[y][x]));

        String[] enemy = iconmap.get(buttonArray[y][x]).split("_");

        hpmap.put(iconmap.get(buttonArray[y][x]), enemyHP - atk);
    }

    public boolean midneCanatkCheck(int y, int x, int midne_x, int midne_y) {
        boolean flag = false;
        for (int i = -2, j = -2; i < 3; i++, j++) {
            if ((midne_x + i == x && midne_y == y) || (midne_x == x && midne_y + j == y)) {
                flag = true;
                return flag;
            }
        }
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (midne_x + j == x && midne_y + j == y) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }

    

    public void tiscaterMove(int y, int x, int tiscater_x, int tiscater_y) {
        System.out.println("OKKKK");
        String val = iconmap.get(buttonArray[tiscater_y][tiscater_x]);
        iconmap.remove(buttonArray[y][x]);
        iconmap.put(buttonArray[y][x], val);
        iconmap.put(buttonArray[tiscater_y][tiscater_x], "field_0_0");
        if ((myColor == 0 && myTurn == 0) || (myColor == 1 && myTurn == 1)) {//myColor==myTurn
            buttonArray[y][x].setIcon(tiscater_R);
        } else {
            buttonArray[y][x].setIcon(tiscater_B);
        }
        if ((tiscater_x % 2 == 0 && tiscater_y % 2 == 0) || (tiscater_x % 2 != 0 && tiscater_y % 2 != 0)) {
            buttonArray[tiscater_y][tiscater_x].setIcon(boardIcon1);
        } else {
            buttonArray[tiscater_y][tiscater_x].setIcon(boardIcon2);
        }
    }

    public boolean tiscaterCanMoveCheck(int y, int x, int tiscater_x, int tiscater_y) {
        boolean flag = false;
        for (int i = -2; i < 3; i++) {
            if (tiscater_x == x && tiscater_y + i == y) {
                flag = true;
                return flag;
            }
        }
        for (int i = -1; i < 1; i++) {
            for (int j = 1; j < 3; j *= 2) {
                if ((tiscater_x + j == x || tiscater_x - j == x) && (tiscater_y + i == y)) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }

    public void tiscateratk(int y, int x, int tiscater_x, int tiscater_y) {
        System.out.println("OKKK");
        int atk = atkmap.get(iconmap.get(buttonArray[tiscater_y][tiscater_x]));
        //String enemyType=iconmap.get(buttonArray[y][x]);
        int enemyHP = hpmap.get(iconmap.get(buttonArray[y][x]));

        String[] enemy = iconmap.get(buttonArray[y][x]).split("_");

        hpmap.put(iconmap.get(buttonArray[y][x]), enemyHP - atk);
    }

    public boolean tiscaterCanatkCheck(int y, int x, int tiscater_x, int tiscater_y) {
        boolean flag = false;
        for (int i = -2, j = -2; i < 3; i++, j++) {
            if ((tiscater_x + i == x && tiscater_y == y) || (tiscater_x == x && tiscater_y + j == y)) {
                flag = true;
                return flag;
            }
        }
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (tiscater_x + j == x && tiscater_y + j == y) {
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
}