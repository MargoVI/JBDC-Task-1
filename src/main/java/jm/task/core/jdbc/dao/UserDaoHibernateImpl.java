package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

import static jm.task.core.jdbc.util.Util.*;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        try (session){
            transaction.begin();
            session.createSQLQuery(CREATE_TABLE).executeUpdate();
            transaction.commit();
        } catch(HibernateException e){
            if(transaction !=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        try (session){
            transaction.begin();
            session.createSQLQuery(DROP_TABLE).executeUpdate();
            transaction.commit();
        } catch(HibernateException e){
            if(transaction !=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        try (session){
            transaction.begin();
            User user = new User(name, lastName, age);
            session.save(user);
            System.out.println(" User с именем – " + name + " добавлен в базу данных");
            transaction.commit();
        } catch(HibernateException e){
            if(transaction !=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        try (session){
            transaction.begin();
            session.delete(session.get(User.class, id));
            transaction.commit();
        } catch(HibernateException e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = getSessionFactory().openSession()){
            Query<User> query = session.createQuery("from User", User.class);
            query.stream().forEach(System.out::println);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void cleanUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        try (session){
            transaction.begin();
            session.createQuery("delete from User").executeUpdate();
            transaction.commit();
        } catch(HibernateException e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
