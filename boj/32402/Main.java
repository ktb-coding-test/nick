import java.util.*;
import java.io.*;

public class Main {

    static int[] player = new int[]{0, 0};
    static int[] camera = new int[]{0, -1};
    static int[] direction = new int[]{0, -1};

    static void move(int dx, int dy) {
        player[0] += dx;
        player[1] += dy;
        camera[0] += dx;
        camera[1] += dy;
    }

    static void moveFront() {
        move(-direction[0], -direction[1]);
    }
    static void moveLeft() {
        move(direction[1], -direction[0]);
    }
    static void moveBack() {
        move(direction[0], direction[1]);
    }
    static void moveRight() {
        move(-direction[1], direction[0]);
    }

    static void cameraMoveRight() {
        int newDirectionX = direction[1];
        int newDirectionY = -direction[0];
        direction[0] = newDirectionX;
        direction[1] = newDirectionY;

        camera[0] = player[0] + direction[0];
        camera[1] = player[1] + direction[1];
    }

    static void cameraMoveLeft() {
        int newDirectionX = -direction[1];
        int newDirectionY = direction[0];
        direction[0] = newDirectionX;
        direction[1] = newDirectionY;

        camera[0] = player[0] + direction[0];
        camera[1] = player[1] + direction[1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            switch (input) {
                case "W":
                    moveFront();
                    break;
                case "A":
                    moveLeft();
                    break;
                case "S":
                    moveBack();
                    break;
                case "D":
                    moveRight();
                    break;
                case "MR":
                    cameraMoveRight();
                    break;
                case "ML":
                    cameraMoveLeft();
                    break;
            }

            sb.append(player[0] + " " + player[1] + " " + camera[0] + " " + camera[1] + "\n");
        }

        System.out.println(sb.toString().trim());
    }
}