package fs;

import java.util.function.Consumer;

public class File {

  private final int descriptor;
  private final LowLevelFileSystem lowLevelFileSystem;

  public File(int descriptor, LowLevelFileSystem lowLevelFileSystem) {
    this.descriptor = descriptor;
    this.lowLevelFileSystem = lowLevelFileSystem;
  }

  public int getDescriptor() {
    return this.descriptor;
  }

  public void read(Buffer buffer) {
    int readBytes = this.lowLevelFileSystem.syncReadFile(
        this.descriptor, buffer.getBytes(), buffer.getStart(), buffer.getEnd());
    validarLecturaDeArchivo(readBytes);
    buffer.limit(readBytes);
  }

  public void close() {
    this.lowLevelFileSystem.closeFile(this.descriptor);
  }

  public void write(Buffer buffer) {
    this.lowLevelFileSystem.syncWriteFile(
        this.descriptor, buffer.getBytes(), buffer.getStart(), buffer.getEnd());
  }

  public void asyncRead(Buffer buffer, Consumer<Integer> callback) {
    this.lowLevelFileSystem.asyncReadFile(
        this.descriptor, buffer.getBytes(), buffer.getStart(), buffer.getEnd(), readBytes -> {
          validarLecturaDeArchivo(readBytes);
          buffer.limit(readBytes);
          callback.accept(readBytes);
        });
  }

  public void asyncWrite(Buffer buffer, Runnable callback) {
    this.lowLevelFileSystem.asyncWriteFile(
        this.descriptor, buffer.getBytes(), buffer.getStart(), buffer.getEnd(), callback);
  }

  private void validarLecturaDeArchivo(int readBytes) {
    if (readBytes == -1) {
      throw new CanNotReadFileException();
    }
  }
}
