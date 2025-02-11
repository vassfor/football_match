public class Main { //κλάση με τη μέθοδο main
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

        System.out.println(TELIKOS.printDraft());
        System.out.println(TELIKOS.startGame());
        System.out.println(TELIKOS.printResults());
        System.out.println(TELIKOS.printBestOffencePlayer());
        System.out.println(TELIKOS.printWorstDefencePlayer());
    }
}