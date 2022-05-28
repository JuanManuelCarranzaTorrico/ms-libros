package bo.edu.ucb.mslibros.API;

import bo.edu.ucb.mslibros.bl.LibroBl;
import bo.edu.ucb.mslibros.dto.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibroApi {
    LibroBl libroBl;
    @Autowired

    public LibroApi(LibroBl libroBl) {
        this.libroBl = libroBl;
    }
    @PostMapping(value = "/libro",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public void ChangeState(@RequestBody Libro libro){
        libroBl.ChangeState(libro.getIdLibro(),libro.getEstado());
    }
    @GetMapping(value = "/libro")
    public List<Libro>ListLibros(){
        return libroBl.GetLibros();
    }
}
