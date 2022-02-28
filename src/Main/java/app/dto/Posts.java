package app.dto;


import javax.persistence.*;
import java.util.ArrayList;

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

    public Posts(String content){
        this.content = content;
    }

    @ManyToMany
    @JoinTable(name = "posts_hashtags",
            joinColumns = {@JoinColumn(name = "postid")},
            inverseJoinColumns = {@JoinColumn(name = "hashtagid")})
    private ArrayList<Integer> usedHashtags;

    public ArrayList<Integer> getUsedHashtags() {
        return usedHashtags;
    }

    public void setUsedHashtags(ArrayList<Integer> usedHashtags) {
        this.usedHashtags = usedHashtags;
    }
}
