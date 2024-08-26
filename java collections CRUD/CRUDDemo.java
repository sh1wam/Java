import java.util.*;

class Employee {
    private int empno;
    private String ename;
    private int salary;

    Employee(int empno, String ename, int salary) {
        this.empno = empno;
        this.ename = ename;
        this.salary = salary;
    }

    public int getEmpno() {
        return empno;
    }

    public int getSalary() {
        return salary;
    }

    public String getEname() {
        return ename;
    }

    public String toString() {
        return empno + " " + ename + " " + salary;
    }
}

class CRUDDemo {
    public static void main(String[] args) {

        List<Employee> coll = new ArrayList<Employee>();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1.INSERT");
            System.out.println("2.DISPLAY");
            System.out.println("3.SEARCH");
            System.out.println("4.DELETE");
            System.out.println("5.UPDATE");
            System.out.print("Enter Your Choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Empno: ");
                    int eno = scanner.nextInt();
                    System.out.print("Enter EmpName: ");
                    String ename = scanner2.nextLine();
                    System.out.print("Enter Salary: ");
                    int salary = scanner.nextInt();

                    coll.add(new Employee(eno, ename, salary));
                    break;

                case 2:
                    System.out.println("---------------------------------");
                    Iterator<Employee> i = coll.iterator();
                    while (i.hasNext()) {
                        Employee e = i.next();
                        System.out.println(e);
                    }
                    System.out.println("---------------------------------");
                    break;

                case 3:
                    boolean found = false;
                    System.out.println("Enter Empno To Search: ");
                    int empno = scanner.nextInt();
                    System.out.println("---------------------------------");
                    i = coll.iterator();
                    while (i.hasNext()) {
                        Employee e = i.next();
                        if (e.getEmpno() == empno) {
                            System.out.println(e);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found!");
                    }
                    System.out.println("---------------------------------");
                    break;

                case 4:
                    found = false;
                    System.out.println("Enter Empno To Delete: ");
                    empno = scanner.nextInt();
                    System.out.println("---------------------------------");
                    i = coll.iterator();
                    while (i.hasNext()) {
                        Employee e = i.next();
                        if (e.getEmpno() == empno) {
                            i.remove();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found!");
                    } else {
                        System.out.println("Record is Deleted Successfully!");
                    }
                    System.out.println("---------------------------------");
                    break;

                case 5:
                    found = false;
                    System.out.println("Enter Empno To Update: ");
                    empno = scanner.nextInt();
                    ListIterator<Employee> li = coll.listIterator();
                    while (li.hasNext()) {
                        Employee e = li.next();
                        if (e.getEmpno() == empno) {
                            System.out.print("Enter new Name: ");
                            ename = scanner2.nextLine();
                            System.out.print("Enter new Salary: ");
                            salary = scanner.nextInt();

                            li.set(new Employee(empno, ename, salary));

                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found!");
                    } else {
                        System.out.println("Record is Updated Successfully!");
                    }
                    break;
            }

        } while (choice != 0);

        scanner.close();
        scanner2.close();
    }
}