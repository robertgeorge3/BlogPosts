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
}
