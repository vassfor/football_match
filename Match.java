import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Iterator;

public class Match {    //μέθοδος "Αναμέτρηση" με ιδιότητες
    Team house;     //ομάδα γηπεδούχων
    Team guest;     //ομάδα φιλοξενούμενων
    int hScore = 0;  //σκορ γηπεδούχων
    int gScore = 0;  //σκορ φιλοξενούμενων

    HashMap<Player, Integer> forwGoals = new HashMap<>();   //HashMap που αποθηκεύει ζεύγη επιθετικών-γκολ
    HashMap<Player, Integer> defByPassed = new HashMap<>();   //HashMap που αποθηκεύει ζεύγη αμυντικών-φορών που προσπεράστηκαν

    public Match(Team house, Team guest) {  //μέθοδος δηημιουργός με παραμέτους
        this.house = house; //μηδενισμός του σκορ και για τις δυο ομάδες
        this.guest = guest;
        for(int i=0; i<5; i++){     //αρχικοποίηση των HashMaps επιθετικών και αμυντικών με μηδενικές τιμές
            forwGoals.put(house.forwards[i], 0);
            forwGoals.put(guest.forwards[i], 0);
            defByPassed.put(house.defenders[i], 0);
            defByPassed.put(guest.defenders[i], 0);       
        }
    }

    public String printDraft() { //μέθοδος που επιστρέφει τα στοιχεία της αναμέτρησης (τα στοιχεία των 2 ομάδων) πριν την έναρξη του αγώνα
        String s = "ΓΗΠΕΔΟΥΧΟΙ\n" + house + "\nΦΙΛΟΞΕΝΟΥΜΕΝΟΙ\n" + guest+"\n";
        return s;
    }

    public String offence(Team t1, Team t2) {   //μέθοδος "Επίθεση" που επιστρέφει το αποτέλεσμα σε μορφή String
        String s="";
        Random rand = new Random();
        int i1 = rand.nextInt(5);
        Player attacking = t1.forwards[i1];   //τυχαία επιλογή επιθετικού της πρώτης ομάδας (επιτιθέμενη)
        int i2 = rand.nextInt(5);
        Player defending = t2.defenders[i2];    //τυχαία επιλογή αμυντικού της δεύτερης ομάδας (αμυνόμενη)
        Player gk = t2.goalkeeper;      //ο τερματοφύλακας της αμυνόμενης ομάδας

        if (attacking.getAbility() > defending.getAbility()) {  //έλγχος αν η ικανότητα του επιθετικού υπερέχει της ικανότητας του αμυντικού
            
            int pre = defByPassed.get(defending);   //η προηγούμενη τιμή για τις φορές που προσπεράστηκε ο συγκενκριμένος αμυντικός
            defByPassed.put(defending, pre+1);      //αύξηση κατα 1

            if(attacking.getAbility() > gk.getAbility()){   //έλεγχος αν η ικανότητα του επιθετικού είναι μεγαλύτερη της ικανότητας του τερματοφύλακα
                s="\t>>ΓΚΟΛ για τον/την "+t1.getName()+"!!!\t("+attacking.getName()+")\n";  //γκολ για την ομαδα t1 από τον επιθετικό (attacking)
                
                int pre2 = forwGoals.get(attacking);    //προηγούμενη τιμή για τα γκολ του συγκεκριμένου επιθετικού
                forwGoals.put(attacking, pre2+1);       //αύξηση κατά 1

                if(t1.getName() == house.getName()){    //έλεγχος αν η t1 είναι η ομάδα των γηπεδούχων
                    hScore+=1;      //αύξηση κατα 1 του σκορ των γηπεδούχων
                }else{      //αλλιώς αυξάνεται το σκορ των φιλοξενούμενων
                    gScore+=1; 
                }
            } else {    //αν ο τερματοφύλακας υπερέχει σε ικανότητα του επιθετικού η επίθεση αποκρούεται
                s="\t>>Η επίθεση της ομάδας " + t1.getName() + " αποκρούστηκε!\n";
            }
        } else {    //αν ο αμυντικός υπερέχει σε ικανότητα του επιθετικού η επίθεση αποκρούεται
            s="\t>>Η επίθεση της ομάδας " + t1.getName() + " αποκρούστηκε!\n";
        }
        return s;   //επιστροφή του αποτελέσματος της επίθεσης
    }

