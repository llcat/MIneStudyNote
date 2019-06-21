package tech.llcat.tij.ch21;

public class Atomicity {
    int i;
    void f0(){ i=1; }
    void f1(){ i++; }
    void f2(){ i+=3; }
    /*
    *  void f0();
    Code:
       0: aload_0
       1: iconst_1
       2: putfield      #2                  // Field i:I
       5: return

  void f1();
    Code:
       0: aload_0
       1: dup
       2: getfield      #2                  // Field i:I
       5: iconst_1
       6: iadd
       7: putfield      #2                  // Field i:I
      10: return

  void f2();
    Code:
       0: aload_0
       1: dup
       2: getfield      #2                  // Field i:I
       5: iconst_3
       6: iadd
       7: putfield      #2                  // Field i:I
      10: return

    * */
}
