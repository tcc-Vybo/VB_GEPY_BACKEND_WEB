package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.NewsEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class NewsDTO {

    private Long id;
    private String titulo;
    private String subtitulo;
    private String texto;
    private String imagemUrl;

    public NewsDTO(NewsEntity news){
        BeanUtils.copyProperties(news,this);
    }

}
