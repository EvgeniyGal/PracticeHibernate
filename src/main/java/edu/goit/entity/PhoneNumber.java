package edu.goit.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;

@Entity
@Table(name = "phone_number")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneNumber implements BaseEntity<Long> {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number")
    private String number;
    @Enumerated(EnumType.STRING)
    @Column(name = "phone_type")
    private PhoneType phoneType;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private People people;
}
