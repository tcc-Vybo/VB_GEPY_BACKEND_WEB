package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "funcionario")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class FuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
