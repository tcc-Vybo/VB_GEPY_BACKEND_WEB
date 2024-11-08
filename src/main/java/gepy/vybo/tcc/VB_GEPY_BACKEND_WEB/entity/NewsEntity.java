package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.NewsDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "news")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class NewsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String titulo;

    @NotBlank
    @Column(nullable = false)
    private String subtitulo;

    @NotBlank
    @Column(nullable = false)
    private String texto;

    @NotBlank
    @Column(nullable = false)
    private String imagemUrl;

    public NewsEntity(NewsDTO news){
        BeanUtils.copyProperties(news, this);
    }

}
