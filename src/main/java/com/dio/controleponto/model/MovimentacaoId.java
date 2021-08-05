package com.dio.controleponto.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Embeddable
public class MovimentacaoId implements Serializable {

    @Column(name = "id")
    private Long id;

    @ManyToOne
    private Usuario usuario;
}
