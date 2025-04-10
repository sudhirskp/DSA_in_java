package Tree;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class Student implements  Comparable<Student> {
    String name;
    int age;
    int roll_no;

    Student(String name, int age, int roll_no) {
        this.name = name;
        this.age = age;
        this.roll_no = roll_no;
    }

    @Override
    public int compareTo(Student that) {
        if(this.age == that.age){
            if(this.age == that.age){
                return this.name.compareTo(that.name); // lexigraphical order
            }
            return this.roll_no - that.roll_no; // ascending order
        }
        //sort on the basis fo the roll number
        return that.roll_no - this.roll_no; //descending order
    }

    public String toString() {
        //System.out.println(s.name + " " + s.age + " " + s.roll_no);
        return "Student " + this.name;
    }
}





public class Treemap {

    public static void main(String[] args) {
        TreeMap<Student,Integer> map = new TreeMap<>();

        map.put(new Student("Sudhir",18,62), 100);
        map.put(new Student("Rahul",19,63), 200);
        map.put(new Student("Raj",20,64), 300);


        Student ob = new Student("R",29,64);
        System.out.println(map.containsKey(ob));


        //System.out.println(map);

        for(Map.Entry<Student, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        //floorEntry for the value less than or equal to the given key
        //ceilingEntry for the value greater than or equal to the given key
        //lowerEntry for the value less than the given key
        //higherEntry for the value greater than the given key
        //firstEntry for the first entry
        //lastEntry for the last entry
        //pollFirstEntry for the first entry and remove it
        //pollLastEntry for the last entry and remove it
        //subMap for the range of the key
        //headMap for the range of the key less than the given key
        //tailMap for the range of the key greater than the given key
        //descendingMap for the reverse order of the map

    }
    
}