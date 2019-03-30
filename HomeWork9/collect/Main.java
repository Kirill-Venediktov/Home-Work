package HomeWork7.collect;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> personList = PersonGenerator.generate(10);

        for (Person person : personList){
            System.out.println(person);
        }
        System.out.println("");

        Comparator<Person> comparator1 = new NameComparator();
        Collections.sort(personList, comparator1);

        for (Person person : personList){
            System.out.println(person);
        }
        System.out.println("");

        Comparator<Person> comparator2 = new NameComparator().thenComparing(new SalaryComparator());
        Collections.sort(personList, comparator2);

        for (Person person : personList) {
            System.out.println(person);
        }

        System.out.println("3");

        Comparator<Person> comparator3 = new NameComparator().thenComparing(new SalaryComparator()).thenComparing(new AgeComparator()).thenComparing(new CompanyComparator());
        Collections.sort(personList, comparator3);

        for (Person person : personList) {
            System.out.println(person);
        }

    }

}
