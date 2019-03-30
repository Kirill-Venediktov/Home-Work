package HomeWork7.collect;

import java.util.*;

enum Name {
//    Иван, Семен, Василий, Александр, Константин, Кирилл, Светлана, Юрий, Андрей, Антон, Анастасия, Екатерина,
//    Сергей, Геннадий, Нина, Ольга, Тамара, Алексей, Павел, Софья, Дмитрий, Мария, Марта, Елена, Виктория, Станислав;

    Max, Dan, Ivan, Court, Daniel, Chris, Jill, Barry, Rebecca, Albert, Ada, Leon, Clare, Markus, Gale, Rick, Dylan, Harry,
    James,Cheryl, Liza, Cybil, Michaell;

    public static Name getName(int ord) {
        for (Name name : values()) {
            if (ord == name.ordinal()){
                return name;
            }
        }
        throw new AssertionError("Wrong ordinal: " + ord);
    }
}

enum Company {
    Microsoft, Google, Apple, Газпром, McDonalds, Яндекс, IBM, Аэрофлот, НорНикель, BurgerKing, KFC, Samsung, Sony,
    AnalogDevices, NationalInstruments, Altera, TexasInstruments, АвтоВАЗ, ГАЗ, УАЗ, Hyundai, Kia;

    public static Company getCompany(int ord) {
        for (Company company : values()) {
            if (ord == company.ordinal()) {
                return company;
            }
        }
        throw new AssertionError("Wrong ordinal: " + ord);
    }
}

public class Person {
    private Name name;
    private int age;
    private int salary;
    private Company company;

    public Person(Name name, int age, int salary, Company company) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.company = company;
    }

    public Name getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name= '" + name + '\'' +
                ", age= " + age +
                ", salary= " + salary +
                ", company= '" + company + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() &&
                getSalary() == person.getSalary() &&
                getName() == person.getName() &&
                getCompany() == person.getCompany();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getSalary(), getCompany());
    }
}

class PersonGenerator {
    public static List<Person> generate(int num) {
        if (num <= 0) {
            return Collections.emptyList();
        }
        Random random = new Random();
        List<Person> person = new ArrayList<>();
        int nameCount = Name.values().length;
        int companyCount = Company.values().length;
        int ageMin = 16;
        int ageMax = 80;
        int salaryMin = 10000;
        int salaryMax = 500000;
        for (int i = 0; i < num; i++) {
            person.add(new Person(Name.getName(random.nextInt(nameCount)),
                    (random.nextInt(ageMax - ageMin+ 1) + ageMin),
                    (random.nextInt(salaryMax - salaryMin + 1) + salaryMin),
                    Company.getCompany(random.nextInt(companyCount))));
        }
        return person;
    }
}

class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {


        if(o1.getAge()> o2.getAge())
            return 1;
        else if(o1.getAge()< o2.getAge())
            return -1;
        else
            return 0;
//        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

class SalaryComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getSalary()> o2.getSalary())
        return 1;
        else if(o1.getSalary()< o2.getSalary())
            return -1;
        else
            return 0;

//        return Integer.compare(o1.getSalary(), o2.getSalary());
    }
}

class CompanyComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getCompany().compareTo(o2.getCompany());
    }
}



