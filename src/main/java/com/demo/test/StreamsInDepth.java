package com.demo.test;

import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.kafka.common.protocol.types.Field;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Employee {
    Integer empId;
    String empName;
    Integer empManagerId;
}

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
class Student {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String departmentName;
    private int joinedYear;
    private String city;
    private int rank;
}

public class StreamsInDepth {

    public static void main (String[] a) {

        Employee employee1 = new Employee(1,"emp1", 2);
        Employee employee2 = new Employee(2,"man1", 3);
        Employee employee3 = new Employee(3,"man2", null);
        Employee employee4 = new Employee(4,"emp4", 3);
        Employee employee5 = new Employee(5,"emp5", 2);

        List<Employee> employeeList = Arrays.asList(employee1, employee2, employee3, employee4, employee5);

        Map<Integer, String> managerMap = employeeList.stream().collect(Collectors.toMap(Employee::getEmpId, Employee:: getEmpName));

        Set<String> managerNames = employeeList.stream()
                .map(Employee::getEmpManagerId)
                .filter(managerMap::containsKey)
                .map(managerMap::get)
                .collect(Collectors.toSet());

//        Set<String> managers = employeeList.stream()
//                .map(employee -> Optional.ofNullable(employee.getEmpManagerId())
//                        .flatMap(managerMap::get)
//                        .orElse(null))
//                .filter(Objects::nonNull)
//                .collect(Collectors.toSet());

        System.out.println(managerNames);

// New operation
        List<Student> studentList = Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));

// Find list of students whose first name starts with alphabet A
        List<Student> firstNameStudent = studentList.stream()
                .filter(t -> t.getFirstName().startsWith("A"))
                . toList();

// FirstName of the same list
        List<String> firstName = studentList.stream()
                .map(Student::getFirstName)
                .filter(name -> name.startsWith("A")).toList();

// Group Students with department
        Map<String, List<Student>> groupDept = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName));

// Total no. of student
        Long totalStudent = studentList.stream().count();

// MaxAge of Student
        Optional<Integer> maxStudentAge1 = studentList.stream()
                .map(Student::getAge).max(Integer::compareTo);
        OptionalLong maxStudentAge2 = studentList.stream()
                .mapToLong(Student::getAge).max();

// Find all Dept name
         List<String> deptNames = studentList.stream()
                 .map(Student::getDepartmentName).distinct().toList();
         Map<String, List<Student>> segDept = studentList.stream()
                 .collect(Collectors.groupingBy(Student::getDepartmentName));

// Find the count of student in each dept
        Map<String, Long> deptCount = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()));

// Find list of Students whose age is less than 30
        List<Student> ageFilterStudents = studentList.stream()
                .filter(t -> t.getAge() < 30).toList();

// Find the list of students whose rank is between 50 and 100
        List<Student> marksFilterStudents = studentList.stream()
                .filter(t -> t.getRank() > 50 && t.getRank() < 100).toList();

// Avg age of male and female
        Map<String, Double> avgAgeByGender = studentList.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingDouble(Student::getAge)));

// Find dept with maximum no. of students
        String maxDept = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Dept not found");

// Find students living in delhi and sort by names
        List<Student> delhiStudents = studentList.stream()
                .filter(t -> Objects.equals(t.getCity(), "Karnataka"))
                .sorted(Comparator.comparing(Student::getFirstName)).toList();

// Find avg rank in all dept
        Map<String, Double> avgRankDept = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.averagingDouble(Student::getRank)));

// Find highest rank in each Dept
        Map<String, Optional<Student>> highestRankDept = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.minBy(Comparator.comparing(Student::getRank))));

// Find the list of students and sort them by their rank
        List<Student> rankSortedStudents = studentList.stream()
                .sorted(Comparator.comparing(Student::getRank))
                .toList();

// Find second ranked student
        Optional<Student> secondStudent = studentList.stream()
                .sorted(Comparator.comparing(Student::getRank))
                .skip(1).findFirst();

    }
}
