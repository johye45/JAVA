class UsePizza{
	
	//피자를 먹는다
	public void eat(Pizza p){
		p.slice =3;
	}
	//갯수를 조정한다
	public void setSlic(int slice){
		slice = 3;
	}

	public static void main(String[] args){
		Pizza p1 = new Pizza("피자헛");
		Pizza p2 = new Pizza("도미노");

		UsePizza up = new UsePizza();
		up.setSlice(5);//피자들과 상관이 없다
		up.setSlice(p1.slice);//피자헛에 영향이 없다
		up.eat(p2);//도미노에 영향을 줌
	}
}
