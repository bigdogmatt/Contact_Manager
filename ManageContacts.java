import java.util.Scanner;

public class ManageContacts {

	public static void main(String[] args) {	
		String name;
		String email;
		int age;
		Contacts contacts = new Contacts();
		String found;
		char choice;
		Scanner in = new Scanner(System.in);

		do {
			choice = menu(in);
			switch( choice ) {
				case 'A': 
					System.out.print("\tEnter name: ");
					name = in.nextLine();
					System.out.print("\tEnter e-mail: ");
					email = in.nextLine();
					System.out.print("\tEnter age: ");
					age = in.nextInt();
					in.nextLine();
					contacts.add(name, email, age);
					break;
				case 'F':
					System.out.print("\tEnter name: ");
					name = in.nextLine();
					found = contacts.find( name );
					if( found == null )
						System.out.println("\t\"" + name + "\" not found");
					else 
						System.out.println( found );
					break;
				case 'P':
					contacts.print();
					break;
			}	
			
			System.out.println();
		} while( choice != 'Q' );
	}

	private static char menu(Scanner in) {  
		// print menu  
		System.out.println("A - Add a contact");
		System.out.println("F - Find and display a contact");
		System.out.println("P - Print contact list");
		System.out.println("Q - Quit");
		System.out.print("Your choice: ");

		// Get input
		String input = in.nextLine();
		
		System.out.println();
		return input.toUpperCase().charAt(0);
	}
}
