package com.shivaprasadgurram.streamapi;

import java.util.*; // Please avoid doing like this production
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiMain {
    public static void main(String[] args) {

        // Input 1
        List<Integer> input1 = Arrays.asList(10,15,8,49,25,98,32, 98, 32, 15);

        // Input 2
        List<Note> noteLst = prepareNotes();

        // Input 3
        List<String> input3_1 = List.of("Java", "C");
        List<String> input3_2 = List.of("Python", "GoLang", "Rust");

        // Input 4
        List<Integer> input4 = Arrays.asList(1,7,8,9,5,2,36,4,78,222,24,9);

        // Input 5
        List<Employee> employeeList = prepareEmployees();

        // 1. Given an input of integers, find out all the even numbers
        List<Integer> evenNumbers = getAllEvenNumbers(input1);
        System.out.println("Even Numbers: " + evenNumbers);

        // When numbers are given as Array int[] arr = {10,15,8,49,25,98,32};
        int[] arr = {10,15,8,49,25,98,32};
        Stream<Integer> list1 = Arrays.stream(arr).boxed();
        list1.filter(n -> n % 2 == 0).forEach(System.out::println);

        // 2. Given an input of integers, find out all the numbers starting with 1
        List<Integer> startsWith1FirstApproach = getNumbersStartingWithGivenNumber(input1, 1);
        System.out.println("Starts with 1 -> first approach: " + startsWith1FirstApproach);

        // second approach
        List<Integer> startsWith1SecondApproach = getNumbersStartingWithGivenNumSecondApproach(input1, 1);

        System.out.println("Starts with 1 -> second approach: " + startsWith1SecondApproach);

        // 3. find duplicate elements in a given integers input1
        Set<Integer> duplicates = new HashSet<>();
        List<Integer> duplicateElements = getDuplicateElements(input1, duplicates);
        System.out.println("Duplicate elements: " + duplicateElements);

        // Using entry set
        List<Integer> dups = input1.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("Using Grouping By: " + dups);

        // 4. Given the input of integers, find the first element of the input
        Integer firstElement = getFirstElement(input1);
        System.out.println("First Element: " + firstElement);

        // 5. Given an input of integers, find the total number of elements present in the input
        long count = getCount(input1);
        System.out.println("Total number of elements : " + count);

        // 6. Given an input of integers, find the maximum value element present in it
        Integer maxValue = getMaxValue(input1);
        System.out.println("Max value in input1: " + maxValue);

        // 7. Given a String, find the first non-repeated character in it
        String str = "swiss"; // expected "w"
        Character firstNonRepeated = getFirstNonRepeated(str);
        System.out.println("First Non Repeated: " + firstNonRepeated);

        // 8. Given a String, find the first repeated character in it
        String str1 = "swiiss"; // expected "s"
        Character firstRepeated = getFirstRepeated(str1);
        System.out.println("First Repeated: " + firstRepeated);

        // 9. Given an input of integers, sort all the values present in it
        List<Integer> sortedValues = getSortedValues(input1);
        System.out.println("Sorted: " + sortedValues);

        // 10. Given an integer array nums, return true if any value appears at least twice in the array,
        // and return false if every element is distinct.
        boolean hasDuplicates = isHasDuplicates(input1);
        System.out.println("Has duplicates: " + hasDuplicates);

        // 11. How will you get the current date and time using Java 8 Date and Time API?
        System.out.println("Current Local date: " + java.time.LocalDate.now());
        System.out.println("Current Local time: " + java.time.LocalTime.now());
        System.out.println("Current Local Date and Time: " + java.time.LocalDateTime.now());

        // 12. Write a Java 8 program to concatenate two Streams
        Stream<String> concatenatedStrings = Stream.concat(input3_1.stream(), input3_2.stream());
        concatenatedStrings.forEach(System.out::println);

        // 13. program to perform cube on input1 elements and filter numbers greater than 50.
        List<Integer> cubed = getCubedGreaterThan50(input1);
        System.out.println("Cubed: " + cubed);

        // Return empty input1 if no such input exists
        List<Integer> cubedWithEmptyReturnList = input1.stream()
                .map(n -> n * n * n)
                .filter(n -> n < 50)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        res -> res.isEmpty() ? Collections.emptyList() : res));

        System.out.println("Cubed With Empty Return List: " + cubedWithEmptyReturnList);

        // 14. How to use map to convert object into Uppercase?
        String s1 = "somedummyvalue";
        String convertedToUpper = getConvertedToUpper(s1);
        System.out.println("Converted to upper case: " + convertedToUpper);

        // 15. How to find only duplicate elements with its count from the String ArrayList in Java8?
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String, Long> duplicateNames = getDuplicateNames(names);
        System.out.println("Duplicate Names: " + duplicateNames);

        // 16. How to check if input1 is empty in Java 8 using Optional, if not null iterate through the input1 and print the object?
        List<String> nonNullObjects = getNonNullObjects(noteLst);
        System.out.println("Non null objects: " + nonNullObjects);

        // 17. Write a Program to find the Maximum element in an array?
        Integer maxElem = getMaxElement(input1);
        System.out.println("Max element: " + maxElem);

        // 18. Write a program to print the count of each character in a String?
        String s2 = "MyNameIsMyName";
        Map<Character, Long> countOfChars = getCountOfChars(s2);
        System.out.println("Count of chars: " + countOfChars);

        // 19. Find second-highest number
        Integer secondHighest = getSecondHighest(input1);
        System.out.println("Second Highest Number: " + secondHighest);

        // 20. Find the longest string from given array
        List<String> cities = List.of("Hyderabad", "Chennai", "Mumbai", "Kolkata");
        String longestString = getLongestString(cities);
        System.out.println("Longest String: " + longestString);

        // using reduce
        String longestStringUsingReduce = cities.stream()
                .reduce((city1, city2) -> city1.length() > city2.length() ? city1 : city2)
                .get();

        System.out.println("Longest String using reduce: " + longestStringUsingReduce);

        // 21. Find Nth highest salary

        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("Alice", 1600);
        salaries.put("Bob", 8900);
        salaries.put("John", 5500);
        salaries.put("David", 6799);
        salaries.put("Warner", 6155);
        System.out.println("Nth Highest salary: " + getNthHighestSalary(salaries, 3));

        // 22. Given an input of numbers, return the sum of all numbers.
        Integer sum = getSum(input4);
        System.out.println("Sum of All numbers : " + sum);

        // 23. Given an input of numbers, return the average of all numbers
        double avg = getAvg(input4);
        System.out.println("Average of numbers: " + avg);

        // 24. Given an input of numbers, square them and filter the numbers which are greater 100 and then find the average of them.
        double avgOfFilteredData = getAvgOfFilteredData(input4, 100);
        System.out.println("Avg of filtered data: " + avgOfFilteredData);

        // 25. Given an input of numbers, find out all the numbers starting with 2.
        List<Integer> startsWith2FirstApproach = getNumbersStartingWithGivenNumber(input4, 2);
        System.out.println("Starts with 2: first approach: " + startsWith2FirstApproach);

        //second approach
        List<Integer> startsWith2SecondApproach = getNumbersStartingWithGivenNumSecondApproach(input4, 2);
        System.out.println("Starts with 2: second approach: " + startsWith2SecondApproach);

        // 26. Given an input of numbers, print the duplicate numbers.
        Set<Integer> nums = new HashSet<>();
        List<Integer> onlyDuplicates = getDuplicateElements(input4, nums);
        System.out.println("Only duplicates: " + onlyDuplicates);

        // second approach
        List<Integer> onlyDups = input4.stream()
                .filter(num -> Collections.frequency(input4, num) > 1)
                .distinct() // Just to avoid returning all the duplicates
                .toList();
        System.out.println("Only Duplicates 2: " + onlyDups);

        // 27. Given an input of numbers, print the maximum and minimum values.
        Integer maxVal = getMaxValue(input4);
        Integer minVal = getMinVal(input4);
        System.out.println("Max Value: " + maxVal);
        System.out.println("Min Value: " + minVal);

        // 28. Given an input of numbers, return the first 5 elements and their sum.
        Integer first5Sum = getFirst5Sum(input4);
        System.out.println("First 5 sum: " + first5Sum);

        // 29. Given an input of numbers, skip first 5 numbers and return the sum of remaining numbers.
        Integer skipFirst5AndSumRest = getSkipFirst5AndSumRest(input4);
        System.out.println("Skip first 5 and sum rest: " + skipFirst5AndSumRest);

        // 30. How many male and female employees are there in the organization?
        Map<String, Long> maleAndFemaleCounts = getMaleAndFemaleCount(employeeList);
        System.out.println("Male and Female counts: " + maleAndFemaleCounts);

        // 31. Print the name of all departments in the organization.
        List<String> departments = getAllDepartmentNames(employeeList);
        System.out.println("All departments: " + departments);

        // 32. What is the average age of male and female employees?
        Map<String, Double> avgAgeOfMaleAndFemale = getAvgAgeOfMaleAndFemale(employeeList);
        System.out.println("Avg age of male and female: " + avgAgeOfMaleAndFemale);

        // 33. Get the details of highest paid employee in the organization.
        Employee highestPaidEmployee = getHighestPaidEmployee(employeeList);
        System.out.println("Highest paid employee: " + highestPaidEmployee);

        // 34. Get the names of all employees who have joined after 2015.
        List<String> whoJoinedAfter2015 = getWhoJoinedAfter2015(employeeList);
        System.out.println("Who joined after 2015?: " + whoJoinedAfter2015);

        // 35. Count the number of employees in each department.
        Map<String, Long> employeesByDepartment = getEmployeesByDepartment(employeeList);
        System.out.println("Employees by department: " + employeesByDepartment);

        // 36. What is the average salary of each department?
        Map<String, Double> avgSalOfEachDept = getAvgSalOfEachDept(employeeList);
        System.out.println("Avg sal of each dept: " + avgSalOfEachDept);

        // 37. Who has the most working experience in the organization?
        Employee seniorEmployee = getSeniorEmployee(employeeList);
        System.out.println("Senior employee: " + seniorEmployee);

        // 38. Get the details of youngest male employee in the each department.
        Map<String, Employee> youngestMaleOfEachDept = getYoungestMaleOfEachDept(employeeList);
        System.out.println("Youngest male of each dept: " + youngestMaleOfEachDept);

        // 39. What is the average salary and total salary of the whole organization?
        DoubleSummaryStatistics summary = getDoubleSummaryStatistics(employeeList);
        System.out.println("Average salary of org: " + summary.getAverage());
        System.out.println("Total salary of org: " + summary.getSum());

        // 40. Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        Map<Boolean, List<Employee>> partitionByAge = getEmployeeDataPartitionedByAge(employeeList);
        System.out.println("Partitioned By Age: " + partitionByAge);

        // 41. Find the second-highest salary employee details.
        Employee secondHighestEmployee = getSecondHighestEmployee(employeeList);
        System.out.println("Second Highest employee: " + secondHighestEmployee);

        // 42. Get the maximum salary of an employee from each department.
        Map<String, Employee> maxSalByDept = getMaxSalByDept(employeeList);
        System.out.println("Max sal by dept: " + maxSalByDept);

    }

    private static Integer getSkipFirst5AndSumRest(List<Integer> input4) {
        return input4.stream()
                .skip(5)
                .reduce(Integer::sum)
                .orElse(-1);
    }

    private static Integer getFirst5Sum(List<Integer> input4) {
        return input4.stream()
                .limit(5)
                .reduce(Integer::sum)
                .orElse(-1);
    }

    private static Integer getMinVal(List<Integer> input4) {
        return input4.stream()
                .min(Comparator.naturalOrder())
                .orElse(-1);
    }

    private static double getAvgOfFilteredData(List<Integer> input4, int num) {
        return input4.stream()
                .map(n -> n * n)
                .filter(n -> n > num)
                .mapToInt(Integer::intValue)
                .average().orElse(0);
    }

    private static double getAvg(List<Integer> input4) {
        return input4.stream()
                .mapToInt(Integer::intValue).average().orElseThrow();
    }

    private static Integer getSum(List<Integer> input4) {
        return input4.stream()
                .reduce(0, Integer::sum);
    }

    private static String getLongestString(List<String> cities) {
        return cities.stream()
                .min((s11, s21) -> s21.length() - s11.length())
                .orElse(null);
    }

    private static Integer getSecondHighest(List<Integer> input1) {
        return input1.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst()
                .orElse(null);
    }

    private static Map<Character, Long> getCountOfChars(String s2) {
        return s2.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static Integer getMaxElement(List<Integer> input1) {
        return input1.stream()
                .max(Integer::compareTo)
                .orElse(-1);
    }

    private static List<String> getNonNullObjects(List<Note> noteLst) {
        return Optional.ofNullable(noteLst)
                .orElseGet(Collections::emptyList)
                .stream().filter(Objects::nonNull)
                .map(Note::name)
                .toList();
    }

    private static Map<String, Long> getDuplicateNames(List<String> names) {
        return names.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream().filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static String getConvertedToUpper(String s1) {
        return s1.chars()
                .mapToObj(c -> (char) c)
                .map(Character::toUpperCase)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    private static List<Integer> getCubedGreaterThan50(List<Integer> input1) {
        return input1.stream()
                .map(n -> n * n * n)
                .filter(n -> n > 50)
                .toList();
    }

    private static boolean isHasDuplicates(List<Integer> input1) {
        return input1.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .values()
                .stream()
                .anyMatch(countV -> countV > 1);
    }

    private static List<Integer> getSortedValues(List<Integer> input1) {
        return input1.stream()
                .sorted()
                .toList();
    }

    private static Character getFirstRepeated(String str1) {
        return str1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    private static Character getFirstNonRepeated(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    private static Integer getMaxValue(List<Integer> input1) {
        return input1.stream()
                .max(Integer::compare)
                .orElse(null);
    }

    private static long getCount(List<Integer> input1) {
        return input1.stream().count();
    }

    private static Integer getFirstElement(List<Integer> input1) {
        return input1.stream()
                .findFirst()
                .orElseThrow();
    }

    private static List<Integer> getDuplicateElements(List<Integer> input1, Set<Integer> duplicates) {
        return input1.stream()
                .filter(n -> !duplicates.add(n))
                .toList();
    }

    private static List<Integer> getNumbersStartingWithGivenNumSecondApproach(List<Integer> input1, int number) {
        return input1.stream()
                .filter(num -> Integer.toString(num)
                        .startsWith(""+number))
                .toList();
    }

    private static List<Integer> getNumbersStartingWithGivenNumber(List<Integer> input1, int number) {
        return input1.stream()
                .map(n -> n + "")
                .filter(s -> s.startsWith(""+number))
                .map(Integer::parseInt).toList();
    }

    private static List<Integer> getAllEvenNumbers(List<Integer> input1) {
        return input1.stream()
                .filter(n -> n % 2 == 0)
                .toList();
    }

    private static List<Employee> prepareEmployees() {
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
        return employeeList;
    }

    private static List<Note> prepareNotes() {
        List<Note> notes = new ArrayList<>();
        notes.add(new Note(1, "note1", 11));
        notes.add(new Note(2, "note2", 22));
        notes.add(new Note(3, "note3", 33));
        notes.add(new Note(4, "note4", 44));
        notes.add(new Note(5, "note5", 55));
        notes.add(new Note(6, "note4", 66));
        return notes;
    }

    private static Map<String, Employee> getMaxSalByDept(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getEmp_dept,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getEmp_salary)),
                                empOut ->empOut.orElse(null))));
    }

    private static Employee getSecondHighestEmployee(List<Employee> employeeList) {
        return employeeList.stream()
                .sorted((emp1, emp2) -> (int) (emp2.getEmp_salary() - emp1.getEmp_salary()))
                .skip(1)
                .findFirst()
                .orElse(null);

        // use can use
        // employeeList.stream().sorted(Comparator.comparingDouble(Employee::getEmp_salary).reversed()).skip(1).findFirst();
    }

    private static Map<Boolean, List<Employee>> getEmployeeDataPartitionedByAge(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getEmp_age() > 25));
    }

    private static DoubleSummaryStatistics getDoubleSummaryStatistics(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getEmp_salary));
    }

    private static Map<String, Employee> getYoungestMaleOfEachDept(List<Employee> employeeList) {
        return employeeList.stream()
                .filter(emp -> "Male".equals(emp.getEmp_gender()))
                .collect(Collectors.groupingBy(Employee::getEmp_dept,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Employee::getEmp_doj)),
                                empOpt -> empOpt.orElse(null))));
    }

    private static Employee getSeniorEmployee(List<Employee> employeeList) {
        return employeeList.stream()
                .max((emp1, emp2) -> emp2.getEmp_doj() - emp1.getEmp_doj())
                .orElseThrow();
        /*
        Using min
                Employee e=  employeeList.stream()
                .min(Comparator.comparingInt(Employee::getEmp_doj)).orElse(null);
         */
    }

    private static Map<String, Double> getAvgSalOfEachDept(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getEmp_dept, Collectors.averagingDouble(Employee::getEmp_salary)));
    }

    private static Map<String, Long> getEmployeesByDepartment(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getEmp_dept, Collectors.counting()));
    }

    private static List<String> getWhoJoinedAfter2015(List<Employee> employeeList) {
        return employeeList.stream()
                .filter(emp -> emp.getEmp_doj() > 2015)
                .map(Employee::getEmp_name)
                .toList();
    }

    private static Employee getHighestPaidEmployee(List<Employee> employeeList) {
        return employeeList.stream()
                .min((emp1, emp2) -> (int) (emp2.getEmp_salary() - emp1.getEmp_salary()))
                .orElse(null);
    }

    private static Map<String, Double> getAvgAgeOfMaleAndFemale(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getEmp_gender, Collectors.averagingDouble(Employee::getEmp_age)));
    }

    private static List<String> getAllDepartmentNames(List<Employee> employeeList) {
        return employeeList.stream()
                .map(Employee::getEmp_dept)
                .distinct()
                .toList();
    }

    private static Map<String, Long> getMaleAndFemaleCount(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getEmp_gender, Collectors.counting()));
    }

    private static String getNthHighestSalary(Map<String, Integer> salaries, int num) {
        return salaries
                .entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue() - entry1.getValue())
                .skip(num-1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
}
