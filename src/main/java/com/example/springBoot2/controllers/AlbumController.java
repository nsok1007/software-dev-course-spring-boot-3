package com.example.springBoot2.controllers;

import com.example.springBoot2.Repositories.AlbumRepository;
import com.example.springBoot2.models.Album;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @GetMapping
    public List<Album> getAllItems(){
        return albumRepository.findAll();
    }

    @GetMapping("/{id}") // inherits the base URL from @RequestMapping
    public Album getItem(@PathVariable int id){
        return albumRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Album addItem(@RequestBody Album album){
        return albumRepository.save(album);
    }

    @PutMapping("/{id}") // inherits the base URL from @RequestMapping
    public Album updateItem(@PathVariable int id, @RequestBody Album album){
        return albumRepository.save(album);
    }

    @DeleteMapping("/{id}") // inherits the base URL from @RequestMapping
    public void deleteItem(@PathVariable int id){
        albumRepository.deleteById(id);
    }
}
