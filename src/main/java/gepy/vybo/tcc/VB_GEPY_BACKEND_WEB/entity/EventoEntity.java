package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.EventoDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "evento")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class EventoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String data;

    @Column(nullable = false)
    private String hora;

    @OneToOne
    private FuncionarioEntity remetente;

    @ManyToOne
    private TurmaEntity destinatario;

    public EventoEntity(EventoDTO evento){
        BeanUtils.copyProperties(evento, this);
    }
}
