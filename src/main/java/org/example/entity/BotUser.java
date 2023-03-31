package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder (toBuilder = true)
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
    private Long countVisits;
}

