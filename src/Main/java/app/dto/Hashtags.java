package app.dto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Hashtags")
@Table(name = "Hashtags")
public class Hashtags {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long hashtagid;

    @Column(nullable = false)
    private String phrase;

    public Hashtags() {
    }

    public Hashtags(String phrase){this.phrase = phrase;
    }   // end of constructor
    @ManyToMany(mappedBy = "postHashtags")
    private Set<Posts> hashtagPosts = new HashSet<>();

    public Set<Posts> getPosts() {
        return hashtagPosts;
    }

    public void setPosts(Set<Posts> posts) {
        this.hashtagPosts = posts;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hashtags tag = (Hashtags) o;
        return Objects.equals(phrase, tag.phrase);
    }
    @Override
    public int hashCode() {
        return Objects.hash(phrase);
    }

}
