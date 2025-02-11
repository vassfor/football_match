public class Player {       //κλάση "Παίκτης" για αντικείμενα με ιδιότητες
    private int jersey;     //αριθμός φανέλας
    private String name;    //όνομα
    private int age;        //ηλικία
    private String position;    //θέση
    private int ability;    //ικανότητα

    public Player(int jersey, String name, int age, String position, int ability) {     //μέθοδος δημιουργός με παραμέτρους
        this.jersey = jersey;
        this.name = name;
        this.age = age;
        this.position = position;
        this.ability = ability;
    }

    public Player() {   //μέθοδος δημιουργός χωρίς παραμέτρους
        this.jersey = -1;
        this.name = "";
        this.age = -1;
        this.position = "";
        this.ability = -1;
    }

    public int getJersey() {   //μέθοδος που επιστρέφει τον αριθμό φανέλας του παίκτη
        return jersey;
    }

    public String getName() {   //μέθοδος που επιστρέφει το όνομα του παίκτη
        return name;
    }

    public int getAge() {   //μέθοδος που επιστρέφει την ηλικία του παίκτη
        return age;
    }
    public String getPosition() {   //μέθοδος που επιστρέφει τη θέση του παίκτη
        return position;
    }

    public int getAbility() {   //μέθοδος που επιστρέφει την ικανότητα του παίκτη
        return ability;
    }

    public String toString() {   //μέθοδος που επιστρέφει όλα τα στοιχεία του παίκτη στη σειρά
        String s = jersey+"\t"+name+"\t"+age+"\t"+position+"\t"+ability;
        return s;
    }
}