package com.educc0r.rxjava.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tbl_book")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBook;

    @Column(length = 100, nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "id_author")
    private Author author;
}
