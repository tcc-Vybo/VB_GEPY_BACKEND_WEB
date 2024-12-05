package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.VinculoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class VinculoDTO {

    private Long id;
    private FuncionarioDTO funcionario;
    private CargoDTO cargo;

    public VinculoDTO(VinculoEntity vinculo) {
        BeanUtils.copyProperties(vinculo, this);
        if(vinculo != null && vinculo.getFuncionario() != null) {
            this.funcionario = new FuncionarioDTO(vinculo.getFuncionario());
        }
        if(vinculo != null && vinculo.getCargo() != null) {
            this.cargo = new CargoDTO(vinculo.getCargo());
        }
    }
}
