package app.dto;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hashtags {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int hashtagid;

    @Column(nullable = false)
    private String phrase;

    public Hashtags(String phrase){this.phrase = phrase;
    }   // end of constructor

    // Should handle or be necessary for the bridge table
    @ManyToMany(mappedBy = "usedHashtags")
    public List<Posts> inPosts;

    public int getHashtagid() {
        return hashtagid;
    }

    public void setHashtagid(int hashtagid) {
        this.hashtagid = hashtagid;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public List<Posts> getInPosts() {
        return inPosts;
    }

    public void setInPosts(List<Posts> inPosts) {
        this.inPosts = inPosts;
    }
}
