package vn.iotstar.configs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.iotstar.entity.User;
import java.sql.Date;

public class Test {

    public static void main(String[] args) {

        EntityManager entityManager = JPAConfig.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        // Create a new User instance
        User user = new User();
        user.setEmail("test@example.com");
        user.setUserName("testuser");
        user.setFullName("Test User");
        user.setPassword("password123");
        user.setImages("user-avatar.jpg");
        user.setRoleid(1); // Assuming roleid 1 is an example role
        user.setPhone("0123456789");
        user.setCreatedDate(new Date(System.currentTimeMillis())); // Set current date as createdDate

        try {
            // Begin the transaction
            transaction.begin();

            // Persist the User object
            entityManager.persist(user);

            // Commit the transaction
            transaction.commit();

            System.out.println("User successfully created and persisted to the database.");
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            System.out.println("Transaction failed, changes rolled back.");
            throw e;
        } finally {
            // Close the entity manager
            entityManager.close();
        }
    }
}
