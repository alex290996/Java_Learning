/**Класс реализован по методу KISS-keep it simple and short. Код должен быть простым и коротким.
**/
public class SqMax {
    public static int max(int left, int right) {
        return left > right ? left : right;
    }

    public static int max(int first, int second, int third, int forth) {
        return max(
                max(first, second),
                max(third, forth)
        );
    }
}
/** без использования метода KISS
public class SqMax {
    public static int max(int first, int second, int third, int forth) {
        int result = forth;
        if (first > second) {
            if (first > third) {
                if (first > forth) {
                    result = third;
                }
            }
        } else if (second > third) {
            if (second > forth) {
                result = first;
            }
        } else if (third > forth) {
            result = second;
        }
        return result;
    }
}**/

/**DRY - don't repeat yourselft.
 Дословно "не повторяй себя".
 Противоположность этому принципу - copypaste.
 То есть, старайтесь использовать уже существующие методы, чтобы решить новую задачу.
 Не копируйте код.

 YAGNI - You aren't going need it.
 Принцип пересекается со втором.
 Подумайте, стоит ли создавать новый метод.
 Можно ли решить задачу уже существующими методами.

 Без YAGNI
 public class Search {
 static List<File> findByMask(String mask) {
 List<File> rsl = new ArrayList<>();
 for (File file : ..) {
 if (Pattern.matches(mask, file.getName())) {
 rsl.add(file);
 }
 }
 return rsl;
 }

 static List<File> findByName(String name) {
 List<File> rsl = new ArrayList<>();
 for (File file : ..) {
 if (name.equals(file.getName())) {
 rsl.add(file);
 }
 }
 return rsl;
 }

 static List<File> findByExt(String ext) {
 List<File> rsl = new ArrayList<>();
 for (File file : ..) {
 if (file.getName().endWiths(ext)) {
 rsl.add(file);
 }
 }
 return rsl;
 }
 }

 С методом YAGNI
 public class Search {

 static List<File> findBy(Predicate<File> predicate) {
 List<File> rsl = new ArrayList<>();
 for (File file : ..) {
 if (predicate.test(file)) {
 rsl.add(file);
 }
 }
 return rsl;
 }
 static List<File> findByMask(String mask) {
 return findBy(file -> Pattern.matches(mask, file.getName()));
 }

 static List<File> findByName(String name) {
 return findBy(file -> file.getName().equals(name));
 }

 static List<File> findByExt(String ext) {
 return findBy(file -> file.getName().endsWith(ext));
 }
 }
 **/