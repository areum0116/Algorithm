import java.util.*;

class Student implements Comparable<Student> {
    private String name;
    private int korean;
    private int english;
    private int math;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.math = math;
        this.english = english;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student o) {
        if (this.korean != o.korean) {
            return o.korean - this.korean;
        } else {
            if (this.english != o.english) {
                return this.english - o.english;
            } else {
                if (this.math != o.math) {
                    return o.math - this.math;
                } else {
                    return this.name.compareTo(o.name);
                }
            }
        }
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(list);
        for (Student student : list) {
            System.out.println(student.getName());
        }
    }

}
