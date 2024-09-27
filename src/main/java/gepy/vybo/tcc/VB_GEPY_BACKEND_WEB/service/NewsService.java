package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.NewsDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.NewsEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public List<NewsDTO> listarTodos(){
        List<NewsEntity> news = newsRepository.findAll();
        return news.stream().map(NewsDTO::new).toList();
    }

    public void inserir(NewsDTO news){
        NewsEntity newsEntity = new NewsEntity(news);
        newsRepository.save(newsEntity);
    }

    public NewsDTO alterar(NewsDTO news){
        NewsEntity newsEntity = new NewsEntity(news);
        return new NewsDTO(newsRepository.save(newsEntity));
    }

    public void excluir(Long id){
        NewsEntity news = newsRepository.findById(id).get();
        newsRepository.delete(news);
    }
}
