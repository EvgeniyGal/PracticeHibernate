package edu.goit.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;

@Entity
@Table(name = "profile")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProFile implements BaseEntity<Long> {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "people_id")
    private Long id;
    @Column(name = "address")
    private String address;
    @Column(name = "placeOfBirth")
    private String placeOfBirth;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "people_id")
    @MapsId
    private People people;

}
