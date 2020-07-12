import java.lang.annotation.*;
import java.lang.reflect.*;
// Маркерная аннотация
    @Retention(RetentionPolicy.RUNTIME)
    @interface MyMarker { }
    class Marker {
// аннотировать метод с помощью маркера
// Обратите внимание на обязательность скобок ()
    @MyMarker
    public static void myMeth(){
    Marker оЬ = new Marker();
    try {
        Method m = оЬ.getClass().getMethod("myMeth") ;
        // определить наличие аннотации
        if(m.isAnnotationPresent(MyMarker.class))
            System.out.println("Маркерная аннотация MyMarker присутствует.");}
        catch (NoSuchMethodException exc) {
            System.out.println("Meтoд не найден.");}}

            public static void main(String args[]) {
                myMeth();
            }}