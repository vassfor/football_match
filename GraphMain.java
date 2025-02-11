//Επιχείρησα να πρoσθέσω γραφικά για πιο διαδραστικό αποτέλεσμα

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GraphMain extends JFrame{  //κλάση για γραφική αναπαράσταση της αναμέτρησης, επεκτείνει την JFrame
    static Image ball;
    static Image houseLogo;
    static Image guestLogo;

    GraphMain(String atitle){
        super(atitle);
    }

    public void paint(Graphics g){  //η μέθοδος paint της υπερκλάσης
        super.paint(g);

        //δημιουργία των γραφικών του γηπέδου
        g.setColor(new Color(0,220,80));
        g.fillRect(0, 60, getWidth(), getHeight());
        g.setColor(Color.WHITE);
        g.drawRect(20, 65, 760, 440);
        g.drawLine(400,65,400,505);
        g.drawOval(325, 200, 150, 150);
        g.drawRect(20, 165, 80, 200);
        g.drawRect(20, 220, 30, 90);
        g.drawArc(50,220,100,100, 90, -180);
        g.drawRect(700, 165, 80, 200);
        g.drawRect(750, 220, 30, 90);
        g.drawArc(650,220,100,100, 90, 180);

        //σχεδίαση εικόνων
        g.drawImage(ball, 365, 240, ball.getWidth(this) / 14, ball.getHeight(this) / 14, this);
        g.drawImage(houseLogo, 10, 225, houseLogo.getWidth(this) / 5, houseLogo.getHeight(this) / 5, this);
        g.drawImage(guestLogo, 720, 235, guestLogo.getWidth(this) / 21, guestLogo.getHeight(this) / 21, this);
    }

    public static void main(String[] args) {

        //δημιουργία 10 παικτών για την ομάδα των γηπεδούχων
        Player gkHouse = new Player(1, "STANKOVIC", 31 , "Τερματοφύλακας", 80);
        Player a1 = new Player(12, "ROTA\t", 25, "Αμυντικός", 55);
        Player a2 = new Player(21, "VIDA\t", 33, "Αμυντικός", 70);
        Player a3 = new Player(2, "MOUKOUDI", 19, "Αμυντικός", 87);
        Player a4 = new Player(28, "HAJISAFI", 32, "Αμυντικός", 72);
        Player a5 = new Player(4, "SZYMANSKI", 27, "Αμυντικός", 65);
        Player[] amyna1={a1, a2, a3, a4, a5}; //πίνακας με αμυντικούς

        Player e1 = new Player(19, "ELIASON\t", 27, "Επιθετικός", 55);
        Player e2 = new Player(13, "PINEDA\t", 26, "Επιθετικός", 70);
        Player e3 = new Player(8, "GARCIA\t", 27, "Επιθετικός", 87);
        Player e4 = new Player(10, "ZUBER\t", 31, "Επιθετικός", 72);
        Player e5 = new Player(7, "GARCINOVIC", 25, "Επιθετικός", 65);
        Player[] epithesi1={e1, e2, e3, e4, e5}; //πίνακας με επιθετικούς

        Team house = new Team("AEK", gkHouse, amyna1, epithesi1); //δημιουργία της ομάδας των γηπεδούχων

        //δημιουργία 10 παικτών για την ομάδα των φιλοξενούμενων
        Player gkGuest = new Player(42, "KOTARSKI", 22 , "Τερματοφύλακας", 77);
        Player A1 = new Player(55, "SOARES\t", 27, "Αμυντικός", 75);
        Player A2 = new Player(59, "KOULIERAKIS", 19, "Αμυντικός", 73);
        Player A3 = new Player(4, "INGASON\t", 29, "Αμυντικός", 70);
        Player A4 = new Player(23, "SASTRE\t", 25, "Αμυντικός", 85);
        Player A5 = new Player(22, "SCHWAB\t", 32, "Αμυντικός", 59);
        Player[] amyna2={A1, A2, A3, A4, A5};   //πίνακας με αμυντικούς

        Player E1 = new Player(8, "DOUGLAS\t", 25, "Επιθετικός", 77);
        Player E2 = new Player(14, "ZIVKOVIC", 26, "Επιθετικός", 81);
        Player E3 = new Player(65, "KONSTANTELIAS", 19, "Επιθετικός", 79);
        Player E4 = new Player(11, "TAISON\t", 34, "Επιθετικός", 59);
        Player E5 = new Player(71, "BRANDON\t", 27, "Επιθετικός", 54);
        Player[] epithesi2={E1, E2, E3, E4, E5};    //πίνακας με επιθετικούς

        Team guest = new Team("PAOK", gkGuest, amyna2, epithesi2);  //δημιουργία της ομάδας των φιλοξενούμενων

        Match TELIKOS = new Match(house, guest);    //δημιουργία αναμέτρησης με τις δύο ομάδες

        //εισαγωγή των 3 εικόνων, έλεγχος για exceptions
        try {
            ball = ImageIO.read(new File("ball.png"));
        } catch (IOException e) {
            System.out.println("Ball image not found");
        }

        try {
            houseLogo = ImageIO.read(new File("aek.png"));
        } catch (IOException e) {
            System.out.println("House logo image not found");
        }

        try {
            guestLogo = ImageIO.read(new File("paok.png"));
        } catch (IOException e) {
            System.out.println("Guest logo image not found");
        }

        //δημιουργία του κύριου frame του γραφικού
        GraphMain frame = new GraphMain("ΤΕΛΙΚΟΣ ΚΥΠΕΛΛΟΥ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 520);
        frame.setLayout(new FlowLayout());
        frame.setLocation(530,200);

        //δημιουργία του frame για τα στατιστικά - αποτελέσματα της αναμέτρησης
        GraphMain frame2 = new GraphMain("ΣΤΑΤΙΣΤΙΚΑ-ΑΠΟΤΕΛΕΣΜΑΤΑ");
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setSize(570, 800);

        JButton button1 = new JButton("PRINT DRAFT"); //κουμπί για την εκτύπωση των στοιχείων των 2 ομάδων πριν την αναμέτρηση
        JButton button2 = new JButton("START GAME!"); //κουμπί για την εκκίνηση
        button2.setBackground(Color.RED);       
        button2.setForeground(Color.WHITE);
        JButton button3 = new JButton("RESULTS");   //κουμπί για την εκτύπωση των αποτελεσμάτων
        JButton button4 = new JButton("BEST OFFENCE PLAYER");   //κουμπί για την εκτύπωση του καλύτερου επιθετικού
        JButton button5 = new JButton("WORST DEFENCE PLAYER");  //κουμπί για την εκτύπωση του χειρότερου αμυντικού
        JButton button6 = new JButton("RESTART");  //κουμπί για επανεκκίνηση
        button6.setBackground(Color.ORANGE);       
        button6.setForeground(Color.WHITE);
        //τα κουμπιά 2,3,4,5,6 δεν είναι εμφανή εξ αρχής στο γραφικό
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
        button5.setVisible(false);
        button6.setVisible(false);

        //προσθήκη των κουμπιών στο frame
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);

        //δημιουργία JTextArea οπου θα εκτυπώνεται το κείμενο
        JTextArea label = new JTextArea();
        label.setBackground(new Color(0,220,80));
        label.setForeground(Color.WHITE);
        frame2.add(label); //προσθήκη στο δεύτερο frame (με τα στατιστικά)
        

        ActionListener action1 = new ActionListener() { //ActionListener για το κουμπί1
            public void actionPerformed(ActionEvent e) { //η μέθοδος για το πατημα του κουμπιου
                String txt = TELIKOS.printDraft(); //χρήση της printDraft()
                label.setFont(new Font("Monospaced", Font.BOLD, 16));             
                label.setText("\n\n"+txt); //το κείμενο στο label
                label.setVisible(true);
                button1.setVisible(false);  //το κουμπί1 εξαφανίζεται
                button2.setVisible(true);   //το κουμπί2 εμφανίζεται (κουμπί εκκίνησης παιχνιδιού) 
            }
        };

        ActionListener action2 = new ActionListener() { //ActionListener για το κουμπί2
            public void actionPerformed(ActionEvent e) {
                String txt = TELIKOS.startGame();   //χρήση της startGame()
                label.setText("\n\n\n"+txt);
                label.setVisible(true);
                button2.setVisible(false); //το κουμπί2 εξαφανίζεται
                button3.setVisible(true);  //το κουμπί3 εμφανίζεται(κουμπί αποτελεσμάτων)
            }
        };

        ActionListener action3 = new ActionListener() { //ActionListener για το κουμπί3
            public void actionPerformed(ActionEvent e) {
                String txt = TELIKOS.printResults();    //χρήση της printResults()
                label.setText("\n\n\n\n\n\n\n\n"+txt);  //κεντράρισμα του κειμένου
                label.setFont(new Font("Monospaced", Font.BOLD, 20));
                label.setVisible(true);
                button4.setVisible(true);  //τα κουμπιά 4 (κουμπί Καλύτερου Επιθετικού),
                button5.setVisible(true);  // 5 (κουμπί Χειρότερου Αμυντικού)
                button6.setVisible(true);  //και 6 (κουμπί Επανεκκίνησης) εμφανίζονται
            }
        };

        ActionListener action4 = new ActionListener() { //ActionListener για το κουμπί4
            public void actionPerformed(ActionEvent e) {
                String txt = TELIKOS.printBestOffencePlayer(); //χρήση της printBestOffencePlayer()
                label.setText("\n\n\n\n\n\n\n\n"+txt);
                label.setVisible(true);                
            }
        };

        ActionListener action5 = new ActionListener() { //ActionListener για το κουμπί5
            public void actionPerformed(ActionEvent e) {
                String txt = TELIKOS.printWorstDefencePlayer();  //χρήση της printWorstDefencePlayer()
                label.setText("\n\n\n\n\n\n\n\n"+txt);
                label.setVisible(true);                
            }
        };

        ActionListener action6 = new ActionListener() { //ActionListener για το κουμπί6
            public void actionPerformed(ActionEvent e) {
                label.setFont(new Font("Monospaced", Font.BOLD, 30));
                label.setText("\n\n\n\n\n\n\n\n\t  NEW MATCH !");
                button1.setVisible(true);
                button3.setVisible(false);
                button4.setVisible(false);
                button5.setVisible(false);
                button6.setVisible(false);
            }
        };

        //ανάθεση των 6 ActionListeners στα 6 κουμπιά
        button1.addActionListener(action1);
        button2.addActionListener(action2);
        button3.addActionListener(action3);
        button4.addActionListener(action4);
        button5.addActionListener(action5);
        button6.addActionListener(action6);

        //εμφάνιση των 2 frame
        frame2.setVisible(true);
        frame.setVisible(true);
    }
}