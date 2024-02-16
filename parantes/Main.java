package parantes;
import parantes.ParantesSjekker;
public class Main {

	public static void main(String[] args) {
		String javaprogram="(([å])l)";
		ParantesSjekker s = new ParantesSjekker();
		System.out.println(s.sjekkParenteser(javaprogram));
	}

}
