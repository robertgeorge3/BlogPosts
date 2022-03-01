package app.dao;

import app.dto.Posts;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PostRepositoryTest {
    // DI
    @Autowired
    PostRepository postDao;

    @Autowired
    HashtagRepository hashtagDao;

    // Set up DB before tests
    @Before
    public void setUp() {       //
        postDao.deleteAll();
        hashtagDao.deleteAll();
    }   // End of setUp

    // getById + save
    @Test
    @Transactional
    public void testAddGetPost() {
        // create post object
        Posts post = new Posts();
        // fill with information
        post.setId(1L);
        post.setContent("Test content");
        // save to DB
        postDao.save(post);
        // pull out from DB
            //Posts fromDao = postDao.getById(id);
        Posts fromDao = postDao.getById(post.getPostid());

        // check post created is equal to post saved to DB
        assertEquals(post, fromDao);      // unsolveable error with assertEquals method

    }   // End of test
    //findAll

    //deleteById

    //count

    //existsById
}   // End of class