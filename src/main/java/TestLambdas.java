/**
 * Created by fanghuicheng on 2019-06-09 13:42
 */
public class TestLambdas {

    public static void main(String[] args){

    }

//    void passMeALambda(() -> System.out.println("Lambda called"));

    @FunctionalInterface
    interface Foo1 {
        void bar(String str);
    }

    Foo1 f = x->System.out.println("cc");

    interface Foo2 {
        int bar(boolean baz);
    }

    Foo2 np = x -> ( x ? 1 : 0 ); // okay

    interface Foo3 {
        String bar(Object baz, int mink);
    }

    interface Foo4 {
        String bar() ;
        void quux();
    }

    interface BlankFoo1 extends Foo3 { // inherits abstract method from Foo3
    }

    interface BadFoo {
        void bar();
        void quux(); // <-- Second method prevents lambda: which one should be considered as lambda?
    }

}
