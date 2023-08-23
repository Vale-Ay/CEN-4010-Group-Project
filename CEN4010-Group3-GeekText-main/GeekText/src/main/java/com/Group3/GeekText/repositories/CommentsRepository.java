package com.Group3.GeekText.repositories;

import com.Group3.GeekText.entities.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer> {
    @Query("SELECT c.comment FROM Comments c WHERE c.bookID = :bookID")
    List<String> findCommentsByBookID(@Param("bookID") Integer bookID);
}
