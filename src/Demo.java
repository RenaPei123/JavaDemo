import java.util.ArrayList;


public class Demo {

	public static void main(String[] args) {
		System.out.println("!");
		
		Person person = new Person();
		person.setAge(20);
		person.setName("xiaoli");
		Person s = person;
		s = null;
		int a = person.getAge();
		String b = person.getname();
		System.out.println("person's name is " + b + " and person's age is " +a);
		
		ArrayList<Person> array = new ArrayList<Person>();
		ArrayList<String> ar = new ArrayList<String>();
		
		Stack stack = new Stack();
		stack.push("aaa");
		stack.push("bbb");
		stack.push("ccc");
		stack.push("ddd");
		System.out.println(stack.getSize());
		Object p = stack.pop();
		System.out.println((String)p);
		p = stack.pop();
		System.out.println((String)p);
		p = stack.pop();
		System.out.println((String)p);
		p = stack.pop();
		System.out.println((String)p);
		p = stack.pop();
		if(p!=null)
		System.out.println((String)p);
		stack.push("aaa");
		System.out.println(stack.getSize());
	}
	public static void testPointer(Person p){
		p = new Person();
		p.setName("Rena");
		p.setAge(10);
	}

}
class ObjectListElement{
	private Object o;
	private ObjectListElement next;
	public ObjectListElement(Object o){
		this.o = o;
		this.next = null;
	}
	public Object getO() {
		return o;
	}
	public void setO(Object o) {
		this.o = o;
	}
	public ObjectListElement getNext() {
		return next;
	}
	public void setNext(ObjectListElement next) {
		this.next = next;
	}
	
}
class Stack{
	
	public ObjectListElement getHead() {
		return head;
	}
	public void setHead(ObjectListElement head) {
		this.head = head;
	}
	public ObjectListElement getTrail() {
		return trail;
	}
	public void setTrail(ObjectListElement trail) {
		this.trail = trail;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	//private Object[] obs;// array implementation
	private ObjectListElement head; // pointer implementation
	private ObjectListElement trail;
	//private int capacity;
	private int size;
	
	public Stack(){
		//capacity = 10;
		//obs = new Object[capacity];
		head = null;
		trail = null;
		size = 0;
	}
	public Object pop(){
		if(size>0){
			ObjectListElement z = trail;
			ObjectListElement cur = head;
			for(int i=0;i<size-1 ;i++){
				trail = cur;
				cur = cur.getNext();
			}
			trail.setNext(null);
			size--;
			if(size == 0){
				head=null;
				trail=null;
			}
			return z.getO();
		}else{
			return null;
		}
	}
	public void push(Object o){
		ObjectListElement oe = new ObjectListElement(o);
		if(size == 0){
			head = oe;
			trail = oe;
			size++;
		}else{
			ObjectListElement z = trail;// get the last element
			z.setNext(oe);
			trail = oe;
			size++;
		}
	}
	
}
class Person{
	int age;
	String name;
	public int getAge(){
		return age;
	}
	public String getname(){
		return name;
	}
	public void setAge(int i){
		age = i;
	}
	public void setName(String i){
		name = i;
	}
}
