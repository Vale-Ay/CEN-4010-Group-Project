package com.Group3.GeekText.repositories;

import com.Group3.GeekText.entities.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingsRepository extends JpaRepository<Ratings,Integer> {
    @Query("SELECT AVG(r.rating) FROM Ratings r WHERE r.bookID = :bookID")
    Double getAverageRatingByBookID(@Param("bookID") Integer bookID);
}
