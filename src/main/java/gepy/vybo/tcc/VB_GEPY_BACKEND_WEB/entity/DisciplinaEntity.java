package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.DisciplinaDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Entity
@Table(name = "disciplina")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class DisciplinaEntity extends DisciplinaDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Column(nullable = false)
    private String descricao;

    @PrePersist
    @PreUpdate
    public void prePersistAndUpdate(){
        if (this.nome != null){
            this.nome = this.nome.toUpperCase();
        }
    }

    @OneToMany(mappedBy = "disciplina")
    private List<ProfessorDisciplinaEntity> professores;

    public DisciplinaEntity(DisciplinaDTO disciplina) {
        BeanUtils.copyProperties(disciplina, this);
    }
}
