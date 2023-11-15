import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 국영수
public class BOJ_10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            students[i] = new Student(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]));
        }

        Arrays.sort(students);

        for(Student student : students) {
            System.out.println(student.name);
        }
    }
}

class Student implements Comparable<Student> {
    String name;
    int kor, eng, math;

    Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Student o) {
        if(this.kor == o.kor && this.eng == o.eng && this.math == o.math) {
            return this.name.compareTo(o.name);
        }
        if(this.kor == o.kor && this.eng == o.eng) {
            return Integer.compare(o.math, this.math);
        }
        if(this.kor == o.kor) {
            return Integer.compare(this.eng, o.eng);
        }
        return Integer.compare(o.kor, this.kor);
    }
}
