package fs;

public class Buffer {

  private final byte[] bytes;
  private final int start;
  private int end;

  public Buffer(int size) {
    this.bytes = new byte[size];
    this.start = 0;
    this.end = size - 1;
  }

  public byte[] getBytes() {
    return this.bytes;
  }

  public int getStart() {
    return this.start;
  }

  public int getEnd() {
    return this.end;
  }

  public void limit(int limit) {
    this.end = this.start + limit - 1;
  }

  public int getCurrentSize() {
    return this.end + 1;
  }

  public int getMaxSize() {
    return this.bytes.length;
  }

}
