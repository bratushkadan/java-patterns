package main.java.com.pracs.P1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.function.Function;

public class Main {
  private static class StudentClass implements Student {
    private String name;
    private String group;

    public StudentClass(String name, String group) {
      this.name = name;
      this.group = group;
    }

    public String getName() {
      return name;
    }

    public String getGroup() {
      return group;
    }

    public void setName(String name) {
      this.name = name;
    }

    public void setGroup(String group) {
      this.group = group;
    }
  }

  public static void main(String[] args) {
    List<Student> studentsList = new ArrayList<>();
    studentsList.add(new StudentClass("Dan", "IKBO-24-21"));
    studentsList.add(new StudentClass("Evgenia", "IKBO-06-21"));
    studentsList.add(new StudentClass("Arina", "IKBO-24-21"));
    studentsList.add(new StudentClass("Elizaveta", "IKBO-01-21"));
    studentsList.add(new StudentClass("Alexander", "IKBO-01-21"));
    studentsList.add(new StudentClass("Egor", "IKBO-24-21"));
    studentsList.add(new StudentClass("Dmitry", "IKBO-31-21"));

    Function<List<Student>, Map<String, List<Student>>> fn = (students) -> {
      Map<String, List<Student>> studentsMap = new HashMap<>();

      for (Student student : students) {
        List<Student> groupStudents = studentsMap.get(student.getGroup());

        if (groupStudents == null) {
          groupStudents = new ArrayList<Student>();
          studentsMap.put(student.getGroup(), groupStudents);
        }

        groupStudents.add(student);
      }

      return studentsMap;
    };

    for (Map.Entry<String, List<Student>> entry : fn.apply(studentsList).entrySet()) {
      System.out.printf("Group %s\n", entry.getKey());
      for (Student st : entry.getValue()) {
        System.out.printf("--- Student: %s\n", st.getName());
      }
    }
  }
}
