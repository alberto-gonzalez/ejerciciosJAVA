package edu.upc.eetac.dsa.ejerciciosJAVA;

public class principal {
	public static void main(String[] args) {
		String path = "C:/Users/alberto/DSA/ejerciciosJAVA";
 /*       if (args.length != 1) {
            System.err.println("Program needs the path to the file with the numbers");
            System.exit(-1);
        }
*/
        try {
            double average = MediaAritmetica.average(path);
            System.out.println("Average = " + average);
        } catch (FileParsingException e) {
            e.printStackTrace();
        } catch (BigNumberException e) {
            e.printStackTrace();
        }
    }
}
