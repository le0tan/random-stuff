import java.util.*;


public class Main {
  
  private static int calc(String str) {
    HashMap<Character, Integer> last = new HashMap<>();
    char[] a = new char[str.length()];
    for(int i=0;i<str.length();i++) {
      a[i] = str.charAt(i);
      last.put(a[i], i);
    }
    List<Stack<Character>> stacks = new ArrayList<>();
    stacks.add(new Stack<>());
    for(int i=0;i<str.length();i++) {
      boolean ok = false;
      for(Stack<Character> s: stacks) {
        if(s.isEmpty()) {
          s.push(a[i]);
          ok = true;
          break;
        } else if(s.peek() == a[i]) {
          s.push(a[i]);
          ok = true;
          break;
        } else if(a[i] < s.peek() ) {
          s.push(a[i]);
          ok = true;
          break;
        } else continue;
      }
      if(ok) continue;
      else {
        Stack<Character> t = new Stack<>();
        t.push(a[i]);
        stacks.add(t);
      }
    }
    return stacks.size();
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int T = 0;
    while(true) {
      String s = sc.next();
      if(s.equals("end")) break;
      else System.out.printf("Case %d: %d\n", ++T, calc(s));
    }
  }
}
