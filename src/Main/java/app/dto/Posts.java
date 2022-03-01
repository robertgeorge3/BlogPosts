package app.dto;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name="Posts")
@Table(name ="Posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postid;


    private String content;

    public Long getPostid() {
        return postid;
    }

    public String getContent() {
        return content;
    }

    protected Posts(){}

    public Posts(String content){
        this.content = content;
    }

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "posts_hashtags",
            joinColumns = {@JoinColumn(name = "postid")},
            inverseJoinColumns = {@JoinColumn(name = "hashtagid")})
    private Set<Hashtags> postHashtags = new HashSet<>();

    public void addTag(Hashtags tag) {
        postHashtags.add(tag);
        tag.getPosts().add(this);
    }

    public void removeTag(Hashtags tag) {
        postHashtags.remove(tag);
        tag.getPosts().remove(this);
    }
    public Long getId() {
        return postid;
    }

    public void setId(Long id) {
        this.postid = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Posts)) return false;
        return postid != null && postid.equals(((Posts) o).postid);
    }

    @Override
    public int hashCode() {
        return 31;
    }


}
