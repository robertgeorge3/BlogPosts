package app.dao;

import app.dto.Hashtags;
import app.dto.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface PostRepository extends JpaRepository<Posts, Long> {



}
