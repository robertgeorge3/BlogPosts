package app.dao;

import app.dto.Posts;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
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
    @BeforeEach
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
        //post.setId(1L);

        post.setContent("Test content");
        // save to DB
        postDao.save(post);

        // pull out from DB
        Posts fromDao = postDao.getById(post.getPostid());

        // check post created is equal to post saved to DB
        assertEquals(post, fromDao);

    }   // End of test

    //findAll
    @Test
    @Transactional
    public void testFindAllPosts() {
        // create new post object
        Posts post = new Posts();
        //post.setId(1L);
        post.setContent("Test post content 1");
        postDao.save(post);

        // create second post object
        Posts post2 = new Posts();
        //post2.setId(2L);
        post2.setContent("Test post content 2");
        postDao.save(post2);

        // get posts in list
        List<Posts> posts = postDao.findAll();

        // check rooms are in DB
        assertEquals(2, posts.size());
        assertTrue(posts.contains(post));
        assertTrue(posts.contains(post2));
    }   // End of test

    //count
    @Test
    public void testCount() {
        // create post object
        Posts post = new Posts();
        post.setContent("test content");

        // add to DB
        postDao.save(post);

        // check the count
        assertEquals(1, postDao.count());

        // create 2nd post object
        Posts post2 = new Posts();
        post2.setContent("test content2");

        // add to DB
        postDao.save(post2);

        // check new count
        assertEquals(2, postDao.count());
    }   // End of count
}   // End of class