package com.jiyeon.project.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "row_num")
    private Long rowNum;

    @Column(name = "col_Val")
    private String colVal;

    @OneToOne(mappedBy = "seat")
    private User user;

}
