import java.io.*;
//Serializable - интерфейс через который можно сохранять созданный объект в файл и также его выгрузить.
/*Если наследоваться от класса который не использует интерфейс serializable, то все его поля будут как transient (пустые).
 */
class SerializableTest {
    public static void main (String args[]) throws IOException, ClassNotFoundException {
        User user = new User();
        user.lifelevel = 55;
        user.ret = 4;

        //FileOutputStream - создает файл для записи объекта
        //ObjectOutputStream - приводит сам файл к виду объека и дальше записывает
        FileOutputStream fileOutputStream = new FileOutputStream("tempFile");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user);
        objectOutputStream.close();

        //FileInputStream - принимает файл для чтения объекта
        FileInputStream fileInputStream = new FileInputStream("tempfile");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        User newUser = (User) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(newUser.lifelevel);
        System.out.println(newUser.ret);

    }
}

