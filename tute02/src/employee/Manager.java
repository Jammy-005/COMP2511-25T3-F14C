package employee;

import java.time.LocalDate;

public class Manager extends Employee {
    private LocalDate hireDate;

    /**
     * Creates a Manager with the given name, salary, and hire date.
     *
     * @param name     The full name of the manager.
     * @param salary   The manager's yearly salary in dollars.
     * @param hireDate The date the manager was hired.
     */
    public Manager(String name, int salary, LocalDate hireDate) {
        super(name, salary);
        this.hireDate = hireDate;
    }

    /**
     * Creates a Manager with the given name and salary, and sets the hire date to today.
     * 
     * @param name
     * @param salary
     */
    public Manager(String name, int salary) {
        this(name, salary, LocalDate.now());
    }

    /**
     * Return the manager's hire date.
     * @return The date the manager was hired.
     */
    public LocalDate getHireDate() {
        return hireDate;
    }

    @Override
    public String toString() {
        return super.toString() + " [hireDate=" + hireDate + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(super.equals(obj))) {
            return false;
        }

        Manager other = (Manager) obj;
        return this.hireDate.equals(other.hireDate);
    }    

    public static void main(String[] args) {
        Manager mgr1 = new Manager("Jane Smith", 80000, LocalDate.of(2020, 1, 15));
        Employee mgr2 = new Employee("Hello world", 0);
        System.out.println(mgr1.toString());
        System.out.println(mgr1.equals(mgr2));
    }
}
