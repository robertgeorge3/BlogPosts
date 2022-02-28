package app.controllers;


import app.dao.HashtagRepository;
import app.dao.PostRepository;
import app.dto.Hashtags;
import app.dto.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class HashtagController {
    @Autowired
    HashtagRepository hashtagDao;

    @Autowired
    public HashtagController(HashtagRepository hashtagDao) {
        this.hashtagDao = hashtagDao;
    }   // End of constructor

    @Autowired
    PostRepository postDao;

    /*@Autowired
    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }   // End of constructor*/


    @GetMapping("findall")
    public List<Hashtags> findAll() {
        return hashtagDao.findAll();
    }   // End of findAll method

    // Parse all posts ONCE when program starts
    public void startUp() {
        for (int id = 1; id <= postDao.count(); id++) {
            findHash(postDao.getById(id));  // find hashtags in a post
        }   // End of for loop

    }   // End of startUp method

    // Search 1 post for hashtags and return a list
    public ArrayList<String> findHash(Posts post) {
        // create arraylist to store hashtags
        ArrayList<String> hashtags = new ArrayList<String>();

        // Store post as string
        String content = post.getContent();
        // split string by spaces
        String[] words = content.split(" ");

        // find # and store into array
        for (String word : words) {
            Character firstChar = word.charAt(0);

            // check for #
            if (firstChar.equals("#")) {
                word = word.replace("#","");    // eliminates #
                word = word.trim(); // eliminates leading and trailing spaces
                hashtags.add(word); // add hashtag to arraylist
            }   //End of if
        }   // End of for loop

        // check hashtag table and add if new
        ArrayList<Hashtags> hashtagslist = checkHash(hashtags);

        // create bridge table entry
        addPostHash(post, hashtagslist);

        // return array of hashtags
        return hashtags;
    }
    // For each hashtag in list, check-add to hashtag table
    public ArrayList<Hashtags> checkHash(ArrayList<String> hashtags){
        // create arraylist to hold hashIds
        ArrayList<Hashtags> hashtagslist = new ArrayList<Hashtags>();

        for (String phrase : hashtags) {
            // check if it exists
            if (hashtagDao.existsHashtagByPhrase(phrase)){
                // if yes, continue
                continue;
            // if no, add to DB
            }   // end of if
            else {
                Hashtags hashtag = new Hashtags(phrase);
                hashtagDao.save(hashtag);

            }   // end of else
            // get object and add to arraylist
            hashtagslist.add(hashtagDao.getHashtagByPhrase(phrase));

        }   // End of for each loop
        return hashtagslist;
    }   // End of checkHash

    // Add postid + each hashtagid to bridge table
    public void addPostHash(Posts post, ArrayList<Hashtags> hashtagslist){
        post.setUsedHashtags(hashtagslist);
    }   // End of addPostHash

} // end controllers
