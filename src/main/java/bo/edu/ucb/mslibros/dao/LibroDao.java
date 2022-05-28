package bo.edu.ucb.mslibros.dao;

import bo.edu.ucb.mslibros.dto.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class LibroDao {
    private DataSource dataSource;
    @Autowired
    public LibroDao(DataSource dataSource){
        this.dataSource=dataSource;
    }
    public List<Libro> ListLibros() {
        List<Libro> result = new ArrayList<>();
        String query = "SELECT * FROM Libro;";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Libro libro = new Libro();
                libro.setIdLibro(rs.getInt("idLibro"));
                libro.setTitulo(rs.getString("Titulo"));
                libro.setAutor(rs.getString("Autor"));
                libro.setPublicacion(rs.getInt("Publicacion"));
                libro.setEstado(rs.getInt("Estado"));
                result.add(libro);
            }
            System.out.println(result);
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public void ChangeState(int idLibro, int Estado){
        String query="UPDATE Libro "+
                "SET Estado = (?) "+
                "WHERE idLibro = (?);";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                ){
            pstmt.setInt(1,Estado);
            pstmt.setInt(2,idLibro);
            pstmt.executeUpdate();
            System.out.println("Actualizado");
        } catch (SQLException throwables) {
            System.out.println("No se logro :(");
            throwables.printStackTrace();
        }

    }

}
