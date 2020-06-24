package June12.hospitalQueue;

import java.util.Random;

//Utwórz klasę Patient mającą pola:
//                * imie (String)
//                * nazwisko (String)
//                * jakBardzoZly (int) - opisuje poziom zlosci
//                * rozpoznanaChoroba (String)
//                * pamietaj o angielskich nazwach, konstruktorze, getterach i setterach jesli potrzebujesz
public class Patient {
    private String name;
    private String surname;
    private int howBad;
    private String diagnosis;

    private String[] namesArray = new String[]{"Jan", "Janina", "Henryk", "Maria", "Marian", "Jerzy", "Mariola", "Andrzej", "Daria"
    , "Dariusz", "Cezary"};
    private String[] surnamesArray = new String[]{"Kowalski", "Nowak", "Kołodziejczyk", "Wiśniewski", "Wójcik", "Kowalczyk",
    "Krawczyk", "Schubert", "Jędrzejczak"};
    private String[] sicknessArray = new String[]{"Getting Down with the sickness", "Sick and Tired", "Leprosis", "Alergy",
    "Lack of (good) taste", "Lactose intolerance", "Fracture of moral spine", "Split personality", "Cough", "Insomnia"};

    public Patient() {
    }

    public Patient(String name, String surname, int howBad, String diagnosis) {
        this.name = name;
        this.surname = surname;
        this.howBad = howBad;
        this.diagnosis = diagnosis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int gethowBad() {
        return howBad;
    }

    public void sethowBad(int howBad) {
        this.howBad = howBad;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "Patient(" + name + '\''  + surname + '\'' +
                ", howBad=" + howBad +
                ", diagnoza='" + diagnosis + '\'' +
                ')';
    }

    public int compareEmergency(Patient patient2) {
        if (this.howBad > patient2.howBad) {
            return -1;
        }
        if (this.howBad < patient2.howBad){
            return 1;
        }

            return 0;
    }

    public  Patient createRandom(){
        int nameRandom = new Random().nextInt(namesArray.length);
        int surnameRandom = new Random().nextInt(surnamesArray.length);
        int sicknessRandom = new Random().nextInt(sicknessArray.length);
        int howBadRandom = new Random().nextInt(10);
       return new Patient(namesArray[nameRandom], surnamesArray[surnameRandom], howBadRandom,sicknessArray[sicknessRandom]);


    }
}
