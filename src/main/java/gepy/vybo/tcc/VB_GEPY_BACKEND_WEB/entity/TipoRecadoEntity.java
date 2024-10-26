package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.TipoRecadoDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "tipo_recado")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TipoRecadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    public TipoRecadoEntity(TipoRecadoDTO tipoRecado) {
        BeanUtils.copyProperties(tipoRecado, this);
    }
}
