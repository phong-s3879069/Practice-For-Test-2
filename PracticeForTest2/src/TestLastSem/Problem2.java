package TestLastSem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static void main(String[] args) {
        String[] people = {"s01", "s02", "s03","s04","s05","s06","s07","s08", "s09", "s10"};
        String[] recoveredPeople = {"s03", "s06", "s09"};
        String[] oneDosePeople = {"s02", "s04", "s06"};
        String[] anotherDosePeople = {"s08", "s06", "s10"};

        Campus campus = new Campus();
        campus.plan(people, recoveredPeople, oneDosePeople, anotherDosePeople);
        System.out.println(campus.countEligible());
        System.out.println(campus.isEligible("s09"));
    }
}

class Person{
    String id;

    boolean recovered;

    int numDoses;

    public Person(String id, boolean recovered, int numDoses) {
        this.id = id;
        this.recovered = recovered;
        this.numDoses = numDoses;
    }
}

class Campus {
    ArrayList<Person> people;

    public Campus() {
        people = new ArrayList<Person>();
    }

    public void plan(String[] people, String[] recoveredPeople, String[] oneDosePeople, String[] anotherDosePeople) {
        List<String> recoveredList = Arrays.asList(recoveredPeople);
        List<String> oneDose = Arrays.asList(oneDosePeople);
        List<String> anotherDose = Arrays.asList(anotherDosePeople);
        for (String people_id : people) {
            boolean recovered = false;
            int numDoses = 0;
            if(recoveredList.contains(people_id)) {
                recovered = true;
            }
            if(oneDose.contains(people_id)) {
                numDoses += 1;
            }
            if(anotherDose.contains(people_id)) {
                numDoses += 1;
            }
            Person person = new Person(people_id, recovered, numDoses);
            this.people.add(person);
        }
    }

    public boolean isEligible(String id) {
        boolean isEligible = false;
        for(Person person : people) {
            if(person.id.equals(id)) {
                if(person.recovered) {
                    isEligible = true;
                }
                else if(person.numDoses == 2) {
                    isEligible = true;
                }
            }
        }
        return isEligible;
    }

    public int countEligible(){
        int count = 0;
        for(Person person : people) {
            if(person.recovered) {
                count += 1;
            }
            else if(person.numDoses == 2) {
                count += 1;
            }
        }
        return count;
    }


}

