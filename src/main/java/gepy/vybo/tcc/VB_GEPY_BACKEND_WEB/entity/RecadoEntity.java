package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.RecadoDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "recado")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class RecadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String rementente;

    @Column(nullable = false)
    private String destinatario;

    @Column(nullable = false)
    private String texto;

    @Column(nullable = false)
    private String dataAtual;

    @Column(nullable = false)
    private String horarioAtual;

    public RecadoEntity(RecadoDTO recado){
        BeanUtils.copyProperties(recado, this);
    }
}
