package org.example;

import org.hibernate.Session;

public class Program {
    public static void main(String[] args)
    {
        Connector connector = new Connector();
        Session session = connector.getSession();

        /**
         * Для проверки методов необходимо раскомментировать нужный
         */

//        Db.addCourse("Математика", 120);
//        Db.addCourse("Геомтерия", 110);
//        Db.addCourse("Физика", 70);
//        Db.addCourse("Пение", 20);
//        Db.editCourse(session, 2, "Алгебра", 70);
//        Db.printCourses(session);
//        Db.delCourses(session);

    }
}