package py.edu.facitec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Post;
import py.edu.facitec.repository.PostRepository;

@RestController

@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostRepository postRepository;

	@GetMapping // Responderá al verbo GET
	public ResponseEntity<List<Post>> getAll() {
		// realizamos la consulta y cargamos el objeto posts
		List<Post> posts = postRepository.findAll();
		// retornamos la lista con el status

		return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
	}
	// indicar que los datos viajan dentro del request

	// datos que vienen del cliente EN EL OBJETO REQUEST
	@PostMapping
	public ResponseEntity<Post> create(@RequestBody Post postLlega) {
		try {

			Post postRetorno = postRepository.save(postLlega);
			System.out.println(postRetorno.toString());

			return new ResponseEntity<Post>(postRetorno, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}

	// reccibimos el codigo
	@GetMapping(value = "/{codigo}") // cargamos la variable
	public ResponseEntity<Post> getOne(@PathVariable Long codigo) {
		// consulta por codigo
		Optional<Post> postConsulta = postRepository.findById(codigo);

		if (postConsulta.isPresent()) {
			return new ResponseEntity<Post>(postConsulta.get(), HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<Post> deleteById(@PathVariable Long codigo) {
		//logica para eliminar a traves de una tabla precargada
		try {
			postRepository.deleteById(codigo);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

}
