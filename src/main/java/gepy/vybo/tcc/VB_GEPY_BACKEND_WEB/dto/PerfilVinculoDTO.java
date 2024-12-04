package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.FuncionarioEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.PerfilVinculoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.TurmaDisciplinaEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class PerfilVinculoDTO {

    private Long id;
    private CargoDTO cargo;
    private FuncionarioDTO funcionario;

    public PerfilVinculoDTO(PerfilVinculoEntity perfilVinculo) {
        BeanUtils.copyProperties(perfilVinculo, this);
        if(perfilVinculo != null && perfilVinculo.getCargo() != null) {
            this.cargo = new CargoDTO(perfilVinculo.getCargo());
        }
        if(perfilVinculo != null && perfilVinculo.getFuncionario() != null) {
            this.funcionario  = new FuncionarioDTO(perfilVinculo.getFuncionario());
        }
    }
}
