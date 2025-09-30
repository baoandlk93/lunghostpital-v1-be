package vn.org.bvpkh.bvpkh_gov.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;
    String description;
    String author;
    String publisher;
    String content;

    @ManyToOne(fetch = FetchType.LAZY)
    Tag tags;
    @ManyToOne(fetch = FetchType.LAZY)
    Category category;

}
