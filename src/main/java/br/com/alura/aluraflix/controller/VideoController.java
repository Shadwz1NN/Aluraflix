package br.com.alura.aluraflix.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.aluraflix.model.Video;
import br.com.alura.aluraflix.repository.VideoRepository;



@RestController
@RequestMapping("videos")
public class VideoController {
	
	@Autowired
	private VideoRepository videoRepository;
	
	@GetMapping("/listar")
	public Page<Video> listar(Pageable paginacao){
		 Page<Video> listaDeCursos = videoRepository.findAll(paginacao);
		 return listaDeCursos;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Video>> obter(@PathVariable Long id){
		Optional<Video> videoProcurado =  videoRepository.findById(id);
		if(videoProcurado.isPresent()) {
			return ResponseEntity.ok(videoProcurado);
		}
		return new ResponseEntity("Nao encontrado", HttpStatus.BAD_REQUEST);
	}
	@Transactional
	@PostMapping("/cadastrar")
	public ResponseEntity<Video> cadastrar(@RequestBody @Valid Video video){
		
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/videos/{id}").buildAndExpand(video.getId()).toUri();
		video.setUrl(uri.toString());
		videoRepository.save(video);
		return ResponseEntity.created(uri).build();
	}
	@Transactional
	@PutMapping("/atualizar")
	public ResponseEntity<Video> updateVideo(@RequestBody Video video) {
		//Quando for update, precisa passar o ID no body do postman. 
				Video updatedVideo = videoRepository.save(video);
				return ResponseEntity.ok(updatedVideo);

	}
	@Transactional
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteVideo(@PathVariable Long id){
		videoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}	
