import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Book {
    String autor;
    String name;
}
//HashMap принимает первую строку по которой будет искать (ключ), а второй аргумент сам объект
//hashCode создает сам хеш-код для объекта
//put - записывает значение в HashMap, get - получате объект по ключу.
class Ticket{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return number == ticket.number &&
                libraryName.equals(ticket.libraryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, libraryName);
    }

    int number;
    String libraryName;
}
class Hash {
    public static void main(String args[]) {
        Book newBook = new Book();
        newBook.autor = "Karnigy";
        newBook.name = "how to get friends";
        Ticket ticket = new Ticket();
        ticket.number = 1234;
        ticket.libraryName = "1234";
        Map <Ticket, Book> library = new HashMap<>();
        library.put(ticket, newBook);

        Ticket ticket2 = new Ticket();
        ticket2.number = 1234;
        ticket2.libraryName = "1234";

        Book KarnigyBook = library.get(ticket2);
        System.out.println(KarnigyBook.autor);

        //System.out.println(newBook.hashCode());
       // System.out.println(new Book().hashCode());
    }
}