package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.VinculoDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "vinculo")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class VinculoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", nullable = false)
    private FuncionarioEntity funcionario;

    @ManyToOne
    @JoinColumn(name = "id_cargo", nullable = false)
    private CargoEntity cargo;

    public VinculoEntity(VinculoDTO vinculo) {
        BeanUtils.copyProperties(vinculo, this);
        if(vinculo != null && vinculo.getFuncionario() != null) {
            this.funcionario = new FuncionarioEntity(vinculo.getFuncionario());
        }
        if(vinculo != null && vinculo.getCargo() != null) {
            this.cargo = new CargoEntity(vinculo.getCargo());
        }
    }
}
