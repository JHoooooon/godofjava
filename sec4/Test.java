public class PrimitiveTypes {
    public static void main(String[] args) {
        PrimitiveTypes pt = new PrimitiveTypes();
        pt.checkByte();
    }
    public void checkByte() {
        byte byteMin = (byte)(-128 - 1);
        byte byteMax = (byte)(127 + 1 );
        System.out.println(byteMin);
        System.out.println(byteMax);
    }
}
