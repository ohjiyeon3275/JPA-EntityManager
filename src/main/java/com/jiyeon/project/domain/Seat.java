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

    @OneToMany(mappedBy = "seat" , cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();

    public void addUser(User user){
        this.users.add(user);
        if(user.getSeat()!=this){
            user.setSeat(this);
        }
    }

}
