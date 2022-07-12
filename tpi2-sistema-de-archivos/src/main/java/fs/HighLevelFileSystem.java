package fs;

public class HighLevelFileSystem {

  private final LowLevelFileSystem lowLevelFileSystem;

  public HighLevelFileSystem(LowLevelFileSystem lowLevelFileSystem) {
    this.lowLevelFileSystem = lowLevelFileSystem;
  }

  public File open(String path) {
    int fileDescriptor = this.lowLevelFileSystem.openFile(path);

    validarAperturaDeArchivo(fileDescriptor);
    return new File(fileDescriptor, this.lowLevelFileSystem);
  }

  private void validarAperturaDeArchivo(int fd) {
    if (fd == -1) {
      throw new CanNotOpenFileException();
    }
  }

}
