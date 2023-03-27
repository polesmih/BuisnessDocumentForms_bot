package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bot_users")
public class BotUser implements BotEntity{
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private LocalDateTime dateCreate;
}