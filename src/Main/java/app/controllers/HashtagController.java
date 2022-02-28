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
            // catch error
            Character firstChar;
            try{
                firstChar = word.charAt(0);
            }
            catch(Exception e){
                continue;
            }


            // check for #
            if (firstChar.equals('#')) {
                word = word.substring(1);    // eliminates #
                word = word.trim(); // eliminates leading and trailing spaces
                hashtags.add(word); // add hashtag to arraylist
            }   //End of if
        }   // End of for loop

        // check hashtag table and add if new
        ArrayList<Integer> hashIds = checkHash(hashtags);

        // create bridge table entry
        addPostHash(post, hashIds);

        // return array of hashtags
        return hashtags;
    }
    // For each hashtag in list, check-add to hashtag table
    public ArrayList<Integer> checkHash(ArrayList<String> hashtags){
        // create arraylist to hold hashIds
        ArrayList<Integer> hashIds = new ArrayList<Integer>();

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
            // get id and add to arraylist

        }   // End of for each loop
        return hashIds;
    }   // End of checkHash

    // Add postid + each hashtagid to bridge table
    /*
    The parameters given are a single post and the list of hashtags ids
    within that post. Thus, the post id is the same for each row to be
    added to the bridge table for every single instance this method is called.
     */
    public void addPostHash(Posts post, ArrayList<Integer> hashIds){    // parameters are the hashtags in a given post
       // add hashtags list property to post
        post.setUsedHashtags(hashIds);

    }   // End of addPostHash

} // end controllers
