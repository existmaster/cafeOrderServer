package com.narae.cafe.user.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by existmaster on 2016. 11. 26..
 */
@Entity
@Data
public class User {
    @Id @Column(name = "user_id")
    private String id;

    private String name;

    private String password;

}
