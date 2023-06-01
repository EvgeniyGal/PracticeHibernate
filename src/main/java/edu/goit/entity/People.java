package edu.goit.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "people")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"phoneNumbers", "proFile", "organizations"})
@ToString(exclude = {"phoneNumbers", "proFile", "organizations"})
public class People implements BaseEntity<Long> {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String lastName;
    @Column(length = 50)
    private String firstNAme;
    private byte age;
    private LocalDate birthday;
    private boolean isMarried;
    @Builder.Default
    @OneToMany(mappedBy = "people", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();
    @OneToOne(mappedBy = "people", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ProFile proFile;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "people_role", joinColumns = @JoinColumn(name = "people_id"))
    private Set<Authority> roles = new HashSet<>();
    @Builder.Default
    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "people_organization",
            joinColumns = @JoinColumn(name = "people_id"),
            inverseJoinColumns = @JoinColumn(name = "organization_id"))
    private List<Organization> organizations = new ArrayList<>();


}
