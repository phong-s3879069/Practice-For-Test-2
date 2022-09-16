package SampleTest;

public class Problem1 {
    public static void main(String[] args) throws InvalidVaccineTypeException {
        Person p1 = new Person("Phong 1", 16);
        Person p2 = new Person("Phong 2", 25);
        Person p3 = new Person("Phong 3", 50);
        Person p4 = new Person("Phong 4", 70);

        TypeA a = new TypeA("a", 10);
        TypeB b = new TypeB("b", 10);
        TypeC c = new TypeC("c", 10);
        TypeD d = new TypeD("d", 10);

        p1.getVaccine(a);
        p2.getVaccine(b);
        p3.getVaccine(c);
        p4.getVaccine(d);


    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void getVaccine(Vaccine v) throws InvalidVaccineTypeException {
        if(age < 18) {
            if (v instanceof UsedByYoung) {
                if(v.isTwoDoses()){
                    System.out.println(name + ", you will get the second dose after " + v.daysBetween() + "days");
                } else {
                    System.out.println(name + ", you need only one dose");
                }
            }
            else {
                throw new InvalidVaccineTypeException("Vaccine is not suitable");
            }
        }
        else if(age > 65) {
            if (v instanceof UsedByElderly) {
                if(v.isTwoDoses()){
                    System.out.println(name + ", you will get the second dose after " + v.daysBetween() + "days");
                } else {
                    System.out.println(name + ", you need only one dose");
                }
            }
            else {
                throw new InvalidVaccineTypeException("Vaccine is not suitable");
            }
        }
        else {
            if(v.isTwoDoses()){
                System.out.println(name + ", you will get the second dose after " + v.daysBetween() + "days");
            } else {
                System.out.println(name + ", you need only one dose");
            }
        }

    }
}

abstract class Vaccine {
    String name;
    double amount;

    public Vaccine(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    abstract public boolean isTwoDoses();

    abstract public int daysBetween();
}

class TypeA extends Vaccine implements UsedByYoung {
    public TypeA(String name, double amount) {
        super(name, amount);
    }

    @Override
    public boolean isTwoDoses() {
        return true;
    }

    @Override
    public int daysBetween() {
        return 20;
    }

    @Override
    public String procedureForTheYoung() {
        return this.name + "is OK for the Young";
    }
}

class TypeB extends Vaccine implements UsedByElderly{
    public TypeB(String name, double amount) {
        super(name, amount);
    }

    @Override
    public boolean isTwoDoses() {
        return true;
    }

    @Override
    public int daysBetween() {
        return 30;
    }

    @Override
    public String procedureForTheElderly() {
        return this.name + "is OK for the Elderly";
    }
}

class TypeC extends Vaccine implements UsedByYoung{
    public TypeC(String name, double amount) {
        super(name, amount);
    }

    @Override
    public boolean isTwoDoses() {
        return false;
    }

    @Override
    public int daysBetween() {
        return 0;
    }

    @Override
    public String procedureForTheYoung() {
        return this.name + "is Ok for the Young";
    }
}
class TypeD extends Vaccine implements UsedByElderly{
    public TypeD(String name, double amount) {
        super(name, amount);
    }

    @Override
    public boolean isTwoDoses() {
        return false;
    }

    @Override
    public int daysBetween() {
        return 0;
    }

    @Override
    public String procedureForTheElderly() {
        return this.name + "is OK for the Elderly";
    }
}

interface UsedByYoung {
    public String procedureForTheYoung();
}

interface UsedByElderly {
    public String procedureForTheElderly();
}

class InvalidVaccineTypeException extends Exception{
    public InvalidVaccineTypeException(String str){super(str);}
}
