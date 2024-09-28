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
    public void checkotherTypes() {
        short shortMax = 23767;
        int intMax = 2147483647;
        long longMax = 922337203685477807L;
    }
}
