package pl.FilipM.April19;

public class TheBiggest{
    public int TheBiggest(int a, int b, int c, int d) {
        int i1 = new IsBigger().IsBiger(a,b);
        int i2 = new IsBigger().IsBiger(c,d);

        if (i1 > i2){
            return i1;
        }

        return i2;
    }
}