    public String startGame() {     //μέθοδος "Εκκίνησης" του παιχνιδιού
        //μηδενισμός τιμών (για την περίπτωση που γίνεται ξανά κλήση της startGame για το ίδιο αντικέιμενο της Match)
        hScore=0;
        gScore=0;
        for (Map.Entry<Player, Integer> e : forwGoals.entrySet()) {
            e.setValue(0);
        }
        for (Map.Entry<Player, Integer> entry : defByPassed.entrySet()) {
            entry.setValue(0);
        }
  
        String s = "ΤΟ ΠΑΙΧΝΙΔΙ ΞΕΚΙΝΗΣΕ!\n";

        for(int i=0; i<2; i++) {    //η αναμέτρηση τρέχει σε 2 ημίχρονα
            s=s+"\nΗΜΙΧΡΟΝΟ: "+(i+1)+"ο\n";
            for(int j=0; j<10; j++) {   //σε κάθε ημίχρονο 10 επιθέσεις εναλλάξ για τις δύο ομάδες
                if(j%2==0) {    //για άρτιες τιμές του j επιτίθεται η ομάδα των γηπεδούχων
                    String of1 = offence(house, guest);
                    s=s+of1;
                }else{    //για περιττές τιμές του j επιτίθεται η ομάδα των φιλοξενούμενων
                    String of2 = offence(guest, house);
                    s=s+of2;
                }
            }
        }
        return s;   //επιστροφή των αποτελεσμάτων για κάθε ημίχρονο
    }

    public String printResults(){   //μέθοδος που επιστρέφει τα συγκεντρωτικά αποτελέσματα της αναμέτρησης

        String s = "\nΑΠΟΤΕΛΕΣΜΑΤΑ\n"+house.getName()+"\t"+guest.getName()+"\n"+hScore+"    -    "+gScore+"\n"; //συγκεντρωτικό αποτέλεσμα

        if(hScore > gScore) {   //έλεγχος αν το σκορ των γηπεδούχων είναι μεγαλύτερο του σκορ των φιλοξενούμενων
            s=s+"ΝΙΚΗΤΕΣ ΟΙ ΓΗΠΕΔΟΥΧΟΙ "+house.getName()+"!!!\n"; //νίκησαν οι γηπεδούχοι
        }else if(gScore > hScore){  //αν το σκορ των φιλοξενούμενων είναι μεγαλύτερο, νίκησαν οι φιλοξενούμενοι
            s=s+"ΝΙΚΗΤΕΣ ΟΙ ΦΙΛΟΞΕΝΟΥΜΕΝΟΙ "+guest.getName()+"!!!\n";
        }else{      //αλλιώς έχουμε ισοπαλία
            s=s+"ΙΣΟΠΑΛΙΑ!\n";
        }
        return s;   //επιστροφή των συγκεντρωτικών αποτελεσμάτων
    }

