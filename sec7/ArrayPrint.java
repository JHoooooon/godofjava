class ArrayPrint {
  public static void main(String[] args) {
    ArrayPrint ap = new ArrayPrint();
    ap.init();
    ap.primitiveTypeInit();
  }

  public void init() {
    System.out.println(new String[0]);
    System.out.println(new ArrayPrint[0]);
  }

  public void primitiveTypeInit() {
    System.out.println(new byte[0]);
    System.out.println(new short[0]);
    System.out.println(new int[0]);
    System.out.println(new long[0]);
    System.out.println(new float[0]);
    System.out.println(new double[0]);
    System.out.println(new char[0]);
    System.out.println(new boolean[0]);

    int [][] twoDim = {{1, 2, 3}, {4, 5, 6}};
    int twoDimIdx = 0; 
    for (int[] dim: twoDim) {
        int dimIdx = 0;
        for (int data: dim) {
            System.out.println(twoDimIdx +" "+ dimIdx + " "+ data);
            dimIdx += 1;
        }
        twoDimIdx += 1;
    }

  }
}
