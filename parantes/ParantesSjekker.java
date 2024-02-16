package parantes;

public class ParantesSjekker {
	
	public boolean sjekkParenteser(String s) {
		char[] text=s.toCharArray();
		NoderStabel<Character> sjekker = new NoderStabel<>();
		
		for (int i = 0; i<text.length; i++) {
			if (erStartParentes(text[i]))
				sjekker.push(text[i]);
			if(erSluttParentes(text[i])) {
				if (!sjekker.isEmpty() && erParentesPar(sjekker.peek(),text[i])) {
					sjekker.pop();
				}else {
					return false;
				}
			}
		}
		return sjekker.isEmpty();
	}

	public boolean erStartParentes(char c) {
		if (c=='('||c=='['||c=='{')
			return true;
		return false;
	}
	
	public boolean erSluttParentes(char c) {
		if (c==')'||c==']'||c=='}')
			return true;
		return false;
	}
	
	public boolean erParentesPar(char start, char slutt) {
		if ((start=='('&&slutt==')')||(start=='['&&slutt==']')||(start=='{'&&slutt=='}'))
			return true;
		return false;
	}

}
