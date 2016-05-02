import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Reader;

class SolutionIter implements Iterable<Integer> {

  private ArrayList<Integer> values = new ArrayList<>();

  public SolutionIter(Reader inp) {

    String element = "";
    int character;
    try {
      while (((character = inp.read()) != -1)) {
        char c = (char) character;

        if (c != '\n' && c != 'r') {
          element += Character.toString(c);
        } else {
          element = element.trim();
          if (element.matches("^(\\-|\\+)?\\d+$")) {
            try {
              BigInteger i = i.add(BigInteger.valueOf(Long.parseLong(element)));
              values.add(i);
            } catch (NumberFormatException e) {
              // Just keep going...
            }
          }
          element = "";
        }
      }
    } catch (IOException e) {
      // Do nothing for now
    }

  }

  public Iterator<Integer> iterator() {
    return values.iterator();
  }

}
