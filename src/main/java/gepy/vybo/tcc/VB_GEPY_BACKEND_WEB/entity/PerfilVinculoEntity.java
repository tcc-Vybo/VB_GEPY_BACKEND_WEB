package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.CargoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.FuncionarioDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.PerfilVinculoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.TurmaDisciplinaDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "perfil_vinculo")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PerfilVinculoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cargo", nullable = false)
    private CargoEntity cargo;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", nullable = false)
    private FuncionarioEntity funcionario;

    public PerfilVinculoEntity(PerfilVinculoDTO perfilVinculo) {
        BeanUtils.copyProperties(perfilVinculo, this);
        if(perfilVinculo != null && perfilVinculo.getCargo() != null) {
            this.cargo = new CargoEntity(perfilVinculo.getCargo());
        }
        if(perfilVinculo != null && perfilVinculo.getFuncionario() != null) {
            this.funcionario  = new FuncionarioEntity(perfilVinculo.getFuncionario());
        }
    }
}
