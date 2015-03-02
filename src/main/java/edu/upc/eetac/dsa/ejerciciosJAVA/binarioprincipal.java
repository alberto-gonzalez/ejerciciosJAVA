package edu.upc.eetac.dsa.ejerciciosJAVA;

import java.io.File;
import java.io.IOException;

public class binarioprincipal {

	public static void main(String[] args) throws IOException {
        atributosbinario testWrite = new atributosbinario(9, 9.5, 'A');
        testWrite.saveToFile("enterodecimalcaracter.txt");

        atributosbinario testRead = atributosbinario.readFromFile("enterodecimalcaracter.txt");
        System.out.println("integer = " + testRead.getInteger());
        System.out.println("decimal = " + testRead.getDecimal());
        System.out.println("char = " + testRead.getCharacter());

        File file = new File("enterodecimalcaracter.txt");
        file.delete();
    }
}
