package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try {
            /*session = factory.getCurrentSession();
            Employee employee = new Employee("Ramazan", "Aliev",
                    "IT", 500);
            Detail detail = new Detail("Moscow", "88005553535",
                    "ramazanaliev@gmail.com");

            employee.setEmpDetail(detail);
            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();
            System.out.println("Success");*/

            /*session = factory.getCurrentSession();
            Employee employee = new Employee("Oleg", "Smirnov",
                    "Sales", 700);
            Detail detail = new Detail("Kiev", "86545624",
                    "olejka@gmail.com");

            employee.setEmpDetail(detail);
            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();
            System.out.println("Success");*/

            /*session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 10);
            System.out.println(employee.getEmpDetail());

            session.getTransaction().commit();
            System.out.println("Success");*/

            session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 2);
            session.delete(employee);

            session.getTransaction().commit();
            System.out.println("Success");
        } finally {
            session.close();
            factory.close();
        }

    }
}
