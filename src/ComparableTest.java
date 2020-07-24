import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Person implements Comparable<Person> {
    //Comparable - интерфейс для сортировки объектов по средствам переопределенного метода compareTo
    int age;
        public Person(int age) {
            this.age = age;
        }
        @Override
        public int compareTo(Person person) {
            return this.age - person.age;
        }
        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    '}';
        }
    }


class main {
    public static void main(String args[]) {
        Set set = new TreeSet();
        set.add(new Person(7));
        set.add(new Person(6));
        for(Object o: set){
            System.out.println(o);
        }
    }
}




class Person2 {
    //Comparable - интерфейс для сортировки объектов по средствам переопределенного метода compareTo
    int age;

    public Person2(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
//Если нет доступа к классу который нужно имплементировать то следует применять Comparator и создать класс стыковки

class ComparePerson implements Comparator<Person2> {
    @Override
   public int compare(Person2 o1, Person2 o2){
        return o1.age - o2.age;
    }
}
class main2 {
    public static void main(String args[]) {
        ComparePerson comparePerson = new ComparePerson();
        Set set = new TreeSet(comparePerson);
        set.add(new Person2(7));
        set.add(new Person2(6));
        for(Object o: set){
            System.out.println(o);
        }
    }
}


