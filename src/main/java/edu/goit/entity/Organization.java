package edu.goit.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "people")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Organization implements BaseEntity<Long> {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 50)
    private String name;
    @Builder.Default
    @ManyToMany(mappedBy = "organizations", cascade = CascadeType.REFRESH)
    private List<People> peoples = new ArrayList<>();
}
