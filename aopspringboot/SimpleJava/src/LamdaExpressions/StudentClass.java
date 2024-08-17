package LamdaExpressions;

public class StudentClass implements Comparable<StudentClass>{
    String name;
    int rollNumber;

    public StudentClass(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                '}';
    }

    @Override
    public int compareTo(StudentClass that) {
        if(this.name.length()> that.name.length())
            return 1;
        else
            return -1;
    }
}
