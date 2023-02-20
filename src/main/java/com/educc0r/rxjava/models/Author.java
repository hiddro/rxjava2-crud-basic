package com.educc0r.rxjava.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tbl_author")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Author {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAuthor;

    @Column(length = 100, nullable = false)
    private String name;

}
