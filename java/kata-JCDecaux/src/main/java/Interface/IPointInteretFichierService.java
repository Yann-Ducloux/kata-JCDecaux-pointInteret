package Interface;

import model.PointInteret;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IPointInteretFichierService {
    List<PointInteret> recuperer(MultipartFile multipartFile);
}
