package app.dto;

import javax.persistence.*;

@Entity
public class Hashtags {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int hashtagid;

    @Column(nullable = false)
    private String phrase;

    public Hashtags(String phrase){this.phrase = phrase;
    }   // end of constructor
}
