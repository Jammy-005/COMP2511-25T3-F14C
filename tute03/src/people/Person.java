package people;

import java.util.Map;

public abstract class Person {
    public static final Map<String, Integer> PAY_RATES = Map.of(
        "LVL0", 0,
        "LVL1", 1000,
        "LVL2", 2000,
        "LVL3", 3000
    );

    private String name;
    private int age;
    private int salary;


    /**
     * Invariants same as preconditions.
     * 
     * 
     * @pre age >= 0
     * @pre name != ""
     * @pre payRate is an integer string and its > 0
     * @param name
     * @param age
     * @param payRate
     * @post created Person.
     */
    public Person(String name, int age, String payRate) {
        setName(name);
        setAge(age);
        setSalary(payRate);
    }

    /**
     * Invariant, person object always has a name
     * @return returns non null string
     */
    public String getName() {
        return name;
    }

    /**
     * @pre name != ""
     * @param name
     * @post update Person's name
     */
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    /**
     * Sets the salary of a person given their pay rate
     * @param payRate New pay rate of the person
     * @precondition payRate is an integer string
     * @pre payRate >= 0
     * @postcondition update Person's salary
     */
    public void setSalary(String payRate) {
        Integer pay = PAY_RATES.get(payRate);
        salary = pay;
    }
}
