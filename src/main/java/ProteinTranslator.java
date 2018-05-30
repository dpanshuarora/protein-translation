import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class ProteinTranslator {
  public static final int CODON_LENGTH = 3;
  public static HashMap<String, String> codonToProtein = new HashMap<String, String> ();
  static {
    codonToProtein.put("AUG", "Methionine");
    codonToProtein.put("UUU", "Phenylalanine");
    codonToProtein.put("UUC", "Phenylalanine");
    codonToProtein.put("UUA", "Leucine");
    codonToProtein.put("UUG", "Leucine");
    codonToProtein.put("UCU", "Serine");
    codonToProtein.put("UCC", "Serine");
    codonToProtein.put("UCA", "Serine");
    codonToProtein.put("UCG", "Serine");
    codonToProtein.put("UAU", "Tyrosine");
    codonToProtein.put("UAC", "Tyrosine");
    codonToProtein.put("UGU", "Cysteine");
    codonToProtein.put("UGC", "Cysteine");
    codonToProtein.put("UGG", "Tryptophan");
    codonToProtein.put("UAA", "STOP");
    codonToProtein.put("UAG", "STOP");
    codonToProtein.put("UGA", "STOP");
  }

  public List<String> translate(String rnaSequence) {
    List<String> proteinsList = new ArrayList<String>();
    for(int startIndex = 0, endIndex = CODON_LENGTH; endIndex <= rnaSequence.length(); startIndex += CODON_LENGTH, endIndex += CODON_LENGTH) {
      String codon = rnaSequence.substring(startIndex, endIndex);
      String protein = codonToProtein.get(codon);
      try {
        proteinCheck(protein);
      } catch (UnsupportedOperationException e) {
        System.out.println(e.getMessage());
        break;
      }

      proteinsList.add(protein);
    }

    return proteinsList;
  }

  private void proteinCheck(String protein) throws UnsupportedOperationException {
    if("STOP".equals(protein)) {
      throw new UnsupportedOperationException("Encoutered a STOP Codon");
    }
    if(protein == null) {
      throw new UnsupportedOperationException("Invalid Codon");
    }
  }
}