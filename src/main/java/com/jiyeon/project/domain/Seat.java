package com.jiyeon.project.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "row_num")
    private Long rowNum;

    @Column(name = "col_Val")
    private String colVal;

    @JoinColumn(name="seat_id")
    @OneToMany
    private List<User> users = new ArrayList<>();

}
