import java.io.Serializable;

//Serializable - интерфейс через который можно сохранять созданный объект в файл и также его выгрузить.
//transient - не сохраняется в файл и принимает стандартное значение Null, полезно для наследованных объектов.
public class User implements Serializable {
    int lifelevel;
    transient int ret;
}
