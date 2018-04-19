import java.util.Stack;
import java.util.*;

public class Hanoi{

  private static final int  MAX_ELEMENTS = 15;
  private static Scanner in = new Scanner(System.in);
  private Stack<Integer> A;
  private String line;



public Hanoi(){
     A = new Stack<>();
}

/**
* Metodo para printar mensagem na tela
*/
private void log(Object msg){
  System.out.println(msg);
}


/**
* Metodo que resolve a torre movendo todos os discos para outra
* pino
*/
private void solve(int n, int O, int T, int D){
  if (n > 0) {
			solve(n - 1, O, T, D);
			move(n ,O, D);
			solve(n - 1, T, D, O);
		}
}

/**
* Metodo que registra os movimentos
*/
private void move(int disc , int source, int destiny) {
		log("mova o disco " + disc + " do pino "+source + " para o pino "+ destiny );
}

/**
* Metodo que preenche a pilha incial com @param elements discos
* @param elements Quantidade de discos
*/
 private void fillStack(int elements){
   //Coloca cada disco na pilha deixando discos com pesos maiores no topo
   for ( int x = elements  ; x >= 1 ; x--)
      A.push(x);
    solve(elements,1,3,2);
 }

/**
* Metodo que verifca se o inteiro inserido esta dentro do intervalo permitido
* @param n Inteiro a ser verficado
*/
private void verifyInput(int n){
  if( n > 0 && n <= MAX_ELEMENTS)
     fillStack(n);
  else log("Invalid input !!! ( 0 < n <= 15)");
}

/**
* Metodo que recebe a entrada
* @param elements Linha contendo a quantidade de elementos
*/
 private  void fillInput(String  elements){
   //Tenta converter para intteiro
   try{
     verifyInput(Integer.parseInt(elements));
   }catch(Exception e ){}
 }

/**
* Metodo que le a entrada do entrada padrao
*/
 public void readInputAndSolve(){
   //Enquanto houver linhas
   while(!((line  = in.nextLine()).isEmpty())){
         fillInput(line);
   }
 }


  public static void main(String[] args){
    new Hanoi().readInputAndSolve();
  }






}