    public String printBestOffencePlayer() {    //μέθοδος "Καλύτερος Επιθετικός"
        ArrayList<Player> best = new ArrayList<>(); //αρχικοποίηση λίστας best forwards
        int maxVal = 0; //τα περισσότερα γκολ απο 1 παίκτη

        Iterator<Map.Entry<Player, Integer>> it = forwGoals.entrySet().iterator();  //δημιουργία iterator για να μπορούμε να διατρέξουμε τo HashMap forwGoals
        while (it.hasNext()) {      //για όσο υπάρχει επόμενος επιθετικός
            Map.Entry<Player, Integer> entry = it.next();
            if(entry.getValue() > maxVal){ //αν τα γκολ του παίκτη αυτής της επανάληψης είναι περισσότερα απο τα maxVal
                maxVal = entry.getValue();  //ενημέρωση της maxVal
                best.clear();               //καθαρισμός λίστας και προσθήκη του καλύτερου επιθετικού
                best.add(entry.getKey());
            } else if(entry.getValue() == maxVal){  //αν υπάρχει παίκτης με ίδιο αριθμό γκολ (έως τη συγκεκριμένη επανάληψη)
                best.add(entry.getKey());       //προστίθεται
            }
        }

        String s="";
        if(best.size()>1){  //αν υπάρχουν περισσότεροι απο 1 επιθετικοί με μεγιστο αριθμό γκολ
            s="\nΚΑΛΥΤΕΡΟΙ ΕΠΙΘΕΤΙΚΟΙ";
            for(int i=0; i<best.size();i++){
                s=s+"\nΑΡΙΘΜΟΣ: "+best.get(i).getJersey()+"\nΟΝΟΜΑ: "+best.get(i).getName()+"\nΗΛΙΚΙΑ: "+best.get(i).getAge()+"\nΙΚΑΝΟΤΗΤΑ: "+best.get(i).getAbility()+"\nΓΚΟΛ: "+maxVal+"\n";
            }
        } else {
            s="\nΚΑΛΥΤΕΡΟΣ ΕΠΙΘΕΤΙΚΟΣ\nΑΡΙΘΜΟΣ: "+best.get(0).getJersey()+"\nΟΝΟΜΑ: "+best.get(0).getName()+"\nΗΛΙΚΙΑ: "+best.get(0).getAge()+"\nΙΚΑΝΟΤΗΤΑ: "+best.get(0).getAbility()+"\nΓΚΟΛ: "+maxVal+"\n";
        }
        return s; //επιστροφή των στοιχείων του καλύτερου επιθετικού / καλύτερων επιθετικών
    }

    public String printWorstDefencePlayer() {    //μέθοδος "Χειρότερος Αμυντικός"
        ArrayList<Player> worst = new ArrayList<>(); //αρχικοποίηση λίστας worst defenders
        int maxVal = 0; //οι περισσότερες φορές που κάποιος αμυντικός προσπεράστηκε

        Iterator<Map.Entry<Player, Integer>> it = defByPassed.entrySet().iterator();  //δημιουργία iterator για να μπορούμε να διατρέξουμε τo HashMap defByPassed
        while (it.hasNext()) {      //για όσο υπάρχει επόμενως αμυντικός
            Map.Entry<Player, Integer> entry = it.next();
            if(entry.getValue() > maxVal){  //αν ο αμυντικός έχει προσπεραστεί περισσότερες φορές από το maxVal
                maxVal = entry.getValue();  //ενημέρωση του maxVal
                worst.clear();              //καθαρισμός λίστας και προσθήκη
                worst.add(entry.getKey());
            } else if(entry.getValue() == maxVal){  //αν υπάρχει και άλλος αμυντικός με την ίδια τιμή
                worst.add(entry.getKey());      //προστίθεται
            }
        }
        String s="";
        if(worst.size()>1){ //αν υπάρχουν περισσότεροι από 1 αμυντικοί με την μεγιστη τιμή
            s ="\nΧΕΙΡΟΤΕΡΟI ΑΜΥΝΤΙΚΟI";
            for(int i=0;i<worst.size();i++){
                s=s+"\nΑΡΙΘΜΟΣ: "+worst.get(i).getJersey()+"\nΟΝΟΜΑ: "+worst.get(i).getName()+"\nΗΛΙΚΙΑ: "+worst.get(i).getAge()+"\nΙΚΑΝΟΤΗΤΑ: "+worst.get(i).getAbility()+"\nΠΡΟΣΠΕΡΑΣΤΗΚΕ: "+maxVal+"\n";
            }
        } else {
            s ="\nΧΕΙΡΟΤΕΡΟΣ ΑΜΥΝΤΙΚΟΣ\nΑΡΙΘΜΟΣ: "+worst.get(0).getJersey()+"\nΟΝΟΜΑ: "+worst.get(0).getName()+"\nΗΛΙΚΙΑ: "+worst.get(0).getAge()+"\nΙΚΑΝΟΤΗΤΑ: "+worst.get(0).getAbility()+"\nΠΡΟΣΠΕΡΑΣΤΗΚΕ: "+maxVal+"\n";
        }
        return s;   //επιστροφή των στοιχείων του χειρότερου αμυντικού / χειρότερων αμυντικών
    }
}