package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.NewsDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@CrossOrigin
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping
    public List<NewsDTO> listarTodos(){
        return newsService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody NewsDTO news){
        newsService.inserir(news);
    }

    @PutMapping
    public NewsDTO alterar(@RequestBody NewsDTO news){
        return newsService.alterar(news);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        newsService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
