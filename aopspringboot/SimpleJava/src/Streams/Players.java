package Streams;

public class Players {
    private String Name;
    private int age;
    private int score ;

    public Players(String name, int age, int score) {
        Name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Players{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

}
