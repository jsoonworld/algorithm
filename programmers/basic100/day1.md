
# 챙겨야 하는 함수 List

```java
// StringBuilder를 사용하여 문자열을 효율적으로 생성하고 수정합니다.
StringBuilder sb = new StringBuilder();

// 문자열 추가 예시: StringBuilder에 문자열을 추가합니다.
sb.append(str); 

// StringBuilder 내용을 문자열로 변환합니다.
String result = sb.toString();

// 문자의 대소문자를 변환합니다: 대문자는 소문자로, 소문자는 대문자로 변환합니다.
if(Character.isUpperCase(currentChar)){
    output.append(Character.toLowerCase(currentChar));
} else{
    output.append(Character.toUpperCase(currentChar));
}

// ASCII 값을 사용하여 대문자를 소문자로 변환하는 예시입니다.
if (currentChar >= 'A' && currentChar <= 'Z') {
    output.append((char) (currentChar + 32));
}

// 특수 문자를 이스케이프하여 출력하는 방법입니다.
// 주어진 문자열에 역슬래시와 쌍따옴표가 포함되어 있으므로, 이들을 이스케이프 처리합니다.
System.out.println("!@#$%^&*(\\'\"<>?:;");

// 문자열의 특정 부분을 다른 문자열로 덮어쓰는 예시입니다.
// overwrite_string의 각 문자를 순회하며 my_string의 지정된 위치에 덮어씁니다.
for (int i = 0; i < overwrite_string.length(); i++) {
    sb.setCharAt(s + i, overwrite_string.charAt(i));
}
```


# 1.  문자열 출력하기

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(str);
    }
}
```

# 2.  a와 b 출력하기

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("a " + "= " + a);
        System.out.println("b " + "= " + b);
    }
}
```

# 3. 문자열 반복해서 출력하기

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            System.out.print(str);
        }
    }
}
```


```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        
        StringBuilder sb = new StringBuilder(); // 문자열을 효율적으로 결합하기 위해StringBuilder 사용
        for(int i = 0; i < n; i++){
            sb.append(str); // 주어진 문자열을 n번 반복하여 추가
        }
        
        System.out.println(sb.toString()); // 최종 문자열 한 번에 출력

        // 주의: System.in을 사용하는 Scanner는 프로그램의 다른 부분에서 입력을 계속 받아야 하는 경우 닫지 않는 것이 좋습니다.
    }
}
```


# 4.  대소문자 바꿔서 출력하기

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next(); // 사용자로부터 문자열 입력 받음
        StringBuilder output = new StringBuilder(); // 변환된 문자를 저장할 StringBuilder

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i); // 현재 문자 가져오기
            // 대문자인 경우 소문자로 변환
            if (currentChar >= 'A' && currentChar <= 'Z') {
                output.append((char) (currentChar + 32));
            }
            // 소문자인 경우 대문자로 변환
            else if (currentChar >= 'a' && currentChar <= 'z') {
                output.append((char) (currentChar - 32));
            }
        }
        System.out.println(output.toString()); // 변환된 문자열 출력
    }
}
```




```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        StringBuilder output = new StringBuilder();
        
        
        for(int i = 0; i < input.length(); i++){
            char currentChar = input.charAt(i);
            
            if(Character.isUpperCase(currentChar)){
                output.append(Character.toLowerCase(currentChar));
            } else{
                output.append(Character.toUpperCase(currentChar));
            }
        }
        System.out.print(output);
    }
}
```


# 5.  툭수문자 출력하기

```java
public class Main {
    public static void main(String[] args) {
        // 주어진 문자열에는 역슬래시와 쌍따옴표가 포함되어 있으므로, 이들을 이스케이프합니다.
        System.out.println("!@#$%^&*(\\'\"<>?:;");
    }
}
```

자바에서 주어진 문자열을 그대로 출력하는 것은 매우 간단합니다. 특수 문자들 중에는 자바에서 문자열 내에서 특별한 의미를 가지는 이스케이프 시퀀스(예: `\n`은 줄바꿈, `\"`는 쌍따옴표 문자를 나타냄)가 있으므로, 이러한 문자를 출력하려면 이스케이프 문자를 사용해야 합니다. 예를 들어, 쌍따옴표(`"`)와 역슬래시(`\`)를 출력하려면 각각 `\"`와 `\\`를 사용해야 합니다.


# 6.  덧셈식 출력하기

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a + " + " + b + " = " + (a+b));
    }
}
```

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // String.format을 사용하여 문자열을 포맷팅하고 출력합니다.
        System.out.println(String.format("%d + %d = %d", a, b, a+b));

        // System.in을 사용하는 Scanner는 여기서 닫지 않습니다.
    }
}
```


```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.printf("%d + %d = %d",a,b,a+b);
    }
}
```


# 7.  문자열 붙여서 출력하기

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.print(a + b);
    }
}
```

# 8.  문자열 돌리기

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        for(int i = 0; i < input.length(); i++){
            System.out.println(input.charAt(i));
        }
    }
}
```

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        // 문자열 연결을 명시적으로 보여주고 출력합니다.
        String concatenated = a + b;
        System.out.print(concatenated);

        // System.in을 사용하는 Scanner는 여기서 닫지 않습니다.
    }
}
```

# 9.  홀짝 구분하기

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n % 2 == 0){
            System.out.print(n + " is " + "even");
        } else{
            System.out.print(n + " is " + "odd");
        }
    }
}
```


# 10. 문자열 겹쳐쓰기

```java
public class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        // StringBuilder를 사용하여 my_string을 수정 가능한 형태로 변환합니다.
        StringBuilder sb = new StringBuilder(my_string);
        
        // overwrite_string의 각 문자를 순회하며 my_string의 해당 위치에 덮어씁니다.
        for (int i = 0; i < overwrite_string.length(); i++) {
            sb.setCharAt(s + i, overwrite_string.charAt(i));
        }
        
        // 수정된 StringBuilder 객체를 문자열로 변환하여 반환합니다.
        return sb.toString();
    }
}
```


```java
public class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        // my_string의 s 인덱스 이전 부분을 잘라냅니다.
        String prefix = my_string.substring(0, s);
        
        // my_string에서 overwrite_string을 삽입할 위치 이후의 부분을 잘라냅니다.
        String suffix = my_string.substring(s + overwrite_string.length());
        
        // 잘라낸 부분 사이에 overwrite_string을 삽입하여 새로운 문자열을 생성합니다.
        return prefix + overwrite_string + suffix;
    }
}
```
