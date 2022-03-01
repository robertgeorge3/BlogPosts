package app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name="posts_hashtags")
@Table(name ="posts_hashtags")
public class posts_hashtags implements Serializable {

    @Id
    private Long postid;
    @Id
    private Long hashtagid;
}
