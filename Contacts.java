
public class Contacts 
{
	private static class Node 
	{
		public String name;		// Full name of contact
		public String email;	// E-mail address of contact
		public int	age;		// Age of contact
		public Node left;
		public Node right;	
	}
	
	private Node root = null;
	
	public void add(String name, String email, int age) 
	{
		root = add(root, name, email, age);	
	}
	
	public String find(String name) 
	{
		Node node = find(root, name);
		if( node == null )
			return null;
		else
			return format(node);
	}
	
	public void print() 
	{
		print(root);
	}
		
	private static String format(Node node) 
	{
		return "\t" + node.name + " <" + node.email +  "> is " + node.age + " years old.";
	}
	
	private static Node add(Node node, String name, String email, int age) //new method gets a node, two strings, and an int and returns a node
	{
		if(node == null) //Base case: if the node is null
		{
			node = new Node(); //Create a new node
			node.name = name; //Set the name of this node to the name given
			node.email = email; //Set the email of this node to the email given
			node.age = age; //Set the age of this node to the age given
		}
		
		else if(name.compareTo(node.name) < 0) //recursive case 1: if the name given is earlier in the alphabet than the name of the current node
			node.left = add(node.left, name, email, age); //Set the node to the left equal to a recursive call moving to the left
		
		else if(name.compareTo(node.name) > 0) //recursive case 2: if the name given is later in the alphabet than the name of the current node
			node.right = add(node.right, name, email, age); //Set the node to the right equal to a recursive call moving to the right
		
		else //Recursive case 3: the name we want to add is already in the contact list
		{
			node.email = email; //update the email
			node.age = age; //update the age
		}
		
		return node; //return the node
	}
	
	private static Node find(Node node, String name) //new method that takes a node and a string and returns a Node
	{
		if(node == null || name.equals(node.name)) //Base case: if the given node is null or the name of that node is equal to the name we want to find
			return node; //return the node
		
		else if(name.compareTo(node.name) < 0) //Recursive case 1: the name we want to find comes before the name of the given node
			return find(node.left, name); //return a recursive call moving to the left
		
		else //Recursive case 2: otherwise (the name we want to find comes after the name of the given node)
			return find(node.right, name); //return a recursive call moving to the right
	}
	
	private static void print(Node node) //new method that takes a node and returns nothing (but prints)
	{
		if(node == null) //Base case: if the node given is null
			System.out.println("."); //print a dot (null)
		
		else //recursive case
		{
			print(node.left); //recursively call print moving down the left subtree
			System.out.println(format(node)); //print out the node (formatted)
			print(node.right); //recursively call print moving down the right subtree
			
		}
	}
}
