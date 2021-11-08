import java.util.Random;

public class CrearTablero {


	public  CrearTablero()
	{
		
	}
	
	public int[][] crearMatriz(int cantFilas, int cantColumnas, int cantMinas)
	{
		Random MatrizRandom = new Random();
		int [][] MatrizADevolver = new int[cantFilas][cantColumnas]; 
		
		for(int x = 0;x < MatrizADevolver.length; x++)
		{
			for (int y = 0; y < MatrizADevolver[0].length; y++)
			{
				 if (x >= 0 && y >= 0 && MatrizADevolver[x][y] ==0)
	                {
				MatrizADevolver[x][y] = MatrizRandom.nextInt(1);
	                }
				 
			}
		}
		int verdadOno = (cantFilas * cantColumnas)/4 ;
		if(verdadOno >= cantMinas)
		{
			generarMinas(MatrizADevolver,MatrizADevolver, cantMinas);
		}
		
		return MatrizADevolver;
	}
		public void Escribir(int[][] matriz)
		{
			int i = 0;
			while(i < matriz.length)
			{
				if(i == 0)
				{
					System.out.print("\t");
				}
				System.out.print("\t"+ i);
				i++;
			}
			System.out.println(" ");
			for(int x = 0;x < matriz.length; x++)
			{
				System.out.print("\t"+ x);
				for (int y = 0; y < matriz[0].length; y++)
				{
					
						System.out.print("\t"+ "* ");
						
					// tengo que usar otro escritura para navegar por el mapa
				}
				System.out.println(' ');
			}
		}
		
		
		public void generarMinas(int[][] matriz,int[][] MatrizADevolver, int cantMinas)
		{
			int cantidadDeMinasGeneradas =0;
			Random lugarDeLaMina =  new Random();
			Random lugarDeLaMinaDos = new Random();
			
			if(matriz.length != 0 && matriz[0].length !=0)
			{
			while (cantidadDeMinasGeneradas < cantMinas)
			{
				
				
				int numero =lugarDeLaMina.nextInt(matriz.length);
				int numerodos =lugarDeLaMinaDos.nextInt(matriz[0].length);
				
                if (numero >= 0 && numero < matriz.length &&
                		numerodos >= 0 && numerodos < matriz[0].length
                		&&matriz[numero][numerodos] !=9)
                {
                	cantidadDeMinasGeneradas++ ;
                	
                	matriz[numero][numerodos] = 9;
    				
    				GenerarNumeros(matriz,MatrizADevolver, numero,numerodos);
                }
				
		            }
			}
			MatrizADevolver = matriz;
		}
			
			
		
		
		
		public void GenerarNumeros(int[][] matriz,int[][] matrizDibujada, int fila, int columna)
		{
			
			for (int i = -1; i <=1 ; i++)
			{
	            for (int j = -1; j<=1 ; j++)
	            {
	            	int posFila = fila + i;
	                int posCol = columna + j;
	            	if (posFila >= 0 &&	posFila < matriz.length 
	                		&&	 posCol >= 0 
	                        && 
	                        posCol < matriz[0].length  && matriz[posFila][posCol] !=9 )
	            	{
	            		
	                matrizDibujada[posFila][posCol] += 1;
	            	}
	            	
	            }
			}
			

			
	        }   
		
		public int EscribirMientrasJuego(int[][] matriz,int[][] matrizDibujada, int filaSeleccionada,int columnaSeleccionada/*, boolean SioNo*/)
		{
			if(matriz[filaSeleccionada][columnaSeleccionada] ==9)
			{
				
				matrizDibujada[filaSeleccionada][columnaSeleccionada] = 9;
				return -2;
			}
			matrizDibujada[filaSeleccionada][columnaSeleccionada] =-1;
			if(filaSeleccionada >= 0 
				&& filaSeleccionada < matriz.length
				&&columnaSeleccionada >= 0
				&& columnaSeleccionada < matriz[0].length 
				&& matriz[filaSeleccionada][columnaSeleccionada] != 0)
			{
				matrizDibujada[filaSeleccionada][columnaSeleccionada] = matriz[filaSeleccionada][columnaSeleccionada];
				return matriz[filaSeleccionada][columnaSeleccionada];
			}else
			{
				for (int i = -1; i <=1 ; i++){
		            for (int j = -1; j<=1 ; j++){
		                int posFila = filaSeleccionada + i;
		                int posCol = columnaSeleccionada + j;
		               
		                if (posFila >= 0 && posFila < matriz.length &&
		                        posCol >= 0 && posCol < matriz[0].length
		                        && matriz[filaSeleccionada][columnaSeleccionada] == 0
		                        && matrizDibujada[posFila][posCol] != -1){
		                    //System.out.println((fila + i) + " " +  (columna + j));               
		                	EscribirMientrasJuego(matriz,matrizDibujada, posFila, posCol);
		                	
		                }
		            }
		        }          
				
			}
			
			return 0;
		}
		
		public int EscribirDos(int[][] matriz,int[][] matrizAux )
		{
			int contador = 0;
			
			for(int x = 0;x < matriz.length; x++)
			{
				//System.out.print(matriz.length);
				for (int y = 0; y < matriz[0].length; y++)
				{
					
						if(matrizAux[x][y] != 0 )
						{
							if(matrizAux[x][y] == -1 )
							{
								System.out.print(" " +0+ " ");
								contador++;
							}
							else
							{
								System.out.print(" " +matriz[x][y] + " ");
								contador++;
							}
						
						}
						else
						{
							System.out.print( " * ");
						}
						
					// tengo que usar otro escritura para navegar por el mapa
				}
				System.out.println(' ');
			}
			return contador;
		}
			
			
		}



