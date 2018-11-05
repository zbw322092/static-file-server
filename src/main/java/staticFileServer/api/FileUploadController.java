package staticFileServer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import staticFileServer.common.ServerResponse;
import staticFileServer.exception.ResourceNotFoundException;
import staticFileServer.service.StorageService;

@RestController
public class FileUploadController extends BaseRestController {

  private final StorageService storageService;

  @Autowired
  public FileUploadController(StorageService storageService) {
    this.storageService = storageService;
  }

  @RequestMapping(path = "/upload_static", method = { RequestMethod.POST, RequestMethod.PUT })
  @ResponseStatus(HttpStatus.OK)
  public ServerResponse storeFiles(@RequestParam("path") String path, @RequestParam("file") MultipartFile file) {

    logger.info("get file " + file.getOriginalFilename());

    storageService.store(path, file);

    return ServerResponse.createBySuccessMessage("file upload success");
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException ex) {
    return ResponseEntity.notFound().build();
  }
}
