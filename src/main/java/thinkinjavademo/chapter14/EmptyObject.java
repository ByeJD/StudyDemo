package thinkinjavademo.chapter14;

import java.util.ArrayList;

/**
 * @author Quan
 * @date 2017/9/20
 * @desciption
 */

interface Null{}
class Person{
    public final String first;
    public final String last;
    public final String address;

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class NullPerson extends Person implements Null{

        public NullPerson() {
            super("none", "none", "none");
        }

        @Override
        public String toString() {
            return "NullPerson";
        }
    }

    // 通常情况下，空对象都是单例的，你可以使用instanceof来探测泛化的null还是具体的NullPerson，由于使用了单例模式，所以你
    // 还可以使用equals()甚至==来比较Person.NULL
    public static final Person NULL = new NullPerson();
}


class Position{
    public Position(String title) {
        this.title = title;
        this.person = Person.NULL;
    }

    private String title;
    private Person person;

    @Override
    public String toString() {
        return "Position{" +
                "title='" + title + '\'' +
                ", person=" + person +
                '}';
    }

    public Position(String title, Person employee) {
        this.title = title;
        this.person = employee;
        if(person == null){
            this.person = Person.NULL;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person newPerson) {
        this.person = newPerson;
        if(this.person == null){
            this.person = Person.NULL;
        }
    }
}
public class EmptyObject extends ArrayList<Position>{

    public void add(String title,Person person) {
        add(new Position(title,person));
    }

    public void add(String... titles){
        for(String title : titles){
            add(new Position(title));
        }
    }
    public EmptyObject(String... titles){
        add(titles);
    }

    public boolean positionAvailable(String title){
        for (Position position : this){
            if(position.getTitle().equals(title) && position.getPerson() == Person.NULL){
                return true;
            }
        }
        return false;
    }

    public void fillPosition(String title,Person hire){
        for (Position position : this){
            if(position.getTitle().equals(title) && position.getPerson() == Person.NULL){
                position.setPerson(hire);
                return;
            }

        }
        throw new RuntimeException("Position " + title + " not avaiable");
    }

    // 在某些地方仍然需要测试空对象，这和检查null对象没有差异，但是在其他地方，如toString() 地方就不必检查是否为空对象了
    // 我们知道System.out.println(emptyObject);就是调用了emptyObject的toString()方法。
    public static void main(String[] args) {
        EmptyObject emptyObject = new EmptyObject("President","CTO","Marketing Manager","Product Manager","Project Lead","Software Engineer","Software Engineer","Software Engineer",
                "Test Engineer");
        emptyObject.fillPosition("President",new Person("Me","Last","The Top, Lonely At"));
        emptyObject.fillPosition("Project Lead",new Person("A","B","C"));

        if(emptyObject.positionAvailable("Software Engineer")){
            emptyObject.fillPosition("Software Engineer",new Person("Bob","Coder","Bright Light City"));
        }
        System.out.println(emptyObject);
    }
}
