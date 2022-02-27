package app.dto;


import javax.persistence.*;
import java.util.List;

@Entity
public class Posts {

    @Id
    private int postid;
    @Column(nullable = false)
    private String content;

    public int getPostid() {
        return postid;
    }

    public String getContent() {
        return content;
    }

    protected Posts(){}

    @ManyToMany
    @JoinTable(name = "posts_hashtags",
            joinColumns = {@JoinColumn(name = "postid")},
            inverseJoinColumns = {@JoinColumn(name = "hashtagid")})
    private List<Hashtags> hashtags;


}
