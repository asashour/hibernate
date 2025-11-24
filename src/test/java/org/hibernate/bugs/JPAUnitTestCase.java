package org.hibernate.bugs;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static jakarta.persistence.criteria.JoinType.LEFT;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
class JPAUnitTestCase {

    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
    }

    @AfterEach
    void destroy() {
        entityManagerFactory.close();
    }

    @Test
    void test() {
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        var cb = entityManager.getCriteriaBuilder();
        var query = cb.createQuery(Request.class);
        var root = query.from(Request.class);
        query.where(getPredicate(cb, root));
        entityManager.createQuery(query).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    Predicate getPredicate(CriteriaBuilder cb, Root<Request> root) {
        var pattern = "%abc%";
        var treat = cb.treat(root, KeywordAssetRequest.class);
        return cb.like(cb.lower(treat.join("tokens", LEFT)), pattern);
    }
}