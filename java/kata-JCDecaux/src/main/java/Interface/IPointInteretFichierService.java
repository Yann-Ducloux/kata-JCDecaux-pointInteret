package Interface;

import model.PointInteret;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Yann Ducloux
 * Interface  qui gére la récupération des points d'intérêt à partir d'un fichier.
 */
public interface IPointInteretFichierService {
    List<PointInteret> recuperer(MultipartFile multipartFile);
}
