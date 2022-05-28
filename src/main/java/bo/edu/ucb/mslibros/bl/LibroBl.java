package bo.edu.ucb.mslibros.bl;
import bo.edu.ucb.mslibros.dto.Libro;
import bo.edu.ucb.mslibros.dao.LibroDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class LibroBl {
    private final LibroDao libroDao;
    @Autowired
    public LibroBl(LibroDao libroDao) {
        this.libroDao = libroDao;
    }
    public List<Libro> GetLibros(){
        return libroDao.ListLibros();
    }
    public void ChangeState(int idLibro, int Estado){
        libroDao.ChangeState(idLibro,Estado);
    }
}
