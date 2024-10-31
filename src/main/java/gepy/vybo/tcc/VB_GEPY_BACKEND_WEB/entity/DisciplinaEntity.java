package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.DisciplinaDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "disciplina")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class DisciplinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @PrePersist
    @PreUpdate
    public void prePersistAndUpdate(){
        if (this.nome != null){
            this.nome = this.nome.toUpperCase();
        }
    }

    public DisciplinaEntity(DisciplinaDTO disciplina) {
        BeanUtils.copyProperties(disciplina, this);
    }
}
