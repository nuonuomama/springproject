package com.xueduan.stock.dbservice.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@Table(name = "quotes", catalog = "testdb")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @Column(name="user_name")
    private String userName;
    @Column(name="quote")
    private String quote;
    public Quote(String userName,String quote){
        this.userName=userName;
        this.quote=quote;
    }
}
