class ArrayLotto {
  public static void main(String [] args) {
    ArrayLotto arrayLotto = new ArrayLotto();
    arrayLotto.init(); 
  }

  public void init() {
    byte [] b = new byte [2];
    short [] s = new short [2];
    int [] i = new int [2];
    long [] l = new long [2];
    float [] f = new float [2];
    double [] d = new double [2];
    char [] c = new char [2];

    System.out.println(b[0]); // 0
    System.out.println(s[0]); // 0
    System.out.println(i[0]); // 0
    System.out.println(l[0]); // 0
    System.out.println(f[0]); // 0.0
    System.out.println(d[0]); // 0.0
    System.out.println(c[0]); // " "
    System.out.println(b[1]); // 1
    System.out.println(s[1]); // 1
    System.out.println(i[1]); // 1
    System.out.println(l[1]); // 1
    System.out.println(f[1]); // 1.1
    System.out.println(d[1]); // 1.1
    System.out.println(c[1]); // " "
//    int [] lottoNumbers = new int[7];
//    lottoNumbers [0] = 5;
//    lottoNumbers [1] = 12;
//    lottoNumbers [2] = 23;
//    lottoNumbers [3] = 25;
//    lottoNumbers [4] = 38;
//    lottoNumbers [5] = 41;
//    lottoNumbers [6] = 2;
//    lottoNumbers [7] = 9;
  }
}
