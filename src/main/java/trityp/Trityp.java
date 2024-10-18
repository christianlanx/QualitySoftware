package trityp;

import java.util.Scanner;

public class Trityp {
    private static String[] triTypes = { "", "scalene", "isosceles", "equilateral", "not a valid triangle" };
    private static String instructions = "This is the ancient TriTyp program.\n"
            + "Enter three integers that represent the lengths of the sides of a triangle.\n"
            + "The triangle will be categorized as either scalene, isosceles, equilateral or invalid\n";

    public static void main(String[] argv) {
        int A, B, C;
        int T;

        System.out.println(instructions);
        System.out.println("Enter side 1: ");
        A = getN();
        System.out.println("Enter side 2: ");
        B = getN();
        System.out.println("Enter side 3: ");
        C = getN();
        T = Triang(A, B, C);

        System.out.println("Result is: " + triTypes[T]);
    }

    // Triangle classification method
    public static int Triang(int Side1, int Side2, int Side3) {
        int tri_out;

        if (Side1 <= 0 || Side2 <= 0 || Side3 <= 0) {
            return 4; // Invalid triangle
        }

        tri_out = 0;
        if (Side1 == Side2)
            tri_out += 1;
        if (Side1 == Side3)
            tri_out += 2;
        if (Side2 == Side3)
            tri_out += 3;

        if (tri_out == 0) { // Scalene check
            if (Side1 + Side2 <= Side3 || Side2 + Side3 <= Side1 || Side1 + Side3 <= Side2)
                return 4; // Invalid triangle
            else
                return 1; // Scalene
        }

        if (tri_out > 3)
            return 3; // Equilateral
        else if (tri_out == 1 && Side1 + Side2 > Side3)
            return 2; // Isosceles
        else if (tri_out == 2 && Side1 + Side3 > Side2)
            return 2; // Isosceles
        else if (tri_out == 3 && Side2 + Side3 > Side1)
            return 2; // Isosceles
        else
            return 4; // Invalid triangle
    }

    private static Scanner in = new Scanner(System.in);

    private static int getN() {
        return in.nextInt();
    }
}
