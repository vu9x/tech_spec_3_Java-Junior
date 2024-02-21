package org.example.homework;

import org.example.models.Course;
import org.example.models.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class hwProgram {
    public static void main(String[] args) {
        // Создание фабрики сессий
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernateSchoolDB.cfg.xml")
                .addAnnotatedClass(School.class)
                .buildSessionFactory();

        // Создание сессии
        Session session = sessionFactory.getCurrentSession();


        // Сессия работы со Школой
        try {
            // Начало транзакции
            session.beginTransaction();

            //Создание объекта
            School school = School.create();

            session.save(school);
            System.out.println("Object has been saved syccessfully");

            // Чтение объекта
            School retrivedSchool = session.get(School.class, school.getId());
            System.out.println("Object school retrieved successfully");
            System.out.println("Retrieved school object: " + retrivedSchool);

            // Обновление объекта
            retrivedSchool.updateTitle();
            retrivedSchool.updateDuration();
            session.update(retrivedSchool);
            System.out.println("Object school update successfully");

            // Удаление объекта
//            session.delete(retrivedSchool);
//            System.out.println("Object school update successfully");

            // Коммит транзакции
            session.getTransaction().commit();

        } finally {
            session.close();
        }

        Session session2 = sessionFactory.getCurrentSession();
        // Сессия работы с Курсами
        try {
            // Начало транзакции
            session2.beginTransaction();

            //Создание объекта
            Course course = Course.create();

            session2.save(course);
            System.out.println("Course has been saved successfully");

            // Чтение объекта
            Course retrivedCourse = session2.get(Course.class, course.getId());
            System.out.println("Object course retrieved successfully");
            System.out.println("Retrieved course object: " + retrivedCourse);

            // Обновление объекта
            retrivedCourse.updateCourseDuration();
            retrivedCourse.updateCourseName();
            session2.update(retrivedCourse);
            System.out.println("Object course update successfully");

            // Удаление объекта
//            session2.delete(retrivedCourse);
//            System.out.println("Object course update successfully");

            // Коммит транзакции
            session2.getTransaction().commit();

        } finally {
            session2.close();
        }
    }
}
