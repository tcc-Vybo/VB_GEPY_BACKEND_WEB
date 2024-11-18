package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.CargoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class CargoDTO {

    private Long id;
    private String nome;

    public CargoDTO(CargoEntity cargo) {
        BeanUtils.copyProperties(cargo, this);
    }
}
