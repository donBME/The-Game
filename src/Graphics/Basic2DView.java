package Graphics;

import GameObjects.FieldObject;
import GameObjects.StarGate;
import Inventories.DataAccessPoint;
import Players.Colonel;
import Players.Jaffa;
import Players.Replicator;
import Tools.CVector;
import Tools.Controller;
import Tools.Coordinate;
import Tools.Direction;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.HashMap;

/**
 * Nézetet megvalósító osztály
 */
public class Basic2DView implements Notifiable {

    // "Globális" változók
    private static final int CONFIG_SIZE = 3;
    private final Controller controller;
    private DataAccessPoint data;
    private JComboBox<Object> mapselectbox;
    private JFrame jFrame;
    private JPanel pTitle;
    private JPanel maps;
    private JPanel buttonPanel;
    private JPanel gamePanel;
    private Timer replicatorTimer;
    private HashMap<String, ImageIcon> iconBuffer;

    private int OBJECT_WIDTH, OBJECT_HEIGHT;
    private Coordinate maxCoord;

    /**
     * Üres konstrukor
     */
    public Basic2DView() {
        controller = new Controller(this);
        initWindow();
    }

    /**
     * Grafikus elemek betöltése, az összes grafikus elemet a memóriába másolja
     *
     * @throws IOException Beolvasási hiba esetén kivételt dob
     */
    private void loadIcons() throws IOException {
        iconBuffer = new HashMap<>();

        iconBuffer.put("ColonelUp", new ImageIcon(ImageIO.read(new File("Don-Graphics/OneilUpstep1/upOneillUpstep1.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("ColonelRight", new ImageIcon(ImageIO.read(new File("Don-Graphics/OneilUpstep1/rightOneillUpstep1.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("ColonelLeft", new ImageIcon(ImageIO.read(new File("Don-Graphics/OneilUpstep1/leftOneillUpstep1.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("ColonelDown", new ImageIcon(ImageIO.read(new File("Don-Graphics/OneilUpstep1/downOneillUpstep1.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

        iconBuffer.put("JaffaUp", new ImageIcon(ImageIO.read(new File("Don-Graphics/JaffaStep1/upJaffaStep1.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("JaffaRight", new ImageIcon(ImageIO.read(new File("Don-Graphics/JaffaStep1/rightJaffaStep1.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("JaffaLeft", new ImageIcon(ImageIO.read(new File("Don-Graphics/JaffaStep1/leftJaffaStep1.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("JaffaDown", new ImageIcon(ImageIO.read(new File("Don-Graphics/JaffaStep1/downJaffaStep1.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

        iconBuffer.put("ReplicatorUp", new ImageIcon(ImageIO.read(new File("Don-Graphics/Replicator/upReplicator.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("ReplicatorRight", new ImageIcon(ImageIO.read(new File("Don-Graphics/Replicator/rightReplicator.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("ReplicatorLeft", new ImageIcon(ImageIO.read(new File("Don-Graphics/Replicator/leftReplicator.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("ReplicatorDown", new ImageIcon(ImageIO.read(new File("Don-Graphics/Replicator/downReplicator.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

        iconBuffer.put("Way", new ImageIcon(ImageIO.read(new File("Don-Graphics/way.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

        iconBuffer.put("SpecWall", new ImageIcon(ImageIO.read(new File("Don-Graphics/SpecWall.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

        iconBuffer.put("Wall", new ImageIcon(ImageIO.read(new File("Don-Graphics/wall.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

        iconBuffer.put("ZPM", new ImageIcon(ImageIO.read(new File("Don-Graphics/ZPM.png")).
                getScaledInstance(OBJECT_WIDTH / 2, OBJECT_HEIGHT / 2, Image.SCALE_SMOOTH)));

        iconBuffer.put("Abyss", new ImageIcon(ImageIO.read(new File("Don-Graphics/Abyss.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

        iconBuffer.put("RightYellowGate", new ImageIcon(ImageIO.read(new File("Don-Graphics/rightYellowGate.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("LeftYellowGate", new ImageIcon(ImageIO.read(new File("Don-Graphics/leftYellowGate.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("UpYellowGate", new ImageIcon(ImageIO.read(new File("Don-Graphics/upYellowGate.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("DownYellowGate", new ImageIcon(ImageIO.read(new File("Don-Graphics/downYellowGate.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

        iconBuffer.put("RightGreenGate", new ImageIcon(ImageIO.read(new File("Don-Graphics/rightGreenGate.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("LeftGreenGate", new ImageIcon(ImageIO.read(new File("Don-Graphics/leftGreenGate.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("UpGreenGate", new ImageIcon(ImageIO.read(new File("Don-Graphics/upGreenGate.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("DownGreenGate", new ImageIcon(ImageIO.read(new File("Don-Graphics/downGreenGate.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

        iconBuffer.put("RightRedGate", new ImageIcon(ImageIO.read(new File("Don-Graphics/rightRedGate.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("LeftRedGate", new ImageIcon(ImageIO.read(new File("Don-Graphics/leftRedGate.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("UpRedGate", new ImageIcon(ImageIO.read(new File("Don-Graphics/upRedGate.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("DownRedGate", new ImageIcon(ImageIO.read(new File("Don-Graphics/downRedGate.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

        iconBuffer.put("RightBlueGate", new ImageIcon(ImageIO.read(new File("Don-Graphics/rightBlueGate.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("LeftBlueGate", new ImageIcon(ImageIO.read(new File("Don-Graphics/leftBlueGate.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("UpBlueGate", new ImageIcon(ImageIO.read(new File("Don-Graphics/upBlueGate.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("DownBlueGate", new ImageIcon(ImageIO.read(new File("Don-Graphics/downBlueGate.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

        iconBuffer.put("Box", new ImageIcon(ImageIO.read(new File("Don-Graphics/box.png")).
                getScaledInstance(OBJECT_WIDTH / 2, OBJECT_HEIGHT / 2, Image.SCALE_SMOOTH)));

        iconBuffer.put("ButtonOpened", new ImageIcon(ImageIO.read(new File("Don-Graphics/ButtonOpened.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("ButtonClosed", new ImageIcon(ImageIO.read(new File("Don-Graphics/ButtonClosed.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

        iconBuffer.put("DoorOpened", new ImageIcon(ImageIO.read(new File("Don-Graphics/DoorOpened.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
        iconBuffer.put("DoorClosed", new ImageIcon(ImageIO.read(new File("Don-Graphics/DoorClosed.png")).
                getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

    }

    /**
     * Ablak inicializálása, vezérlőelemek elhelyezése, menü kirajzolása
     */
    private void initWindow() {

        // Adatok betöltése
        String[] config = getConfig();
        // Ha nem sikeres, visszajelzést kapunk és kilépünk
        if (!config[0].equals("ok!"))
            return;

        // ablak létrehozása
        jFrame = new JFrame();
        int num_of_maps;

        try {
            // config adatok beállítása az ablakon
            int w = Integer.parseInt(config[1]);
            int h = Integer.parseInt(config[2]);
            jFrame.setSize(w, h);
            num_of_maps = Integer.parseInt(config[3]);
        } catch (NumberFormatException e) {

            // amennyiben a config fájl tartalma nem konzisztens az elvárásokkal, alapértelmezett értékeket használunk
            jFrame.setSize(800, 600);
            num_of_maps = 0;
        }
        // cím középre és felülre igazítva
        JLabel title = new JLabel("don Game - Stargates");
        pTitle = new JPanel();
        pTitle.add(title, BorderLayout.CENTER);


        // pályaválasztáshoz legördülő lista:
        String[] combolabels = new String[num_of_maps];
        for (int i = 0; i < num_of_maps; i++) {
            combolabels[i] = "" + (i + 1);
        }

        // címkék hozzáadása
        mapselectbox = new JComboBox<>(combolabels);

        // tájékoztató felirat
        JLabel info = new JLabel("Please select map number below:");

        // ezeket tartalmazó panel
        maps = new JPanel();
        GridLayout mapsLayout = new GridLayout(20, 0);

        // layout beállítása, elemek hozzáadása
        maps.setLayout(mapsLayout);
        maps.add(info);
        maps.add(mapselectbox);

        // gombpanel és gomb létrehozása, igazítások
        buttonPanel = new JPanel();
        JButton startbutton = new JButton();
        startbutton.setText("Start!");
        buttonPanel.add(startbutton, BorderLayout.CENTER);

        startbutton.addActionListener(e -> {
            int selectedMap = mapselectbox.getSelectedIndex() + 1;
            jFrame.remove(maps);
            jFrame.remove(pTitle);
            jFrame.remove(buttonPanel);
            gamePanel = new JPanel();
            gamePanel.setLayout(null);
            gamePanel.setPreferredSize(new Dimension(jFrame.getWidth(), jFrame.getHeight()));
            jFrame.add(gamePanel);
            jFrame.pack();
            controller.loadMap(selectedMap);

        });

        // panelek ablakhoz hozzáadása
        jFrame.add(pTitle, BorderLayout.PAGE_START);
        jFrame.add(maps, BorderLayout.CENTER);
        jFrame.add(buttonPanel, BorderLayout.PAGE_END);

        jFrame.setResizable(false);
        jFrame.setVisible(true);

        jFrame.addKeyListener(controller);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    /**
     * config.ini fájlból adatok kiolvasása
     * az ablak és a pályabemeneti paraméterek így programon kívül egyszerűen testreszabhatók
     *
     * @return beolvasott konfiguráció
     */
    private String[] getConfig() {
        BufferedReader read;

        try {
            // eltároljuk a configból beolvasott adatokat és a válasz eredményét
            String[] result = new String[CONFIG_SIZE + 1];
            read = new BufferedReader(new FileReader("config.ini"));

            // beolvassuk a sorokat
            for (int i = 1; i < CONFIG_SIZE + 1; i++) {
                String row = read.readLine();
                String[] tmp = row.split(" ");
                result[i] = tmp[1];
            }
            read.close();

            // nyugtázzuk hogy minden jól ment
            result[0] = "ok!";
            return result;

        } catch (FileNotFoundException e) {

            //ha nem létezik a fájl
            e.printStackTrace();
            String[] result = new String[1];
            result[0] = "File not found";
            return result;

        } catch (IOException e) {

            //bármely io hiba esetén
            e.printStackTrace();
            String[] result = new String[1];
            result[0] = "Unexpected Error";
            return result;
        }
    }

    /**
     * Nézet értesítése a kirajzolandó adatok megváltozásáról
     */
    @Override
    public void notifyView() {
        drawAll();
    }

    /**
     * Adattároló referencia beállítása
     *
     * @param data adattároló referencia
     */
    @Override
    public void setData(DataAccessPoint data) {
        // Globális paraméterek beállítása
        this.data = data;
        maxCoord = data.fields.getMaxCoordinates();
        OBJECT_WIDTH = gamePanel.getWidth() / (maxCoord.GetX() + 1);
        OBJECT_HEIGHT = gamePanel.getHeight() / (maxCoord.GetY() + 1);
        System.out.println(maxCoord.GetX() + " " + maxCoord.GetY());
        System.out.println(OBJECT_WIDTH + " " + OBJECT_HEIGHT);

        // Grafika betöltése
        try {
            loadIcons();
        } catch (IOException ignored) {
        }

        // Replikátor kezelése
        if (data.Repli != null) {
            replicatorTimer = new Timer(2000, e -> data.Repli.randomMove());
            replicatorTimer.start();
        }

        // Kezdeti kirajzolás
        drawAll();
    }

    /**
     * Dobozt kirajzoló függvény
     *
     * @param coord       kirajzolandó doboz koordinátái
     * @param subPosition hányadik doboz az adott koordinátán
     */
    private void drawBox(Coordinate coord, int subPosition) {

        // Változók inicializálása
        JLabel label = new JLabel();
        ImageIcon img = iconBuffer.get("Box");
        label.setIcon(img);

        // Pozíció meghatározása
        switch (subPosition) {
            case 1:
                label.setBounds(OBJECT_WIDTH * coord.GetX() + OBJECT_WIDTH / 4,
                        gamePanel.getHeight() - OBJECT_HEIGHT * (coord.GetY() + 1),
                        OBJECT_WIDTH, OBJECT_HEIGHT);
                break;
            case 2:
                label.setBounds(OBJECT_WIDTH * coord.GetX(),
                        gamePanel.getHeight() - OBJECT_HEIGHT * (coord.GetY() + 1) - OBJECT_HEIGHT / 4,
                        OBJECT_WIDTH, OBJECT_HEIGHT);
                break;
            case 3:
                label.setBounds(OBJECT_WIDTH * coord.GetX(),
                        gamePanel.getHeight() - OBJECT_HEIGHT * (coord.GetY() + 1) + OBJECT_HEIGHT / 4,
                        OBJECT_WIDTH, OBJECT_HEIGHT);
                break;
            case 4:
                label.setBounds(OBJECT_WIDTH * coord.GetX() + OBJECT_WIDTH / 2,
                        gamePanel.getHeight() - OBJECT_HEIGHT * (coord.GetY() + 1) + OBJECT_HEIGHT / 4,
                        OBJECT_WIDTH, OBJECT_HEIGHT);
                break;
            case 5:
                label.setBounds(OBJECT_WIDTH * coord.GetX() + OBJECT_WIDTH / 2,
                        gamePanel.getHeight() - OBJECT_HEIGHT * (coord.GetY() + 1) - OBJECT_HEIGHT / 4,
                        OBJECT_WIDTH, OBJECT_HEIGHT);
                break;
        }

        // Panelhez adás
        gamePanel.add(label);
    }

    /**
     * Gombot kirajzoló függvény
     *
     * @param coord a kirajzolandó gomb koordinátái
     */
    private void drawButton(Coordinate coord) {

        // Változók inicializálása
        JLabel label = new JLabel();
        ImageIcon img;

        // Nyitottság ellenőrzése
        if (data.buttons.isOpenAt(coord)) {
            img = iconBuffer.get("ButtonOpened");
        } else {
            img = iconBuffer.get("ButtonClosed");
        }

        // Grafika beállítása
        label.setIcon(img);
        label.setBounds(OBJECT_WIDTH * coord.GetX(), gamePanel.getHeight() - OBJECT_HEIGHT * (coord.GetY() + 1),
                OBJECT_WIDTH, OBJECT_HEIGHT);
        gamePanel.add(label);
    }

    /**
     * Fieldobjectek kirajzolása
     *
     * @param fieldObject fieldobject referencia
     * @param coord       kirajzolandó koordináta
     */
    private void drawFieldObject(FieldObject fieldObject, Coordinate coord) {

        // Változók inicializálása
        JLabel label = new JLabel();
        ImageIcon img = null;

        // Kép kiválasztása
        if (fieldObject.Steppable()) {
            if (fieldObject.isDoor()) {

                // Nyitott ajtó
                img = iconBuffer.get("DoorOpened");
            } else if (!fieldObject.IsMortal()) {

                // Út
                img = iconBuffer.get("Way");
            } else if (fieldObject.IsMortal()) {

                // Szakadék
                img = iconBuffer.get("Abyss");
            }
        } else {
            if (fieldObject.isDoor()) {

                // Zárt ajtó
                img = iconBuffer.get("DoorClosed");
            } else if (fieldObject.Shootable()) {

                // Speciális fal
                img = iconBuffer.get("SpecWall");
            } else {

                // "Sima" fal
                img = iconBuffer.get("Wall");
            }
        }

        // Grafika beállítása
        if (img != null) {
            label.setIcon(img);
            label.setBounds(OBJECT_WIDTH * coord.GetX(), gamePanel.getHeight() - OBJECT_HEIGHT * (coord.GetY() + 1),
                    OBJECT_WIDTH, OBJECT_HEIGHT);
            gamePanel.add(label);
        }

    }

    /**
     * Jaffa kirajzolása
     *
     * @param jaffa Jaffa referencia
     */
    private void drawPlayer(Jaffa jaffa) {

        // Változók inicializálása
        CVector pos;
        JLabel label = new JLabel();
        ImageIcon img = null;
        pos = jaffa.getPos();

        // Kép kiválasztása
        switch (pos.GetDir()) {
            case East:
                img = iconBuffer.get("JaffaRight");
                break;
            case North:
                img = iconBuffer.get("JaffaUp");
                break;
            case West:
                img = iconBuffer.get("JaffaLeft");
                break;
            case South:
                img = iconBuffer.get("JaffaDown");
                break;
        }

        // Doboz beállítása
        if (jaffa.hasBox()) {
            drawBox(pos, 1);
        }

        // Grafika beállítása
        label.setIcon(img);
        label.setBounds(OBJECT_WIDTH * pos.GetX(), gamePanel.getHeight() - OBJECT_HEIGHT * (pos.GetY() + 1),
                OBJECT_WIDTH, OBJECT_HEIGHT);
        gamePanel.add(label);
    }

    /**
     * Replikátor kirajzolása
     *
     * @param replicator Replikátor referencia
     */
    private void drawPlayer(Replicator replicator) {

        // Változók inicializálása
        CVector pos;
        JLabel label = new JLabel();
        ImageIcon img = null;
        pos = replicator.getPos();

        // Kép kiválasztása
        switch (pos.GetDir()) {
            case East:
                img = iconBuffer.get("ReplicatorRight");
                break;
            case North:
                img = iconBuffer.get("ReplicatorUp");
                break;
            case West:
                img = iconBuffer.get("ReplicatorLeft");
                break;
            case South:
                img = iconBuffer.get("ReplicatorDown");
                break;
        }

        // Grafika beállítása
        label.setIcon(img);
        label.setBounds(OBJECT_WIDTH * pos.GetX(), gamePanel.getHeight() - OBJECT_HEIGHT * (pos.GetY() + 1),
                OBJECT_WIDTH, OBJECT_HEIGHT);
        gamePanel.add(label);
    }

    /**
     * Ezredes kirajzolása
     *
     * @param colonel Ezredes referencia
     */
    private void drawPlayer(Colonel colonel) {

        // Változók inicializálása
        CVector pos;
        JLabel label = new JLabel();
        ImageIcon img = null;
        pos = colonel.getPos();

        // Kép kiválasztása
        switch (pos.GetDir()) {
            case East:
                img = iconBuffer.get("ColonelRight");
                break;
            case North:
                img = iconBuffer.get("ColonelUp");
                break;
            case West:
                img = iconBuffer.get("ColonelLeft");
                break;
            case South:
                img = iconBuffer.get("ColonelDown");
                break;
        }

        // Doboz beállítása
        if (colonel.hasBox()) {
            drawBox(pos, 1);
        }

        // Grafika beállítása
        label.setIcon(img);
        label.setBounds(OBJECT_WIDTH * pos.GetX(), gamePanel.getHeight() - OBJECT_HEIGHT * (pos.GetY() + 1),
                OBJECT_WIDTH, OBJECT_HEIGHT);
        gamePanel.add(label);
    }

    /**
     * Csillagkapu kirajzolása
     *
     * @param stargate Csillagkapu referencia
     */
    private void drawStarGate(StarGate stargate) {

        // Változók inicializálása
        JLabel label = new JLabel();
        ImageIcon img = null;
        CVector pos = stargate.GetPos();

        // Kép kiválasztása
        switch (stargate.getColor()) {
            case Yellow:
                switch (pos.GetDir()) {
                    case East:
                        img = iconBuffer.get("RightYellowGate");
                        break;
                    case North:
                        img = iconBuffer.get("UpYellowGate");
                        break;
                    case West:
                        img = iconBuffer.get("LeftYellowGate");
                        break;
                    case South:
                        img = iconBuffer.get("DownYellowGate");
                        break;
                }
                break;
            case Blue:
                switch (pos.GetDir()) {
                    case East:
                        img = iconBuffer.get("RightBlueGate");
                        break;
                    case North:
                        img = iconBuffer.get("UpBlueGate");
                        break;
                    case West:
                        img = iconBuffer.get("LeftBlueGate");
                        break;
                    case South:
                        img = iconBuffer.get("DownBlueGate");
                        break;
                }
                break;
            case Red:
                switch (pos.GetDir()) {
                    case East:
                        img = iconBuffer.get("RightRedGate");
                        break;
                    case North:
                        img = iconBuffer.get("UpRedGate");
                        break;
                    case West:
                        img = iconBuffer.get("LeftRedGate");
                        break;
                    case South:
                        img = iconBuffer.get("DownRedGate");
                        break;
                }
                break;
            case Green:
                switch (pos.GetDir()) {
                    case East:
                        img = iconBuffer.get("RightGreenGate");
                        break;
                    case North:
                        img = iconBuffer.get("UpGreenGate");
                        break;
                    case West:
                        img = iconBuffer.get("LeftGreenGate");
                        break;
                    case South:
                        img = iconBuffer.get("DownGreenGate");
                        break;
                }
                break;
        }

        // Grafika beállítása
        label.setIcon(img);
        label.setBounds(OBJECT_WIDTH * pos.GetX(), gamePanel.getHeight() - OBJECT_HEIGHT * (pos.GetY() + 1),
                OBJECT_WIDTH, OBJECT_HEIGHT);
        gamePanel.add(label);
    }

    /**
     * ZPM kirajzolása
     *
     * @param coord kirajzolandó ZPM koordinátái
     */
    private void drawZPM(Coordinate coord) {

        // Változó inicializálása
        JLabel label = new JLabel();

        // Kép kiválasztása
        ImageIcon img = iconBuffer.get("ZPM");

        // Grafika beállítása
        label.setIcon(img);
        label.setBounds(OBJECT_WIDTH * coord.GetX() + OBJECT_WIDTH / 4, gamePanel.getHeight() - OBJECT_HEIGHT * (coord.GetY() + 1),
                OBJECT_WIDTH, OBJECT_HEIGHT);
        gamePanel.add(label);
    }

    /**
     * Az összes ZPM modul felvétele esetén lefutó függvény
     */
    private void drawWin() {

        // Változó inicializálása
        JLabel label = new JLabel();

        // Kirajzolandó szöveg beállítása és pozicionálása
        label.setText("Winner");
        label.setBounds(0, 0, 100, 100);
        gamePanel.add(label);

        // Controller lecsatolása
        gamePanel.removeKeyListener(controller);

        // Automatikus replikátor léptetés leállítása
        if (replicatorTimer != null) {
            replicatorTimer.stop();
        }
    }

    /**
     * Valamelyik játékos halála után lefutó függvény (nem replikátor)
     */
    private void drawGameOver() {

        // Változó inicializálása
        JLabel label = new JLabel();

        // Kirajzolandó szöveg beállítása és pozicionálása
        label.setText("Game Over");
        label.setBounds(0, 0, 100, 100);
        gamePanel.add(label);

        // Controller lecsatolása
        gamePanel.removeKeyListener(controller);

        // Automatikus replikátor léptetés kikapcsolása
        if (replicatorTimer != null) {
            replicatorTimer.stop();
        }
    }

    /**
     * Az adattároló tartalmának vizualizálása
     */
    private void drawAll() {

        // Focus beállítása az ablakra
        jFrame.requestFocus();

        // Korábbi grafika törlése
        gamePanel.removeAll();

        // Játék végének ellenőrzése
        if (data.collectables.ZPMCount() == 0) {
            drawWin();
            gamePanel.repaint();
            return;
        } else if (data.Colonel.getPos() == null || (data.Jaffa != null && data.Jaffa.getPos() == null)) {
            drawGameOver();
            gamePanel.repaint();
            return;
        }

        // Végigiterálás az adattárolón
        for (int i = 0; i <= maxCoord.GetX(); i++) {
            for (int j = 0; j <= maxCoord.GetY(); j++) {

                // Változók inicializálása
                Coordinate coord = new Coordinate(i, j);
                FieldObject fo = data.fields.GetFieldObject(coord);
                CVector cv;

                // Játékosok kirajzolása
                cv = data.Colonel.getPos();
                if (coord.equals(cv)) {
                    drawPlayer((Colonel) data.Colonel);
                }

                if (data.Jaffa != null) {
                    cv = data.Jaffa.getPos();
                    if (coord.equals(cv)) {
                        drawPlayer((Jaffa) data.Jaffa);
                    }
                }
                if (data.Repli != null) {
                    cv = data.Repli.getPos();
                    if (cv == null) {
                        replicatorTimer.stop();
                    }
                    if (coord.equals(cv))
                        drawPlayer(data.Repli);
                }

                // Dobozok kirajzolása
                int boxes = data.boxes.isThereV2(coord);
                while (boxes > 0) {
                    drawBox(coord, boxes);
                    boxes--;
                }

                // Nyomólap kirajzolása
                boolean isThere = data.buttons.isThere(coord);
                if (isThere) {
                    drawButton(coord);
                }

                // Csillagkapu kirajzolása
                cv = new CVector(i, j, Direction.North);
                StarGate sg = data.stargates.getStarGate(cv);
                if (sg != null) {
                    drawStarGate(sg);
                    continue;
                }
                cv = new CVector(i, j, Direction.West);
                sg = data.stargates.getStarGate(cv);
                if (sg != null) {
                    drawStarGate(sg);
                    continue;
                }
                cv = new CVector(i, j, Direction.East);
                sg = data.stargates.getStarGate(cv);
                if (sg != null) {
                    drawStarGate(sg);
                    continue;
                }
                cv = new CVector(i, j, Direction.South);
                sg = data.stargates.getStarGate(cv);
                if (sg != null) {
                    drawStarGate(sg);
                    continue;
                }
                // ZPM kirajzolása
                isThere = data.collectables.isThere(coord);
                if (isThere) {
                    drawZPM(coord);
                }

                // Fieldobject kirajzolása
                if (fo != null) {
                    drawFieldObject(fo, coord);
                }
            }
        }

        // Képernyő frissítése
        gamePanel.repaint();
    }
}
