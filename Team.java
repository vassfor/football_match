public class Team {     //κλάση "Ομάδα" για αντικείμενα με ιδιότητες
    private String name;    //όνομα ομάδας
    public Player goalkeeper;   //τερματοφύλακας ομάδας
    public Player[] defenders = new Player[5];  //πίνακας με τους αμυντικούς της ομάδας
    public Player[] forwards = new Player[5];   //πίνακας με τους επιθετικούς της ομάδας

    public Team (String name, Player goalkeeper, Player[] defenders, Player[] forwards) {   //μέθοδος δημιουργός με παραμέτρους
        setName(name);      //κλήση της μεθόδου setName με παράμετρο το name
        setGoalkeeper(goalkeeper);  //κλήση της μεθόδου setGoalkeeper με παράμετρο το goalkeeper
        setDefenders(defenders);    //κλήση της μεθόδου setDefenders με παράμετρο defenders (πίνακας με αντικέιμενα τύπου Player)
        setForwards(forwards);      //κλήση της μεθόδου setForwards με παράμετρο forwards (πίνακας με αντικείμενα τύπου Player)
    }

    public void setName(String teamName) {  //μέθοδος που θέτει το teamName ως όνομα της ομάδας
        this.name = teamName;
    }

    public void setGoalkeeper(Player gk) {  //μέθοδος που θέτει το gk ως goalkeeper της ομάδας
        if(gk.getPosition() != "Τερματοφύλακας") {  //έλεγχος αν ο παίκτης που δίνεται ως παράμετρος έχει σωστή θέση 'Τερματοφύλακας'
            System.out.println("Αυτός ο παίκτης δεν είναι τερματοφύλακας!");    //αν δεν είναι τερματοφύλακας εμφανίζεται προειδοποιητικό μήνυμα
            this.goalkeeper = new Player();     //και ο παίκτης αρχικοποιείται χωρίς παραμέτρους
            return;
        }
        this.goalkeeper = gk;
    }

    public void setDefenders(Player[] def) {    //μέθοδος που θέτει τα στοιχεία του πίνακα def ως defenders της ομάδας
        for(int i=0; i<5; i++) {        //για κάθε παίκτη (στοιχείο του πίνακα που δίνεται ως παράμετρος)
            if(def[i].getPosition() != "Αμυντικός") {   //έλεγχος αν ο παίκτης έχει σωστή θέση 'Αμυντικός'
                System.out.println("Ο παίκτης " + i + " δεν είναι αμυντικός!");     //αν δεν είναι αμυντικός εμφανίζεται προειδοποιητικό μήνυμα
                this.defenders[i] = new Player();   //και ο παίκτης αρχικοποιείται χωρίς παραμέτρους
                continue;
            }
            this.defenders[i] = def[i];
        }
    }

    public void setForwards(Player[] forw) {        //μέθοδος που θέτει τα στοιχεία του πίνακα forw ως forwards της ομάδας
        for(int i=0; i<5; i++) {        //για κάθε παίκτη (στοιχείο του πίνακα που δίνεται ως παράμετρος)
            if(forw[i].getPosition() != "Επιθετικός") {     //έλεγχος αν ο παίκτης έχει σωστή θέση 'Επιθετικός'
                System.out.println("Αυτός ο παίκτης δεν είναι επιθετικός!");       //αν δεν είναι επιθετικός εμφανίζεται προειδοποιητικό μήνυμα
                this.forwards[i] = new Player();   //και ο παίκτης αρχικοποιείται χωρίς παραμέτρους
                continue;
            }
            this.forwards[i] = forw[i];
        }
    }

    public String getName() {   //μέθοδος που επιστρέφει το όνομα της ομάδας
        return name;
    }

    public String toString() {    //μέθοδος που επιστρέφει όλα τα στοιχεία της ομάδας σε μορφή πίνακα
        String d="", f="";
        for(int i=0; i<5; i++) {
            d=d+defenders[i].toString()+"\n";
            f=f+forwards[i].toString()+"\n";
        }
        String s="ΟΜΑΔΑ: "+name+"\nΑΡ.\tΟΝΟΜΑ\t\tΗΛΙΚΙΑ\tΘΕΣΗ\t\tΙΚΑΝΟΤΗΤΑ\n"+goalkeeper+"\n"+d+f;
        return s;
    }
}