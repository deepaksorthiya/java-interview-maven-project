package com.example.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StudentWithMaxMarks {

    public static final String MATHS = "MATHS";

    public static void main(String[] args) {

        Student s1 = new Student(1, "JOHN",
                getSubject(70, 75, 72));
        Student s2 = new Student(2, "MARK", getSubject(78, 80, 60));
        Student s3 = new Student(3, "WILL", getSubject(90, 88, 91));
        Student s4 = new Student(4, "DANIEL", getSubject(78, 58, 60));
        Student s5 = new Student(4, "DANIEL", new ArrayList<>());

        List<Student> students = List.of(s1, s2, s3, s4, s5);

        //LinkedHashMap<String, IntSummaryStatistics> map = students.stream().collect(Collectors.groupingBy(s -> s.name, LinkedHashMap::new, Collectors.flatMapping(s -> s.subjects.stream(), Collectors.summarizingInt(s -> s.mark))));
        LinkedHashMap<String, List<Student>> map = students.stream().filter(s -> s.subjects.stream().anyMatch(sub -> sub.name.equals(MATHS))).collect(Collectors.groupingBy(s -> s.name, LinkedHashMap::new, Collectors.toList()));
        String max = students.stream().distinct()
                .max(Comparator.comparingInt(student -> student.subjects.stream()
                        .filter(subj -> MATHS.equalsIgnoreCase(subj.name())).findFirst().orElse(new Subject(0, null, 0))
                        .mark()))
                .map(Student::name).get();
        printMap(map);
        System.out.println(max);

        int mark = s5.subjects.stream()
                .filter(subj -> MATHS.equalsIgnoreCase(subj.name())).findFirst().orElse(new Subject(0, null, 0))
                .mark();
        System.out.println(mark);
    }

    private static void printMap(Map<?, ?> map) {
        System.out.println("#########################################");
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " :::: " + entry.getValue());
        }
        System.out.println("#########################################");
    }

    private static List<Subject> getSubject(int mm, int pm, int cm) {
        return List.of(
                new Subject(1, MATHS, mm),
                new Subject(2, "PHYSICS", pm),
                new Subject(3, "CHEMISTRY", cm)
        );
    }

    private record Student(int studentId, String name, List<Subject> subjects) {
        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", studentId=" + studentId +
                    '}';
        }
    }

    private record Subject(int subjectId, String name, int mark) {

        @Override
        public String toString() {
            return "Subject{" +
                    "subjectId=" + subjectId +
                    ", name='" + name + '\'' +
                    ", mark=" + mark +
                    '}';
        }
    }
}
