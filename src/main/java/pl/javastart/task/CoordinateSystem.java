package pl.javastart.task;

import java.util.Scanner;

public class CoordinateSystem {

    // uzupełnij metodę. Używaj scannera przekazanego w parametrze.
    void run(Scanner scanner) {
        Point point = getPointFromUser(scanner);
        System.out.println(getPositionOfPoint(point));
    }

    private String getPositionOfPoint(Point point) {
        String result = calculateBorderlineCases(point);
        if (result == null) {
            result = "leży w " + calculateQuarter(point) + " ćwiartce układu współrzędnych.";
        }
        return prepareResultMessage(point, result);
    }

    private String prepareResultMessage(Point point, String result) {
        return "Punkt (" + point.getX() + ", " + point.getY() + ") " + result;
    }

    private String calculateBorderlineCases(Point point) {
        if (point.getX() == 0.0) {
            if (point.getY() == 0.0) {
                return "leży na środku układu współrzędnych";
            } else {
                return "leży na osi Y";
            }
        } else if (point.getY() == 0.0) {
            return "leży na osi X";
        }
        return null;
    }

    private String calculateQuarter(Point point) {
        if (point.getX() > 0.0) {
            if (point.getY() > 0.0) {
                return "I";
            } else {
                return "IV";
            }
        } else {
            if (point.getY() > 0.0) {
                return "II";
            } else {
                return "III";
            }
        }
    }

    /**
     * Wg materiału poniżej Fragment: "Znak białej linii po wczytaniu liczb" po wpisaniu przez użytkownika powinenem zastosować scanner.nextLine();,
     * ale w trakcie manualnych testów wyszło, że działa równie dobrze bez tej komendy.
     * Uruchomione na JDK 19.0.2 w intellij
     * Link: https://app.javastart.pl/kurs/java/java-podstawy-temat-14-wprowadzanie-danych/lekcja/java-podstawy-wprowadzanie-danych-z-klawiatury-new
     */
    private Point getPointFromUser(Scanner scanner) {
        System.out.println("Podaj X");
        int x = scanner.nextInt();
//        scanner.nextLine(); - jak wyżej w komentarzu
        System.out.println("Podaj Y");
        int y = scanner.nextInt();
//        scanner.nextLine(); - jak wyżej w komentarzu
        return new Point(x, y);
    }
}
