package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.NewsDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.NewsEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public List<NewsDTO> listarTodos(){
        List<NewsEntity> news = newsRepository.findAllOrderedById();
        return news.stream().map(NewsDTO::new).toList();
    }

    public ResponseEntity<Map<String, String>> inserir(NewsDTO news){
        NewsEntity newsEntity = new NewsEntity(news);
        Map<String, String> response = new HashMap<>();
        try {
            newsRepository.save(newsEntity);
            response.put("message", "Notícia postada com sucesso!!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao postar notícia!!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> alterar(NewsDTO news){
        NewsEntity newsEntity = new NewsEntity(news);
        Map<String, String> response = new HashMap<>();
        try{
            newsRepository.save(newsEntity);
            response.put("message", "Notícia editada com sucesso!!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao editar notícia!!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> excluir(Long id){
        NewsEntity news = newsRepository.findById(id).get();
        Map<String, String> response = new HashMap<>();
        try {
            newsRepository.delete(news);
            response.put("message", "Notícia deletada com sucesso!!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao deletar notícia!!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
