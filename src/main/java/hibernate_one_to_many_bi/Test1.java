package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {
            /*session = factory.getCurrentSession();

            Department department = new Department("Sales",
                    800, 1500);
            Employee employee1 = new Employee("Ramazan", "Aliev",
                    800);
            Employee employee2 = new Employee("Elena", "Smirnova",
                    1500);
            Employee employee3 = new Employee("Anton", "Sidorov",
                    1200);
            department.addEmployeeToDepartment(employee1);
            department.addEmployeeToDepartment(employee2);
            department.addEmployeeToDepartment(employee3);

            session.beginTransaction();

            session.save(department);

            session.getTransaction().commit();
            System.out.println("Success");*/

            session = factory.getCurrentSession();

            session.beginTransaction();

            System.out.println("Get department");
            Department department = session.get(Department.class, 4);
            System.out.println("Show department");
            System.out.println(department);
            System.out.println("Download employees");
            department.getEmployees().get(0);

            session.getTransaction().commit();
            System.out.println("Show employees of the department");
            System.out.println(department.getEmployees());

            System.out.println("Success");

            /*session = factory.getCurrentSession();

            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);
            System.out.println(employee);
            System.out.println(employee.getDepartment());

            session.getTransaction().commit();
            System.out.println("Success");*/

            /*session = factory.getCurrentSession();

            session.beginTransaction();

            Employee employee = session.get(Employee.class, 4);
            session.delete(employee);

            session.getTransaction().commit();
            System.out.println("Success");*/

        } finally {
            session.close();
            factory.close();
        }

    }
}
