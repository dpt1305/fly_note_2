package aden.dev.site.fly_note.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;
//@Entity
//@Table(name = "employees")
//public class NoteEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private Integer id;
////    private Id _id;
////    private String title;
////    private String content;
////    private Date createAt;
////    private Date updateAt;
//}

//@Entity
//@Document(collection = "note")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class NoteEntity {
    @Id
    private String id;

    private String title;
    private String content;
}