
import java.util.Scanner;


public class BuscaMinas {

	public static void main(String[] args)
	{
		int juegaOno = -10;
	
		do
		{
		
		CrearTablero tablero = new CrearTablero();
		int minas =0;
		System.out.println("Elija la cantidad de filas");
			int filas =CrearVar1();
			System.out.println("Elija la cantidad de columnas");
			int columnas =CrearVar1();
			System.out.println("Elija la cantidad de minas");
			minas = CrearVar1();
			int matriz[][] =tablero.crearMatriz(filas, columnas, minas);
			
			tablero.Escribir(matriz);
			System.out.println("");
		int[][] matrizAux = new int[matriz.length][matriz[0].length];
		boolean VorT =Jugar(matriz, matrizAux,-1,minas);
		System.out.println("Si desea seguir jugando ponga -10, sino cualquier numero");
		Scanner numeroSeleccionadoUno = new Scanner(System.in);
		String numeroUno = numeroSeleccionadoUno.next();
		int numeroOne = Integer.parseInt(numeroUno);
		if(juegaOno != numeroOne)
		{
			juegaOno = numeroOne;
		}
		
		}while(juegaOno == -10);
		
	}
	
	public static void PedirColumna()
	{
		
	}
	
	private static int CrearVar1()
	{
		Scanner numeroSeleccionadoUno = new Scanner(System.in);
		String numeroUno = numeroSeleccionadoUno.next();
		int numeroOne = Integer.parseInt(numeroUno);

		
		return numeroOne;
	}
	
	public static boolean Jugar(int [][] matriz,int [][] matrizAux ,int numero, int minas) 
	{
		
		
		
		if(numero == -2 )
		{
			return false;
		}
		else 
			
		{
			//Primer numero
		Scanner numeroSeleccionadoUno = new Scanner(System.in);
		System.out.println("Seleccione una casilla: ");
		String numeroUno = numeroSeleccionadoUno.next();
		int numeroOne = Integer.parseInt(numeroUno);
		//Segundo numero
		System.out.println("Segundo numero: ");
		String numeroDos = numeroSeleccionadoUno.next();
		int numeroTwo = Integer.parseInt(numeroDos);
		System.out.println(" ");
		
		CrearTablero tablero = new CrearTablero();
		if(!(numeroOne > matriz.length-1 || numeroTwo > matriz[0].length-1))
		{
			numero =tablero.EscribirMientrasJuego(matriz, matrizAux,numeroOne,numeroTwo);
		}
		else
		{
			System.out.println("Elija casillas que esten dentro de la matriz");
		}
		
		int EscribirInt = tablero.EscribirDos( matrizAux, matrizAux);
		if(!(EscribirInt == ((matriz.length*matriz[0].length)- minas)))
		{
			Jugar(matriz,matrizAux,numero, minas);
		}
			
		
		}
		
		return true;
		
	}
	
	
	
	
		public static void recorrerIsla(int  mapa[][], int mapaAux[][], int fila, int columna)
		{   
			CrearTablero tablero = new CrearTablero();
	       
	        for (int i = -1; i <=1 ; i++)
	        {
	            for (int j = -1; j<=1 ; j++)
	            {
	                int posFila = fila + i;
	                int posCol = columna + j;
	               
	                if (posFila >= 0 && posFila < mapa.length &&
	                        posCol >= 0 && posCol < mapa[0].length &&
	                        mapaAux[posFila][posCol] == 0 &&
	                        mapa[posFila][posCol] == 0 && mapaAux[posFila][posCol] != 10)
	                {
	                    
	                	if( mapa[posFila][posCol] == 0)
	                	{
	                		 System.out.println("Me Llamaron" +  mapa[posFila][posCol]);
	                		mapaAux[posFila][posCol] = 10;
	                    {
	                    recorrerIsla(mapa, mapaAux, posFila, posCol);
	                }
	                    
	            }
	        } 
		}
	   }
	        tablero.Escribir(mapa);
	}
	

}
