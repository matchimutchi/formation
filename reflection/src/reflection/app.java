package reflection;



import reflection.metier.Livre;
import reflection.metier.Produit;
import reflection.util.SuperPromptor;

public class app {

	public static void main(String[] args) {
		
		SuperPromptor<Livre> sp = new SuperPromptor<>(Livre.class);
		Livre l1 = sp.saisie();
		System.out.println(l1);
		
		SuperPromptor<Produit> sp2 = new SuperPromptor<>(Produit.class);
		Produit p1 = sp2.saisie();
		System.out.println(p1);
		
		
		/*String nomClasse = "";
		Scanner input = new Scanner(System.in);
		System.out.println("Entrez un nom de classe pleinement qualifié");
		nomClasse = input.nextLine();
		
		try {
			Class classe = Class.forName(nomClasse);
			System.out.println("nom de la classe " + classe.getName());
			//getMethods renvoie les méthodes public
			Method[] methodes = classe.getMethods();
			System.out.println("Méthodes publiques de la classe");
			for(Method m : methodes) {
				System.out.println(m.getReturnType().getSimpleName() + " " + m.getName() +"( "+ Arrays.toString(m.getParameterTypes())+ ")");
			}
			
			System.out.println("Propriété privée de la Classe");
			Field[] fields = classe.getDeclaredFields();
			for(Field f : fields) {
				System.out.println(f.getName() + " " + f.getType().getSimpleName());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		


	}

}
