package vn.iotstar.configs;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Video;

public class Test {

    public static void main(String[] args) {

        EntityManager entityManager = JPAConfig.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Category category = new Category();
        category.setCategoryname("Iphone");
        category.setImages("abc.jpg");
        category.setStatus(1);

        Video video = new Video();
        video.setVideoId("v01");
        video.setTitle("test");
        video.setCategory(category);

        try {
            transaction.begin();
            entityManager.persist(category);
            entityManager.persist(video);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }
}

