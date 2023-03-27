package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doc_info")
public class DocumentInfo implements BotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer docIndex;
    private String docName;
    private String docPath;
    private String docType;
    private String description;
    private LocalDateTime dateCreate;
}