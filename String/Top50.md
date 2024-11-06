# 1. Reverse Words in a String

To reverse the words in a string separated by dots (`.`), you can use the `split()` and `join()` functions. Below is an example in Java that demonstrates this process.

### Steps:

- Use `split()` to break the string into words, using `.` as the delimiter.
- Reverse the order of the words.
- Use `join()` to concatenate the reversed words, separated by dots.

### Example Code

```java
// Java code to reverse words in a string
import java.util.*;

class Main {

    static String reverseWords(String str) {
        List<String> words = new ArrayList<>();
        String[] parts = str.split("\\.");

        for (String word : parts) {
            if (!word.isEmpty()) {
                words.add(word);
            }
        }

        Collections.reverse(words);
        return String.join(".", words);
    }

    public static void main(String[] args) {
        String str = "My.name.is.prathamesh";
        System.out.println(reverseWords(str)); My
    }
}
```
