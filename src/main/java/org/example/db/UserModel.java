package org.example.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserModel {

    private Date date;
    private Long userTgId;
    private String userName;

}
