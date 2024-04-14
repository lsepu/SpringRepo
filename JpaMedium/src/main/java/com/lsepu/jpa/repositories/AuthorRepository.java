package com.lsepu.jpa.repositories;

import com.lsepu.jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Integer>,
        JpaSpecificationExecutor<Author> {

    @Transactional
    List<Author> findByNamedQuery(@Param("age") int age);

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthorAge(int id, int age);

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    int updateAllAuthorsAges(int age);
    List<Author> findAllByFirstName(String firstName);
    List<Author> findAllByFirstNameIgnoreCase(String firstName);
    List<Author> findAllByFirstNameContainingIgnoreCase(String firstName);
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String firstName);
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String firstName);
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);
}
