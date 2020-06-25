package June12.hospitalQueue;

//Utwórz klasę HospitalQueue, która
//               a ma pole typu Queue (patientQueue)
//               b utwórz metodę add(Patient) -> dodaje pacjenta
//               c utwórz metodę Patient next() -> zwracającą kolejną osobę z kolejki i usuwającą ją z niej
//               d Patient peek() -> podglądającą kto jest (zwraca kolejną osobę bez usuwania jej z kolejki)

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HospitalQueue_Surname {
    Queue<Patient> patientQueue;



    int length = 0;
    int MaxLength = 20;
    int head = 0;
    int tail = 0;

    public HospitalQueue_Surname() {
        this.patientQueue = new PriorityQueue<>(20, emergencyComparator);
    }

    public void add(Patient patient) {
        if (patientQueue.size() < 20){
            patientQueue.offer(patient);
            length++;
        }

    }

    Comparator<Patient> emergencyComparator = new Comparator<Patient>() {
        @Override
        public int compare(Patient patient1, Patient patient2) {
            if (patient1.getSurname().equalsIgnoreCase("Kowalski")){
                return -1;
            }
            return 0;
        }
    }; // ;? why?

    public Patient peek() {
        return patientQueue.peek();
    }

    public Patient next() {
        length--;
        return patientQueue.remove();
    }
}
